<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 04.06.2021
  Time: 12:36
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
        <a href="/EngineTypesServlet">List Engines</a>
    </h2>
</center>
<div align="center">
    <c:if test="${engine == null}">
        <form action="/EngineTypesServlet" method="post"/>
    </c:if>
    <table border="1" cellpadding="5">
        <caption>
            <h2>
                <c:if test="${engine != null}">
                    Edit engine
                </c:if>
                <c:if test="${engine == null}">
                    Add New engine
                </c:if>
            </h2>
        </caption>
        <c:if test="${engine != null}">
            <input type="hidden" name="id" value="<c:out value='${engine.getId()}' />" />
        </c:if>
        <tr>
            <th>nameEngine: </th>
            <td>
                <input type="text" name="nameEngine" size="45"
                       value="<c:out value='${engine.get()}' />"
                />
            </td>
        </tr>
        <tr>
            <th>engineCapacity: </th>
            <td>
                <input type="text" name="engineCapacity" size="45"
                       value="<c:out value='${engine.getEngineCapacity()}' />"
                />
            </td>
        </tr>
        <tr>
            <th>enginePower: </th>
            <td>
                <input type="text" name="enginePower" size="45"
                       value="<c:out value='${engine.getSupplierByIdSupplier().getId()}' />"
                />
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="Save" name="insertKnopka" />
            </td>
        </tr>
    </table>
</div>
</body>
</html>
