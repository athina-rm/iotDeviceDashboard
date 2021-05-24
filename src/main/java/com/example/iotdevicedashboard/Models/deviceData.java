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
    float Highest;
    float Lowest;
    float Average;

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
    public deviceData(float highest,float lowest,float average){
        this.Highest = highest;
        this.Lowest = lowest;
        this.Average = average;
    }

    public float getHighest() {
        return Highest;
    }

    public void setHighest(float highest) {
        Highest = highest;
    }

    public float getLowest() {
        return Lowest;
    }

    public void setLowest(float lowest) {
        Lowest = lowest;
    }

    public float getAverage() {
        return Average;
    }

    public void setAverage(float average) {
        Average = average;
    }

    public int getId() {
        return id;
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
    public LocalDateTime getDatetime() {
        return datetime;
    }
    public void setDateTime(LocalDateTime date) {
        this.datetime = date;
    }

}
