package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

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
        String option = args[0];
        String productName = "";
        for (int i = 1; i < args.length-2; i++){
            productName = productName + args[i] + " ";
        }
        productName = productName.substring(0,productName.length()-1);//Удаление последнего пробела
        String price = args[args.length-2];
        String quantity = args[args.length-1];
        int id = 0;
        String record;
        //Проверка введенных данных на корректность ввода
        if (!option.equals("-c")) {
            return;
        }
        if (productName.length() > 30) {
            productName = productName.substring(0, 30);
        }
        if (price.length() > 8) {
            price = price.substring(0, 8);
        }
        if (quantity.length() > 4) {
            quantity = quantity.substring(0, 4);
        }
        //Чтение имени файла для парсинга
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        //Работа с файлом
        FileReader infile = new FileReader(fileName);
        BufferedReader fileReader = new BufferedReader(infile);
        //Преобразование данных к необходимому типу данных
        String line;
        while ((line = fileReader.readLine()) != null) {
            if (line.isEmpty()){
                continue;
            }
            //Считываем номер id записи и ищем максимальный
            record = line.substring(0,8).replaceAll("\\s+","");
            if(id < Integer.parseInt(record)) {
                id = Integer.parseInt(record);
            }
        }
        fileReader.close();
        infile.close();
        reader.close();
        //Максимальный id + 1
        id++;
        //Преобразование данных к необходимому формату. Добавляем пробелы.
        record = String.format("%-8s%-30s%-8s%-4s",id,productName,price,quantity);
        //Запись данных в файл
        FileWriter outfile = new FileWriter(fileName,true);
        BufferedWriter writer = new BufferedWriter(outfile);
        writer.newLine();
        writer.write(record);
        writer.close();
        outfile.close();
    }
}
