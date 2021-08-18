package com.google;
/*
Author :Vaibhavi
code for calculate salary of employee
* */
public class Ass3 {
    public static void main(String[] args) {
        int avgOfThreeEmpInOneWeek=1000; //We have given that average salary of 3 employees in one week is 1000
        int E1_Salary=1100;
        int E2_Salary=500;
        float E3_Salary; // we have to find third employee salary

        // we know 1000(avg)=(1100(E1)+500(E2)+E3) / 3 .....3 because there are 3 employees
        //E3 =  1000*3 - (1100+500)
        E3_Salary= (float) ((avgOfThreeEmpInOneWeek*3.0)-(E1_Salary+E2_Salary));
        System.out.println("Salary of thid employee is: "+E3_Salary);
    }
}
