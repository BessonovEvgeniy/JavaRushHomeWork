package com.javarush.test.level10.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Количество букв
Ввести с клавиатуры 10 строчек и подсчитать в них количество различных букв (для 33 букв алфавита).  Вывести результат на экран.
Пример вывода:
а 5
б 8
в 3
г 7
д 0
…
я 9
*/

public class Solution
{
    public static void main(String[] args)  throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        HashMap <Character, Integer> chars_counter = new HashMap<Character, Integer>();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++) {
            alphabet.add(abcArray[i]);
            chars_counter.put(abcArray[i], 0);
        }
        //ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }
        char[] strChar = null;
        for (int i = 0; i < list.size(); i++) {
            strChar = list.get(i).toCharArray();
            for (int j = 0; j < strChar.length; j++){
                for (int k = 0; k < alphabet.size(); k++){
                    if (strChar[j] == alphabet.get(k)){
                        chars_counter.put(alphabet.get(k), chars_counter.get(alphabet.get(k)) + 1);
                    }
                }
            }
        }
        for (int i = 0; i < alphabet.size(); i++){
            System.out.println(alphabet.get(i) + " " + chars_counter.get(alphabet.get(i)));
        }
    }
}