package com.codecool.shop.model;

/**
 * Created by zahoranszky on 2017.04.27..
 */


import java.util.ArrayList;
import java.util.List;

/**
 * The type Products.
 */
public class Products {

    private final List<Pro> products = new ArrayList<Pro>();

    /**
     * Instantiates a new Products.
     */
    public Products () {
        this.initStoreItems();
    }

    /**
     * Gets products.
     *
     * @return the products
     */
    public List<Pro> getProducts() {
        return products;
    }

    /**
     * Init store items.
     */
    public void initStoreItems() {
        String [] productNames = {"Amazon Fire", "Lenovo IdeaPad Miix 700", "Amazon Fire HD 8"};
        Double [] productPrice = {49.9d, 479.0d, 89.0d};
        Integer [] stock = {10, 6, 10};

        for (int i=0; i < productNames.length; i++) {
            this.products.add(new Pro(i+1, productNames[i], productPrice[i], stock[i]));
        }
    }

}
