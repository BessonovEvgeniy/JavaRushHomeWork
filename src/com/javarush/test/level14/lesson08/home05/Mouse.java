package com.javarush.test.level14.lesson08.home05;

class Mouse implements CompItem{
    public String getName(){
        return this.getClass().getSimpleName();
    }
}