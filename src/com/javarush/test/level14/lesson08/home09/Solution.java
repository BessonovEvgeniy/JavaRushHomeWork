package com.javarush.test.level14.lesson08.home09;

import java.util.ArrayList;
import java.util.List;

/* Валюты
1. Реализуй метод getAmount в классе Money:
1.1. Подумай, какого типа нужно создать приватную переменную, если метод getAmount будет ее возвращать.
1.2. Создай приватную переменную этого типа и верни ее в методе getAmount.
1.3. В конструкторе присвой ей значение, полученное параметром.
2. В отдельном файле создай класс Hrivna.
3. Наследуй класс Hrivna от класса Money.
4. В классе Hrivna реализуй метод getCurrencyName, который возвращает "HRN".
5. В отдельном файле создай класс USD.
6. Наследуй класс USD от класса Money.
7. В классе USD реализуй метод getCurrencyName, который возвращает "USD".
8. Подумай, объекты каких классов можно добавить в список(лист) allMoney.
9. Добавь в конструктор класса Person заполнение листа allMoney объектами всех возможных классов.
*/

public class Solution {
    public static void main(String[] args) {
        Person ivan = new Person("Иван");
        for (Money money : ivan.getAllMoney()) {
            System.out.println(ivan.name + " имеет заначку в размере " + money.getAmount() + " " + money.getCurrencyName());
        }
    }
    public static class Person {
        public String name;
        private List<Money> allMoney;

        public Person(String name) {
            this.name = name;
            this.allMoney = new ArrayList<Money>();
            this.allMoney.add(new Hrivna(2));
            this.allMoney.add(new USD(100));
        }
        public List<Money> getAllMoney() {
            return allMoney;
        }
    }

    public static class USD extends Money{
        public USD (double value){
            super(value);
        }
        public String getCurrencyName(){
            return "USD";
        }
    }
}
