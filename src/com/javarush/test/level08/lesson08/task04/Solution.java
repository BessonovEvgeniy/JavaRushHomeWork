package com.javarush.test.level08.lesson08.task04;

import java.util.*;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{

    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
       map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("Alex", new Date("DECEMBER 1 1987"));
        map.put("Jack", new Date("FEBRUARY 1 1987"));
        map.put("Vasja", new Date("MARCH 1 1987"));
        map.put("Max", new Date("MAY 1 1987"));

        map.put("Artem", new Date("JULY 1 1987"));
        map.put("Alina", new Date("AUGUST 1 1987"));
        map.put("Artek", new Date("SEPTEMBER 1 1987"));
        map.put("Ambroz", new Date("OCTOBER 1 1987"));
        map.put("Arax", new Date("NOVEMBER 1 1987"));

        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map){
        Set<String> keys = map.keySet();
        Iterator item = keys.iterator();
        while(item.hasNext()){
            String key = (String) item.next();
            if (map.containsKey(key)) {
                if (map.get(key).getMonth() > 4 && map.get(key).getMonth() < 8)
                {
                    item.remove();
                }
            }
        }
    }
}
