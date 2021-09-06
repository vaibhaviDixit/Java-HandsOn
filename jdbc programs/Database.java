package com.google;
import java.sql.*;
/*
Author :vaibhavi dixit
code to demonstrate create database using jdbc
* */
public class Database {

    public static void main(String args[]){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); //register driver class
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javaDB?autoReconnect=true&useSSL=false","root","vaibhu");

            Statement stmt=con.createStatement();
            String rs="create database testDB";//create database query
            stmt.executeUpdate(rs);
            System.out.println("Database created successfully...");
            con.close();
        }
        catch(Exception exp)
        { System.out.println(exp);
        }
    }

}
