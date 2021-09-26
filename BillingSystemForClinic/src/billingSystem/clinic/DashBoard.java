package billingSystem.clinic;
import billingSystem.jdbc.DbConnection;
import billingSystem.subFrames.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Color.*;

public class DashBoard extends JFrame implements ActionListener {

    JMenuBar mb=null;
    JMenu dash,patients,doctors,appoint,bill;
    JMenuItem addP,listP,addD,listD,addAp,listAp,gBill,listBill,logout,addSer;
    DashBoard(){
        setTitle("HappyLife Clinic");
        getContentPane().setBackground(WHITE);


        mb=new JMenuBar();
        mb.setBackground(black);
        mb.setFont(new Font("Tahoma",Font.BOLD,30));



       patients=new JMenu("Patients");
       Image i=new ImageIcon(ClassLoader.getSystemResource("billingSystem/img/pt.png")).getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT);
       patients.setIcon(new ImageIcon(i));
       patients.setForeground(WHITE);
       patients.setFont(new Font("Tahoma",Font.BOLD,18));
       mb.add(patients);
       addP=new JMenuItem("Add Patients");
       addP.addActionListener(this);
       addP.setBackground(white);
       addP.setFont(new Font("Tahoma",Font.BOLD,16));
       patients.add(addP);
       listP=new JMenuItem("List Patients");
       listP.addActionListener(this);
       listP.setBackground(white);
       listP.setFont(new Font("Tahoma",Font.BOLD,16));
       patients.add(listP);


        doctors=new JMenu("Doctors");
        Image dt=new ImageIcon(ClassLoader.getSystemResource("billingSystem/img/doc.png")).getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT);
        doctors.setIcon(new ImageIcon(dt));
        doctors.setForeground(WHITE);
        doctors.setFont(new Font("Tahoma",Font.BOLD,18));
        mb.add(doctors);
        addD=new JMenuItem("Add Doctors");
        addD.addActionListener(this);
        addD.setFont(new Font("Tahoma",Font.BOLD,16));
        doctors.add(addD);
        listD=new JMenuItem("List Doctors");
        listD.addActionListener(this);
        listD.setFont(new Font("Tahoma",Font.BOLD,16));
        doctors.add(listD);

        appoint=new JMenu("Appointments");
        Image app=new ImageIcon(ClassLoader.getSystemResource("billingSystem/img/app.png")).getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT);
        appoint.setIcon(new ImageIcon(app));
        appoint.setForeground(WHITE);
        appoint.setFont(new Font("Tahoma",Font.BOLD,18));
        mb.add(appoint);

        addAp=new JMenuItem("Add Appointment");
        addAp.addActionListener(this);
        addAp.setFont(new Font("Tahoma",Font.BOLD,16));
        appoint.add(addAp);
        listAp=new JMenuItem("List Appointments");
        listAp.addActionListener(this);
        listAp.setFont(new Font("Tahoma",Font.BOLD,16));
        appoint.add(listAp);

        bill=new JMenu("Bills");
        Image b=new ImageIcon(ClassLoader.getSystemResource("billingSystem/img/bi.png")).getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT);
        bill.setIcon(new ImageIcon(b));
        bill.setForeground(WHITE);
        bill.setFont(new Font("Tahoma",Font.BOLD,18));
        mb.add(bill);

        gBill=new JMenuItem("Generate Bill");
        gBill.addActionListener(this);
        gBill.setFont(new Font("Tahoma",Font.BOLD,16));
        bill.add(gBill);
        listBill=new JMenuItem("List Bills");
        listBill.addActionListener(this);
        listBill.setFont(new Font("Tahoma",Font.BOLD,16));
        bill.add(listBill);

        addSer=new JMenuItem("Add Services");
        Image ser=new ImageIcon(ClassLoader.getSystemResource("billingSystem/img/service.png")).getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT);
        addSer.setIcon(new ImageIcon(ser));
        addSer.setForeground(WHITE);
        addSer.setBackground(BLACK);
        addSer.setFont(new Font("Tahoma",Font.BOLD,18));
        addSer.addActionListener(this);
        mb.add(addSer);

        logout=new JMenuItem("Logout");
        Image log=new ImageIcon(ClassLoader.getSystemResource("billingSystem/img/lout.png")).getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT);
        logout.setIcon(new ImageIcon(log));
        logout.setForeground(WHITE);
        logout.setBackground(BLACK);
        logout.setFont(new Font("Tahoma",Font.BOLD,18));
        logout.addActionListener(this);
        mb.add(logout);

        mb.setBounds(0,0,900,50);
        setJMenuBar(mb);

        //background image
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("billingSystem/img/dashboard.jpg"));
        Image i1=img.getImage().getScaledInstance(900,600,Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(i1);
        JLabel l1=new JLabel(img);
        l1.setBounds(0,0,900,600);
        add(l1);


        JPanel totalPatients=new JPanel();
        totalPatients.setBackground(darkGray);
        totalPatients.setBounds(80,100,200,150);

        JLabel label1=new JLabel("Total Registered");
        label1.setFont(new Font("Tahoma",Font.BOLD,16));
        label1.setForeground(white);

        JLabel label2=new JLabel("Patients");
        label2.setFont(new Font("Tahoma",Font.BOLD,16));
        label2.setForeground(white);

        JLabel label3=new JLabel(String.valueOf(new DbConnection().getTotalPatients() ) );
        label3.setFont(new Font("Tahoma",Font.BOLD,18));
        label3.setForeground(white);

        label1.setBounds(30,50,200,50);
        label2.setBounds(70,70,100,50);
        label3.setBounds(90,100,100,50);

        ImageIcon patients=new ImageIcon(ClassLoader.getSystemResource("billingSystem/img/pt.png"));
        Image pt=patients.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        ImageIcon ptt=new ImageIcon(pt);
        JLabel ptimg=new JLabel(ptt);
        ptimg.setBounds(80,10,50,50);

        totalPatients.add(label1);
        totalPatients.add(label2);
        totalPatients.add(label3);

        totalPatients.add(ptimg);
        l1.add(totalPatients);

        totalPatients.setLayout(null);


        JPanel totalApp=new JPanel();
        totalApp.setBackground(darkGray);
        totalApp.setBounds(300,100,200,150);

        JLabel label4=new JLabel("Total");
        label4.setFont(new Font("Tahoma",Font.BOLD,16));
        label4.setForeground(white);

        JLabel label5=new JLabel("Appointments");
        label5.setFont(new Font("Tahoma",Font.BOLD,16));
        label5.setForeground(white);

        JLabel label6=new JLabel(String.valueOf(new DbConnection().getTotalAppointments() ) );
        label6.setFont(new Font("Tahoma",Font.BOLD,18));
        label6.setForeground(white);

        label4.setBounds(85,50,200,50);
        label5.setBounds(50,70,200,50);
        label6.setBounds(90,100,100,50);

        ImageIcon apps=new ImageIcon(ClassLoader.getSystemResource("billingSystem/img/app.png"));
        Image at=apps.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        ImageIcon apt=new ImageIcon(at);
        JLabel aptimg=new JLabel(apt);
        aptimg.setBounds(80,10,50,50);

        totalApp.add(label4);
        totalApp.add(label5);
        totalApp.add(label6);

        totalApp.add(aptimg);
        l1.add(totalApp);

        totalApp.setLayout(null);


        JPanel totalBills=new JPanel();
        totalBills.setBackground(darkGray);
        totalBills.setBounds(520,100,200,150);

        JLabel label7=new JLabel("Total");
        label7.setFont(new Font("Tahoma",Font.BOLD,16));
        label7.setForeground(white);

        JLabel label8=new JLabel("Bills Generated");
        label8.setFont(new Font("Tahoma",Font.BOLD,16));
        label8.setForeground(white);

        JLabel label9=new JLabel(String.valueOf(new DbConnection().getTotalBills() ) );
        label9.setFont(new Font("Tahoma",Font.BOLD,18));
        label9.setForeground(white);

        label7.setBounds(85,50,200,50);
        label8.setBounds(50,70,200,50);
        label9.setBounds(90,100,100,50);

        ImageIcon bills=new ImageIcon(ClassLoader.getSystemResource("billingSystem/img/bi.png"));
        Image bl=bills.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        JLabel billimg=new JLabel(new ImageIcon(bl));
        billimg.setBounds(80,10,50,50);

        totalBills.add(label7);
        totalBills.add(label8);
        totalBills.add(label9);

        totalBills.add(billimg);
        l1.add(totalBills);

        totalBills.setLayout(null);




        setLayout(null);
        setVisible(true);
        setBounds(200,40,900,650);
        setSize(900,600);
        setResizable(false);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Add Patients")){
            new AddPatients().setVisible(true);
        }
        else if(e.getActionCommand().equals("List Patients")){
            new ListPatients().setVisible(true);
        }
        else if(e.getActionCommand().equals("Add Doctors")){
            new AddDoctor().setVisible(true);
        }
        else if(e.getActionCommand().equals("List Doctors")){
            new ListDoctors().setVisible(true);
        }
        else if(e.getActionCommand().equals("Add Appointment")){
            new AddAppointment().setVisible(true);
        }
        else if(e.getActionCommand().equals("List Appointments")){
            new ListAppointments().setVisible(true);
        }
        else if(e.getActionCommand().equals("Generate Bill")){
            new AddBills().setVisible(true);
        }
        else if(e.getActionCommand().equals("List Bills")){
            new ListBills().setVisible(true);
        }
        else if(e.getActionCommand().equals("Add Services")){
            new AddServices().setVisible(true);
        }
        else if(e.getActionCommand().equals("Logout")){
            setVisible(false);
            new Login().setVisible(true);
        }


    }

    public static void main(String[] args) {
        new DashBoard().setVisible(true);
    }
}
