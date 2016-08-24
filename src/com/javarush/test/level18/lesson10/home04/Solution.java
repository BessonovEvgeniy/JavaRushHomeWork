package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            String fileName1 = reader.readLine();
            String fileName2 = reader.readLine();
            FileOutputStream outFile1;

            FileInputStream inFile1 = new FileInputStream(fileName1);
            byte[] buffer1 = new byte[inFile1.available()];
            FileInputStream inFile2 = new FileInputStream(fileName2);
            byte[] buffer2 = new byte[inFile2.available()];

            if (buffer2.length > 0){
                inFile2.read(buffer2);
                if (buffer1.length > 0){
                    inFile1.read(buffer1);
                }
                outFile1 = new FileOutputStream(fileName1);
                outFile1.write(buffer2);
                outFile1.write(buffer1);
                outFile1.close();
            }
            reader.close();
            inFile1.close();
            inFile2.close();
        }
        catch(IOException exc){}
    }
}
