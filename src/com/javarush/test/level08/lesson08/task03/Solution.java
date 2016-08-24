package com.javarush.test.level08.lesson08.task03;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    /*public static void main(String[] args) {
        HashMap<String, String> map = createMap();
        int rez1 = getCountTheSameFirstName(map, "Павел");
    }
*/

    public static HashMap<String, String> createMap()
    {
        HashMap <String, String> map = new HashMap<String, String>();
        map.put("Бессонов","Евгений");
        map.put("Бессонова","Валентина");
        map.put("Гашок","Екатерина");
        map.put("Сидоренко","Павел");
        map.put("Петренко","Павел");

        map.put("Иванов","Павел");
        map.put("Гнатенко","Павел");
        map.put("Игнатенко","Павел");
        map.put("Вершинин","Павел");
        map.put("Вершок","Павел");

        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        Collection<String> list = map.values();
        int counter = 0;
        for (String item : list){
            if (item.equals(name)){
                counter++;
            }
        }
        return counter;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName)
    {
        if (map.containsKey(lastName)){
            return 1;
        }
        return 0;
    }
}
