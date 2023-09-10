package ru.geekbrains.lesson4;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


/*
1 Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4. При
подаче массива другого размера необходимо бросить исключение MyArraySizeException.
2 Далее метод должен пройтись по всем элементам массива, преобразовать в int и
просуммировать. Если в каком-то элементе массива преобразование не удалось (например, в
ячейке лежит символ или текст вместо числа), должно быть брошено исключение
MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
3 В методе main() вызвать полученный метод, обработать возможные исключения
MyArraySizeException и MyArrayDataException и вывести результат расчета.
 */
public class Program {

    private static Scanner sc = new Scanner(System.in);
    private static String[][] test = {
            {"1", "1", "1", "1"},
            {"1", "1", "1", "1"},
            {"1", "1", "1", "1"},
            {"1", "1", "1", "1"}};

    public static void main(String[] args) {
        testprint();
        while (true) {
            try {
                //интерактив
                start();
            } catch (InputMismatchException i) {
                System.out.println("ошибка ввода");
                sc.next();

            } catch (IOException m) {
                System.out.println(m.getMessage());

            } catch (MyArrayDataException a) {
                System.out.printf("%s %s \'%s\'", a.getMessage(), a.get_position(), a.get_value());
                System.out.println();

            } catch (MyArraySizeException e) {
                System.out.println(e.getMessage() + e.get_position());
            }

            System.out.print("Повторить еще раз? (Y - да): ");
            if (!sc.next().equalsIgnoreCase("Y"))
                break;
        }
    }

    /**
     * печать масиива test из этого класса
     */
    private static void testprint() {
        try {
            // печать правильного массива
            ArrayGenerate.printArray(test);
            System.out.println(new VerifyArray(test));
        } catch (MyArrayDataException a) {
            System.out.printf("%s %s \'%s\'", a.getMessage(), a.get_position(), a.get_value());
            System.out.println();
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage() + e.get_position());
        }
        System.out.println();
    }

    private static void start() throws MyArraySizeException, IOException {
        int p, s, w;

        System.out.println("Введите процент плохих ячеек от 0 до 100");
        p = sc.nextInt();
        System.out.println("Введите размер массива");
        s = sc.nextInt();
        System.out.println("Введите ширину ячейки");
        w = sc.nextInt();
        ArrayGenerate a = new ArrayGenerate(p, s, w);
        System.out.println(new VerifyArray(a.getArray()));
    }

}