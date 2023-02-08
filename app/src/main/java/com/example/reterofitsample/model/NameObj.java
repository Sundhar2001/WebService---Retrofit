package com.example.reterofitsample.model;

import com.google.gson.annotations.SerializedName;

public class NameObj {

    @SerializedName("name")
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
