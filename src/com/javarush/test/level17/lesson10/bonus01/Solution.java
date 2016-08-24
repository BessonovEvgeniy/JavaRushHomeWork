package com.javarush.test.level17.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        int id;
        String name;
        Date date;
        Person person;
        SimpleDateFormat dateFormatIn = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat dateFormatOut = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        try {
            switch (args[0])
            {
                case "-c":
                    name = args[1];
                    date = dateFormatIn.parse(args[3]);
                    //Создание нового пользователя
                    if (args[2].equals("м"))
                        allPeople.add(Person.createMale(name,date));
                    else
                        allPeople.add(Person.createFemale(name,date));
                    System.out.println(allPeople.size() - 1);
                    break;
                case "-u":
                    //Обновление данных пользователя
                    id = Integer.parseInt(args[1]);
                    name = args[2];
                    date = dateFormatIn.parse(args[4]);
                    if (args[3].equals("м"))
                        allPeople.set(id, Person.createMale(name,date));
                    else
                        allPeople.set(id, Person.createFemale(name,date));
                    break;
                case "-d":
                    //Чтение ID
                    id = Integer.parseInt(args[1]);
                    person = allPeople.get(id);
                    //Логическое удаление данных пользователя
                    person.setName(null);
                    person.setSex(null);
                    person.setBirthDay(null);
                    break;
                case "-i":
                    //Вывод информации о пользователе
                    id = Integer.parseInt(args[1]);
                    person = allPeople.get(id);
                    String sex = person.getSex().equals(Sex.MALE) ? "м" : "ж";
                    System.out.println(person.getName() + " " + sex + " " + " " + dateFormatOut.format(person.getBirthDay()));
                    break;
            }
        }
        catch (ParseException exc){}
    }
}
