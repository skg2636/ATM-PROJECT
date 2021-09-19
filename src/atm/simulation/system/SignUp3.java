
package atm.simulation.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.*;
import javax.swing.JFrame;

public class SignUp3 extends JFrame implements ActionListener {
    
    
    JCheckBox cheque,mobile,atm_car,internet,email_alert,e_state,agree;
    JLabel f_no,acc_det,acc_type,card_no,card_number,pin,pin_,service_req;
    JRadioButton savings,current,fixed,reccuring;
    String form_no;
    JLabel card_msg;
    JButton submit,cancel;
            
            
    SignUp3(String form_no)
    {
        this.form_no=form_no;
        setTitle("NEW ACCOUNT APPLICATION FORM");
        setLayout(null);
        
        
        
        
        f_no = new JLabel();
        f_no.setFont(new Font("Raleway", Font.BOLD, 13));
        f_no.setBounds(820, 40, 100, 20);
        f_no.setText("Form no: "+form_no);
        add(f_no);
        
        acc_det= new JLabel("Page 2: Account Details");
        acc_det.setFont(new Font("Raleway", Font.BOLD, 22));
        acc_det.setBounds(280,40,400,40);
        add(acc_det);
        
        acc_type= new JLabel("Account Type:");
        acc_type.setFont(new Font("Raleway", Font.BOLD, 18));
        acc_type.setBounds(100,120,200,30);
        add(acc_type);
        
        
        savings = new JRadioButton("Savings Account");
        savings.setFont(new Font("Raleway",Font.BOLD,16));
        savings.setBackground(Color.WHITE);
        savings.setBounds(130,150,200,30);
        add(savings);
        
        fixed = new JRadioButton("Fixed Account");
        fixed.setFont(new Font("Raleway",Font.BOLD,16));
        fixed.setBackground(Color.WHITE);
        fixed.setBounds(380,150,200,30);
        add(fixed);
        
        current = new JRadioButton("Current Account");
        current.setFont(new Font("Raleway",Font.BOLD,16));
        current.setBackground(Color.WHITE);
        current.setBounds(130,180,200,30);
        add(current);
        
        reccuring = new JRadioButton("Recurring Account");
        reccuring.setFont(new Font("Raleway",Font.BOLD,16));
        reccuring.setBackground(Color.WHITE);
        reccuring.setBounds(380,180,200,30);
        add(reccuring);
        
        
        ButtonGroup acctype = new ButtonGroup();
        acctype.add(savings);
        acctype.add(current);
        acctype.add(reccuring);
        acctype.add(fixed);
        
        card_no = new JLabel("Card Number: ");
        card_no.setFont(new Font("Raleway",Font.BOLD,18));
        card_no.setBounds(100,230,200,30);
        add(card_no);
        
        card_number = new JLabel("XXXX-XXXX-XXXX-XXXX");
        card_number.setFont(new Font("Raleway",Font.BOLD,18));
        card_number.setBounds(300,230,250,30);
        add(card_number);
        
        card_msg = new JLabel("Your 16-Digit Card Number");
        card_msg.setFont(new Font("Raleway",Font.PLAIN,12));
        card_msg.setBounds(100,260,250,30);
        add(card_msg);
        
        JLabel card_msg_1 = new JLabel("It would appear on ATM card/cheque and Statement");
        card_msg_1.setFont(new Font("Raleway",Font.PLAIN,12));
        card_msg_1.setBounds(300,260,500,30);
        add(card_msg_1);
        
        pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,18));
        pin.setBounds(100,300,100,30);
        add(pin);
        
        pin_ = new JLabel("XXXX");
        pin_.setFont(new Font("Raleway",Font.BOLD,18));
        pin_.setBounds(300,300,100,30);
        add(pin_);
        
        JLabel pin_msg= new JLabel("[4-digit Password]");
        pin_msg.setFont(new Font("Raleway",Font.BOLD,12));
        pin_msg.setBounds(100,330,200,30);
        add(pin_msg);
        
        service_req= new JLabel("Service Required:");
        service_req.setFont(new Font("Raleway",Font.BOLD,18));
        service_req.setBounds(100,380,200,30);
        add(service_req);
        
        cheque = new JCheckBox("Cheque Book");
        cheque.setFont(new Font("Raleway",Font.BOLD,16));
        cheque.setBounds(130,420,200,30);
        add(cheque);
        
        mobile = new JCheckBox("Mobile Banking");
        mobile.setFont(new Font("Raleway",Font.BOLD,16));
        mobile.setBounds(430,420,200,30);
        add(mobile);

        atm_car = new JCheckBox("ATM Card");
        atm_car.setFont(new Font("Raleway",Font.BOLD,16));
        atm_car.setBounds(130,460,200,30);
        add(atm_car);
        
        internet = new JCheckBox("Internet Banking");
        internet.setFont(new Font("Raleway",Font.BOLD,16));
        internet.setBounds(430,460,200,30);
        add(internet);
        
        email_alert = new JCheckBox("Email Alert");
        email_alert.setFont(new Font("Raleway",Font.BOLD,16));
        email_alert.setBounds(130,500,200,30);
        add(email_alert);
        
        e_state = new JCheckBox("E-Statement");
        e_state.setFont(new Font("Raleway",Font.BOLD,16));
        e_state.setBounds(430,500,200,30);
        add(e_state);

        agree= new JCheckBox("I hereby declares that the above entered details correct to th best of my knowledge.",true);
        agree.setFont(new Font("Raleway",Font.BOLD,16));
        agree.setBounds(150,550,700,30);
        add(agree);
        
        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(370, 600, 100, 30);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(500, 600, 100, 30);
        add(cancel);
        
        
        submit.addActionListener(this);
        cancel.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(1600, 1080);
        setLocation(0, 0);
        setVisible(true);
        
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        String atype="";
        if(savings.isSelected())
        {
            atype="Savings";
        }else if (current.isSelected())
        {
            atype="Current";
        }else if (reccuring.isSelected())
        {
            atype="Recurring";
        }else if(fixed.isSelected())
        {
            atype="Fixed";
        }
        
        Random ran = new Random();
        
        long first7 = (ran.nextLong() % 90000000L) + 5040270900000000L;
        String cardno = "" + Math.abs(first7);
        
        long first3= (ran.nextLong() % 9000L) +5000L;
        String pin = "" + Math.abs(first3);
        
        
        String fc_chq="No";
        String fc_mob="No";
        String fc_card="No";
        String fc_internet="No";
        String fc_em_alert="No";
        String fc_statement="No";
        
        
        if(cheque.isSelected())
        {
            fc_chq="Yes";
        }
        if(mobile.isSelected())
        {
            fc_mob="Yes";
        }
        if(atm_car.isSelected())
        {
            fc_card="Yes";
        }
        if(internet.isSelected())
        {
            fc_internet="Yes";
        }
        if(email_alert.isSelected())
        {
            fc_em_alert="Yes";
        }
        if(e_state.isSelected())
        {
            fc_statement="Yes";
        }
        
        
        try
        {
            if(e.getSource()==submit)
            {
                if(!"".equals(atype))
                {
                    conn c3 = new conn();
                    
                    String q1 = "insert into signup3 values('"+form_no+"','"+atype+"','"+cardno+"','"+pin+"','"+fc_chq+"','"+fc_mob+"','"+fc_card+"','"+fc_internet+"','"+fc_em_alert+"','"+fc_statement+"')";                                            
                    String q2 = "insert into login(formno,card_no,pin) values('"+form_no+"','"+cardno+"','"+pin+"')";
                    
                    c3.s.executeUpdate(q1);
                    c3.s.executeUpdate(q2);
                    
                    
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardno + "\n Pin:"+ pin+"\n Please don't share this with anyone");
                    new Login().setVisible(true);
                    
                    
                }else
                {
                    JOptionPane.showMessageDialog(null, "Please Select the account type");
                }
            }else if(e.getSource()==cancel)
            {
                System.exit(0);
            }
        }catch(HeadlessException | SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    
    
}
