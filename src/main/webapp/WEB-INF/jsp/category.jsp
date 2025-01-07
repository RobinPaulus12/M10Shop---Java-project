<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include/importTags.jsp" %>
<html>
<head>
    <title>Title</title>
    <link type="text/css" href="<spring:url value='/css/category.css' />" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
</head>
<body>
<div class="title-container">
    <c:if test="${productCategoryInfo.getId() != null}">
        <div class="title">${productCategoryInfo.getName()} de foot</div>
    </c:if>
    <c:if test="${productCategoryInfo.getId() == null}">
        <div class="title"><spring:message code="allProducts" /></div>
    </c:if>
</div>
<p class="description">${productCategoryInfo.getDescription()}</p>
<div class="container my-4">
    <div class="row">
        <c:forEach items="${product}" var="product">
            <div class="col-md-4 col-sm-6 col-lg-3 mb-4">
                <div class="card h-100">
                    <img src="<spring:url value='/images/${product.getPictureLink()}' />" class="card-img-top img-fluid" alt="${product.getName()}">
                    <div class="card-body text-center">
                        <h5 class="card-title">${product.getName()}</h5>
                        <c:if test="${product.getDiscountId() != null}">
                            <div class="price-container" style="display: flex; justify-content: center; align-items: center; gap: 8px;">
                                <span class="old-price" style="text-decoration: line-through; color: rgb(128,128,128);">${product.getPrice()} €</span>
                                <span class="new-price text-primary" style="font-weight: bold;">${realPrice[product.getId()]} €</span>
                            </div>
                        </c:if>
                        <c:if test="${product.getDiscountId() == null}">
                            <p class="card-text"><strong>${product.getPrice()} €</strong></p>
                        </c:if>
                        <a href="<spring:url value='/products/${product.getId()}' />" class="btn btn-primary"><spring:message code="seeDetails" /></a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>