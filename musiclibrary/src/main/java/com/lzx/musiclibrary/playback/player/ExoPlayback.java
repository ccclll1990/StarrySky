package com.lzx.musiclibrary.playback.player;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.danikula.videocache.HttpProxyCacheServer;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.ext.rtmp.RtmpDataSourceFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.source.dash.DefaultDashChunkSource;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.source.smoothstreaming.DefaultSsChunkSource;
import com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.google.android.exoplayer2.upstream.FileDataSourceFactory;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.upstream.cache.CacheDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.lzx.musiclibrary.MusicService;
import com.lzx.musiclibrary.aidl.model.SongInfo;
import com.lzx.musiclibrary.cache.CacheConfig;
import com.lzx.musiclibrary.cache.CacheUtils;
import com.lzx.musiclibrary.constans.State;
import com.lzx.musiclibrary.manager.FocusAndLockManager;
import com.lzx.musiclibrary.utils.BaseUtil;
import com.lzx.musiclibrary.utils.LogUtil;
import com.lzx.musiclibrary.utils.SPUtils;

import static com.google.android.exoplayer2.C.CONTENT_TYPE_MUSIC;
import static com.google.android.exoplayer2.C.USAGE_MEDIA;
import static com.lzx.musiclibrary.constans.Constans.play_back_pitch;
import static com.lzx.musiclibrary.constans.Constans.play_back_speed;
import static com.lzx.musiclibrary.manager.FocusAndLockManager.AUDIO_NO_FOCUS_CAN_DUCK;
import static com.lzx.musiclibrary.manager.FocusAndLockManager.AUDIO_NO_FOCUS_NO_DUCK;
import static com.lzx.musiclibrary.manager.FocusAndLockManager.VOLUME_DUCK;
import static com.lzx.musiclibrary.manager.FocusAndLockManager.VOLUME_NORMAL;

/**
 * Created by xian on 2018/1/20.
 */

public class ExoPlayback implements Playback, FocusAndLockManager.AudioFocusChangeListener {

    private boolean isOpenCacheWhenPlaying = false;
    private boolean mPlayOnFocusGain;
    private boolean mAudioNoisyReceiverRegistered;
    private String mCurrentMediaId; //?????????????????????id
    private SongInfo mCurrentMediaSongInfo;

    private SimpleExoPlayer mExoPlayer;
    private final ExoPlayerEventListener mEventListener = new ExoPlayerEventListener();
    private boolean mExoPlayerNullIsStopped = false;
    private boolean isGiveUpAudioFocusManager = false;
    private FocusAndLockManager mFocusAndLockManager;

    private Callback mCallback;
    private Context mContext;
    private DataSource.Factory dataSourceFactory;

    private HttpProxyCacheServer mProxyCacheServer;
    private HttpProxyCacheServer.Builder builder;
    private long mErrorProgress = 0;
    private boolean isStateError = false;

    public ExoPlayback(Context context, CacheConfig cacheConfig, boolean isGiveUpAudioFocusManager) {
        this.mContext = context;
        this.isGiveUpAudioFocusManager = isGiveUpAudioFocusManager;
        mFocusAndLockManager = new FocusAndLockManager(context, this);
        dataSourceFactory = ExoPlayerHelper.getInstance().buildDataSourceFactory();

        builder = CacheUtils.createHttpProxyCacheServerBuilder(mContext, cacheConfig);
        if (cacheConfig != null && cacheConfig.isOpenCacheWhenPlaying()) {
            isOpenCacheWhenPlaying = true;
        }
        mProxyCacheServer = builder.build();
    }

    private final IntentFilter mAudioNoisyIntentFilter = new IntentFilter(AudioManager.ACTION_AUDIO_BECOMING_NOISY);

    private final BroadcastReceiver mAudioNoisyReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (AudioManager.ACTION_AUDIO_BECOMING_NOISY.equals(intent.getAction())) {
                if (isPlaying()) {
                    Intent i = new Intent(context, MusicService.class);
                    mContext.startService(i);
                }
            }
        }
    };

    /**
     * ?????????????????????????????????????????????????????????WiFi?????????????????? ???????????????ExoPlayer?????????????????????
     *
     * @param releasePlayer ???????????????????????????????????????
     */
    private void releaseResources(boolean releasePlayer, boolean isResetPlayer) {
        if (releasePlayer && mExoPlayer != null) {
            mExoPlayer.release();
            mExoPlayer.removeListener(mEventListener);
            if (!isResetPlayer) {
                mExoPlayerNullIsStopped = true;
            }
            mPlayOnFocusGain = false;
            mExoPlayer = null;
        }
        mFocusAndLockManager.releaseWifiLock();
    }

    @Override
    public void start() {

    }

    @Override
    public void stop(boolean notifyListeners, boolean isResetPlayer) {
        mFocusAndLockManager.giveUpAudioFocus();
        unregisterAudioNoisyReceiver();
        releaseResources(true, isResetPlayer);
    }

    @Override
    public void setState(int state) {

    }

    @Override
    public int getState() {
        //STATE_IDLE      ???????????????????????????
        //STATE_BUFFERING ???????????????????????????????????????
        //STATE_READY ????  ?????????????????????????????????????????? ??????  {@link #getPlayWhenReady??????}???true?????????????????????????????????
        //STATE_ENDED ????  ???????????????????????????
        LogUtil.i("thread = " + Thread.currentThread());
        int state = State.STATE_IDLE;
        if (isStateError) {
            state = State.STATE_ERROR;
        } else {
            if (mExoPlayer == null) {
                state = mExoPlayerNullIsStopped ? State.STATE_STOP : State.STATE_IDLE;
            } else {
                switch (mExoPlayer.getPlaybackState()) {
                    case Player.STATE_IDLE:
                    case Player.STATE_ENDED:
                        state = State.STATE_IDLE;
                        break;
                    case Player.STATE_BUFFERING:
                        state = State.STATE_ASYNC_LOADING;
                        break;
                    case Player.STATE_READY:
                        state = mExoPlayer.getPlayWhenReady() ? State.STATE_PLAYING : State.STATE_PAUSED;
                        break;
                }
            }
        }
        return state;
    }

    @Override
    public boolean isConnected() {
        return true;
    }

    @Override
    public boolean isPlaying() {
        return mPlayOnFocusGain || (mExoPlayer != null && mExoPlayer.getPlayWhenReady());
    }

    @Override
    public long getCurrentStreamPosition() {
        return mExoPlayer != null ? mExoPlayer.getCurrentPosition() : 0;
    }

    @Override
    public long getBufferedPosition() {
        long bufferedPosition = mExoPlayer != null ? mExoPlayer.getBufferedPosition() : 0;
        long duration = mExoPlayer != null ? mExoPlayer.getDuration() : 0;
        bufferedPosition = bufferedPosition * 2;
        if (bufferedPosition > duration) {
            bufferedPosition = duration;
        }
        if (isOpenCacheWhenPlaying && mCurrentMediaSongInfo != null) {
            boolean fullyCached = mProxyCacheServer.isCached(mCurrentMediaSongInfo.getSongUrl());
            return fullyCached ? duration : bufferedPosition;
        } else {
            return bufferedPosition;
        }
    }

    @Override
    public void updateLastKnownStreamPosition() {

    }

    @Override
    public void play(SongInfo info) {
        mPlayOnFocusGain = true;
        mFocusAndLockManager.tryToGetAudioFocus();
        registerAudioNoisyReceiver();
        String mediaId = info.getSongId();
        boolean mediaHasChanged = !TextUtils.equals(mediaId, mCurrentMediaId);
        if (mediaHasChanged) {
            mCurrentMediaId = mediaId;
            mCurrentMediaSongInfo = info;
        }
        if (mediaHasChanged || mExoPlayer == null) {
            releaseResources(false, false); // release everything except the player

            String source = info.getSongUrl();
            if (source != null && BaseUtil.isOnLineSource(source)) {
                source = source.replaceAll(" ", "%20"); // Escape spaces for URLs
            }
            if (TextUtils.isEmpty(source)) {
                if (mCallback != null) {
                    mCallback.onError("song url is null");
                }
                return;
            }

            Uri playUri;
            if (BaseUtil.isOnLineSource(source)) {
                String proxyUrl;
                if (isOpenCacheWhenPlaying && (ExoPlayerHelper.getInstance().getMediaType(null, Uri.parse(source)) == C.TYPE_OTHER)) {
                    boolean isRtmpSource = source.toLowerCase().startsWith("rtmp://");
                    proxyUrl = isRtmpSource ? source : mProxyCacheServer.getProxyUrl(source);
                } else {
                    proxyUrl = source;
                }
                playUri = Uri.parse(proxyUrl);

            } else {
                playUri = BaseUtil.getLocalSourceUri(source);
            }
            if (playUri == null) {
                if (mCallback != null) {
                    mCallback.onError("song uri is null");
                }
                return;
            }

            //LogUtil.i("isOpenCacheWhenPlaying = " + isOpenCacheWhenPlaying + " playUri = " + playUri.toString());

            if (mExoPlayer == null) {
                mExoPlayer = ExoPlayerFactory.newSimpleInstance(mContext, new DefaultRenderersFactory(mContext),
                        new DefaultTrackSelector(), new DefaultLoadControl());
                mExoPlayer.addListener(mEventListener);
                changePlaybackParameters();
            }

            final AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setContentType(CONTENT_TYPE_MUSIC)
                    .setUsage(USAGE_MEDIA)
                    .build();
            mExoPlayer.setAudioAttributes(audioAttributes);

            MediaSource mediaSource = ExoPlayerHelper.getInstance().buildMediaSource(dataSourceFactory, playUri, null);
            mExoPlayer.prepare(mediaSource);
            mFocusAndLockManager.acquireWifiLock();
        }
        configurePlayerState();
    }

    private void changePlaybackParameters() {
        float spSpeed = (float) SPUtils.get(mContext, play_back_speed, 1f);
        float spPitch = (float) SPUtils.get(mContext, play_back_pitch, 1f);
        float currSpeed = mExoPlayer.getPlaybackParameters().speed;
        float currPitch = mExoPlayer.getPlaybackParameters().pitch;
        if (spSpeed != currSpeed || spPitch != currPitch) {
            setPlaybackParameters(spSpeed, spPitch);
        }
    }

    @Override
    public void pause() {
        if (mExoPlayer != null) {
            mExoPlayer.setPlayWhenReady(false);
        }
        releaseResources(false, false);
        unregisterAudioNoisyReceiver();
    }

    @Override
    public void seekTo(long position) {
        if (mExoPlayer != null) {
            registerAudioNoisyReceiver();
            mExoPlayer.seekTo(position);
        } else {
            if (mCurrentMediaSongInfo != null) {
                play(mCurrentMediaSongInfo);
                mExoPlayer.seekTo(position);
            }
        }
    }

    @Override
    public void setCurrentMediaId(String mediaId) {
        this.mCurrentMediaId = mediaId;
    }

    @Override
    public String getCurrentMediaId() {
        return mCurrentMediaId;
    }

    @Override
    public int getDuration() {
        return mExoPlayer != null ? (int) mExoPlayer.getDuration() : 0;
    }

    @Override
    public void setErrorProgress(int errorProgress) {
        mErrorProgress = errorProgress;
    }

    @Override
    public SongInfo getCurrentMediaSongInfo() {
        return mCurrentMediaSongInfo;
    }

    @Override
    public void openCacheWhenPlaying(boolean isOpen) {
        isOpenCacheWhenPlaying = isOpen;
    }

    @Override
    public void setPlaybackParameters(float speed, float pitch) {
        if (mExoPlayer != null) {
            mExoPlayer.setPlaybackParameters(new PlaybackParameters(speed, pitch));
        }
    }

    @Override
    public void setVolume(float audioVolume) {
        if (mExoPlayer != null) {
            mExoPlayer.setVolume(audioVolume);
        }
    }

    @Override
    public int getAudioSessionId() {
        if (mExoPlayer != null) {
            return mExoPlayer.getAudioSessionId();
        }
        return 0;
    }

    @Override
    public float getPlaybackSpeed() {
        if (mExoPlayer != null) {
            return mExoPlayer.getPlaybackParameters().speed;
        } else {
            return (float) SPUtils.get(mContext, play_back_speed, 1f);
        }
    }

    @Override
    public float getPlaybackPitch() {
        if (mExoPlayer != null) {
            return mExoPlayer.getPlaybackParameters().pitch;
        } else {
            return (float) SPUtils.get(mContext, play_back_pitch, 1f);
        }
    }

    @Override
    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    /**
     * ??????????????????????????????????????????????????????/??????????????? ????????????
     * ??????/????????????ExoPlayer????????????????????????????????????????????? ?????????????????????
     * ???????????????????????????; ?????????????????????????????????????????????
     * ??????????????????????????????????????????????????????????????????????????????
     * ?????????????????
     */
    private void configurePlayerState() {
        if (mFocusAndLockManager.getCurrentAudioFocusState() == AUDIO_NO_FOCUS_NO_DUCK) {
            if (!isGiveUpAudioFocusManager) {
                pause();
            }
        } else {
            registerAudioNoisyReceiver();
            if (mFocusAndLockManager.getCurrentAudioFocusState() == AUDIO_NO_FOCUS_CAN_DUCK) {
                mExoPlayer.setVolume(VOLUME_DUCK);
            } else {
                mExoPlayer.setVolume(VOLUME_NORMAL);
            }
            if (mPlayOnFocusGain) {
                mExoPlayer.setPlayWhenReady(true);
                mPlayOnFocusGain = false;
            }
            if (mExoPlayerNullIsStopped) {
                mExoPlayerNullIsStopped = false;
            }
            if (mErrorProgress != 0) {
                seekTo(mErrorProgress);
                mErrorProgress = 0;
            }
        }
    }

    private void registerAudioNoisyReceiver() {
        if (!mAudioNoisyReceiverRegistered) {
            mContext.registerReceiver(mAudioNoisyReceiver, mAudioNoisyIntentFilter);
            mAudioNoisyReceiverRegistered = true;
        }
    }

    private void unregisterAudioNoisyReceiver() {
        if (mAudioNoisyReceiverRegistered) {
            mContext.unregisterReceiver(mAudioNoisyReceiver);
            mAudioNoisyReceiverRegistered = false;
        }
    }

    @Override
    public void onAudioFocusLossTransient() {
        mPlayOnFocusGain = mExoPlayer != null && mExoPlayer.getPlayWhenReady();
    }

    @Override
    public void onAudioFocusChange() {
        if (mExoPlayer != null) {
            configurePlayerState();
        }
    }


    /**
     * ExoPlayer???????????????
     */
    private final class ExoPlayerEventListener implements Player.EventListener {


        @Override
        public void onTimelineChanged(Timeline timeline, Object manifest, int reason) {

        }

        @Override
        public void onTracksChanged(TrackGroupArray trackGroups, TrackSelectionArray trackSelections) {

        }

        @Override
        public void onLoadingChanged(boolean isLoading) {

        }

        @Override
        public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
            isStateError = false;
            if (mCallback != null) {
                switch (playbackState) {
                    case Player.STATE_IDLE:
                        mCallback.onPlaybackStatusChanged(State.STATE_IDLE);
                        break;
                    case Player.STATE_BUFFERING:
                        mCallback.onPlaybackStatusChanged(State.STATE_ASYNC_LOADING);
                        break;
                    case Player.STATE_READY:
                        mCallback.onPlaybackStatusChanged(playWhenReady ? State.STATE_PLAYING : State.STATE_PAUSED);
                        break;
                    case Player.STATE_ENDED:
                        mCallback.onPlayCompletion(mCurrentMediaSongInfo);
                        // mCallback.onPlaybackStatusChanged(State.STATE_ENDED);
                        break;
                }
            }
        }

        @Override
        public void onRepeatModeChanged(int repeatMode) {

        }

        @Override
        public void onShuffleModeEnabledChanged(boolean shuffleModeEnabled) {

        }

        @Override
        public void onPlayerError(ExoPlaybackException error) {
            mCurrentMediaId = "";
            mErrorProgress = getCurrentStreamPosition();
            isStateError = true;
            final String what;
            switch (error.type) {
                case ExoPlaybackException.TYPE_SOURCE:
                    what = error.getSourceException().getMessage();
                    break;
                case ExoPlaybackException.TYPE_RENDERER:
                    what = error.getRendererException().getMessage();
                    break;
                case ExoPlaybackException.TYPE_UNEXPECTED:
                    what = error.getUnexpectedException().getMessage();
                    break;
                default:
                    what = "Unknown: " + error;
            }
            if (mCallback != null) {
                mCallback.onError("ExoPlayer error " + what);
            }
        }

        @Override
        public void onPositionDiscontinuity(int reason) {

        }


        @Override
        public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {

        }

        @Override
        public void onSeekProcessed() {

        }
    }


}
