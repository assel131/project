import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.util.*;
public class ListStudentPage extends Container{
    private JButton back;
    private JTextArea area;
    private JTable table;
    private String titles[] = {"id","name","surname","faculty","books","groups","course"};
    public ListStudentPage(){
        setSize(600,600);
        setLayout(null);

        back = new JButton("BACK");
        back.setSize(200,30);
        back.setLocation(250,450);
        add(back);

        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Main.frame.showMenuPage();
            }
        });
    }

    public void fillArea(){
        PackageData response = Main.getPackage();
        ArrayList<Students> students = response.getStudents();
        Object values[][]= new Object[students.size()][7];
        for(int i=0;i<students.size();i++){
            values[i][0] =students.get(i).getId();
            values[i][1] = students.get(i).getName();
            values[i][2] = students.get(i).getSurname();
            values[i][3] = students.get(i).getFaculty();
            values[i][4] = students.get(i).getBook();
            values[i][5] = students.get(i).getGroups();
            values[i][6] = students.get(i).getCourse();
        }

        JTable table = new JTable(values, titles);
        table.setSize(575,400);
        table.setLocation(10,10);
        add(table);
    }
}