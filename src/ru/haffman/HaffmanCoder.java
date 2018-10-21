package ru.haffman;

import java.util.ArrayList;
import java.util.HashMap;

public class HaffmanCoder {
    private HashMap<String,String> table;
    private Handler handler;
    private String treestr="";
    private String treechar="";

    public HaffmanCoder(String path) {
        table = new HashMap<>();
        handler = new Handler(path);
    }

    private Tree buildTreeHaffman() {

        PriorityQueue queue = new PriorityQueue();

        Node[] nodes = handler.getFreqOfSym();

        for (int i = 0; i < nodes.length; i++) {
            if(nodes[i].getFreq()>0)
                queue.insert(new Tree(nodes[i]));
        }

        while (queue.getSize() > 1) {
            Tree temp = new Tree(queue.getTree(0), queue.getTree(1));
            queue.remove();
            queue.insert(temp);
        }
        return queue.getTree(0);
    }

    public HashMap<String,String> getCodeTable()
    {
        return table;
    }

    private void reqBuildCodeTable(String str, Tree node){
        if(node.getLeft()!=null) {
            reqBuildCodeTable(str+'0', node.getLeft());
            reqBuildCodeTable(str+'1', node.getRight());
        }
        else
            table.put(String.valueOf(node.getRoot().getSymbol()), str);
    }

    private void inOrder(Tree tree, String strstep)
    {
        if(tree!=null)
        {
            if(tree.getLeft()==null)
                treechar+=tree.getRoot().getSymbol();
            treestr+=strstep;
            inOrder(tree.getLeft(), "0");
            inOrder(tree.getRight(), "1");
        }

    }

    public void buildCodeTable() {
        Tree tree = buildTreeHaffman();
        reqBuildCodeTable("",  tree);
    }

    public void coder(){
        ArrayList<String> str = handler.getInput_str();
        String inputstr="";
        for(String i:str){
            inputstr+=i;
        }
        String outputstr="";
        char[] inputarr=inputstr.toCharArray();
        for(int i=0;i<inputarr.length;i++){
            outputstr+=table.get(String.valueOf(inputarr[i]));
        }
        outputstr=" "+outputstr;
        inOrder(buildTreeHaffman(),"");
        String temp="";
        for(int i=0;i<treechar.length();i++) {
            temp+= String.valueOf(treechar.charAt(i));
        }
        outputstr=temp+outputstr;
        outputstr=" "+outputstr;
        outputstr=treestr+outputstr;
        Writer writer = new Writer("codetext.txt");
        writer.writeToFile(outputstr);
        System.out.println(inputstr);
        System.out.println(outputstr);

    }

    public void decoder(){

    }
}
