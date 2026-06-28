package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class StudentFeeForm extends JFrame implements ActionListener {

    Choice crollno;
    JComboBox cbcourse, cbbranch, cbsemester;
    JLabel labeltotal;
    JTextField tfpaid, tfdue;
    JButton update, pay, back;
    
    StudentFeeForm() {
        setSize(900, 600);
        setLocation(300, 100);
        setLayout(null);
        
        getContentPane().setBackground(new Color(210,252,251));
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fee.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 100, 300, 300);
        add(image);

        JLabel lblrollnumber = new JLabel("Select Roll No");
        lblrollnumber.setBounds(40, 60, 150, 20);
        lblrollnumber.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblrollnumber);

        crollno = new Choice();
        crollno.setBounds(200, 60, 150, 20);
        add(crollno);
        crollno.add("Select Roll Number");
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while(rs.next()) {
                crollno.add(rs.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(40, 100, 150, 20);
        lblname.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblname);
        
        JLabel labelname = new JLabel();
        labelname.setBounds(200, 100, 150, 20);
        labelname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelname);
        
        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(40, 140, 150, 20);
        lblfname.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblfname);
        
        JLabel labelfname = new JLabel();
        labelfname.setBounds(200, 140, 150, 20);
        labelfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelfname);
        
        try {
            Conn c = new Conn();
            String query = "select * from student where rollno='"+crollno.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        crollno.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from student where rollno='"+crollno.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()) {
                        labelname.setText(rs.getString("name"));
                        labelfname.setText(rs.getString("fname"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        JLabel lblcourse = new JLabel("Course");
        lblcourse.setBounds(40, 180, 150, 20);
        lblcourse.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblcourse);
        
        String course[] = {"Select Course", "BTech", "BBA", "BCA", "Bsc", "Msc", "MBA", "MCA", "MCom", "MA", "BA"};
        cbcourse = new JComboBox(course);
        cbcourse.setBounds(200, 180, 150, 20);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);
        
        JLabel lblbranch = new JLabel("Branch");
        lblbranch.setBounds(40, 220, 150, 20);
        lblbranch.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblbranch);
        
        String branch[] = {"Select Branch", "Computer Science", "Electronics", "Mechanical", "Civil", "IT"};
        cbbranch = new JComboBox(branch);
        cbbranch.setBounds(200, 220, 150, 20);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch);
        
        JLabel lblsemester = new JLabel("Semester");
        lblsemester.setBounds(40, 260, 150, 20);
        lblsemester.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblsemester);
        
        String semester[] = {"Select Semester", "Semester1", "Semester2", "Semester3", "Semester4", "Semester5", "Semester6", "Semester7", "Semester8" };
        cbsemester = new JComboBox(semester);
        cbsemester.setBounds(200, 260, 150, 20);
        cbsemester.setBackground(Color.WHITE);
        add(cbsemester);
        
        JLabel lbltotal = new JLabel("Total Payable");
        lbltotal.setBounds(40, 300, 150, 20);
        lbltotal.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lbltotal);
        
        labeltotal = new JLabel();
        labeltotal.setBounds(200, 300, 150, 20);
        labeltotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labeltotal);
        
        JLabel lblpaid = new JLabel("Paid Amount");
        lblpaid.setBounds(40, 340, 150, 20);
        lblpaid.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblpaid);

        tfpaid = new JTextField();
        tfpaid.setBounds(200, 340, 150, 20);
        add(tfpaid);

        JLabel lbldue = new JLabel("Due Amount");
        lbldue.setBounds(40, 380, 150, 20);
        lbldue.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lbldue);

        tfdue = new JTextField();
        tfdue.setBounds(200, 380, 150, 20);
        tfdue.setEditable(false);
        add(tfdue);
        
        update = new JButton("Update");
        update.setBounds(50, 470, 120, 30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        update.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(update);
        
        pay = new JButton("Pay Fee");
        pay.setBounds(200, 470, 120, 30);
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.WHITE);
        pay.addActionListener(this);
        pay.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(pay);
        
        back = new JButton("Back");
        back.setBounds(350, 470, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(back);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == update) {
            
        if (crollno.getSelectedItem().equals("Select Roll Number")) {
           JOptionPane.showMessageDialog(null, "Please select a roll number");
           return;
        }
        
        if (cbcourse.getSelectedItem().equals("Select Course")) {
           JOptionPane.showMessageDialog(null, "Please select a Course");
           return;
        }
        
         if (cbbranch.getSelectedItem().equals("Select Branch")) {
           JOptionPane.showMessageDialog(null, "Please select a Branch");
           return;
        }
         
        if (cbsemester.getSelectedItem().equals("Select Semester")) {
           JOptionPane.showMessageDialog(null, "Please select a Semester");
           return;
        }
            
            String course = (String) cbcourse.getSelectedItem();
            String semester = (String) cbsemester.getSelectedItem();
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(
                        "select * from fee where course='" + cbcourse.getSelectedItem() + "'");

                if (rs.next()) {
                    labeltotal.setText(rs.getString((String) cbsemester.getSelectedItem()));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

         try {
             int total = Integer.parseInt(labeltotal.getText());
             int paid = Integer.parseInt(tfpaid.getText());

             if (paid > total) {
                 JOptionPane.showMessageDialog(null, 
                    "Paid amount cannot be greater than Total Fee");
                return;
            }

         int due = total - paid;
         tfdue.setText(String.valueOf(due));

        } catch (NumberFormatException e) {
                 JOptionPane.showMessageDialog(null, 
                            "Please enter valid numeric amount");
        }
        
        } else if (ae.getSource() == pay) {
            
        if (labeltotal.getText().equals("")) {
           JOptionPane.showMessageDialog(null, "Please click update first");
           return;
        }
            
            String rollno = crollno.getSelectedItem();
            String course = (String) cbcourse.getSelectedItem();
            String semester = (String) cbsemester.getSelectedItem();
            String branch = (String) cbbranch.getSelectedItem();
            String total = labeltotal.getText();
            String paid = tfpaid.getText();
            String due = tfdue.getText();
            
            try {
                Conn c = new Conn();
                
                String query = "insert into feeform values('"+rollno+"', '"+course+"', '"+branch+"', '"+semester+"', '"+total+"', '"+paid+"', '"+due+"')";
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Fee Marked Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new StudentFeeForm();
    }
}



