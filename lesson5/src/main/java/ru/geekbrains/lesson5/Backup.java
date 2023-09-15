package ru.geekbrains.lesson5;

import java.io.*;

public class Backup {
    /**
     * Написать функцию, создающую резервную копию всех файлов в директории во вновь созданную папку ./backup
     */

    private static String _Bpath;
    private static String dest_dir;


    public static void main(String[] args) throws IOException {
        start(new File("."),"backup");
    }

    /**
     * @param file текущая папка
     * @param dest  папка с этим именем будет создана для копирования
     */

    public static void start(File file, String dest) {
        dest_dir = "\\" + dest;
        try {
            _Bpath = file.getCanonicalPath();
        } catch (IOException err) {
            err.getMessage();
        }
        copy(file);
    }


    private static void copy(File current) {
        File[] files = current.listFiles();
        if (files == null) {
            return;
        }

        File _new = new File(_Bpath + dest_dir.concat(current.getPath().substring(1)));
        for (int i = 0; i < files.length; i++) {

            if (current.isDirectory()) {
                if (!_new.exists()) {
                    _new.mkdir();
                }
            }

            if (files[i].isFile()) {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(_Bpath + dest_dir + files[i].getPath().substring(1)); //куда копируется

                    int c;
                    try (FileInputStream fileInputStream = new FileInputStream(_Bpath + files[i].getPath())) {// кто копируется
                        while ((c = fileInputStream.read()) != -1)
                            fileOutputStream.write(c);

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                } catch (IOException s) {
                    s.printStackTrace();
                }

            }

            copy(files[i]);
        }


    }

}
