import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class AddStudentPage extends Container{
    private JButton backButton, addButton;
    private JTextField nameField, surnameField,bookField,groupsField;
    private JComboBox facultyBox,courseBox;
    private JLabel nameLabel, surnameLabel,bookLabel, facultyLabel, groupsLabel,courseLabel, messageLabel;
    private String[] faculties = {"SIS", "UP", "CSSE", "IS","RET","FIN","MCM","SP","ITM"};
    private String[] courses = {"1","2","3","4"};
    private Long id =0L;
    public AddStudentPage(){
        setSize(600,600);
        setLayout(null);
        nameLabel = new JLabel("NAME : ");
        nameLabel.setSize(100,30);
        nameLabel.setLocation(150,100);
        add(nameLabel);

        surnameLabel = new JLabel("SURNAME : ");
        surnameLabel.setSize(100,30);
        surnameLabel.setLocation(150,150);
        add(surnameLabel);

        facultyLabel = new JLabel("FACULTY : ");
        facultyLabel.setSize(100,30);
        facultyLabel.setLocation(150,200);
        add(facultyLabel);

        bookLabel = new JLabel("Book : ");
        bookLabel.setSize(100,30);
        bookLabel.setLocation(150,250);
        add(bookLabel);

        groupsLabel = new JLabel("Group : ");
        groupsLabel.setSize(100,30);
        groupsLabel.setLocation(150,300);
        add(groupsLabel);

        courseLabel = new JLabel("Course : ");
        courseLabel.setSize(100,30);
        courseLabel.setLocation(150,350);
        add(courseLabel);

        nameField = new JTextField();
        nameField.setSize(200,30);
        nameField.setLocation(270,100);
        add(nameField);

        surnameField = new JTextField();
        surnameField.setSize(200,30);
        surnameField.setLocation(270,150);
        add(surnameField);

        facultyBox = new JComboBox(faculties);
        facultyBox.setSize(200,30);
        facultyBox.setLocation(270,200);
        add(facultyBox);

        bookField = new JTextField();
        bookField.setSize(200,30);
        bookField.setLocation(270,250);
        add(bookField);


        groupsField = new JTextField();
        groupsField.setSize(200,30);
        groupsField.setLocation(270,300);
        add(groupsField);

        courseBox = new JComboBox(courses);
        courseBox.setSize(200,30);
        courseBox.setLocation(270,350);
        add(courseBox);

        messageLabel = new JLabel("Student added successfully");
        messageLabel.setSize(400,30);
        messageLabel.setLocation(200,30);
        messageLabel.setVisible(false);
        add(messageLabel);

        backButton = new JButton("BACK");
        backButton.setSize(100,30);
        backButton.setLocation(320,400);
        backButton.setBackground(Color.WHITE);
        add(backButton);

        backButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                refresh();
                Main.frame.showMenuPage();
            }
        });

        addButton = new JButton("ADD");
        addButton.setSize(100,30);
        addButton.setLocation(190,400);
        add(addButton);

        addButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String name = nameField.getText();
                String surname = surnameField.getText();
                String faculty = facultyBox.getSelectedItem().toString();
                String book = bookField.getText();
                String groups = groupsField.getText();
                String course = courseBox.getSelectedItem().toString();
                Students st = new Students(id, name, surname, faculty,book,groups,course);
                id++;

                PackageData pd = new PackageData("add",st);
                Main.sendPackage(pd);
                refresh();
                messageLabel.setVisible(true);
            }
        });
    }

    private void refresh(){
        messageLabel.setVisible(false);
        nameField.setText("");
        surnameField.setText("");
        facultyBox.setSelectedIndex(0);
        bookField.setText("");
        groupsField.setText("");
        courseBox.setSelectedIndex(0);
    }
}