package ru.geekbrains.lesson2;


public class Checks extends App{

    /**
     * Проверка на заполнение доски
    */
    public static boolean checkGameState() {    
        if (checkDraw()) {
            System.out.println("Ничья!");
            return true;
        }
        return false; // Игра продолжается
    }

    /**
     * Проверка победы
     * 
     * @param dot символ игрока
     * @param x 
     * @param y
     * @return true / false
     * проверка идет по всем направлениям,равна количеству выигрышной комбинации
     */
    public static boolean checkWin(char dot, int x, int y) {
        // cleandebug();
        boolean result = false;
        int tempA = x;
        int tempB = y;

        // Проверка по горизонтали
        for (int a = 0; a < WIN_COUNT; a++) {
            if (isCellValid(tempA, y)) {
                if (checkHorizontal(tempA, y, dot)) {
                    result = true;
                    break;
                }

            }
            --tempA;
            // cleandebug();
        }
        // Проверка по вертикали
        for (int a = 0; a < WIN_COUNT; a++) {
            if (isCellValid(x, tempB)) {
                if (checkVertical(x, tempB, dot)) {
                    result = true;
                    break;
                }
            }
            ++tempB;
            // cleandebug();
        }
        tempA = x;
        tempB = y;
        // Проверка по диагонали 1
        for (int a = 0; a < WIN_COUNT; a++) {
            if (isCellValid(tempA, tempB)) {
                if (checkUpRight(tempA, tempB, dot)) {
                    result = true;
                    break;
                }
            }

            --tempA;
            --tempB;
            // cleandebug();
        }
        tempA = x;
        tempB = y;
        // Проверка по диагонали 2
        for (int a = 0; a < WIN_COUNT; a++) {
            if (isCellValid(tempA, tempB)) {
                if (checkDownRight(tempA, tempB, dot)) {
                    result = true;
                    break;
                }

            }
            --tempA;
            ++tempB;
            // cleandebug();
        }

        return result;
    }



    /**
     * Проверка по диагонали 1
     * 
     */
    static boolean checkUpRight(int x, int y, char dot) {
        int count = 0;
        for (int i = x; i < x + WIN_COUNT ; ) {
            for (int j = y; j < y + WIN_COUNT ; ) {
              //  debugArea[i][j]='u';
              //  printdebugArea();
              if(isCellValid(i, j)){
                if (gameArea[i][j] == dot) {
                    ++count;
                }}
                i++;
                j++;
            }
        }
        return count == WIN_COUNT;
    }

    /**
     * Проверка по диагонали 2
     */
    static boolean checkDownRight(int x, int y, char dot) {
        int count = 0;
        for (int i = x; i < x + WIN_COUNT ; ) {
            for (int j = y; j > y - WIN_COUNT ; ) {
              //  debugArea[i][j]='d';
              //  printdebugArea();
              if(isCellValid(i, j)){
                if (gameArea[i][j] == dot) {
                    ++count;
                }}
                i++;
                j--;
            }
        }
        return count == WIN_COUNT;
    }

    /**
     * Проверка по горизонтали
     */
    static boolean checkHorizontal(int x, int y, char dot) {
        int count = 0;
        for (int i = x; i < x + WIN_COUNT ; i++) {
          //  debugArea[i][y]='H';
          //  printdebugArea();
          if(isCellValid(i, y)){
            if (gameArea[i][y] == dot) {
                ++count;
            }}
        }
        return count == WIN_COUNT;
    }

    /**
     * Проверка вертикали
     */
    static boolean checkVertical(int x, int y, char dot) {
        int count = 0;
        for (int i = y; i < y + WIN_COUNT ; i++) {
          //  debugArea[x][i]='V';
          //  printdebugArea();
          if(isCellValid(x, i)){
            if (gameArea[x][i] == dot) {
                ++count;
            }}
        }
        return count == WIN_COUNT;
    }

    /**
     * Проверка на ничью,
     * проверка всего игрового поля
     * @return true/false
     */
    public static boolean checkDraw() {
        for (int x = 0; x < gameArea.length; x++) {
            for (int y = 0; y < gameArea[0].length; y++) {
                if (isCellEmpty(x, y))
                    return false;
            }
        }
        return true;
    }
}
