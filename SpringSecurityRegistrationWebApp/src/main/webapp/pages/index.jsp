<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>User login</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/master_css.css">
    <!--<script type="text/javascript" src="../../scripts/common.js"></script>-->


</head>
<body>
<div id="allcontent">
    <%--<%@include file="common/header.jsp" %> --%>
    <jsp:directive.include file="common/header.jsp"/>
    <div id="actual_content">
        <%@include file="common/cr_leftnav.jsp" %>
        <div id="content-body">
            <h3>Welcome</h3>
            <p>Welcome to the Spring Application Security practice
                <%--<security:authentication property="principal.username" />&nbsp;
                <security:authentication property="principal.authorities" />--%>
            </p>
        </div>
    </div>
</div>
</body>
</html>