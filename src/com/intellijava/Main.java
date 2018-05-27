package com.intellijava;

public class Main {
    public static void main(String[] args)
    {
        MyMap map= new MyMap();
        map.add("this",1 );
        map.add("coder",2 );
        map.add("that",3 );
        map.add("big",4 );
        map.add("small",5 );
        map.add("red",6 );
        map.add("tokyo",7 );
        map.add("osaka",8 );
        map.add("koto",9 );
        map.add("tsukishima",10 );
        map.add("kachidoki",11 );
        map.add("monzennakacho",12 );
        map.add("kiyosumishirakawa",13 );
        map.add("sumiyoshi",14 );
        map.add("morishita",15);
        map.add("kikukawa",16 );
        System.out.println(map.getSize());
        System.out.println(map.remove("this"));
        System.out.println(map.remove("this"));
        System.out.println(map.getSize());
        map.add("this",12);
        System.out.println(map.getValue("this"));
        System.out.println(map.getValue("tokyo"));
        System.out.println(map.remove("big"));
        System.out.println(map.remove("tokyo"));
        System.out.println(map.remove("morishita"));

        System.out.println(map.getSize());
        map.add("morishita",15);
        System.out.println(map.getSize());
        System.out.println(map.getValue("tokyo"));
        //System.out.println(map.getValue("tokyo"));
        System.out.println(map.isEmpty());
        System.out.println(map.getValue("kiyosumishirakawa"));

        System.out.println("LRU");
        LRUCache obj = new LRUCache(3);
        obj.put(1,1);
        obj.put(2,2);
        obj.put(3,3);
        obj.put(4,4);
        System.out.println(obj.get(4));
        System.out.println(obj.get(3));
        System.out.println(obj.get(2));
        System.out.println(obj.get(1));
        obj.put(5,5);
        //obj.put(4,1);
        System.out.println(obj.get(1));
       // obj.put(4,4);
        System.out.println(obj.get(2));
        System.out.println(obj.get(3));
        System.out.println(obj.get(4));
        System.out.println(obj.get(5));

        ListNode Node1 = new ListNode(1);
        //ListNode Node2 = new ListNode(2);
        //ListNode Node3 = new ListNode(3);
        //ListNode Node4 = new ListNode(4);
       // ListNode Node5 = new ListNode(5);

        //Node1.next=Node2;
        //Node2.next=Node3;
        //Node3.next=Node4;
        //Node4.next=Node5;

        RemoveLastNthNode remLastN = new RemoveLastNthNode();
        remLastN.removeNthFromEnd(Node1, 1);


    }
}
