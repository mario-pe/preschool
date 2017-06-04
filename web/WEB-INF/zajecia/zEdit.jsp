<%--
  Created by IntelliJ IDEA.
  User: mario
  Date: 02.06.2017
  Time: 18:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PsedskoleSATANA</title>
</head>
<body>
${id}
<form action="/zEdit">
<table>
    <tr>
        <td>${przedmiot}</td>
        <td>przedmiot</td>
        <td><input type="text" name="przedmiot"/></td>
    </tr>
    <tr>
        <td>${godzina}</td>
        <td>godzina</td>
        <td><input type="text" name="godzina"/></td>
    </tr>
    <tr>
        <td>${rok}</td>
        <td>rok</td>
        <td><input type="text" name="rok"/></td>
    </tr>
    <tr>
        <td>${dzien}</td>
        <td>rok</td>
        <td><input type="text" name="dzien"/></td>
    </tr>

</table>
<input type="hidden" value="${id}" name="id"/>
<input type="submit" value="edytuj"/>
</form>

</body>
</html>
