package com.example.gorcories;

/**
 * Model file for Orders
 */
public class orderpojo {
    private String name,price,image,customer;
    public orderpojo()
    {

    }

    /**
     * Constructor to initialize price and name of item
     * @param name item name
     * @param price item price
     */
    public orderpojo(String name,String price)
    {
        this.name=name;
        this.price=price;
    }

    /**
     * getter for name of item
     * @return Return name of item
     */
    public String getName()
    {
        return name;
    }

    /**
     * Setter for name of item
     * @param name Item name
     */
    public void setName(String name)
    {
        this.name=name;

    }
    /**
     * getter for price of item
     * @return Return price of item
     */
    public String getPrice()
    {
        return price;
    }
    /**
     * Setter for price of item
     * @param price  Item price
     */

    public void setPrice(String price)
    {
        this.price=price;

    }
}
