package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

import java.util.Date;

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        String firstName;
        String secondName;
        int age;
        boolean sex;
        Date bithday;
        String addres;

        public Human(String firstName, String secondName, int age, boolean sex, Date bithday, String addres){
            this.firstName = firstName;
            this.secondName = secondName;
            this.age = age;
            this.sex = sex;
            this.bithday = bithday;
            this.addres = addres;
        }

        public Human(String firstName, int age){
            this.firstName = firstName;
            this.age = age;
        }

        public Human(String firstName){
            this.firstName = firstName;
        }

        public Human(String firstName, String secondName, boolean sex){
            this.firstName = firstName;
            this.secondName = secondName;
            this.sex = sex;
        }

        public Human(String firstName, boolean sex, Date bithday, String addres){
            this.firstName = firstName;
            this.sex = sex;
            this.bithday = bithday;
            this.addres = addres;
        }

        public Human(String firstName, Date bithday){
            this.firstName = firstName;
            this.bithday = bithday;
        }

        public Human(String firstName, String secondName){
            this.firstName = firstName;
            this.secondName = secondName;
        }

        public Human(String firstName, String secondName, int age){
            this.firstName = firstName;
            this.secondName = secondName;
            this.age = age;
        }

        public Human(String firstName, String secondName, Date bithday, String addres){
            this.firstName = firstName;
            this.secondName = secondName;
            this.bithday = bithday;
            this.addres = addres;
        }

        public Human(String firstName, String secondName, Date bithday){
            this.firstName = firstName;
            this.secondName = secondName;
            this.bithday = bithday;
        }

    }
}
