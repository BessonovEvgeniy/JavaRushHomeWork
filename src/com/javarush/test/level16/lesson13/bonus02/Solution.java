package com.javarush.test.level16.lesson13.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

/* Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. нить 1 должна бесконечно выполняться;
1.2. нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. нить 3 должна каждые полсекунды выводить "Ура";
1.4. нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. нить 5 должна читать с консоли цифры пока не введено слово "N", а потом вывести в консоль сумму введенных цифр.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.
Подсказка: Нить 4 можно проверить методом isAlive()
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<Thread>(5);

    static {
        threads.add(new InfinityRun());
        threads.add(new Interrupt());
        threads.add(new Hurray());
        threads.add(new StopThread());
        threads.add(new ReadNums());
    }

    //1------------------------------------------------------
    static class InfinityRun extends Thread{
        public void run(){
            while(true){}
        }
    }
    //2------------------------------------------------------
    static class Interrupt extends Thread{
        public void run() {
            try{
                while(true){
                    sleep(500);
                }
            }
            catch(InterruptedException exc){
                System.out.println("InterruptedException");
            }
        }
    }
    //3------------------------------------------------------
    static class Hurray extends Thread{
        public void run() {
            try {
                while (true) {
                    System.out.println("Ура");
                    this.sleep(500);
                }
            }
            catch (InterruptedException exc){
                System.out.println("InterruptedException");
            }
        }
    }
    //4------------------------------------------------------
    static class StopThread extends Thread implements Message{
        public void run() {
            while (!isInterrupted()) {
            }
        }
        public void showWarning() throws InterruptedException {
            if (this.isAlive()){
                this.interrupt();
                this.join();
            }
        }
    }
    //5------------------------------------------------------
    static class ReadNums extends Thread{
        String str;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<Integer>();

        public void run() {
            try {
                int sum = 0;
                str = reader.readLine();
                while (!str.equals("N")) {
                    sum = sum + Integer.parseInt(str);
                    str = reader.readLine();
                }
                System.out.println(sum);
            }
            catch (IOException exc) { }
        }
    }
}
