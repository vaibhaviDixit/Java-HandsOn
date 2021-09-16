package swingGUI;
import javax.swing.*;
import java.awt.event.*;
/*
Author : vaibhavi dixit
code for button event handling
* */

public class EventsHandling{
    JFrame f1;
    JButton yes,no;
    EventsHandling(){
        f1=new JFrame("Welcome");
        f1.setLayout(null);

        yes=new JButton("Yes");
        yes.setBounds(80,200,80,30);
        yes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //toggle lable of buttons
                if(e.getActionCommand()=="Yes"){
                    yes.setText("No");
                }
                if(e.getActionCommand()=="No"){
                    yes.setText("Yes");
               }
        }});
        f1.add(yes);

        no=new JButton("No");
        no.setBounds(210,200,80,30);
        no.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //toggle lable of buttons
                if(e.getActionCommand()=="No"){
                    no.setText("Yes");
                }
                if(e.getActionCommand()=="Yes"){
                    no.setText("No");
                }
            }
        });
        f1.add(no);


        f1.setSize(500,500);
        f1.setVisible(true);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    public static void main(String[] args) {
        EventsHandling ob=new EventsHandling();
    }//main ends
}//class ends
