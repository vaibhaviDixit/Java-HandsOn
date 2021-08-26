package com.google;
/*
Author: Vaibhavi Dixit
code for demonstrate abstract class
* */

//abstract class Calculation
abstract class Calculations{

    //abstract method result will be implemented by child class
    public abstract void result();
    void toDO(){
        System.out.println("Calculating arithmetic operations...");
    }
}

class Add extends Calculations{
    int x,y;
    Add(int a,int b){
        x=a;
        y=b;
    }
  //implementing abstract method of parent abstract class -Calcultions
    @Override
    public void result() {
        System.out.println("sum is :"+ (x+y));
    }
}

class Sub extends Calculations{
    int x,y;
    Sub(int a,int b){
        x=a;
        y=b;
    }

    //implementing abstract method of parent abstract class -Calcultions
    @Override
    public void result() {
        System.out.println("Subtraction is :"+ (x-y));
    }
}
class Mul extends Calculations{
    int x,y;
    Mul(int a,int b){
        x=a;
        y=b;
    }

    //implementing abstract method of parent abstract class -Calcultions
    @Override
    public void result() {
        System.out.println("Multiplication is :"+ (x*y));
    }
}

class Div extends Calculations{
    int x,y;
    Div(int a,int b){
        x=a;
        y=b;
    }
    //implementing abstract method of parent abstract class -Calcultions
    @Override
    public void result() {
        System.out.println("Division is :"+ (x/y));
    }
}

class Mod extends Calculations{
    int x,y;
    Mod(int a,int b){
        x=a;
        y=b;
    }
    //implementing abstract method of parent abstract class -Calcultions
    @Override
    public void result() {
        System.out.println("Remainder is :"+ (x%y));
    }
}

public class JPR25 {
    public static void main(String[] args) {
        //we cannot create object of interface so we are assigning child class of interface
        Calculations c=new Add(5,7);
        c.result();//Add class version of result method will be called

        c=new Sub(10,7);
        c.result();//Sub class version of result method will be called

        c=new Mul(50,6);
        c.result();//Mul class version of result method will be called

        c=new Div(30,7);
        c.result();//Div class version of result method will be called

        c=new Mod(50,6);
        c.result();//Mod class version of result method will be called

    }//main method ends
}//JPR25 class ends
/*
* Output:
        sum is :12
        Subtraction is :3
        Multiplication is :300
        Division is :4
        Remainder is :2

* */