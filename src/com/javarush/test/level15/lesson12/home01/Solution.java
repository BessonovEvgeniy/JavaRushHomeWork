package com.javarush.test.level15.lesson12.home01;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/* Разные методы для разных типов
1. Считать с консоли данные, пока не введено слово "exit".
2. Для каждого значения, кроме "exit", вызвать метод print. Если значение:
2.1. содержит точку '.', то вызвать метод print для Double;
2.2. больше нуля, но меньше 128, то вызвать метод print для short;
2.3. больше либо равно 128, то вызвать метод print для Integer;
2.4. иначе, вызвать метод print для String.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        LinkedList<String> list = new LinkedList<String>();
        while(!str.equals("exit")){
            list.add(str);
            str = reader.readLine();
        }
        for (String item : list) {
            try {
                Double num_d = Double.parseDouble(item);
                if (item.contains(".")) {
                    print(num_d);
                    continue;
                }
                Integer num_i = Integer.parseInt(item);
                if (num_i > 0 && num_i < 128) {
                    print(num_i.shortValue());
                }
                else if (num_i >= 128) {
                    print(num_i);
                }
                else {
                    print(item.toString());
                }
            }
            catch (Exception e) {
                print(item);
            }
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
