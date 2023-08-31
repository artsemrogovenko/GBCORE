package ru.geekbrains.lesson1.app;

import ru.geekbrains.lesson1.calc.Converter;
/** Это простой калькулятор
 *
 * cd X:\gbcore\lesson1\src\main
 * javac -sourcepath ./java -d out java/ru/geekbrains/lesson1/app/App.java
 * javadoc -encoding utf8  -d mydocs -sourcepath ./java -cp ./out -subpackages ru
 * java -classpath ./out ru.geekbrains.lesson1.app.App
 *
 *
 */

public class App {
    /**
     * точка входа
     */
    public static void main(String[] args) {
        /** Массив с примерами */
        String[] ar = new String[]{"6+2", "6-2", "6*2", "6/2"};
        /** каждый пример будет напечатан и посчитан */
        for (String sample : ar) {
            System.out.printf(sample + " ");
            Converter.separator(sample);
        }
    }
}

