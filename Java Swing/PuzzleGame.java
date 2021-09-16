package swingGUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/*
Author : vaibhavi dixit
puzzle game
* */
public class PuzzleGame implements ActionListener {
    JFrame frame;
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9; //buttons
    int arr[][]={{0,0,0},
            {0,0,0},
            {0,0,0}
    }; //array to maintain clicks of user
    JLabel winningMsg;
    PuzzleGame(){
        frame=new JFrame("Puzzle Game");
        frame.setLayout(null);
        b1=new JButton("1");
        b1.setBounds(40,100,50,50);
        b1.setBackground(Color.LIGHT_GRAY);
        b1.addActionListener(this);
        frame.add(b1);

        b2=new JButton("2");
        b2.setBounds(100,100,50,50);
        b2.setBackground(Color.LIGHT_GRAY);
        b2.addActionListener(this);
        frame.add(b2);

        b3=new JButton("3");
        b3.setBounds(160,100,50,50);
        b3.setBackground(Color.LIGHT_GRAY);
        b3.addActionListener(this);
        frame.add(b3);

        b4=new JButton("4");
        b4.setBounds(40,160,50,50);
        b4.setBackground(Color.LIGHT_GRAY);
        b4.addActionListener(this);
        frame.add(b4);

        b5=new JButton("5");
        b5.setBounds(100,160,50,50);
        b5.setBackground(Color.LIGHT_GRAY);
        b5.addActionListener(this);
        frame.add(b5);

        b6=new JButton("6");
        b6.setBounds(160,160,50,50);
        b6.setBackground(Color.LIGHT_GRAY);
        b6.addActionListener(this);
        frame.add(b6);

        b7=new JButton("7");
        b7.setBounds(40,220,50,50);
        b7.setBackground(Color.LIGHT_GRAY);
        b7.addActionListener(this);
        frame.add(b7);

        b8=new JButton("8");
        b8.setBounds(100,220,50,50);
        b8.setBackground(Color.LIGHT_GRAY);
        b8.addActionListener(this);
        frame.add(b8);

        b9=new JButton("9");
        b9.setBounds(160,220,50,50);
        b9.setBackground(Color.LIGHT_GRAY);
        b9.addActionListener(this);
        frame.add(b9);

        winningMsg=new JLabel(" ");
        winningMsg.setBounds(180,300,100,40);
        frame.add(winningMsg);
        frame.setVisible(true);
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        System.out.println(e.getActionCommand());
                switch (e.getActionCommand()){
                    case "1":
                        arr[0][0]=1;
                        b1.setBackground(Color.GREEN);
                        break;
                    case "3":
                        arr[0][2]=1;
                        b3.setBackground(Color.GREEN);
                        break;
                    case "4":
                        arr[1][0]=1;
                        b4.setBackground(Color.GREEN);
                        break;
                    case "2":
                        arr[0][1]=1;
                        b2.setBackground(Color.BLUE);
                        break;
                    case "5":
                        arr[1][1]=1;
                        b5.setBackground(Color.BLUE);
                        break;
                    case "7":
                        arr[2][0]=1;
                        b7.setBackground(Color.BLUE);
                        break;
                    case "6":
                        arr[1][2]=1;
                        b6.setBackground(Color.CYAN);
                        break;
                    case "8":
                        arr[2][1]=1;
                        b8.setBackground(Color.CYAN);
                        break;
                    case "9":
                        arr[2][2]=1;
                        b9.setBackground(Color.CYAN);
                        break;

                }
                checkWin();//check if colors are matched

    }
    void checkWin(){

        if(arr[0][0]!=0 && arr[0][2]!=0 && arr[1][0]!=0){
//            System.out.println("Green wins");
            winningMsg.setText("Congratulations");

        }
        if(arr[0][1]!=0 && arr[1][1]!=0 && arr[2][0]!=0){
//            System.out.println("BLue wins");
            winningMsg.setText("Congratulations");

        }
        if(arr[1][2]!=0 && arr[2][1]!=0 && arr[2][2]!=0){
//            System.out.println("Cyan wins");
            winningMsg.setText("Congratulations");

        }


    }


    public static void main(String[] args) {
        PuzzleGame p1=new PuzzleGame();
    }

}
