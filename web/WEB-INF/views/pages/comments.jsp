<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
<head>

    <title>Comments</title>
    <style>
        <%@include file="/resources/css/comments_style.css"%>
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script type="text/javascript">
        <%@include file="/resources/js/app.js"%>
    </script>

</head>
<body>

<h1>Комментарии</h1>

<div class="comment_text">
<form:form method="POST" action="save">
    <div class="field">
    <form:label path="name" cssClass="field-label">Ваше имя</form:label>
    <form:input path="name" cssClass="field-input"/>
    </div>

    <div class="field">
    <form:label path="descr" cssClass="field-label">Отзыв</form:label>
    <form:input path="descr" cssClass="field-input"/>
    </div>

    <div class="send_form">
    <input type="submit" class="send_msg" value="Отправить"/>
    </div>


</form:form>




    <c:forEach var="user" items="${list}">
        <br/>
        <br/>
        <output class="comment_name">${user.name}</output>
        <br/>
        <br/>
        <output class="comment_descr">${user.descr}</output>
        <br/>
        <hr/>
    </c:forEach>
    </div>


</body>
</html>

