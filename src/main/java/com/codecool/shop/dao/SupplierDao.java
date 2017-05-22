package com.codecool.shop.dao;

import com.codecool.shop.model.Supplier;

import java.util.List;

/**
 * The interface Supplier dao.
 */
public interface SupplierDao {

    /**
     * Add.
     *
     * @param supplier the supplier
     */
    void add(Supplier supplier);

    /**
     * Find supplier.
     *
     * @param id the id
     * @return the supplier
     */
    Supplier find(int id);

    /**
     * Find supplier.
     *
     * @param name the name
     * @return the supplier
     */
    Supplier find(String name);

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
    List<Supplier> getAll();
}
