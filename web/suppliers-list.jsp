<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 04.06.2021
  Time: 11:08
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
        <a href="cars-from.jsp">Add New Supplier</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Suppliers</h2></caption>
        <tr>
            <th>ID</th>
            <th>nameSupplier</th>
        </tr>
        <c:forEach var= "supplier" items = "${listSuppliers}">
            <tr>
                <td><c:out value= "${supplier.getId()}" /></td>
                <td><c:out value= "${supplier.getNameSupplier()}" /></td>
                <td>
                    <a href="edit?id=<c:out value='${supplier.getId()}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="delete?id=<c:out value='${supplier.getId()}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
