package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public volatile static List<Person> allPeople = new ArrayList<Person>();
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
            switch (args[0]) {
                case "-c":
                    for (int i = 1; i < (args.length-1); i=i+3) {
                        name = args[i];
                        date = dateFormatIn.parse(args[i+2]);
                        //Создание нового пользователя
                        if (args[i+1].equals("м"))
                            allPeople.add(Person.createMale(name, date));
                        else
                            allPeople.add(Person.createFemale(name, date));
                        System.out.println(allPeople.size() - 1);
                    }
                    break;
                case "-u":
                    for (int i = 1; i < args.length-1; i=i+4) {
                        //Обновление данных пользователя
                        id = Integer.parseInt(args[i]);
                        name = args[i + 1];
                        date = dateFormatIn.parse(args[i + 3]);
                        if (args[i + 2].equals("м"))
                            allPeople.set(id, Person.createMale(name, date));
                        else
                            allPeople.set(id, Person.createFemale(name, date));
                        System.out.println(id);
                    }
                    break;
                case "-d":
                    for (int i = 1; i < args.length; i++) {
                        //Чтение ID
                        id = Integer.parseInt(args[i]);
                        person = allPeople.get(id);
                        //Логическое удаление данных пользователя
                        person.setName(null);
                        person.setSex(null);
                        person.setBirthDay(null);
                    }
                    break;
                case "-i":
                    for (int i = 1; i < args.length; i++) {
                        //Вывод информации о пользователе
                        id = Integer.parseInt(args[i]);
                        person = allPeople.get(id);
                        String sex = person.getSex().equals(Sex.MALE) ? "м" : "ж";
                        System.out.println(person.getName() + " " + sex + " " + " " + dateFormatOut.format(person.getBirthDay()));
                    }
                    break;
            }
        }
        catch (ParseException exc){}
    }
}
