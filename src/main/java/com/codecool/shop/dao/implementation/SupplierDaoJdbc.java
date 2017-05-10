package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.model.Supplier;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by flavia on 2017.05.10..
 */
public class SupplierDaoJdbc extends JdbcConnection implements SupplierDao {

    @Override
    public void add(Supplier supplier) {
        String query =
                "INSERT INTO suppliers (id, name, description) " +
                        "VALUES ('" + supplier.getId() + "', '" + supplier.getName() + "', '" + supplier.getDescription() + "')" +
                        "ON CONFLICT (name) DO UPDATE " +
                        "SET id = '" + supplier.getId() + "', name = '" + supplier.getName() + "', description = '" + supplier.getDescription() + "';";
        executeQuery(query);
    }

    @Override
    public Supplier find(int id) {
        String query = "SELECT * FROM suppliers WHERE id ='" + id + "';";

        try (Connection connection = getConnection();
             Statement statement =connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query);
        ){
            if (resultSet.next()){
                Supplier result = new Supplier(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
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
    public Supplier find(String name) {
        String query = "SELECT * FROM suppliers WHERE id ='" + name + "';";

        try (Connection connection = getConnection();
             Statement statement =connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query);
        ){
            if (resultSet.next()){
                Supplier result = new Supplier(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
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
        String query = "DELETE FROM suppliers WHERE id = '" + id +"';";
        executeQuery(query);
    }

    @Override
    public List<Supplier> getAll() {
        String query = "SELECT * FROM suppliers;";

        List<Supplier> resultList = new ArrayList<>();

        try (Connection connection = getConnection();
             Statement statement =connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query);
        ){
            while (resultSet.next()){
                Supplier actSupplier = new Supplier(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"));
                resultList.add(actSupplier);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultList;
    }
}
