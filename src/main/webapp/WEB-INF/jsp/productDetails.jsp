<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="./include/importTags.jsp" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
    <title>Title</title>
    <link type="text/css" href="<spring:url value='/css/productDetails.css' />" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
<!-- Section Image -->
<div class="product-image">
    <img src="<spring:url value='/images/${productDetails.getPictureLink()}' />" class="card-img-top img-fluid" alt="${product.getName()}">
</div>

<!-- Section Détails -->
<div class="product-details">
    <h1 class="product-title">${productDetails.getName()}</h1>

<!-- Si c'est la categorie chaussures ou equipement on ne fait pas apparaitre la reduction -->
<c:if test="${productCategoryInfos.getName() == 'Chaussures' or productCategoryInfos.getName() == 'Équipements'}">
    <p class="price">
        <span class="old-priceNoPromo">${realPrice} €</span>
    </p>
</c:if>

    <!-- Si c'est la categorie maillot on fait  apparaitre la reduction -->
<c:if test="${productCategoryInfos.getName() == 'Maillots'}">
    <p class="price">
        <span class="old-price">${productDetails.getPrice()} €</span>
        <span>${realPrice} €</span> (-20%)
    </p>
</c:if>
<!-- envoyer la taille selectionner dans orderline -->
<form:form method="post" modelAttribute="orderLine" action="/M10Shop/products">
    <form:hidden path="price" value="${realPrice}" />
    <div class="options">
        <label for="size"><spring:message code="size" /> *</label>
        <select id="size" name="size" required>
            <option value="DEFAULT"><spring:message code="selectOption" /></option>
            <!-- Si la catégorie est "Maillot" -->
            <c:if test="${productCategoryInfos.getName() == 'Maillots' or productCategoryInfos.getName() == 'Équipements'}">
                <option value="XS">XS</option>
                <option value="S">S</option>
                <option value="M">M</option>
                <option value="L">L</option>
                <option value="XL">XL</option>
            </c:if>

            <!-- Si la catégorie est "Chaussures" -->
            <c:if test="${productCategoryInfos.getName() == 'Chaussures'}">
                <option value="36">36</option>
                <option value="37">37</option>
                <option value="38">38</option>
                <option value="39">39</option>
                <option value="40">40</option>
                <option value="41">41</option>
                <option value="42">42</option>
                <option value="43">43</option>
                <option value="44">44</option>
                <option value="45">45</option>
            </c:if>
        </select>
        <!-- Affichage de l'erreur -->
        <c:if test="${not empty errorMessage}">
            <div class="error-message">${errorMessage}</div>
        </c:if>
    </div>
        <form:label path="quantity"><spring:message code="quantity"/> : </form:label>
        <form:input path="quantity" id="quantity" type="number" min="1" value="1" />
    <div class="product-action">
    <div class="add-to-cart">
        <button type="submit"><spring:message code="addToCart"/></button>
    </div>
    </div>
    </form:form>
    <div class="details-section">
        <!-- Description du produit -->
        <div class="product-description">
            <h2>Description</h2>
            <p>
                ${productDetails.getDescription()}
            </p>
        </div>

        <!-- Informations complémentaires -->
        <div class="additional-info">
            <h2><spring:message code="additionalInformations" /></h2>
            <table class="info-table">
                <tr>
                    <th><spring:message code="color" /></th>
                    <td>${productDetails.getColor()}</td>
                </tr>
            </table>
        </div>
    </div>
</div>
</div>

</body>
</html>