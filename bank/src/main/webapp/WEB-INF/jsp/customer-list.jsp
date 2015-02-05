<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Joey
  Date: 26.01.2015
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List-Page</title>
</head>
<body>
<h1>Liste aller Kunden</h1>
<table style="text-align: center;" border="1px" cellpadding="0" cellspacing="0" >
  <thead>
  <tr>
    <th width="25px">ID</th><th width="150px">NAME</th><th width="25px">ADRESSE</th><th width="50px">PIN</th><th width="25px">BANK</th><th>AKTIONEN</th>
  </tr>
  </thead>
  <tbody>
  <jsp:useBean id="customerList" scope="request" type="java.util.List"/>
  <c:forEach var="customer" items="${customerList}">
    <tr>
      <td>${customer.customerId}</td>
      <td>${customer.customerName}</td>
      <td>${customer.customerAddress}</td>
      <td>${customer.pin}</td>
      <td>${customer.bankId}</td>
      <td>
        <a href="${pageContext.request.contextPath}/customer/edit/${customer.customerId}">bearbeiten</a><br/>
        <a href="${pageContext.request.contextPath}/customer/delete/${customer.customerId}">löschen</a><br/>
        <a href="${pageContext.request.contextPath}/customer/${customer.customerId}/account/list/">aktuelle Konten</a><br/>
        <a href="${pageContext.request.contextPath}/customer/${customer.customerId}/account/open/checking">Konto anlegen</a><br/>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<a href="${pageContext.request.contextPath}/">Startseite</a>
</body>
</html>
