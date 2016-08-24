package com.javarush.test.level09.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел). Слова вывести в возрастающем порядке, числа - в убывающем.
Пример вывода:
Арбуз
3
Боб
2
Вишня
1
0
Яблоко
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array){
        ArrayList<Integer> num_list = new ArrayList<>();
        ArrayList<String> str_list = new ArrayList<>();
        int num, temp;
        //Сортировка данных на числа и строки
        for (String item : array){
            if (isNumber(item)){
                num = Integer.parseInt(item);
                num_list.add(num);
            }
            else {
                str_list.add(item);
            }
        }
        //Сортировка чисел по убыванию
        for (int j = 0; j < num_list.size()-1; j++){
            for (int i = j; i < num_list.size()-1; i++){
                if (num_list.get(j) <= num_list.get(i + 1)){
                    num_list.add(j,num_list.get(i + 1));
                    num_list.remove(i + 2);
                }
            }
        }
        //Сортировка букв по возрастанию
        for (int j = 0; j < str_list.size(); j++){
            for (int i = j; i < str_list.size()-1; i++){
                if (isGreaterThan(str_list.get(j),str_list.get(i + 1))){
                    str_list.add(j,str_list.get(i + 1));
                    str_list.remove(i + 2);
                }
            }
        }

        for (int i = 0; i < array.length; i++){
            if (isNumber(array[i])){
                array[i] = num_list.get(0).toString();
                num_list.remove(0);
            }
            else {
                array[i] = str_list.get(0);
                str_list.remove(0);
            }
        }
    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b)
    {
        return a.compareTo(b) > 0;
    }


    //строка - это на самом деле число?
    public static boolean isNumber(String s)
    {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            char c = chars[i];
            if ((i != 0 && c == '-') //есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-') ) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
