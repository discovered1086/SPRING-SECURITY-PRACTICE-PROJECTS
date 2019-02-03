<%-- 
    Document   : errorPage
    Created on : 11 Jan, 2011, 10:06:42 AM
    Author     : Kingshuk
--%>

<%@page contentType="text/html" isErrorPage="true" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>welcome to kingshuk's portal</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/master_css.css">
</head>


<body>
<div id="allcontent">
    <%@include file="header.jsp" %>
    <div id="actual_content">
        <%@include file="cr_leftnav.jsp" %>
        <div id="content-body">
            <h2>System Unavailable</h2>
            <div class="error-message">
                <h4>
                    You're NOT authorized to view this page</h4>
            </div>
        </div>
    </div>
</body>
</html>
