<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include/importTags.jsp" %>
<html>
<head>
    <title><spring:message code="aboutUs" /> - M10Shop</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
    <link type="text/css" href="<spring:url value='/css/aboutUs.css' />" rel="stylesheet">
</head>
<body>
<div class="container py-5">
    <h1 class="text-center mb-5">À propos de M10Shop</h1>

    <!-- Section Description -->
    <div class="row mb-5">
        <div class="col-md-6">
            <img src="<spring:url value='/images/M10_logo_cropped-removebg-preview.png' />" alt="Logo M10Shop" class="img-fluid rounded shadow">
        </div>
        <div class="col-md-6 d-flex align-items-center">
            <p class="about-description">
                Bienvenue sur <strong>M10Shop</strong>, votre boutique en ligne dédiée à la vente d'articles de football !
                Créée par trois étudiants passionnés – Kevin Hirwa, Robin Paulus et Jeremy Nsimba Muanda – M10Shop est
                née de notre amour du football et de notre admiration pour <strong>le plus grand joueur de tous les temps, Lionel Messi</strong>.
                Notre nom est une référence directe au légendaire numéro 10 argentin qui a marqué l’histoire du football.
            </p>
        </div>
    </div>

    <!-- Section Les créateurs -->
    <div class="creators-section mb-5">
        <h2 class="text-center mb-4">Nos créateurs</h2>
        <div class="row text-center">
            <div class="col-md-4">
                <img src="<spring:url value='/images/Kevin_Hirwa2.png' />" alt="Kevin Hirwa" class="creator-photo creator-photo-kevin">
                <h5 class="mt-3">Kevin Hirwa</h5>
                <p class="text-muted">Co-fondateur & Développeur Backend</p>
            </div>
            <div class="col-md-4">
                <img src="<spring:url value='/images/Robin_Paulus.jpg' />" alt="Robin Paulus" class="creator-photo creator-photo-robin">
                <h5 class="mt-3">Robin Paulus</h5>
                <p class="text-muted">Co-fondateur & Développeur Full Stack</p>
            </div>
            <div class="col-md-4">
                <img src="<spring:url value='/images/Jeremy_Nsimba_Muanda2.png' />" alt="Jeremy Nsimba Muanda" class="creator-photo creator-photo-jeremy">
                <h5 class="mt-3">Jeremy Nsimba Muanda</h5>
                <p class="text-muted">Co-fondateur & Développeur Frontend</p>
            </div>
        </div>
    </div>

    <!-- Section Vision et Mission -->
    <div class="mission-section text-center mb-5">
        <h2 class="mb-4">Notre mission</h2>
        <p class="mission-text">
            Chez M10Shop, notre objectif est de fournir aux amateurs de football des articles de qualité,
            des maillots personnalisés aux équipements de terrain, tout en célébrant les icônes du football comme Messi.
            Nous nous engageons à offrir une expérience utilisateur fluide, des produits authentiques, et un service client irréprochable.
        </p>
    </div>

    <!-- Section Contact -->
    <div class="contact-section text-center">
        <h2 class="mb-4">Nous contacter</h2>
        <p class="contact-text">
            Vous avez des questions ou souhaitez en savoir plus ? N'hésitez pas à nous contacter via notre page Contact</a>.
            Suivez-nous également sur nos réseaux sociaux pour rester informé des dernières nouveautés !
        </p>
    </div>
</div>
</body>
</html>
