package com.codecool.shop.model;

import java.util.Objects;

/**
 * The type Pro.
 */
public class Pro {

    private Integer pid;
    private String name;
    private Double price;
    private Integer stock;

    /**
     * Instantiates a new Pro.
     */
    public Pro() {
    }

    /**
     * Instantiates a new Pro.
     *
     * @param pid   the pid
     * @param name  the name
     * @param price the price
     * @param stock the stock
     */
    public Pro(Integer pid, String name, Double price, Integer stock) {
        this.pid = pid;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price to set
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * Gets stock.
     *
     * @return the stock
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * Sets stock.
     *
     * @param stock the stock to set
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * Gets pid.
     *
     * @return the pid
     */
    public Integer getPid() {
        return pid;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.pid);
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + Objects.hashCode(this.price);
        hash = 29 * hash + Objects.hashCode(this.stock);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pro other = (Pro) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.pid, other.pid)) {
            return false;
        }
        if (!Objects.equals(this.price, other.price)) {
            return false;
        }
        if (!Objects.equals(this.stock, other.stock)) {
            return false;
        }
        return true;
    }

    /**
     * Sets pid.
     *
     * @param pid the pid to set
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }


}