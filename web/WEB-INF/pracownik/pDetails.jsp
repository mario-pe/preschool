<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mario
  Date: 05.06.2017
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>WesołePrzedszkole</title>
</head>
<body>
<h1>Szczegóły dotyczace pracownika</h1>

ID:${pracownik.id} <br>imie: ${pracownik.imie}<br> nazwisko: ${pracownik.nazwisko}<br> stanowisko: ${pracownik.stanowisko}
<%--<c:if test="${pracownik.stanowisko == 'nauczyciel'}"> ${pracownik.stopien} ${pracownik.przedmiot} </c:if>--%>
<%--<c:if test="${pracownik.stanowisko == 'opiekunka'}"> ${pracownik.specjalnosc} </c:if>--%>
<%--<c:if test="${pracownik.stanowisko == 'kucharka'}"> badania wazne do ${element} </c:if>--%>
<%--<c:if test="${pracownik.stanowisko == 'sprzataczka'}"> miejsce pracy, grupa: ${element} </c:if>--%>
<br>
<c:choose>
    <c:when test="${pracownik.stanowisko == 'nauczyciel'}">
       stopien zawodowy : ${pracownik.stopien}<br>
       przedmiot: ${pracownik.przedmiot}
        <br>
    </c:when>
    <c:when  test="${pracownik.stanowisko == 'opiekunka'}">
       <p>specjalnosc: </p> ${pracownik.specjalnosc}
        <br>
    </c:when>
    <c:when test="${pracownik.stanowisko == 'kucharka'}">
        badania wazne do: ${element}
        <br>
    </c:when>
    <c:when test="${pracownik.stanowisko == 'sprzataczka'}">
        miejsce pracy, grupa: ${element}
        <br>
    </c:when>
    <c:otherwise>
        pizzas.
        <br>
    </c:otherwise>
</c:choose>




<h3>Grupy powiazane</h3>
<br>
<table>
    <tr>
        <td>id</td>
        <td>kat</td>
        <td>sala</td>
        <td>rok</td>

    </tr>
    <c:forEach var="grupa" items="${grupas}">
        <tr>
            <td>${grupa.id}</td>
            <td>${grupa.kat}</td>
            <td>${grupa.sala}</td>
            <td>${grupa.rok}</td>
        </tr>
    </c:forEach>
</table>
<br>
<h3>Zajecia prowadzone przez nauczyciela</h3>
<table>
    <tr>
        <td>id</td>
        <td>przedmiot</td>
        <td>godzina</td>
        <td>rok</td>
    </tr>
    <c:forEach var="grupa" items="${zajecias}">
        <tr>
            <td>${grupa.id}</td>
            <td>${grupa.przedmiot}</td>
            <td>${grupa.godzina}</td>
            <td>${grupa.rok}</td>
            <td>${grupa.dzien}</td>
        </tr>
    </c:forEach>


</table>


</body>
</html>
