package com.codecool.shop.model;

import java.util.ArrayList;

/**
 * The type Product category.
 */
public class ProductCategory extends BaseModel {
    private String department;
    private ArrayList<Product> products;

    /**
     * Instantiates a new Product category.
     *
     * @param id          the id
     * @param name        the name
     * @param department  the department
     * @param description the description
     */
    public ProductCategory(int id, String name, String department, String description) {
        super(id, name, description);
        this.department = department;
        this.products = new ArrayList<>();
    }

    /**
     * Gets department.
     *
     * @return the department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Sets department.
     *
     * @param department the department
     */
    public void setDepartment(String department) {
        this.department = department;
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
        return String.format(
                "id: %1$d, " +
                        "name: %2$s, " +
                        "department: %3$s, " +
                        "description: %4$s",
                this.id,
                this.name,
                this.department,
                this.description);
    }
}