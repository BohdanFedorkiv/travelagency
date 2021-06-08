<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<table border="1">
    <thead>
    <tr>
        <th>Id</th>
        <th>Email</th>
        <th>Name</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="person" items="${persons}">
        <sf:form method="get" action="${ordersLink}">
            <tr>
                <td>${person.id}</td>
                <td>${person.email}</td>
                <td>${person.firstName}</td>
            </tr>
        </sf:form>
    </c:forEach>
    </tbody>
</table>
</body>
</html>