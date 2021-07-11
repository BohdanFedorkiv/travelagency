<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <a class="nav-link" href="/sent">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/hotels/allhotels-manager">See all hotels</a>
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
            <li class="nav-item">
                <a class="nav-link" href="/hotels/create">Add hotel</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/rooms/create">Add room</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/persons/all">All persons</a>
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
<c:if test="${info == 'anonymousUser'}">
    <h1></h1>
</c:if>
<c:if test="${info != 'anonymousUser'}">
    <h1>Welcome ${info}</h1>
    <c:forEach var="order" items="${info2}">
        <p>${order.authority}</p>
    </c:forEach>
</c:if>
<h1>Manager page</h1>
</body>
</html>

