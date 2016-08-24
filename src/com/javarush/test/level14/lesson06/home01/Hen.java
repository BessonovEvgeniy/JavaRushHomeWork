package com.javarush.test.level14.lesson06.home01;

public abstract class Hen extends Solution.HenFactory
{
    int getCountOfEggsPerMonth(){
        return 2;
    }
    String getDescription(){
        return "Я курица.";
    }
}
