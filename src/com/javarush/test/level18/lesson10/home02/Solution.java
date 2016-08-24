package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        String fileName = args[0];
        try {
            FileInputStream file = new FileInputStream(fileName);

            while(file.available()>0){
                byte[] buffer = new byte[file.available()];
                int count = file.read(buffer);
                int allChars = buffer.length;
                int allSpaces = 0;
                for (byte item : buffer){
                    if (item == 32 ){
                        allSpaces++;
                    }
                }
                System.out.println((float) Math.round((float)allSpaces/allChars*10000)/100);
            }
            file.close();
        }
        catch (IOException exc){}

    }
}
