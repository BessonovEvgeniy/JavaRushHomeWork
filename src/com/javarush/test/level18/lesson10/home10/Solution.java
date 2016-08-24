package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        TreeMap<Integer,String> fileList = new TreeMap<>();
        String[] params = {"",""};
        String inFileName;
        String outFileName = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //Считываем по очереди имена файлов
        while (!(inFileName = reader.readLine()).equals("end")){
            params = inFileName.split("\\.part");
            //Запись данных о введенном файле <номер части, имя файла>
            fileList.put(Integer.parseInt(params[1]),inFileName);
        }
        outFileName = params[0];//Имя финального файла
        //Создание финального файла
        new File(outFileName);
        FileOutputStream outStreamFile = new FileOutputStream(outFileName);
        //Считыание/запись данных введенных файлов
        for(Map.Entry<Integer,String> part : fileList.entrySet()){
            FileInputStream inStreamFile = new FileInputStream(part.getValue());
            byte[] buffer = new byte[inStreamFile.available()];
            inStreamFile.read(buffer);
            outStreamFile.write(buffer);
            inStreamFile.close();
        }
        reader.close();
        outStreamFile.close();
    }
}
