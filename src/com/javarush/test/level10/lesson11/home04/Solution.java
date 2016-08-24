package com.javarush.test.level10.lesson11.home04;

/* Большая зарплата
Вывести на экран надпись «Я не хочу изучать Java, я хочу большую зарплату» 40 раз по образцу.
Образец:
Я не хочу изучать Java, я хочу большую зарплату
 не хочу изучать Java, я хочу большую зарплату
не хочу изучать Java, я хочу большую зарплату
е хочу изучать Java, я хочу большую зарплату
 хочу изучать Java, я хочу большую зарплату
хочу изучать Java, я хочу большую зарплату
…
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        String s = "Я не хочу изучать Java, я хочу большую зарплату";

        char[] chars = s.toCharArray();
        ArrayList<Character> chars_list= new ArrayList<>();
        for (char item : chars){
        chars_list.add(item);
    }

        for (int i = 0; i < 40; i++){
            String str = "";
            for (char item : chars_list){
                str += item;
            }
            System.out.println(str);
            chars_list.remove(0);
        }
    }

}
