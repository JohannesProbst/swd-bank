<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Joey
  Date: 05.02.2015
  Time: 01:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Account List-Page</title>
</head>
<body>
<h1>Liste aller Konten des ausgewählten Kunden</h1>
<table style="text-align: center;" border="1px" cellpadding="0" cellspacing="0" >
  <thead>
  <tr>
    <th>ID</th><th>BESCHREIBUNG</th><th>KUNDEN_ID</th><th>IBAN</th><th>SALDO</th><th colspan="2">Letzter Kontoauszug</th><th>AKTIONEN</th>
  </tr>
  </thead>
  <tbody>
  <jsp:useBean id="accountList" scope="request" type="java.util.List"/>
  <c:forEach var="account" items="${accountList}">
    <tr>
      <td>${account.accountId}</td>
      <td>${account.accountDescription}</td>
      <td>${account.customerId}</td>
      <td>${account.accountIban}</td>
      <td>${account.accountSaldo}</td>
        <td>${account.accountStatement}</td>
        <td>${account.accountStatementDate}</td>
      <td>
        <a href="${pageContext.request.contextPath}/account/edit/${account.accountId}">bearbeiten</a><br/>
        <a href="${pageContext.request.contextPath}/account/delete/${account.accountId}">löschen</a><br/>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<a href="${pageContext.request.contextPath}/">Startseite</a>
</body>
</html>
