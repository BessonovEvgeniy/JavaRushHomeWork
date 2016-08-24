package com.javarush.test.level12.lesson04.task04;

/* Три метода возвращают минимальное из двух переданных в него чисел
Написать public static методы: int min(int, int), long min(long, long), double min(double, double).
Каждый метод должен возвращать минимальное из двух переданных в него чисел.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static int min(int k, int n){
        if (k < n){
            return k;
        }
        return n;
    }
    public static long min(long k, long n){
        if (k < n){
            return k;
        }
        return n;
    }
    public static double min(double k, double n){
        if (k < n){
            return k;
        }
        return n;
    }
}
