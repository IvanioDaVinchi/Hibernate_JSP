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
        <a href="carsSuppliers-form.jsp">Add New carSupplier</a>

    </h2>
</center>
<div align="center">
    <form action="${pageContext.request.contextPath}/CarsSuppliersServlet" method="post">
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
        <label>idCar</label>
        <input type = text name = "idCar" size = 2/>
        <label>idSupplier</label>
        <input type = text name = "idSupplier" size = 2/>
        <input type = submit value="Update" name = "updateKnopka" />
    </center>
    </br>
    </form>
</div>
</body>
</html>