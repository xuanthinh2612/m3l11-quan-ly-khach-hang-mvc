<%--
  Created by IntelliJ IDEA.
  User: xuant
  Date: 2/3/2021
  Time: 4:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detail</title>
</head>
<body>
<table>
    <tr>
        <td>Name</td>
        <td>${customer.getName()}</td>
    </tr>
    <tr>
        <td>Email</td>
        <td>${customer.getEmail()}</td>
    </tr>

    <tr>
        <td>Address</td>
        <td>${customer.getAddress()}</td>
    </tr>
</table>
<a href="/customer">Back</a>
</body>
</html>
