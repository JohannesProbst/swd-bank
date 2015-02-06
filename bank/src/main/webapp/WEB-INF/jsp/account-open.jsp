<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Joey
  Date: 04.02.2015
  Time: 18:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Account Open-Page</title>
</head>
<body>
<h1>Ein Girokonto anlegen</h1>
<form:form method="post" commandName="account" action="${pageContext.request.contextPath}/open/checking" >
  <table>
    <tbody>
    <tr>
      <td>Kontobezeichnung:</td>
      <td><form:input path="accountDescription" /></td>
    </tr>
    <tr>
      <td>Kunden Id:</td>
      <td><form:input path="customerId" readonly="true" /></td>
    </tr>
    <tr>
      <td>IBAN:</td>
      <td><form:input path="accountIban" /></td>
    </tr>
    <tr>
      <td>Saldo:</td>
      <td><form:input path="accountSaldo" /></td>
    </tr>
    <tr>
      <td><input type="submit" value="open account" /></td>
    </tr>
    </tbody>
  </table>
</form:form>
<a href="${pageContext.request.contextPath}/">Startseite</a>
</body>
</html>
