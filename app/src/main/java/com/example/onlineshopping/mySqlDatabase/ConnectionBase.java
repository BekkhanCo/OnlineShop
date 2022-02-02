package com.example.onlineshopping.mySqlDatabase;

import android.annotation.SuppressLint;
import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBase {
    String classs = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://192.168.43.8:3307/shop";
    String userName = "root";
    String parol = "";

    @SuppressLint ( "NewApi" )
    public Connection Conn() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection conn = null;
        String ConnUrl = null;

        try {
            Class.forName(classs);
            conn = DriverManager.getConnection(url, userName, parol);
            conn = DriverManager.getConnection(ConnUrl);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
