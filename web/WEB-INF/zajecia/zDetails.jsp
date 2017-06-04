<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mario
  Date: 04.06.2017
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PsedskoleSATANA</title>
</head>
<body>

<h1>Lista dzieci uczeszczajacych na zajecia id:${zajecia.id}, ${zajecia.przedmiot}, ${zajecia.godzina}, ${zajecia.dzien}, </h1>
nauczyciel prowadzacy ${pracownik.id} ${pracownik.imie} ${pracownik.nazwisko}
<table>
    <tr>
        <td>id</td>
        <td>imie</td>
        <td>nazwisko</td>
        <td>miasto</td>
        <td>ulica</td>
        <td>dom</td>
    </tr>
    <c:forEach var="o" items="${childList}">
        <tr>
            <td>${o.id}</td>
            <td>${o.imie}</td>
            <td>${o.nazwisko}</td>
            <td>${o.miejscowosc}</td>
            <td>${o.ulica}</td>
            <td>${o.dom}</td>
            <c:url var="urlDelete" scope="page" value="/zAction">
                <c:param name="idC" value="${o.id}"/>
                <c:param name="id" value="${id}"/>
                <c:param name="action" value="deleteChild"/>
            </c:url>
            <td>
                <a href="${urlDelete}"><input type="button" value="usun" class="deleteButton"/></a>
            </td>
        </tr>
    </c:forEach>
</table>
<form>
    <input type="hidden" value="${zajecia.id}" name="id"/>
    <input type="hidden" value="${pracownik.id}" name="idN"/>

    <input type="hidden" value="addChild" name="action"/>
    <label> dodaj ucznia do zajec(wpisz ID ucznia) </label>
    <input type="text" name="idC" size="20">
    <input type="submit" value="dodaj">
</form>

</body>
</html>
