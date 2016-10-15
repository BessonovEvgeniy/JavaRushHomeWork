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
    abstract class CrUD {
        //Преобразование данных параметров согласно требуемому формату
        abstract void readParams(String[] args);
        abstract String readFileName();
        abstract void updateData(String fileName, String record, String id) throws IOException;
    }
    public class DoTask extends CrUD{
        private String option;
        private String id = "";
        private StringBuilder productName = new StringBuilder();
        private String price;
        private String quantity;
        private String record = "";
        private String fileName = "";
        private int posId = 0;
        DoTask(String[] args) throws IOException{
            readParams(args);
            fileName = readFileName();
            updateData(fileName,record,id);
        }
        //--------------------------------------------------------------------------------------------------------------
        public void readParams(String[] args){
            option= args[0];
            id = args[1];
            if (option.equals("-u")) {
                for (int i = 2; i < args.length - 2; i++) {
                    productName.append(args[i] + " ");
                }
                productName.deleteCharAt(productName.length()-1);
                price = args[args.length - 2];
                quantity = args[args.length - 1];
                //-----------------------Проверка введенных данных на корректность ввода--------------------------------
                if (productName.length() > 30) {
                    productName.substring(0,29);
                }
                if (price.length() > 8) {
                    price = price.substring(0, 8);
                }
                if (quantity.length() > 4) {
                    quantity = quantity.substring(0, 4);
                }
                //--------------------------------Финальная строка для записи-------------------------------------------
                record = String.format("%-8s%-30s%-8s%-4s%n",id,productName,price,quantity);
            }
            else if(option.equals("-d")){
                //----------------------------------Пустая строка для записи--------------------------------------------
                record = "";
            }
        }
        //--------------------------------------------------------------------------------------------------------------
        public String readFileName(){
            String fileName = "";
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                fileName = reader.readLine();
                reader.close();
            }
            catch(IOException exc){}
            return fileName;
        }
        //--------------------------------------------------------------------------------------------------------------
        public int findId(String fileName, String id) throws IOException{
            int posId = 0;
            String line;
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            while ((line = reader.readLine()) != null) {
                if (line.split(" ")[0].equals(id)) {
                    break;
                }
                posId++;
            }
            reader.close();
            return posId;
        }
        //--------------------------------------------------------------------------------------------------------------
        public void updateData(String fileName, String record, String id) throws IOException {
            int posId = findId(fileName,id);
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            StringBuilder outString = new StringBuilder();
            String line;
            int stringCounter = 0;
            while((line = reader.readLine()) != null){
                if (stringCounter == posId){
                    outString.append(record);
                }
                else{
                    outString.append(line+"\n");
                }
                stringCounter++;
            }
            reader.close();
            //Блок записи новой строки
            FileOutputStream outFile = new FileOutputStream(fileName);
            outFile.write(outString.toString().getBytes());
            outFile.close();
        }
    }
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        CrUD crUD = solution.new DoTask(args);
    }
}