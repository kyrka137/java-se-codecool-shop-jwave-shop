package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.model.Supplier;
import jdk.nashorn.internal.objects.annotations.Optimistic;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Created by kyrka on 2017.05.11..
 */
class SupplierDaoJdbcTest {

    /**
     * Gets all.
     */
    @Test
    public void getALL() {
        SupplierDao supplierDao = new SupplierDaoJdbc();
        assertEquals(null, supplierDao.find(-7));
    }


    /**
     * Add.
     */
    @Test
    public void add() {
        SupplierDao supplierDao = new SupplierDaoJdbc();
        Supplier supplier = new Supplier(137, "", "");
        supplierDao.add(supplier);
        assertNotNull(supplierDao.find(137));
    }

    /**
     * Find string.
     */
    @Test
    public void find_string() {
        SupplierDao supplierDao = new SupplierDaoJdbc();
        assertEquals("Amazon", supplierDao.find(1).getName());
    }


    /**
     * Find int.
     */
    @Optimistic
    @Test
    public void find_int() {
        SupplierDao supplierDao = new SupplierDaoJdbc();
        assertEquals(1, supplierDao.find(1).getId());
    }

    /**
     * Remove.
     */
    @Test
    public void remove() {
        SupplierDao supplierDao = new SupplierDaoJdbc();
        Supplier supplier = new Supplier(731, "", "");
        supplierDao.add(supplier);
        supplierDao.remove(731);
        Supplier supplier_found = supplierDao.find(731);
        assertEquals(null, supplier_found);
    }
}
