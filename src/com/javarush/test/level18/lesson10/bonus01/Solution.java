package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        try {
            FileInputStream inFile = new FileInputStream(args[1]);
            FileOutputStream outFile = new FileOutputStream(args[2]);
            if (inFile.available()>0){
                byte[] buffer = new byte[inFile.available()];
                inFile.read(buffer);
                if (args[0].equals("-e")) {
                    //Код Юлия Цезаря
                    for(int i = 0; i < buffer.length; i++){
                        buffer[i] = (byte)(buffer[i] + 1);
                    }
                    outFile.write(buffer);
                }
                else if (args[0].equals("-d")) {
                    //Дешивровка кода Юлия Цезаря
                    for(int i = 0; i < buffer.length; i++){
                        buffer[i] = (byte)(buffer[i] - 1);
                    }
                    outFile.write(buffer);
                }
            }
            inFile.close();
            outFile.close();
        }
        catch (IOException exc){ }
    }
}
