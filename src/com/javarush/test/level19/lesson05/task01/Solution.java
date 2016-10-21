package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String fileName1 = reader.readLine();
            String fileName2 = reader.readLine();

            FileReader fileReader = new FileReader(fileName1);
            FileWriter fileWriter = new FileWriter(fileName2);

            boolean evenFlag = false;
            while (fileReader.ready()) {
                int data = fileReader.read(); //читаем один символ (char будет расширен до int)
                if (evenFlag) {
                    fileWriter.write(data); //пишем один символ (int будет обрезан/сужен до char)
                }
                evenFlag = !evenFlag;
            }
            fileReader.close();
            fileWriter.close();
            reader.close();
        }
        catch (Exception e){}
    }
}
