package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Solution{
    public static void main(String[] args){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String fileName = reader.readLine();
            FileReader rfile = new FileReader(fileName);

            LinkedList<Integer> evenNum = new LinkedList<>();

            Scanner scanner = new Scanner(rfile);

            int num;
            while(scanner.hasNext()){
                num = scanner.nextInt();
                if (num%2 == 0){
                    evenNum.add(num);
                }
            }
            rfile.close();
            Object[] temp = evenNum.toArray();
            Arrays.sort(temp);

 /*           for (int j = 0; j < evenNum.size(); j++){
                for (int i = j; i < evenNum.size(); i++){
                    if (evenNum.get(j) > evenNum.get(i)){
                        int temp1 = evenNum.get(i);
                        evenNum.add(i,evenNum.get(j));
                        evenNum.add(j,temp1);
                    }
                }
            }*/


            for (Object item : temp){
                System.out.println(item);
            }
        }
        catch (Exception ex){
            System.out.println("Ups!");
        }
    }
}
