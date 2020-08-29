package com.example.gorcories;

public class orderpojo {
    private String name,price,image,customer;
    public orderpojo()
    {

    }
    public orderpojo(String name,String price)
    {
        this.name=name;
        this.price=price;

    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name=name;

    }
    public String getPrice()
    {
        return price;
    }
    public void setPrice(String price)
    {
        this.price=price;

    }
}
