<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mario
  Date: 31.05.2017
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Psedskole</title>
</head>
<body>
<h1> oto lista wszystkich pracowników </h1>
<p>${info}</p>
<table>
    <tr>
        <td>id</td>
        <td>imie</td>
        <td>nazwisko</td>


    </tr>
    <c:forEach var="p" items="${pracownicy}">
        <tr>
            <td>${p.id}</td>
            <td>${p.imie}</td>
            <td>${p.nazwisko}</td>

            <c:url var="urlDelete" scope="page" value="/pAction">
                <c:param name="id" value="${p.id}"/>
                <c:param name="action" value="delete"/>
            </c:url>
            <td>
                <a href="${urlDelete}"><input type="button" value="usun" class="deleteButton"/></a>
            </td>
            <c:url var="urlEdit" scope="page" value="/pAction">
                <c:param name="id" value="${p.id}"/>
                <c:param name="kat" value="${p.imie}"/>
                <c:param name="sala" value="${p.nazwisko}"/>
                <c:param name="action" value="edit"/>
            </c:url>
            <td>
                <a href="${urlEdit}"><input type="button" value="edytuj"/></a>
            </td>
            <c:url var="urlEdit" scope="page" value="/pAction">
                <c:param name="id" value="${p.id}"/>
                <c:param name="action" value="details"/>
            </c:url>
            <td>
                <a href="${urlEdit}"><input type="button" value="szczegóły"/></a>
            </td>
        </tr>
    </c:forEach>


</table>
<form action="/pAction">
    <input type="hidden" name="action" value="add"/>
    <select name="zawod">
        <option value="n">nauczyciel</option>
        <option value="o">opiekunka</option>
        <option value="s">sprzataczka</option>
        <option value="k">kucharka</option>
    </select>
    <input type="submit" value="dodaj pracownika"/>
</form>


</body>
</html>
