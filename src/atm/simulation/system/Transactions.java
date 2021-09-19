
package atm.simulation.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Transactions extends JFrame implements ActionListener{

    JLabel l1;
    JButton Deposit,Withdrawl,Check_Balance,Mini_Statement,Fast_WithD,PIN_Change,Cancel;
    String pin;
    String card_no;
    public Transactions(String pin,String card_no) {
        
        setTitle("Transcations");
        setLayout(null);
        
        
        this.pin=pin;
        this.card_no=card_no;
        
        l1 = new JLabel("Select Your Transcation");
        l1.setBounds(480, 100, 700, 35);
        l1.setFont(new Font("Raleway",Font.BOLD,26));
        add(l1);
        
        Deposit =  new JButton();
        Withdrawl =  new JButton();
        Check_Balance =  new JButton();
        Mini_Statement =  new JButton();
        PIN_Change =  new JButton();
        Fast_WithD =  new JButton();
        Cancel =  new JButton();
        
        
        setBT(Deposit,400,250,150,35,"Deposit");
        setBT(Withdrawl,700,250,150,34,"Withdrawl");
        setBT(Check_Balance,400,330,150,35,"Check Balance");
        setBT(Mini_Statement,700,330,150,35,"Mini Statement");
        setBT(PIN_Change,400,410,150,35,"PIN Change");
        setBT(Fast_WithD,700,410,150,35,"User Profile");
        setBT(Cancel,650-125,500,250,35,"Cancel Transcation");
        
        
        Deposit.addActionListener(this);
        Withdrawl.addActionListener(this);
        Mini_Statement.addActionListener(this);
        Check_Balance.addActionListener(this);
        Fast_WithD.addActionListener(this);
        PIN_Change.addActionListener(this);
        Cancel.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(1600, 1080);
        setLocation(0, 0);
        setVisible(true);
        
    }
    
    public void setBT(JButton bt,int x,int y,int z,int w,String text)
    {
        bt.setText(text);
        bt.setFont(new Font("Raleway",Font.BOLD,16));
        bt.setBounds(x,y,z,w);
        bt.setForeground(Color.BLACK);
        add(bt);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==Deposit)
        {
            setVisible(false);
            new Deposit(card_no,pin).setVisible(true);
        }
        else if(e.getSource()==Withdrawl)
        {
            setVisible(false);
            new Withdrawl(card_no,pin).setVisible(true);
        }else if(e.getSource()==Check_Balance)
        {
            setVisible(false);
            new BalanceEnquiry(card_no,pin).setVisible(true);
            
        }else if(e.getSource()==Mini_Statement)
        {
            setVisible(false);
            new Mini_Statement(card_no,pin).setVisible(true);
            
        }else if(e.getSource()==PIN_Change)
        {
            setVisible(false);
            new PIN_Change(card_no,pin).setVisible(true);
            
        }else if(e.getSource()==Fast_WithD)
        {
            setVisible(false);
            new User_Profile(card_no,pin).setVisible(true);
            
        }else if(e.getSource() == Cancel)
        {
            setVisible(false);
            System.exit(0);
        }
        
        
    }
    
   
}
