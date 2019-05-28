<%--
  Created by IntelliJ IDEA.
  User: Abdu
  Date: 28-May-19
  Time: 1:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>

<h4> Answer</h4>


<div class="container">
    <%
        int num1 = (int) request.getAttribute("num1");
        int num2 = (int) request.getAttribute("num2");
        int sum = (int) request.getAttribute("sum");
        int num11 = (int) request.getAttribute("num11");
        int num22 = (int) request.getAttribute("num22");
        int product= (int) request.getAttribute("product");

    %>
    <input type="text" value= <%=num1%> name="num1" id="num1"> +
    <input type="text" value= <%=num2%> name="num2" id="num2">  =
    <input type="text" value= <%=sum%> name="sum" id="sum">
    <br><br>
    <input type="text" value= <%=num11%> > +
    <input type="text" value= <%=num22%> >  =
    <input type="text" value= <%=product%> >
    <br><br>

</div>

</form>





<h4>EL</h4>
  ${sum} <br>
  ${product}


</body>
</html>
