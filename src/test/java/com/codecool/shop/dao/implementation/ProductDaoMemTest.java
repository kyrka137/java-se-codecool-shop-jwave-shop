package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by zahoranszky on 2017.05.11..
 */
class ProductDaoMemTest {

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        ProductDao productDao = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDao = ProductCategoryDaoMem.getInstance();
        SupplierDao supplierDao = SupplierDaoMem.getInstance();
        ProductCategory tablet = new ProductCategory(1, "Tablet", "Hardware", "A tablet computer.");
        Supplier amazon = new Supplier(1,"Amazon", "Digital content and services");
        productCategoryDao.add(tablet);
        supplierDao.add(amazon);
        productDao.add(new Product(1,"Amazon Fire", 49.9f, "USD", "Fantastic price. Large content ecosystem. Good parental controls. Helpful technical support.", tablet, amazon));
    }

    /**
     * Tear down.
     */
    @AfterEach
    void tearDown() {
        ProductDao productDao = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDao = ProductCategoryDaoMem.getInstance();
        SupplierDao supplierDao = SupplierDaoMem.getInstance();
        productDao.remove(1);
        productCategoryDao.remove(1);
        supplierDao.remove(1);

    }

    /**
     * Test get instance.
     */
    @Test
    void testGetInstance() {
        ProductDao product1 = ProductDaoMem.getInstance();
        ProductDao product2 = ProductDaoMem.getInstance();
        assertEquals(product1.hashCode(),product2.hashCode());
    }

    /**
     * Gets all.
     */
    @Test
    void getAll() {
        ProductDao productDao = ProductDaoMem.getInstance();
        assertEquals(1,productDao.getAll().size());
    }

    /**
     * Test add.
     */
    @Test
    void testAdd() {
        ProductDao productDao = ProductDaoMem.getInstance();
        assertEquals(1,productDao.getAll().size());
        productDao.remove(1);
    }

    /**
     * Test remove.
     */
    @Test
    void testRemove() {
        ProductDao productDao = ProductDaoMem.getInstance();
        productDao.remove(1);
        assertEquals(0,productDao.getAll().size());
    }

    /**
     * Test find.
     */
    @Test
    void testFind() {
        ProductDao productDao = ProductDaoMem.getInstance();
        assertEquals("Amazon Fire",productDao.find(1).getName());

    }





}