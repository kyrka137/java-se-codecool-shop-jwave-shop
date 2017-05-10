package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Created by flavia on 2017.05.10..
 */
public class ProductDaoJdbc extends JdbcConnection implements ProductDao {
    @Override
    public void add(Product product) {
        String query = "INSERT INTO products (id, name, defaultPrice, currencyString, description, productCategory, supplier) " +
                        "VALUES ('" + product.getId() + "', '" + product.getName() + "', '" + product.getDefaultPrice() + "', '" + product.getDefaultCurrency() + "', '" + product.getDescription() + "', '" + product.getProductCategory() + "', '" + product.getSupplier() + "') " +
                        "ON CONFLICT (name) DO UPDATE " +
                        "SET id = '" + product.getId() + "', name = '" + product.getName() + "', defaultPrice = '" + product.getDefaultPrice() + "', currencyString = '" + product.getDefaultCurrency() + "', description = '" + product.getDescription() + "', productCategory = '" + product.getProductCategory() + "', supplier = '" + product.getSupplier() + "';";
        executeQuery(query);
    }

    @Override
    public Product find(int id) {
        String query = "SELECT * FROM products WHERE id ='" + id + "';";

        try (Connection connection = getConnection();
             Statement statement =connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query);
        ){
            if (resultSet.next()){
                Product result = new Product(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getFloat("defaultPrice"),
                        resultSet.getString("currencyString"),
                        resultSet.getString("description"),
                        null,
                        null);
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

    }

    @Override
    public List<Product> getAll() {
        return null;
    }

    @Override
    public List<Product> getBy(Supplier supplier) {
        return null;
    }

    @Override
    public List<Product> getBy(ProductCategory productCategory) {
        return null;
    }
}
