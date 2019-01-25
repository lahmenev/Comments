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
    <form:form method="POST" action="send">
        <div class="field">
            <form:label path="userName" cssClass="field-label">Ваше имя</form:label>
            <form:input path="userName" cssClass="field-input"/>
        </div>

        <div class="field">
            <form:label path="email" cssClass="field-label">Email</form:label>
            <form:input path="email" cssClass="field-input"/>
        </div>

        <div class="field">
            <form:label path="phoneNumber" cssClass="field-label">Телефон</form:label>
            <form:input path="phoneNumber" cssClass="field-input"/>
        </div>

        <div class="field">
            <form:label path="text" cssClass="field-label">Текст письма</form:label>
            <form:input path="text" cssClass="field-input"/>
        </div>

        <div class="send_form">
            <input type="submit" class="send_msg" value="Отправить"/>
        </div>


    </form:form>





</div>


</body>
</html>

