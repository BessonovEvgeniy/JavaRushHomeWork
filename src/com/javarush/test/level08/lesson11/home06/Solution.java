package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        Human child1 = new Human("Masha", false , 20 , new ArrayList<Human>());
        Human child2 = new Human("Misha", true , 22 , new ArrayList<Human>());
        Human child3 = new Human("Sasha", true , 26 , new ArrayList<Human>());

        ArrayList<Human> children = new ArrayList<>();
        children.add(child1);
        children.add(child2);
        children.add(child3);

        Human mother = new Human("Vita", false, 23, children);
        Human father = new Human("Grisha", true, 27, children);

        ArrayList<Human> f = new ArrayList<>();
        ArrayList<Human> m = new ArrayList<>();
        m.add(mother);
        f.add(father);
        Human gm_mother = new Human("Valya", false, 29, m);
        Human gm_father = new Human("Anatolij", false, 40, m);

        Human gf_mother = new Human("Nina", false, 29, f);
        Human gf_father = new Human("Mihail", false, 40, f);


        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);

        System.out.println(mother);
        System.out.println(gm_mother);
        System.out.println(gm_father);

        System.out.println(father);
        System.out.println(gf_mother);
        System.out.println(gf_father);



    }

    public static class Human
    {

            String name;
            boolean sex;
            int age;
            ArrayList<Human> children;

        public Human(String name, boolean sex, int age, ArrayList<Human> children){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
