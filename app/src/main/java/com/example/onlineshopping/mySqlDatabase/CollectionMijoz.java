package com.example.onlineshopping.mySqlDatabase;

import android.util.Log;

import com.example.onlineshopping.objects.MijozModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CollectionMijoz {
    public static ArrayList<MijozModel> getMijoz() {
        ArrayList<MijozModel> modelUsers = new ArrayList<>();
        ConnectionBase connectionBase = new ConnectionBase();
        Connection connection = connectionBase.Conn();
        String sql = "SELECT * FROM `users`";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            MijozModel modelUser;
            while (resultSet.next()) {
                modelUser = new MijozModel();

                modelUser.setId(resultSet.getInt(1));
                modelUser.setEmail(resultSet.getString(2));
                modelUser.setParol(resultSet.getString(3));
                modelUser.setName(resultSet.getString(4));
                modelUser.setPhone(resultSet.getString(5));
                modelUsers.add(modelUser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return modelUsers;


    }

    public static boolean testUser(String email) {
        boolean A = true;
        for (int i = 0; i < CollectionMijoz.getMijoz().size(); i++) {
            if (CollectionMijoz.getMijoz().get(i).getEmail().equals(email)) {
                A = false;
                break;
            }
        }
        return A;
    }

}
