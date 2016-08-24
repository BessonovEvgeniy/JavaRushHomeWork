package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Евгений on 21.06.2016.
 */
class UkrainianHen extends Hen
{
    int getCountOfEggsPerMonth(){
        return 2;
    }
    String getDescription(){
        return super.getDescription()+" Моя страна - "+ Country.UKRAINE +". Я несу "+this.getCountOfEggsPerMonth()+" яиц в месяц.";
    }
}