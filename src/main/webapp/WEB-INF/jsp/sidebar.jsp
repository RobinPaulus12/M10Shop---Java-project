<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include/importTags.jsp" %>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
    <link type="text/css" href="<spring:url value='/css/sidebar.css' />" rel="stylesheet">
</head>
<div class="sidebar">
    <div class="profile-section">
        <div class="profile-initials">
            ${fn:toUpperCase(pageContext.request.userPrincipal.principal.firstName.substring(0, 1))}${fn:toUpperCase(pageContext.request.userPrincipal.principal.lastName.substring(0, 1))}
        </div>
        <h5 class="profile-name">
           <spring:message code="hello" />
            <br>
            ${pageContext.request.userPrincipal.principal.firstName} ${pageContext.request.userPrincipal.principal.lastName}
        </h5>
    </div>

    <ul class="menu">
        <li>
            <a href="<spring:url value='/myAccount/myInformations' />">
                <span><i class="fas fa-info-circle"></i> <spring:message code="myInformations" /></span>
                <i class="fas fa-chevron-right"></i>
            </a>
        </li>
        <li>
            <a href="<spring:url value='/myAccount/myOrders' />">
                <span><i class="fas fa-box"></i> <spring:message code="myOrders" /></span>
                <i class="fas fa-chevron-right"></i>
            </a>
        </li>
    </ul>


    <div class="logout-section">
        <a href="<spring:url value='/logout' />" class="btn logout-btn">
            <i class="fas fa-sign-out-alt"></i> <spring:message code="signOff" />
        </a>
    </div>
</div>
