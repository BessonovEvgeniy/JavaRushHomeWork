package com.javarush.test.level14.lesson08.home09;

public class Hrivna extends Money {
    public Hrivna (double value) {
        super(value);
    }
    public String getCurrencyName(){
        return "HRN";
    }
}