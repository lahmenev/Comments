<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title><tiles:insertAttribute name="title" ignore="true" /></title>
    <style>
        <%@include file="/resources/css/main_style.css"%>
    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<header>
    <tiles:insertAttribute name="header" />
</header>
    <tiles:insertAttribute name="body"/>

</body>
</html>
