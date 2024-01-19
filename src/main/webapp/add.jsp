
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>ADD User page</title>
</head>
<body>
    <sf:form method="post" action="/save" modelAttribute="user">
        <sf:input path="name"/><br>
        <sf:input path="age"/><br>
        <input type="submit" value="Save">
    </sf:form>
</body>
</html>
