package com.example.lab2;

public class Boat {
    private String make;
    private String model;
    private int year;
    private double length;
    private String engineType;
    private double price;

    public Boat() {
        make = "";
        model = "";
        year = 0;
        length = 0.0;
        engineType = "";
        price = 0.0;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getLength() {
        return length;
    }

    public String getEngineType() {
        return engineType;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Make: " + make + "\nModel: " + model + "\nYear: " + year +
                "\nLength: " + length + " feet" + "\nEngine Type: " + engineType +
                "\nPrice: $" + String.format("%.2f", price) + "\n";
    }
}