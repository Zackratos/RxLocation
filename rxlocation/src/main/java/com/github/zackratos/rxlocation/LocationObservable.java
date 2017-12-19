package com.github.zackratos.rxlocation;

import android.util.Log;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationListener;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

/**
 * author : Zhangwenchao
 * e-mail : zhangwch@yidianling.com
 * time   : 2017/12/13
 */

final class LocationObservable extends Observable<AMapLocation> {

    private final AMapLocationClient client;

    LocationObservable(AMapLocationClient client) {
        this.client = client;
    }

    private static final String TAG = "LocationObservable";

    @Override
    protected void subscribeActual(Observer<? super AMapLocation> observer) {
        Log.d(TAG, "subscribeActual: " + Thread.currentThread().getName());
        Listener listener = new Listener(client, observer);
        observer.onSubscribe(listener);
        client.setLocationListener(listener);
        client.startLocation();
    }

    static final class Listener extends MainThreadDisposable implements AMapLocationListener {

        private AMapLocationClient client;

        private Observer<? super AMapLocation> observer;

        private Listener(AMapLocationClient client, Observer<? super AMapLocation> observer) {
            this.client = client;
            this.observer = observer;
        }

        @Override
        protected void onDispose() {
            client.stopLocation();
            client.onDestroy();
            client.setLocationListener(null);
        }

        @Override
        public void onLocationChanged(AMapLocation aMapLocation) {
            Log.d(TAG, "onLocationChanged: " + Thread.currentThread().getName());
            if (isDisposed()) {
                return;
            }
            if (aMapLocation.getErrorCode() == 0) {
                observer.onNext(aMapLocation);
            } else {
                observer.onError(new Throwable(aMapLocation.getErrorInfo()));
            }
        }
    }
}
