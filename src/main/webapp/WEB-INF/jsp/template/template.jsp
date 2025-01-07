<%@ page pageEncoding="UTF-8"
         contentType="text/html; charset=UTF-8"%>
<%@ include file="../include/importTags.jsp"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
    <link type="text/css" href="<spring:url value='/css/navBar.css' />" rel="stylesheet">
    <spring:url var="localeFr" value="">
        <spring:param name="locale" value="fr" />
    </spring:url>

    <spring:url var="localeEn" value="">
        <spring:param name="locale" value="en" />
    </spring:url>
</head>
<body>
<header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light px-3">
        <!-- Logo -->
        <a class="navbar-brand" href="<spring:url value='/home' />">
            <img src="<spring:url value='/images/M10_logo_cropped-removebg-preview.png' />" alt="Logo FootSport" class="logo">
        </a>

        <!-- Mobile menu toggle -->
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarContent" aria-controls="navbarContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarContent">
            <!-- Main menu -->
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="<spring:url value="/product/all"/>"><spring:message code="allProducts"/></a>
                </li>
                <c:forEach items="${productCategory}" var="productCategory">
                    <li class="nav-item">
                        <a class="nav-link" href="<spring:url value='/product/${productCategory.getId()}' />">
                            ${productCategory.getName()}
                        </a>
                    </li>
                </c:forEach>
            </ul>


            <!-- About Us -->
            <a href="<spring:url value='/aboutUs' />" class="btn btn-light me-3">
                <spring:message code="aboutUs" />
            </a>

            <!-- Language switcher + User actions -->
            <div class="d-flex align-items-center">
                <!-- Language Switcher -->
                <div class="language-switcher dropdown me-3">
                    <button class="btn btn-light dropdown-toggle language-btn" type="button" id="languageDropdown" data-bs-toggle="dropdown" aria-expanded="false">
                        <img src="<spring:url value='/images/Flag_of_France.png' />" alt="FR" class="language-icon"> FR
                    </button>
                    <ul class="dropdown-menu" aria-labelledby="languageDropdown">
                        <li>
                            <a class="dropdown-item" href="${localeFr}">
                                <img src="<spring:url value='/images/Flag_of_France.png' />" alt="Français" class="language-icon"> Français
                            </a>
                        </li>
                        <li>
                            <a class="dropdown-item" href="${localeEn}">
                                <img src="<spring:url value='/images/Flag_of_the_United_Kingdom.png' />" alt="English" class="language-icon"> English
                            </a>
                        </li>
                    </ul>
                </div>

                <!-- User actions -->
                <sec:authorize access="!isAuthenticated">
                    <button onclick="window.location.href='<spring:url value='/login' />'" class="btn btn-light">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person" viewBox="0 0 16 16">
                            <path d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6m2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0m4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4m-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10s-3.516.68-4.168 1.332c-.678.678-.83 1.418-.832 1.664z"></path>
                        </svg>
                    </button>
                </sec:authorize>

                <sec:authorize access="isAuthenticated()">
                    <div class="user-container d-flex align-items-center">
                        <span class="user-greeting me-2"><spring:message code="hello" />${pageContext.request.userPrincipal.principal.firstName}</span>
                        <a href="<spring:url value='/myAccount' />" class="account-link"><spring:message code="myAccount" /></a>
                    </div>
                </sec:authorize>

                <!-- Cart Icon -->
                <button onclick="window.location.href='<spring:url value='/cart' />'">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-basket" viewBox="0 0 16 16">
                        <path d="M5.757 1.071a.5.5 0 0 1 .172.686L3.383 6h9.234L10.07 1.757a.5.5 0 1 1 .858-.514L13.783 6H15a1 1 0 0 1 1 1v1a1 1 0 0 1-1 1v4.5a2.5 2.5 0 0 1-2.5 2.5h-9A2.5 2.5 0 0 1 1 13.5V9a1 1 0 0 1-1-1V7a1 1 0 0 1 1-1h1.217L5.07 1.243a.5.5 0 0 1 .686-.172zM2 9v4.5A1.5 1.5 0 0 0 3.5 15h9a1.5 1.5 0 0 0 1.5-1.5V9zM1 7v1h14V7zm3 3a.5.5 0 0 1 .5.5v3a.5.5 0 0 1-1 0v-3A.5.5 0 0 1 4 10m2 0a.5.5 0 0 1 .5.5v3a.5.5 0 0 1-1 0v-3A.5.5 0 0 1 6 10m2 0a.5.5 0 0 1 .5.5v3a.5.5 0 0 1-1 0v-3A.5.5 0 0 1 8 10m2 0a.5.5 0 0 1 .5.5v3a.5.5 0 0 1-1 0v-3a.5.5 0 0 1 .5-.5m2 0a.5.5 0 0 1 .5.5v3a.5.5 0 0 1-1 0v-3a.5.5 0 0 1 .5-.5"></path>
                    </svg>
                </button>
            </div>
        </div>
    </nav>
</header>
<div>
    <tiles:insertAttribute name="main-content" />
</div>
</body>
</html>


<script>
    const dropdownToggle = document.getElementById('languageDropdown');
    dropdownToggle.addEventListener('click', function () {
        const dropdownMenu = document.querySelector('.dropdown-menu');
        dropdownMenu.classList.toggle('show');
    });
</script>
