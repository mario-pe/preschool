<%--
  Created by IntelliJ IDEA.
  User: mario
  Date: 02.06.2017
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Przedszkole</title>
</head>
<body>
/przesład id dziecka
<p>Opiekun dla dziecka o indekise ${id}</p>
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
    <input type="hidden" value="keeper" name="type"/>
    <input type="hidden" value="${id}" name="id"/>
    <input type="submit" value="dodaj"/>
</form>

</body>
</html>
