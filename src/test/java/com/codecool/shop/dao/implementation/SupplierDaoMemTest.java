package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.model.Supplier;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by zahoranszky on 2017.05.11..
 */
class SupplierDaoMemTest {

    @AfterEach
    public void clearExampleData() {
        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();
        for (int i=0; i<supplierDataStore.getAll().size(); i++) {
            supplierDataStore.remove(i);
        }
    }

    @Test
    public void testIsProductCategoryDaoMemIsSingletone () {
        SupplierDao supplierDataStore1 = SupplierDaoMem.getInstance();
        SupplierDao supplierDataStore2 = SupplierDaoMem.getInstance();
        assertEquals(supplierDataStore1.hashCode(),supplierDataStore2.hashCode());
    }

    @Test
    public void testFindByIfIdZero() {
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        assertEquals(null,productCategoryDataStore.find(0));
    }

    @Test
    public void testRemoveById() {
        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();
        Supplier amazon = new Supplier("Amazon", "Digital content and services");
        supplierDataStore.add(amazon);
        supplierDataStore.remove(1);
        assertEquals(null,supplierDataStore.find(1));
    }

}