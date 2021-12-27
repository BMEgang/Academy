<%--
  Created by IntelliJ IDEA.
  User: ganghu
  Date: 12/27/21
  Time: 9:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>List Of Subject</title>
    <link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>
<div id="page">
    <jsp:include page="left-list.jsp"/>
    <div id="wrapper">
        <div id="header">
            <h3>Subjects</h3>
        </div>
    </div>

    <div id="container">
        <div id="content">
            <table>
                <tr>
                    <th>Name</th>
                    <th>short cut</th>
                </tr>

                <c:forEach var="tempSubject" items="${SUBJECTS_LIST}">
                    <tr>
                        <td>${tempSubject.name}</td>
                        <td>${tempSubject.shortcut}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>
