<%--
  Created by IntelliJ IDEA.
  User: mario
  Date: 29.05.2017
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>przedszkole</title>
</head>
<body>
<p>${id}</p>
<form action="/uEdit">
    <table>
        <tr>
            <td>${imie}</td>
            <td>imie</td>
            <td><input type="text" name="name"/></td>
        </tr>
        <tr>
            <td>${nazwisko}</td>
            <td>nazwisko</td>
            <td><input type="text" name="surname"/></td>
        </tr>
        <tr>
            <td>${miejscowosc}</td>
            <td>miejscowosc</td>
            <td><input type="text" name="city"/></td>
        </tr>
        <tr>
            <td>${ulica}</td>
            <td>ulica</td>
            <td><input type="text" name="street"/></td>
        </tr>
        <tr>
            <td>${dom}</td>
            <td>dom</td>
            <td><input type="text" name="home"/></td>
        </tr>

    </table>
    <input type="hidden" value="${id}" name="id"/>
    <input type="submit" value="edytuj"/>
</form>
</body>
</html>
