<%@ include file="include/importTags.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="register" /></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
    <link type="text/css" href="<spring:url value='/css/inscription.css' />" rel="stylesheet">
</head>
<body>
<div class="container py-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <h1 class="text-center mb-4"><spring:message code="createAccount" /></h1>
            <form:form id="userForm"
                       method="POST"
                       action="/M10Shop/inscription/send"
                       modelAttribute="userForm"
                       class="card p-4 shadow">
                <div class="mb-3">
                    <form:label path="email" class="form-label">
                        <spring:message code="email"/> <span class="text-danger">*</span>
                    </form:label>
                    <form:input path="email" class="form-control" required="true" />
                    <form:errors path="email" cssClass="text-danger" htmlEscape="false"/>
                </div>
                <div class="mb-3">
                    <form:label path="username" class="form-label">
                        <spring:message code="username"/> <span class="text-danger">*</span>
                    </form:label>
                    <form:input path="username" class="form-control" required="true" />
                    <form:errors path="username" cssClass="text-danger" htmlEscape="false" />
                </div>
                <div class="mb-3">
                     <form:label path="password" class="form-label">
                        <spring:message code="password"/> <span class="text-danger">*</span>
                    </form:label>
                    <form:password path="password" class="form-control" required="true" />
                    <form:errors path="password" cssClass="text-danger" htmlEscape="false"/>
                </div>
                <div class="mb-3">
                    <form:label path="confirmPassword" class="form-label">
                        <spring:message code="confirmPassword"/> <span class="text-danger">*</span>
                    </form:label>
                    <form:password path="confirmPassword" class="form-control" required="true" />
                    <form:errors path="confirmPassword" cssClass="text-danger" htmlEscape="false"/>
                </div>
                <div class="mb-3">
                    <form:label path="firstName" class="form-label">
                        <spring:message code="firstName"/> <span class="text-danger">*</span>
                    </form:label>
                    <form:input path="firstName" class="form-control" required="true" />
                    <form:errors path="firstName" cssClass="text-danger" htmlEscape="false"/>
                </div>
                <div class="mb-3">
                    <form:label path="lastName" class="form-label">
                        <spring:message code="lastName"/> <span class="text-danger">*</span>
                    </form:label>
                    <form:input path="lastName" class="form-control" required="true" />
                    <form:errors path="lastName" cssClass="text-danger" htmlEscape="false"/>
                </div>
                <div class="mb-3">
                    <form:label path="dateOfBirth" class="form-label">
                        <spring:message code="dateOfBirth"/> <span class="text-danger">*</span>
                    </form:label>
                    <form:input path="dateOfBirth" type="date" class="form-control" required="true" />
                    <form:errors path="dateOfBirth" cssClass="text-danger" htmlEscape="false"/>
                </div>
                <div class="mb-3">
                    <form:label path="telephone" class="form-label"><spring:message code="phone"/></form:label>
                    <form:input path="telephone" class="form-control" />
                    <form:errors path="telephone" cssClass="text-danger" htmlEscape="false"/>
                </div>
                <div class="mb-3">
                    <form:label path="address" class="form-label">
                        <spring:message code="address"/> <span class="text-danger">*</span>
                    </form:label>
                    <form:input path="address" class="form-control" required="true" />
                    <form:errors path="address" cssClass="text-danger" htmlEscape="false"/>
                </div>
                <div class="d-grid">
                    <form:button class="btn btn-primary">
                        <i class="fas fa-user-plus me-2"></i> Inscription
                    </form:button>
                </div>
                <!-- Légende pour les champs obligatoires -->
                <p class="mt-3 text-muted text-center" style="font-size: 0.85rem;">
                    <spring:message code="requiredFieldsLegend"/> : <span class="text-danger">*</span>
                </p>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>