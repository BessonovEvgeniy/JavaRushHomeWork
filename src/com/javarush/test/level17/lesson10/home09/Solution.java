package com.javarush.test.level17.lesson10.home09;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            //-----1. Считать с консоли 2 имени файла------------------------------------
            Scanner breader1 = new Scanner(new File(reader.readLine()));
            Scanner breader2 = new Scanner(new File(reader.readLine()));
            //2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
            while (breader1.hasNext()) {
                allLines.add(breader1.nextLine());
            }
            while (breader2.hasNext()) {
                forRemoveLines.add(breader2.nextLine());
            }
            reader.close();
            breader1.close();
            breader2.close();
            //----------------------------------------------------------------------------
            new Solution().joinData();
        }
        catch (CorruptedDataException exc){}
        catch (IOException exc){}
    }

    public void joinData () throws CorruptedDataException {
        //Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
        List<String> allLinesBuf = allLines;
        List<String> forRemoveLinesBuf = forRemoveLines;
        //3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
        if (allLinesBuf.containsAll(forRemoveLinesBuf)){
            allLinesBuf.removeAll(forRemoveLinesBuf);
        }
        //4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
        else {
            //Удаление всех элементов forRemoveLinesBuf в allLinesBuf
            allLinesBuf.retainAll(forRemoveLinesBuf);
            //Сравнение размеров (содержит ли allLinesBuf каких-либо строки forRemoveLinesBuf?)
            if (allLinesBuf.size() == allLines.size()){
                //4.1. очистить allLines от данных
                allLines.clear();
                //4.2. выбросить исключение CorruptedDataException
                throw new CorruptedDataException();
            }
        }
    }
}