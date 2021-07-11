<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <%@ page isELIgnored="false" %>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>

<html>
<head>
    <title>Add a hotel</title>
</head>
<body>
<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css"
      rel="Stylesheet"type="text/css"/>
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
<form:form method="post" action="/orders/create/${room_id.id}" modelAttribute="order">
    <table>
        <tr>
            <td>
                <label for="checkin">Check In:</label>
            </td>
            <td>
                <input type="date" name="checkin" id="checkin" min="${localDate}" max="${localDate.plusDays(100)}" required/>
            </td>
        </tr>
        <tr>
            <td>
                <label for="checkout">Check Out:</label>
            </td>
            <td>
                <input type="date" name="checkout" id="checkout" min="${localDate}" max="${localDate.plusDays(100)}" required/>
            </td>
        </tr>
    </table>
    <button type="submit">Add an order</button>
</form:form>
</body>
</html>