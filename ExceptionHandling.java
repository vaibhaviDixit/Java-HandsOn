package com.google;
/*
 * Author: Vaibhavi
 *code to demonstrate exception handling
 *
 * */

public class ExceptionHandling {
    void div(int a,int b){
        try{
           int result= a/b;
            System.out.println("Result is : "+result);
        }
        catch (ArithmeticException ae){
            System.out.println("cannot divide by zero");
        }
        catch (Exception e){
            System.out.println(e);
        }

    }
    public static void main(String[] args) {

        ExceptionHandling obj=new ExceptionHandling();
        obj.div(2,0);

    }
}
