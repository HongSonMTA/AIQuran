package com.example.aiquran.aiquran.models;

public class MyColor {
    private String name;
    private String hex;

    public MyColor(String name, String value) {
        this.name = name;
        this.hex = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String value) {
        this.hex = value;
    }
    public  int getColor(){
        return android.graphics.Color.parseColor(this.hex);
    }
}
