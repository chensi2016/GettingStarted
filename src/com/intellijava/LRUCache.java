package com.intellijava;

import java.util.HashMap;
import java.util.Map;

class Node {
    int key;
    int value;
    Node next;
    Node prev;
    Node(int key, int value){
        this.key=key;
        this.value=value;
        next = this;
        prev = this;
    }
    Node(){

    }

    void delete() {
        Node toDeleteNodeNextNode = this.next;
        Node toDeleteNodePreviousNode = this.prev;

        toDeleteNodeNextNode.prev = toDeleteNodePreviousNode;
        toDeleteNodePreviousNode.next = toDeleteNodeNextNode;

        this.prev = null;
        this.next = null;
    }
}

public class LRUCache {
    private int capacity;
    private Node headNode;
    private Node lastNode;
    private int size;
    private Map<Integer, Node> map = new HashMap<>();
    public LRUCache(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity should be positive");
        }
        this.capacity = capacity;
        headNode = new Node();
      }
    private Node getReference(int key){
       return map.get(key);
    }
    public int get(int key) {
        //check whether it is present
       /* Node pointerNode;
        pointerNode=headNode.next;
        Node prevNode=headNode;
        Node newNode=new Node();
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
       Node foundNode = getReference(key);
       if (foundNode == null){
           return -1;
       }
       else{
           //if the foundNode is not the last Node;
           if (foundNode.next != null ) {
               map.remove(key);
               foundNode.next.prev = foundNode.prev;
               foundNode.prev.next = foundNode.next;
               Node newNode = new Node(key, foundNode.value);
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
       /* Node pointerNode;
        pointerNode=headNode.next;
        Node prevNode=headNode;
        Node newNode=new Node(key,value);
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
        Node foundNode = getReference(key);
        if( foundNode != null){
            get(key);
            lastNode.value = value;
        }
        else {
            //insert the new node
            Node newNode = new Node(key, value);
            if(lastNode != null) {
                lastNode.next = newNode;
                newNode.prev = lastNode;
            }
            else {
                headNode.next = newNode;
                newNode.prev = headNode;
            }
            size++;
            lastNode = newNode;
            map.put(key, newNode);
            if(size > capacity){
                Node toDeleteNode = headNode.next;
                map.remove(toDeleteNode.key);

                toDeleteNode.delete();

                size--;
            }
        }
    }
}
