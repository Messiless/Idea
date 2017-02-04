<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>所有部门列表</title>  
  </head>
  
  <body>
  	<form action="${pageContext.request.contextPath }/ListDeptServlet" method="post">
  	<table align="center" width="600px">
  		<tr>
  			<td> 
  			部门名称： <input type="text" size="8" name="deptName" value="${param['deptName'] }" />
  			负责人： <input type="text" size="8" name="principal" value="${param['principal'] }"/>
  			职能：<input type="text" size="10" name="functional" value="${param['functional'] }"/>
  			<input type="submit" value="搜索"/>
  			</td>
  		</tr>
  	</table>
  	</form>
    <table align="center" border="1" width="600px">
    	<tr>
    		<th>编号</th>
    		<th>部门名称</th>
    		<th>负责人</th>
    		<th>部门职能</th>
    	</tr>
    	<c:forEach items="${list}" var="dept">
    	<tr>
    		<td>${dept.id }</td>
    		<td>${dept.deptName }</td>
    		<td>${dept.principal }</td>
    		<td>${dept.functional }</td>
    	</tr>
    	</c:forEach>
    </table>
  </body>
</html>
