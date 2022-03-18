<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %></h1>
<br/>
<%--以路径名称开头的相对路径 其参照路径都是当前访问路径的资源路径 即：http://localhost:8080/myWeb/--%>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>