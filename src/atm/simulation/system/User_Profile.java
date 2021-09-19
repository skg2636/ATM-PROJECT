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


public class User_Profile extends JFrame implements ActionListener {
    private String cardno,pin;
    
    JLabel title,name,fname,dob,gender,email,marital,address,city,pincode,state;
    JButton cancel_trans,prev_menu;

    public User_Profile(String cardno, String pin) {
        this.cardno = cardno;
        this.pin = pin;
        
        
        setTitle("Withdraw");
        setLayout(null);   
        
        

        
        prev_menu = new JButton("Previous Menu");
        prev_menu.setBounds(200,450,500,32);
        prev_menu.setFont(new Font("Raleway",Font.BOLD,22));
        add(prev_menu);
        prev_menu.setForeground(Color.BLACK);
        prev_menu.addActionListener(this);
        
        
        cancel_trans = new JButton("Cancel Transcation");
        cancel_trans.setBounds(200,500,500,35);
        cancel_trans.setFont(new Font("Raleway",Font.BOLD,22));
        add(cancel_trans);
        cancel_trans.setForeground(Color.BLACK);
        cancel_trans.addActionListener(this);
        
        
        String formno = getForm_No(cardno,pin);
        conn c1 = new conn();
        String q1 = "select * from signup where formno = '"+formno+"' ";

        ResultSet rs ;
        
        try
        {
            rs = c1.s.executeQuery(q1);
            
            while(rs.next())
            {
                
                
                
        setLabel(title,400,50,700,35,"User Profile",28);
        setLabel(name,200,100,500,35,   "Name:            "+rs.getString(2),24);
        setLabel(fname,200,140,500,35,  "Father Name:     "+rs.getString(3),24);
        setLabel(dob,200,180,300,35,    "Date of Birth:   "+rs.getString(4),24);
        setLabel(gender,500,180,300,35, "Gender:          "+rs.getString(5),24);
        setLabel(marital,200,220,300,35,"Marital Status:  "+rs.getString(7),24);
        setLabel(email,200,260,500,35,  "Email ID:        "+rs.getString(6),24);
        setLabel(address,200,300,500,35,"Adress:          "+rs.getString(8),24);
        setLabel(city,200,340,300,35,   "City:            "+rs.getString(9),24);
        setLabel(pincode,500,340,300,35,"PIN Code:        "+rs.getString(10),24);
        setLabel(state,200,380,500,35,  "State:           "+rs.getString(11),24);
                
              

               
            }
            
            
        }catch(SQLException e)
        {
            
        }
        
        
        
        getContentPane().setBackground(Color.WHITE);
        setSize(1600,1080);
        setLocation(0, 0);
        setVisible(true);
        
        
        
        
    }
    
    
    public void setLabel(JLabel l,int x,int y,int z, int w,String str,int fs  )
    {
        
        l = new JLabel(str);
        l.setBounds(x,y,z,w);
        l.setFont(new Font("Raleway",Font.BOLD,fs));
        add(l);
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
        } 
    }
    
    
   
    private String getForm_No(String cardno, String pin) {

        conn c1 = new conn();
        String fmno="";
        String q1 = "select * from login where card_no = '"+cardno+"' and pin = '"+pin+"'  ";
        ResultSet rs;
        try
        {
            rs = c1.s.executeQuery(q1);
            
            while(rs.next())
            {
                fmno = rs.getString(1);
            }
            
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        

        return fmno;
    }

    
}
