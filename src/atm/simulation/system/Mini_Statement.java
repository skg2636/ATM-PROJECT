
package atm.simulation.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class Mini_Statement extends JFrame implements ActionListener {
    
    private String card,pin;
    JLabel title,name,mob,email,acc_no,adhaar,pan;
    JButton cancel_trans,prev_menu;
    JTable table;
    DefaultTableModel model;
    DefaultTableCellRenderer render;
   JScrollPane scroll;
  
    

    public Mini_Statement(String card, String pin) {
        this.card = card;
        this.pin = pin;
        
        setTitle("Mini Statement");
        setLayout(null);
        
        setLabel(title,500,30,700,35,"Mini Statement",28);
        
        
        
 
        
         
        scroll = new JScrollPane();
        table = new JTable();
        scroll.setViewportView(table);
        model = (DefaultTableModel) table.getModel();
        model.addColumn("Sl no.");
        model.addColumn("Transcation");
        model.addColumn("Amount");
        model.addColumn("Balance");
        model.addColumn("Transcation Time");
        
        
        
        try
        {
            conn mini = new conn();
            String q = "select * from transaction where card_no= '"+card+"' and pin = '"+pin+"'";
            ResultSet statement ;
            int c=0;
            statement = mini.s.executeQuery(q);
             
            while(statement.next())
            {
                
                Timestamp ts = statement.getTimestamp(8);
                Date date = new Date(ts.getTime());
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("DD/mm/yyyy' 'HH:mm:ss");

                
                model.addRow(new Object[0]);
                model.setValueAt(c+1,c,0);
                model.setValueAt(statement.getString(3), c, 1);
                model.setValueAt(statement.getString(4),c,2);
                model.setValueAt(statement.getString(5),c,3);
                model.setValueAt(simpleDateFormat.format(date),c,4);
                c++;
            }
            
        }catch(SQLException se)
        {
            JOptionPane.showMessageDialog(null,
                    se, "Error Message",
                    JOptionPane.ERROR_MESSAGE);
        }

        
        table.getColumnModel().getColumn(0).setPreferredWidth(5);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setPreferredWidth(150);
        render = new DefaultTableCellRenderer();
        render.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(render);
        scroll.setBounds(200,250,800,250);
        add(scroll);
        
        
        prev_menu = new JButton("Previous Menu");
        prev_menu.setBounds(250,550,300,32);
        prev_menu.setFont(new Font("Raleway",Font.BOLD,22));
        add(prev_menu);
        prev_menu.setForeground(Color.BLACK);
        prev_menu.addActionListener(this);
        
        
        cancel_trans = new JButton("Cancel Transcation");
        cancel_trans.setBounds(600,550,300,32);
        cancel_trans.setFont(new Font("Raleway",Font.BOLD,22));
        add(cancel_trans);
        cancel_trans.setForeground(Color.BLACK);
        cancel_trans.addActionListener(this);
        
        
        
        String fmno = getForm_No(card,pin);
        setCustName(fmno);
        setCustAadharPan(fmno);
        setLabel(acc_no,250,120,800,32,"Card No:    "+card,22);
        setCustEmailDOB(fmno);
        
        

        
        
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
           new Transactions(card,pin).setVisible(true);
        } 
            

    }
    
    
     public void setLabel(JLabel l,int x,int y,int z, int w,String str,int fs  )
    {
        
        l = new JLabel(str);
        l.setBounds(x,y,z,w);
        l.setFont(new Font("Raleway",Font.BOLD,fs));
        add(l);
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

    private void setCustName(String fmno) {

        try {
            conn c1 = new conn();
            String q1 = "select name from signup where formno = '"+fmno+"' ";
            
            ResultSet rs ;
            
            rs = c1.s.executeQuery(q1);
            
            while(rs.next())
            {
                        setLabel(name,250,80,800,32,"Name:      "+rs.getString("name"),22);

            }
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, ex);
            
        }
        


    }

    private void setCustAadharPan(String fmno) {
        
        
         try {
            conn c1 = new conn();
            String q1 = "select * from signup2 where formno = '"+fmno+"'";
            
            ResultSet rs ;
            
            rs = c1.s.executeQuery(q1);
            
            while(rs.next())
            {
               setLabel(pan,250,200,400,32,"PAN:    "+rs.getString(7),22);
               setLabel(adhaar,700,200,800,32,"Aadhar:  "+rs.getString(8),22);

            }
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    private void setCustEmailDOB(String fmno) {

            
        try {
            conn c1 = new conn();
            String q1 = "select email,dob from signup where formno = '"+fmno+"'";
            
            ResultSet rs ;
            
            rs = c1.s.executeQuery(q1);
            
            while(rs.next())
            {
              
                setLabel(mob,250,160,400,32,"DOB:   "+rs.getString("dob"),22);
                setLabel(email,700,160,800,32,"Email:   "+rs.getString("email"),22);

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            
        }
        


    }
    
}
