package com.javarush.test.level18.lesson10.home08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();


    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        try{
            while (!(fileName = reader.readLine()).equals("exit")){
                resultMap.put(fileName,null);
                new ReadThread(fileName).run();
            }
            for (Map.Entry<String,Integer> item : resultMap.entrySet()){
                System.out.println(item.getKey() + " " + item.getValue());
            }
        }
        catch (IOException exc){}
    }

    public static class ReadThread extends Thread {
        FileInputStream file;
        String fileName;
        public ReadThread(String fileName) {
            try {
                file = new FileInputStream(fileName);
                this.fileName = fileName;
            }
            catch (IOException exc){}
        }
        @Override
        public void run() {
            int[] readByte = new int[255];
            int index;
            int maxRepeats = 0;
            try {
                while (file.available() > 0) {
                    index = file.read();
                    readByte[index]++;
                    if (readByte[index] > maxRepeats){
                        maxRepeats = readByte[index];
                        resultMap.put(fileName,index);
                    }
                }
            }
            catch (IOException exc){}
        }
    }
}
