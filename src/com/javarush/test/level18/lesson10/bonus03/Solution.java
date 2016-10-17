package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //--------------------------------------------------------------------------------------------------------------
        String id;
        StringBuilder productName = new StringBuilder();
        String record = "";
        String line;
        String fileName;
        //-------------------------------Считывание параметров работы программы-----------------------------------------
        id = args[1];
        if (args[0].equals("-u")) {
                for (int i = 2; i < args.length - 2; i++) {
                    productName.append(args[i] + " ");
                }
                productName.deleteCharAt(productName.length()-1);
            //-----------------------------------Финальная строка для записи--------------------------------------------
            record = String.format("%-8s%-30s%-8s%-4s",args[1],productName,args[args.length-2],args[args.length-1]);
        }
        //-----------------------------------Считывание имени рабочего файла--------------------------------------------
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            fileName = reader.readLine();
            reader.close();
            //----------------------------------------------------------------------------------------------------------
            reader = new BufferedReader(new FileReader(fileName));
            StringBuilder outString = new StringBuilder();
            while((line = reader.readLine()) != null){
                if(line.substring(0,8).trim().equals(id)){
                    if (!record.isEmpty()) {
                        outString.append(record + "\n");
                    }
                }
                else {
                    outString.append(line+"\n");
                }
            }
            FileOutputStream outFile = new FileOutputStream(fileName);
            outFile.write(outString.toString().getBytes());
            reader.close();
            outFile.close();
            //----------------------------------------------------------------------------------------------------------
        }
        catch(IOException exc){}
    }
}