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
        index =Math.abs(key.hashCode())%hashLength;
        return index;
    }
    public Integer getValue(String key) {
        int index;
        MyHashNode firstHashNode;
        Integer value=null;
        index = getIndex(key);
        firstHashNode = myHashNodeList.get(index);
        if(firstHashNode.next == null) {
            if(firstHashNode.key==key) {
                value = firstHashNode.value;
                return value;
            }
            return value;
        }
        while(firstHashNode.next != null){
            if(firstHashNode.key==key) {
                value = firstHashNode.value;
                return value;
            }
            else
                firstHashNode=firstHashNode.next;
        }
        value = firstHashNode.value;
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

    public Integer remove(String key) {
        int index = getIndex(key);
        MyHashNode aHashNode;
        aHashNode = myHashNodeList.get(index);
        if (aHashNode.key != null && aHashNode.next == null) {
            //1 notes
            if (aHashNode.key == key) {
                MyHashNode nullHashNode=new MyHashNode();
                myHashNodeList.set(index, nullHashNode);
                size--;
                return null;
            } else
                return null;
        }
        else {
            if (aHashNode.next.key != null && aHashNode.next.next == null) { //2 notes
                if (aHashNode.key == key) {
                    myHashNodeList.set(index, aHashNode.next);
                    return aHashNode.next.value;
                } else {
                    if (aHashNode.next.key == key) {
                        aHashNode.next = null;
                        return null;
                    } else
                        return null;

                }
            }
            else{
                //3 notes or more
                if(aHashNode.key==key) {
                    //the head is the one to find
                    myHashNodeList.set(index, aHashNode.next);
                    return aHashNode.next.value;
                }

                else{
                    while(aHashNode.next.next!=null)
                    {
                        if(aHashNode.next.key==key) {
                            aHashNode.next = aHashNode.next.next;
                            return aHashNode.next.value;
                        }
                        else
                            aHashNode=aHashNode.next;

                    }
                    if(aHashNode.next.key==key)
                        aHashNode.next=null;


                }

            } //3 notes or more finished
        }

        return null;
    }



    public boolean isEmpty(){
        if(size==0)
            return true;
        else
            return false;
    }


}
