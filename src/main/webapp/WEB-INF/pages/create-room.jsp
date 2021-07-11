<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <%@ page isELIgnored="false" %>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<html>
<head>
    <title>Add a hotel</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/home">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/hotels/allhotels">See all hotels</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/persons/create">Register</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/auth/login">Login</a>
            </li>
            <li class="nav-item">
                <form class="btn__item" action="/auth/logout" method="POST">
                    <button class="btn" type="submit">Logout </button>
                </form>
            </li>
            <c:if test="${person == null}">
                <li class="nav-item">
                    <a class="nav-link" href="#"></a>
                </li>
            </c:if>
            <c:if test="${person != null}">
                <li class="nav-item">
                    <a class="nav-link" href="/orders/allorders/${person.id}">My orders</a>
                </li>
            </c:if>
        </ul>
    </div>
</nav>
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