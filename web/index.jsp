<%--
  Created by IntelliJ IDEA.
  User: mario
  Date: 28.05.2017
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Psedskole</title>
</head>
<body>
Witaj w predzszkolu
Co chcesz zrobic?

<form action="/uczniowie">
    <input type="submit" value="uczniowie"/>
</form>
<form action="/grupa">
    <input type="submit" value="grupa"/>
</form>
<form action="/zajecia">
    <input type="submit" value="zajecia dodatkowe"/>
</form>
<form action="/pracownik">
    <input type="submit" value="pracownicy"/>
</form>
</body>
</html>
