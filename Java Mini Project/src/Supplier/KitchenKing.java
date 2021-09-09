package Supplier;
import jdbc.*;//import user defined jdbc package to perform database related operations


//product interface
interface products{
    //this 2 functions must implemented by child classes of products interface
    void addProducts(String pname,int price);
    void displayProducts();
}
//KichenKing is name of company which sales kitchen related products
public class KitchenKing implements products {
    //details of KitchenKing company
    protected static String name = "Kitchen King";
    protected static String email = "kitchenking@yahoo.com";
    protected static String address = "Station Road,sangola";
    protected static String phone = "9284552192";
    protected static String GSTIN = "22AAAAA0077A1Z5";
    //create object of JDBC class to connect with database
    JDBC jdbc = new JDBC();

    //implement methods of interface products
    //addProducts method add products into products table
    @Override
    public void addProducts(String pname, int price) {
        jdbc.insertIntoProduct(pname, price);//call method in jdbc to insert data in table

    }

    @Override
    public void displayProducts() {
        jdbc.dispProducts();//display products to user by fetching them from database
    }

    //welcome user to kitchenKing company
    public void welcome() {
        System.out.println("-------------------------------------------------------");
        System.out.println("|\t\t\t\tWelcome to " + name + "\t\t\t\t|");
        System.out.println("-------------------------------------------------------");

    }
}
