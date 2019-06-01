<%--
  Created by IntelliJ IDEA.
  User: Abdu
  Date: 30-May-19
  Time: 6:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Result</title>
</head>
<body>

<input type = "text" name = "add1" size = "2"  value ="${myCalc.add1}" />+
<input type = "text" name = "add2" value = "<%= request.getParameter("add2")%>" size = "2"/>=<input type = "text" name = "sum" value = "${sum}"  size = "2" readonly/><br/>
<input type = "text" name = "mult1" value = "${input.get("x")}" size = "2"/>*
<input type = "text" name = "mult2" value = "${input.get("y")}"  size = "2"/>=<input type = "text" name = "product" value = "${product}"   size = "2" readonly/><br/>

${answer}

</body>
</html>
