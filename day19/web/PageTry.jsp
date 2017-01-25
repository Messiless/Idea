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
<form action="/SelectServlet" >
    <table>
               <tr>
                   <th></th>
                   <th></th>
                   <th></th>
                   <th></th>
               </tr>
    </table>
</form>
<table align="center" border="1" width="800px" >
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

   <c:choose>
                <c:when test="${pageBean.checkPage==pageBean.firstPage}">
                    <a href="/ListServlet?checkPage=${pageBean.firstPage}&pageAvg=${pageBean.everyPage}">首页</a>&nbsp;
                    上一页
                </c:when>
                <c:otherwise>
                    <a href="/ListServlet?checkPage=${pageBean.firstPage}&pageAvg=${pageBean.everyPage}">首页</a>&nbsp;
                    <a href="/ListServlet?checkPage=${pageBean.beforePage}&pageAvg=${pageBean.everyPage}">上一页</a>&nbsp;
                </c:otherwise>
            </c:choose>
        <c:choose>
            <c:when test="${pageBean.checkPage==pageBean.lastPage}">
                下一页&nbsp;
                <a href="/ListServlet?checkPage=${pageBean.lastPage}&pageAvg=${pageBean.everyPage}">末页</a>&nbsp;
            </c:when>
            <c:otherwise>
                <a href="/ListServlet?checkPage=${pageBean.nextPage}&pageAvg=${pageBean.everyPage}">下一页</a>&nbsp;
                <a href="/ListServlet?checkPage=${pageBean.lastPage}&pageAvg=${pageBean.everyPage}">末页</a>&nbsp;
            </c:otherwise>
        </c:choose>
        当前页为${pageBean.checkPage}/共${pageBean.lastPage}
        &nbsp;每页显示<input type="text" id="pageAvg" size="2" value="${pageBean.everyPage}" onblur="changePageSize()"/>页
        &nbsp;跳转到第<input type="text" id="pageC" size="2"> 页&nbsp;<input type="submit" value="确定" onclick="change()">

    </th>
</tr>
</table>
</body>
<script type="text/javascript">
    function changePageSize() {
        var doc=document.getElementById("pageAvg").value;
        var reg=/^[0-9][0-9]?$/;
        if(!reg.test(doc)){
            alert("请输入1—2位数字");
            return;
        }
        var url="${pageContext.request.contextPath}/ListServlet?pageAvg="+doc;
        window.location.href=url;
    }
    function change() {
        var do1=document.getElementById("pageC").value;
        var reg=/^[0-9][0-9]?$/;
        if(!reg.test(do1)){
            alert("请输入1—2位数字");
            return;
        }
        var totalPage = "${pageBean.lastPage}";
        if(do1>totalPage){
            alert("超过最大页数")
            return;
        }
        var url="${pageContext.request.contextPath}/ListServlet?checkPage="+do1+"&pageAvg=${pageBean.everyPage}";
        window.location.href=url;
    }
</script>
</html>