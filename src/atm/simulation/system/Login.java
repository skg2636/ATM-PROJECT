
package atm.simulation.system;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener{
    
    JLabel l1,l2,l3;
    JTextField t1;
    JPasswordField p1;
    JButton b1,b2,b3;

    Login()
    {
        setFont(new Font("System",Font.BOLD,22));
        Font f =getFont();
        FontMetrics fm = getFontMetrics(f);
        int x= fm.stringWidth("AUTOMATED TELLER MACHINE");
        int y=fm.stringWidth(" ");
        int z = getWidth() -x;
        int w = z/y;
        String pad="";
        pad = String.format("i"+w+"s",pad);
        setTitle(pad+"AUTOMATED TELLER MACHINE");
        
        
        l1= new JLabel("WELCOME TO ATM");
        l1.setFont(new Font("Osward",Font.BOLD,38));
        
        l2 = new JLabel("Card No:");
        l2.setFont(new Font("Osward",Font.BOLD,30));
        
        l3= new JLabel("PIN:");
        l3.setFont(new Font("Osward",Font.BOLD,30));
        
        t1 = new JTextField(16);
        p1= new JPasswordField(15);
        
        b1= new JButton("SIGN IN");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        
        b2= new JButton("CLEAR");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        
        b3= new JButton("SIGN UP");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        
        setLayout(null);
        
        l1.setBounds(200,40,450,40);
        add(l1);
        
        l2.setBounds(125,150,375,30);
        add(l2);
        
        l3.setBounds(125,220,375,30);
        add(l3);
        
        t1.setFont(new Font("Arial",Font.BOLD,14));
        t1.setBounds(300,150,230,30);
        add(t1);
        
        p1.setFont(new Font("Arial",Font.BOLD,14));
        p1.setBounds(300,220,230,30);
        add(p1);
        
        b1.setFont(new Font("Arial",Font.BOLD,14));
        b1.setBounds(300,400,100,30);
        add(b1);
        
        b2.setFont(new Font("Arial",Font.BOLD,14));
        b2.setBounds(430,400,100,30);
        add(b2);
        
        b3.setFont(new Font("Arial",Font.BOLD,14));
        b3.setBounds(300,450,230,30);
        add(b3);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(1600, 1080);
        setLocation(0, 0);
        setVisible(true);
        
        
    }
        @Override
    public void actionPerformed(ActionEvent ae){
        try{        
            if(ae.getSource()==b1){
                conn c1 = new conn();
                String cardno  = t1.getText();
                String pin  = p1.getText();
                String q  = "select * from login where card_no = '"+cardno+"' and pin = '"+pin+"'";

                ResultSet rs = c1.s.executeQuery(q);
                if(rs.next()){
                   new Transactions(pin,cardno).setVisible(true);
                   setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            }else if(ae.getSource()==b2){
                t1.setText("");
                p1.setText("");
            }else if(ae.getSource()==b3){
                setVisible(false);
                new SignUp().setVisible(true);
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e+" error");
        }
    }
    
     public static void main(String[] args){
        new Login().setVisible(true);
    }

    
    
}
