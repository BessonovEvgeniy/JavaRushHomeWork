package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String fileName1 = reader.readLine();
            String fileName2 = reader.readLine();
            String str;

            BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));
            FileWriter fileWriter = new FileWriter(fileName2, true);

            int numI;
            while ((str = fileReader.readLine()) != null ){
                String[] nums = str.split(" ");
                for (String item : nums){
                    numI = Math.round(Float.parseFloat(item));
                    fileWriter.write(String.valueOf(numI)+" ");
                }
            }
            reader.close();
            fileReader.close();
            fileWriter.close();
        }
        catch(IOException exc){}
    }
}
