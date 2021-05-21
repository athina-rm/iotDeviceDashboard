package com.example.iotdevicedashboard.repositories;

import com.example.iotdevicedashboard.Models.deviceData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DeviceDataDAO {
    public DeviceDataDAO() {
    }

    public List<deviceData> getAllData() {
        List<deviceData> data = new ArrayList<>();
        try {
            Properties p = new Properties();
            p.load(new FileInputStream("src/main/resources/application.properties"));
            Connection con = DriverManager.getConnection(p.getProperty("connectionString"), p.getProperty("spring.datasource.username"), p.getProperty("spring.datasource.password"));
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM dbo.dhtmeasurements ORDER BY epochTime desc");
            while (rs.next()) {
                deviceData d = new deviceData(rs.getInt("id"), rs.getString("deviceId"), rs.getFloat("temp"), rs.getFloat("humidity"), rs.getLong("epochTime"));
                data.add(d);
            }
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return data;
    }

    public boolean addData(deviceData d) {
        int result = 0;
        try {
            Properties p = new Properties();
            p.load(new FileInputStream("src/main/resources/application.properties"));
            Connection con = DriverManager.getConnection(p.getProperty("connectionString"), p.getProperty("spring.datasource.username"), p.getProperty("spring.datasource.password"));
            PreparedStatement stmt = con.prepareStatement("INSERT INTO dbo.dhtmeasurements (deviceId,temp,humidity,epochTime,date) VALUES (?,?,?,?,?)");
            stmt.setString(1, d.getDeviceId());
            stmt.setFloat(2, d.getTemp());
            stmt.setFloat(3, d.getHumidity());
            stmt.setLong(4, (d.getTime()));
            stmt.setDate(5, new Date(d.getTime() * 1000));

            result = stmt.executeUpdate();
            if (result == 1) {
                return true;
            }
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return  false;
    }

    public String Forecast() {

        String forecast = "";
        String quary = "select max(temp) as Todays_Highest , min(temp) as Todays_Lowest,  ROUND(avg(temp),2) as Todays_avg from dbo.dhtmeasurements  where date =  CONVERT(date, SYSDATETIME())";
        try {
            Properties p = new Properties();
            p.load(new FileInputStream("src/main/resources/application.properties"));
            Connection con = DriverManager.getConnection(p.getProperty("connectionString"),p.getProperty("username"),p.getProperty("password"));
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(quary);

            while (rs.next()) {
                float Highest = rs.getFloat("Todays_Highest");
                float Lowest = rs.getFloat("Todays_Lowest");
                float Average = rs.getFloat("Todays_avg");
                forecast += "Highest " + Highest + " Lowest " + Lowest + " Average " + Average;
                System.out.println(forecast);


            }
        } catch (SQLException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return forecast;
    }

}
