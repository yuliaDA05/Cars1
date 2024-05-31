package com.example.cars2;

public class Cars {

    private String name;
    private String number;
    private int year;
    public Cars (String name, String number, int year) {
        this.name = name;
        this.number = number;
        this.year = year;
    }
    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
}