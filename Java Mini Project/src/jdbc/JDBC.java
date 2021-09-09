package jdbc;
import java.sql.*; //import sql package to perform database related operations
import java.util.Date;//import Date from util package to get current date

/*
* Here i am creating JDBC class which
* will perform all the operation related
* to database like: create table,
* insert values into table,
* fetch values from table
* */
public class JDBC {
    //temporary initialize objects as null further we will initialize them
    Connection con=null;
    Statement stmt=null;
    PreparedStatement pstmt=null;

    //in JDBC default constructor we are connecting to database
     public JDBC(){
         try{
             //load mysql driver in memory(it can throw exception)
             Class.forName("com.mysql.cj.jdbc.Driver");
             //creating jdbc connection
             con=DriverManager.getConnection("jdbc:mysql://localhost:3306/KitchenKing?autoReconnect=true&useSSL=false","root","vaibhu");
         }
         catch (Exception e){
             e.printStackTrace();
         }


     }
     //function to create table in database
     void createTable(){
         //create 2 tables
         //create products table
         String q1="create table products(pid int(10) primary key auto_increment,pname varchar(40) not null, price int(20) )";
         //create invoice table
         String q2="create table invoice(id int(10) primary key auto_increment, invoiceDate date not null,custName varchar(30) not null,custEmail varchar(30) not null,custPhone varchar(30) not null,subTotal int(20),gst decimal(8,2),total decimal(13,2) ) ";

         try{
             //create statement
             stmt=con.createStatement();
             //call executeUpdate method because we are not fetching any data just updating it
             stmt.executeUpdate(q1);
             stmt.executeUpdate(q2);

         }
         catch (Exception e){
             e.printStackTrace();
         }

     }
    //method to insert values into product table
     public void insertIntoProduct(String pname,int price){

          String sql="insert into products(pname,price) values(?,?)";
         try {
             //to create dynamic query we need preparedStatement
             pstmt=con.prepareStatement(sql);
             //set values at particular position in query
             pstmt.setString(1,pname);
             pstmt.setInt(2,price);
             //call executeUpdate method because we are not fetching any data just updating it
             pstmt.executeUpdate();

         } catch (SQLException e) {
             e.printStackTrace();
         }


     }
     //method to display all the products from products table
     public void dispProducts(){
         String fetch="select * from products";
         try {
             stmt=con.createStatement();
             //select all records from products table
             ResultSet result= stmt.executeQuery(fetch);

             //display products
             System.out.println("^^^^^^^^^^^^^^^^^^ Products ^^^^^^^^^^^^^^^^^^");
             while (result.next()){
                 System.out.println("> "+result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getInt(3));

             }
             System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");

         } catch (SQLException e) {
             e.printStackTrace();
         }


     }

     /*
     this method gets array of id of products purchased,array of quantity of products purchased
     and length of array to generate array of amount of products purchased
      */
     public long[] generateAmount(int productPurchased[],int productQuantity[],int length){
          long amountArray[]=new long[length];
          try{
            String q="select * from products where pid=?";
            pstmt=con.prepareStatement(q);
            for(int i=0;i<productPurchased.length;i++){
                pstmt.setInt(1,productPurchased[i]);
                ResultSet r=pstmt.executeQuery();
                while (r.next()){
                    int price=r.getInt(3);
                    amountArray[i]=price*productQuantity[i];

                }
            }


          }
          catch (Exception e){
              System.out.println(e);
          }

         return amountArray;
     }
     /*
     This method gets array of id of product purchased ,length of array
     and return array of product names with respect to id
     * */
     public String[] getProductName(int productPurchased[],int length){
       String[] productnames=new String[length];//allocate memory for array
         try{
             //select rows from products matching with id given in productPurchased array
             String q="select * from products where pid=?";
             pstmt=con.prepareStatement(q);
             for(int i=0;i<productPurchased.length;i++){
                 pstmt.setInt(1,productPurchased[i]);
                 ResultSet r=pstmt.executeQuery();
                 //fetch names of products
                 while (r.next()){
                     String pName=r.getString(2);
                     //add name of product in array
                     productnames[i]=pName;
                 }
             }

         }
         catch (Exception e){
             System.out.println(e);
         }
        return productnames;//return array of name of products
     }

    /* this method takes array of id of product purchased and
      return array of price of product purchased*/
    public int[] getProductPrice(int productPurchased[],int length){
        int[] productPrice=new int[length];
        try{
            String q="select * from products where pid=?";
            pstmt=con.prepareStatement(q);
            for(int i=0;i<productPurchased.length;i++){
                pstmt.setInt(1,productPurchased[i]);
                ResultSet r=pstmt.executeQuery();
                //get price of product purchased
                while (r.next()){
                    int price=r.getInt(3);
                    //stor price of product in array
                    productPrice[i]=price;
                }
            }

        }
        catch (Exception e){
            System.out.println(e);
        }
        return productPrice; //return array of price of product purchased
    }

   //this method insert values into invoice table and return id of row inserted in table
    public int insertIntoInvoice(String invoiceDate,String custName,String custEmail,String custPhone,long subTotal,float gst,float total){
        String sql="insert into invoice(invoiceDate,custName,custEmail,custPhone,subTotal,gst,total) values(?,?,?,?,?,?,?)";
        try {
            /*
            here we ar passing to arguments to prepareStatement
            one is sql query a
            2nd is constant for returning key generated by inserting records into table
            * */

            pstmt=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            //to set date in database we need to convert java date to sql date
            pstmt.setDate(1, new java.sql.Date(new Date().getTime()));
            //set other parameters with respect to column
            pstmt.setString(2,custName);
            pstmt.setString(3,custEmail);
            pstmt.setString(4,custPhone);
            pstmt.setLong(5,subTotal);
            pstmt.setFloat(6,gst);
            pstmt.setFloat(7,total);
            //execute update -because we are not fetching any data
            pstmt.executeUpdate();
            //getGeneratedKeys() method returns key(in this case id of invoice table) generated by
            // inserting row in table
            ResultSet rs=pstmt.getGeneratedKeys();
            if(rs.next()){
                //get that id and return id
                return rs.getInt(1);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;

    }
    public static void main(String[] args) {
        JDBC jdbc=new JDBC();
//        jdbc.createTable();

    }


}
