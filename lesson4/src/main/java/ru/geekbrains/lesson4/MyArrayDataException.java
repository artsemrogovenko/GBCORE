package ru.geekbrains.lesson4;
public class MyArrayDataException extends MyArraySizeException {

    private String _value;

    public String get_value() {
        return _value;
    }
    
    public MyArrayDataException(String message, String value, int x, int y) {
        super(message, x, y);
        _value = value;
    }


    
}
