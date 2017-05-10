package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.model.ProductCategory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gabor on 2017.05.08..
 */
public class ProductCategoryDaoJdbc extends JdbcConnection implements ProductCategoryDao {
    @Override
    public void add(ProductCategory category) {
        String query =
                "INSERT INTO categories (id, name, department, description) " +
                "VALUES ('" + category.getId() + "', '" + category.getName() + "', '" + category.getDepartment() + "', '" + category.getDescription() + "')" +
                "ON CONFLICT (name) DO UPDATE " +
                "SET id = '" + category.getId() + "', name = '" + category.getName() + "', department = '" + category.getDepartment() + "', description = '" + category.getDescription() + "';";
        executeQuery(query);
    }

    @Override
    public ProductCategory find(int id) {
        String query = "SELECT * FROM categories WHERE id ='" + id + "';";

        try (Connection connection = getConnection();
             Statement statement =connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query);
        ){
            if (resultSet.next()){
                ProductCategory result = new ProductCategory(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("department"),
                        resultSet.getString("description"));
                return result;
            } else {
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public ProductCategory find(String name) {
        String query = "SELECT * FROM categories WHERE id ='" + name + "';";

        try (Connection connection = getConnection();
             Statement statement =connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query);
        ){
            if (resultSet.next()){
                ProductCategory result = new ProductCategory(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("department"),
                        resultSet.getString("description"));
                return result;
            } else {
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void remove(int id) {
        String query = "DELETE FROM categories WHERE id = '" + id +"';";
        executeQuery(query);
    }

    @Override
    public List<ProductCategory> getAll() {
        String query = "SELECT * FROM categories;";

        List<ProductCategory> resultList = new ArrayList<>();

        try (Connection connection = getConnection();
             Statement statement =connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query);
        ){
            while (resultSet.next()){
                ProductCategory actProductCategory = new ProductCategory(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("department"),
                        resultSet.getString("description"));
                resultList.add(actProductCategory);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultList;
    }
}
