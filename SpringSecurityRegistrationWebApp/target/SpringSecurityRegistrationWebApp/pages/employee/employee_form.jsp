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
    <jsp:directive.include file="/pages/common/header.jsp"/>
    <div id="actual_content">
        <%@include file="/pages/common/cr_leftnav.jsp" %>
        <div id="content-body">
            <h3>Please select the role</h3>
            <form action="${pageContext.request.contextPath}/mySecurityServlet" method="post">
                <table class="tableinfo">
                    <thead>
                    <tr>
                        <td colspan="2">Employee information</td>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>Type your name</td>
                        <td><label>
                            <input type="text" name="userId"/>
                        </label></td>
                    </tr>
                    <tr>
                        <td>Select role</td>
                        <td><label>
                            <select name="role">
                                <option value="employee">Employee</option>
                                <option value="contractor">Contractor</option>
                                <option value="admin">Admin</option>
                            </select>
                        </label>
                        </td>
                    </tr>
                    <tr>
                        <td>&nbsp;&nbsp;</td>
                        <td><input type="submit" value="Check eligibility"/></td>
                    </tr>
                    </tbody>
                </table>
            </form>
        </div>
    </div>
</div>
</body>
</html>