package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;




/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream fileReader = new FileInputStream (fileName);

        boolean[] list = new boolean[255];
        int current_byte;
        int min_byte_repeat_index = 0;

        while(fileReader.available() > 0){
            current_byte = fileReader.read();
            list[current_byte]=true;
        }
        fileReader.close();
        for (int i = 0; i < list.length; i++){
            if (list[i]){
                System.out.println(i);
            }
        }
    }
}
