# XMapLocation
高德地图定位的封装，一行代码完成定位

## 使用方法

1.添加依赖：

```xml
compile 'com.github.zackratos.xlocation:xlocation:1.0.4'
```

2.配置AndroidManifest.xml：

在application标签中加入：

```xml
<meta-data android:name="com.amap.api.v2.apikey" android:value="key">//高德开放平台申请的key

</meta-data>
```



3.在需要定位的地方：
```java
XLocation.newBuilder(MainActivity.this)
        .locationMode(Mode.Device_Sensors)   //定位模式，默认值是 Mode.Height_Accuracy
        .cacheEnable(true)                           //缓存策略，默认关闭
        .onceLocationlatest(true)                    //获取最近3s内精度最高的一次定位结果，默认关闭
        .needAddress(false)                          //返回地址描述，默认开启
        .mockEnable(true)                            //外界在定位SDK通过GPS定位时模拟位置，默认关闭
        .wifiScan(false)                             //主动刷新设备wifi模块,默认开启
        .httpTimeout(5000)                           //通过网络定位获取结果的超时时间，默认值是 20000
        .build()
        .locate(new Listener() {               //监听定位结果
            @Override
            public void onLocated(Location location) {
                boolean success = location.isSuccess();         //定位是否成功
                int errorCode = location.getErrorCode();        //错误代码
                String errorInfo = location.getErrorInfo();     //错误信息
                double latitude = location.getLatitude();       //纬度
                double longitude = location.getLongitude();     //经度
                float acc = location.getAccuracy();             //精度
                double altitude = location.getAltitude();       //海拔
                float speed = location.getSpeed();              //速度
                float bear = location.getBearing();             //方向角
                String build = location.getBuildingId();        //室内定位建筑物 id
                String floor = location.getFloor();             //室内定位楼层
                String address = location.getAddress();         //地址描述
                String country = location.getCountry();         //国家
                String province = location.getProvince();       //省
                String city = location.getCity();               //城市
                String cityCode = location.getCityCode();       //城市编码
                String district = location.getDistrict();       //城区
                String adCode = location.getAdCode();           //区域编码
                String street = location.getStreet();           //街道
                String streetNum = location.getStreetNum();     //街道门牌号
                String poi = location.getPoiName();             //当前位置的 poi 名称
                String aoi = location.getAoiName();             //当前位置的 aoi 名称
                int gpsStatus = location.getGpsStatus();        //当前 gps 状态
                int type = location.getLocationType();          //定位来源
                String detail = location.getLocationDetail();   //定位信息描述

            }
        });
```

## 更新日志

### v1.0.4
1.修改包名；<br/>
2.修改部分类名；<br/>
3.修改 .gitignore 文件；<br/>
4.删除不需要的 .idea 目录。

### v1.0.3
1.修复获取定位结果的 aoi 名称为空的 bug。

### v1.0.2

1.增加开启获取最近3s内精度最高的一次定位结果功能，默认为关闭。

### v1.0.1

1.定位的结果 Location 类增加可序列化。

### v1.0.0


## License
```
Copyright 2017 Zackratos

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```