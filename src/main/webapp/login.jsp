<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<%
    if(null!=request.getAttribute("errorMessage"))
    {
        out.println(request.getAttribute("errorMessage"));
    }
%>
<br>
<br>
<br>
<form action="check" method="post">
emailid :<input type="text" name="email"/><br>
password :<input type="password" name="pass"/><br>
<input type="submit" value="login"/><br>
</form>
</body>
</html>