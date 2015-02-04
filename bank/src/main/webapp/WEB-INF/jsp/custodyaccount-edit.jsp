<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: WuM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CustodyAccount Edit-Page</title>
</head>
<body>
<h1>Wertpapier Depot bearbeiten</h1>
<jsp:useBean id="custodyAccount" scope="request" type="at.ac.fhsalzburg.swd.entities.CustodyAccountEntity"/>
<form:form method="post" commandName="custodyAccount"
           action="${pageContext.request.contextPath}/custodyaccount/edit/${custodyAccount.accountId}">
    <div><form:hidden path="accountId"/></div>
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
            <td><input type="submit" value="update"/></td>
        </tr>
        </tbody>
    </table>
</form:form>
<a href="${pageContext.request.contextPath}/">Startseite</a>
</body>
</html>
