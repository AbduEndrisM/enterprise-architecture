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


    <p> ISBN:  ${book.isbn} <p/>
    <p> Title: ${book.title} </p>
    <p> Author:  ${book.author} </p>
    <p> Price:  ${book.price} </p>
    <br/>
    <a href="bookList.jsp"><button> Back</button></a>

</div>
</body>
</html>