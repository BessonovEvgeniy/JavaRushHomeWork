package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String fileName1 = reader.readLine();
            String fileName2 = reader.readLine();
            String fileName3 = reader.readLine();

            FileOutputStream outFile1 = new FileOutputStream(fileName1);
            FileInputStream inFile2 = new FileInputStream(fileName2);
            FileInputStream inFile3 = new FileInputStream(fileName3);

            while(inFile2.available() > 0){
                byte[] buffer = new byte[inFile2.available()];
                inFile2.read(buffer);
                outFile1.write(buffer);
            }

            while(inFile3.available() > 0){
                byte[] buffer = new byte[inFile3.available()];
                inFile3.read(buffer);
                outFile1.write(buffer);
            }

            reader.close();
            inFile2.close();
            inFile3.close();
            outFile1.close();
        }
        catch (IOException exc){

        }
    }
}
