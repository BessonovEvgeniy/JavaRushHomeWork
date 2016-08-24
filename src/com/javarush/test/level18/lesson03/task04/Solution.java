package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
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
        int min_byte_repeat_index = 0;

        while(fileReader.available() > 0){
            current_byte = fileReader.read();
            list[current_byte]++;
            if ((min_byte_repeat_index > list[current_byte])&&(list[current_byte]!=0)){
                min_byte_repeat_index = list[current_byte];
            }
        }
        fileReader.close();
        for (int i = 1; i < list.length; i++){
            if (list[i] == min_byte_repeat_index){
                System.out.println(i);
            }
        }
    }
}
