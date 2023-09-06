package ru.geekbrains.lesson3;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Program {

    public static void main(String[] args) {
//генерация в заданом количестве
        RandomEmployee.generate(7);
        System.out.println();
//сортаровка по фамилии
        RandomEmployee.sortbyNames();
        RandomEmployee.showEmployees();
        System.out.println();
//сортирока по номеру
        RandomEmployee.sortbyPhones();
        RandomEmployee.showEmployees();
    }

}
