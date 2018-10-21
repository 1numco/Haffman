package ru.haffman;

import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    private String path;

    public Writer(String path) {
        this.path = path;
    }

    public void writeToFile(String text){

        try(FileWriter writer = new FileWriter(path, false))
        {
// запись всей строки
            writer.write(text);
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
