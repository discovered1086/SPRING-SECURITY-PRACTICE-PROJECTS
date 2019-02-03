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
            <form:form name="thisForm" method="post"
                       action="${pageContext.request.contextPath}/registration/processRegistration.htm"
                       modelAttribute="registrationInfo">

                <table class="tableinfo" id="student_form">
                    <th colspan="2">Please enter user information</th>
                    <c:if test="${requestScope.validationErrorMessage ne null}">
                        <tr>
                            <td colspan="2">
                                <div class="error-message">
                                    <c:out value="${requestScope.validationErrorMessage}"/>
                                </div>
                            </td>
                        </tr>
                    </c:if>
                    <tr>
                        <td>User ID</td>
                        <td align="left">
                            <form:input type="text" name="username"
                                        path="username"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"><form:errors cssClass="error-message" path="username"/></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td align="left">
                            <form:input type="password" name="password"
                                        path="password"/>

                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"><form:errors cssClass="error-message" path="password"/></td>
                    </tr>

                    <tr>
                        <td>Select roles</td>
                        <td align="left">
                            <table border="0">
                                <tr>
                                    <td><!--<input type="checkbox" name="role"
                                               value="ROLE_EMPLOYEE">-->
                                        <form:checkbox path="roles" value="ROLE_EMPLOYEE"/>
                                    </td>
                                    <td>EMPLOYEE</td>
                                </tr>
                                <tr>
                                    <td><!--<input type="checkbox" name="ro"
                                               value="ROLE_LEADERSHIP">-->
                                        <form:checkbox path="roles" value="ROLE_LEADERSHIP"/>
                                    </td>
                                    <td>LEADERSHIP</td>
                                </tr>
                                <tr>
                                    <td><!--<input type="checkbox" name="role" value="ROLE_VENDOR">-->
                                        <form:checkbox path="roles" value="ROLE_VENDOR"/>
                                    </td>
                                    <td>VENDOR</td>
                                </tr>
                            </table>

                        </td>
                    </tr>

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
