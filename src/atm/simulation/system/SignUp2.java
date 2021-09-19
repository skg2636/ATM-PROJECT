package atm.simulation.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SignUp2 extends JFrame implements ActionListener {

    JLabel form_no, add_det, rel, cat, income, edu, qual, occ, pan, aadhar, snr, ext;
    JButton next_btn;
    JRadioButton sc1, sc2, ex1, ex2;
    JTextField f_no, pan_no, aadhar_no;
    JComboBox relB, categoryB, IncomeB, OccupationB, eduB;

    String formno;

    SignUp2(String formno) {
        this.formno = formno;
        setTitle("NEW ACCOUNT APPLICATION FORM");

        setLayout(null);
        add_det = new JLabel("Page 2: Additional Details");
        add_det.setFont(new Font("Raleway", Font.BOLD, 22));
        add_det.setBounds(280, 30, 600, 40);
        add(add_det);

        rel = new JLabel("Religion:");
        rel.setFont(new Font("Raleway", Font.BOLD, 18));
        rel.setBounds(100, 120, 100, 30);
        add(rel);

        cat = new JLabel("Category:");
        cat.setFont(new Font("Raleway", Font.BOLD, 18));
        cat.setBounds(100, 170, 100, 30);
        add(cat);

        income = new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD, 18));
        income.setBounds(100, 220, 100, 30);
        add(income);

        edu = new JLabel("Educational");
        edu.setFont(new Font("Raleway", Font.BOLD, 18));
        edu.setBounds(100, 270, 150, 30);
        add(edu);

        qual = new JLabel("Qualification:");
        qual.setFont(new Font("Raleway", Font.BOLD, 18));
        qual.setBounds(100, 290, 150, 30);
        add(qual);

        occ = new JLabel("Occupation:");
        occ.setFont(new Font("Raleway", Font.BOLD, 18));
        occ.setBounds(100, 340, 150, 30);
        add(occ);

        pan = new JLabel("PAN:");
        pan.setFont(new Font("Raleway", Font.BOLD, 18));
        pan.setBounds(100, 390, 100, 30);
        add(pan);

        aadhar = new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 18));
        aadhar.setBounds(100, 440, 150, 30);
        add(aadhar);

        snr = new JLabel("Senior Citizen:");
        snr.setFont(new Font("Raleway", Font.BOLD, 18));
        snr.setBounds(100, 490, 140, 30);
        add(snr);

        ext = new JLabel("Existing Customer:");
        ext.setFont(new Font("Raleway", Font.BOLD, 18));
        ext.setBounds(100, 540, 200, 30);
        add(ext);

        form_no = new JLabel("Form No: ");
        form_no.setFont(new Font("Raleway", Font.BOLD, 13));
        form_no.setBounds(760, 40, 150, 20);
        add(form_no);

        next_btn = new JButton("Next");
        next_btn.setFont(new Font("Raleway", Font.BOLD, 14));
        next_btn.setBackground(Color.BLACK);
        next_btn.setForeground(Color.WHITE);
        next_btn.setBounds(770, 600, 100, 30);
        add(next_btn);

        String religion[] = {"Hindu", "Sikh", "Christian", "Budhism", "Janism", "Muslim", "Other"};
        relB = new JComboBox(religion);
        relB.setBackground(Color.WHITE);
        relB.setFont(new Font("Raleway", Font.BOLD, 14));
        relB.setBounds(500, 120, 150, 30);
        add(relB);

        String category[] = {"General", "OBC", "SC", "ST", "Other"};
        categoryB = new JComboBox(category);
        categoryB.setBackground(Color.WHITE);
        categoryB.setFont(new Font("Raleway", Font.BOLD, 14));
        categoryB.setBounds(500, 170, 150, 30);
        add(categoryB);

        String Income[] = {"<50,000", "<1,50,000", "<2,50,000", "<5,00,000", "Upto 10,00,000", "Above 10,00,000"};
        IncomeB = new JComboBox(Income);
        IncomeB.setBackground(Color.WHITE);
        IncomeB.setFont(new Font("Raleway", Font.BOLD, 14));
        IncomeB.setBounds(500, 220, 150, 30);
        add(IncomeB);

        String quali[] = {"Graduate", "Non-Graduate", "Post-Graduate", "Doctrate", "High School", "Other"};
        eduB = new JComboBox(quali);
        eduB.setBackground(Color.WHITE);
        eduB.setFont(new Font("Raleway", Font.BOLD, 14));
        eduB.setBounds(500, 290, 150, 30);
        add(eduB);

        String occ[] = {"Self-Employed", "Salaried", "Student", "Retired", "Other"};
        OccupationB = new JComboBox(occ);
        OccupationB.setBackground(Color.WHITE);
        OccupationB.setFont(new Font("Raleway", Font.BOLD, 14));
        OccupationB.setBounds(500, 340, 150, 30);
        add(OccupationB);

        f_no = new JTextField();
        f_no.setFont(new Font("Raleway", Font.BOLD, 13));
        f_no.setBounds(820, 40, 100, 20);
        f_no.setText(formno);
        add(f_no);

        pan_no = new JTextField();
        pan_no.setFont(new Font("Raleway", Font.BOLD, 13));
        pan_no.setBounds(500, 390, 200, 30);
        add(pan_no);

        aadhar_no = new JTextField();
        aadhar_no.setFont(new Font("Raleway", Font.BOLD, 13));
        aadhar_no.setBounds(500, 440, 200, 30);
        add(aadhar_no);

        sc1 = new JRadioButton("Yes");
        sc1.setFont(new Font("Raleway", Font.BOLD, 14));
        sc1.setBackground(Color.WHITE);
        sc1.setBounds(500, 490, 60, 30);
        add(sc1);

        sc2 = new JRadioButton("No");
        sc2.setFont(new Font("Raleway", Font.BOLD, 14));
        sc2.setBackground(Color.WHITE);
        sc2.setBounds(590, 490, 60, 30);
        add(sc2);
        
        ButtonGroup bt = new ButtonGroup();
        bt.add(sc1);
        bt.add(sc2);
        
        
        ex1 = new JRadioButton("Yes");
        ex1.setFont(new Font("Raleway", Font.BOLD, 14));
        ex1.setBackground(Color.WHITE);
        ex1.setBounds(500, 540, 60, 30);
        add(ex1);

        ex2 = new JRadioButton("No");
        ex2.setFont(new Font("Raleway", Font.BOLD, 14));
        ex2.setBackground(Color.WHITE);
        ex2.setBounds(590, 540, 60, 30);
        add(ex2);
        
        ButtonGroup bt2 = new ButtonGroup();
        bt2.add(sc1);
        bt2.add(sc2);
        
        next_btn.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(1600, 1080);
        setLocation(0, 0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String religion = (String) relB.getSelectedItem();
        String category = (String) categoryB.getSelectedItem();
        String occupation = (String) OccupationB.getSelectedItem();
        String education = (String) eduB.getSelectedItem();
        String inc = (String) IncomeB.getSelectedItem();
        
        
        String pan= pan_no.getText();
        String aad = aadhar_no.getText();
        
        String snrctz="";
        String extcust="";
        
        if(sc1.isSelected())
        {
            snrctz="Yes";
        }else if(sc2.isSelected())
        {
            snrctz="No";
        }
        
        
         if(ex1.isSelected())
        {
            extcust="Yes";
        }else if(ex2.isSelected())
        {
            extcust="No";
        }
         
        
        if(isValidPanCardNo(pan))
        {
            if(isValidAadharNo(aad))
            {
                if(!(snrctz.equals("") || extcust.equals("")))
                {
                    
                    
                    conn c2 = new conn();
                    String q2 = "insert into signup2 values('"+formno+"','"+religion+"','"+category+"','"+inc+"','"+education+"','"+occupation+"','"+pan+"','"+aad+"','"+snrctz+"','"+extcust+"')";
                    try {
                        c2.s.executeUpdate(q2);
                            new SignUp3(formno).setVisible(true);
                    } catch (SQLException ex) {
                        Logger.getLogger(SignUp2.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, ex+" error");
                    }
                    
                }else
                {
                 JOptionPane.showMessageDialog(null, "Please complete the form");
                  
                }
                
            }else
            {
                JOptionPane.showMessageDialog(null, "Please enter a valid Aadhar Number");
            }
        }else
        {
             JOptionPane.showMessageDialog(null, "Please enter a valid PAN");
        }
        
        
        
        
        
        
    }

    
    
    
    
     public  boolean isValidPanCardNo(String panCardNo)
    {
 
        String regex = "[A-Z]{5}[0-9]{4}[A-Z]{1}";
        Pattern p = Pattern.compile(regex);
        if (panCardNo == null)
        {
            return false;
        }
 
        
        Matcher m = p.matcher(panCardNo);
 
        
        return m.matches();
    }
     
     public boolean isValidAadharNo(String aadhaar)
     {
         String regex= "[0-9]{12}";
         Pattern p = Pattern.compile(regex);
         if(aadhar==null)
         {
             return false;
         }
         
         Matcher m = p.matcher(aadhaar);
         
         return m.matches();
     }

}
