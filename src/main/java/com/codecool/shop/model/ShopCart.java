package com.codecool.shop.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gabor on 2017.04.28..
 */
public class ShopCart {

    private Integer id;
    private String status;
    private List<LineItem> shoppingCart;
    private static ShopCart instance;
    /**
     * The Total price.
     */
    float totalPrice = 0;


    /**
     * Add shopping cart.
     *
     * @param product the product
     */
    public void addShoppingCart(Product product) {
        boolean notFound = true;
        for(LineItem lineItem  : shoppingCart) {
            if(lineItem.getProduct().getId() == product.getId()) {
                lineItem.setQuantity(lineItem.getQuantity()+1);
                notFound = false;
            }
        }
        if (notFound) {
            LineItem lineItem = new LineItem(product, 1);
            shoppingCart.add(lineItem);
        }
    }

    /**
     * Gets shopping cart.
     *
     * @param id the id
     * @return the shopping cart
     */
    public LineItem getShoppingCart(int id) {
        return shoppingCart.get(id);
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static ShopCart getInstance() {
        if (instance == null) {
            instance = new ShopCart();
        }
        return instance;
    }

    /**
     * Gets all carts.
     *
     * @return the all carts
     */
    public List<LineItem> getAllCarts() {
        return shoppingCart;
    }

    /**
     * Instantiates a new Shop cart.
     */
    public ShopCart() {
        shoppingCart = new ArrayList<>();

    }

    /**
     * Gets total price.
     *
     * @return the total price
     */
    public float getTotalPrice() {
        for (LineItem lineItem: shoppingCart) {
            this.totalPrice += lineItem.getPrice();
        }
        return totalPrice;
    }

    /**
     * Gets .
     *
     * @return the
     */
    public int getid() {
        return id;
    }

    /**
     * Sets .
     *
     * @param id the id
     */
    public void setid(int id) {
        this.id = id;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }



}