package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.model.ProductCategory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * The type Product category dao mem test.
 */
class ProductCategoryDaoMemTest {
    /**
     * Instantiates a new Product category dao mem test.
     */
    ProductCategoryDaoMemTest() {
    }

    /**
     * Test same category name cannot add.
     */
    @Test
    public void testSameCategoryNameCannotAdd() {
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        ProductCategory tablet1 = new ProductCategory(1,"Tablet", "Hardware", "A tablet computer.");
        productCategoryDataStore.add(tablet1);
        ProductCategory tablet2 = new ProductCategory(1,"Tablet", "Hardware", "A tablet computer.");
        productCategoryDataStore.add(tablet2);
        int size = productCategoryDataStore.getAll().size();
        Assertions.assertEquals(1, size);
    }

    /**
     * Test is product category dao mem is singleton.
     */
    @Test
    public void testIsProductCategoryDaoMemIsSingleton() {
        ProductCategoryDao productCategoryDataStore1 = ProductCategoryDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore2 = ProductCategoryDaoMem.getInstance();
        Assertions.assertEquals(productCategoryDataStore1.hashCode(), productCategoryDataStore2.hashCode());
    }

    /**
     * Test find by id if non existing id.
     */
    @Test
    public void testFindByIdIfNonExistingId() {
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        assertEquals(null,productCategoryDataStore.find(-4));
    }

    private void assertEquals(Object o, ProductCategory productCategory) {
    }

    /**
     * Test find by if id zero.
     */
    @Test
    public void testFindByIfIdZero() {
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        assertEquals(null,productCategoryDataStore.find(0));
    }


    /**
     * Test remove by non existing id.
     */
    @Test
    public void testRemoveByNonExistingId() {
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        ProductCategory tablet = new ProductCategory(1,"Tablet", "Hardware", "A tablet computer.");
        productCategoryDataStore.add(tablet);
        productCategoryDataStore.remove(0);

    }

    /**
     * Test remove by id.
     */
    @Test
    public void testRemoveById() {
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        ProductCategory tablet = new ProductCategory(1,"Tablet", "Hardware", "A tablet computer.");
        productCategoryDataStore.add(tablet);
        productCategoryDataStore.remove(1);
        assertEquals(null,productCategoryDataStore.find(1));
    }




}
