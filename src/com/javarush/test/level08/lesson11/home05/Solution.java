package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        char[] char_s = s.toCharArray();

        if (char_s[0] != ' '){
            char_s[0] = Character.toUpperCase(char_s[0]);
        }

        char prev_char = char_s[0];

        for (int i = 1; i < char_s.length; i++){
            if (char_s[i-1] == ' ' && char_s[i] != ' '){
                char_s[i] = Character.toUpperCase(char_s[i]);
            }
        }

        System.out.print(char_s);
    }
}
