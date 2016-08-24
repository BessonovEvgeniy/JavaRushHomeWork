package com.javarush.test.level18.lesson03.task01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream fileReader = new FileInputStream (fileName);
        int max_byte = 0;
        int current_byte;

        while(fileReader.available() > 0){
            current_byte = fileReader.read();
            if (current_byte > max_byte){
                max_byte = current_byte;
            }
        }
        fileReader.close();
        System.out.println(max_byte);
    }
}
