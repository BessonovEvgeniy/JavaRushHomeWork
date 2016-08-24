package com.javarush.test.level04.lesson13.task03;

import java.io.*;

/* Рисуем треугольник
Используя цикл for вывести на экран прямоугольный треугольник из восьмёрок со сторонами 10 и 10.
Пример:
8
88
888
...
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int m = 10;
        int n = 10;
        for (int m1 = 1; m1<=m; m1++){
            for (int n1 = 1; n1<=m1; n1++){
                System.out.print("8");
            }
            System.out.println("");
        }
    }
}
