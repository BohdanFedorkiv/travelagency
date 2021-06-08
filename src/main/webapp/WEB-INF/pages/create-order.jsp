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
<%--<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.6/jquery.min.js" type="text/javascript"></script>--%>
<%--<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"--%>
<%--        type="text/javascript"></script>--%>
<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css"
      rel="Stylesheet"type="text/css"/>
<%--<script type="text/javascript">--%>
<%--    $(function () {--%>
<%--        $("#txtFrom").datepicker({--%>
<%--            numberOfMonths: 2,--%>
<%--            onSelect: function (selected) {--%>
<%--                var dt = new Date(selected);--%>
<%--                dt.setDate(dt.getDate() + 1);--%>
<%--                $("#txtTo").datepicker("option", "minDate", dt);--%>
<%--            }--%>
<%--        });--%>
<%--        $("#txtTo").datepicker({--%>
<%--            numberOfMonths: 2,--%>
<%--            onSelect: function (selected) {--%>
<%--                var dt = new Date(selected);--%>
<%--                dt.setDate(dt.getDate() - 1);--%>
<%--                $("#txtFrom").datepicker("option", "maxDate", dt);--%>
<%--            }--%>
<%--        });--%>
<%--    });--%>
<%--</script>--%>
<form:form method="post" action="/orders/create" modelAttribute="order">
    <table>
        <tr>
            <td>
                <label for="checkin">Check In:</label>
            </td>
            <td>
                <input type="date" name="checkin" id="checkin" min="${localDate}" max="${localDate.plusDays(100)}" required/>
            </td>
        </tr>
        <tr>
            <td>
                <label for="checkout">Check Out:</label>
            </td>
            <td>
                <input type="date" name="checkout" id="checkout" min="${localDate}" max="${localDate.plusDays(100)}" required/>
            </td>
        </tr>
    </table>
    <div>
        <label for="room_id">Room</label>
        <select id="room_id" name="room_id">
            <c:forEach var="room" items="${rooms}">
                <option value="${room.number}">${room.number}</option>
            </c:forEach>
        </select>
    </div>
    <button type="submit">Add an order</button>
</form:form>
</body>
</html>