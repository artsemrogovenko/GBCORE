package ru.geekbrains.lesson1.calc;

public class Converter {
    /**
     * Процедура для удаления пробелов и выбора действия
     * @param data строка данных
     */
    public static void separator(String data) {
        data = data.replaceAll(" ", "");
        char operation = '0';
        char[] symbols = { '*', '-', '+', '/' };

        for (int a = 0; a < symbols.length; a++) {
            char temp = symbols[a];
            for (int j = 0; j < data.length(); j++) {
                if (temp == data.charAt(j) & temp != data.charAt(0)) {
                    operation = temp;
                    a = symbols.length;
                    break;
                }
            }
        }
        Out.result(data, operation);
    }
}
