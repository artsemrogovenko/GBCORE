package ru.geekbrains.lesson2;

import java.util.Random;
import java.util.Scanner;

public class App {

    public static final int WIN_COUNT = 4; // Выигрышная комбинация
    public static final char DOT_HUMAN = 'X'; // Фишка игрока - человек
    public static final char DOT_AI = '0'; // Фишка игрока - компьютер
    public static final char DOT_EMPTY = ' '; // Признак пустого поля

    public static final Scanner scanner = new Scanner(System.in);
    public static final Random random = new Random();

    public static char[][] gameArea; // Двумерный массив хранит текущее состояние игрового поля */

    public static void main(String[] args) {

        while (true) {
            // размер поля
            initialize(6, 4);
            // Debug.cleandebug();
            printArea();
            while (true) {

                if (humanTurn()) {
                    System.out.println("Вы победили!");
                    break;
                }

                printArea();
                if (Checks.checkGameState()) {
                    break;
                }

                if (aiTurn()) {
                    System.out.println("Победил компьютер!");
                    break;
                }

                printArea();
                if (Checks.checkGameState()) {
                    break;
                }

            }
            printArea();
            System.out.print("Желаете сыграть еще раз? (Y - да): ");
            if (!scanner.next().equalsIgnoreCase("Y"))
                break;
        }
    }

    /**
     * Инициализация поля игры -
     * задать ширину и высоту
     */
    private static void initialize(int width, int height) {
        // Debug.debugArea=new char[width][height];
        gameArea = new char[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                gameArea[x][y] = DOT_EMPTY;
            }
        }
    }

    /**
     * Отрисовка игрового поля
     */
    private static void printArea() {
        // прорисовка координат

        System.out.println("Y");
        for (int y = gameArea[0].length; y > 0; y--) {
            System.out.print(y);
            for (int x = 0; x < gameArea.length; x++) {
                System.out.print("|" + gameArea[x][y - 1]);
            }
            System.out.print("|\n");
        }

        System.out.print("+");
        for (int x = 0; x < gameArea.length; x++) {
            System.out.print("-" + (x + 1));
        }
        System.out.println("--> X\n");

    }

    /**
     * Отрисовка тестового поля
     */

    private static int checkInput() {
        while (true) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt() - 1;
            } else {
                System.out.println("Некорректное число, повторите попытку ввода.");
                scanner.nextLine();
            }
        }
    }

    /**
     * Обработка хода игрока (человек)
     */
    private static boolean humanTurn() {
        int x, y;
        do {
            while (true) {
                System.out.printf("Введите координату хода X (от 1 до %d): ", gameArea.length);
                x = checkInput();
                break;
            }
            while (true) {
                System.out.printf("Введите координату хода Y (от 1 до %d): ", gameArea[0].length);
                y = checkInput();
                break;
            }

        } while (!Checks.isCellValid(x, y) || !Checks.isCellEmpty(x, y));

        gameArea[x][y] = DOT_HUMAN;
        return Checks.checkWin(DOT_HUMAN, x, y);
    }

    /**
     * Обработка хода компьютера
     */
    private static boolean aiTurn() {
        int x, y;
        int[] human = think(DOT_HUMAN);
        int[] ai = think(DOT_AI);
        // помешать выиграть человеку

        if (human[0] != -1) { // если человек может выиграть
            System.out.println("Человек хочет выиграть");
            x = human[0];
            y = human[1];
            gameArea[x][y] = DOT_AI;
            return Checks.checkWin(DOT_AI, x, y);

        }
        if (ai[0] != -1) {// если бот сейчас может выиграть
            System.out.println("Бот может выиграть");
            x = ai[0];
            y = ai[1];
            gameArea[x][y] = DOT_AI;
            return Checks.checkWin(DOT_AI, x, y);

        } else {// просто проставить
            do {
                System.out.println();
                x = random.nextInt(gameArea.length);
                y = random.nextInt(gameArea[0].length);
            } while (!isCellEmpty(x, y));
            gameArea[x][y] = DOT_AI;
            return Checks.checkWin(DOT_AI, x, y);
        }
    }

    /**
     * 
     * возвращает точку для выигрышной комбинации
     */
    private static int[] think(char symbol) {
        int[] position = new int[] { -1, -1 };

        for (int i = 0; i < gameArea.length; i++) {
            for (int j = 0; j < gameArea[0].length; j++) {

                if (isCellEmpty(i, j)) {

                    gameArea[i][j] = symbol; // подставить символ
                    if (Checks.checkWin(symbol, i, j)) {// посмотреть будет ли выигрышная комбинация на точке
                        position[0] = i;
                        position[1] = j;
                        return position;
                    } else {
                        gameArea[i][j] = ' '; // если нет, очистить клетку
                    }
                }

            }
        }
        return position;
    }

    /**
     * Проверка, ячейка является пустой (DOT_EMPTY)
     * 
     * @param x
     * @param y
     * @return
     */
    public static boolean isCellEmpty(int x, int y) {
        return gameArea[x][y] == DOT_EMPTY;
    }

    /**
     * Проверка корректности ввода
     * (координаты хода не должны превышать размерность игрового поля)
     * 
     * @param x
     * @param y
     * @return
     */
    public static boolean isCellValid(int x, int y) {
        return x >= 0 && x < gameArea.length && y >= 0 && y < gameArea[0].length;
    }
}

abstract class OutOfAreaException extends Exception {
    private final int x;
    private final int y;

    public OutOfAreaException(int inxexA, int indexB) {
        this.x = inxexA;
        this.y = indexB;
    }

    public String getErr() {
        return "Неверная позиция[" + x + "][" + y + "]";
    }
}