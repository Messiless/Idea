<%--
  Created by IntelliJ IDEA.
  User: Computer
  Date: 2017/1/25
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

 <form action="/TargetServlet" method="post">
     用户名：<input type="text" name="userName" />${error}<br/>
     密码： <input type="password" name="password"/><br/>
     <input type="submit" value="登录"/>
 </form>
  </body>
</html>
