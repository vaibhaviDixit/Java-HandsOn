package com.google;
/*
* Author: Vaibhavi
*code to demonstrate exception handling
*
* */

public class IsEligible {
    //isEligible function takes age and give exception if age is less than 18
    void isEligible(int age){
        try{
            if(age>18){
                System.out.println("You are eligible to vote...");
            }
            else{
                //if age is less than 18 then throw exception
                throw new Exception("You are not eligible to vote");
            }
        }
        catch (Exception e){//catch exception and display message to user
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        IsEligible obj=new IsEligible();
        obj.isEligible(15);
    }
}
