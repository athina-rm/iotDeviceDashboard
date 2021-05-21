package com.example.iotdevicedashboard.controllers;

import com.example.iotdevicedashboard.Models.deviceData;
import com.example.iotdevicedashboard.repositories.DeviceDataDAO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@RestController
public class RESTController {
    DeviceDataDAO data = new DeviceDataDAO();

    @RequestMapping("/deviceData")                 //http://localhost:8080/deviceData
    public List<deviceData> getAllData() {
        return data.getAllData();
    }

    @RequestMapping("deviceData/add")      //http://192.168.0.243:8080/deviceData/add
    public String addFriend(@RequestBody deviceData d) {
        boolean status;
        data.addData(d);
        //System.out.println("deviceId:"+d.getDeviceId()+" Humidity:"+d.getHumidity()+" Temperature : "+d.getTemp()+" timestamp:"+d.getTimestamp()+" Time:"+(new Date(d.getTimestamp()*1000))+ d.getTime());
        /*if (status = data.addFriend(f))
            return new Response("Friend added Successfully", true);
        else
            return new Response("Couldn't add friend",false);*/
        return ("added");
    }

    @RequestMapping("deviceData/forecast")
    public String TodaysForecast() {

        return data.Forecast();
    }

}
