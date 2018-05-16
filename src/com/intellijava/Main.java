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
        System.out.println(map.getSize());
        System.out.println(map.remove("this"));
        System.out.println(map.remove("this"));
        System.out.println(map.getSize());
        map.add("this",12);
        System.out.println(map.getValue("this"));
        System.out.println(map.getValue("tokyo"));
        System.out.println(map.getSize());
        System.out.println(map.isEmpty());
    }
}
