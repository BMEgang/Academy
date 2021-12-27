<%--
  Created by IntelliJ IDEA.
  User: ganghu
  Date: 12/27/21
  Time: 9:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>List of Students</title>
    <link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>
<div id="page">
    <jsp:include page="left-list.jsp"/>
    <div id="wrapper">
        <div id="header">
            <h3>Students</h3>
        </div>
    </div>

    <div id="container">
        <div id="content">
            <table>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>age</th>
                </tr>

                <c:forEach var="tempStudent" items="${STUDENT_LIST}">
                    <tr>
                        <td>${tempStudent.fname}</td>
                        <td>${tempStudent.lname}</td>
                        <td>${tempStudent.age}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>
