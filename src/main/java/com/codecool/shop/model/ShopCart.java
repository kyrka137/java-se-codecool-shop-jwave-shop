package com.codecool.shop.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gabor on 2017.04.28..
 */
public class ShopCart {

    private Integer id;
    private String status;
    private List<Product> shoppingCart;
    private static ShopCart instance;


    public void addShoppingCart(Product product) {
        shoppingCart.add(product);
    }

    public Product getShoppingCart(int id) {
        return shoppingCart.get(id);
    }

    public static ShopCart getInstance() {
        if (instance == null) {
            instance = new ShopCart();
        }
        return instance;
    }

    public List<Product> getAllCarts() {
        return shoppingCart;
    }

    public ShopCart() {
        shoppingCart = new ArrayList<>();

    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }



}