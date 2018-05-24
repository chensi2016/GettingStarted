package com.intellijava;
import java.util.HashMap;

class QNode{
    int key;
    int value;
    QNode next;
    QNode prev;
    QNode(int key, int value){
        this.key=key;
        this.value=value;
        this.next=null;
        this.prev=null;
    }
    QNode(){

    }
}
public class LRUCache {
    int capacity;
    QNode headNode;
    QNode lastNode;
    int size=0;
    HashMap<Integer,QNode> map=new HashMap<>();
    public LRUCache(int capacity) {
        this.capacity=capacity;
        headNode=new QNode();
        lastNode=null;
      }
    public QNode getRefer(Integer key){
       return map.get(key);
    }
    public int get(int key) {
        //check whether it is present
       /* QNode pointerNode;
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
        */
       QNode foundNode=getRefer(key);
       if (foundNode == null){
           return -1;
       }
       else{
           //if the foundNode is not the last Node;
           if (foundNode.next != null ) {
               foundNode.next.prev = foundNode.prev;
               foundNode.prev.next = foundNode.next;
               map.remove(key);
               QNode newNode = new QNode(key, foundNode.value);
               newNode.prev = lastNode;
               lastNode.next = newNode;
               lastNode = newNode;
               map.put(key,newNode);
               return lastNode.value;
           }
           else {//if the foundNode is the last Node, nothing changed;
               return foundNode.value;
           }

       }
    }

    public void put(int key, int value) {

        //check whether it is present
       /* QNode pointerNode;
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
*/

       //check whether the node is present
        QNode foundNode = getRefer(key);
        if( foundNode != null){
            if (foundNode.next != null ) {
                foundNode.value=value;
                foundNode.next.prev = foundNode.prev;
                foundNode.prev.next = foundNode.next;
                foundNode.next = null;
                foundNode.prev = lastNode;
                lastNode.next = foundNode;
                lastNode = foundNode;
                return;
            }
            else {//if the foundNode is the last Node, just chang the value;
                foundNode.value = value;
                return;
            }

        }
        else {
            //insert the new node
            QNode newNode = new QNode(key, value);
            if(lastNode!=null) {
                lastNode.next = newNode;
                newNode.prev = lastNode;
            }
            else{
                headNode.next = newNode;
                newNode.prev = headNode;
            }
            size++;
            lastNode = newNode;
            map.put(key, newNode);
            if(size>capacity){
                map.remove(headNode.next.key);
                headNode.next=headNode.next.next;
                size--;
            }
        }
    }
}
