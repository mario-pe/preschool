<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mario
  Date: 28.05.2017
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Psedskole</title>
</head>
<body>
<h1> oto lista wszystkich przedszkolaków</h1>
<p>${info}</p>
<table>
    <tr>
        <td>id</td>
        <td>imie</td>
        <td>nazwisko</td>
        <td>miasto</td>
        <td>ulica</td>
        <td>dom</td>
    </tr>
    <c:forEach var="grupa" items="${children}">
        <tr>
            <td>${grupa.id}</td>
            <td>${grupa.imie}</td>
            <td>${grupa.nazwisko}</td>
            <td>${grupa.miejscowosc}</td>
            <td>${grupa.ulica}</td>
            <td>${grupa.dom}</td>
            <c:url var="urlDelete" scope="page" value="/uAction">
                <c:param name="id" value="${grupa.id}"/>
                <c:param name="action" value="delete"/>
            </c:url>
            <td>
                <a href="${urlDelete}"><input type="button" value="usun" class="deleteButton"/></a>
            </td>
            <c:url var="urlEdit" scope="page" value="/uAction">
                <c:param name="id" value="${grupa.id}"/>
                <c:param name="imie" value="${grupa.imie}"/>
                <c:param name="nazwisko" value="${grupa.nazwisko}"/>
                <c:param name="miejscowosc" value="${grupa.miejscowosc}"/>
                <c:param name="ulica" value="${grupa.ulica}"/>
                <c:param name="dom" value="${grupa.dom}"/>
                <c:param name="action" value="edit"/>
            </c:url>
            <td>
                <a href="${urlEdit}"><input type="button" value="edytuj"/></a>
            </td>
            <c:url var="urlEdit" scope="page" value="/uAction">
                <c:param name="id" value="${grupa.id}"/>
                <c:param name="action" value="details"/>
            </c:url>
            <td>
                <a href="${urlEdit}"><input type="button" value="szczegóły"/></a>
            </td>
        </tr>
    </c:forEach>


</table>
<form action="/uAction">
    <input type="hidden" name="action" value="add"/>
    <input type="submit" value="dodaj przedszkolaka"/>
</form>


</body>
</html>
