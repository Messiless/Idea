<%--
  Created by IntelliJ IDEA.
  User: Computer
  Date: 2017/2/3
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>i18n time</title>
</head>
<body>
<jsp:useBean id="now" class="java.util.Date" scope="page"></jsp:useBean>
<fmt:formatDate value="${now}" dateStyle="full" timeStyle="full" type="both"></fmt:formatDate>
</body>
</html>
