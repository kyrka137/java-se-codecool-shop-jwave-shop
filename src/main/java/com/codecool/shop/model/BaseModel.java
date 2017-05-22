package com.codecool.shop.model;


import java.lang.reflect.Field;

/**
 * The type Base model.
 */
public class BaseModel {

    /**
     * The Id.
     */
    protected int id;
    /**
     * The Name.
     */
    protected String name;
    /**
     * The Description.
     */
    protected String description;

    /**
     * Instantiates a new Base model.
     *
     * @param id the id
     */
    public BaseModel(int id) { this.id = id ;}

    /**
     * Instantiates a new Base model.
     *
     * @param name the name
     */
    public BaseModel(String name) {
        this.name = name;
    }

    /**
     * Instantiates a new Base model.
     *
     * @param id          the id
     * @param name        the name
     * @param description the description
     */
    public BaseModel(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }


    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
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
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (Field field : this.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object value = null;
            try {
                value = field.get(this);
                if (value != null) {
                    sb.append(field.getName() + ":" + value + ",");
                }
            } catch (IllegalAccessException e) {

            }
        }
        return sb.toString();
    }

}
