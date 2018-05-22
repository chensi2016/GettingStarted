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
    public LRUCache(int capacity) {
        this.capacity=capacity;
        QNode nextNode=null;
        for(int i=capacity;i>=0;i--)
        {
            headNode=new QNode(-999,0);
            if(i<capacity) {
                headNode.next=nextNode;
            }
            nextNode=headNode;
        }
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
                //prevNode.next=pointerNode.next;
                while(pointerNode!=null){
                    prevNode=pointerNode;
                    pointerNode=pointerNode.next;
                }
                prevNode.next=newNode;
                headNode.next=headNode.next.next;
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
                while(pointerNode!=null){
                    prevNode=pointerNode;
                    pointerNode=pointerNode.next;
                }
                prevNode.next=newNode;
                //headNode.next=headNode.next.next;
                return;
            }
            prevNode=pointerNode;
            pointerNode=pointerNode.next;
        }
        //insert the new node;
        prevNode.next=newNode;
        headNode.next=headNode.next.next;
    }
}
