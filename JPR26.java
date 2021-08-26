package com.google;
/*
Author: Vaibhavi Dixit
code for demonstrate interface
* */

//interface Calculate
interface Calculate{
    //methods of interface are by default public abstract
    // ...we should implement abstract methods in child class
    void Add(int a,int b);
    void Sub(int a,int b);
    void Mul(int a,int b);
    void Div(int a,int b);
    void Mod(int a,int b);
}

//class Arithmetic implementing Calculate interface
class Arithmetic implements Calculate{
/*    Override all methods of interface
    note interface methods are public by default
     so we should override them as public access modifier otherwise error will occurred...
     we cant give weaker access privilege to overridden method*/
    @Override
    public void Add(int a, int b) {
        System.out.println("sum is :"+ (a+b));
    }

    @Override
    public void Sub(int a, int b) {
        System.out.println("substraction is :"+ (a-b));
    }

    @Override
    public void Mul(int a, int b) {
        System.out.println("Multiplication is :"+ (a*b));
    }

    @Override
    public void Div(int a, int b) {
        System.out.println("Division is :"+ (a/b));
    }

    @Override
    public void Mod(int a, int b) {
        System.out.println("MOd is :"+ (a%b));
    }
}
public class JPR26 {
    public static void main(String[] args) {
          Calculate c=new Arithmetic();
          //calling methods of Arithmetic class
          c.Add(3,6);
          c.Sub(4,1);
          c.Mul(4,8);
          c.Div(40,5);
          c.Mod(20,5);
    }
}
/*
Output:
sum is :9
substraction is :3
Multiplication is :32
Division is :8
MOd is :0
* */