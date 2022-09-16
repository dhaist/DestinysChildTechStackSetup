package com.example.vibe;

public class User {
    private String name;
    public User(){

    }

    public User(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setName(String newName){
        this.name = newName;
    }
}
