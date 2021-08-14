package com.google;

public class JPR17 {
    public static void main(String[] args) {
        int amount=161258;
        float simpleInterest,compoundInterest;
        //simple interest calculating
        simpleInterest=((amount*0.05f*1)/100)/12;
        System.out.println("Monthly Simple interest on amount "+amount+" is: "+simpleInterest);
        //compund interest calculating
        float rate=(1+(5.0f/100));
        compoundInterest=(amount*rate-amount)/12;
        System.out.println("Monthly Simple interest on amount "+amount+" is: "+compoundInterest);


    }
}
