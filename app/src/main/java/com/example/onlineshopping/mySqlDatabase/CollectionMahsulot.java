package com.example.onlineshopping.mySqlDatabase;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.onlineshopping.CategoryItem.ModelCategoryItem;
import com.example.onlineshopping.KategoriyaRec.ModelKategoriya;
import com.example.onlineshopping.nestedview.ModelAllCategory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CollectionMahsulot {

    public static ArrayList<ModelAllCategory> getmodelAllCategories() {
        ArrayList<ModelAllCategory> modelAllCategories = new ArrayList<>();

        ConnectionBase connectionBase = new ConnectionBase();
        Connection connection = connectionBase.Conn();
        String sql = "SELECT * FROM marka WHERE marka.kategoriya_id=0";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            ModelAllCategory modelAllCategory;
            while (resultSet.next()) {
                modelAllCategory = new ModelAllCategory();
                modelAllCategory.setId(resultSet.getInt(1));
                modelAllCategory.setNomi(resultSet.getString(2));
                modelAllCategory.setRasmi(resultSet.getBytes(4));
                modelAllCategories.add(modelAllCategory);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return modelAllCategories;
    }

    public static ArrayList<ModelCategoryItem> getModelCategoryItems(int id) {
        ArrayList<ModelCategoryItem> modelCategoryItems = new ArrayList<>();
        ConnectionBase connectionBase = new ConnectionBase();
        Connection connection = connectionBase.Conn();
        String sql = "SELECT kategoriya.id,kategoriya.rasmi,kategoriya.narxi,kategoriya.nomi,kategoriya.sanasi,kategoriya.marka_id FROM kategoriya JOIN marka ON marka.id=kategoriya.marka_id WHERE marka.id=" + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            ModelCategoryItem modelCategoryItem;
            while (resultSet.next()) {
                modelCategoryItem = new ModelCategoryItem();
                modelCategoryItem.setId(resultSet.getInt(1));
                modelCategoryItem.setRasm(resultSet.getBytes(2));
                modelCategoryItem.setNarxi(resultSet.getDouble(3));
                modelCategoryItem.setNomi(resultSet.getString(4));
                modelCategoryItem.setSanasi(resultSet.getString(5));
                modelCategoryItem.setMarka_id(resultSet.getInt(6));
                modelCategoryItems.add(modelCategoryItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return modelCategoryItems;
    }

}








