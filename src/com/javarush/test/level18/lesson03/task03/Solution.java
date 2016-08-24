package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream fileReader = new FileInputStream (fileName);

        int[] list = new int[255];
        int current_byte;
        int max_byte_repeat_index = 0;

        while(fileReader.available() > 0){
            current_byte = fileReader.read();
            list[current_byte]++;
            if (max_byte_repeat_index < list[current_byte]){
                max_byte_repeat_index = list[current_byte];
            }
        }
        fileReader.close();
        for (int i = 1; i < list.length; i++){
            if (list[i] == max_byte_repeat_index){
                System.out.println(i);
            }
        }

    }
}
