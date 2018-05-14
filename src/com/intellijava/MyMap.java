package com.intellijava;
import java.util.ArrayList;

public class MyMap {
    ArrayList<MyHashNode> myHashNode = new ArrayList<MyHashNode>();

    MyHashNode lastHashNode;
    int hashLength = 10;
    int size = 0;
    public int getIndex(String key){
        int index;
        index = key.hashCode()%hashLength;
        return index;
    }
    public int getValue(String key) {
        int index;
        MyHashNode firstHashNode;
        int value=9999;
        index = getIndex(key);
        firstHashNode = myHashNode.get(index);
        if(firstHashNode.next == null)
            return value;
        while(firstHashNode.next != null){
            if(firstHashNode.key==key)
                value = firstHashNode.value;
            else
                firstHashNode=firstHashNode.next;
        }
        return value;
    }

    public MyHashNode getLastHashNode(int index) {

        MyHashNode aHashNode;
        if(myHashNode.get(index)!=null) {
            aHashNode = myHashNode.get(index);
            while (aHashNode.next != null)
                aHashNode = aHashNode.next;

            lastHashNode=aHashNode;
        }
        else
            lastHashNode=null;
        return lastHashNode;
    }

    public int getSize(){
        return size;
    }

    public void add(String key, int value){
        int index = getIndex(key);
        MyHashNode aHashNode = new MyHashNode(key, value);
        lastHashNode=getLastHashNode(index);
        if(myHashNode.get(index)==null)
             {
                 size++;
                 myHashNode.add(index, aHashNode);
             }
        else
            {
                lastHashNode=getLastHashNode(index);
                lastHashNode.next=aHashNode;
            }

    }

    public int remove(String key){
        int index=getIndex(key);
        myHashNode.remove(index);
        size--;
        return getIndex(key);
    }

    public boolean isEmpty(){
        if(size==0)
            return true;
        else
            return false;
    }


}
