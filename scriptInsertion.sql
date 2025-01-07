INSERT INTO user (
    email, 
    username, 
    password, 
    first_name, 
    last_name, 
    date_of_birth, 
    telephone, 
    address, 
    authorities, 
    account_non_expired, 
    account_non_locked, 
    credentials_non_expired, 
    enabled
) VALUES (
    'robin.paulus10@gmail.com', 
    'robinpaulus', 
    '$2a$10$TnXQyxfOd/Pldx5FilKAsu.X/H.fkaEI8HKUvZTj6/qBftdyBMaja',
    'Robin', 
    'Paulus', 
    '2002-12-12', 
    '0472580914', 
    '123 Rue Joseph Calozet, 5000, Namur', 
    'ROLE_USER', 
    TRUE, 
    TRUE, 
    TRUE, 
    TRUE
);

INSERT INTO product_category VALUES
(1, "Decouvrez sur notre site les chaussures de football des plus grandes marques telle que Nike, adidas ou encore Puma. ", "Chaussures"),
(2, "Decouvrez tout les maillot de football des plus grands club européens ainsi que mondiaux disponible sur notre site", "Maillots" ),
(3, "Decouvrez les différents equipements comme des jambières, Gands etc , dont vous avez besoin pour pratiquer votre sport préfére sont disponible sur notre site", "Équipements");

INSERT INTO discount VALUES
(1,"Promo de noel","Beneficiez de -20 % pour chaque maillot achetés",0.20,1);

INSERT INTO product VALUES
(1,"Maillot Domicile FC Barcelone 24/25","Notre collection de maillot associe des détails de conception de répliques à une technologie d'évacuation de la transpiration pour vous donner un look prêt à jouer inspiré par votre équipe préférée.",
"Bleu/rouge/or",79.99,2,1,"barcaMaillotDomicile.jpg"),
(2,"Maillot Extérieur FC Barcelone 24/25","Notre collection de maillot associe des détails de conception de répliques à une technologie d'évacuation de la transpiration pour vous donner un look prêt à jouer inspiré par votre équipe préférée.",
"Noir/rouge",119.99,2,1,"barcaMaillotExterieur.jpg"),
(3,"Chaussures de football adidas X Crazyfast Elite FG","""Notre collection de chaussures associe des détails de conception de répliques à une technologie d'évacuation de la transpiration pour vous donner un look prêt à jouer inspiré par votre équipe préférée.",
"Jaune/noir",194.99,1,NULL,"chaussuresAdidasX.jpg"),
(4,"Protège-Tibias Nike Mercurial Lite","Notre collection d'equipement associe des détails de conception de répliques à une technologie d'évacuation de la transpiration pour vous donner un look prêt à jouer inspiré par votre équipe préférée.",
"Blanc/noir",22.83,3,NULL,"ProtegeTibiasNike.jpg"),
(5,"Chaussures de football Nike Superfly 10 Elite Pro SG","Notre collection de chaussures associe des détails de conception de répliques à une technologie d'évacuation de la transpiration pour vous donner un look prêt à jouer inspiré par votre équipe préférée",
"Vert/blanc/orange",299.99,1,NULL,"NikeEliteProSG.jpg"),
(6,"Maillot Extérieur Inter Miami 23/24","Notre collection de maillot associe des détails de conception de répliques à une technologie d'évacuation de la transpiration pour vous donner un look prêt à jouer inspiré par votre équipe préférée",
"Noir/rose",109.99,2,1,"maillotMessiMiami.jpeg"),
(7,"Maillot Domicile et Extérieur Real Vardrid","Notre collection de maillot associe des détails de conception de répliques à une technologie d'évacuation de la transpiration pour vous donner un look prêt à jouer inspiré par votre équipe préférée",
"Jaune",1.99,2,1,"realVardrid.jpg"),
(8,"Maillot Extérieur RDC 23/24","Notre collection de maillot associe des détails de conception de répliques à une technologie d'évacuation de la transpiration pour vous donner un look prêt à jouer inspiré par votre équipe préférée",
"Blanc",70.99,2,1,"maillot-rd-congo-exterieur.jpg"),
(9,"Maillot Extérieur Côte d'ivoire 23/24","Notre collection de maillot associe des détails de conception de répliques à une technologie d'évacuation de la transpiration pour vous donner un look prêt à jouer inspiré par votre équipe préférée",
"Orange",40.99,2,1,"maillotCIV.jpg"),
(10, "Chaussures de football Nike Phantom GX 2 Elite", "Des chaussures conçues pour un contrôle optimal du ballon, avec une technologie Flyknit pour plus de confort et de précision.", 
"Bleu turquoise", 229.99, 1, NULL, "PHANTOM+GX+II+ELITE+FG.png"),
(11, "Chaussures de football Puma Future 7 Ultimate FG/AG", "Les Puma Ultra sont légères, rapides et idéales pour les terrains naturels et synthétiques.", 
"Blanc", 189.99, 1, NULL, "Puma Future 7 Ultimate.png"),
(12, "Chaussures de football Adidas Predator Accuracy.1 FG", "Conçues pour une précision ultime, les Predator sont parfaites pour les créateurs de jeu.", 
"Bleu/blanc", 249.99, 1, NULL, "Adidas Predator Accuracy.1 FG.png"),
(13, "Gants de Gardien Adidas Predator Pro", "Les gants Adidas Predator Pro offrent une excellente adhérence et un rembourrage optimal pour protéger les mains du gardien.", 
"Noir", 89.99, 3, NULL, "Adidas Predator Pro.jpg"),
(14, "Brassard de Capitaine Nike", "Un brassard élastique avec le logo Nike et une excellente visibilité pour inspirer votre équipe.", 
"Rouge", 9.99, 3, NULL, "Brassard capitaine Nike.png"),
(15, "Veste de Survêtement FC Barcelone", "Veste officielle de survêtement du FC Barcelone pour vous garder au chaud avant et après les matchs.", 
"Bleu/grenat", 79.99, 3, NULL, "Veste de survetement Barca.png");

INSERT INTO language VALUES 
('en'),
('fr');

INSERT INTO translation VALUES
(1, 'Shoes', 1, 'en'),
(2, 'Chaussures', 1, 'fr'),
(3, 'Jerseys', 2, 'en'),
(4, 'Maillots', 2, 'fr'),
(5, 'Equipments', 3, 'en'),
(6, 'Équipements', 3, 'fr');