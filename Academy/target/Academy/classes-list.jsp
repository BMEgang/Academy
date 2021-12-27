<%--
  Created by IntelliJ IDEA.
  User: ganghu
  Date: 12/27/21
  Time: 3:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>List of Classes</title>
    <link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>
<div id="page">
    <jsp:include page="left-list.jsp"/>

    <div id="wrapper">
        <div id="header">
            <h3>Classes</h3>
        </div>
    </div>

    <div id="container">
        <div id="content">
            <table>
                <tr>
                    <th>Section</th>
                    <th>Subject</th>
                    <th>Teacher</th>
                    <th>Time</th>
                    <th>List Of Student</th>
                </tr>

                <c:forEach var="tempClass" items="${CLASSES_LIST}">
                    <tr>
                        <c:url var="tempLink" value="/AdminControllerServlet">
                            <c:param name="command" value="ST_LIST"/>
                            <c:param name="classId" value="${tempClass.id}"/>
                            <c:param name="section" value="${tempClass.section}"/>
                            <c:param name="subject" value="${tempClass.subject}"/>
                        </c:url>

                        <td>${tempClass.section}</td>
                        <td>${tempClass.subject}</td>
                        <td>${tempClass.teacher}</td>
                        <td>${tempClass.time}</td>
                        <td><a href="${tempLink}"></a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>
