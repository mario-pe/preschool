<%--
  Created by IntelliJ IDEA.
  User: mario
  Date: 31.05.2017
  Time: 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Psedskole</title>
</head>

<body>
<form action="/pEdit">
    <table>
        <tr>
            <td>${imie}</td>
            <td>imie</td>
            <td><input type="text" name="imie"/></td>
        </tr>
        <tr>
            <td>${nazwisko}</td>
            <td>nazwisko</td>
            <td><input type="text" name="nazwisko"/></td>
        </tr>
        <tr>
            <td>${data}</td>
            <td>data umowy</td>
            <td><input type="datetime" name="date"/></td>
        </tr>
        <tr>
            <td>${type}</td>
            <td>typ umowy</td>
            <td><input type="text" name="type"/></td>
        </tr>
    </table>
    <input type="hidden" value="${id}" name="id"/>
    <input type="submit" value="edytuj"/>
</form>
</body>
</html>
