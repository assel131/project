import java.io.*;
public class Students implements Serializable{

    private Long id;
    private String name;
    private String surname;
    private String faculty;
    private String book;
    private String groups;
    private String course;

    public Students() {
    }

    public Students(Long id, String name, String surname, String faculty, String book, String groups, String course) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.faculty = faculty;
        this.book = book;
        this.groups = groups;
        this.course = course;
    }

    public Students(Long id, String name, String surname, String faculty, String book, String groups, String[] courses) {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getFaculty() {
        return this.faculty;
    }
    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
    public String getBook() {
        return book;
    }
    public void setBook(String book) {
        this.book = book;
    }
    public String getGroups() {
        return groups;
    }
    public void setGroups(String groups) {
        this.groups = groups;
    }
    public String getCourse() {
        return course;
    }
    public void setCourse(String course) {
        this.course = course;
    }
}