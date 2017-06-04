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
${info}
<h1>Szczegóły dotyczace ucznia <p>${child.imie} ${child.nazwisko}</p></h1>
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
            <c:url var="urlDelete" scope="page" value="/uAction">
                <c:param name="idk" value="${o.id}"/>
                <c:param name="id" value="${id}"/>
                <c:param name="action" value="deleteKeeper"/>
            </c:url>
            <td>
                <a href="${urlDelete}"><input type="button" value="usun" class="deleteButton"/></a>
            </td>
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
            <c:url var="urlDelete" scope="page" value="/uAction">
                <c:param name="idG" value="${g.id}"/>
                <c:param name="id" value="${id}"/>
                <c:param name="action" value="deleteFromGrupa"/>
            </c:url>
            <td>
                <a href="${urlDelete}"><input type="button" value="usun" class="deleteButton"/></a>
            </td>
        </tr>
    </c:forEach>
    </tr>
</table>
<form action="/uAction">
    <input type="hidden" value="${id}" name="id"/>
    <input type="hidden" value="addGrupa" name="action"/>
    <label> dodaj ucznia do grupy </label>
    <input type="text" name="id_grupy" size="20">
    <input type="submit" value="dodaj">
</form>

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
        <c:url var="urlDelete" scope="page" value="/uAction">
            <c:param name="idZ" value="${z.id}"/>
            <c:param name="id" value="${id}"/>
            <c:param name="action" value="deleteFromZajecia"/>
        </c:url>
        <td>
            <a href="${urlDelete}"><input type="button" value="usun" class="deleteButton"/></a>
        </td>
    </tr>
    </c:forEach>
</table>
<form action="/uAction">
    <input type="hidden" value="${id}" name="id"/>
    <input type="hidden" value="addZajecia" name="action"/>
    <label> dodaj ucznia do zajec dodatkowych </label>
    <input type="text" name="id_zajecia" size="20">
    <input type="submit" value="dodaj">
</form>
<form action="/uAction">
<input type="hidden" value="${id}" name="id"/>
<input type="hidden" value="addKeeper" name="action"/>
<input type="submit" value="dodaj opiekuna"/>
</form>
</body>
</html>
