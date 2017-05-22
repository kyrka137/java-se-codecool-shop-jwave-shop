package com.codecool.shop.dao;

import com.codecool.shop.model.ProductCategory;

import java.util.List;

/**
 * The interface Product category dao.
 */
public interface ProductCategoryDao {

    /**
     * Add.
     *
     * @param category the category
     */
    void add(ProductCategory category);

    /**
     * Find product category.
     *
     * @param id the id
     * @return the product category
     */
    ProductCategory find(int id);

    /**
     * Find product category.
     *
     * @param name the name
     * @return the product category
     */
    ProductCategory find(String name);

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
    List<ProductCategory> getAll();

}
