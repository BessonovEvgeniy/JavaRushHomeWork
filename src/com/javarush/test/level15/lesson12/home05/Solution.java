package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/
public class Solution {
    public Solution(Object a){  }
    public Solution(double a, double b){  }
    public Solution(Integer a, Integer b){  }
    protected Solution(int a){  }
    protected Solution(double a){  }
    protected Solution(Integer a){  }
    private Solution(short b){  }
    private Solution(byte b){  }
    private Solution(long b){  }
    Solution(){  }
    Solution(double a, int b){  }
    Solution(int a, double b){}
}