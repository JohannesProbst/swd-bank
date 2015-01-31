<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Joey
  Date: 26.01.2015
  Time: 22:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer New-Page</title>
</head>
<body>
<h1>Einen neuen Kunden anlegen</h1>
<form:form method="post" commandName="customer" action="${pageContext.request.contextPath}/customer/create" >
  <table>
    <tbody>
    <tr>
      <td>Name:</td>
      <td><form:input path="customerName" /></td>
    </tr>
    <tr>
      <td>Adresse:</td>
      <td><form:input path="customerAddress" /></td>
    </tr>
    <tr>
      <td>PIN:</td>
      <td><form:input path="pin" /></td>
    </tr>
    <tr>
      <td>BankId:</td>

      <td>

          <form:select path="bankId" items="${bankList}" itemValue="bankId" itemLabel="bankName" name="select"/>

      </td>
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
