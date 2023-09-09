package ru.geekbrains.lesson4;

import java.io.IOException;
import java.util.Random;

public class ArrayGenerate {
    private static final Random random =new Random();
    private static String[] digit =new String[] { "1", "2", "3", "0" };
    private static String[] miscellan =new String[] { "a", " ", "", "+" };
    private static int _range, _count;
    private static String[][] generated;

    public String[][] getArray() {
        return generated;
    }

    public ArrayGenerate(int percent, int size) throws IOException {
            if((percent<100 && percent>0) || size > 1){
                _range =size;
        }else{
            String msg=String.format("неверные данные %d%s arr[%d][%d]",percent,"%",size,size);
            throw new IOException(msg);
        }
        // посчитаю сколько будет плохих ячеек (общее количество разделить на часть от 100%)
        if(percent>0){
        double res = (_range * _range) / (100 / percent);
        _count=(int)Math.round(res);
        }
        if (percent==0){
            _count=percent;
        }
        System.out.println(_count   + " не числовых ячеек");
        arrayInit();
        printArray();
    }

    private static void arrayInit() {
        generated = new String[_range][_range];
        int brokenCell = 0;

        if (_count != 0) {
            brokenCell = (_range * 2) / _count;
        }

        int currentCell = 0;
        for (int i = 0; i < _range; i++) {
            for (int j = 0; j < _range; j++) {
                ++currentCell;
                //портить ячейки и уменьшать счетчик

                    if (brokenCell == currentCell - 1 && brokenCell != 0) {
                        if (_count > 0) {
                        currentCell = 0;
                        --_count;
                        generated[i][j] = mixer(false);
                    }
                } else {
                    generated[i][j] = mixer(true);
                }
            }
        }
    }

    private static String mixer(boolean state) {
        if(state){
         return   digit[random.nextInt(digit.length)]+ digit[random.nextInt(digit.length)];

        } else {

            switch (random.nextInt(4)) {
                case 1:
                    return digit[random.nextInt(digit.length)] + miscellan[random.nextInt(miscellan.length)];
                case 2:
                    return miscellan[random.nextInt(miscellan.length)] + miscellan[random.nextInt(miscellan.length)];
                case 3:
                    return miscellan[random.nextInt(miscellan.length)];
                default:
                    return null;
            }
        }
    }

    private static void printArray(){
        // прорисовка координат


        for (int j = 0; j< generated[0].length; j++) {

            for (int i = 0; i < generated.length; i++) {

              System.out.printf("|'%s'",generated[j][i] );
            }
            System.out.print("|\n");
        }

    }
}
