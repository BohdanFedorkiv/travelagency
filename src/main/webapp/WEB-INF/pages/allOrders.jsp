<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

    <title>Hello, world!</title>
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
            <th>Room number</th>
            <th>Hotel name</th>
            <th>Checkin</th>
            <th>Checkout</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="order" items="${orders}">
            <tr>
                <td>${order.room.number}</td>
                <td>${order.room.hotel.name}</td>
                <td>${order.checkin}</td>
                <td>${order.checkout}</td>
                <th><a href="/orders/delete/${order.id}">Delete</a></th>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>