/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: F:\\NiceMusic\\musiclibrary\\src\\main\\aidl\\com\\lzx\\musiclibrary\\aidl\\listener\\IPlayControl.aidl
 */
package com.lzx.musiclibrary.aidl.source;

import android.os.RemoteException;

import com.lzx.musiclibrary.aidl.model.SongInfo;
import com.lzx.musiclibrary.notification.NotificationCreater;

import java.util.List;

public interface IPlayControl extends android.os.IInterface {
    /**
     * Local-side IPC implementation stub class.
     */
    public static abstract class Stub extends android.os.Binder implements IPlayControl {
        private static final java.lang.String DESCRIPTOR = "IPlayControl";

        /**
         * Construct the stub at attach it to the interface.
         */
        public Stub() {
            this.attachInterface(this, DESCRIPTOR);
        }

        /**
         * Cast an IBinder object into an IPlayControl interface,
         * generating a proxy if needed.
         *
         * @param obj
         * @return IPlayControl
         */
        public static IPlayControl asInterface(android.os.IBinder obj) {
            if ((obj == null)) {
                return null;
            }
            android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (((iin != null) && (iin instanceof IPlayControl))) {
                return ((IPlayControl) iin);
            }
            return new IPlayControl.Stub.Proxy(obj);
        }

        @Override
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override
        public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException {
            switch (code) {
                case INTERFACE_TRANSACTION: {
                    reply.writeString(DESCRIPTOR);
                    return true;
                }
                case TRANSACTION_playMusic: {
                    data.enforceInterface(DESCRIPTOR);
                    List<SongInfo> _arg0;
                    _arg0 = data.createTypedArrayList(SongInfo.CREATOR);
                    int _arg1;
                    _arg1 = data.readInt();
                    boolean _arg2;
                    _arg2 = (0 != data.readInt());
                    this.playMusic(_arg0, _arg1, _arg2);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_playMusicByInfo: {
                    data.enforceInterface(DESCRIPTOR);
                    SongInfo _arg0;
                    if ((0 != data.readInt())) {
                        _arg0 = SongInfo.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    boolean _arg1;
                    _arg1 = (0 != data.readInt());
                    this.playMusicByInfo(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_playMusicByIndex: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    boolean _arg1;
                    _arg1 = (0 != data.readInt());
                    this.playMusicByIndex(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_pausePlayInMillis: {
                    data.enforceInterface(DESCRIPTOR);
                    long _arg0;
                    _arg0 = data.readLong();
                    this.pausePlayInMillis(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_getCurrPlayingIndex: {
                    data.enforceInterface(DESCRIPTOR);
                    int _result = this.getCurrPlayingIndex();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case TRANSACTION_pauseMusic: {
                    data.enforceInterface(DESCRIPTOR);
                    this.pauseMusic();
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_resumeMusic: {
                    data.enforceInterface(DESCRIPTOR);
                    this.resumeMusic();
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_stopMusic: {
                    data.enforceInterface(DESCRIPTOR);
                    this.stopMusic();
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setPlayList: {
                    data.enforceInterface(DESCRIPTOR);
                    List<SongInfo> _arg0;
                    _arg0 = data.createTypedArrayList(SongInfo.CREATOR);
                    this.setPlayList(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setPlayListWithIndex: {
                    data.enforceInterface(DESCRIPTOR);
                    List<SongInfo> _arg0;
                    _arg0 = data.createTypedArrayList(SongInfo.CREATOR);
                    int _arg1;
                    _arg1 = data.readInt();
                    this.setPlayListWithIndex(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_getPlayList: {
                    data.enforceInterface(DESCRIPTOR);
                    List<SongInfo> _result = this.getPlayList();
                    reply.writeNoException();
                    reply.writeTypedList(_result);
                    return true;
                }
                case TRANSACTION_deleteSongInfoOnPlayList: {
                    data.enforceInterface(DESCRIPTOR);
                    SongInfo _arg0;
                    if ((0 != data.readInt())) {
                        _arg0 = SongInfo.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    boolean _arg1;
                    _arg1 = (0 != data.readInt());
                    this.deleteSongInfoOnPlayList(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_getStatus: {
                    data.enforceInterface(DESCRIPTOR);
                    int _result = this.getStatus();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case TRANSACTION_getDuration: {
                    data.enforceInterface(DESCRIPTOR);
                    int _result = this.getDuration();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case TRANSACTION_playNext: {
                    data.enforceInterface(DESCRIPTOR);
                    this.playNext();
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_playPre: {
                    data.enforceInterface(DESCRIPTOR);
                    this.playPre();
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_hasPre: {
                    data.enforceInterface(DESCRIPTOR);
                    boolean _result = this.hasPre();
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    return true;
                }
                case TRANSACTION_hasNext: {
                    data.enforceInterface(DESCRIPTOR);
                    boolean _result = this.hasNext();
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    return true;
                }
                case TRANSACTION_getPreMusic: {
                    data.enforceInterface(DESCRIPTOR);
                    SongInfo _result = this.getPreMusic();
                    reply.writeNoException();
                    if ((_result != null)) {
                        reply.writeInt(1);
                        _result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                }
                case TRANSACTION_getNextMusic: {
                    data.enforceInterface(DESCRIPTOR);
                    SongInfo _result = this.getNextMusic();
                    reply.writeNoException();
                    if ((_result != null)) {
                        reply.writeInt(1);
                        _result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                }
                case TRANSACTION_getCurrPlayingMusic: {
                    data.enforceInterface(DESCRIPTOR);
                    SongInfo _result = this.getCurrPlayingMusic();
                    reply.writeNoException();
                    if ((_result != null)) {
                        reply.writeInt(1);
                        _result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                }
                case TRANSACTION_setCurrMusic: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    this.setCurrMusic(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setPlayMode: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    this.setPlayMode(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_getPlayMode: {
                    data.enforceInterface(DESCRIPTOR);
                    int _result = this.getPlayMode();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case TRANSACTION_getProgress: {
                    data.enforceInterface(DESCRIPTOR);
                    long _result = this.getProgress();
                    reply.writeNoException();
                    reply.writeLong(_result);
                    return true;
                }
                case TRANSACTION_seekTo: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    this.seekTo(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_reset: {
                    data.enforceInterface(DESCRIPTOR);
                    this.reset();
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_openCacheWhenPlaying: {
                    data.enforceInterface(DESCRIPTOR);
                    boolean _arg0;
                    _arg0 = (0 != data.readInt());
                    this.openCacheWhenPlaying(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_stopNotification: {
                    data.enforceInterface(DESCRIPTOR);
                    this.reset();
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setPlaybackParameters: {
                    data.enforceInterface(DESCRIPTOR);
                    float _arg0;
                    _arg0 = data.readFloat();
                    float _arg1;
                    _arg1 = data.readFloat();
                    this.setPlaybackParameters(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_getBufferedPosition: {
                    data.enforceInterface(DESCRIPTOR);
                    long _result = this.getBufferedPosition();
                    reply.writeNoException();
                    reply.writeLong(_result);
                    return true;
                }
                case TRANSACTION_setVolume: {
                    data.enforceInterface(DESCRIPTOR);
                    float _arg0;
                    _arg0 = data.readFloat();
                    this.setVolume(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_updateNotificationCreater: {
                    data.enforceInterface(DESCRIPTOR);
                    NotificationCreater _arg0;
                    if ((0 != data.readInt())) {
                        _arg0 = NotificationCreater.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    this.updateNotificationCreater(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_updateNotificationFavorite: {
                    data.enforceInterface(DESCRIPTOR);
                    boolean _arg0;
                    _arg0 = (0 != data.readInt());
                    this.updateNotificationFavorite(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_updateNotificationLyrics: {
                    data.enforceInterface(DESCRIPTOR);
                    boolean _arg0;
                    _arg0 = (0 != data.readInt());
                    this.updateNotificationLyrics(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_updateNotificationContentIntent: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.Bundle _arg0;
                    if ((0 != data.readInt())) {
                        _arg0 = android.os.Bundle.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    java.lang.String _arg1;
                    _arg1 = data.readString();
                    this.updateNotificationContentIntent(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_registerPlayerEventListener: {
                    data.enforceInterface(DESCRIPTOR);
                    IOnPlayerEventListener _arg0;
                    _arg0 = IOnPlayerEventListener.Stub.asInterface(data.readStrongBinder());
                    this.registerPlayerEventListener(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_unregisterPlayerEventListener: {
                    data.enforceInterface(DESCRIPTOR);
                    IOnPlayerEventListener _arg0;
                    _arg0 = IOnPlayerEventListener.Stub.asInterface(data.readStrongBinder());
                    this.unregisterPlayerEventListener(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_registerTimerTaskListener: {
                    data.enforceInterface(DESCRIPTOR);
                    IOnTimerTaskListener _arg0;
                    _arg0 = IOnTimerTaskListener.Stub.asInterface(data.readStrongBinder());
                    this.registerTimerTaskListener(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_unregisterTimerTaskListener: {
                    data.enforceInterface(DESCRIPTOR);
                    IOnTimerTaskListener _arg0;
                    _arg0 = IOnTimerTaskListener.Stub.asInterface(data.readStrongBinder());
                    this.unregisterTimerTaskListener(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_getAudioSessionId: {
                    data.enforceInterface(DESCRIPTOR);
                    int _result = this.getAudioSessionId();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case TRANSACTION_getPlaybackSpeed: {
                    data.enforceInterface(DESCRIPTOR);
                    float _result = this.getPlaybackSpeed();
                    reply.writeNoException();
                    reply.writeFloat(_result);
                    return true;
                }
                case TRANSACTION_getPlaybackPitch: {
                    data.enforceInterface(DESCRIPTOR);
                    float _result = this.getPlaybackPitch();
                    reply.writeNoException();
                    reply.writeFloat(_result);
                    return true;
                }
            }
            return super.onTransact(code, data, reply, flags);
        }

        private static class Proxy implements IPlayControl {
            private android.os.IBinder mRemote;

            Proxy(android.os.IBinder remote) {
                mRemote = remote;
            }

            @Override
            public android.os.IBinder asBinder() {
                return mRemote;
            }

            public java.lang.String getInterfaceDescriptor() {
                return DESCRIPTOR;
            }

            /**
             * ??????????????????????????????
             *
             * @param list
             * @param index
             * @param isJustPlay
             */
            @Override
            public void playMusic(List<SongInfo> list, int index, boolean isJustPlay) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeTypedList(list);
                    _data.writeInt(index);
                    _data.writeInt(((isJustPlay) ? (1) : (0)));
                    mRemote.transact(Stub.TRANSACTION_playMusic, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /**
             * ????????????????????????
             *
             * @param info
             * @param isJustPlay
             */
            @Override
            public void playMusicByInfo(SongInfo info, boolean isJustPlay) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    if ((info != null)) {
                        _data.writeInt(1);
                        info.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(((isJustPlay) ? (1) : (0)));
                    mRemote.transact(Stub.TRANSACTION_playMusicByInfo, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /**
             * ??????????????????
             *
             * @param index
             * @param isJustPlay
             */
            @Override
            public void playMusicByIndex(int index, boolean isJustPlay) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(index);
                    _data.writeInt(((isJustPlay) ? (1) : (0)));
                    mRemote.transact(Stub.TRANSACTION_playMusicByIndex, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /**
             * ??????????????????
             *
             * @param time
             */
            @Override
            public void pausePlayInMillis(long time) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeLong(time);
                    mRemote.transact(Stub.TRANSACTION_pausePlayInMillis, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /**
             * ????????????????????????
             *
             * @return index
             */
            @Override
            public int getCurrPlayingIndex() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_getCurrPlayingIndex, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * ??????
             */
            @Override
            public void pauseMusic() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_pauseMusic, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /**
             * ??????
             */
            @Override
            public void resumeMusic() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_resumeMusic, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /**
             * ????????????
             */
            @Override
            public void stopMusic() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_stopMusic, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /**
             * ??????????????????
             *
             * @param list
             */
            @Override
            public void setPlayList(List<SongInfo> list) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeTypedList(list);
                    mRemote.transact(Stub.TRANSACTION_setPlayList, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /**
             * ??????????????????
             *
             * @param list
             * @param index
             */
            @Override
            public void setPlayListWithIndex(List<SongInfo> list, int index) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeTypedList(list);
                    _data.writeInt(index);
                    mRemote.transact(Stub.TRANSACTION_setPlayListWithIndex, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /**
             * ??????????????????
             *
             * @return list
             */
            @Override
            public List<SongInfo> getPlayList() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                List<SongInfo> _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_getPlayList, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.createTypedArrayList(SongInfo.CREATOR);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * ????????????????????????????????????
             *
             * @param info
             * @param isNeedToPlayNext
             */
            @Override
            public void deleteSongInfoOnPlayList(SongInfo info, boolean isNeedToPlayNext) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    if ((info != null)) {
                        _data.writeInt(1);
                        info.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(((isNeedToPlayNext) ? (1) : (0)));
                    mRemote.transact(Stub.TRANSACTION_deleteSongInfoOnPlayList, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /**
             * ??????????????????
             *
             * @return int
             */
            @Override
            public int getStatus() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_getStatus, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * ??????????????????
             *
             * @return int
             */
            @Override
            public int getDuration() throws RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_getDuration, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * ???????????????
             */
            @Override
            public void playNext() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_playNext, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /**
             * ???????????????
             */
            @Override
            public void playPre() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_playPre, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /**
             * ??????????????????
             *
             * @return boolean
             */
            @Override
            public boolean hasPre() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_hasPre, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * ??????????????????
             *
             * @return boolean
             */
            @Override
            public boolean hasNext() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_hasNext, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * ?????????????????????
             *
             * @return info
             */
            @Override
            public SongInfo getPreMusic() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                SongInfo _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_getPreMusic, _data, _reply, 0);
                    _reply.readException();
                    if ((0 != _reply.readInt())) {
                        _result = SongInfo.CREATOR.createFromParcel(_reply);
                    } else {
                        _result = null;
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * ?????????????????????
             *
             * @return info
             */
            @Override
            public SongInfo getNextMusic() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                SongInfo _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_getNextMusic, _data, _reply, 0);
                    _reply.readException();
                    if ((0 != _reply.readInt())) {
                        _result = SongInfo.CREATOR.createFromParcel(_reply);
                    } else {
                        _result = null;
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * ????????????????????????
             *
             * @return info
             */
            @Override
            public SongInfo getCurrPlayingMusic() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                SongInfo _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_getCurrPlayingMusic, _data, _reply, 0);
                    _reply.readException();
                    if ((0 != _reply.readInt())) {
                        _result = SongInfo.CREATOR.createFromParcel(_reply);
                    } else {
                        _result = null;
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * ????????????????????????
             *
             * @param index
             */
            @Override
            public void setCurrMusic(int index) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(index);
                    mRemote.transact(Stub.TRANSACTION_setCurrMusic, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /**
             * ??????????????????
             *
             * @param mode
             */
            @Override
            public void setPlayMode(int mode) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(mode);
                    mRemote.transact(Stub.TRANSACTION_setPlayMode, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /**
             * ??????????????????
             *
             * @return int
             */
            @Override
            public int getPlayMode() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_getPlayMode, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * ??????????????????
             *
             * @return long
             */
            @Override
            public long getProgress() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                long _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_getProgress, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readLong();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * ?????????????????????
             *
             * @param position
             */
            @Override
            public void seekTo(int position) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(position);
                    mRemote.transact(Stub.TRANSACTION_seekTo, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /**
             * ?????????
             */
            @Override
            public void reset() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_reset, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /**
             * ????????????????????????
             *
             * @param isOpen
             */
            @Override
            public void openCacheWhenPlaying(boolean isOpen) throws RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(((isOpen) ? (1) : (0)));
                    mRemote.transact(Stub.TRANSACTION_openCacheWhenPlaying, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /**
             * ???????????????
             */
            @Override
            public void stopNotification() throws RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_stopNotification, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /**
             * ??????
             *
             * @param speed
             * @param pitch
             */
            @Override
            public void setPlaybackParameters(float speed, float pitch) throws RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeFloat(speed);
                    _data.writeFloat(pitch);
                    mRemote.transact(Stub.TRANSACTION_setPlaybackParameters, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public long getBufferedPosition() throws RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                long _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_getBufferedPosition, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readLong();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * ????????????
             *
             * @param audioVolume
             */
            @Override
            public void setVolume(float audioVolume) throws RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeFloat(audioVolume);
                    mRemote.transact(Stub.TRANSACTION_setVolume, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /**
             * ???????????????
             *
             * @param creater
             */
            @Override
            public void updateNotificationCreater(NotificationCreater creater) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    if ((creater != null)) {
                        _data.writeInt(1);
                        creater.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    mRemote.transact(Stub.TRANSACTION_updateNotificationCreater, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /**
             * ?????????????????????/????????????????????????
             *
             * @param isFavorite
             */
            @Override
            public void updateNotificationFavorite(boolean isFavorite) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(((isFavorite) ? (1) : (0)));
                    mRemote.transact(Stub.TRANSACTION_updateNotificationFavorite, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /**
             * ?????????????????????????????????????????????
             *
             * @param isChecked
             */
            @Override
            public void updateNotificationLyrics(boolean isChecked) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(((isChecked) ? (1) : (0)));
                    mRemote.transact(Stub.TRANSACTION_updateNotificationLyrics, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /**
             * ???????????????ContentIntent
             *
             * @param bundle
             * @param targetClass
             */
            @Override
            public void updateNotificationContentIntent(android.os.Bundle bundle, java.lang.String targetClass) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    if ((bundle != null)) {
                        _data.writeInt(1);
                        bundle.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeString(targetClass);
                    mRemote.transact(Stub.TRANSACTION_updateNotificationContentIntent, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /**
             * ?????????????????????????????????
             *
             * @param listener
             */
            @Override
            public void registerPlayerEventListener(IOnPlayerEventListener listener) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((listener != null)) ? (listener.asBinder()) : (null)));
                    mRemote.transact(Stub.TRANSACTION_registerPlayerEventListener, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /**
             * ????????????????????????????????????
             *
             * @param listener
             */
            @Override
            public void unregisterPlayerEventListener(IOnPlayerEventListener listener) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((listener != null)) ? (listener.asBinder()) : (null)));
                    mRemote.transact(Stub.TRANSACTION_unregisterPlayerEventListener, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /**
             * ?????????????????????????????????
             *
             * @param listener
             */
            @Override
            public void registerTimerTaskListener(IOnTimerTaskListener listener) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((listener != null)) ? (listener.asBinder()) : (null)));
                    mRemote.transact(Stub.TRANSACTION_registerTimerTaskListener, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /**
             * ????????????????????????????????????
             *
             * @param listener
             */
            @Override
            public void unregisterTimerTaskListener(IOnTimerTaskListener listener) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((listener != null)) ? (listener.asBinder()) : (null)));
                    mRemote.transact(Stub.TRANSACTION_unregisterTimerTaskListener, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public int getAudioSessionId() throws RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_getAudioSessionId, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public float getPlaybackSpeed() throws RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                float _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_getPlaybackSpeed, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readFloat();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public float getPlaybackPitch() throws RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                float _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_getPlaybackPitch, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readFloat();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }


        }

        static final int TRANSACTION_playMusic = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
        static final int TRANSACTION_playMusicByInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
        static final int TRANSACTION_playMusicByIndex = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
        static final int TRANSACTION_pausePlayInMillis = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
        static final int TRANSACTION_getCurrPlayingIndex = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
        static final int TRANSACTION_pauseMusic = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
        static final int TRANSACTION_resumeMusic = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
        static final int TRANSACTION_stopMusic = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
        static final int TRANSACTION_setPlayList = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
        static final int TRANSACTION_setPlayListWithIndex = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
        static final int TRANSACTION_getPlayList = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
        static final int TRANSACTION_deleteSongInfoOnPlayList = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
        static final int TRANSACTION_getStatus = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
        static final int TRANSACTION_getDuration = (android.os.IBinder.FIRST_CALL_TRANSACTION + 13);
        static final int TRANSACTION_playNext = (android.os.IBinder.FIRST_CALL_TRANSACTION + 14);
        static final int TRANSACTION_playPre = (android.os.IBinder.FIRST_CALL_TRANSACTION + 15);
        static final int TRANSACTION_hasPre = (android.os.IBinder.FIRST_CALL_TRANSACTION + 16);
        static final int TRANSACTION_hasNext = (android.os.IBinder.FIRST_CALL_TRANSACTION + 17);
        static final int TRANSACTION_getPreMusic = (android.os.IBinder.FIRST_CALL_TRANSACTION + 18);
        static final int TRANSACTION_getNextMusic = (android.os.IBinder.FIRST_CALL_TRANSACTION + 19);
        static final int TRANSACTION_getCurrPlayingMusic = (android.os.IBinder.FIRST_CALL_TRANSACTION + 20);
        static final int TRANSACTION_setCurrMusic = (android.os.IBinder.FIRST_CALL_TRANSACTION + 21);
        static final int TRANSACTION_setPlayMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 22);
        static final int TRANSACTION_getPlayMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 23);
        static final int TRANSACTION_getProgress = (android.os.IBinder.FIRST_CALL_TRANSACTION + 24);
        static final int TRANSACTION_seekTo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 25);
        static final int TRANSACTION_reset = (android.os.IBinder.FIRST_CALL_TRANSACTION + 26);
        static final int TRANSACTION_stopNotification = (android.os.IBinder.FIRST_CALL_TRANSACTION + 27);
        static final int TRANSACTION_openCacheWhenPlaying = (android.os.IBinder.FIRST_CALL_TRANSACTION + 28);
        static final int TRANSACTION_setPlaybackParameters = (android.os.IBinder.FIRST_CALL_TRANSACTION + 29);
        static final int TRANSACTION_getBufferedPosition = (android.os.IBinder.FIRST_CALL_TRANSACTION + 30);
        static final int TRANSACTION_setVolume = (android.os.IBinder.FIRST_CALL_TRANSACTION + 31);
        static final int TRANSACTION_updateNotificationCreater = (android.os.IBinder.FIRST_CALL_TRANSACTION + 32);
        static final int TRANSACTION_updateNotificationFavorite = (android.os.IBinder.FIRST_CALL_TRANSACTION + 33);
        static final int TRANSACTION_updateNotificationLyrics = (android.os.IBinder.FIRST_CALL_TRANSACTION + 34);
        static final int TRANSACTION_updateNotificationContentIntent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 35);
        static final int TRANSACTION_registerPlayerEventListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 36);
        static final int TRANSACTION_unregisterPlayerEventListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 37);
        static final int TRANSACTION_registerTimerTaskListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 38);
        static final int TRANSACTION_unregisterTimerTaskListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 39);
        static final int TRANSACTION_getAudioSessionId = (android.os.IBinder.FIRST_CALL_TRANSACTION + 40);
        static final int TRANSACTION_getPlaybackSpeed = (android.os.IBinder.FIRST_CALL_TRANSACTION + 41);
        static final int TRANSACTION_getPlaybackPitch = (android.os.IBinder.FIRST_CALL_TRANSACTION + 42);

    }

    //??????????????????????????????
    void playMusic(List<SongInfo> list, int index, boolean isJustPlay) throws android.os.RemoteException;

    //????????????????????????
    void playMusicByInfo(SongInfo info, boolean isJustPlay) throws android.os.RemoteException;

    //??????????????????
    void playMusicByIndex(int index, boolean isJustPlay) throws android.os.RemoteException;

    //??????????????????
    void pausePlayInMillis(long time) throws android.os.RemoteException;

    int getCurrPlayingIndex() throws android.os.RemoteException;

    //??????
    void pauseMusic() throws android.os.RemoteException;

    //??????
    void resumeMusic() throws android.os.RemoteException;

    //????????????
    void stopMusic() throws android.os.RemoteException;

    //??????????????????
    void setPlayList(List<SongInfo> list) throws android.os.RemoteException;

    //??????????????????
    void setPlayListWithIndex(List<SongInfo> list, int index) throws android.os.RemoteException;

    //??????????????????
    List<SongInfo> getPlayList() throws android.os.RemoteException;

    //????????????????????????????????????
    void deleteSongInfoOnPlayList(SongInfo info, boolean isNeedToPlayNext) throws android.os.RemoteException;

    //??????????????????
    int getStatus() throws android.os.RemoteException;

    //??????????????????
    int getDuration() throws android.os.RemoteException;

    //???????????????
    void playNext() throws android.os.RemoteException;

    //???????????????
    void playPre() throws android.os.RemoteException;

    //??????????????????
    boolean hasPre() throws android.os.RemoteException;

    //??????????????????
    boolean hasNext() throws android.os.RemoteException;

    //?????????????????????
    SongInfo getPreMusic() throws android.os.RemoteException;

    //?????????????????????
    SongInfo getNextMusic() throws android.os.RemoteException;

    //????????????????????????
    SongInfo getCurrPlayingMusic() throws android.os.RemoteException;

    //????????????????????????
    void setCurrMusic(int index) throws android.os.RemoteException;

    //??????????????????
    void setPlayMode(int mode) throws android.os.RemoteException;

    int getPlayMode() throws android.os.RemoteException;

    //??????????????????
    long getProgress() throws android.os.RemoteException;

    //?????????????????????
    void seekTo(int position) throws android.os.RemoteException;

    //?????????
    void reset() throws android.os.RemoteException;

    //????????????????????????
    void openCacheWhenPlaying(boolean isOpen) throws android.os.RemoteException;

    //???????????????
    void stopNotification() throws RemoteException;

    //??????
    void setPlaybackParameters(float speed, float pitch) throws RemoteException;

    //??????????????????
    long getBufferedPosition() throws RemoteException;

    //????????????
    void setVolume(float audioVolume) throws RemoteException;

    //???????????????
    void updateNotificationCreater(NotificationCreater creater) throws android.os.RemoteException;

    //?????????????????????/????????????????????????
    void updateNotificationFavorite(boolean isFavorite) throws android.os.RemoteException;

    //?????????????????????????????????????????????
    void updateNotificationLyrics(boolean isChecked) throws android.os.RemoteException;

    //???????????????ContentIntent
    void updateNotificationContentIntent(android.os.Bundle bundle, String targetClass) throws android.os.RemoteException;

    //?????????????????????????????????
    void registerPlayerEventListener(IOnPlayerEventListener listener) throws android.os.RemoteException;

    //????????????????????????????????????
    void unregisterPlayerEventListener(IOnPlayerEventListener listener) throws android.os.RemoteException;

    //?????????????????????????????????
    void registerTimerTaskListener(IOnTimerTaskListener listener) throws android.os.RemoteException;

    //????????????????????????????????????
    void unregisterTimerTaskListener(IOnTimerTaskListener listener) throws android.os.RemoteException;

    //????????????SessionId
    int getAudioSessionId() throws android.os.RemoteException;

    //??????????????????
    float getPlaybackSpeed() throws android.os.RemoteException;

    //??????????????????
    float getPlaybackPitch() throws android.os.RemoteException;


}
