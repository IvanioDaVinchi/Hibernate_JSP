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
    <form action="${pageContext.request.contextPath}/CarsServlet" method="post"/>
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
            </tr>
        </c:forEach>
    </table>
    <br>
    <center>
        <input type="number" name = "idBox" size = "10" />
        <input type="submit" value="Delete" name="deleteKnopka" />
    </center>
    </br>
    <br>
    <center>
        <label>id</label>
        <input type = text name = "idBoxUpdate" size = 2/>
        <label>carBrand</label>
        <input type = text name = "carBrand" size = 5/>
        <label>carModel</label>
        <input type = text name = "carModel" size = 5/>
        <label>speed</label>
        <input type = text name = "speed" size = 5/>
        <label>racing</label>
        <input type = text name = "racing" size = 5/>
        <label>engineType</label>
        <input type = text name = "engineType" size = 5/>
        <label>transmissionType</label>
        <input type = text name = "transmissionType" size = 5/>
        <label>color</label>
        <input type = text name = "color" size = 5/>
        <label>price</label>
        <input type = text name = "price" size = 5/>
        <input type = submit value="Update" name = "updateKnopka" />
    </center>
    </br>
</div>
</body>
</html>
