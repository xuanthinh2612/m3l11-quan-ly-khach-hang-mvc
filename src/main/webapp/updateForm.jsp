<%--
  Created by IntelliJ IDEA.
  User: xuant
  Date: 2/3/2021
  Time: 4:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>update</title>
</head>
<body>
<form method="post">
    <table>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name" value="${customer.getName()}"></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" name="email" value="${customer.getEmail()}"></td>
        </tr>
        <tr>
            <td>Address</td>
            <td><input type="text" name="address" value="${customer.getAddress()}"></td>
        </tr>

    </table>
    <input type="submit" value="Update">
</form>

</body>
</html>
