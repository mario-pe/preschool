<%--
  Created by IntelliJ IDEA.
  User: mario
  Date: 05.06.2017
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<title>Psedszkole</title>
</head>
<body>
<form action="/pAdd">
    <table>
        <tr>
            <td>imie</td>
            <td><input type="text" name="imie"/></td>
        </tr>
        <tr>
            <td>nazwisko</td>
            <td><input type="text" name="nazwisko"/></td>
        </tr>
        <tr>
            <td>data umowy</td>
            <td><input type="datetime" name="date"/> </td>
        </tr>
        <tr>
            <td>typ umowy</td>
            <td><input type="text" name="type"/> </td>
        </tr>
        <tr>
            <td>stopein zawodowy</td>
            <td><input type="text" name="stopien"/> </td>
        </tr>
        <tr>
            <td>przedmiot</td>
            <td><input type="text" name="przedmiot"/> </td>
        </tr>
    </table>
    <input type="hidden" value="nauczyciel" name="stanowisko"/>
    <input type="submit" value="dodaj"/>
</form>
</body>
</html>
</body>
</html>
