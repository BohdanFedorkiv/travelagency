<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

</head>
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
<form:form method="get" action="available" >
    <table>
        <tr>
            <td>
                <label for="checkin">Check In:</label>
            </td>
            <td>
                <input type="date" name="checkin" id="checkin" required/>
            </td>
        </tr>
        <tr>
            <td>
                <label for="checkout">Check Out:</label>
            </td>
            <td>
                <input type="date" name="checkout" id="checkout" required/>
            </td>
        </tr>
    </table>
    <button type="submit">Sent</button>
</form:form>