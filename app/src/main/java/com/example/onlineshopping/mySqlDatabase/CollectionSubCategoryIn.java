package com.example.onlineshopping.mySqlDatabase;

import com.example.onlineshopping.CategoryItem.ModelCategoryItem;
import com.example.onlineshopping.SubCategory.ModelSubCategory;
import com.example.onlineshopping.subCategoryin.ModelSubCategoryIn;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CollectionSubCategoryIn {
    public static ArrayList<ModelSubCategoryIn> getModelSubCategoryIns(int id) {
        ArrayList<ModelSubCategoryIn> modelSubCategoryIns = new ArrayList<>();
        ConnectionBase connectionBase = new ConnectionBase();
        Connection connection = connectionBase.Conn();
        String sql = "SELECT marka.id,kategoriya.nomi,kategoriya.rasmi,kategoriya.narxi,kategoriya.sanasi FROM marka JOIN kategoriya ON kategoriya.marka_id=marka.id WHERE kategoriya.marka_id=" + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            ModelSubCategoryIn modelSubCategoryIn;
            while (resultSet.next()) {
                modelSubCategoryIn = new ModelSubCategoryIn();
                modelSubCategoryIn.setId(resultSet.getInt(1));
                modelSubCategoryIn.setNomi(resultSet.getString(2));
                modelSubCategoryIn.setRasmi(resultSet.getBytes(3));
                modelSubCategoryIn.setNarxi(resultSet.getDouble(4));
                modelSubCategoryIn.setSana(resultSet.getString(5));
                modelSubCategoryIns.add(modelSubCategoryIn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return modelSubCategoryIns;
    }
}
