<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mario
  Date: 02.06.2017
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>psedszkole</title>
</head>
<body>
<h1>Szczegóły dotyczace ucznia</h1>
<h3>Opiekunowie</h3>
<table>
    <tr>
        <td>imie</td>
        <td>nazwisko</td>
        <td>miasto</td>
        <td>ulica</td>
        <td>dom</td>
    </tr>
    <c:forEach var="o" items="${opiekunowie}">
        <tr>
            <td>${o.id}</td>
            <td>${o.imie}</td>
            <td>${o.nazwisko}</td>
            <td>${o.miejscowosc}</td>
            <td>${o.ulica}</td>
            <td>${o.dom}</td>
        </tr>
    </c:forEach>
</table>

<h3>Grupy</h3>
<table>
    <tr>
        <td>id</td>
        <td>kat</td>
        <td>sala</td>
        <td>rok</td>
    </tr>
    <c:forEach var="g" items="${grupa}">
        <tr>
            <td>${g.id}</td>
            <td>${g.kat}</td>
            <td>${g.sala}</td>
            <td>${g.rok}</td>
        </tr>
    </c:forEach>
    </tr>
</table>

<h3>Zajecia</h3>
<table>
    <tr>
        <td>id</td>
        <td>przedmiot</td>
        <td>godzina</td>
        <td>rok</td>
    </tr>
    <c:forEach var="z" items="${zajecia}">
    <tr>
        <td>${z.id}</td>
        <td>${z.przedmiot}</td>
        <td>${z.godzina}</td>
        <td>${z.rok}</td>
    </tr>
    </c:forEach>
</table>
<form action="/uAction">
<input type="hidden" value="${id}" name="id"/>
<input type="hidden" value="addKeeper" name="action"/>
<input type="submit" value="dodaj opiekuna"/>
</form>
</body>
</html>
