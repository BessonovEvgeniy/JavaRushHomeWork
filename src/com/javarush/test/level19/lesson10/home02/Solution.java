package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));

            Map<String, Double> sortedMap = new TreeMap<String, Double>();

            String[] line;
            String key;
            Double value;
            Double maxvalue;

            while (reader.ready()){

                line = reader.readLine().split(" ");

                key = line[0];
                value = Double.parseDouble(line[1]);

                if (sortedMap.containsKey(key)){
                    sortedMap.put(key, sortedMap.get(key) + value);
                }
                else {
                    sortedMap.put(key, value);
                }
            }

            Collection<Double> values = sortedMap.values();
            maxvalue = Collections.max(values);

            for (Map.Entry<String, Double> item : sortedMap.entrySet()){
                if (item.getValue().equals(maxvalue)) {
                    System.out.println(item.getKey());
                }
            }

            reader.close();

        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
