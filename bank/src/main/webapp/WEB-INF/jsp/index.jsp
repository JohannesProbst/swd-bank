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
</head>
<body>
<h1>Bank XY</h1>
<p>
  <h2>Herzlich Willkommen bei der Bank ihres Vertrauens.</h2>
  <i>${message}</i><br/>
  <a href="${pageContext.request.contextPath}/bank/create">Eine neue Bank anlegen</a><br/>
  <a href="${pageContext.request.contextPath}/bank/list">Alle Banken anzeigen</a><br/>
</p>
</body>
</html>
