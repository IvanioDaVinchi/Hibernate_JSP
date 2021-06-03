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
    <h1>Car Management</h1>
    <h2>
        <a href="cars-form.jsp">Add New Car</a>

    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Cars</h2></caption>
        <tr>
            <th>ID</th>
            <th>CarBrand</th>
            <th>CarModel</th>
            <th>Speed</th>
            <th>Racing</th>
            <th>EngineType</th>
            <th>TransmissionType</th>
            <th>CarColor</th>
            <th>Price</th>
        </tr>
        <c:forEach var= "car" items = "${listCars}">
            <tr>
                <td><c:out value= "${car.getId()}" /></td>
                <td><c:out value= "${car.getCarBrand()}" /></td>
                <td><c:out value= "${car.getCarModel()}" /></td>
                <td><c:out value= "${car.getSpeed()}" /></td>
                <td><c:out value= "${car.getRacing()}" /></td>
                <td><c:out value= "${car.getEngineTypeByIdEngine().getId()}" /></td>
                <td><c:out value= "${car.getTransmissionTypeByIdTransmission().getId()}" /></td>
                <td><c:out value= "${car.getCarColor()}" /></td>
                <td><c:out value= "${car.getPrice()}" /></td>
                <td>
                    <a href="/edit?id=<c:out value='${car.getId()}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="delete?id=<c:out value='${car.getId()}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
