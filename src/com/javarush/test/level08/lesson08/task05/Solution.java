package com.javarush.test.level08.lesson08.task05;

import java.util.*;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution {

    public static HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Pupkin","Vasja");
        map.put("Pupkina","Klara");
        map.put("Dyda","Vasja");
        map.put("Radovkin","Ivan");
        map.put("Pupkind","Ivan");

        map.put("Zhalilo","Alex");
        map.put("Bessonov","Evgeniy");
        map.put("Girkin","Sergey");
        map.put("Samukin","Oleg");
        map.put("Gyliver","Vasja");

        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        HashMap<String, String> copy_map = new HashMap<>(map);
        Collection<String> val = copy_map.values();

        Iterator item = val.iterator();
        while (item.hasNext()) {
            String name = item.next().toString();
            item.remove();
            if (val.contains(name)){
                removeItemFromMapByValue(map, name);
            }
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
