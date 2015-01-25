<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <title>Bank New-Page</title>
</head>
<body>
<h1>Eine neue Bank anlegen</h1>
<form:form method="post" commandName="bank" action="${pageContext.request.contextPath}/bank/create" >
  <table>
    <tbody>
    <tr>
      <td>Name:</td>
      <td><form:input path="bankName" /></td>
    </tr>
    <tr>
      <td>Adresse:</td>
      <td><form:input path="bankAddress" /></td>
    </tr>
    <tr>
      <td>BIC:</td>
      <td><form:input path="bankBic" /></td>
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
