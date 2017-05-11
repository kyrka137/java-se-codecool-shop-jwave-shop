package com.codecool.shop.model;

/**
 * Created by gabor on 2017.05.10..
 */
public class LineItem {
    private Product product;
    private int quantity;
    private float price;


    public LineItem(Product product, int quantity, float price) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }


    public int getId() {
        return this.product.getId();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }



    public String getName(){
        return this.product.getName();
    }
}

