package ru.geekbrains.lesson4;
public class MyArraySizeException extends Exception{
    private int _x , _y;

    public String get_position() {
        return String.format("[%d][%d]",_x,_y);
    }

    public MyArraySizeException(String message, int x, int y) {
        super(message);
        _x = x;
        _y = y;
    }

   
}
