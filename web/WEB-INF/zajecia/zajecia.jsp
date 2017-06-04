<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mario
  Date: 02.06.2017
  Time: 18:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PsedskoleSATANA</title>
</head>
<body>
<h1> zajecia dodatkowe</h1>
<p>${info}</p>
<table>
    <tr>
        <td>id</td>
        <td>przedmiot</td>
        <td>godzina</td>
        <td>rok</td>
    </tr>
    <c:forEach var="grupa" items="${zajecia}">
        <tr>
            <td>${grupa.id}</td>
            <td>${grupa.przedmiot}</td>
            <td>${grupa.godzina}</td>
            <td>${grupa.rok}</td>

            <c:url var="urlDelete" scope="page" value="/zAction">
                <c:param name="id" value="${grupa.id}"/>
                <c:param name="action" value="delete"/>
            </c:url>
            <td>
                <a href="${urlDelete}"><input type="button" value="usun" class="deleteButton"/></a>
            </td>
            <c:url var="urlEdit" scope="page" value="/zAction">
                <c:param name="id" value="${grupa.id}"/>
                <c:param name="przedmiot" value="${grupa.przedmiot}"/>
                <c:param name="godzina" value="${grupa.godzina}"/>
                <c:param name="rok" value="${grupa.rok}"/>
                <c:param name="action" value="edit"/>
            </c:url>
            <td>
                <a href="${urlEdit}"><input type="button" value="edytuj"/></a>
            </td>
            <c:url var="urlEdit" scope="page" value="/zAction">
                <c:param name="id" value="${grupa.id}"/>
                <c:param name="action" value="details"/>
            </c:url>
            <td>
                <a href="${urlEdit}"><input type="button" value="szczegóły"/></a>
            </td>
        </tr>
    </c:forEach>


</table>
<form action="/zAction">
    <input type="hidden" name="action" value="add"/>
    <input type="submit" value="dodaj zajecia"/>
</form>


</body>
</html>