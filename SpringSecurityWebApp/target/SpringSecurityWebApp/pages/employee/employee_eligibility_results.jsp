<%@ page contentType="text/html;charset=UTF-8" %>
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
            <h3>The Servlet says....</h3>
            <p><c:out value="${theMessage}"/></p>
        </div>
    </div>
</div>
</body>
</html>