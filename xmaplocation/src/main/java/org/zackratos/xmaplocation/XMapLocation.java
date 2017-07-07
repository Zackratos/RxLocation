package org.zackratos.xmaplocation;


import android.content.Context;

import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationClientOption.AMapLocationMode;
import com.amap.api.location.AMapLocationListener;

/**
 * Created by Administrator on 2017/6/22.
 */

public class XMapLocation {


    private static final String TAG = "TAG";

    private AMapLocationClient client;

    public static Builder newBuilder(Context context) {
        return new Builder(context);
    }

    private XMapLocation(Context context, Builder builder) {

        client = new AMapLocationClient(context);
        AMapLocationClientOption option = new AMapLocationClientOption();


        option.setLocationMode(builder.mode == LocationMode.Height_Accuracy ?
                AMapLocationMode.Battery_Saving :
                builder.mode == LocationMode.Battery_Saving ?
                        AMapLocationMode.Battery_Saving :
                        AMapLocationMode.Device_Sensors)
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



/*    public void locateRepeat(final LocateListener listener) {

        client.setLocationListener(new AMapLocationListener() {
            @Override
            public void onLocationChanged(com.amap.api.location.XMapLocation aMapLocation) {
                listener.onLocated(new Location(aMapLocation));

            }
        });
    }*/



    public void locate(final LocateListener listener) {

        client.setLocationListener(new AMapLocationListener() {
            @Override
            public void onLocationChanged(com.amap.api.location.AMapLocation aMapLocation) {

                listener.onLocated(new Location(aMapLocation));


                client.stopLocation();
                client.onDestroy();
            }
        });

        client.startLocation();

    }




    public static class Builder {

        private LocationMode mode;
//        private boolean onceLocation;
        private boolean onceLocationLatest;
//        private long interval;
        private boolean needAddress;
        private boolean wifiScan;
        private boolean mockEnable;
        private long timeout;
        private boolean cache;

        private Context context;

        //设置默认参数
        private Builder(Context context) {
            this.context = context.getApplicationContext();
            mode = LocationMode.Height_Accuracy;
            needAddress = true;
            wifiScan = true;
            onceLocationLatest = false;
            timeout = 20000;
            mockEnable = false;
            cache = true;
        }


        public Builder locationMode(LocationMode mode) {
            this.mode = mode;
            return this;
        }

        public Builder onceLocationlatest(boolean onceLocationLatest) {
            this.onceLocationLatest = onceLocationLatest;
            return this;
        }

/*        public Builder onceLocation(boolean onceLocation) {
            this.onceLocation = onceLocation;
            return this;
        }

        public Builder onceLocationLatest(boolean onceLocationLatest) {
            this.onceLocationLatest = onceLocationLatest;
            return this;
        }

        public Builder interval(long interval) {
            this.interval = interval;
            return this;
        }*/

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

        public Builder httpTimeout(long timeout) {
            this.timeout = timeout;
            return this;
        }

        public Builder cacheEnable(boolean cache) {
            this.cache = cache;
            return this;
        }



        public XMapLocation build() {

            return new XMapLocation(context, this);
        }


    }


}
