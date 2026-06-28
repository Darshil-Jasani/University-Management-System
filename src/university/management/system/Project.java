package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener {

    Project() {
        setSize(1366, 768);
        setLocation(0, 0);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/giphy.gif"));
        Image i2 = i1.getImage().getScaledInstance(1366, 768, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setLayout(null);
        add(image);

        ImageIcon logoIcon = new ImageIcon(ClassLoader.getSystemResource("icons/chp.png"));
        Image logoImg = logoIcon.getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH);
        JLabel logo = new JLabel(new ImageIcon(logoImg));
        logo.setBounds(600, 40, 110, 110);
        image.add(logo);

        JLabel heading = new JLabel("GURUKUL UNIVERSITY");
        heading.setBounds(320, 150, 700, 60);
        heading.setFont(new Font("Serif", Font.BOLD, 42));
        heading.setForeground(Color.WHITE);
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        image.add(heading);

        JLabel tagline = new JLabel("Empowering Education • Inspiring Innovation • Building Futures");
        tagline.setBounds(320, 210, 700, 40);
        tagline.setFont(new Font("Serif", Font.PLAIN, 22));
        tagline.setForeground(Color.WHITE);
        tagline.setHorizontalAlignment(SwingConstants.CENTER);
        image.add(tagline);

        
        JMenuBar mb = new JMenuBar();
        
        JMenu newInformation = new JMenu("New Information");
        newInformation.setForeground(Color.BLUE);
        mb.add(newInformation);
        
        JMenuItem facultyInfo = new JMenuItem("New Faculty Information");
        facultyInfo.setBackground(Color.WHITE);
        facultyInfo.addActionListener(this);
        newInformation.add(facultyInfo);
        
        JMenuItem studentInfo = new JMenuItem("New Student Information");
        studentInfo.setBackground(Color.WHITE);
        studentInfo.addActionListener(this);
        newInformation.add(studentInfo);
        
        JMenu details = new JMenu("View Details");
        details.setForeground(Color.RED);
        mb.add(details);
        
        JMenuItem facultydetails = new JMenuItem("View Faculty Details");
        facultydetails.setBackground(Color.WHITE);
        facultydetails.addActionListener(this);
        details.add(facultydetails);
        
        JMenuItem studentdetails = new JMenuItem("View Student Details");
        studentdetails.setBackground(Color.WHITE);
        studentdetails.addActionListener(this);
        details.add(studentdetails);
        
        JMenu attendance = new JMenu("Attendance");
        attendance.setForeground(Color.BLUE);
        mb.add(attendance);
        
        JMenuItem facultyattendance = new JMenuItem("Faculty Attendance");
        facultyattendance.setBackground(Color.WHITE);
        facultyattendance.addActionListener(this);
        attendance.add(facultyattendance);
        
        JMenuItem studentattendance = new JMenuItem("Student Attendance");
        studentattendance.setBackground(Color.WHITE);
        studentattendance.addActionListener(this);
        attendance.add(studentattendance);
        
        JMenu attendanceDetails = new JMenu("Attendance Details");
        attendanceDetails.setForeground(Color.RED);
        mb.add(attendanceDetails);
        
        JMenuItem facultyattendancedetails = new JMenuItem("Faculty Attendance Details");
        facultyattendancedetails .setBackground(Color.WHITE);
        facultyattendancedetails .addActionListener(this);
        attendanceDetails.add(facultyattendancedetails);
        
        JMenuItem studentattendancedetails = new JMenuItem("Student Attendance Details");
        studentattendancedetails.setBackground(Color.WHITE);
        studentattendancedetails.addActionListener(this);
        attendanceDetails.add(studentattendancedetails);
        
        JMenu exam = new JMenu("Examination");
        exam.setForeground(Color.BLUE);
        mb.add(exam);
        
        JMenuItem examinationdetails = new JMenuItem("Examination Results");
        examinationdetails.setBackground(Color.WHITE);
        examinationdetails.addActionListener(this);
        exam.add(examinationdetails);
        
        JMenuItem entermarks = new JMenuItem("Enter Marks");
        entermarks.setBackground(Color.WHITE);
        entermarks.addActionListener(this);
        exam.add(entermarks);
        
        JMenu updateInfo = new JMenu("Update Details");
        updateInfo.setForeground(Color.RED);
        mb.add(updateInfo);
        
        JMenuItem updatefacultyinfo = new JMenuItem("Update Faculty Details");
        updatefacultyinfo.setBackground(Color.WHITE);
        updatefacultyinfo.addActionListener(this);
        updateInfo.add(updatefacultyinfo);
        
        JMenuItem updatestudentinfo = new JMenuItem("Update Student Details");
        updatestudentinfo.setBackground(Color.WHITE);
        updatestudentinfo.addActionListener(this);
        updateInfo.add(updatestudentinfo);
        
        JMenu fee = new JMenu("Fee Details");
        fee.setForeground(Color.BLUE);
        mb.add(fee);
        
        JMenuItem feestructure = new JMenuItem("Fee Structure");
        feestructure.setBackground(Color.WHITE);
        feestructure.addActionListener(this);
        fee.add(feestructure);
        
        JMenuItem feeform = new JMenuItem("Student Fee Form");
        feeform.setBackground(Color.WHITE);
        feeform.addActionListener(this);
        fee.add(feeform);
        
        JMenuItem feedetails = new JMenuItem("Fee Details");
        feedetails.setBackground(Color.WHITE);
        feedetails.addActionListener(this);
        fee.add(feedetails);
        
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.RED);
        mb.add(utility);
        
        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setBackground(Color.WHITE);
        notepad.addActionListener(this);
        utility.add(notepad);
        
        JMenuItem calc = new JMenuItem("Calculator");
        calc.setBackground(Color.WHITE);
        calc.addActionListener(this);
        utility.add(calc);
        
        JMenu about = new JMenu("About");
        about.setForeground(Color.BLUE);
        mb.add(about);
        
        JMenuItem ab = new JMenuItem("About");
        ab.setBackground(Color.WHITE);
        ab.addActionListener(this);
        about.add(ab);
        
        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.RED);
        mb.add(exit);
        
        JMenuItem ex = new JMenuItem("Exit");
        ex.setBackground(Color.WHITE);
        ex.addActionListener(this);
        exit.add(ex);
        
        setJMenuBar(mb);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();
        
        if (msg.equals("Exit")) {
            setVisible(false);
        } else if (msg.equals("Calculator")) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e) {
                
            }
        } else if (msg.equals("Notepad")) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e) {
                
            }
        } else if (msg.equals("New Faculty Information")) {
            new AddTeacher();
        } else if (msg.equals("New Student Information")) {
            new AddStudent();
        } else if (msg.equals("View Faculty Details")) {
            new TeacherDetails();
        } else if (msg.equals("View Student Details")) {
            new StudentDetails();
        } else if (msg.equals("Faculty Attendance")) {
            new TeacherAttendance();
        } else if (msg.equals("Student Attendance")) {
            new StudentAttendance();
        } else if (msg.equals("Faculty Attendance Details")) {
            new TeacherAttendanceDetails();
        } else if (msg.equals("Student Attendance Details")) {
            new StudentAttendanceDetails();
        } else if (msg.equals("Update Faculty Details")) {
            new UpdateTeacher();
        } else if (msg.equals("Update Student Details")) {
            new UpdateStudent();
        } else if (msg.equals("Enter Marks")) {
            new EnterMarks();
        } else if (msg.equals("Examination Results")) {
            new ExaminationDetails();
        } else if (msg.equals("Fee Structure")) {
            new FeeStructure();
        } else if (msg.equals("Student Fee Form")) {
            new StudentFeeForm();
        } else if (msg.equals("Fee Details")) {
            new FeeDetails();
        } else if (msg.equals("About")) {
            new About();
        }
    }

    public static void main(String[] args) {
        new Project();
    }
}
