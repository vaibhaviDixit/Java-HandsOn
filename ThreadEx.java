package com.google;

//first way of creating thread:
//by extending Thread class
public class ThreadEx extends Thread{

    @Override
    public void run() {

        for (int i=0;i<5;i++){
            //get name of current thread using getName() method
            System.out.println("Thread "+this.getName()+" is running now : "+i);
        }
    }

    public static void main(String[] args) {
        //create object of 1st thread
        ThreadEx t1=new ThreadEx();
        //set name of t1 thread using setName method
        t1.setName("FirstThread");
        t1.start();//start t1 thread
        t1.yield(); //pause t1 temporary
        try {
            t1.join(); //start t2 after executing t1
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //create object of second thread
        ThreadByImplementing t2=new ThreadByImplementing();
        Thread th=new Thread(t2);
        th.start();



    }
}

//Seconf way of creating thread:
//by implementing Runnable interface
class ThreadByImplementing implements Runnable{
    @Override
    public void run() {

        for (char i='A';i<'F';i++){
            //getName() method is not present in Runnable interface so we cant access it here
            System.out.println("Thread 2 is running now : "+i);
        }
    }
}







