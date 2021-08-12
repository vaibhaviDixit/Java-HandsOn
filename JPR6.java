package com.google;

public class JPR6 {
    int a;
    String s;
    static{
        System.out.println("Static block ....Executed very first");
    }
    {
        System.out.println("Instance block....executed after object of class is created");
        System.out.println("Lets initialize instnce varibles here");
        a=50;
        s="Vaibhavi";
    }
    static{
        System.out.println("2nd static block");
    }

    public static void main(String[] args) {
        System.out.println("Create object of class...");
        JPR6 ob=new JPR6();
        System.out.println("check value of initialized variables in instance block");
        System.out.println("a= "+ob.a+" s= "+ob.s);

    }
}
