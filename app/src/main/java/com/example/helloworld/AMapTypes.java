package com.example.helloworld;

public enum AMapTypes {
    marker("marker"),
    navigation("navigation");

    private String type;
    AMapTypes(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
