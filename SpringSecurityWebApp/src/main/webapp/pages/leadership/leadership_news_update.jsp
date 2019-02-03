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
            <h3>Here're some updates for the leadership</h3>
            <p><u>Nadine Brennan</u> is the Associate Campus Director at UCONN Hartford and was primarily responsible
                for the relocation of the UCONN Hartford campus from West Hartford to downtown Hartford. She is a
                graduate of the University of Connecticut and is known for her expertise in student and staff
                development. Nadine is a graduate of Leadership Greater Harford’s 2017 Executive Orientation Program.

            <p><u>Rosaida Morales Rosario</u> is a Leadership and Organizational Development Consultant with Rosario &
                Associates LLC. She is known for using her excellent consulting and training skills in ways that greatly
                impact the community. She is a graduate of Wesleyan University and served as a member of the Board of
                Trustees of the Hartford Foundation for Public Giving for 12 years, where she spent her last three years
                as the first Hispanic Vice-Chair. Rosaida is a graduate of Leadership Greater Hartford’s second ALF
                class and the 1980 Quest program.

            <p><u>Ryan Taylor</u> is the Senior Supervisor System Operations for Eversource Energy. He administers
                Eversource’s System Operations Center and is responsible for ensuring that 1.25 million customers in CT
                have electricity. He is a graduate of Westfield State University and of Leadership Greater Hartford’s
                2017 Quest program.
        </div>
    </div>
</div>
</body>
</html>