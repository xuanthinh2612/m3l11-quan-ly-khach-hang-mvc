<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Customer List </title>
</head>
<body>
<h1>Customer List</h1>
<a href="/customer?action=create">Create new</a>
<form>
    <input type="text" size="30" name="name">
<%--    <input type="search" value="find" name="action">--%>
    <input  name="action" type="submit" value="find" >
</form>
<table>
    <tr>
        <td>Name</td>
        <td>Email</td>
        <td>Address</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>

    <c:forEach items="${list}" var="customer">
        <tr>
            <td>${customer.getName()}</td>
            <td>${customer.getEmail()}</td>
            <td>${customer.getAddress()}</td>
            <td><a href="/customer?action=update&id=${customer.getId()}">update</a></td>
            <td><a href="/customer?action=delete&id=${customer.getId()}">delete</a></td>
            <td><a href="/customer?action=detail&id=${customer.getId()}">detail</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
