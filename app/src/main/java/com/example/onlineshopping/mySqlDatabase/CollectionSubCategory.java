package com.example.onlineshopping.mySqlDatabase;

import com.example.onlineshopping.SubCategory.ModelSubCategory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CollectionSubCategory {
    public static ArrayList<ModelSubCategory> getModelSubCategory(int id) {
        ArrayList<ModelSubCategory> modelSubCategories = new ArrayList<>();
        ConnectionBase connectionBase = new ConnectionBase();
        Connection connection = connectionBase.Conn();
        String sql = "SELECT marka.id,marka.nomi FROM marka  WHERE marka.kategoriya_id=" + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            ModelSubCategory modelSubCategory;
            while (resultSet.next()) {
                modelSubCategory = new ModelSubCategory();
                modelSubCategory.setId(resultSet.getInt(1));
                modelSubCategory.setNomi(resultSet.getString(2));
                modelSubCategories.add(modelSubCategory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return modelSubCategories;
    }
}
