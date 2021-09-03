package com.google;
import java.io.*;
/*
* Author:vaibhavi
* code to demonstrate file handling in java
* */

public class WriteIO {
    public static void main(String[] args) {

        File f=null;
        FileOutputStream fos=null;
        BufferedOutputStream bos=null;

        String s=" Never give up !";
       //write into file
        try{
            f=new File("E:\\myfile.txt");
            if(!f.exists()){
                f.createNewFile();//if file nor=t exu=istes create new one
            }
            fos=new FileOutputStream(f);
            bos=new BufferedOutputStream(fos);
            byte b[]=s.getBytes();
            bos.write(b);//write into file



        }catch(Exception e){
                e.printStackTrace();
        }
        finally {
            //this code will execute always even try or catch executed or not
            try{

            if(fos!=null && bos!=null){
                bos.flush();
                fos.close();
                bos.close();

            }

            }
            catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("File written successfully");
        }
    //Read from file
        FileInputStream fin=null;
        BufferedInputStream bin=null;
        try{
         fin=new FileInputStream(f);
         bin=new BufferedInputStream(fin);
            int i;
            while((i=bin.read())!=-1){ //read byte from file untill it return -1 means file empty...
                System.out.print((char)i);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                if(fin!=null & bin!=null){
                        fin.close();
                        bin.close();
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }


       //append to the file
     String append="Keep learning...";
        try{
           fos=new FileOutputStream(f,true);//pass true as second argument  to enable append to the file
           bos=new BufferedOutputStream(fos);
           bos.write(append.getBytes());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try{

                if(fos!=null && bos!=null){
                    bos.flush();
                    fos.close();
                    bos.close();

                }

            }
            catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("File append successful");
        }

    }


}
