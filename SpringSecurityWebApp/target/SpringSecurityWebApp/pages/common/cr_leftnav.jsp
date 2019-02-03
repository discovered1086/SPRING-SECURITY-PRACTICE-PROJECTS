<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
    Document   : rightNav
    Created on : 5 Jan, 2011, 2:25:32 AM
    Author     : Kingshuk
--%>

<div id="sidebar">
    <ul id="parent_nav">
        <security:authorize access="hasRole('EMPLOYEE')">
            <li><a href="${pageContext.request.contextPath}/employee">Get the employee page</a></li>
        </security:authorize>

        <security:authorize access="hasRole('LEADERSHIP')">
            <li><a href="${pageContext.request.contextPath}/leadership">Get the leadership page</a></li>
        </security:authorize>

        <security:authorize access="hasRole('VENDOR')">
            <li><a href="${pageContext.request.contextPath}/vendor">Get the vendor page</a></li>
        </security:authorize>


        <security:authorize access="isAuthenticated()">
            <li>
                <form:form method="post" action="${pageContext.request.contextPath}/logout">
                    <input type="submit" value="Log out"/>
                </form:form>
            </li>
        </security:authorize>

    </ul>
</div>
