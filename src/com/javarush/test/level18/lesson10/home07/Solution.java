package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки. Не использовать try-with-resources

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        int myId = Integer.parseInt(args[0]);
        String currStr;
        String[] params;
        int id;
        String productName;
        double price;
        int quantity;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            String fileName = reader.readLine();
            FileReader file = new FileReader(fileName);
            Scanner in = new Scanner(file);

            while (in.hasNext())
            {
                currStr = in.nextLine();
                if (currStr.isEmpty()) {
                    continue;
                }

                productName = "";
                params = currStr.split(" ");

                id = Integer.parseInt(params[0]);
                if (params.length > 4){
                    for (int i = 1; i < params.length - 2; i++) {
                        productName = productName + params[i] + " ";
                    }
                    productName.substring(0,productName.length()-2);
                }
                else{
                    productName = params[1];
                }
                price = Double.parseDouble(params[params.length-2]);
                quantity = Integer.parseInt(params[params.length-1]);

                if (id == myId){
                    System.out.println(id);
                    System.out.println(productName);
                    System.out.println(price);
                    System.out.println(quantity);
                }
            }
            reader.close();
            file.close();
            in.close();
        }
        catch(IOException exc){}
    }
}
