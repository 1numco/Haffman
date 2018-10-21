package ru.haffman;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class Reader {

    private ArrayList<String> str;
    private String path;
    Reader(String path){
        str = new ArrayList<>();
        this.path=path;
    }
    public ArrayList<String> read() {
        File file=new File(path);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String st;
            while((st=br.readLine()) !=null) {
                str.add(st.toLowerCase());
            }
//            for(String s:str)
//                System.out.println(s);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }


}


