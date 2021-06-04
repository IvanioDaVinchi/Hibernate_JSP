<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 04.06.2021
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>polska Sait</title>
</head>
<body>
<center>
    <h2>
        <a href="cars-from.jsp">Add New Transmission</a>

    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Transmissions</h2></caption>
        <tr>
            <th>ID</th>
            <th>nameTransmission</th>
            <th>numberOfGears</th>
        </tr>
        <c:forEach var= "transmission" items = "${listTransmission}">
            <tr>
                <td><c:out value= "${transmission.getId()}" /></td>
                <td><c:out value= "${transmission.getNameTransmission()}" /></td>
                <td><c:out value= "${transmission.getNumberOfGears()}" /></td>
                <td>
                    <a href="edit?id=<c:out value='${transmission.getId()}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="delete?id=<c:out value='${transmission.getId()}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
