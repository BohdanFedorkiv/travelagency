<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
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
<form:form method="post" action="/hotels/create" modelAttribute="hotel">
<div class="container">
    <table class="table table-bordered">
        <tr>
            <td>
                <label for="name">Name:</label>
            </td>
            <td>
                <input type="text" name="name" id="name" />
            </td>
        </tr>
        <tr>
            <td>
                <label for="country">Country:</label>
            </td>
            <td>
                <input type="text" name="country" id="country" />
            </td>
        </tr>
        <tr>
            <td>
                <label for="country">City:</label>
            </td>
            <td>
                <input type="text" name="city" id="city" />
            </td>
        </tr>
        <tr>
            <td>
                <label for="capacity">Capacity:</label>
            </td>
            <td>
                <input type="number" name="capacity" id="capacity" min="10"/>
            </td>
        </tr>
        <tr>
            <td>
                <label for="stars">Stars:</label>
            </td>
            <td>
                <input type="number" name="stars" id="stars" min="1" max="5"/>
            </td>
        </tr>
    </table>
    <button type="submit">Add a hotel</button>
</div>
    <br>
    <h1>${message}</h1>
</form:form>
</body>
</html>