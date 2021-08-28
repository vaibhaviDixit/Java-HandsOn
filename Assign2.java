package com.google;
/*
Author: Vaibhavi Dixit
code for generate ID card of employees
* */
abstract class Employee{
    //fields for employee
    int idNo;
    String name;
    String company;
    String dept;
    String edu;
    long phone;
    String email;
    //parameterized constructor
    Employee(int idNo,String name, String company, String dept, String edu, long phone, String email){
        this.company=company;
        this.dept=dept;
        this.edu=edu;
        this.email=email;
        this.idNo=idNo;
        this.name=name;
        this.phone=phone;
    }

   abstract public void IdCard();
}
class ID extends Employee{
    ID(int idNo,String name, String company, String dept, String edu, long phone, String email){
        super(idNo,name,company,dept,edu,phone,email);
    }
    //abstract method implementation
    @Override
    public void IdCard() {
        System.out.println("************************");
        System.out.println(company);
        System.out.println("************************");
        System.out.print("ID: "+idNo);
        System.out.println("Name: "+name);
        System.out.println("Dept: "+dept);
        System.out.println("Edu: "+edu);
        System.out.println("Phone: "+phone);
        System.out.println("Email: "+email);
        System.out.println("************************");

    }
}

public class Assign2 {
    public static void main(String[] args) {
        ID i1=new ID(101,"Shiv Desai","Wipro Limited Corporation","Sales","BTech CS",1206733,"shiv123@gmail.com");
        i1.IdCard();
    }//main method ends
}//Assign2 ends
//output
/*
************************
 Wipro Limited Corporation
 ************************
 ID: 101Name: Shiv Desai
 Dept: Sales
 Edu: BTech CS
 Phone: 1206733
 Email: shiv123@gmail.com
 ************************


* */