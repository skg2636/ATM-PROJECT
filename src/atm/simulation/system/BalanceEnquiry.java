
package atm.simulation.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class BalanceEnquiry extends JFrame implements ActionListener{
    
    private String card_no,pin;
    JLabel msg,balance;
    JButton exit_btn,prev_menu;

    public BalanceEnquiry(String card_no, String pin) {
        this.card_no = card_no;
        this.pin = pin;
        
        setTitle("Balance Enquiry");
        setLayout(null);
        
        msg = new JLabel("Balance Enquiry for Card no\n "+card_no);
        msg.setBounds(400,100,700,55);
        msg.setFont(new Font("Raleway",Font.BOLD,26));
        add(msg);
        
        String bal="1231" ;
        
        conn c1 = new conn();
        
        try {
        ResultSet rs = c1.s.executeQuery("select * from login where pin = '"+pin+"' and card_no = '"+card_no+"'");
        
        while(rs.next())
        {
            bal =String.format("%.2f", rs.getDouble(4));
            
        }
                
        }catch(SQLException e)
        {
              JOptionPane.showMessageDialog(null, e);
        }
        
        balance = new JLabel("Your Saving Account Balance is Rs. "+bal+" /-");
        balance.setBounds(400,200,700,45);
        balance.setFont(new Font("Raleway",Font.BOLD,24));
        add(balance);
        
        
        exit_btn = new JButton("Cancel Transcation");
        exit_btn.setBounds(500,400,300,30);
        exit_btn.setFont(new Font("Raleway",Font.BOLD,21));
        add(exit_btn);
        exit_btn.addActionListener(this);
        
        
        prev_menu = new JButton("Back to previous menu");
        prev_menu.setBounds(490,350,320,30);
        prev_menu.setFont(new Font("Raleway",Font.BOLD,21));
        add(prev_menu);
        prev_menu.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(1600,1080);
        setLocation(0, 0);
        setVisible(true);
        
    }
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==exit_btn)
        {
            int result = JOptionPane.showConfirmDialog(null, 
                         "Are you sure you wish to exit?",null, JOptionPane.YES_NO_OPTION);
                if(result == JOptionPane.YES_OPTION) {
                                     System.exit(0);
                                    } 
            
        }else if (e.getSource() == prev_menu)
        {
            setVisible(false);
            new Transactions(card_no,pin).setVisible(true);
        }
    }
    
    
    
    
}
