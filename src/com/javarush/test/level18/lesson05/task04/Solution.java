package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName1 = reader.readLine();
            String fileName2 = reader.readLine();

            FileInputStream inputFile = new FileInputStream(fileName1);
            FileOutputStream outputFile = new FileOutputStream(fileName2);
            
            int fileSize = inputFile.available();
            byte[] buffer = new byte[fileSize];
            inputFile.read(buffer);

            for (int i = fileSize-1; i>-1; i--) {
                outputFile.write(buffer[i]);
            }
            reader.close();
            inputFile.close();
            outputFile.close();
        }
        catch(IOException exc){}
    }
}
