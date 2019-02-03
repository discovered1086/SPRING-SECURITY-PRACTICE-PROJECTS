<%--
  Created by IntelliJ IDEA.
  User: kingshuk
  Date: 5/14/17
  Time: 7:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Registration Page</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/common_style.css">

</head>
<body>
<div id="allcontent">
    <%@include file="header.jsp" %>
    <div id="actual_content">
        <div id="content-body">
            <h3>You registration has been completed. Please
                <a href="${pageContext.request.contextPath}/requestToLogin">login here</a></h3>
        </div>
    </div>
</div>
</body>
</html>
