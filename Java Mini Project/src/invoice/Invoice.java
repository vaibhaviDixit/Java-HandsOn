package invoice;
import Supplier.Customer;
import Supplier.KitchenKing;
import jdbc.JDBC; //perform database related operations

import java.text.SimpleDateFormat;  //import this class to format date ccording to our need
import java.util.Date; //get current dat from util.Date class
import java.util.Scanner;

//generate invoice of customer
public class Invoice extends Customer {
    Date date = new Date();
    //format current date
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
    String currentDate = formatter.format(date);
    int invNo;
    long subtotal=0;
    long amount[];
    String productNames[];
    int productPrice[];
    float total;
    float CGST,SGST,GST;

    Invoice(){
        super();

    }
    //generate invoice of customer
    void generateInvoice(){

         JDBC jdbc=new JDBC();
         //get amount of product purchased
         amount=jdbc.generateAmount(super.productPurchased,super.productQuantity,super.productPurchased.length);
         //get name of product purchased
         productNames=jdbc.getProductName(super.productPurchased,super.productPurchased.length);
         //get price of product purchased
         productPrice=jdbc.getProductPrice(super.productPurchased,super.productPurchased.length);
         //calculate subtotal by adding amount of all purchased products
        for(int i=0;i<amount.length;i++){
            subtotal+=amount[i];
        }
        //calculate CGST SGST
        CGST= (float) (0.09*subtotal);
        SGST= (float) (0.09*subtotal);
        GST=CGST+SGST;
        total=(CGST+SGST+subtotal);
        //insert all invoice details into database and get id of invoice
        invNo=jdbc.insertIntoInvoice(currentDate,super.name,super.email,super.phone,subtotal,GST,total);

        //Display invoice to user
        System.out.println("This is your invoice :-");
        System.out.println("______________________________________________________________________");
         System.out.println("\t\t\t\t\t\t\t Invoice\t\t\t\t\t\t\t ");
        System.out.println("______________________________________________________________________");
         System.out.println("|From:\t\t\t\t\t\t\t\tTo:\t\t\t\t\t\t\t|");
        System.out.println("| "+ KitchenKing.name+"\t\t\t\t\t\t\t"+super.name);
        System.out.println("| "+KitchenKing.address+"\t\t\t\t\t"+super.address);
        System.out.println("| "+KitchenKing.email+"\t\t\t\t\t"+super.email);
        System.out.println("| "+KitchenKing.phone+"\t\t\t\t\t\t\t"+super.phone);
        System.out.println("______________________________________________________________________");
        System.out.println("| Invoice no.: "+invNo+"\t\t\t\t\t Date: "+currentDate);
        System.out.println("______________________________________________________________________");
        System.out.println("Product\t\t\t Quantity\t\tUnit Price\t\tAmount  ");
        System.out.println("______________________________________________________________________");
        for (int i=0;i<productNames.length;i++){
            System.out.println(productNames[i]+"\t\t\t"+productQuantity[i]+"\t\t\tRs."+productPrice[i]+"\t\t\tRs."+amount[i]);
        }
        System.out.println("______________________________________________________________________");

        System.out.println("\t\t\t\t\t\t\t\t\tSubtotal: Rs."+subtotal);
        System.out.println("\t\t\t\t\t\t\t\t\t\tCGST: Rs."+CGST);
        System.out.println("\t\t\t\t\t\t\t\t\t\tSGST: Rs."+SGST);
        System.out.println("\t\t\t\t\t\t\t\t\t\tTotal: Rs."+total);
        System.out.println("______________________________________________________________________");

    }

   //starting of program flow
    public static void main(String[] args) {
        Invoice inv=new Invoice();
        //first welcome user
        inv.welcome();
        while(true){
            //get choice of user
            System.out.println("Enter your choice:(1/2/3/4) ");
            System.out.println("1. Admin login ");
            System.out.println("2. Buy products");
            System.out.println("3. View products");
            System.out.println("4. Exit");

            Scanner scan=new Scanner(System.in);
            int choice=scan.nextInt();
            if(choice==1){
                //this is for admin only
                System.out.println("----------------");
                System.out.println("Enter username: ");
                String uname=scan.next();
                System.out.println("----------------");
                System.out.println("Enter password: ");
                String pass=scan.next();
                //verify username and password of admin
                if(uname.equals("invoice") && pass.equals("kitchenking")){
                    System.out.println("Enter your choice \n1. to add products \n2. to Exit ");
                    choice=scan.nextInt();
                    if(choice==1){
                        System.out.println("Enter no. of products you want to add");
                        Scanner sc=new Scanner(System.in);
                        int n=sc.nextInt();
                        //enter name and price of products admin wants to add
                        for(int i=0;i<n;i++){
                            Scanner s=new Scanner(System.in);
                            System.out.println("Enter name of product : "+(i+1));
                            String name=s.nextLine();
                            System.out.println("Enter price of product: "+(i+1));
                            int price=s.nextInt();
                            inv.addProducts(name,price);

                        }
                        System.out.println("Products added successfully.");
                    }
                    else if(choice==2){
                        break;
                    }
                    else{
                        System.out.println("Invalid choice");
                    }

                }
                else{
                    System.out.println("Invalid username or password");
                }

            }
            else if(choice==2){
                System.out.println("Our products :- \t\t\t\t");
                inv.displayProducts();
                System.out.println("Enter no of products you want to buy...");
                int n=scan.nextInt();
                //customer buy products
                inv.buyProducts(n);
                //get details of customer
                inv.getDetails();
                //generate invoice for customer
                inv.generateInvoice();



            }
            else if(choice==3){
                //display products to user
                inv.displayProducts();
            }
            else if(choice==4){
                System.out.println("Thank you");
                break;
            }
            else{
                System.out.println("Invalid choice...");
            }
        }


    }//main method ends here


}//Invoice class ends here
