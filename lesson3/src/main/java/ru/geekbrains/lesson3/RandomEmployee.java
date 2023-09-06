package ru.geekbrains.lesson3;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.LinkedList;

public class RandomEmployee {
    //region сортировки
    private static List<Employee> _employees = new LinkedList<>();

    public static void sortbyPhones() {
        Collections.sort(_employees, new EmployeePhoneComparator());
    }

    public static void sortbyNames() {
        Collections.sort(_employees, new EmployeeNameComparator());
    }
    //endregion

    //region генерация и отображение

    /**
     * рандомное заполнение списка рабочими,
     *
     * @param count количество в штате
     */
    public static void generate(int count) {
        for (int i = 0; i < count; i++) {
            switch (new Random().nextInt(2)) {
                case 0:
                    _employees.add(Worker.getInstance());
                    break;
                case 1:
                    _employees.add(Freelancer.getInstance());
                    break;
            }
        }
        showEmployees();
    }

    /**
     * печать списка
     */
    public static void showEmployees() {
        for (Employee e : _employees) {
            System.out.println(e.toString());

        }
    }
//endregion
}