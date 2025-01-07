<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include/importTags.jsp" %>
<html>
<head>
    <title><spring:message code="myCart"/></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
    <link type="text/css" href="<spring:url value='/css/cart.css' />" rel="stylesheet">
</head>
<body>
<div class="title-container">
    <div class="title"><spring:message code="myCart"/></div>
</div>
<div class="container">
    <div class="left">
        <div class="title"><spring:message code="myProductsAdded"/></div>
        <c:if test="${cart.getCart().size() == 0}">
            <p><spring:message code="emptyCart"/></p>
        </c:if>
        <c:if test="${cart.getCart().size() > 0}">
        <table class="table">
            <thead>
            <tr>
                <th><spring:message code="product"/></th>
                <th><spring:message code="price"/></th>
                <th><spring:message code="quantity"/></th>
                <th><spring:message code="subTotal"/></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${cart.getCart().keySet()}" var="key">
                <c:set var="product" value="${cart.getCart().get(key).getProduct()}"/>
                <tr>
                    <td>
                        <img src="<spring:url value='/images/${product.getPictureLink()}'/>" class="img-fluid mb-3" style="max-width: 100px;"/>
                        <div><strong>${product.getName()}</strong></div>
                        <div><strong><spring:message code="size"/> :</strong> ${cart.getCart().get(key).getSize()}</div>
                        <div><strong><spring:message code="color"/> :</strong> ${product.getColor()}</div>
                    </td>
                    <td>${realPrices[key]}€</td>
                    <td>
                        <form:form method="post" action="/M10Shop/cart/update" modelAttribute="orderLine" class="d-flex align-items-center">
                            <input type="hidden" name="key" value="${key}" />
                            <form:input class="form-control" style="max-width: 60px;" path="quantity" type="number" min="1" value="${cart.getCart().get(key).getQuantity()}"/>
                            <form:button class="ms-2 btn btn-primary" modelAttribute="orderLine">
                                <i class="bi bi-arrow-counterclockwise"></i>
                            </form:button>
                        </form:form>
                    </td>
                    <td>${String.format("%.2f", realPrices[key] * cart.getCart().get(key).getQuantity())}€</td>
                    <td>
                        <form:form method="post" action="/M10Shop/cart/delete" modelAttribute="orderLine">
                            <input type="hidden" name="key" value="${key}" />
                            <button class="btn" style="background: none; border: none; cursor: pointer;">
                                <i class="bi bi-trash" style="font-size: 20px;"></i>
                            </button>
                        </form:form>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>
    </c:if>
    <c:if test="${cart.getCart().size() > 0}">
        <div class="right">
            <div class="summary">
                <div class="total"><spring:message code="total"/>: ${String.format("%.2f", total)}€</div>
                <form action="<spring:url value="/payment"/>">
                    <button class="button"><spring:message code="placeOrder"/></button>
                </form>
                <div class="features">
                    <div>💳 <br><spring:message code="payment"/> <br><spring:message code="noFees"/></div>
                    <div>🚚 <br><spring:message code="delivery24h"/> <br><spring:message code="freeFrom"/></div>
                    <div>🔄 <br><spring:message code="returns"/> <br><spring:message code="30days"/></div>
                    <div>❤️ <br>Satisfaction <br>9.6/10</div>
                </div>
            </div>
        </div>
    </c:if>
</div>

</body>
</html>
