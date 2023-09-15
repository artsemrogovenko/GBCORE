package ru.geekbrains.lesson5;

import java.io.File;

public class Tree {

    public static void main(String[] args) {

        print(new File("."), "", true);

    }

    /**
     * метод print, распечатает директории и файлы
     * @param file текущий файл
     * @param indent отступы и ветки
     * @param isLast элемент последний в папке?
     */
    public static void print(File file, String indent, boolean isLast){
        System.out.print(indent);
        if (isLast){
            System.out.print("└─");
            indent += "  ";
        }
        else{
            System.out.print("├─");
            indent += "│ ";
        }
        System.out.println(file.getName());

        File[] files = file.listFiles();
        if (files == null)
            return;


        int subDirTotal = 0;
        for (int i = 0; i < files.length; i++){
            if (files[i].isDirectory())
                subDirTotal++;
        }

        int subDirCounter = 0;
        for (int i = 0; i < files.length; i++){
            if (files[i].isDirectory()){
                subDirCounter++;
                print(files[i], indent, subDirCounter == subDirTotal);
            }
            // печать файлов
            if (files[i].isFile()){
                print(files[i], indent, i==files.length-1);
            }

        }

    }

}
