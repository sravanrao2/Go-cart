package com.example.gorcories;

/**
 * Represents the Ingredients if receipe
 */
public class Ingredients {
    /**
     *Represents the Ingredients name
     * Represents the ingredients price
     */
    private String name;
    private int price;

    /**
     * Creates Ingredients with name and price
     * @param name the ingredients name
     * @param price the ingredients price
     */
    public Ingredients(String name, int price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Get's Ingredients name
     * @return a string represents Ingredients name
     */
    public String getName() {
        return name;
    }

    /**
     * Set's Ingredients name
     * @param name a string contains Ingredients name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get's Ingredients price
     * @return a integer represents the Ingredients price
     */
    public int getPrice() {
        return price;
    }

    /**
     * Set's the ingredients price
     * @param price a integer represents the
     */
    public void setPrice(int price) {
        this.price = price;
    }
}
