package com.javarush.test.level19.lesson10.home04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.concurrent.ExecutionException;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки. Не использовать try-with-resources

Пример: words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А Б Д  //2 слова - подходит, выводим
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        try{
            String fileName = console.readLine();

            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

            String line;

            Integer counter;

            while(reader.ready()){

                counter = 0;

                line = reader.readLine();

                for (String item : words) {

                    String[] splitWords = line.split(" ");

                    for (String word : splitWords){
                        if (word.trim().equals(item)){
                            counter++;
                            break;
                        }
                    }
                }
                if (counter == 2){
                    System.out.println(line);
                }
            }

            console.close();
            reader.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
