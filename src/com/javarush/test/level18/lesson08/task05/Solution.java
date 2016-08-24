package com.javarush.test.level18.lesson08.task05;

import java.util.List;

/* Таблица
Измените класс TableInterfaceWrapper так, чтобы он стал Wrapper-ом для ATableInterface.
Метод setModel должен вывести в консоль количество элементов в новом листе перед обновлением модели
Метод getHeaderText должен возвращать текст в верхнем регистре - используйте метод toUpperCase()
*/

public class Solution {
    public class TableInterfaceWrapper implements ATableInterface{

        private ATableInterface aTableInterface;
        private List rows;
        private String newHeaderText;

        TableInterfaceWrapper(ATableInterface aTableInterface){
            this.aTableInterface = aTableInterface;
        }

        @Override
        public void setModel(List rows) {
            System.out.println(rows.size());
            this.rows = rows;
            this.aTableInterface.setModel(rows);
        }
        @Override
        public String getHeaderText() {
            newHeaderText = aTableInterface.getHeaderText();
            return newHeaderText.toUpperCase();
        }
        @Override
        public void setHeaderText(String newHeaderText) {
            this.newHeaderText = newHeaderText;
            aTableInterface.setHeaderText(newHeaderText);
        }
    }

    public interface ATableInterface {
        void setModel(List rows);
        String getHeaderText();
        void setHeaderText(String newHeaderText);
    }
}