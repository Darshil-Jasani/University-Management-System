package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class FeeDetails extends JFrame implements ActionListener {

    Choice crollno;
    JTable table;
    JButton search, print, delete, cancel;

    FeeDetails() {

        getContentPane().setBackground(new Color(210,232,252));
        setLayout(null);

        JLabel heading = new JLabel("Search by Roll Number");
        heading.setBounds(20, 20, 150, 20);
        add(heading);

        crollno = new Choice();
        crollno.setBounds(180, 20, 150, 20);
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

        table = new JTable();

        loadTable(); 

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 500);
        add(jsp);

        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);
        
        delete = new JButton("Delete");
        delete.setBounds(220, 70, 80, 20);
        delete.addActionListener(this);
        add(delete);

        cancel = new JButton("Cancel");
        cancel.setBounds(320, 70, 80, 20);
        cancel.addActionListener(this);
        add(cancel);

        setSize(900, 650);
        setLocation(300, 20);
        setVisible(true);
    }

    public void loadTable() {
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from feeform");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == search) {

            if (crollno.getSelectedItem().equals("Select Roll No")) {
                JOptionPane.showMessageDialog(null, "Please select roll no");
                return;
            }

            try {
                Conn c = new Conn();
                String query = "select * from feeform where rollno = '"
                        + crollno.getSelectedItem() + "'";
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        else if (ae.getSource() == print) {
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        else if (ae.getSource() == delete) {

            int row = table.getSelectedRow();

            if (row == -1) {
                JOptionPane.showMessageDialog(null, "Select a record first");
                return;
            }

            try {
                String rollno = table.getValueAt(row, 0).toString();

                Conn c = new Conn();
                String query = "delete from feeform where rollno = '" + rollno + "'";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Record Deleted");

                loadTable(); 

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new FeeDetails();
    }
}
