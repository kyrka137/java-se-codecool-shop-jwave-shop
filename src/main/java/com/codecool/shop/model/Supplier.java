package com.codecool.shop.model;

import java.util.ArrayList;


/**
 * The type Supplier.
 */
public class Supplier extends BaseModel {
    private ArrayList<Product> products;

    /**
     * Instantiates a new Supplier.
     *
     * @param id          the id
     * @param name        the name
     * @param description the description
     */
    public Supplier(int id, String name, String description) {
        super(id, name, description);
        this.products = new ArrayList<>();
    }

    /**
     * Sets products.
     *
     * @param products the products
     */
    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    /**
     * Gets products.
     *
     * @return the products
     */
    public ArrayList getProducts() {
        return this.products;
    }

    /**
     * Add product.
     *
     * @param product the product
     */
    public void addProduct(Product product) {
        this.products.add(product);
    }

    public String toString() {
        return String.format("id: %1$d, " +
                        "name: %2$s, " +
                        "description: %3$s",
                this.id,
                this.name,
                this.description
        );
    }
}