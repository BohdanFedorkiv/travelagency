<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <%@ page isELIgnored="false" %>
</head>


<html>
<head>
    <title>Add a hotel</title>
</head>
<body>
<form:form method="post" action="/rooms/create" modelAttribute="room">
    <table>
        <tr>
            <td>
                <label for="number">Number:</label>
            </td>
            <td>
                <input type="number" name="number" id="number" min="1" maxlength="6" required/>
            </td>
        </tr>
        <tr>
            <td>
                <label for="capacity">Capacity:</label>
            </td>
            <td>
                <input type="number" name="capacity" id="capacity" min="1" max="6" required/>
            </td>
        </tr>
        <tr>
            <td>
                <label for="price">Price:</label>
            </td>
            <td>
                <input type="number" name="price" id="price" min="1" required/>
            </td>
        </tr>
        <tr>
            <td>
                <label for="available">Available:</label>
            </td>
            <td>
                <input type="checkbox" checked="checked" name="available" id="available" required/>
            </td>
        </tr>
    </table>
    <div>
        <label for="hotelName">Hotel</label>
        <select id="hotelName" name="hotelName">
            <c:forEach var="hotel" items="${hotels}">
                <option value="${hotel.name}">${hotel.name}</option>
            </c:forEach>
        </select>
    </div>
    <button type="submit">Add a room</button>
</form:form>
</body>
</html>