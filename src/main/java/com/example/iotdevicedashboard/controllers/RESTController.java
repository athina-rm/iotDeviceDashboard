package com.example.iotdevicedashboard.controllers;

import com.example.iotdevicedashboard.Models.deviceData;
import com.example.iotdevicedashboard.repositories.DeviceDataDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@Controller
public class RESTController {
    DeviceDataDAO data = new DeviceDataDAO();

    /*@GetMapping("/home")
    public String welcome(){
        return "index";
    }*/

    @RequestMapping("/deviceData")                 //http://localhost:8080/deviceData
    public String  getAllData(Model model) {
        List<deviceData>allData=data.getAllData();
        model.addAttribute("index",allData);
        return "index";
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

    @RequestMapping("deviceData/forecast")      //http://192.168.0.243:8080/deviceData/forecast
    public String TodaysForecast() {
        return data.Forecast();
    }

}
