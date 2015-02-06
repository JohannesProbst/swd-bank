<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Bankomat</title>
    <link href="<c:url value='/'/>assets/css/main.css" rel="stylesheet" media="screen" />
</head>
<body>
<h1>Bank XY</h1>
<p>
<h2>Herzlich Willkommen ${customer.getCustomerName()} ᕙ (;｀⊥ ＾★)┐!</h2>

<c:if test="${not empty error}">
<p class="message error">${error}<p>
    </c:if>
    <c:if test="${not empty message}">
<p class="message success">${message}<p>
    </c:if>

<h3>Girokonten:</h3>
<table class="account-table checking">
    <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>IBAN</th>
            <th>Saldo</th>
        </tr>
    </thead>
    <tbody>
        <c:if test="${not empty checkingAccounts}">
            <c:forEach var="account" items="${checkingAccounts}">
                <tr>
                    <td>${account.getAccountId()}</td>
                    <td>${account.getAccountDescription()}</td>
                    <td>${account.getAccountIban()}</td>
                    <td class="highlight">${account.getAccountSaldo()}</td>
                </tr>
            </c:forEach>
        </c:if>
        <c:if test="${empty checkingAccounts}">
            <tr><td colspan="3">keine Accounts</td><td class="highlight">&nbsp;</td></tr>
        </c:if>
    </tbody>
</table>

<h3>Sparkonten:</h3>
<table class="account-table savings">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>IBAN</th>
        <th>Saldo</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${not empty savingsAccounts}">
        <c:forEach var="account" items="${savingsAccounts}">
            <tr>
                <td>${account.getAccountId()}</td>
                <td>${account.getAccountDescription()}</td>
                <td>${account.getAccountIban()}</td>
                <td class="highlight">${account.getAccountSaldo()}</td>
            </tr>
        </c:forEach>
    </c:if>
    <c:if test="${empty savingsAccounts}">
        <tr><td colspan="3">keine Accounts</td><td class="highlight">&nbsp;</td></tr>
    </c:if>
    </tbody>
</table>

<h3>Aktiendepots:</h3>
<table class="account-table custody">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>IBAN</th>
        <th>Saldo</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${not empty custodyAccounts}">
        <c:forEach var="account" items="${custodyAccounts}">
            <tr>
                <td>${account.getAccountId()}</td>
                <td>${account.getAccountDescription()}</td>
                <td>${account.getAccountIban()}</td>
                <td class="highlight">${account.getAccountSaldo()}</td>
            </tr>
        </c:forEach>
    </c:if>
    <c:if test="${empty custodyAccounts}">
        <tr><td colspan="3">keine Accounts</td><td class="highlight">&nbsp;</td></tr>
    </c:if>
    </tbody>
</table>

<h3>Wählen Sie eine gewünschte Transaktion:</h3>
<p>Hier können Sie gewünschte Transaktionen für ihre Bankkonten durchführen</p>
<form method="post" action="${pageContext.request.contextPath}/transaction/deposit" >

    <h2>Geld einzahlen:</h2>
    <input type="hidden" name="customerId" value="${customer.getCustomerId()}" />
    <input type="hidden" name="pin" value="${customer.getPin()}" />

    <table class="transaction-table">
        <thead>
            <tr>
                <th>Betrag</th>
                <th>Konto</th>
                <th>&nbsp;</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td><input type="text" name="amount" /></td>
                <td>
                    <select name="accountId">
                        <c:forEach var="account" items="${checkingAccounts}">
                            <option class="checking" value="${account.getAccountId()}">${account.getAccountId()}: ${account.getAccountDescription()}</option>
                        </c:forEach>
                        <c:forEach var="account" items="${savingsAccounts}">
                            <option class="savings" value="${account.getAccountId()}">${account.getAccountId()}: ${account.getAccountDescription()}</option>
                        </c:forEach>
                        <c:forEach var="account" items="${custodyAccounts}">
                            <option class="custody" value="${account.getAccountId()}">${account.getAccountId()}: ${account.getAccountDescription()}</option>
                        </c:forEach>
                    </select>
                </td>
                <td><input type="submit" value="Durchführen" /></td>
            </tr>

        </tbody>
    </table>
</form>

<form method="post" action="${pageContext.request.contextPath}/transaction/withdraw" >

    <h2>Geld abheben:</h2>
    <input type="hidden" name="customerId" value="${customer.getCustomerId()}" />
    <input type="hidden" name="pin" value="${customer.getPin()}" />

    <table class="transaction-table">
        <thead>
        <tr>
            <th>Betrag</th>
            <th>Konto</th>
            <th>&nbsp;</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td><input type="text" name="amount" /></td>
            <td>
                <select name="accountId">
                    <c:forEach var="account" items="${checkingAccounts}">
                        <option class="checking" value="${account.getAccountId()}">${account.getAccountId()}: ${account.getAccountDescription()}</option>
                    </c:forEach>
                    <c:forEach var="account" items="${savingsAccounts}">
                        <option class="savings" value="${account.getAccountId()}">${account.getAccountId()}: ${account.getAccountDescription()}</option>
                    </c:forEach>
                    <c:forEach var="account" items="${custodyAccounts}">
                        <option class="custody" value="${account.getAccountId()}">${account.getAccountId()}: ${account.getAccountDescription()}</option>
                    </c:forEach>
                </select>
            </td>
            <td><input type="submit" value="Durchführen" /></td>
        </tr>

        </tbody>
    </table>
</form>


<form method="post" action="${pageContext.request.contextPath}/transaction/transfer" >

    <h2>Geld überweisen:</h2>
    <input type="hidden" name="customerId" value="${customer.getCustomerId()}" />
    <input type="hidden" name="pin" value="${customer.getPin()}" />

    <table class="transaction-table">
        <thead>
        <tr>
            <th>Betrag</th>
            <th>Konto</th>
        </tr>
        </thead>
        <tbody>
            <tr>
                <td><input type="text" name="amount" /></td>
                <td>
                    <select name="accountId">
                        <c:forEach var="account" items="${checkingAccounts}">
                            <option class="checking" value="${account.getAccountId()}">${account.getAccountId()}: ${account.getAccountDescription()}</option>
                        </c:forEach>
                        <c:forEach var="account" items="${savingsAccounts}">
                            <option class="savings" value="${account.getAccountId()}">${account.getAccountId()}: ${account.getAccountDescription()}</option>
                        </c:forEach>
                        <c:forEach var="account" items="${custodyAccounts}">
                            <option class="custody" value="${account.getAccountId()}">${account.getAccountId()}: ${account.getAccountDescription()}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>BIC</th>
                <th>IBAN</th>
            </tr>
            <tr>
                <td><input name="bic" type="text" value="" />
                <td><input name="iban" type="text" value="" /></td>
            </tr>
            <tr><td colspan="2"><input type="submit" value="Durchführen" /></td></tr>
        </tbody>
    </table>




</form>

<p>
    <a href="${pageContext.request.contextPath}/">Startseite</a>
</p>

</body>
</html>
