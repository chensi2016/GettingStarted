package com.intellijava;
import java.util.ArrayList;

public class MyMap {
    ArrayList<MyHashNode> myHashNodeList = new ArrayList<MyHashNode>();

    MyHashNode lastHashNode;
    int hashLength = 10;
    int size = 0;
    public MyMap(){
        for(int i=0;i<hashLength;i++)
            myHashNodeList.add(new MyHashNode());
    }
    public int getIndex(String key){
        int index;
        index = key.hashCode()%hashLength;
        return index;
    }
    public Integer getValue(String key) {
        int index;
        MyHashNode firstHashNode;
        Integer value=null;
        index = getIndex(key);
        firstHashNode = myHashNodeList.get(index);
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
        if(myHashNodeList.get(index).key!=null) {
            aHashNode = myHashNodeList.get(index);
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
        if(lastHashNode==null)
             {
                 size++;
                 myHashNodeList.set(index, aHashNode);
             }
        else
            {
                lastHashNode=getLastHashNode(index);
                lastHashNode.next=aHashNode;
            }

    }

    public Integer remove(String key){
        int index=getIndex(key);
        MyHashNode aHashNode;
        if(myHashNodeList.get(index).key!=null) {
            if(myHashNodeList.get(index).next!=null) {
                aHashNode = myHashNodeList.get(index).next;
                myHashNodeList.remove(index);
                myHashNodeList.add(index,aHashNode);
                return myHashNodeList.get(index).value;
            }
            else {
                myHashNodeList.remove(index);
                size--;
                return null;
            }
        }
        else
        return null;
    }

    public boolean isEmpty(){
        if(size==0)
            return true;
        else
            return false;
    }


}
