package ru.geekbrains.lesson4;

public class MyArray {

    public MyArray(String[][] array) throws MyArraySizeException {
        conversing(array);
    }


    /**
     * метод пройдет по всем элементам массива, преобразует строки в int и
     * просуммирует
     * 
     * @param arrayOfIntegers массив должен быть 4х4
     * @throws MyArraySizeException искоючение при неправильном размере
     */
    private static void conversing(String[][] arrayOfIntegers) throws MyArraySizeException {
        if (arrayOfIntegers.length != 4 || arrayOfIntegers[0].length != 4) {
            throw new MyArraySizeException("Неверный размер",
                    arrayOfIntegers.length, arrayOfIntegers[0].length);
        }

        int sum = 0;
        for (int i = 0; i < arrayOfIntegers.length; i++) {
            for (int j = 0; j < arrayOfIntegers[0].length; j++) {

                if (parser(arrayOfIntegers[i][j])) {
                    sum += Integer.parseInt(arrayOfIntegers[i][j]);
                } else {
                    throw new MyArrayDataException("Неверное значение",
                            arrayOfIntegers[i][j], i, j);
                }
            }
        }
        System.out.println("Сумма = "+sum);
    }

    /**
     * Проверка на "числовую строку"
     * 
     * @param value входное значение
     * @return true / false
     */
    private static boolean parser(String value) {
        //если не пустое
        if (!value.isEmpty()) {
            // если первый элемент ноль, но не число
            if (value.length() > 1) {
                String[] temp = value.split("");
                if (temp[0].contains("0")) {
                    return false;
                }
            }
            for (int i = 0; i < value.length(); i++) {
                // если встретилась не цифра
                if (!Character.isDigit(value.charAt(i))) {
                    return false;
                }
            }
        }
        return (!value.isEmpty()) & true; // если ячейка пустая, то при умножении 0 на 1 вернет false
    }


}
