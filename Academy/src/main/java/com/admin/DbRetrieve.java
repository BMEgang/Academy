package com.admin;

import com.models.Class;
import com.models.Student;
import com.models.Subject;
import com.models.Teacher;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbRetrieve {
    Connection myConn = null;
    Statement myStmt = null;
    ResultSet myRs = null;

    public DbRetrieve() throws ClassNotFoundException, SQLException {
        java.lang.Class.forName("com.mysql.cj.jdbc.Driver");
        myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/administrative-portal","root","Hu123456");
        System.out.println("connection established with database");
        myStmt = myConn.createStatement();
    }

    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM Academicadmin.students";
        try {

            myRs = myStmt.executeQuery(sql);

            while (myRs.next())
            {
                int id = myRs.getInt("id");
                String firstname = myRs.getString("fname");
                String lastname = myRs.getString("lname");
                int age = myRs.getInt("age");
                int aclass = myRs.getInt("class");

                Student tempstudent = new Student(id,firstname,lastname,age,aclass);

                students.add(tempstudent);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public List<Teacher> getTeachers(){
        List<Teacher> teachers = new ArrayList<>();
        String sql = "SELECT * FROM Academicadmin.teachers";

        try {

            myRs = myStmt.executeQuery(sql);

            while (myRs.next())
            {
                int id = myRs.getInt("id");
                String firstname = myRs.getString("fname");
                String lastname = myRs.getString("lname");
                int age = myRs.getInt("age");

                Teacher tempteacher = new Teacher(id,firstname,lastname,age);

                teachers.add(tempteacher);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return teachers;
    }

    public List<Subject> getSubjects(){
        List<Subject> subjects = new ArrayList<>();

        String sql = "SELECT * FROM Academicadmin.subjects";

        try {
            myRs = myStmt.executeQuery(sql);

            while (myRs.next())
            {
                int id = myRs.getInt("id");
                String name = myRs.getString("name");
                String shortcut = myRs.getString("shortcut");



                Subject tempsubject = new Subject(id,name,shortcut);

                subjects.add(tempsubject);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return subjects;
    }

    public List<Class> getClasses()
    {
        List<Class> classes = new ArrayList<>();

        String sql = "SELECT * FROM Academicadmin.classes";

        try {
            myRs = myStmt.executeQuery(sql);

            while (myRs.next())
            {
                int id = myRs.getInt("id");
                int section = myRs.getInt("section");
                int subject = myRs.getInt("subject");
                int teacher = myRs.getInt("teacher");
                String time = myRs.getString("time");

                Teacher tempTeacher = loadTeacher(teacher);
                Subject temoSubject = loadSubject(subject);

                String teacher_name = tempTeacher.getFname()+ " " + tempTeacher.getLname();
                Class tempclass = new Class(id,section,teacher_name,temoSubject.getName(),time);

                classes.add(tempclass);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return classes;
    }

    public Teacher loadTeacher(int teacherId)
    {
        Teacher ret = null;

        String sql = "SELECT * FROM Academicadmin.teachers WHERE id =" + teacherId;

        try {

            myRs = myStmt.executeQuery(sql);

            while (myRs.next()){
                int id = myRs.getInt("id");
                String firstname = myRs.getString("fname");
                String lastname = myRs.getString("lname");
                int age = myRs.getInt("age");

                ret = new Teacher(id,firstname,lastname,age);


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    public Subject loadSubject(int Subject_id)
    {
        Subject ret = null;

        String sql = "SELECT * FROM Academicadmin.subjects WHERE id =" + Subject_id;

        try {
            myRs = myStmt.executeQuery(sql);

            while (myRs.next()){
                int id = myRs.getInt("id");
                String name = myRs.getString("name");
                String shortcut = myRs.getString("shortcut");

                ret = new Subject(id,name,shortcut);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ret;
    }

    public Class loadClass(int classId)
    {
        Class ret = null;

        String sql = "SELECT * FROM Academicadmin.classes WHERE id =" + classId;

        try {
            myRs = myStmt.executeQuery(sql);

            while (myRs.next()){
                int id = myRs.getInt("id");
                int section = myRs.getInt("section");
                int subject = myRs.getInt("subject");
                int teacher = myRs.getInt("teacher");
                String time = myRs.getString("time");

                Teacher tempTeacher = loadTeacher(teacher);
                Subject temoSubject = loadSubject(subject);

                String teacher_name = tempTeacher.getFname()+ " " + tempTeacher.getLname();

                ret = new Class(id,section,teacher_name,temoSubject.getName(),time);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ret;
    }

    public List<Student> loadClassStudents(int classId)
    {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM Academicadmin.students WHERE class =" + classId;

        try {
            myRs = myStmt.executeQuery(sql);

            while (myRs.next()){
                int id = myRs.getInt("id");
                String firstname = myRs.getString("fname");
                String lastname = myRs.getString("lname");
                int age = myRs.getInt("age");
                int aclass = myRs.getInt("class");

                Student tempstudent = new Student(id,firstname,lastname,age,aclass);
                students.add(tempstudent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return students;
    }

}
