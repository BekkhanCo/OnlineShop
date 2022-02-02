package com.example.onlineshopping.mySqlDatabase;

import android.content.Context;
import android.util.Log;
import android.view.Display;

import com.example.onlineshopping.KategoriyaRec.ModelKategoriya;
import com.example.onlineshopping.MahsulotRec.ModelMahsulot;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;;
import java.sql.Statement;

public class CollectionKategoriya {

    public static ArrayList<ModelKategoriya> getModelKategoriyas() {
        ArrayList<ModelKategoriya> modelKategoriyas = new ArrayList<>();

        ConnectionBase connectionBase = new ConnectionBase();
        Connection connection = connectionBase.Conn();
        String sql = "SELECT * FROM marka WHERE marka.kategoriya_id=0";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            ModelKategoriya modelKategoriya;
            while (resultSet.next()) {
                modelKategoriya = new ModelKategoriya();
                modelKategoriya.setId(resultSet.getInt(1));
                modelKategoriya.setNomi(resultSet.getString(2));
                modelKategoriya.setRasmi(resultSet.getBytes(3));
                modelKategoriyas.add(modelKategoriya);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return modelKategoriyas;
    }

}
