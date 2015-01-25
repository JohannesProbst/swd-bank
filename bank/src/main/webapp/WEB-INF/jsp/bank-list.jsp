<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Joey
  Date: 25.01.2015
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bank List-Page</title>
</head>
<body>
<h1>Liste aller Banken</h1>
<table style="text-align: center;" border="1px" cellpadding="0" cellspacing="0" >
  <thead>
  <tr>
    <th width="25px">ID</th><th width="150px">NAME</th><th width="25px">ADRESSE</th><th width="50px">BIC</th><th>AKTIONEN</th>
  </tr>
  </thead>
  <tbody>
  <jsp:useBean id="bankList" scope="request" type="java.util.List"/>
  <c:forEach var="bank" items="${bankList}">
    <tr>
      <td>${bank.bankId}</td>
      <td>${bank.bankName}</td>
      <td>${bank.bankAddress}</td>
      <td>${bank.bankBic}</td>
      <td>
        <a href="${pageContext.request.contextPath}/bank/edit/${bank.bankId}">bearbeiten</a><br/>
        <a href="${pageContext.request.contextPath}/bank/delete/${bank.bankId}">löschen</a><br/>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<a href="${pageContext.request.contextPath}/">Startseite</a>
</body>
</html>
