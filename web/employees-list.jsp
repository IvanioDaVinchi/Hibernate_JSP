<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 03.06.2021
  Time: 14.50
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
        <a href="employee-form.jsp">Add New Employee</a>

    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Employee</h2></caption>
        <tr>
            <th>ID</th>
            <th>firstName</th>
            <th>secondName</th>
            <th>patronymic</th>
            <th>position</th>
            <th>phoneNumber</th>
        </tr>
        <c:forEach var= "employee" items = "${listEmployee}">
            <tr>
                <td><c:out value= "${employee.getId()}" /></td>
                <td><c:out value= "${employee.getFirstName()}" /></td>
                <td><c:out value= "${employee.getSecondName()}" /></td>
                <td><c:out value= "${employee.getPatronymic()}" /></td>
                <td><c:out value= "${employee.getPosition()}" /></td>
                <td><c:out value= "${employee.getPhoneNumber()}" /></td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <center>
        <input type="number" name = "idBox" size = "10" />
        <input type="submit" value="Delete" name="deleteKnopka" />
    </center>
    </br>
</div>
</body>
</html>
