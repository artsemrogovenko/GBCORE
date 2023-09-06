package ru.geekbrains.lesson3;

import java.util.Comparator;

    public class EmployeePhoneComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee o1, Employee o2) {
            int res = o1.getPhone().compareTo(o2.getPhone());
            if (res == 0){
                return o1.getPhone().compareTo(o2.getPhone());
            }
            return res;
        }
    }


