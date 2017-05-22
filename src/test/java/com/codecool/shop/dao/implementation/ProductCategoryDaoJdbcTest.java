package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.model.ProductCategory;
import jdk.nashorn.internal.objects.annotations.Optimistic;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Created by kyrka on 2017.05.11..
 */
public class ProductCategoryDaoJdbcTest {

    /**
     * Gets all.
     */
    @Test
    public void getALL() {
        ProductCategoryDao productCategoryDao = new ProductCategoryDaoJdbc();
        assertNotNull(productCategoryDao.getAll());
    }


    /**
     * Add.
     */
    @Test
    public void add() {
        ProductCategoryDao productCategoryDao = new ProductCategoryDaoJdbc();
        ProductCategory productcategory = new ProductCategory(137, "productcategoryname", "", "");
        productCategoryDao.add(productcategory);
        assertNotNull(productCategoryDao.find(137));
    }

    /**
     * Find string.
     */
    @Test
    public void find_string() {
        ProductCategoryDao productCategoryDao = new ProductCategoryDaoJdbc();
        ProductCategory productcategory = new ProductCategory(137, "productcategoryname", "", "");
        productCategoryDao.add(productcategory);
        assertEquals(137, productCategoryDao.find("productcategoryname").getId());
    }


    /**
     * Find int.
     */
    @Optimistic
    @Test
    public void find_int() {
        ProductCategoryDao productCategoryDao = new ProductCategoryDaoJdbc();
        ProductCategory productcategory = new ProductCategory(137, "productcategoryname", "", "");
        productCategoryDao.add(productcategory);
        assertEquals("productcategoryname", productCategoryDao.find(137).getName());
    }

    /**
     * Remove.
     */
    @Test
    public void remove() {
        ProductCategoryDao productCategoryDao = new ProductCategoryDaoJdbc();
        ProductCategory productcategory = new ProductCategory(731, "productcategoryname", "", "");
        productCategoryDao.add(productcategory);
        productCategoryDao.remove(731);
        ProductCategory productCategory2_found = productCategoryDao.find(731);
        assertEquals(null, productCategory2_found);
    }
}
