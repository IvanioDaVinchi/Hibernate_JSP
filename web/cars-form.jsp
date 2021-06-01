<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Polska Sait</title>
</head>
<body>
<center>
    <h1></h1>
    <h2>
        &nbsp;&nbsp;&nbsp;
        <a href="cars-list.jsp">List All Cars</a>

    </h2>
</center>
<div align="center">
        <if test="${car == null}">
        <form action="CarsServlet/insert" method="post"/>
        </if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <if test="${car != null}">
                            Edit Car
                        </if>
                        <if test="${car == null}">
                            Add New Car
                        </if>
                    </h2>
                </caption>
                <if test="${car != null}">
                    <input type="hidden" name="id" value="<out value='${car.getId()}' />" />
                </if>
                <tr>
                    <th>carBrand: </th>
                    <td>
                        <input type="text" name="carBrand" size="45"
                               value="<out value='${car.getCarBrand()}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>carModel: </th>
                    <td>
                        <input type="text" name="carModel" size="45"
                               value="<out value='${car.getModel()}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Speed: </th>
                    <td>
                        <input type="text" name="Speed" size="15"
                               value="<out value='${car.getSpeed()}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Racing: </th>
                    <td>
                        <input type="text" name="Racing" size="15"
                               value="<out value='${car.getRacing()}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>EngineType: </th>
                    <td>
                        <input type="text" name="EngineType" size="15"
                               value="<out value='${car.getEngineTypeByIdEngine()}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>TransmissionType: </th>
                    <td>
                        <input type="text" name="TransmissionType" size="15"
                               value="<out value='${car.getTransmissionTypeByIdTransmission()}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>CarColor: </th>
                    <td>
                        <input type="text" name="CarColor" size="15"
                               value="<out value='${car.getCarColor()}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Price: </th>
                    <td>
                        <input type="text" name="Price" size="15"
                               value="<out value='${car.getPrice()}' />"
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
