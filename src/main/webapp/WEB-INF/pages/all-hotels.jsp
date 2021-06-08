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
<form:form cssClass="form-inline" action="searchHotel" method="get">
<div class="input-group">
    <input class="form-control mr-sm-2" placeholder="Search by Country" type="search"
           name="country"/>
    <button class="btn btn-success my-2 my-sm-0" type="submit">Search</button>
</div>
</form:form>
<c:choose>
<c:when test="${searchHotel.size()>=0}">
<div>
    <form:form cssClass="form-inline" action="searchHotel" method="get">
        <table class="table table-bordered">
            <thead class="thead-dark">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Country</th>
                <th>City</th>
            </tr>
            </thead>
            <tbody>
        <c:forEach var="h" items="${searchHotel}">
            <tr>
                <td>${h.id}</td>
                <td>${h.name}</td>
                <td>${h.country}</td>
                <td>${h.city}</td>
            </tr>
        </c:forEach>
            </tbody>
        </table>
    </form:form>
</div>
</c:when>
<c:otherwise>
<div class="container">
    <hr>
    <table class="table table-bordered">
        <thead class="thead-dark">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Country</th>
            <th>City</th>
            <th>Number of rooms</th>
            <th>Remove</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="hotel" items="${hotels}">
            <tr>
                <td>${hotel.id}</td>
                <td>
                    <a href="/rooms/allRooms/${hotel.id}">${hotel.name}</a>
                </td>
                <td>${hotel.country}</td>
                <td>${hotel.city}</td>
                <td>${hotel.rooms.size()}</td>
                <td>
                    <a href="/hotels/deleteHotel/${hotel.id}">Remove</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</c:otherwise>
</c:choose>
</body>

</html>