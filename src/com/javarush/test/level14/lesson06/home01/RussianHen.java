package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Евгений on 21.06.2016.
 */
class RussianHen extends Hen
{
    int getCountOfEggsPerMonth(){
        return 100;
    }
    String getDescription(){
        return super.getDescription()+" Моя страна - "+ Country.RUSSIA +". Я несу "+this.getCountOfEggsPerMonth()+" яиц в месяц.";
    }
}
