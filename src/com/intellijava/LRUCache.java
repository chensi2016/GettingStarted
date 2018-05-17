package com.intellijava;
import sun.rmi.server.InactiveGroupException;

import java.util.ArrayList;

public class QNode{
    int key;
    int value;
    QNode(int key, int value){
        this.key=key;
        this.value=value;

    }
}
public class LRUCache {
    int capacity;
    QNode Queue[capacity];
    public LRUCache(int capacity) {
        for(int i=0;i<capacity;i++)
        {
            Queue[i]=new QNode();
        }
    this.capacity=capacity;
    }

    public int get(int key) {
        int value;
        QNode newNode=new QNode();
        //check whether it is present
        for(int i=0;i<capacity;i++){
            if(Queue[i].key==key) {
                value=QNode[i].value;
                for(int j=i;j<capacity-1;j++)
                {
                    QNode[j]=QNode[j+1];
                }
                newNode.key=key;
                newNode.value=value;
                QNode[capacity-1]=newNode;
                return value;
            }
        }
        else
            return -1;

    }

    public void put(int key, int value) {
        QNode newNode=new QNode(key, value);
        //check whether it is present
        for(int i=0;i<capacity;i++){
            if(Queue[i].key==key) {
                for(int j=i;j<capacity-1;j++)
                {
                    QNode[j]=QNode[j+1];
                }
                QNode[capacity-1]=newNode;
                return;
            }
        }
        //insert the new node
        for(int i=0;i<capacity-1;i++) {
            Queue[i]=QNode[i+1];
        }
        Queue[capacity]=newNode;

    }
}
