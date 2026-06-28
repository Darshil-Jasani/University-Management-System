package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{

    JButton login, cancel;
    JTextField tfusername, tfpassword;
    
    Login () {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 20, 100, 20);
        add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(150, 20, 150, 20);
        add(tfusername);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 70, 100, 20);
        add(lblpassword);
        
        tfpassword = new JPasswordField();
        tfpassword.setBounds(150, 70, 150, 20);
        add(tfpassword);
        
        login = new JButton("Login");
        login.setBounds(40, 140, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        login.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(login);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(180, 140, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/chp.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(325, 0, 250, 250);
        add(image);
        
        setSize(600, 300);
        setLocation(500, 250);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login){
            try {
                Conn c = new Conn();
            String username = tfusername.getText();
            String password = tfpassword.getText();
            
            if(username.trim().isEmpty()){
                JOptionPane.showMessageDialog(null,"Username cannot be empty");
                return;
            }
            if(password.trim().isEmpty()){
               JOptionPane.showMessageDialog(null,"Password cannot be empty");
               return;
            }
                String query = "select * from login where username = '"+username+"' and password = '"+password+"'";
                ResultSet resultSet = c.s.executeQuery(query);
                if (resultSet.next()){
                    new Project();
                    setVisible(false);
                }else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }

            }catch (Exception E){
                E.printStackTrace();
            }

        }else {
            System.exit(102);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
