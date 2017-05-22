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

    /**
     * Clear example data.
     */
    @AfterEach
    public void clearExampleData() {
        SupplierDao supplierData = SupplierDaoMem.getInstance();
        for (int i=0; i<supplierData.getAll().size(); i++) {
            supplierData.remove(i);
        }
    }

    /**
     * Test is product category dao mem is singleton.
     */
    @Test
    public void testIsProductCategoryDaoMemIsSingleton () {
        SupplierDao supplierData1 = SupplierDaoMem.getInstance();
        SupplierDao supplierData2 = SupplierDaoMem.getInstance();
        assertEquals(supplierData1.hashCode(),supplierData2.hashCode());
    }

    /**
     * Test remove by id.
     */
    @Test
    public void testRemoveById() {
        SupplierDao supplierData = SupplierDaoMem.getInstance();
        Supplier amazon = new Supplier(1,"Amazon", "Digital content and services");
        supplierData.add(amazon);
        supplierData.remove(1);
        assertEquals(null,supplierData.find(1));
    }

    /**
     * Test find by if id zero.
     */
    @Test
    public void testFindByIfIdZero() {
        ProductCategoryDao productCategoryData = ProductCategoryDaoMem.getInstance();
        assertEquals(null,productCategoryData.find(0));
    }



}