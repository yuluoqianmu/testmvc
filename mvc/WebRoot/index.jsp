<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML>
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  <body>
    <form action="<%=request.getContextPath()%>/test.do" method="post">
    name:<input type="text" name="name"><br>
    password:<input type="text" name="password"><br>
    	<input type="submit">
    </form>
  </body>
</html>
