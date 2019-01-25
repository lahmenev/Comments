<!-- обратите внимание на spring тэги -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
  <title>Index Page</title>
</head>

<body>
<spring:form method="post"  modelAttribute="user" action="check-user">

  Name: <spring:input path="name"/> (path="" - указывает путь, используемый в modelAttribute=''. в нашем случае User.name)  <br/>

  <spring:button>Next Page</spring:button>

</spring:form>

</body>

</html>
