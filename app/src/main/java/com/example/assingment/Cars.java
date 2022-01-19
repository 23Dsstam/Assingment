package com.example.assingment;

import java.io.Serializable;

public class Cars implements Serializable {

    //Initialize variables
    private int Photo;
    private String Brand;
    private String Model;
    private String Year;
    private String Price;

    // Getters and Setters
    public int getPhoto() {
        return Photo;
    }

    public String getBrand() {
        return Brand;
    }

    public String getModel() {
        return Model;
    }

    public String getYear() {
        return Year;
    }

    public String getPrice() {
        return Price;
    }

    //Constructors
    public Cars(int photo, String brand, String model, String year, String price){
        this.Photo = photo;
        this.Brand = brand;
        this.Model = model;
        this.Year = year;
        this.Price = price;
    }

}
