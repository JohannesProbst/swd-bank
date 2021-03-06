<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Joey
  Date: 26.01.2015
  Time: 22:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Edit-Page</title>
</head>
<body>
<h1>Kunden bearbeiten</h1>
<jsp:useBean id="customer" scope="request" type="at.ac.fhsalzburg.swd.entities.CustomerEntity"/>
<form:form method="post" commandName="customer" action="${pageContext.request.contextPath}/customer/edit/${customer.customerId}">
    <div><form:hidden path="customerId" /></div>
    <table>
    <tbody>
    <tr>
      <td>Name:</td>
      <td><form:input path="customerName"/></td>
    </tr>
    <tr>
      <td>Adresse:</td>
      <td><form:input path="customerAddress"/></td>
    </tr>
    <tr>
      <td>PIN:</td>
      <td><form:input path="pin"/></td>
    </tr>
    <tr>
      <td>BankId:</td>
      <td><form:input path="bankId"/></td>
    </tr>
    <tr>
      <td><input type="submit" value="update" /></td>
    </tr>
    </tbody>
  </table>
</form:form>
<a href="${pageContext.request.contextPath}/">Startseite</a>
</body>
</html>
