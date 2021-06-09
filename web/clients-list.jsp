<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 03.06.2021
  Time: 13.55
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
        <a href="clients-form.jsp">Add New Client</a>

    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Clients</h2></caption>
        <tr>
            <th>ID</th>
            <th>firstName</th>
            <th>secondName</th>
            <th>patronymic</th>
            <th>phoneNumber</th>
        </tr>
        <c:forEach var= "client" items = "${listClient}">
            <tr>
                <td><c:out value= "${client.getId()}" /></td>
                <td><c:out value= "${client.getFirstName()}" /></td>
                <td><c:out value= "${client.getSecondName()}" /></td>
                <td><c:out value= "${client.getPatronymic()}" /></td>
                <td><c:out value= "${client.getPhoneNumber()}" /></td>
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
