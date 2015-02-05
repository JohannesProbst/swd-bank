<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Account Open-Page</title>
</head>
<body>
<h1>Ein neues Sparkonto anlegen</h1>

<form:form method="post" commandName="savings" action="${pageContext.request.contextPath}/open/savings" >
    <table>
        <tbody>
        <tr>
            <td>Girokonto:</td>
            <td><form:select path="cheAccountId" items="${checkingAccounts}"></form:select></td>
        </tr>
        <tr>
            <td>Kontobezeichnung:</td>
            <td><form:input path="accountDescription" /></td>
        </tr>
        <tr>
            <td>Kunden Id:</td>
            <td><form:input path="customerId" /></td>
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
