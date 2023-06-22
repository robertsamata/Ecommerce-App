package com.example.ecommerce;

public class Product {
    private String name, description, price, imagine;
    public Product(){

    }

    public Product(String imagine , String name, String description, String price) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imagine = imagine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImagine() {
        return imagine;
    }

    public void setImagine(String imagine) {this.imagine = imagine;}
};


