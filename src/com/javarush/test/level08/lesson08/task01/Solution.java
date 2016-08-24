package com.javarush.test.level08.lesson08.task01;

import java.util.HashSet;
import java.util.Set;

/* 20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
*/

public class Solution
{
    public static HashSet<String> createSet()
    {
        HashSet<String> set1 = new HashSet<String>();
        set1.add("Люстра");
        set1.add("Люгер");
        set1.add("Лампа");
        set1.add("Люфт");
        set1.add("Лифт");
        set1.add("Лимон");
        set1.add("Лидка");
        set1.add("Лебедка");
        set1.add("Лебедь");
        set1.add("Легенда"); //10
        set1.add("Лампада");
        set1.add("Лига");
        set1.add("Лира");
        set1.add("Лес");
        set1.add("Луза");
        set1.add("Луна");
        set1.add("Любовь");
        set1.add("Лава");
        set1.add("Лом");
        set1.add("Лунаход");

        return set1;
    }
}
