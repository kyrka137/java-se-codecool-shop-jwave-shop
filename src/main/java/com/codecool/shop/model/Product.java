package com.codecool.shop.model;

import java.util.Currency;

/**
 * The type Product.
 */
public class Product extends BaseModel {

    private float defaultPrice;
    private Currency defaultCurrency;
    private ProductCategory productCategory;
    private Supplier supplier;


    /**
     * Instantiates a new Product.
     *
     * @param id              the id
     * @param name            the name
     * @param defaultPrice    the default price
     * @param currencyString  the currency string
     * @param description     the description
     * @param productCategory the product category
     * @param supplier        the supplier
     */
    public Product(int id, String name, float defaultPrice, String currencyString, String description, ProductCategory productCategory, Supplier supplier) {
        super(id, name, description);
        this.setPrice(defaultPrice, currencyString);
        this.setSupplier(supplier);
        this.setProductCategory(productCategory);
    }

    /**
     * Gets default price.
     *
     * @return the default price
     */
    public float getDefaultPrice() {
        return defaultPrice;
    }

    /**
     * Sets default price.
     *
     * @param defaultPrice the default price
     */
    public void setDefaultPrice(float defaultPrice) {
        this.defaultPrice = defaultPrice;
    }

    /**
     * Gets default currency.
     *
     * @return the default currency
     */
    public Currency getDefaultCurrency() {
        return defaultCurrency;
    }

    /**
     * Sets default currency.
     *
     * @param defaultCurrency the default currency
     */
    public void setDefaultCurrency(Currency defaultCurrency) {
        this.defaultCurrency = defaultCurrency;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public String getPrice() {
        return String.valueOf(this.defaultPrice) + " " + this.defaultCurrency.toString();
    }

    /**
     * Sets price.
     *
     * @param price    the price
     * @param currency the currency
     */
    public void setPrice(float price, String currency) {
        this.defaultPrice = price;
        this.defaultCurrency = Currency.getInstance(currency);
    }

    /**
     * Gets product category.
     *
     * @return the product category
     */
    public ProductCategory getProductCategory() {
        return productCategory;
    }

    /**
     * Sets product category.
     *
     * @param productCategory the product category
     */
    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
        this.productCategory.addProduct(this);
    }

    /**
     * Gets supplier.
     *
     * @return the supplier
     */
    public Supplier getSupplier() {
        return supplier;
    }

    /**
     * Sets supplier.
     *
     * @param supplier the supplier
     */
    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
        this.supplier.addProduct(this);
    }

    @Override
    public String toString() {
        return String.format("id: %1$d, " +
                        "name: %2$s, " +
                        "defaultPrice: %3$f, " +
                        "defaultCurrency: %4$s, " +
                        "productCategory: %5$s, " +
                        "supplier: %6$s",
                this.id,
                this.name,
                this.defaultPrice,
                this.defaultCurrency.toString(),
                this.productCategory.getName(),
                this.supplier.getName());
    }
}
