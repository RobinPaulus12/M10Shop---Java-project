<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include/importTags.jsp" %>
<html>
<head>
    <title><spring:message code="myOrders"/></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
    <link type="text/css" href="<spring:url value='/css/userOrders.css' />" rel="stylesheet">
</head>
<body>
   <div class="account-container">
       <%@ include file="sidebar.jsp" %>
    <!-- Contenu principal -->
    <div class="content">
        <h1><spring:message code="myPurchases"/></h1>

        <!-- Affichage des commandes -->
        <c:forEach var="order" items="${orders}">
            <div class="card mb-3">
                <div class="card-body">
                    <h5 class="card-title">
                        <spring:message code="order"/> #${order.id}
                        <!-- Lien vers la page de détail -->
                        <a href="<spring:url value='/myAccount/myOrders/details/${order.id}' />" class="btn btn-link">
                            <spring:message code="seeDetails"/>
                        </a>
                    </h5>
                    <p class="card-text">Total : ${order.totalPrice} €</p>

                    <!-- Affichage des produits dans la commande -->
                    <div class="d-flex">
                        <c:forEach var="line" items="${order.orderLines}">
                            <div class="p-2 text-center">
                                <img src="<spring:url value='/images/${line.product.pictureLink}' />" alt="${line.product.name}" class="img-thumbnail" style="width: 150px; height: 150px;">
                                <p>${line.product.name}</p>
                                <p>${line.quantity} x ${line.price} €</p> <!-- Affiche le prix avec réduction -->
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>