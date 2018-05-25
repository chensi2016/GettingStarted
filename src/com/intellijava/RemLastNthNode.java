package com.intellijava;
import java.util.HashMap;

class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
        this.next = null;
    }
    ListNode(){

        }
}

public class RemLastNthNode {
    ListNode currentListNode = new ListNode();
    HashMap<Integer, ListNode> map = new HashMap<>();
    public ListNode removeNthFromEnd(ListNode head, int n) {
        currentListNode.next = head;
        int listLength = 0;
        map.put(0,currentListNode);
        currentListNode = currentListNode.next;
        while(currentListNode!=null){
            listLength++;
            map.put(listLength,currentListNode);
            currentListNode = currentListNode.next;
        }
        int prevNodeNumber = listLength - n ;
        ListNode prevNode = map.get(prevNodeNumber);
        prevNode.next = prevNode.next.next;
        return map.get(0).next;
        }


    }
