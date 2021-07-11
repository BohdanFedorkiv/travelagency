<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<head>
    <title>Home Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">--%>
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
        </ul>
    </div>
</nav>
<div class="container">
    <hr>
    <table class="table table-bordered">
        <thead class="thead-dark">
        <tr>
            <th>Hotel name</th>
            <th>Number</th>
            <th>Capacity</th>
            <th>Price</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="room" items="${rooms}">
            <tr>
                <td>${room.hotel.name}</td>
                <td><a href="/orders/create/${room.id}">${room.number}</a></td>
                <td>${room.capacity}</td>
                <td>${room.price}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>