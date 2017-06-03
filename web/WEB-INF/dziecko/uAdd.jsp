<%--
  Created by IntelliJ IDEA.
  User: mario
  Date: 30.05.2017
  Time: 08:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>przedszkole</title>
</head>
<body>
<h1>Dodaj przedszkolaka</h1>

<form action="/uAdd">
    <table>
        <tr>
            <td>imie</td>
            <td><input type="text" name="name"/> </td>
        </tr>
        <tr>
            <td>nazwisko</td>
            <td><input type="text" name="surname"/> </td>
        </tr>
        <tr>
            <td>miasto</td>
            <td><input type="text" name="city"/></td>
        </tr>
        <tr>
            <td>ulica</td>
            <td><input type="text" name="street"/></td>
        </tr>
        <tr>
            <td>Nr. domu</td>
            <td><input type="text" name="home"/></td>
        </tr>
    </table>
    <input type="hidden" value="child" name="type"/>
    <input type="submit" value="dodaj"/>
</form>

</body>
</html>
