<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 31.05.2021
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
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
        <forEach var= "car" items = "${listCars}">
            <tr>
                <td><out value= "${car.getId()}" /></td>
                <td><out value= "${car.getCarBrand()}" /></td>
                <td><out value= "${car.getCarModel()}" /></td>
                <td><out value= "${car.getSpeed()}" /></td>
                <td><out value= "${car.getRacing()}" /></td>
                <td><out value= "${car.getEngineTypeByIdEngine()}" /></td>
                <td><out value= "${car.getTransmissionTypeByIdTransmission()}" /></td>
                <td><out value= "${car.getCarColor()}" /></td>
                <td><out value= "${car.getPrice()}" /></td>
                <td>
                    <a href="edit?id=<out value='{car.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="delete?id=<out value='{car.id}' />">Delete</a>
                </td>
            </tr>
        </forEach>
    </table>
</div>
</body>
</html>
