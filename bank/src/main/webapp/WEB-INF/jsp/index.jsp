<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Joey
  Date: 25.01.2015
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Bank Index-Page</title>
  <link href="<c:url value='/'/>assets/css/main.css" rel="stylesheet" media="screen" />
</head>
<body>
<h1>Bank XY</h1>
<p>
  <h2>Herzlich Willkommen bei der Bank ihres Vertrauens.</h2>

    <c:if test="${not empty error}">
        <p class="message error">${error}<p>
    </c:if>
    <c:if test="${not empty message}">
        <p class="message success">${message}<p>
    </c:if>

  <a href="${pageContext.request.contextPath}/bank/create">Eine neue Bank anlegen</a><br/>
  <a href="${pageContext.request.contextPath}/bank/list">Alle Banken anzeigen</a><br/>
  <br>
  <a href="${pageContext.request.contextPath}/customer/create">Einen neuen Kunden anlegen</a><br/>
  <a href="${pageContext.request.contextPath}/customer/list">Alle Kunden anzeigen</a><br/>
</p>

<p>
    <a href="${pageContext.request.contextPath}/cash-dispenser">Bankomat</a>
</p>
</body>
</html>
