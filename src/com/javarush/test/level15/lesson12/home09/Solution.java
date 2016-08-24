package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            //Инициализация переменных
            String str = reader.readLine();
            LinkedList<String> params = new LinkedList<String>();
            LinkedList<Object> values = new LinkedList<Object>();

            str = str.substring(str.indexOf("?") + 1,str.length());
            String[] parsedStr = str.split("&");
            for (String parametr : parsedStr){
                params.add(parametr);
                if (parametr.startsWith("obj=")){
                    String[] ParamValue = parametr.split("=");
                    try {
                        values.add(Double.parseDouble(ParamValue[1]));
                    }
                    catch (Exception e){
                        values.add(ParamValue[1].toString());
                    }
                }
            }
            for(String param : params){
                alertP(param); System.out.print(" ");
            }
            System.out.println("");
            for(Object value : values){
                if (value instanceof Double ) {
                    alert((double) value);
                }
                else {
                    alert(value.toString());
                }
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        if (value.contains("=")){
            value = value.substring(0,value.indexOf("="));
        }
        System.out.print("String " + value);
    }
    public static void alertP(String value) {
        if (value.contains("=")){
            value = value.substring(0,value.indexOf("="));
        }
        System.out.print(value);
    }
}
