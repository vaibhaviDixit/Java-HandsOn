package com.google;
import java.sql.*;
/*
Author :vaibhavi dixit
code to demonstrate fetch data from table using jdbc
* */
public class fetchData {
    public static void main(String[] args) {


        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //register driver class
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb?autoReconnect=true&useSSL=false", "root", "vaibhu");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from student"); //select all data from student table

                while(rs.next()){
                    //Display values
                    System.out.println("Roll no.: " + rs.getInt("roll"));
                    System.out.println("Name: " + rs.getString("name"));

                }
            con.close();
        } catch (Exception exp) {
            System.out.println(exp);
        }
    }
}
/*output:
Roll no.: 1
Name: Snehal
Roll no.: 2
Name: Pranali
*
* */