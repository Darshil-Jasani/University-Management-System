package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class StudentAttendance extends JFrame implements ActionListener {

    Choice crollno, ctime;
    JDateChooser dcdate;
    JButton submit, cancel;
    
    StudentAttendance() {
        
        setSize(500, 550);
        setLocation(450, 100);
        setLayout(null);
        
        getContentPane().setBackground(new Color(210,232,252));
        
        JLabel heading = new JLabel("Student Attendance");
        heading.setBounds(100, 30, 300, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 26));
        add(heading);
        
        JLabel lblrollno = new JLabel("Search by Roll Number");
        lblrollno.setBounds(60, 100, 200, 20);
        lblrollno.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblrollno);
        
        crollno = new Choice();
        crollno.setBounds(60, 130, 200, 20);
        add(crollno);
        crollno.add("Select Roll No");
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while(rs.next()) {
                crollno.add(rs.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(60, 180, 200, 20);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lbldate);
        
        dcdate = new JDateChooser();
        dcdate.setBounds(60, 210, 200, 25);
        add(dcdate);
        
        JLabel lbltime = new JLabel("Attendance");
        lbltime.setBounds(60, 260, 200, 20);
        lbltime.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lbltime);
        
        ctime = new Choice();
        ctime.setBounds(60, 290, 200, 20);
        ctime.add("Select Attendance");
        ctime.add("Present");
        ctime.add("Absent");
        add(ctime);
        
        submit = new JButton("Submit");
        submit.setBounds(60, 350, 100, 25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(200, 350, 100, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            
        if (crollno.getSelectedItem().equals("Select Roll No")) {
            JOptionPane.showMessageDialog(null, "Please select roll no");
            return;
        }
        String date = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
        if (date.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please select Date");
            return;
        }
        if (ctime.getSelectedItem().equals("Select Attendance")) {
            JOptionPane.showMessageDialog(null, "Please select attendance");
            return;
        }    
            
            String rollno = crollno.getSelectedItem();
            String attendance = ctime.getSelectedItem();
            
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(
                    "select * from studentattendance where rollno='"+rollno+"' and date='"+date+"'");

                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Attendance already marked for this date");
                    return;
                }

                String query = "insert into studentattendance values('"+rollno+"', '"+date+"', '"+attendance+"')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Attendance Marked Successfully");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new StudentAttendance();
    }
}
