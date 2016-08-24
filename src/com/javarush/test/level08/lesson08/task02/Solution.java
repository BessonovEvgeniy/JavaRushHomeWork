package com.javarush.test.level08.lesson08.task02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* Удалить все числа больше 10
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.
*/

public class Solution
{
    public static void main(String[] args){
        HashSet<Integer> set = createSet();
        HashSet<Integer> set1 = removeAllNumbersMoreThan10(set);

        for(Integer item : set1){
            System.out.println(item);
        }

    }
    public static HashSet<Integer> createSet()
    {
        HashSet<Integer> set = new HashSet();
        for (int i = 0; i < 20; i++){
            set.add(i);
        }
        return set;
    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set)
    {
        HashSet<Integer> temp = set;
        Iterator<Integer> iterator = set.iterator();

        while (iterator.hasNext()){
            Integer item = iterator.next();
            if (item > 10){
                temp.remove(item);
            }
        }
        return temp;
    }
}
