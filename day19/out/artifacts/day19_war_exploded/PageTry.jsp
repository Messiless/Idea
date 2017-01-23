<%--
  Created by IntelliJ IDEA.
  User: Computer
  Date: 2017/1/22
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>it is a try</title>
</head>
<body>
<table align="center" border="1" width="700px">
<tr>
    <th>编号</th>
    <th>姓名</th>
    <th>年龄</th>
    <th>职位</th>
    <th>邮箱</th>
    <th>工资</th>
    </tr>
    <c:forEach items="${pageBean.list}" var="f">
    <tr>
        <th>${f.id}</th>
        <th>${f.name}</th>
        <th>${f.gender}</th>
        <th>${f.title}</th>
        <th>${f.email}</th>
        <th>${f.salary}</th>
    </tr>
    </c:forEach>
<tr>
    <th align="center" colspan="6">
        <!-- 类似FirstPage第一个字母要小写 -->
       <a href="/ListServlet?checkPage=${pageBean.firstPage}">首页</a>${pageBean.firstPage}&nbsp; <a href="/ListServlet?checkPage=${pageBean.beforePage}">上一页</a> ${pageBean.beforePage}&nbsp;<a href="/ListServlet?checkPage=${pageBean.nextPage}">下一页</a> ${pageBean.nextPage}&nbsp;
        <a href="/ListServlet?checkPage=${pageBean.lastPage}">末页</a>  ${pageBean.lastPage}&nbsp;当前页为${pageBean.checkPage}/共${pageBean.lastPage}&nbsp;一共有${pageBean.countPage}条信息 &nbsp;每页有${pageBean.everyPage}条信息

    </th>
</tr>
</table>
</body>
</html>
