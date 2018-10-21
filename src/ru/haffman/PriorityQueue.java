package ru.haffman;

import java.util.ArrayList;

public class PriorityQueue {
    private ArrayList<Tree> arr;

    public PriorityQueue() {
        arr = new ArrayList<>(1);
    }

    public void insert(Tree tr)
    {
        arr.add(tr);
        int i=0;
        while(arr.get(i).getRoot().getFreq()<tr.getRoot().getFreq())
        {
            i++;
        }

        for (int j = arr.size()-1; j >i ; j--) {
            arr.set(j,arr.get(j-1));

        }
        arr.set(i,tr);

    }
    public int getSize()
    {
        return arr.size();
    }

    public void remove()
    {
        arr.remove(0);
        arr.remove(0);
    }

    public Tree getTree(int i) {
        return arr.get(i);
    }
}
