
package atm.simulation.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Deposit extends JFrame implements ActionListener {

    HashMap<Integer,Integer> count = new HashMap<>();
    
    
    
    private String card,pin;
    private JLabel msg,N2000,N500,N200,N100,N50,N20,N10,total_amt;
    private JTextField n2000,n500,n200,n100,n50,n20,n10;
    private JButton cancel_trans,prev_menu,confirm,calculate;
    private  int DEPOSIT_AMOUNT;
    double new_bal;
    private String DEP_STATUS = "";
    
    public Deposit(String card, String pin) {
        
        count.put(2000, 0);
        count.put(500, 0);
        count.put(200, 0);
        count.put(100, 0);
        count.put(50, 0);
        count.put(20, 0);
        count.put(10, 0);
        
        
        
        
        
        this.card = card;
        this.pin = pin;
        
        
        
        
        setTitle("CASH DEPOSIT");
        setLayout(null);
        
        
        msg = new JLabel("Please enter your cash denomination details:");
        msg.setBounds(400,50,700,35);
        msg.setFont(new Font("Raleway",Font.BOLD,26));
        add(msg);
        
        JLabel note_txt = new JLabel("Notes");
        note_txt.setBounds(300,150,70,30);
        note_txt.setFont(new Font("Raleway",Font.BOLD,24));
        add(note_txt);
        
        JLabel count_txt = new JLabel("Count");
        count_txt.setBounds(550,150,70,30);
        count_txt.setFont(new Font("Raleway",Font.BOLD,24));
        add(count_txt);
        
        
        N2000 = new JLabel("Rs. 2000");
        N2000.setBounds(300,210,100,28);
        N2000.setFont(new Font("Raleway",Font.BOLD,24));
        add(N2000);
        
        JLabel x1 = new JLabel("X");
        x1.setBounds(450,210,80,28);
        x1.setFont(new Font("Raleway",Font.BOLD,24));
        add(x1);
        
        n2000 = new JTextField();
        n2000.setBounds(550,210,80,28);
        n2000.setFont(new Font("Raleway",Font.BOLD,24));
        n2000.setText("0");
        add(n2000);
        
        N500 = new JLabel("Rs. 500");
        N500.setBounds(300,260,100,28);
        N500.setFont(new Font("Raleway",Font.BOLD,24));
        add(N500);
        
        JLabel x2 = new JLabel("X");
        x2.setBounds(450,260,80,28);
        x2.setFont(new Font("Raleway",Font.BOLD,24));
        add(x2);
        
        n500 = new JTextField();
        n500.setBounds(550,260,80,28);
        n500.setFont(new Font("Raleway",Font.BOLD,24));
        n500.setText("0");
        add(n500);
        
        N200 = new JLabel("Rs. 200");
        N200.setBounds(300,310,100,28);
        N200.setFont(new Font("Raleway",Font.BOLD,24));
        add(N200);
        
        
        JLabel x3 = new JLabel("X");
        x3.setBounds(450,310,80,28);
        x3.setFont(new Font("Raleway",Font.BOLD,24));
        add(x3);
        
        n200 = new JTextField();
        n200.setBounds(550,310,80,28);
        n200.setFont(new Font("Raleway",Font.BOLD,24));
        n200.setText("0");
        add(n200);
        
        
        N100 = new JLabel("Rs. 100");
        N100.setBounds(300,360,100,28);
        N100.setFont(new Font("Raleway",Font.BOLD,24));
        add(N100);
        
        JLabel x4 = new JLabel("X");
        x4.setBounds(450,360,80,28);
        x4.setFont(new Font("Raleway",Font.BOLD,24));
        add(x4);
        
        n100 = new JTextField();
        n100.setBounds(550,360,80,28);
        n100.setFont(new Font("Raleway",Font.BOLD,24));
        n100.setText("0");
        add(n100);
        
        N50 = new JLabel("Rs. 50");
        N50.setBounds(300,410,100,28);
        N50.setFont(new Font("Raleway",Font.BOLD,24));
        add(N50);
        
        JLabel x5 = new JLabel("X");
        x5.setBounds(450,410,80,28);
        x5.setFont(new Font("Raleway",Font.BOLD,24));
        add(x5);
        
        n50 = new JTextField();
        n50.setBounds(550,410,80,28);
        n50.setFont(new Font("Raleway",Font.BOLD,24));
        n50.setText("0");
        add(n50);
        
        N20 = new JLabel("Rs. 20");
        N20.setBounds(300,460,100,28);
        N20.setFont(new Font("Raleway",Font.BOLD,24));
        add(N20);
        
        JLabel x6 = new JLabel("X");
        x6.setBounds(450,460,80,28);
        x6.setFont(new Font("Raleway",Font.BOLD,24));
        add(x6);
        
        n20 = new JTextField();
        n20.setBounds(550,460,80,28);
        n20.setFont(new Font("Raleway",Font.BOLD,24));
        n20.setText("0");
        add(n20);
        
        N10 = new JLabel("Rs. 10");
        N10.setBounds(300,510,100,28);
        N10.setFont(new Font("Raleway",Font.BOLD,24));
        add(N10);
        
        JLabel x7 = new JLabel("X");
        x7.setBounds(450,510,80,28);
        x7.setFont(new Font("Raleway",Font.BOLD,24));
        add(x7);
        
        n10 = new JTextField();
        n10.setBounds(550,510,80,28);
        n10.setFont(new Font("Raleway",Font.BOLD,24));
        n10.setText("0");
        add(n10);
        
        total_amt = new JLabel("Total Amount : ");
        total_amt.setBounds(450,560,400,30);
        total_amt.setFont(new Font("Raleway",Font.BOLD,26));
        add(total_amt);
        
        
        
        
        prev_menu = new JButton("Previous Menu");
        prev_menu.setBounds(750,400,250,32);
        prev_menu.setFont(new Font("Raleway",Font.BOLD,24));
        add(prev_menu);
        prev_menu.setForeground(Color.BLACK);
        prev_menu.addActionListener(this);
        
        cancel_trans = new JButton("Cancel Transcation");
        cancel_trans.setBounds(750,450,250,32);
        cancel_trans.setFont(new Font("Raleway",Font.BOLD,22));
        add(cancel_trans);
        cancel_trans.setForeground(Color.BLACK);
        cancel_trans.addActionListener(this);
        
        confirm = new JButton("Deposit Rs. "+DEPOSIT_AMOUNT+"/-");
        confirm.setBounds(750,350,250,32);
        confirm.setFont(new Font("Raleway",Font.BOLD,22));
        add(confirm);
        confirm.setForeground(Color.BLACK);
        confirm.addActionListener(this);
        
        calculate = new JButton("Calculate Amount");
        calculate.setBounds(750,300,250,32);
        calculate.setFont(new Font("Raleway",Font.BOLD,22));
        add(calculate);
        calculate.setForeground(Color.BLACK);
        calculate.addActionListener(this);
        
       
        
        getContentPane().setBackground(Color.WHITE);
        setSize(1600,1080);
        setLocation(0, 0);
        setVisible(true);
    }
    
   
    
    
   
    
    @Override
    public void actionPerformed(ActionEvent e) {

        
       if (e.getSource() == cancel_trans)
       {
           int result = JOptionPane.showConfirmDialog(null, 
                         "Are you sure you wish to exit?",null, JOptionPane.YES_NO_OPTION);
                if(result == JOptionPane.YES_OPTION) {
                                     System.exit(0);
                                    } 
       }else if(e.getSource() == calculate)
       {
           
           if(CALCULATE()==0)
           {
               DEPOSIT_AMOUNT=0;
                for (HashMap.Entry<Integer,Integer> entry : count.entrySet())
                {
                    DEPOSIT_AMOUNT+= entry.getKey()*entry.getValue();
                }
               confirm.setText("Deposit Rs. "+DEPOSIT_AMOUNT+"/-");
               total_amt.setText("Total Amount : "+DEPOSIT_AMOUNT+"/-");
                
               
           }else if(CALCULATE()==-1)
           {
               JOptionPane.showMessageDialog(null,
                    "Error: Please a valid number", "Error Message",
                    JOptionPane.ERROR_MESSAGE);
           }
           
            
       }else if (e.getSource() == prev_menu)
       {
           setVisible(false);
           new Transactions(card,pin).setVisible(true);
       }else if (e.getSource() == confirm)
       {
           if(DEPOSIT_AMOUNT==0)
           {
                JOptionPane.showMessageDialog(null,
                    "Deposit Amount Cannot be zero", "Error Message",
                    JOptionPane.ERROR_MESSAGE);
           }else{
           startDeposit();
           }
       }
    }
    
    
    public void startDeposit()
    {
        
        double prev_bal = 0;
        try {
            conn c1 = new conn();
            
            ResultSet rs = c1.s.executeQuery("select balance from login where pin = '"+pin+"' and card_no = '"+card+"'");
        
            while(rs.next())
            {
                prev_bal = Double.parseDouble(rs.getString("balance"));
            }
            
            
         new_bal = prev_bal + DEPOSIT_AMOUNT;
        
        
        
        
        String q = "update login set balance = '"+new_bal+"' where pin = '"+pin+"' and card_no = '"+card+"'";
        String q2 = "commit";        
    
        conn c2 = new conn();
        
        PreparedStatement ps = c2.c.prepareStatement(q);
        PreparedStatement ps1 = c2.c.prepareStatement(q2);
        
        
        ps.executeUpdate();
        ps1.executeUpdate();
        
        DEP_STATUS = "SUCCESS";
        transaction_log();
        
        int result = JOptionPane.showConfirmDialog(null, 
                         "Deposit Successfull.Do you want to continue ? ",null, JOptionPane.YES_NO_OPTION);
                if(result == JOptionPane.NO_OPTION) {
                                     System.exit(0);
                                    } 
                else
                {
                    setVisible(false);
                    new Transactions(card,pin).setVisible(true);
                }
        
         
                
                
        } catch (SQLException ex) {
            Logger.getLogger(Deposit.class.getName()).log(Level.SEVERE, null, ex);
            
            JOptionPane.showMessageDialog(null,
                    ex, "Error Message",
                    JOptionPane.ERROR_MESSAGE);
        }

        
        
        
    }
    
    public int CALCULATE()
    {
        int c2000,c500,c200,c100,c50,c20,c10;
        
        try
        {
            c2000 = Integer.parseInt(n2000.getText());
            c500  = Integer.parseInt(n500.getText());
            c200  = Integer.parseInt(n200.getText());
            c100  = Integer.parseInt(n100.getText());
            c50   = Integer.parseInt(n50.getText());
            c20   = Integer.parseInt(n20.getText());
            c10   = Integer.parseInt(n10.getText());
            
            if(c2000 < 0 || c500<0 || c200<0 || c100<0 || c50<0 || c20<0 || c10<0 || c2000>50 || c500>50
                    || c200>50 || c100>50 || c50>50 || c20>50 || c10>50)
            {
                return -1;
            }
            
            count.put(2000,c2000);
            count.put(500,c500);
            count.put(200,c200);
            count.put(100,c100);
            count.put(50,c50);
            count.put(20,c20);
            count.put(10,c10);
            
            
        }catch(Exception e)
        {
            
            return -1;
        }
        
        
        return 0;
    }
    
    
    private  void transaction_log()
    {
        if(DEP_STATUS.equals("SUCCESS")) {
        try{
        conn c2 = new conn();
        String action= "Deposit";
        String state = DEP_STATUS;
        String trans_note="";
        String q = "insert into transaction(card_no,pin,action,amount,balance,sucess,trans_note) values('"+card+"','"+pin+"','"+action+"','"+DEPOSIT_AMOUNT+"','"+new_bal+"','"+
                state+"','"+trans_note+"')";
        
        String q2 = "commit";
        
        PreparedStatement ps = c2.c.prepareStatement(q);
        PreparedStatement ps1 = c2.c.prepareStatement(q2);
        
        ps.executeUpdate();
        ps1.executeUpdate();
        }catch(SQLException se)
        {
            JOptionPane.showMessageDialog(null,
                    se, "Error Message",
                    JOptionPane.ERROR_MESSAGE);
        }
        
        
    }
    }
    
    
}
