package com.example.shoesfinder;

public class shoes {
    String name;
    String brand;
    String[] colors;
    String url;
    int price;


    public shoes(String name, String brand, String[] colors, String url, int price){
        this.name = name;
        this.brand = brand;
        this.colors = colors;
        this.url = url;
        this.price =  price;
    }

    public shoes(String name, String brand, String url, int price){
        this.name = name;
        this.brand = brand;
        this.url = url;
        this.price =  price;
    }

    public String getName(){
        return  name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getBrand(){
        return  brand;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }

    public String[] getColors(){
        return  colors;
    }

    public void setColors(String[] colors){
        this.colors = colors;
    }

    public String getUrl(){
        return  url;
    }

    public void setUrl(String url){
        this.url = url;
    }

    public int getPrice(){
        return price;
    }

    public  void setPrice(int price){
        this.price = price;
    }

}
