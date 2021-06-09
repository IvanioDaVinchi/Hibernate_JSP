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
        <a href="/CarsServlet">List All Cars</a>

    </h2>
</center>
<div align="center">
        <c:if test="${car == null}">
        <form action="${pageContext.request.contextPath}/CarsServlet" method="post">
        </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${car != null}">
                            Edit Car
                        </c:if>
                        <c:if test="${car == null}">
                            Add New Car
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${car != null}">
                    <input type="hidden" name="id" value="<c:out value='${car.getId()}' />" />
                </c:if>
                <tr>
                    <th>carBrand: </th>
                    <td>
                        <input type="text" name="carBrand" size="45"
                               value="<c:out value='${car.getCarBrand()}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>carModel: </th>
                    <td>
                        <input type="text" name="carModel" size="45"
                               value="<c:out value='${car.getModel()}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Speed: </th>
                    <td>
                        <input type="text" name="speed" size="15"
                               value="<c:out value='${car.getSpeed()}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Racing: </th>
                    <td>
                        <input type="text" name="racing" size="15"
                               value="<c:out value='${car.getRacing()}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>EngineType: </th>
                    <td>
                        <input type="text" name="engineType" size="15"
                               value="<c:out value='${car.getEngineTypeByIdEngine().getId()}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>TransmissionType: </th>
                    <td>
                        <input type="text" name="transmissionType" size="15"
                               value="<c:out value='${car.getTransmissionTypeByIdTransmission().getId()}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>CarColor: </th>
                    <td>
                        <input type="text" name="color" size="15"
                               value="<c:out value='${car.getCarColor()}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Price: </th>
                    <td>
                        <input type="text" name="price" size="15"
                               value="<c:out value='${car.getPrice()}' />"
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
