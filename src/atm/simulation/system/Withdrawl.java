package atm.simulation.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Withdrawl extends JFrame implements ActionListener {

    private String card, pin;
    private JButton confirm, prev_menu, cancel_trans;
    private JLabel msg, msg2;
    private JTextField amt;
    private int WITH_AMOUNT;
    double new_bal;
    private String WITH_STATUS="FAIL";

    public Withdrawl(String card, String pin) {

        setTitle("Withdraw");
        setLayout(null);

        this.card = card;
        this.pin = pin;

        msg = new JLabel("Withdrawl From Savings Account");
        msg.setBounds(400, 50, 700, 35);
        msg.setFont(new Font("Raleway", Font.BOLD, 26));
        add(msg);

        msg2 = new JLabel("Enter the amount to be withdrawn");
        msg2.setBounds(200, 150, 750, 35);
        msg2.setFont(new Font("Raleway", Font.BOLD, 24));
        add(msg2);

        amt = new JTextField();
        amt.setBounds(700, 150, 100, 35);
        amt.setFont(new Font("Raleway", Font.BOLD, 24));
        add(amt);

        JLabel label = new JLabel("Please enter the amount in multiple of 10");
        label.setBounds(300, 250, 800, 30);
        label.setFont(new Font("Raleway", Font.BOLD, 22));
        add(label);

        confirm = new JButton("Confirm Withdraw");
        confirm.setBounds(220, 360, 220, 32);
        confirm.setFont(new Font("Raleway", Font.BOLD, 22));
        add(confirm);
        confirm.setForeground(Color.BLACK);
        confirm.addActionListener(this);

        prev_menu = new JButton("Previous Menu");
        prev_menu.setBounds(490, 360, 220, 32);
        prev_menu.setFont(new Font("Raleway", Font.BOLD, 22));
        add(prev_menu);
        prev_menu.setForeground(Color.BLACK);
        prev_menu.addActionListener(this);

        cancel_trans = new JButton("Cancel Transcation");
        cancel_trans.setBounds(355, 410, 250, 32);
        cancel_trans.setFont(new Font("Raleway", Font.BOLD, 22));
        add(cancel_trans);
        cancel_trans.setForeground(Color.BLACK);
        cancel_trans.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);
        setSize(1600, 1080);
        setLocation(0, 0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == cancel_trans) {
            int result = JOptionPane.showConfirmDialog(null,
                    "Are you sure you wish to exit?", null, JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        } else if (e.getSource() == prev_menu) {
            setVisible(false);
            new Transactions(card, pin).setVisible(true);
        } else if (e.getSource() == confirm) {
            try {
                WITH_AMOUNT = Integer.parseInt(amt.getText());

                if (WITH_AMOUNT % 10 == 0) {
                    startWithD();

                } else {
                    JOptionPane.showMessageDialog(null,
                            "Error: Please a valid Amount", "Error Message",
                            JOptionPane.ERROR_MESSAGE);
                }

            } catch (Exception se) {
                JOptionPane.showMessageDialog(null,
                        "Error: Please a valid Amount", "Error Message",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    public void startWithD() {

        double prev_bal = 0;
        try {
            conn c1 = new conn();

            ResultSet rs = c1.s.executeQuery("select balance from login where pin = '" + pin + "' and card_no = '" + card + "'");

            while (rs.next()) {
                prev_bal = Double.parseDouble(rs.getString("balance"));
            }

            if (prev_bal < WITH_AMOUNT) {
                JOptionPane.showMessageDialog(null,
                        "Insuficient Fund", "Error Message",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                confirmWithD(prev_bal, WITH_AMOUNT);

            }

        } catch (Exception ee) {

        }
    }

    public void confirmWithD(double prev_bal, double amt) {

        try {

            conn c = new conn();
            new_bal = prev_bal - amt;
            String q = "update login set balance = '" + new_bal + "' where pin = '" + pin + "' and card_no = '" + card + "'";
            String q2 = "commit";

            PreparedStatement ps = c.c.prepareStatement(q);
            PreparedStatement ps1 = c.c.prepareStatement(q2);

            ps.executeUpdate();
            ps1.executeUpdate();
            
            
            WITH_STATUS = "SUCCESS";
            transaction_log();

            int result = JOptionPane.showConfirmDialog(null,
                    "Cash Withdrawl Successfull.Do you want to continue ? ", null, JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.NO_OPTION) {
                System.exit(0);
            } else {
                setVisible(false);
                new Transactions(card, pin).setVisible(true);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Withdrawl.class.getName()).log(Level.SEVERE, null, ex);

            JOptionPane.showMessageDialog(null,
                    ex, "Error Message",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    private void transaction_log() {
        
        if(WITH_STATUS.equals("SUCCESS")) {
        
        try {
            conn c2 = new conn();
            String action = "Withdrawl";
            
            String trans_note = "";
            String q = "insert into transaction(card_no,pin,action,amount,balance,sucess,trans_note) values('" + card + "','" + pin + "','" + action + "','" + WITH_AMOUNT + "','" + new_bal + "','"
                    + WITH_STATUS + "','" + trans_note + "')";

            String q2 = "commit";

            PreparedStatement ps = c2.c.prepareStatement(q);
            PreparedStatement ps1 = c2.c.prepareStatement(q2);

            ps.executeUpdate();
            ps1.executeUpdate();
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null,
                    se, "Error Message",
                    JOptionPane.ERROR_MESSAGE);
        }

    }
    }

    
}
