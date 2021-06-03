<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 31.05.2021
  Time: 15:07
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
        <a href="cars-from.jsp">Add New carSupplier</a>

    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of CarsSupplier</h2></caption>
        <tr>
            <th>ID</th>
            <th>idCar</th>
            <th>idSupplier</th>
        </tr>
        <c:forEach var= "carSupplier" items = "${listCarsSupplier}">
            <tr>
                <td><c:out value= "${carSupplier.getId()}" /></td>
                <td><c:out value= "${carSupplier.getCarsByIdCar().getId()}" /></td>
                <td><c:out value= "${carSupplier.getSupplierByIdSupplier().getId()}" /></td>
                <td>
                    <a href="/edit?id=<c:out value='${carSupplier.getId()}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="delete?id=<c:out value='${carSupplier.getId()}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
