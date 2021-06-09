<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 04.06.2021
  Time: 11:34
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
        <a href="/ClientsServlet">List All Clients</a>
    </h2>
</center>
<div align="center">
    <c:if test="${client == null}">
        <form action="/ClientsServlet" method="post"/>
    </c:if>
    <table border="1" cellpadding="5">
        <caption>
            <h2>
                <c:if test="${client != null}">
                    Edit Client
                </c:if>
                <c:if test="${client == null}">
                    Add New Client
                </c:if>
            </h2>
        </caption>
        <c:if test="${client != null}">
            <input type="hidden" name="id" value="<c:out value='${client.getId()}' />" />
        </c:if>
        <tr>
            <th>fName: </th>
            <td>
                <input type="text" name="fName" size="45"
                       value="<c:out value='${client.getFirstName()}' />"
                />
            </td>
        </tr>
        <tr>
            <th>sName: </th>
            <td>
                <input type="text" name="sName" size="45"
                       value="<c:out value='${client.getSecondName()}' />"
                />
            </td>
        </tr>
        <tr>
            <th>patronymic: </th>
            <td>
                <input type="text" name="patronymic" size="45"
                       value="<c:out value='${client.getPatronymic()}' />"
                />
            </td>
        </tr>
        <tr>
            <th>phoneNumber: </th>
            <td>
                <input type="text" name="phoneNumber" size="45"
                       value="<c:out value='${client.getPhoneNumber()}' />"
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