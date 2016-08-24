package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        String fileName = args[0];
        FileInputStream file = new FileInputStream(fileName);
        int[] charList = new int[255];
        int count;
        int result = 0;
        try {
            while (file.available() > 0) {
                count = file.read();
                charList[count]++;
            }
            for (int i = 65; i < 91; i++ ){
                result +=charList[i];
            }
            for (int i = 87; i < 123; i++ ){
                result +=charList[i];
            }
            System.out.println(result);
            file.close();
        }
        catch (IOException exc){}
    }
}
