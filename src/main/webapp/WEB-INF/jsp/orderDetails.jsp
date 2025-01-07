<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include/importTags.jsp" %>
<html>
<head>
    <title><spring:message code="orderDetails" /></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
    <link type="text/css" href="<spring:url value='/css/orderDetails.css' />" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h1 class="text-center"><spring:message code="orderSummary" /></h1>
    <hr>

    <!-- Informations sur l'utilisateur -->
    <div class="card mb-4">
        <div class="card-header">
            <h5><spring:message code="clientInformations" /></h5>
        </div>
        <div class="card-body">
            <p><strong><spring:message code="name:" /></strong>${order.user.firstName} ${order.user.lastName}</p>
            <p><strong>Email : </strong>${order.user.email}</p>
            <p><strong><spring:message code="address:" /></strong>${order.user.address}</p>
            <p><strong><spring:message code="phone:" /></strong>${order.user.telephone}</p>
        </div>
    </div>

    <!-- Informations sur la commande -->
    <div class="card mb-4">
        <div class="card-header">
            <h5><spring:message code="orderDetails" /></h5>
        </div>
        <div class="card-body">
            <p><strong><spring:message code="orderNumber:" /></strong>${order.id}</p>
            <p><strong><spring:message code="status:" /></strong>
                <c:choose>
                    <c:when test="${order.isPaid}"><spring:message code="isPaid" /></c:when>
                    <c:otherwise><spring:message code="isNotPaid" /></c:otherwise>
                </c:choose>
            </p>
        </div>
    </div>

    <!-- Liste des produits commandés -->
    <div class="card mb-4">
        <div class="card-header">
            <h5><spring:message code="orderedProduct" /></h5>
        </div>
        <div class="card-body">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th><spring:message code="picture" /></th>
                    <th><spring:message code="product" /></th>
                    <th><spring:message code="size" /></th>
                    <th><spring:message code="color" /></th>
                    <th><spring:message code="quantity" /></th>
                    <th><spring:message code="unitPrice" /></th>
                    <th><spring:message code="subTotal" /></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="orderLine" items="${order.orderLines}">
                    <tr>
                        <td><img src="<spring:url value='/images/${orderLine.product.pictureLink}' />" alt="${orderLine.product.name}" class="img-thumbnail" style="max-width: 100px;"></td>
                        <td>${orderLine.product.name}</td>
                        <td>${orderLine.size}</td>
                        <td>${orderLine.product.color}</td>
                        <td>${orderLine.quantity}</td>
                        <td>${orderLine.price} €</td>
                        <td>${orderLine.quantity * orderLine.price} €</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <!-- Total -->
    <div class="card">
        <div class="card-body text-end">
            <h4>Total : <strong>
                <c:set var="total" value="0" />
                <c:forEach var="orderLine" items="${order.orderLines}">
                    <c:set var="total" value="${total + (orderLine.quantity * orderLine.price)}" />
                </c:forEach>
                ${total} €
            </strong></h4>
        </div>
    </div>

    <div class="text-center mt-4">
        <a href="<spring:url value='/myAccount/myOrders' />" class="btn btn-primary">
            <i class="fas fa-arrow-left"></i> <spring:message code="backToOrders" />
        </a>
    </div>
</div>
</body>
</html>
