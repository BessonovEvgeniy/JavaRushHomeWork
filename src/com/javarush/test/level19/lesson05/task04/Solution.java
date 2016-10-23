package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName1 = reader.readLine();
            String fileName2 = reader.readLine();
            BufferedReader inFile = new BufferedReader(new FileReader(fileName1));
            FileWriter outFile = new FileWriter(fileName2);

            while (inFile.ready()){
                String line = inFile.readLine().replace(".","!");
                try {
                    outFile.write(line+"\n");
                }
                catch (Exception e){}
            }

            reader.close();
            inFile.close();
            outFile.close();
        }
        catch (Exception e){}
    }
}
