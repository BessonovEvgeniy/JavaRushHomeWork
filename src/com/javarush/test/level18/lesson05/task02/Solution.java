package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки. Не использовать try-with-resources

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String fileName = reader.readLine();
            FileInputStream inputStream = new FileInputStream(fileName);
            int counter = 0;
            while (inputStream.available()>0){
                int currByte = inputStream.read();
                if (currByte == 44){
                    counter++;
                }
            }
            System.out.println(counter);
            inputStream.close();
            reader.close();
        }
        catch (IOException exc){

        }

    }
}
