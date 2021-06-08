<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <%@ page isELIgnored="false" %>
</head>


<html>
<head>
    <title>Add a hotel</title>
</head>
<body>
<form:form method="post" action="/hotels/create" modelAttribute="hotel">
    <table>
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
</form:form>
</body>
</html>