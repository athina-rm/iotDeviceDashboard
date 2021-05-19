package com.example.iotdevicedashboard.controllers;

import com.example.iotdevicedashboard.Models.deviceData;
//import com.example.iotdevicedashboard.repositories.DeviceDataDAO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RESTController {
    /*DeviceDataDAO data = new DeviceDataDAO();

    @RequestMapping("/deviceData")                 //http://localhost:8080/friends
    public List<deviceData> getAllFriends() {
        return data.getAllData();
    }*/

    @RequestMapping("deviceData/add")
    public String addFriend(@RequestBody deviceData d){
        boolean status;
        System.out.println("deviceId:"+d.getDeviceId()+" Humidity:"+d.getHumidity()+" Temperature : "+d.getTemp()+" Time:"+d.getTime());
        /*if (status = data.addFriend(f))
            return new Response("Friend added Successfully", true);
        else
            return new Response("Couldn't add friend",false);*/
        return("added");
    }

}
