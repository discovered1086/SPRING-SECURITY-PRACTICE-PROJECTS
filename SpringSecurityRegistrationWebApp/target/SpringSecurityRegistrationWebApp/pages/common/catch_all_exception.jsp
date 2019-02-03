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
    <%@include file="/pages/common/header.jsp" %>
    <div id="actual_content">
        <%@include file="/pages/common/cr_leftnav.jsp" %>
        <div id="content-body">
            <h2>System Unavailable</h2>
            <div id="demo-notes">
                <h4>
                    This error page is a generic error page that's thrown for all exceptions<br>
                    Cause: ${pageContext.exception.message}
                    kindly navigate to the <a href="javascript:history.go(-1)">previous page</a></h4>
            </div>
        </div>
    </div>
</body>
</html>
