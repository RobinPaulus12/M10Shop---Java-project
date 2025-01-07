<%@ page pageEncoding="UTF-8"
         contentType="text/html; charset=UTF-8"%>
<%@ include file="include/importTags.jsp"%>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
    <link type="text/css" href="<spring:url value='/css/home.css' />" rel="stylesheet">
</head>
<body>
<!-- Bandeau de promo -->
<div class="promo-banner">
    <spring:message code="bannerDiscount"/> <span class="highlight"><spring:message code="bannerContent"/></span>
    <span class="free-shipping"><spring:message code="bannerShipping"/></span>
</div>

<!-- Image promotionnelle -->
<div class="d-flex align-items-center">
     <a href="${pageContext.request.contextPath}/products/5">
        <img id="jerseyInter" alt="maillot" src="<spring:url value='/images/FR_Nike_slider_desktop_1.jpg' />"  class="img-fluid me-3">
     </a>
</div>

<!-- Section Nos Maillots -->
<div class="container my-5">
    <h2 class="section-title"><spring:message code="ourJerseys"/></h2>
    <div id="jerseyCarousel" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-inner">

            <!-- Premier élément du carrousel -->
            <div class="carousel-item active">
                <div class="row flex-nowrap">
                    <c:forEach items="${maillots}" var="product" begin="0" end="3">
                        <div class="col-auto mb-4">
                            <div class="card h-100">
                                <img src="<spring:url value='/images/${product.pictureLink}' />" class="card-img-top img-fluid" alt="${product.name}">
                                <div class="card-body text-center">
                                    <h5 class="card-title">${product.name}</h5>

                                    <!-- Affichage du prix avec ou sans réduction -->
                                    <c:choose>
                                        <c:when test="${product.discountId != null}">
                                            <div class="price-container" style="display: flex; justify-content: center; align-items: center; gap: 8px;">
                                                <span class="old-price" style="text-decoration: line-through; color: rgb(128,128,128);">${product.price} €</span>
                                                <span class="new-price text-primary" style="font-weight: bold;">${realPrice[product.id]} €</span>
                                            </div>
                                        </c:when>
                                        <c:otherwise>
                                            <p class="card-text text-primary"><strong>${product.price} €</strong></p>
                                        </c:otherwise>
                                    </c:choose>

                                    <a href="<spring:url value='/products/${product.id}' />" class="btn btn-primary">
                                        <spring:message code="seeDetails" />
                                    </a>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>

            <!-- Autres éléments du carrousel -->
            <c:forEach items="${maillots}" var="product" begin="4" step="4" varStatus="status">
                <div class="carousel-item">
                    <div class="row flex-nowrap">
                        <c:forEach items="${maillots}" var="innerProduct" begin="${status.index}" end="${status.index + 3}" step="1">
                            <div class="col-auto mb-4">
                                <div class="card h-100">
                                    <img src="<spring:url value='/images/${innerProduct.pictureLink}' />" class="card-img-top img-fluid" alt="${innerProduct.name}">
                                    <div class="card-body text-center">
                                        <h5 class="card-title">${innerProduct.name}</h5>

                                        <!-- Affichage du prix avec ou sans réduction -->
                                        <c:choose>
                                            <c:when test="${innerProduct.discountId != null}">
                                                <div class="price-container" style="display: flex; justify-content: center; align-items: center; gap: 8px;">
                                                    <span class="old-price" style="text-decoration: line-through; color: rgb(128,128,128);">${innerProduct.price} €</span>
                                                    <span class="new-price text-primary" style="font-weight: bold;">${realPrice[innerProduct.id]} €</span>
                                                </div>
                                            </c:when>
                                            <c:otherwise>
                                                <p class="card-text text-primary"><strong>${innerProduct.price} €</strong></p>
                                            </c:otherwise>
                                        </c:choose>

                                        <a href="<spring:url value='/products/${innerProduct.id}' />" class="btn btn-primary">
                                            <spring:message code="seeDetails" />
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </c:forEach>
        </div>

        <!-- Boutons de navigation du carrousel -->
        <button class="carousel-control-prev" type="button" data-bs-target="#jerseyCarousel" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#jerseyCarousel" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>
</div>

<!-- Pied de page -->
<footer class="bg-light py-3 mt-5">
    <div class="container d-flex justify-content-between align-items-center">
        <!-- Logo PayPal -->
        <img src="<spring:url value='/images/paypal.svg' />" alt="PayPal Logo" style="width: 80px; height: auto;">

        <!-- Raccourci vers About Us -->
        <a href="<spring:url value='/aboutUs' />" class="btn btn-light">
            <spring:message code="aboutUs" />
        </a>

        <!-- Copyright -->
        <span class="text-muted">Copyright M10Shop 2024-</span>
    </div>
</footer>

</body>
</html>
