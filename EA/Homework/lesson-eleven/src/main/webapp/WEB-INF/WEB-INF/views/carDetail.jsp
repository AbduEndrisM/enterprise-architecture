<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Car Details</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/bootstrap.min.css"/>">
</head>
<body>
<div class="container">
    <form:form modelAttribute="car" action="../cars/${car.id}" method="post">
        <form:hidden path="id"/>
        <table>
            <tr>
                <td>Make:</td>
                <td><form:input path="make"/></td>
            </tr>
            <tr>
                <td>Model:</td>
                <td><form:input path="model"/></td>
            </tr>
            <tr>
                <td>Year:</td>
                <td><form:input path="year"/></td>
            </tr>
            <tr>
                <td>Color:</td>
                <td><form:input path="color"/></td>
            </tr>
        </table>
        <input type="submit" value="update"/>
    </form:form>

    <form action="delete?carId=${car.id}" method="post">
        <button type="submit">Delete</button>
    </form>
</div>
</body>
</html>