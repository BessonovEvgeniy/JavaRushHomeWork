package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String fileName = reader.readLine();
            FileWriter outStream = new FileWriter(fileName);

            String str = "";
            while(!str.equals("exit")){
                str = reader.readLine();
                list.add(str);
            }
            for (String item : list)
            {
                outStream.write(item);
                outStream.write(System.getProperty("line.separator"));
            }
            outStream.close();
        }
        catch (Exception ex){
            System.out.println(ex);
        }
    }
}
