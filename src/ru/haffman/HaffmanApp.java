package ru.haffman;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class HaffmanApp {
    public static void main(String[] args) {

//        Scanner in = new Scanner(System.in);
//        System.out.println("Enter path of read file");
//        Haffman haffman = new Haffman(in.nextLine());
        HaffmanCoder haffman = new HaffmanCoder("text.txt");
        haffman.buildCodeTable();
        HashMap<String,String> map = haffman.getCodeTable();
        for (Map.Entry entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Value: "
                    + entry.getValue());
        }
        haffman.coder();

    }
}
