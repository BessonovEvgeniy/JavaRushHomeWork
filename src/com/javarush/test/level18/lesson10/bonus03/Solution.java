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
        String option = args[0];
        String id = "";
        String productName = "";
        String price;
        String quantity;
        String record;
        //Парсинг введенных данных
        if (option.equals("-u")) {
            id = args[1];
            for (int i = 2; i < args.length-2; i++){
                productName = productName + args[i] + " ";
            }
            productName = productName.substring(0,productName.length()-1);//Удаление последнего пробела
            price = args[args.length-2];
            quantity = args[args.length-1];
            //Проверка введенных данных на корректность ввода
            if (productName.length() > 30) {
                productName = productName.substring(0, 30);
            }
            if (price.length() > 8) {
                price = price.substring(0, 8);
            }
            if (quantity.length() > 4) {
                quantity = quantity.substring(0, 4);
            }
        }
        //Чтение имени файла для парсинга
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        //Работа с файлом
        FileReader infile = new FileReader(fileName);
        BufferedReader fileReader = new BufferedReader(infile);
        //Преобразование данных к необходимому типу данных
        String line;
        String idTemp;
        while ((line = fileReader.readLine()) != null) {
            idTemp = line.substring(0,8).replaceAll("\\s+","");
            if (id.equals(idTemp)){
                fileReader.close();
                infile.close();
                reader.close();
                if (option.equals("-d")){

                }
                else if (option.equals("-u")){

                }
            }
        }

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