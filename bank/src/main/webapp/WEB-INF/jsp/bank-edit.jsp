<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Joey
  Date: 25.01.2015
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bank Edit-Page</title>
</head>
<body>
<h1>Bank bearbeiten</h1>
<jsp:useBean id="bank" scope="request" type="at.ac.fhsalzburg.swd.entities.BankEntity"/>
<form:form method="post" commandName="bank" action="${pageContext.request.contextPath}/bank/edit/${bank.bankId}">
    <div><form:hidden path="bankId" /></div>
    <table>
        <tbody>
        <tr>
            <td>Name:</td>
            <td><form:input path="bankName"/></td>
        </tr>
        <tr>
            <td>Adresse:</td>
            <td><form:input path="bankAddress"/></td>
        </tr>
        <tr>
            <td>BIC:</td>
            <td><form:input path="bankBic"/></td>
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
