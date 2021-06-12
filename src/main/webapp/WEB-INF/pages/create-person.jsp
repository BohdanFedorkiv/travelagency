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
</head>
<body>
<div class="container">
<form:form method="post" action="/persons/signin" modelAttribute="person">
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
    <button type="submit">Sign in</button>
</form:form>
</div>
<br>
<h1>${message}</h1>
</body>
</html>