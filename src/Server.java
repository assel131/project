import java.io.*;
import java.util.*;
import java.net.*;
import java.sql.*;

public class Server{
    private static Connection connection;

    public static void disconnect(){
        try {
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/iitu_jdbc?useUnicode=true&serverTimezone=UTC","root", "");
        }catch (Exception e) {
            e.printStackTrace();
        }

        try{
            ServerSocket serverSocket = new ServerSocket(8888);

            while(true){
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");
                ServerThread st = new ServerThread(socket);
                st.start();

            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addStudent(Students st){
        try{
            PreparedStatement statement = connection.prepareStatement("INSERT INTO students (id,name,surname,faculty, book, groups,course) VALUES (NULL,?,?,?,?,?,?)");
            statement.setString(1,st.getName());
            statement.setString(2,st.getSurname());
            statement.setString(3,st.getFaculty());
            statement.setString(4,st.getBook());
            statement.setString(5,st.getGroups());
            statement.setString(6,st.getCourse());

            statement.executeUpdate();
            statement.close();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Students> getAllStudents(){
        ArrayList<Students> list = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM students");
            ResultSet result = statement.executeQuery();
            while(result.next()){
                Long id = result.getLong("id");
                String name = result.getString("name");
                String surname = result.getString("surname");
                String faculty = result.getString("faculty");
                String book = result.getString("book");
                String groups = result.getString("groups");
                String course = result.getString("course");
                list.add(new Students(id,name,surname,faculty,book,groups,course));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}