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
    }
}
