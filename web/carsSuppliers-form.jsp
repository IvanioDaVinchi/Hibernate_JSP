<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 04.06.2021
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Polska Sait</title>
</head>
<body>
<center>
    <h1></h1>
    <h2>
        &nbsp;&nbsp;&nbsp;
        <a href="CarsServlet">List All carsSupplier</a>

    </h2>
</center>
<div align="center">
    <c:if test="${carSupplier == null}">
        <form action="/CarsSuppliersServlet/insert" method="post"/>
    </c:if>
    <table border="1" cellpadding="5">
        <caption>
            <h2>
                <c:if test="${carSupplier != null}">
                    Edit carSupplier
                </c:if>
                <c:if test="${carSupplier == null}">
                    Add New carSupplier
                </c:if>
            </h2>
        </caption>
        <c:if test="${car != null}">
            <input type="hidden" name="id" value="<c:out value='${carSupplier.getId()}' />" />
        </c:if>
        <tr>
            <th>carBrand: </th>
            <td>
                <input type="text" name="idCar" size="45"
                       value="<c:out value='${carSupplier.getCarsByIdCar().getId()}' />"
                />
            </td>
        </tr>
        <tr>
            <th>carModel: </th>
            <td>
                <input type="text" name="idSupplier" size="45"
                       value="<c:out value='${carSupplier.getSupplierByIdSupplier().getId()}' />"
                />
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="Save" />
            </td>
        </tr>
    </table>
    </form>
</div>
</body>
</html>
