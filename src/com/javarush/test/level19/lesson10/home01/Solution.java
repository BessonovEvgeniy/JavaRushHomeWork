package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream(args[0]);

            BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));

            Map<String, Double> sortedMap = new TreeMap<String, Double>();

            String[] line;
            String name;
            Double value;

            while (reader.ready()){


                line = reader.readLine().split(" ");
                name = line[0];
                value = Double.parseDouble(line[1]);

                if (sortedMap.containsKey(name)){
                    sortedMap.put(name, sortedMap.get(name) + value);
                }
                else {
                    sortedMap.put(name, value);
                }
            }

            for (Map.Entry<String, Double> item : sortedMap.entrySet())
                System.out.println(item.getKey() + " " + item.getValue());

            reader.close();
            fileInputStream.close();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
