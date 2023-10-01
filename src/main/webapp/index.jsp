<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Поиск сокровищ Ситхов</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1>Поиск сокровищ Ситхов</h1>
    <br>
    <div class="row">
        <div class="col-md-6">
            <h2>Пролог</h2>
            <br>
            <p style="text-indent: 40px">Времена были тяжелыми в галактике Звёздных войн. Войны разрывали планеты, а
                империи возвышались и падали.
                Но
                среди всего хаоса и беспорядка существовали легенды о древних сокровищах Ситхов, скрытых в самых
                отдаленных
                уголках космоса.</p>
            <p style="text-indent: 40px">Вы - отважный искатель приключений, решивший отправиться в поиски этих
                древних сокровищ. Ваш путь
                начинается
                с
                далекой планеты Эксилон, о которой ходят мрачные и таинственные легенды. Говорят, что здесь
                скрываются
                сокровища, способные изменить ход истории галактики.</p>
            <p style="text-indent: 40px">Ваш корабль приземляется на планете, и перед вами разверзается неизведанный
                мир. Следуйте вашей судьбе,
                исследуйте планету, сразитесь с опасностями и возможно, сможете найти сокровища Ситхов, которые
                многие
                считают
                утраченными. Но будьте осторожны - ваши решения определят исход вашего квеста и его последствия для
                галактики.</p>
            <h2>Начало истории</h2>
            <p>Вы - искатель приключений, оказавшийся в галактике Звёздных войн. Вам стало известно о сокровищах
                Ситхов,
                спрятанных
                на далекой планете Эксилон. Ваша задача - найти их. Путешествие начинается...</p>
            <form action="quest" method="post" name="form" role="form">
                <div class="form-group">
                    <div>
                        <label for="name" class="text-primary">Введите своё имя</label>
                    </div>
                    <input type="text" class="from-control" placeholder="Anakin Skywalker" name="name" id="name"/>
                </div>
                <div class="button">
                    <input type="submit" class="btn btn-primary" formaction="<c:url value = 'quest?cmd=question' />">
                </div>
            </form>
        </div>
        <div class="col-md">
            <br>
            <img src="images/index.jpg"/>
        </div>
    </div>
</div>
</body>
</html>