package ru.geekbrains.lesson3;

import java.util.*;

public abstract class Employee implements Comparable<Employee> {

    //region Public Methods

    private String phoneGenerate() {
        int number = rand(1000000, 9999999);
        int[] prefix ={7925, 7915, 7903, 7958, 7995, 7912, 7987} ;
        //сдвигаю префикс влево, и замещаю пустые биты номером
        String result = ""+prefix[random.nextInt(prefix.length)] + number;
        while (true) {
            if (!phones.contains(result)) {
                phones.add(result);
                return result;
            } else {
                number = rand(1000000, 9999999);
                result = ""+prefix[random.nextInt(prefix.length)] + number;
            }
        }
    }

    public static int rand(int min, int max){
        if (min > max || (max - min + 1 > Integer.MAX_VALUE)) {
            throw new IllegalArgumentException("Invalid range");
        }
        return new Random().nextInt(max - min + 1) + min;
    }

    /**
     * Расчет среднемесячной заработной платы
     * @return
     */
    public abstract double calculateSalary();

    @Override
    public int compareTo(Employee o) {
        return Double.compare(calculateSalary(), o.calculateSalary());
        //return calculateSalary() == o.calculateSalary() ? 0 :
        //        calculateSalary() > o.calculateSalary() ? 1 : -1;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", salary=" + salary +
                '}';
    }

    //endregion

    //region Constructors And Initializers

    {
        //System.out.println("Initialize - Employee");
        id = ++counter;

    }

    private Employee(){
        this("#Surnane#", "#Name#");
    }

    private Employee(String surName, String name){
        this(surName, name, 500);
    }

    protected Employee(String surName, String name, double salary){
        //System.out.println("Constructor - Employee");
        if (salary < 500){
            throw new RuntimeException("Ставка заработной платы должна быть не менее 500");
        }
        this.surName = surName;
        this.name = name;
        this.salary = salary;
        this.phone=phoneGenerate();
    }

    //endregion

    //region Getters and Setters
    public String getPhone() {
        return phone;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 30000){
            throw new RuntimeException("Уровень заработной платы должен быть не менее 30000");
        }
        this.salary = salary;
    }

    //endregion

    //region Fields
    private Set<String> phones=new HashSet<String>();

    private int id;

    protected String phone;

    /**
     * Имя
     */
    protected String name;

    /**
     * Фамилия
     */
    protected String surName;

    /**
     * Ставка заработной платы
     */
    protected double salary;

    //endregion

    //region Static Fields

    protected static String[] names = new String[] { "Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен", "Клим", "Панкратий", "Рубен", "Герман" };
    protected static String[] surNames = new String[] { "Григорьев", "Фокин", "Шестаков", "Хохлов", "Шубин", "Бирюков", "Копылов", "Горбунов", "Лыткин", "Соколов" };
    protected static Random random = new Random();
    private static int counter = 1000;

    //endregion

}
