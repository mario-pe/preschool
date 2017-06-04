<%--
  Created by IntelliJ IDEA.
  User: mario
  Date: 30.05.2017
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>WesołePrzedszkole</title>
</head>
<body>
<form action="/gEdit">
    <table>
        <tr>
            <td>${kat}</td>
            <td>kat</td>
            <td><input type="text" name="kat"/></td>
        </tr>
        <tr>
            <td>${sala}</td>
            <td>sala</td>
            <td><input type="text" name="sala"/></td>
        </tr>
        <tr>
            <td>${rok}</td>
            <td>rok</td>
            <td><input type="text" name="rok"/></td>
        </tr>

    </table>
    <input type="hidden" value="${id}" name="id"/>
    <input type="submit" value="edytuj"/>
</form>
</body>
</html>
