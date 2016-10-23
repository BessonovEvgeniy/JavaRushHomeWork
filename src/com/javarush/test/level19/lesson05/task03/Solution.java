package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName1 = reader.readLine();
            String fileName2 = reader.readLine();
            BufferedReader inFile = new BufferedReader(new FileReader(fileName1));
            FileWriter outFile = new FileWriter(fileName2);

            while (inFile.ready()){
                String[] values = inFile.readLine().split(" ");

                StringBuilder line = new StringBuilder();
                Integer num;
                for (String item : values){
                    try{
                        num = Integer.parseInt(item);
                        line.append(num).append(" ");
                    }
                    catch (Exception e){}
                }
                try {
                    outFile.write(line.toString());
                }
                catch (Exception e){}
            }

            reader.close();
            inFile.close();
            outFile.close();
        }
        catch (Exception e){}

    }
}
