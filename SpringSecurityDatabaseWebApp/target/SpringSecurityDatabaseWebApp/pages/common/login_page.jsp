<%--
  Created by IntelliJ IDEA.
  User: kingshuk
  Date: 7/4/17
  Time: 12:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Login to the application</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/common_style.css">
</head>
<body>
<div id="allcontent">
    <div id="actual_content">
        <div id="content-body">
            <form:form name="thisForm" method="post" action="${pageContext.request.contextPath}/performLogin">

                <table class="tableinfo">
                    <th colspan="2">Login Information</th>
                    <c:choose>
                        <c:when test="${param.error ne null}" >
                            <tr>
                                <td colspan="2">

                                    <div class="error-message">
                                        <p>Invalid username/password.</p>
                                    </div>

                                </td>
                            </tr>
                        </c:when>
                        <c:when test="${param.logout ne null}" >
                            <tr>
                                <td colspan="2">

                                    <div class="success-message">
                                        <p>You have been successfully logged out.</p>
                                    </div>

                                </td>
                            </tr>
                        </c:when>
                    </c:choose>
                    <tr>
                        <td>User ID</td>
                        <td align="left">
                            <input type="text" name="username" size="25" placeholder="Your User ID"/>
                        </td>
                    </tr>

                    <tr>
                        <td>Password</td>
                        <td align="left"><input type="password" name="password" size="25"
                                                placeholder="Your Password"/></td>
                    </tr>

                    <tr>
                        <td>&nbsp;&nbsp;</td>
                        <td align="left"><input type="submit" name="login" value="Login"/>
                        </td>
                    </tr>
                </table>
            </form:form>

        </div>
    </div>
</div>
</body>
</html>
