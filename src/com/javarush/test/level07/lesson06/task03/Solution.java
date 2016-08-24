package com.javarush.test.level07.lesson06.task03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Самая короткая строка
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую короткую строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<Integer> intA = new ArrayList<>();

        String str;
        int lstr;
        int min = 100000000;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++){
            str = reader.readLine();
            lstr = str.length();
            list.add(str);
            intA.add(lstr);
            if (min > lstr){
                min = lstr;
            }
        }

        for (int i = 0; i < 5; i++) {
            if (intA.get(i) == min){
                System.out.println(list.get(i));
            }
        }
    }
}
