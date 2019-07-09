<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Cars currently in the shop</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/WEB-INF/resources/bootstrap.min.css"/>">
</head>
<body>
<div class="container">
    <h1>Cars currently in the shop</h1>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Make</th>
            <th scope="col">Model</th>
            <th scope="col">Year</th>
            <th scope="col">Color</th>
            <th scope="col">Operation</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="book" items="${books}">
            <tr>
                <td>${book.id}</td>
                <td>${book.isbn}</td>
                <td>${book.title}</td>
                <td>${book.author}</td>
                <td><a href="book/${book.id}">edit</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="addBook"> Add a Book</a>
</div>

</body>
</html>