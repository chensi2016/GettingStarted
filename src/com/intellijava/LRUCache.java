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
    QNode nextNode;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        for(int i=capacity-1;i>=0;i--)
        {
            headNode=new QNode();
            if(i<capacity-1) {
                headNode.next=nextNode;
            }
            nextNode=headNode;
        }


    }

    public int get(int key) {
        int value;
        QNode newNode=new QNode();
        //check whether it is present
        QNode pointerNode=headNode;
        QNode prevNode=null;
        QNode foundNode;
        while(pointerNode!=null){
            if(pointerNode.key==key) {
                value=pointerNode.value;
                foundNode=pointerNode;
                if(pointerNode==headNode)
                {
                    headNode=pointerNode.next;

                }
                else
                {
                    prevNode.next=pointerNode.next;}
                while(pointerNode.next!=null) {
                    pointerNode=pointerNode.next;
                }
                foundNode.next=pointerNode.next;
                pointerNode.next=foundNode;
                return value;
            }
            prevNode=pointerNode;
            pointerNode=pointerNode.next;
        }
        return -1;
    }

    public void put(int key, int value) {
        QNode newNode=new QNode(key, value);
        //check whether it is present
        QNode pointerNode=headNode;
        QNode prevNode=null;
        QNode foundNode;
        while(pointerNode!=null){
            if(pointerNode.key==key) {
                pointerNode.value=value;
                foundNode=pointerNode;
                prevNode.next=pointerNode.next;
                while(pointerNode!=null) {
                    pointerNode=pointerNode.next;
                }
                foundNode.next=prevNode.next;
                prevNode.next=foundNode;
                return;
            }
            prevNode=pointerNode;
            pointerNode=pointerNode.next;
        }
        //insert the new node

        prevNode.next=newNode;

    }
}
