<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 04.06.2021
  Time: 10:25
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
        <a href="cars-from.jsp">Add New Engine</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Engines</h2></caption>
        <tr>
            <th>ID</th>
            <th>dateSale</th>
            <th>IdClients</th>
            <th>IdCars</th>
            <th>IdEmployeers</th>
        </tr>
        <c:forEach var= "sale" items = "${listSales}">
            <tr>
                <td><c:out value= "${sale.getId()}" /></td>
                <td><c:out value= "${sale.getDateSale()}" /></td>
                <td><c:out value= "${sale.getClientsByIdClient().getId()}" /></td>
                <td><c:out value= "${sale.getCarsByIdCar().getId()}" /></td>
                <td><c:out value= "${sale.getEmployeersByIdEmployee().getId()}" /></td>
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
