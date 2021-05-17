package com.example.iotdevicedashboard.controllers;

import com.example.iotdevicedashboard.Models.deviceData;
import com.example.iotdevicedashboard.repositories.DeviceDataDAO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RESTController {
    DeviceDataDAO data = new DeviceDataDAO();

    @RequestMapping("/deviceData")                 //http://localhost:8080/friends
    public List<deviceData> getAllFriends() {
        return data.getAllData();
    }

}
