package com.javarush.test.level04.lesson16.home02;

import java.io.*;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num1 = Integer.parseInt(reader.readLine());
        int num2 = Integer.parseInt(reader.readLine());
        int num3 = Integer.parseInt(reader.readLine());
        int rez;

        if (num1 > num2 && num1 < num3){
            rez = num1;
        }
        else if (num1 > num3 && num1 < num2){
            rez = num1;
        }
        else if (num2 > num1 && num2 < num3){
            rez = num2;
        }
        else if (num2 > num3 && num2 < num1){
            rez = num2;
        }
        else {
            rez = num3;
        }
        System.out.println(rez);
    }
}
