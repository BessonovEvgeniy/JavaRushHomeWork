package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int in1 = Integer.parseInt(reader.readLine());
        int in2 = Integer.parseInt(reader.readLine());
        int temp;
        if (in1 < in2){
            temp = in2;
            in2 = in1;
            in1 = temp;
        }
        while (in2 !=0 && in1 !=0) {
            int tmp = in1%in2;
            in1 = in2;
            in2 = tmp;
        }
        System.out.println(in1);
    }
}
