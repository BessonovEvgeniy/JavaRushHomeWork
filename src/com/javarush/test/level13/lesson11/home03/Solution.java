package com.javarush.test.level13.lesson11.home03;

/* Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть освободить ресурсы. Закрыть поток чтения с файла и поток ввода с клавиатуры.
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.OutputStream;

public class Solution {
    public static void main(String[] args)  {
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();

            InputStream inStream = new FileInputStream(fileName);

            while (inStream.available() > 0){
                int data = inStream.read();
                System.out.print((char)data);
            }
            inStream.close(); //закрываем потоки
            reader.close();
        }
        catch (Exception ex){
            System.out.println("Где то не работает.");
        }

    }
}
