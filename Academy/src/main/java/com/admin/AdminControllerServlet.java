package com.admin;

import com.models.Class;
import com.models.Student;
import com.models.Subject;
import com.models.Teacher;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

public class AdminControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private DbRetrieve dbRetrieve;


    @Override
    public void init() throws ServletException {
        try {
            dbRetrieve = new DbRetrieve();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public AdminControllerServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String command = req.getParameter("command");

            if (command == null)
            {
                command = "CLASSES";
            }

            if (!getCookies(req,resp) && (!command.equals("LOGIN")))
            {
                resp.sendRedirect("/login.jsp");
            }
            else {
                // if there is no command, how to handle
                //route data to the approriate method
                switch (command)
                {
                    case "STUDENTS":
                        studentList(req,resp);
                        break;
                    case "TEACHERS":
                        teacherList(req,resp);
                        break;
                    case "SUBJECTS":
                        subjectList(req,resp);
                        break;
                    case "CLASSES":
                        classesList(req,resp);
                        break;
                    case "ST_LIST":
                        classstudentList(req,resp);
                        break;
                    case "LOGIN":
                        login(req,resp);
                        break;
                    default:
                        classesList(req,resp);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }



    private void studentList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> students = dbRetrieve.getStudents();
        req.setAttribute("STUDENT_LIST",students);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/list-students.jsp");
        dispatcher.forward(req,resp);
    }

    private void teacherList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Teacher> teachers = dbRetrieve.getTeachers();
        req.setAttribute("TEACHERS_LIST",teachers);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/list-teachers.jsp");
        dispatcher.forward(req,resp);
    }

    private void subjectList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Subject> subjects = dbRetrieve.getSubjects();

        req.setAttribute("SUBJECTS_LIST",subjects);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/list-subjects.jsp");
        dispatcher.forward(req,resp);
    }

    private void classesList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Class> classes = dbRetrieve.getClasses();
        req.setAttribute("CLASSES_LIST",classes);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/classes-list.jsp");
        dispatcher.forward(req,resp);
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println();

        if ((username.toLowerCase().equals("admin")) && password.toLowerCase().equals("123456"))
        {
            Cookie cookie = new Cookie(username, password);
            cookie.setMaxAge(86400);

            resp.addCookie(cookie);
            classesList(req,resp);
        }else {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/login.jsp");
            dispatcher.forward(req,resp);
        }
    }

    private void classstudentList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int classId = Integer.parseInt(req.getParameter("classId"));
        String section = req.getParameter("section");
        String subject = req.getParameter("subject");

        List<Student> students = dbRetrieve.loadClassStudents(classId);

        req.setAttribute("STUDENTS_LIST",students);
        req.setAttribute("SECTION",section);
        req.setAttribute("SUBJECT",subject);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/classes-students.jsp");
        dispatcher.forward(req,resp);
    }

    private boolean getCookies(HttpServletRequest req, HttpServletResponse resp){
        boolean check = false;
        Cookie[] cookies = req.getCookies();

        for (Cookie cookie: cookies) {
            if (cookie.getName().equals("admin") && cookie.getValue().equals("123456")){
                check = true;
                break;
            }
        }
        return check;
    }
}
