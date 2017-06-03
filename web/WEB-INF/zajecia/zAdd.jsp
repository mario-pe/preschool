<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mario
  Date: 02.06.2017
  Time: 18:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/zAdd">
    <table>
        <tr>

            <td>przedmiot</td>
            <td><input type="text" name="przedmiot"/></td>
        </tr>
        <tr>

            <td>godzina</td>
            <td><input type="text" name="godzina"/></td>
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