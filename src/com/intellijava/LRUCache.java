package com.intellijava;
import java.util.ArrayList;

class QNode{
    int key;
    int value;
    QNode next;
    QNode(int key, int value){
        this.key=key;
        this.value=value;
        this.next=null;
    }
    QNode(){

    }
}
public class LRUCache {
    int capacity;
    QNode headNode;
    int size=0;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        headNode=new QNode();
      }

    public int get(int key) {
        //check whether it is present
        QNode pointerNode;
        pointerNode=headNode.next;
        QNode prevNode=headNode;
        QNode newNode=new QNode();
        while(pointerNode!=null)
        {
            if(pointerNode.key==key){
                newNode.key=key;
                newNode.value=pointerNode.value;
                prevNode.next=pointerNode.next;
                pointerNode=pointerNode.next;
                while(pointerNode!=null){
                    prevNode=pointerNode;
                    pointerNode=pointerNode.next;
                }
                prevNode.next=newNode;
                //headNode.next=headNode.next.next;
                return newNode.value;
            }
            prevNode=pointerNode;
            pointerNode=pointerNode.next;
        }
        return -1;

    }

    public void put(int key, int value) {
        //check whether it is present
        QNode pointerNode;
        pointerNode=headNode.next;
        QNode prevNode=headNode;
        QNode newNode=new QNode(key,value);
        while(pointerNode!=null)
        {
            if(pointerNode.key==key){
                prevNode.next=pointerNode.next;
                pointerNode=pointerNode.next;
                while(pointerNode!=null){
                    prevNode=pointerNode;
                    pointerNode=pointerNode.next;
                }
                prevNode.next=newNode;
                return;
            }
            prevNode=pointerNode;
            pointerNode=pointerNode.next;
        }
        //insert the new node;
        prevNode.next=newNode;
        size++;
        if(size>capacity){
            headNode.next=headNode.next.next;
        }

    }
}
