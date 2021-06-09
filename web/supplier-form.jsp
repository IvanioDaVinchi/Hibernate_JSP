<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 07.06.2021
  Time: 10:32
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
    <h2>
        &nbsp;&nbsp;&nbsp;
        <a href="/SuppliersServlet">List Suppliers</a>
    </h2>
</center>
<div align="center">
    <c:if test="${engine == null}">
        <form action="/SuppliersServlet" method="post"/>
    </c:if>
    <table border="1" cellpadding="5">
        <caption>
            <h2>
                <c:if test="${supplier != null}">
                    Edit Supplier
                </c:if>
                <c:if test="${supplier == null}">
                    Add New Supplier
                </c:if>
            </h2>
        </caption>
        <c:if test="${supplier != null}">
            <input type="hidden" name="id" value="<c:out value='${supplier.getId()}' />" />
        </c:if>
        <tr>
            <th>nameSupplier: </th>
            <td>
                <input type="text" name="nameSupplier" size="45"
                       value="<c:out value='${supplier.getNameSupplier()}' />"
                />
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="Save" name="insertKnopka" />
            </td>
        </tr>
    </table>
    </form>
</div>
</body>
</html>
