package org.zackratos.xmaplocation;


import android.os.Parcel;
import android.os.Parcelable;

import com.amap.api.location.AMapLocation;

/**
 * Created by Administrator on 2017/6/22.
 */

public class Location implements Parcelable {

    public static final int CODE_SUCCESS = AMapLocation.LOCATION_SUCCESS;
    public static final int CODE_INVALID_PARAMETER = AMapLocation.ERROR_CODE_INVALID_PARAMETER;
    public static final int CODE_WIFI_INFO = AMapLocation.ERROR_CODE_FAILURE_WIFI_INFO;
    public static final int CODE_LOCATION_PARAMETER = AMapLocation.ERROR_CODE_FAILURE_LOCATION_PARAMETER;
    public static final int CODE_CONNECTION = AMapLocation.ERROR_CODE_FAILURE_CONNECTION;
    public static final int CODE_PARSER = AMapLocation.ERROR_CODE_FAILURE_PARSER;
    public static final int CODE_LOCATION = AMapLocation.ERROR_CODE_FAILURE_LOCATION;
    public static final int CODE_AUTH = AMapLocation.ERROR_CODE_FAILURE_AUTH;
    public static final int CODE_UNKNOWN = AMapLocation.ERROR_CODE_UNKNOWN;
    public static final int CODE__INIT = AMapLocation.ERROR_CODE_FAILURE_INIT;
    public static final int CODE_SERVICE_FAIL = AMapLocation.ERROR_CODE_SERVICE_FAIL;
    public static final int CODE_CELL = AMapLocation.ERROR_CODE_FAILURE_CELL;
    public static final int CODE_LOCATION_PERMISSION = AMapLocation.ERROR_CODE_FAILURE_LOCATION_PERMISSION;
    public static final int CODE_NOWIFIANDAP = AMapLocation.ERROR_CODE_FAILURE_NOWIFIANDAP;
    public static final int CODE_NOENOUGHSATELLITES = AMapLocation.ERROR_CODE_FAILURE_NOENOUGHSATELLITES;
    public static final int CODE_SIMULATION_LOCATION = AMapLocation.ERROR_CODE_FAILURE_SIMULATION_LOCATION;
    public static final int CODE_NO_AVAILABLE_GEOGRAPHICAL_FENCE = 16;


    public static final int TYPE_FAILURE = 0;
    public static final int TYPE_GPS = AMapLocation.LOCATION_TYPE_GPS;
    public static final int TYPE_SAME_REQ = AMapLocation.LOCATION_TYPE_SAME_REQ;
    public static final int TYPE_FAST = AMapLocation.LOCATION_TYPE_FAST;
    public static final int TYPE_FIX_CACHE = AMapLocation.LOCATION_TYPE_FIX_CACHE;
    public static final int TYPE_WIFI = AMapLocation.LOCATION_TYPE_WIFI;
    public static final int TYPE_CELL = AMapLocation.LOCATION_TYPE_CELL;
    public static final int TYPE_AMAP = AMapLocation.LOCATION_TYPE_AMAP;
    public static final int TYPE_OFFLINE = AMapLocation.LOCATION_TYPE_OFFLINE;


    public static final int GPS_ACCURACY_GOOD = AMapLocation.GPS_ACCURACY_GOOD;
    public static final int GPS_ACCURACY_BAD = AMapLocation.GPS_ACCURACY_BAD;
    public static final int GPS_ACCURACY_UNKNOWN = AMapLocation.GPS_ACCURACY_UNKNOWN;



    private boolean success;
    private int errorCode;
    private String errorInfo;
    private int locationType;
    private String locationDetail;
    private double latitude;
    private double longitude;
    private float accuracy;
    private double altitude;
    private float speed;
    private float bearing;
    private String buildingId;
    private String floor;
    private String address;
    private String country;
    private String province;
    private String city;
    private String district;
    private String street;
    private String streetNum;
    private String cityCode;
    private String adCode;
    private String poiName;
    private String aoiName;
    private int gpsStatus;





    public Location(AMapLocation location) {

        this.success = location.getErrorCode() == CODE_SUCCESS;
        this.errorCode = location.getErrorCode();
        this.errorInfo = location.getErrorInfo();
        this.locationType = location.getLocationType();
        this.locationDetail = location.getLocationDetail();
        this.latitude = location.getLatitude();
        this.longitude = location.getLongitude();
        this.accuracy = location.getAccuracy();
        this.altitude = location.getAltitude();
        this.speed = location.getSpeed();
        this.bearing = location.getBearing();
        this.buildingId = location.getBuildingId();
        this.floor = location.getFloor();
        this.address = location.getAddress();
        this.country = location.getCountry();
        this.province = location.getProvince();
        this.city = location.getCity();
        this.district = location.getDistrict();
        this.street = location.getStreet();
        this.streetNum = location.getStreetNum();
        this.cityCode = location.getCityCode();
        this.adCode = location.getAdCode();
        this.poiName = location.getPoiName();
//        this.adCode = location.getAdCode();
        this.aoiName = location.getAoiName();
        this.gpsStatus = location.getGpsAccuracyStatus();

    }


    public boolean isSuccess() {
        return success;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public int getLocationType() {
        return locationType;
    }

    public String getLocationDetail() {
        return locationDetail;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public float getAccuracy() {
        return accuracy;
    }

    public double getAltitude() {
        return altitude;
    }

    public float getSpeed() {
        return speed;
    }

    public float getBearing() {
        return bearing;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public String getFloor() {
        return floor;
    }

    public String getAddress() {
        return address;
    }

    public String getCountry() {
        return country;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public String getDistrict() {
        return district;
    }

    public String getStreet() {
        return street;
    }

    public String getStreetNum() {
        return streetNum;
    }

    public String getCityCode() {
        return cityCode;
    }

    public String getAdCode() {
        return adCode;
    }

    public String getPoiName() {
        return poiName;
    }

    public String getAoiName() {
        return aoiName;
    }

    public int getGpsStatus() {
        return gpsStatus;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte(this.success ? (byte) 1 : (byte) 0);
        dest.writeInt(this.errorCode);
        dest.writeString(this.errorInfo);
        dest.writeInt(this.locationType);
        dest.writeString(this.locationDetail);
        dest.writeDouble(this.latitude);
        dest.writeDouble(this.longitude);
        dest.writeFloat(this.accuracy);
        dest.writeDouble(this.altitude);
        dest.writeFloat(this.speed);
        dest.writeFloat(this.bearing);
        dest.writeString(this.buildingId);
        dest.writeString(this.floor);
        dest.writeString(this.address);
        dest.writeString(this.country);
        dest.writeString(this.province);
        dest.writeString(this.city);
        dest.writeString(this.district);
        dest.writeString(this.street);
        dest.writeString(this.streetNum);
        dest.writeString(this.cityCode);
        dest.writeString(this.adCode);
        dest.writeString(this.poiName);
        dest.writeString(this.aoiName);
        dest.writeInt(this.gpsStatus);
    }

    protected Location(Parcel in) {
        this.success = in.readByte() != 0;
        this.errorCode = in.readInt();
        this.errorInfo = in.readString();
        this.locationType = in.readInt();
        this.locationDetail = in.readString();
        this.latitude = in.readDouble();
        this.longitude = in.readDouble();
        this.accuracy = in.readFloat();
        this.altitude = in.readDouble();
        this.speed = in.readFloat();
        this.bearing = in.readFloat();
        this.buildingId = in.readString();
        this.floor = in.readString();
        this.address = in.readString();
        this.country = in.readString();
        this.province = in.readString();
        this.city = in.readString();
        this.district = in.readString();
        this.street = in.readString();
        this.streetNum = in.readString();
        this.cityCode = in.readString();
        this.adCode = in.readString();
        this.poiName = in.readString();
        this.aoiName = in.readString();
        this.gpsStatus = in.readInt();
    }

    public static final Parcelable.Creator<Location> CREATOR = new Parcelable.Creator<Location>() {
        @Override
        public Location createFromParcel(Parcel source) {
            return new Location(source);
        }

        @Override
        public Location[] newArray(int size) {
            return new Location[size];
        }
    };
}
