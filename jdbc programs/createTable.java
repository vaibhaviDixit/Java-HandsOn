package com.google;
import java.sql.*;
/*
Author :vaibhavi dixit
code to demonstrate create table using jdbc
* */
public class createTable {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); //register driver class
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb?autoReconnect=true&useSSL=false","root","vaibhu");

            Statement stmt=con.createStatement();
            String rs="create table student(roll int(3),name varchar(100))";//create table student
            stmt.executeUpdate(rs);
            System.out.println("table created successfully...");
            con.close();
        }
        catch(Exception exp)
        { System.out.println(exp);
        }
    }

}
