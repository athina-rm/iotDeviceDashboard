package com.example.iotdevicedashboard.repositories;

import com.example.iotdevicedashboard.Models.deviceData;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DeviceDataDAO {
    public DeviceDataDAO() {}

    public List<deviceData> getAllData() {
        List<deviceData> data = new ArrayList<>();
        try {
            Properties p = new Properties();
            p.load(new FileInputStream("src/main/java/com/example/iotdevicedashboard/system.properties"));
            Connection con = DriverManager.getConnection(p.getProperty("connectionString"), p.getProperty("username"), p.getProperty("password"));
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM dbo.dhtmeasurements");
            while (rs.next()) {
                deviceData d = new deviceData(rs.getInt("id"), rs.getString("deviceId"), rs.getFloat("temp"), rs.getFloat("humidity"), rs.getTimestamp("epochTime"));
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
            p.load(new FileInputStream("src/main/java/com/example/iotdevicedashboard/system.properties"));
            Connection con = DriverManager.getConnection(p.getProperty("connectionString"), p.getProperty("username"), p.getProperty("password"));
            PreparedStatement stmt = con.prepareStatement("INSERT INTO dbo.dhtmeasurements (deviceId,temp,humidity,epochTime,date) VALUES (?,?,?,?,?)");
            stmt.setString(1, d.getDeviceId());
            stmt.setFloat(2, d.getTemp());
            stmt.setFloat(3, d.getHumidity());
            stmt.setLong(4,(d.getTime()));
            stmt.setDate(5,new Date(d.getTime()*1000));

            result = stmt.executeUpdate();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return result > 0;
    }
}
