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
<h2>Herzlich Willkommen beim unserem neuen und hoch modernen<br/> Transaktionssystem</h2>
<h3>Wir freuen uns Sie begrüßen zu dürfen!</h3>
<p>Bitte authentifizieren Sie sich, dann kann es auch gleich los gehen!</p>

<c:if test="${not empty error}">
    <p class="message error">${error}<p>
</c:if>
<c:if test="${not empty message}">
    <p class="message success">${message}<p>
</c:if>

    <form method="post" action="${pageContext.request.contextPath}/transaction/start" >

        <table>
            <tbody>
            <tr>
                <td>Kunden-ID:</td>
                <td><input type="text" name="customerId" /></td>
            </tr>
            <tr>
                <td>Pin:</td>
                <td><input type="password" name="pin" /></td>
            </tr>
            <tr>
                <td>╰( ´・ω・)つ──☆✿✿✿✿✿✿</td>
                <td><input type="submit" value="Weiter" /></td>
            </tr>
            </tbody>
        </table>
    </form>

<p></p>


<p>
    <a href="${pageContext.request.contextPath}/">Startseite</a>
</p>

</body>
</html>
