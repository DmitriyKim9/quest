<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Поиск сокровищ Ситхов</title>
</head>
<body>
<h1><%= "Поиск сокровищ Ситхов" %>
</h1>
<p>Вы - искатель приключений, оказавшийся в галактике Звёздных войн. Вам стало известно о сокровищах Ситхов, спрятанных
    на далекой планете Эксилон. Ваша задача - найти их. Путешествие начинается...</p>
<p>Назовите своё имя</p>
<form action="quest" method="post" name="form">
    <div class="input-box">
        <input
                type="text"
                placeholder="Anakin Skywalker"
                name="name"
                id="name"
        />
        <label for="name"></label>
    </div>
    <div class="button">
        <input type="submit" formaction="<c:url value = 'quest?cmd=' />">
    </div>
</form>
</body>
</html>