<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include/importTags.jsp" %>
<html>
<head>
    <title><spring:message code="myInformations"/></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
    <link type="text/css" href="<spring:url value='/css/userInformations.css' />" rel="stylesheet">
</head>
<body>
<div class="account-container">
    <%@ include file="sidebar.jsp" %>
        <!-- Main Content -->
        <div class="content">
            <h1><spring:message code="myInformations"/></h1>

            <!-- Message de succès -->
            <c:if test="${not empty success}">
                <div class="alert alert-success">${success}</div>
            </c:if>

            <!-- Formulaire d'update -->
            <form:form id="updatedUser" method="POST" modelAttribute="currentUser">
                <div class="form-group">
                    <form:label path="email"><spring:message code="email"/></form:label>
                    <form:input path="email" />
                    <form:errors path="email" cssClass="text-danger" htmlEscape="false"/>
                </div>

                <div class="form-group">
                    <form:label path="username"><spring:message code="username"/></form:label>
                    <form:input path="username" readonly="true" /> <!-- Non modifiable -->
                </div>

                <div class="form-group">
                    <form:label path="firstName"><spring:message code="firstName"/></form:label>
                    <form:input path="firstName" />
                    <form:errors path="firstName" cssClass="text-danger" htmlEscape="false"/>
                </div>

                <div class="form-group">
                    <form:label path="lastName"><spring:message code="lastName"/></form:label>
                    <form:input path="lastName" />
                    <form:errors path="lastName" cssClass="text-danger" htmlEscape="false"/>
                </div>

                <div class="form-group">
                    <form:label path="dateOfBirth"><spring:message code="dateOfBirth"/></form:label>
                    <form:input path="dateOfBirth" type="date" />
                    <form:errors path="dateOfBirth" cssClass="text-danger" htmlEscape="false"/>
                </div>

                <div class="form-group">
                    <form:label path="telephone"><spring:message code="phone"/></form:label>
                    <form:input path="telephone" />
                    <form:errors path="telephone" cssClass="text-danger" htmlEscape="false"/>
                </div>

                <div class="form-group">
                    <form:label path="address"><spring:message code="address"/></form:label>
                    <form:input path="address" />
                    <form:errors path="address" cssClass="text-danger" htmlEscape="false"/>
                </div>
                <!-- Gestion des mots de passe -->
                <div class="form-group">
                    <form:label path="currentPassword"><spring:message code="currentPassword"/></form:label>
                    <form:password path="currentPassword" id="currentPassword" class="form-control" />
                    <form:errors path="currentPassword" cssClass="text-danger" htmlEscape="false"/>
                </div>

                <div class="form-group">
                    <form:label path="newPassword"><spring:message code="newPassword"/></form:label>
                    <form:password path="newPassword" id="newPassword" class="form-control" />
                    <form:errors path="newPassword" cssClass="text-danger" htmlEscape="false"/>
                </div>

                <div class="form-group">
                    <form:label path="confirmNewPassword"><spring:message code="confirmNewPassword"/></form:label>
                    <form:password path="confirmNewPassword" id="confirmNewPassword" class="form-control" />
                    <form:errors path="confirmNewPassword" cssClass="text-danger" htmlEscape="false"/>
                </div>

                <form:button class="tn btn-primary w-100">
                        <i class="fas fa-save me-2"></i><spring:message code="updateUserInformations"/>
                </form:button>
            </form:form>
        </div>
    </div>
</body>

</html>
