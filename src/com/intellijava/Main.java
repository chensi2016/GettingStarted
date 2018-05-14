package com.intellijava;

public class Main {
    public static void main(String[] args)
    {
        MyMap map= new MyMap();
        map.add("this",1 );
        map.add("coder",2 );
        map.add("this",4 );
        map.add("hi",5 );
        System.out.println(map.getSize());
        System.out.println(map.remove("this"));
        System.out.println(map.remove("this"));
        System.out.println(map.getSize());
        System.out.println(map.isEmpty());
    }
}
