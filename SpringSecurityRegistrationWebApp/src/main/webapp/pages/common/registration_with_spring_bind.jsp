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
            <table class="tableinfo">
                <th colspan="2">Select registration type</th>
                <tr>
                    <td>User Role</td>
                    <td align="left">

                    </td>
                </tr>
            </table>
            <br>
            <br>
            <form:form name="thisForm" method="post" action="processRegistration">
                <table class="tableinfo" id="student_form">
                    <spring:nestedPath path="user">
                        <tr>
                            <td>User ID</td>
                            <td>
                                <spring:bind path="username">
                                    <input type="text" name="${status.expression}" value="${status.value}">
                                </spring:bind>
                            </td>
                        </tr>
                        <tr>
                            <td>Password</td>
                            <td>
                                <spring:bind path="password">
                                    <input type="password" name="${status.expression}" value="${status.value}">
                                </spring:bind>
                            </td>
                        </tr>
                    </spring:nestedPath>
                    <spring:nestedPath path="role">
                        <tr>
                            <td>Select roles</td>
                            <td>
                                <spring:bind path="roles">
                                    <input type="checkbox" name="${status.expression}"
                                           value="ROLE_EMPLOYEE">&nbsp; EMPLOYEE<br>
                                    <input type="checkbox" name="${status.expression}"
                                           value="ROLE_LEADERSHIP">&nbsp; LEADERSHIP<br>
                                    <input type="checkbox" name="${status.expression}" value="ROLE_VENDOR">&nbsp; VENDOR
                                </spring:bind>
                            </td>
                        </tr>
                    </spring:nestedPath>
                    </label>

                    <th colspan="2">Please enter user information</th>
                    <tr>
                        <td>&nbsp;&nbsp;</td>
                        <td align="left"><input type="submit" name="Register" value="Register user"/>
                        </td>
                    </tr>
                </table>
            </form:form>


        </div>
    </div>
</div>
</body>
</html>
