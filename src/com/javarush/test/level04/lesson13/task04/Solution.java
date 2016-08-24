package com.javarush.test.level04.lesson13.task04;

import java.io.*;

/* Рисуем линии
Используя цикл for вывести на экран:
- горизонтальную линию из 10 восьмёрок
- вертикальную линию из 10 восьмёрок.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
       // BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int m = 10;
        int n = 11;
        for (int m1 = 1; m1<m; m1++){
            System.out.print("8");
        }
        System.out.print("");
        for (int n1 = 1; n1<=n; n1++){
            System.out.println("8");
        }
    }
}
