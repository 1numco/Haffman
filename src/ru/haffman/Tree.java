package ru.haffman;

public class Tree {
    private Node root;
    private Tree left;
    private Tree right;

    public Tree(Node root) {
        this.root = root;
        this.left = null;
        this.right = null;
    }

    public Tree(Tree left, Tree right) {
        this.root = new Node( left.getRoot().getFreq()+right.getRoot().getFreq());
        this.left = left;
        this.right = right;
    }

    public Node getRoot() {
        return root;
    }

    public Tree getLeft() {
        return left;
    }

    public Tree getRight() {
        return right;
    }
}


class Node{
    private int freq;
    private char symbol;

    Node(int freq, char symbol)
    {
        this.freq=freq;
        this.symbol=symbol;
    }

    public Node(int freq) {
        this.freq = freq;

    }

    public Node() {
        this.freq=0;
        this.symbol=' ';
    }

    public int getFreq() {
        return freq;
    }

    public char getSymbol() {
        return symbol;
    }


}