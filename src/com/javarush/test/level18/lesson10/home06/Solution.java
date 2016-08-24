package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        String fileName1 = args[0];
        try {
            FileInputStream file = new FileInputStream(fileName1);
            int[] charSet = new int[255];
            int[] charSetSort;
            int[] charCode = new int[255];
            int temp;
            int code;

            while (file.available()>0){
                code = file.read();
                charSet[code]++;
                charCode[code] = code;
            }

            charSetSort = charSet;
            for (int i = 0; i < charSet.length-1; i++){
                for (int j = i+1; j < charSet.length; j++){
                    if (charCode[i] > charCode[j]){

                        temp = charSetSort[i];
                        charSetSort[i] = charSetSort[j];
                        charSetSort[j] = temp;

                        code = charCode[i];
                        charCode[i] = charCode[j];
                        charCode[j] = code;

                    }
                }
            }

            for (int i = 0; i < charSet.length; i++){
                if (charSetSort[i] != 0){
                    System.out.println((char) charCode[i] + " " + charSetSort[i]);
                }
            }
            file.close();
        }
        catch (IOException exc){}


    }
}
