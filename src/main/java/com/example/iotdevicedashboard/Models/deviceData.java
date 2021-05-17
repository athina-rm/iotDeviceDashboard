package com.example.iotdevicedashboard.Models;

import java.util.Date;

public class deviceData {
    int id;
    String deviceId;
    float temp;
    float humidity;
    Date time;

    public deviceData(int id, String  deviceId, float temp, float humidity, Date time) {
        this.id=id;
        this.deviceId = deviceId;
        this.temp = temp;
        this.humidity = humidity;
        this.time = time;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
