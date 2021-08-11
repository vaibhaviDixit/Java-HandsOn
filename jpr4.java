package com.google;

public class jpr4 {
    static String s;
    static int a;
    static double d;
    static float f;
    int score=80;
    public static void main(String[] args) {
        System.out.println(s);
        System.out.println(a);
        System.out.println(d);
        System.out.println(f);
        System.out.println(score);//Error cannot access nonstatic from static
    }
}
