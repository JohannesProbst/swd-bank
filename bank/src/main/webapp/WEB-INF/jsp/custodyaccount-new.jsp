<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: WuM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CustodyAccount New-Page</title>
</head>
<body>
<h1>Wertpapier Depot anlegen</h1>
<form:form method="post" commandName="custodyAccount" action="${pageContext.request.contextPath}/custodyaccount/create">
    <table>
    <tbody>
    <tr>
        <td>Kunden ID:</td>
        <td><form:input path="customerId"/></td>
    </tr>
    <tr>
      <td>zugeordnetes Verrechnungskonto:</td>
      <td><form:input path="cheAccountId"/></td>
    </tr>
    <tr>
      <td>Beschreibung:</td>
      <td><form:input path="accountDescription"/></td>
    </tr>
    <tr>
      <td>IBAN:</td>
      <td><form:input path="accountIban"/></td>
    </tr>
    <tr>
        <td>Saldo:</td>
        <td><form:input path="accountSaldo"/></td>
    </tr>
    <tr>
      <td><input type="submit" value="create" /></td>
    </tr>
    </tbody>
  </table>
</form:form>
<a href="${pageContext.request.contextPath}/">Startseite</a>
</body>
</html>
