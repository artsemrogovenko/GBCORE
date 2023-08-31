package ru.geekbrains.lesson1.calc;

public class Out {
    /**
     * Процедура подсчета
     * @param in строка для вычисления
     * @param operation символ математической операции
     */
    public static void result(String in, Character operation) {
        double result = 0;
        String sep = "\\" + Character.toString(operation); // нужно использовать разделители для арифметических знаков
        String[] formula = in.split(sep);
        double a = Integer.parseInt(formula[0]);
        double b = Integer.parseInt(formula[1]);

        switch (operation) {
            case '*':
                result = a * b;
                break;
            case '-':
                result = a - b;
                break;
            case '+':
                result = a + b;
                break;
            case '/':
                result = a / b;
                break;
        }
        System.out.println("результат = " + result);
    }
}
