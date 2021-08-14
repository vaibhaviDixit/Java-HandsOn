package com.google;

public class JPR18 {
    public static void main(String[] args) {
        int y1 =5;
        int y2=3;
        int amount=161258;

        float EMI;
        //calculating emi for 5 years:
        float r=(5.0f/(12*100));
        float rpl1=1+r;
        float numerator= (float) (amount*r*Math.pow(rpl1,60));
        float denom= (float) (Math.pow(rpl1,60)-1);
        EMI=numerator/denom;
        System.out.println("EMI for amount "+amount+" of "+y1+" Years is: "+EMI);
        //calculating EMI for 3 years:
        r=(5.0f/(12*100));
        rpl1=1+r;
        numerator= (float) (amount*r*Math.pow(rpl1,36));
        denom= (float) (Math.pow(rpl1,36)-1);
        EMI=numerator/denom;
        System.out.println("EMI for amount "+amount+" of "+y2+" Years is: "+EMI);





    }
}
