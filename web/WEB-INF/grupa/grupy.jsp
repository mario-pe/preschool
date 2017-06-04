<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mario
  Date: 30.05.2017
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>WesołePrzedszkole</title>
</head>
<body>
<h1> oto lista wszystkich przedszkolaków</h1>
<p>${info}</p>
<table>
    <tr>
        <td>id</td>
        <td>kat</td>
        <td>sala</td>
        <td>rok</td>

    </tr>
    <c:forEach var="grupa" items="${grupy}">
        <tr>
            <td>${grupa.id}</td>
            <td>${grupa.kat}</td>
            <td>${grupa.sala}</td>
            <td>${grupa.rok}</td>

            <c:url var="urlDelete" scope="page" value="/gAction">
                <c:param name="id" value="${grupa.id}"/>
                <c:param name="action" value="delete"/>
            </c:url>
            <td>
                <a href="${urlDelete}"><input type="button" value="usun" class="deleteButton"/></a>
            </td>
            <c:url var="urlEdit" scope="page" value="/gAction">
                <c:param name="id" value="${grupa.id}"/>
                <c:param name="kat" value="${grupa.kat}"/>
                <c:param name="sala" value="${grupa.sala}"/>
                <c:param name="rok" value="${grupa.rok}"/>
                <c:param name="action" value="edit"/>
            </c:url>
            <td>
                <a href="${urlEdit}"><input type="button" value="edytuj"/></a>
            </td>
            <c:url var="urlEdit" scope="page" value="/gAction">
                <c:param name="id" value="${grupa.id}"/>
                <c:param name="action" value="details"/>
            </c:url>
            <td>
                <a href="${urlEdit}"><input type="button" value="szczegóły"/></a>
            </td>
        </tr>
    </c:forEach>


</table>
<form action="/gAction">
    <input type="hidden" name="action" value="add"/>
    <input type="submit" value="dodaj grupe"/>
</form>


</body>
</html>
