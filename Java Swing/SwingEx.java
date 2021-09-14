package swingGUI;
import javax.swing.*;
import java.awt.*;

/*
Author :Vaibhavi Dixit
* */
public class SwingEx {

    JFrame j1;
    SwingEx(){
        j1=new JFrame("Welcome");//create jframe and set title as Welcome
        JButton jb1=new JButton("Click");//create button
        j1.add(jb1);//add button on frame
        j1.setLayout(new FlowLayout()); //set layout of frame
        j1.setSize(500,500);//set size of frame
        j1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j1.setVisible(true);//set visibility

    }
    public static void main(String[] args) {
        SwingEx obj1=new SwingEx();
    }//main method ends
}//class ends
