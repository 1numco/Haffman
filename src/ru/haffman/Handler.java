package ru.haffman;

import java.util.ArrayList;
import java.util.HashMap;

public class Handler {

    private ArrayList<String> input_str;
    private Reader rd;
    private char[] alphabet;

    Handler(String path){
        rd = new Reader(path);
        input_str=rd.read();
        alphabet = new char[29];
        for (int i = 0; i < alphabet.length; i++) {
            alphabet[i]=(char)(i+97);
        }
        alphabet[26]=' ';
        alphabet[27]=',';
        alphabet[28]='.';
    }

    public Node[] getFreqOfSym(){
        int[] out = new int[alphabet.length];
        long count=0;
        for(String s:input_str) {
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < alphabet.length; j++) {
                    if (s.charAt(i) == alphabet[j]) {
                        out[j]++;
                    }

                }
                count++;

            }
        }
        Node[] output=new Node[alphabet.length];
        for (int i = 0; i <alphabet.length ; i++) {
            output[i] = new Node(out[i], alphabet[i]);
        }

      return output;
    }


    public ArrayList<String> getInput_str() {
        return input_str;
    }
}


