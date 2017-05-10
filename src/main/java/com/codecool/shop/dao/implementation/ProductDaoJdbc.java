package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

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
