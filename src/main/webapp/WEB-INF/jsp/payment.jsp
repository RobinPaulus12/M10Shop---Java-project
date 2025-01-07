<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include/importTags.jsp" %>
<html>
<head>
    <title><spring:message code="payment" /></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
    <link type="text/css" href="<spring:url value='/css/payment.css' />" rel="stylesheet">
</head>
<body>

<!-- Conteneur principal -->
<div class="container my-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <!-- Carte de paiement -->
            <div class="card shadow p-4">
                <h2 class="text-center mb-4"><spring:message code="payment" /></h2>

                <!-- Détails de la commande -->
                <ul class="list-group mb-4">
                    <li class="list-group-item d-flex justify-content-between align-items-center">
                        <strong><spring:message code="total" /></strong>
                        <span class="text-primary fw-bold">${String.format('%.2f', cart.total())} €</span>
                    </li>
                    <li class="list-group-item d-flex justify-content-between align-items-center">
                        <spring:message code="currency" />
                        <span>EUR</span>
                    </li>
                </ul>

                <!-- Formulaire PayPal -->
                <form action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post">
                    <input type="hidden" name="business" value="M10Shop@business.henallux.be"/>
                    <input type="hidden" name="cert_id" value="AW52o-QlYBJjhZQ5hEoWisMdwoXzNb0qwdpXu44-IWkdKtinVA7v_GDuwoOBzGSyRC_Z2klKE-5FQqcz"/>
                    <input type="hidden" name="cmd" value="_xclick"/>
                    <input type="hidden" name="amount" value="${cart.total()}"/>
                    <input type="hidden" name="currency_code" value="EUR"/>
                    <input type="hidden" name="return" value="http://localhost:8082/M10Shop/payment/successful"/>
                    <input type="hidden" name="cancel_return" value="http://localhost:8082/M10Shop/payment/canceled"/>

                    <!-- Bouton PayPal -->
                    <div class="d-grid">
                        <button type="submit" class="btn btn-primary btn-lg">
                            <i class="fab fa-paypal me-2"></i><spring:message code="payWithPaypal" />
                        </button>
                    </div>
                </form>
            </div>
        </div>
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
