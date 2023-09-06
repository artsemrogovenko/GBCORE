package ru.geekbrains.lesson3;

import java.util.ArrayList;
import java.util.List;
/**
 * TODO: Доработать в рамках домашней работы
 */
public class Freelancer extends Employee{

    private Freelancer(String surName, String name, double salary){
        super(surName, name, salary);
        //System.out.println("Constructor - Worker");
    }

    public static Employee getInstance(){
        return new Freelancer(
                surNames[random.nextInt(surNames.length)],
                names[random.nextInt(surNames.length)],
                (20.8 * 8) * rand(500, 800));
    }

    public static List<Employee> getEmployees(int count){
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < count; i++)
            employees.add(getInstance());
        return employees;
    }

    @Override
    public double calculateSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s; Фрилансер; Среднемесячная заработная плата: %.2f (руб.)" + " телефон +%s",
                surName, name, salary, phone);
    }
}
