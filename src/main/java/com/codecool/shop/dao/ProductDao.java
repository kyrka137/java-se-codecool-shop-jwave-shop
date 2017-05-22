package com.codecool.shop.dao;

import com.codecool.shop.model.Supplier;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;

import java.util.List;

/**
 * The interface Product dao.
 */
public interface ProductDao {

    /**
     * Add.
     *
     * @param product the product
     */
    void add(Product product);

    /**
     * Find product.
     *
     * @param id the id
     * @return the product
     */
    Product find(int id);

    /**
     * Remove.
     *
     * @param id the id
     */
    void remove(int id);

    /**
     * Gets all.
     *
     * @return the all
     */
    List<Product> getAll();

    /**
     * Gets by.
     *
     * @param supplier the supplier
     * @return the by
     */
    List<Product> getBy(Supplier supplier);

    /**
     * Gets by.
     *
     * @param productCategory the product category
     * @return the by
     */
    List<Product> getBy(ProductCategory productCategory);

}
