<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <%@ page isELIgnored="false" %>
</head>


<html>
<head>
    <title>Sign in</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
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
<form:form method="post" action="/persons/create" modelAttribute="person">
    <table class="table table-bordered">
        <tr>
            <td>
                <label for="firstName">First Name:</label>
            </td>
            <td>
                <input type="text" name="firstName" id="firstName" min="1" required/>
            </td>
        </tr>
        <tr>
            <td>
                <label for="lastName">Last Name:</label>
            </td>
            <td>
                <input type="text" name="lastName" id="lastName" required/>
            </td>
        </tr>
        <tr>
            <td>
                <label for="email">Email:</label>
            </td>
            <td>
                <input type="text" name="email" id="email" required/>
            </td>
        </tr>
        <tr>
            <td>
                <label for="password">Password:</label>
            </td>
            <td>
                <input type="password" name="password" id="password" required/>
            </td>
        </tr>
    </table>
    <button type="submit">Register</button>
</form:form>
</div>
<br>
<h1>${message}</h1>
</body>
</html>