<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11.06.2021
  Time: 11:13
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
<div align="center">
    <form action="${pageContext.request.contextPath}/CarSupplierGUIServlet" method="post">
        <table border="1" cellpadding="5">
            <caption><h2>List of CarsSupplier</h2></caption>
            <caption><h2>"${listCarsSupplier.size()}"</h2></caption>
            <tr>
                <th>ID</th>
                <th>Car</th>
                <th>Supplier</th>
            </tr>
            <c:forEach var= "carSupplier" items = "${listCarsSupplier}">
                <tr>
                    <td><c:out value= "${carSupplier.getId()}" /></td>
                    <td><c:out value= "${carSupplier.getCarsByIdCar().getCarBrand()}" /></td>
                    <td><c:out value= "${carSupplier.getSupplierByIdSupplier().getNameSupplier()}" /></td>
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
        <br>
            <center>
                <label>Фильтры:</label>
            </center>
        <center>
            <select name="spisokCars">
                <option>Выберите из Списка</option>>
                <option>Nissan</option>
                <option>BMW</option>
                <option>Audi</option>
                <option>Ford</option>
            </select>
        </center>
        </br>
        <br>
            <center>
                <input type = submit value="Отсортировать по машинам" name = "filterKnopkaCars" />
            </center>
        </br>
        <br>
        <center>
            <select name="spisokSuppliers">
                <option>Выберите из Списка</option>>
                <option>JapaniceCarSup</option>
                <option>CarFromGerman</option>
                <option>AmerSup</option>
                <option>AMSP</option>
            </select>
        </center>
        </br>
        <br>
        <center>
            <input type = submit value="Отсортировать по поставщикам" name = "filterKnopkaSuppliers" />
        </center>
        </br>
    </form>
</div>
</body>
</html>
