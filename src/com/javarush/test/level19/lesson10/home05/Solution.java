package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader fileIn = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));

            FileOutputStream fileOut = new FileOutputStream(args[1]);

            while(fileIn.ready()){

                String[] words = fileIn.readLine().split(" ");

                for (String word : words){
                    for (Integer i = 0; i < 10; i++){
                        if (word.contains(i.toString())){
                            fileOut.write(word.trim().concat(" ").getBytes());
                            break;
                        }
                    }
                }
            }

            fileIn.close();
            fileOut.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
