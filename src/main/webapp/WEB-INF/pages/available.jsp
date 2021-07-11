<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%--<style><%@include file="/WEB-INF/resources/css/ava-rooms.css"%></style>--%>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>Filter</title>
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
<table>
    <thead>
    <h3>Book your room</h3>
    <a>Available rooms</a>
    <input name="checkin" value="${checkin}" readonly/>
    <input name="checkout" value="${checkout}" readonly/>
    <br/>
    <a href="/hotels/dates">Change Dates</a>
    <tr>
        <th>Id</th>
        <th>Hotel</th>
        <th>Price</th>
        <th>Number</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="room" items="${available}">
        <c:url var="Link" value="#">
            <c:param name="roomId" value="${room.id}"/>
            <c:param name="checkin" value="${checkin}"/>
            <c:param name="checkout" value="${checkout}"/>
        </c:url>
        <sf:form method="get" action="/rooms/allRooms/${room.hotel.id}">
            <tr>
                <td>${room.id}</td>
                <td>${room.hotel.name}</td>
                <td>${room.price}</td>
                <td>${room.number}</td>
                <td>
                    <button type="submit">Book</button>
                </td>
            </tr>
        </sf:form>
    </c:forEach>
    </tbody>
</table>
</body>
</html>