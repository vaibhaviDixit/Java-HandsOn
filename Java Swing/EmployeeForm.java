package swingGUI;
import javax.swing.*;
/*
Author : vaibhavi dixit
code for employee joining form
* */

public class EmployeeForm {
    JFrame jf=null;
    JLabel name,email,phone,add,deg;
    JTextField nm,em,ph;
    JTextArea address;
    JRadioButton gender1,gender2;
    JComboBox degree;
    EmployeeForm(){
        jf=new JFrame("Joining Form");//set title of frame
        jf.setLayout(null);//set layout of frame
        JLabel title=new JLabel("Employee joining Form");
        title.setBounds(150,50,300,40);

        //Labels
        name=new JLabel("Name: ");
        name.setBounds(40,120,100,30);
        email=new JLabel("Email: ");
        email.setBounds(40,160,100,30);
        phone=new JLabel("Phone: ");
        phone.setBounds(40,200,100,30);
        add=new JLabel("Address: ");
        add.setBounds(40,240,100,30);
        deg=new JLabel("Degree: ");
        deg.setBounds(40,370,200,30);

        //text fields
        nm=new JTextField();
        nm.setBounds(150,120,200,30);
        em=new JTextField();
        em.setBounds(150,160,200,30);
        ph=new JTextField();
        ph.setBounds(150,200,200,30);
        address=new JTextArea();
        address.setBounds(150,240,200,70);
        gender1=new JRadioButton("Male");
        gender2=new JRadioButton("Female");
        gender1.setBounds(40,320,100,30);
        gender2.setBounds(160,320,100,30);
        String items[]={"BTech","BE","MTech","ME"};
        degree=new JComboBox(items);
        degree.setBounds(160,370,200,30);
        JButton submit=new JButton("Submit");
        submit.setBounds(170,440,100,30);

        //add components to the frame
        jf.add(name);jf.add(email);jf.add(phone);jf.add(add);jf.add(deg);
        jf.add(nm);jf.add(em);jf.add(ph);jf.add(address);
        jf.add(gender1);jf.add(gender2);
        jf.add(degree);jf.add(title);jf.add(submit);

        jf.setVisible(true);//set visibility of frame
        jf.setSize(500,600);//set size of frame
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new EmployeeForm();//crete anonymous instance of class
    }//main ends
}//class ends
