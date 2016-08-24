package com.javarush.test.level07.lesson06.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Самая длинная строка
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую длинную строку в списке.
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
        int max = 0;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++){
            str = reader.readLine();
            list.add(str);
            intA.add(str.length());
            if (max < str.length()){
                max = str.length();
            }
        }
        for (int i = 0; i < 5; i++){
            if (intA.get(i) == max){
                System.out.println(list.get(i));
            }
        }
    }
}
