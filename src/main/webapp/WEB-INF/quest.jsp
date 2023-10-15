<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Выбор</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <style type="text/css">
        #footer {
            position: fixed; /* Фиксированное положение */
            left: 0;
            bottom: 0; /* Левый нижний угол */
            padding: 10px; /* Поля вокруг текста */
            background: #7ba2cc; /* Цвет фона */
            color: #fff; /* Цвет текста */
            width: 100%; /* Ширина слоя */
        }
    </style>
</head>
<body>
<div class="container">
    <br>
    <div class="row">
        <div class="col-md-6">
            <H1>${sessionScope.question.title}</H1>
            <br>
            <p>${sessionScope.question.question}</p>
            <c:choose>
                <c:when test="${sessionScope.question.isEnd}">
                    <form action="quest" method="post" name="form">
                        <div class="button">
                            <input type="submit" class="btn btn-success" value="Начать сначала"
                                   formaction="<c:url value = 'quest?cmd=question' />">
                            <input type="submit" class="btn btn-warning" value="На главную страницу"
                                   formaction="<c:url value = 'quest?cmd=' />">
                        </div>
                    </form>
                </c:when>
                <c:otherwise>
                    <form action="quest" method="post" name="form">
                        <c:forEach var="answer" items="${sessionScope.answers}">
                            <p><input type="radio" name="nextQuestionId"
                                        value=${answer.nextQuestionId}>${answer.answer}
                            </p>
                        </c:forEach>
                        <div class="button">
                            <input type="submit" class="btn btn-primary"
                                   formaction="<c:url value = 'quest?cmd=question' />">
                        </div>
                    </form>
                </c:otherwise>
            </c:choose>
        </div>
        <div class="col-md">
            <br>
            <img src="images/${sessionScope.question.id}.jpg"/>
        </div>
    </div>

    <div id="footer">
        <div>Имя игрока - ${sessionScope.name}</div>
        <div>Колличество побед - ${sessionScope.qtyWin}</div>
        <div>Колличество проигранных игр - ${sessionScope.qtyLose}</div>
    </div>
</div>
</body>
</html>
