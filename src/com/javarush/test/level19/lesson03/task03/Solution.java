package com.javarush.test.level19.lesson03.task03;

/* Адаптация нескольких интерфейсов
Адаптировать IncomeData к Customer и Contact.
Классом-адаптером является IncomeDataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
Дополнить телефонный номер нулями до 10 цифр при необходимости (смотри примеры)
Обратите внимание на формат вывода фамилии и имени человека
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static class IncomeDataAdapter implements Customer, Contact{

        private IncomeData incomeData;

        IncomeDataAdapter(IncomeData iData){
            this.incomeData = iData;
        }
        public String getCompanyName(){
            return incomeData.getCompany();
        }
        public String getCountryName(){
            return countries.get(incomeData.getCountryCode());
        }
        public String getName(){
            return incomeData.getContactLastName() + ", " + incomeData.getContactFirstName() ;
        }
        public String getPhoneNumber(){
            String phoneNumber = Integer.toString(incomeData.getPhoneNumber());
            while (phoneNumber.length()<10){
                phoneNumber = "0" + phoneNumber;
            }
            phoneNumber = String.format("+%s(%s)%s-%s-%s",incomeData.getCountryPhoneCode(),phoneNumber.substring(0,3),phoneNumber.substring(3,6),phoneNumber.substring(6,8),phoneNumber.substring(8,10));
            return phoneNumber;
        }
    }

    public static interface IncomeData {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        int getCountryPhoneCode();      //example 38
        int getPhoneNumber();           //example 501234567
    }
    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }
    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
    public static void main(String[] args) throws Exception {
        IncomeData incomeData = new IncomeData() {
            @Override
            public String getCountryCode(){
                return "UA";
            }

            @Override
            public String getCompany() {
                return "JavaRush Ltd.";
            }

            @Override
            public String getContactFirstName() {
                return "Ivan";
            }

            @Override
            public String getContactLastName() {
                return "Ivanov";
            }

            @Override
            public int getCountryPhoneCode() {
                return 38;
            }

            @Override
            public int getPhoneNumber() {
                return 501234567;
            }
        };
        Contact contact = new IncomeDataAdapter(incomeData);
        Customer customer = new IncomeDataAdapter(incomeData);
        //CheckOut Examples
        String companyName = customer.getCompanyName();        //example JavaRush Ltd.
        String countryName = customer.getCountryName();        //example Ukraine
        String name = contact.getName();                       //example Ivanov, Ivan
        String phoneNumber = contact.getPhoneNumber();         //example +38(050)123-45-67
    }
}