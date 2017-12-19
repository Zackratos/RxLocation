package com.github.zackratos.rxlocation;

import android.content.Context;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationClientOption.AMapLocationMode;

import io.reactivex.Observable;

/**
 * author : Zhangwenchao
 * e-mail : zhangwch@yidianling.com
 * time   : 2017/12/13
 */

public class RxLocation {

    private AMapLocationClient client;

    private RxLocation(Context context, Builder builder) {
        client = new AMapLocationClient(context.getApplicationContext());
        AMapLocationClientOption option = new AMapLocationClientOption();
        option.setLocationMode(builder.mode)
                .setOnceLocation(true)
                .setInterval(2000)
                .setNeedAddress(builder.needAddress);

        option.setMockEnable(builder.mockEnable);
        option.setWifiScan(builder.wifiScan);
        option.setHttpTimeOut(builder.timeout);
        option.setLocationCacheEnable(builder.cache);
        option.setOnceLocationLatest(builder.onceLocationLatest);
        client.setLocationOption(option);
    }

    public static Builder newBuilder(Context context) {
        return new Builder(context);
    }

    public Observable<AMapLocation> locate() {
        return new LocationObservable(client);
    }


    public static class Builder {
//        private Mode mode;
        private AMapLocationMode mode;
        private boolean onceLocationLatest;
        private boolean needAddress;
        private boolean wifiScan;
        private boolean mockEnable;
        private long timeout;
        private boolean cache;
        private Context context;

        // set default value
        private Builder(Context context) {
            this.context = context;
            mode = AMapLocationMode.Hight_Accuracy;
            needAddress = true;
            wifiScan = true;
            onceLocationLatest = false;
            timeout = 20000;
            mockEnable = false;
            cache = false;
        }

        public Builder mode(AMapLocationMode mode) {
            this.mode = mode;
            return this;
        }

        public Builder onceLocationLatest(boolean onceLocationLatest) {
            this.onceLocationLatest = onceLocationLatest;
            return this;
        }

        public Builder needAddress(boolean needAddress) {
            this.needAddress = needAddress;
            return this;
        }

        public Builder wifiScan(boolean wifiScan) {
            this.wifiScan = wifiScan;
            return this;
        }

        public Builder mockEnable(boolean mockEnable) {
            this.mockEnable = mockEnable;
            return this;
        }

        public Builder timeout(long timeout) {
            this.timeout = timeout;
            return this;
        }

        public Builder cache(boolean cache) {
            this.cache = cache;
            return this;
        }

        public RxLocation build() {
            return new RxLocation(context, this);
        }
    }
}
