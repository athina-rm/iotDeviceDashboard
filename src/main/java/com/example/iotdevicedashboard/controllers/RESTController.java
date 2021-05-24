package com.example.iotdevicedashboard.controllers;

import com.example.iotdevicedashboard.Models.Response;
import com.example.iotdevicedashboard.Models.deviceData;
import com.example.iotdevicedashboard.repositories.DeviceDataDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RESTController {
    DeviceDataDAO data = new DeviceDataDAO();

    @RequestMapping("/deviceData")                 //http://localhost:8080/deviceData
    public String  getAllData(deviceData d,Model model) {
        model.addAttribute("allData",data.getAllData());
        model.addAttribute("forecast",data.Forecast());
        return "index";
    }

    @RequestMapping("deviceData/add")      //http://192.168.0.243:8080/deviceData/add
    public Response addFriend(@RequestBody deviceData d) {
       // boolean status;
        Response res = new Response("New dht measurements Added", data.addData(d));
        return res;

    }

    @RequestMapping("deviceData/forecast")      //http://192.168.0.243:8080/deviceData/forecast
    public deviceData TodaysForecast() {
        return data.Forecast();
    }
}
