<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add a Car</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/WEB-INF/resources/bootstrap.min.css"/>">
</head>
<body>
<div class="container">
    <form:form modelAttribute="book" >

        <table>
            <tr>
                <td>Id:</td>
                <td><form:input path="Id"/></td>
            </tr>
            <tr>
                <td>ISBN:</td>
                <td><form:input path="ISBN"/></td>
            </tr>
            <tr>
                <td>Title:</td>
                <td><form:input path="Title"/></td>
            </tr>
            <tr>
                <td>Author:</td>
                <td><form:input path="Author"/></td>
            </tr>
            <tr>
                <td>Price:</td>
                <td><form:input path="price"/></td>
            </tr>
        </table>
        <input type="submit" value="Submit"/>
    </form:form>
</div>
</body>
</html>