<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Add Product Form</title>
    <link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>

<div id="global">
    <c:if test="${errors != null}">

        <p id="errors">
            Error(s)!
        <ul>
            <c:forEach var="error" items="${errors}">
                <li>${error}</li>
            </c:forEach>
        </ul>


    </c:if>

    <form action="product_save" method="post">
        <fieldset>
            <legend>Add a product</legend>
            <p>
                <label for="name">Product Name: </label>
                <input type="text" id="name" name="name" value="${form.name}">
            </p>
            <p>
                <label for="description">Description: </label>
                <input type="text" id="description"
                       name="description" value="${form.description}">
            </p>
            <p>
                <label for="price">Price: </label>
                <input type="text" id="price" name="price" value="${form.price}">
            </p>
            <p id="buttons">
                <input id="reset" type="reset">
                <input id="submit" type="submit" value="Add Product">
            </p>
        </fieldset>
    </form>
</div>
</body>
</html>
