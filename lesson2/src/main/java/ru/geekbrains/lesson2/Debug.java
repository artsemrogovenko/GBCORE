package ru.geekbrains.lesson2;
/**
 * Класс для визуальной оценки проверки на выигрыш
 */
public class Debug {

    public static char[][] debugArea;

    public static void printdebugArea() {

        /** my method */
        System.out.println("Y");
        for (int y = debugArea[0].length; y > 0; y--) {
            System.out.print(y);
            for (int x = 0; x < debugArea.length; x++) {
                System.out.print("|" + debugArea[x][y - 1]);
            }
            System.out.print("|\n");
        }

        System.out.print("+");
        for (int x = 0; x < debugArea.length; x++) {
            System.out.print("-" + (x + 1));
        }
        System.out.println("--> X\n");

    }

    /** очистка для тестового поля */
    public static void cleandebug() {
        for (int i = 0; i < debugArea.length; i++) {
            for (int j = 0; j < debugArea[0].length; j++) {
                debugArea[i][j] = ' ';
            }
        }
    }

    
}
