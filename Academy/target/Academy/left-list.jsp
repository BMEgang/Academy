<%--
  Created by IntelliJ IDEA.
  User: ganghu
  Date: 12/27/21
  Time: 3:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="sidenav">
    <h3 id="logo">
        Administrative <br/>
        Academy Portal
    </h3>

    <c:url var="classesLink" value="/AdminControllerServlet">
        <c:param name="command" value="CLASSES"/>
    </c:url>

    <c:url var="subjectsLink" value="/AdminControllerServlet">
        <c:param name="command" value="SUBJECTS"/>
    </c:url>

    <c:url var="teachersLink" value="/AdminControllerServlet">
        <c:param name="command" value="TEACHERS"/>
    </c:url>

    <c:url var="studentsLink" value="/AdminControllerServlet">
        <c:param name="command" value="STUDENTS"/>
    </c:url>


    <a class="bar-item" href="${classesLink}">classes</a>
    <a class="bar-item" href="${subjectsLink}">Subjects</a>
    <a class="bar-item" href="${teachersLink}">Teachers</a>
    <a class="bar-item" href="${studentsLink}">Students</a>
    <a class="bar-item" href="login.jsp">Log out</a>

</div>
