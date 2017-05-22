package com.codecool.shop.model;

/**
 * Created by gabor on 2017.05.10..
 */
public class LineItem {
    private Product product;
    private int quantity;

    /**
     * Instantiates a new Line item.
     *
     * @param product  the product
     * @param quantity the quantity
     */
    public LineItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * Gets product.
     *
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Sets product.
     *
     * @param product the product
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Gets quantity.
     *
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets quantity.
     *
     * @param quantity the quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public float getPrice() {
        return quantity*product.getDefaultPrice();
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return product.getName();
    }


}

