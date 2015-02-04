<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: WuM
  Date: 03.02.2015
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CustodyAccount List-Page</title>
</head>
<body>
<h1>Liste aller Wertpapier Depots (CustodyAccounts)</h1>
<table style="text-align: center;" border="1px" cellpadding="0" cellspacing="0" >
  <thead>
  <tr>
    <th width="25px">ID</th>
    <th width="150px">customerId</th>
    <th width="25px">CheckingAccount</th>
    <th width="50px">Description</th>
    <th>IBAN</th>
    <th>Saldo</th>
    <th>Auszug</th>
    <th>Datum Auszug</th>
  </tr>
  </thead>
  <tbody>
  <jsp:useBean id="custodyAccountList" scope="request" type="java.util.List"/>
  <c:forEach var="custodyAccount" items="${custodyAccountList}">
    <tr>
      <td>${custodyAccount.accountId}</td>
      <td>${custodyAccount.customerId}</td>
      <td>${custodyAccount.cheAccountId}</td>
      <td>${custodyAccount.accountDescription}</td>
      <td>${custodyAccount.accountIban}</td>
      <td>${custodyAccount.accountSaldo}</td>
      <td>${custodyAccount.accountStatement}</td>
      <td>${custodyAccount.accountStatementDate}</td>
      <td>
        <a href="${pageContext.request.contextPath}/custodyaccount/edit/${custodyAccount.accountId}">bearbeiten</a><br/>
        <a href="${pageContext.request.contextPath}/custodyaccount/delete/${custodyAccount.accountId}">löschen</a><br/>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<a href="${pageContext.request.contextPath}/">Startseite</a>
</body>
</html>
