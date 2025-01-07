<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include/importTags.jsp" %>
<html>
<head>
    <title><spring:message code="myAccount" /></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
    <link type="text/css" href="<spring:url value='/css/account.css' />" rel="stylesheet">
</head>
<body>
<main class="container mt-5">
    <div class="row d-flex justify-content-center">
        <div class="col-md-6">
            <div class="card shadow-sm border-light">
                <div class="card-body">
                    <!-- Section Bonjour -->
                    <div class="text-center mb-4">
                        <div class="avatar bg-primary text-white rounded-circle d-inline-flex align-items-center justify-content-center" style="width: 60px; height: 60px; font-size: 24px;">
                            <span>
                                ${fn:toUpperCase(pageContext.request.userPrincipal.principal.firstName.substring(0, 1))}${fn:toUpperCase(pageContext.request.userPrincipal.principal.lastName.substring(0, 1))}
                            </span>
                        </div>
                        <h5 class="mt-3 fw-bold"><spring:message code="hello" /> ${pageContext.request.userPrincipal.principal.firstName} ${pageContext.request.userPrincipal.principal.lastName}</h5>
                    </div>
                    <!-- Boutons de navigation -->
                    <div class="list-group">
                        <!-- Mes informations -->
                        <a href="<spring:url value='/myAccount/myInformations' />" class="list-group-item list-group-item-action d-flex align-items-center">
                            <i class="fas fa-user-circle me-3"></i>
                            <spring:message code="myInformations" />
                            <i class="fas fa-chevron-right ms-auto"></i>
                        </a>
                        <!-- Mes commandes -->
                        <a href="<spring:url value='/myAccount/myOrders' />" class="list-group-item list-group-item-action d-flex align-items-center">
                            <i class="fas fa-box me-3"></i>
                            <spring:message code="myOrders" />
                            <i class="fas fa-chevron-right ms-auto"></i>
                        </a>
                    </div>
                    <!-- Déconnexion -->
                    <div class="mt-4 text-center">
                        <a href="<spring:url value='/logout' />" class="btn btn-primary w-100">
                            <i class="fas fa-sign-out-alt me-2"></i> <spring:message code="signOff" />
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>
</body>
</html>
