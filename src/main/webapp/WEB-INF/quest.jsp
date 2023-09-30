<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Question</title>
</head>
<body>
<H1>${sessionScope.question.title}</H1>
<p>${sessionScope.question.question}</p>
<c:choose>
    <c:when test="${sessionScope.question.isEnd}">
        <form action="quest" method="post" name="form">
            <div class="button">
                <input type="submit" value="Начать сначало" formaction="<c:url value = 'quest?cmd=question' />">
                <input type="submit" value="На главную страницу" formaction="<c:url value = 'quest?cmd=' />">
            </div>
        </form>
    </c:when>
    <c:otherwise>
        <form action="quest" method="post" name="form">
            <c:forEach var="answer" items="${sessionScope.answers}">
                <p><input name="nextQuestionId" type="radio" value=${answer.nextQuestionId}>${answer.answer}</p>
            </c:forEach>
            <div class="button">
                <input type="submit" formaction="<c:url value = 'quest?cmd=question' />">
            </div>
        </form>
    </c:otherwise>
</c:choose>
</body>
</html>
