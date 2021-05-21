package com.example.iotdevicedashboard.Models;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class deviceData {
    int id;
    String deviceId;
    float temp;
    float humidity;
    long time;
    LocalDateTime datetime;

    public deviceData(){}

    public deviceData(int id, String  deviceId, float temp, float humidity, long timestamp) {
        this.id=id;
        this.deviceId = deviceId;
        this.temp = temp;
        this.humidity = humidity;
        this.time=timestamp;
        this.datetime=LocalDateTime.ofInstant(Instant.ofEpochMilli(this.time*1000), ZoneId.systemDefault());
    }

    public deviceData(String  deviceId, float temp, float humidity, long time) {
        this.deviceId = deviceId;
        this.temp = temp;
        this.humidity = humidity;
        this.time= time;
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

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
    public LocalDateTime getDate() {
        return datetime;
    }

    public void setDate(LocalDateTime date) {
        this.datetime = date;
    }

}
