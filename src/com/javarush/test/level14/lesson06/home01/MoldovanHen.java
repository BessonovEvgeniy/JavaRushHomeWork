package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Евгений on 21.06.2016.
 */
class MoldovanHen extends Hen
{
    int getCountOfEggsPerMonth(){
        return 13;
    }
    String getDescription(){
        return super.getDescription()+" Моя страна - "+ Country.MOLDOVA +". Я несу "+this.getCountOfEggsPerMonth()+" яиц в месяц.";
    }
}