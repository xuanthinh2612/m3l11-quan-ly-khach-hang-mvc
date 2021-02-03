<%--
  Created by IntelliJ IDEA.
  User: xuant
  Date: 2/3/2021
  Time: 2:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Delete</title>
</head>
<body>
<form method="post">
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
    <input type="submit" value="Delete">
</form>
</body>
</html>
