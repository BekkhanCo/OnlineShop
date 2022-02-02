package com.example.onlineshopping.mySqlDatabase;

import android.database.SQLException;

import java.sql.Connection;
import java.sql.Statement;

public class InsertMijoz {
    public static boolean mijozKirit(String email, String parol, String name, String phone)
            throws SQLException, java.sql.SQLException {
        ConnectionBase connectionBase = new ConnectionBase();
        Connection connection = connectionBase.Conn();
        String sql = "INSERT INTO `users`(email,parol,name,phone) VALUES('" + email + "','" + parol + "','" + name + "','" + phone + "')";
        Statement statement = connection.createStatement();
        int natija = statement.executeUpdate(sql);
        return (natija == 1) ? true : false;

    }
}
