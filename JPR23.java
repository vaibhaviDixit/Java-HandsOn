package com.google;
/*
Author: Vaibhavi Dixit
code for demonstrate constructor
* */
class Student{
    static String college="coep";
    String name;
    String Class;
    String div;
    String admiDate,Address,email;
    long phone;
    boolean isAdmit;
    //default constructor
    Student(){
        System.out.println("Default constructor");

    }
    //constructor overloading
    Student(String nm,String cls,String d){
        name=nm;
        Class=cls;
        div=d;
    }
    Student(String nm,String cls,String d,String adDate){
        name=nm;
        Class=cls;
        div=d;
        admiDate=adDate;

    }
    Student(String nm,String cls,String d,String adDate,String ad){
        name=nm;
        Class=cls;
        div=d;
        admiDate=adDate;
        Address=ad;
    }
    Student(String nm,String cls,String d,String adDate,String ad,String em,long ph){
        name=nm;
        Class=cls;
        div=d;
        admiDate=adDate;
        Address=ad;
        email=em;
        phone=ph;
    }

    void admit(){
        isAdmit=true;
        System.out.println("You are admitted to "+college);
    }
    void terminate(){
        isAdmit=false;
        System.out.println("You are terminated from "+college);
    }
    void changeDiv(String dv){
        div=dv;
        System.out.println("your division is changed now ..It's "+div);
    }
    void changeAdd(String ad){
        Address=ad;
        System.out.println("your address is changed now ..It's "+Address);
    }
    void changeMobile(long mob){
        phone=mob;
        System.out.println("your mobile no. is changed now ..It's "+phone);
    }
    void changeEmail(String em){
        email=em;
        System.out.println("your email is changed now ..It's "+email);
    }

    void printDetails(){
        String admit;
        if(isAdmit){
            admit="Admitted";
        }
        else{
            admit="not Admitted";
        }
        System.out.println(name+"\t"+Class+"\t"+div+"\t"+admiDate+"\t"+Address+"\t"+email+"\t"+phone+"\t"+admit);
    }


}
public class JPR23 {


    public static void main(String[] args) {

        //Creating Student class object
        Student s1=new Student(); //default constructor called...

        Student s2=new Student("Vaibhavi","FYCSE","A","5/7/2021","Pune","vaibhavi@gmail.com",92845521);

        //print details of s2
        s2.printDetails();

        //change address of s2
        s2.changeAdd("Sangli");

        //change email of s2
        s2.changeEmail("vaibhavi2711@gmail.com");

        //admit student
        s2.admit();

        Student s3=new Student("Sayali","TYMECH","d","3/8/2020");
        s3.printDetails();


    }
}
