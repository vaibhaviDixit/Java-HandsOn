package Supplier;
import Supplier.KitchenKing; //import kichenking class because we have to deal with customers of this company

import java.util.Scanner;

//extend kitchenking class because this customer is related to that company(kitchenking class)
public class Customer extends KitchenKing {
    //declare variables for details of customer
    protected String name;
    protected String address;
    protected String email;
    protected String phone;
    //declare arrays for product and their quantity purchased by customer
    public int productPurchased[];
    public int productQuantity[];



    public Customer() {

    }

    //get details from customer
    protected void getDetails(){
        Scanner scan=new Scanner(System.in);
        System.out.println("***************************");
        System.out.println("Enter your name: ");
        name=scan.nextLine();
        System.out.println("Enter your address: ");
        address=scan.nextLine();
        System.out.println("Enter your email: ");
        email=scan.next();
        System.out.println("Enter your phone: ");
        phone=scan.next();
        System.out.println("******Thank you******");
    }

    //customer want to buy products ...
    //this method takes number of products customer(end user) want to buy
    protected void buyProducts(int n){
        productPurchased=new int[n];
        productQuantity=new int[n];
        System.out.println("-------------------------");
        Scanner scan=new Scanner(System.in);
        //enter id and quantity of product which customer wants to buy
        for(int i=0;i<n;i++){
            System.out.println("Enter id of product...");
            int id=scan.nextInt();
            productPurchased[i]=id;
            System.out.println("Enter quantity of product...");
            int quan=scan.nextInt();
            productQuantity[i]=quan;
        }
    }


}
