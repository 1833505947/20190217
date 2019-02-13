package com.example.fanshezhujiefanxing20190213.anotation;

@MyAnotation(userId = "class",age = 100)
public class User {
    @MyAnotation(userId = "name",age = 100)
    public String name;
    public int age;
    @MyAnotation(userId = "fun",age = 100)
    public void fun(){

    }

}
