<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include/importTags.jsp" %>
<html>
<head>
    <title><spring:message code="signIn" /></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
    <link type="text/css" href="<spring:url value='/css/login.css' />" rel="stylesheet">
</head>
<body>
<div class="form-container">
    <h2><spring:message code="signIn" /></h2>
    <form:form method="POST" modelAttribute="userLogin">
        <div class="form-group">
            <form:label path="username"><spring:message code="username"/></form:label>
            <form:input path="username" type="text" class="form-control" id="username"/>
        </div>
        <div class="form-group">
            <form:label path="password"><spring:message code="password"/></form:label>
            <form:input path="password" type="password" class="form-control" id="password"/>
        </div>
        <br/>
        <form:button class="btn btn-primary"><spring:message code="connexionButton" /></form:button>
    </form:form>
    <div class="new-customer">
        <p><spring:message code="newCustomer" /></p>
        <button onclick="window.location.href='<spring:url value='/inscription' />'" class="btn btn-secondary"><spring:message code="createAccount" /></button>
    </div>
</div>
</body>
</html>
