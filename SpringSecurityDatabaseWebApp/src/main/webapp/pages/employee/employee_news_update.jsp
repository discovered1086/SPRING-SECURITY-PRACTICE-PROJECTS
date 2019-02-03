<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Employee New update</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/master_css.css">
    <!--<script type="text/javascript" src="../../scripts/common.js"></script>-->


</head>
<body>
<div id="allcontent">
    <%--<%@include file="common/header.jsp" %> --%>
    <jsp:directive.include file="/pages/common/header.jsp"/>
    <div id="actual_content">
        <%@include file="/pages/common/cr_leftnav.jsp" %>
        <div id="content-body">
            <h4>You are <security:authentication property="principal.username"/>&nbsp;
                and you have a role <security:authentication property="principal.authorities"/></h4>
            <h3>Here're some updates for the employees</h3>
            <p>Employers should take note that a significant number of legal changes on the federal, state and local
                level
                have or will have a substantial impact on workplace policies and employee handbooks. It is critical for
                an
                employer to review, amend and properly update its handbook for 2018 so that it reflects the latest legal
                requirements.
            </p>

            <p>An employer also needs to understand what the legal update is and how it affects the workplace, as well
                as
                develop and implement policies, practices and procedures to remain compliant. Further, an employer may
                need
                to update its employee handbook based on internal changes (e.g., benefits, performance management).
            </p>

            <p>
                In our white paper you will learn:

            <ul>
                <li>Steps for changing your employee handbook for 2018</li>
                <li>Employee Handbook policy statements that can assist you while updating</li>
                <li>Important legal developments</li>
                <li>How to prepare for upcoming changes</li>
            </ul>
            </p>
        </div>
    </div>
</div>
</body>
</html>