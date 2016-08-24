package com.javarush.test.level15.lesson12.home04;

public class Sun implements Planet{
    private static Sun sun = null;
    private Sun(){}
    public static Sun getInstance() {
        if (sun==null){
            sun = new Sun();
        }
        return sun;
    }
}
