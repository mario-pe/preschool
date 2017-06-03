<%--
  Created by IntelliJ IDEA.
  User: mario
  Date: 30.05.2017
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Psedskole</title>
</head>
<body>
<form action="/gAdd">
    <table>
        <tr>

            <td>kat</td>
            <td><input type="text" name="kat"/></td>
        </tr>
        <tr>

            <td>sala</td>
            <td><input type="text" name="sala"/></td>
        </tr>
        <tr>

            <td>rok</td>
            <td><input type="text" name="rok"/></td>
        </tr>

    </table>
    <input type="submit" value="dodaj"/>
</form>
</body>
</html>
