
package atm.simulation.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class PIN_Change extends JFrame implements ActionListener {
    
    
    private String cardno,pin;
    JLabel title,old_pin,new_pin,new_pin_ver,msg,msg2;
    JButton submit,prev_menu,cancel_trans;
    JPasswordField old,new1,new2;
    
    public PIN_Change(String cardno, String pin) {
  
        
        this.cardno = cardno;
        this.pin = pin;
        
        
        setTitle("PIN Change");
        setLayout(null);
        
        
        title = new JLabel("PIN Change");
        title.setBounds(570,50,700,35);
        title.setFont(new Font("Raleway",Font.BOLD,26));
        add(title);
        
        
        setLabel(old_pin,400,150,150,32,"Old Pin:",22);
        setLabel(new_pin,400,220,150,32,"New Pin:",22);
        setLabel(new_pin_ver,400,290,250,32,"Re-enter new pin:",22);
        
        
        old = new JPasswordField();
        old.setBounds(670, 150,120, 32);
        old.setFont(new Font("Raleway",Font.BOLD,22));
        add(old);
        
        
        new1 = new JPasswordField();
        new1.setBounds(670, 220,120, 32);
        new1.setFont(new Font("Raleway",Font.BOLD,22));
        add(new1);
        
        new2 = new JPasswordField();
        new2.setBounds(670, 290,120, 32);
        new2.setFont(new Font("Raleway",Font.BOLD,22));
        add(new2);
        
        
        setLabel(msg2,400,350,400,28,"PIN Should be of 4-digits containing only [0-9]",18);
        
        
        submit = new JButton("Submit");
        submit.setBounds(400,400,500,32);
        submit.setFont(new Font("Raleway",Font.BOLD,22));
        add(submit);
        submit.setForeground(Color.BLACK);
        submit.addActionListener(this);
  
        prev_menu = new JButton("Previous Menu");
        prev_menu.setBounds(400,450,500,32);
        prev_menu.setFont(new Font("Raleway",Font.BOLD,22));
        add(prev_menu);
        prev_menu.setForeground(Color.BLACK);
        prev_menu.addActionListener(this);
 
        cancel_trans = new JButton("Cancel Transcation");
        cancel_trans.setBounds(400,500,500,35);
        cancel_trans.setFont(new Font("Raleway",Font.BOLD,22));
        add(cancel_trans);
        cancel_trans.setForeground(Color.BLACK);
        cancel_trans.addActionListener(this);
        
        
        
        setLabel(msg,330,590,1000,30,"Note: Please don't share your PIN with anyone. Also keep updating your"
                + " PIN regularly.",16);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(1600,1080);
        setLocation(0, 0);
        setVisible(true);
    }
    

    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==cancel_trans)
        {
             int result = JOptionPane.showConfirmDialog(null, 
                         "Are you sure you wish to exit?",null, JOptionPane.YES_NO_OPTION);
                if(result == JOptionPane.YES_OPTION) {
                                     System.exit(0);
                                    } 
        } else if (e.getSource() == prev_menu)
        {
           setVisible(false);
           new Transactions(cardno,pin).setVisible(true);
        } else if(e.getSource() == submit)
        {
            String oldP,newP,newP2;
            
            oldP = old.getText();
            newP = new1.getText();
            newP2 = new2.getText();
            
            if(oldP.equals(pin))
            {

                if(newP.equals(newP2) )
                {
                    
                    if(isPINValid(newP))
                    {
                        
                        changePIN(newP);
                        
                        
                    }else
                    {
                        JOptionPane.showMessageDialog(null,
                    "Error! Inavalid PIN");
                    }
                    
                }else
                {
                    JOptionPane.showMessageDialog(null,
                    "Error! New PIN doesn't matches");
                }
                
            }else
            {
                JOptionPane.showMessageDialog(null,
                    "Please enter the correct PIN");
            }
            
            
            
        }
    }
    
    
    
    public void setLabel(JLabel l,int x,int y,int z, int w,String str,int fs  )
    {
        
        l = new JLabel(str);
        l.setBounds(x,y,z,w);
        l.setFont(new Font("Raleway",Font.BOLD,fs));
        add(l);
    }
    
    
    
     private  boolean isPINValid(String PIN)
    {
 
        String regex = "[0-9]{4}";
        Pattern p = Pattern.compile(regex);
        if (PIN == null )
        {
            return false;
        }
 
        
        Matcher m = p.matcher(PIN);
 
        
        return m.matches();
    }

    private void changePIN(String newP) {
        
        
        conn c1 = new conn();
        
        String q = "update login set pin = '"+newP+"' where card_no = '"+cardno+"' and pin = '"+pin+"'";
        String q2 = "commit";
        
        try
        {
            PreparedStatement ps = c1.c.prepareStatement(q);
            PreparedStatement ps2 = c1.c.prepareStatement(q2);
            
            ps.executeUpdate();
            ps2.executeUpdate();
            
             JOptionPane.showMessageDialog(null,
                    "PIN Changed Successfully!");
            
        }catch(SQLException e1)
        {
             JOptionPane.showMessageDialog(null,
                    e1);
        }
        
        
    }
    
}
