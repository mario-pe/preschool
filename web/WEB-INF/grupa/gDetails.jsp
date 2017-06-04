<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mario
  Date: 04.06.2017
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PsedskoleSATANA</title>
</head>
<body>
<h1>Szcególy doptyczace grupy</h1>
<h1> Nauczyciele</h1>
<table border="1">
    <tr>
        <td>imie</td>
        <td>nazwisko</td>
    </tr>

    <c:forEach var="o" items="${nauczycielList}">
        <tr>
            <td>${o.imie}</td>
            <td>${o.nazwisko}</td>
        </tr>
    </c:forEach>

</table>

<h1> Opiekunowie</h1>
<table border="1">
    <tr>
        <td>imie</td>
        <td>nazwisko</td>
    </tr>

    <c:forEach var="o" items="${opiekunList}">
        <tr>
            <td>${o.imie}</td>
            <td>${o.nazwisko}</td>
        </tr>
    </c:forEach>

</table border="1">
<h1> osoba odpowiaedzialna za pożadek</h1>
 ${sprzataczka.imie} ${sprzataczka.nazwisko}


<h2>lista dzieci</h2>
<table>
    <tr>
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
            <c:url var="urlDelete" scope="page" value="/gAction">
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
</body>
</html>
