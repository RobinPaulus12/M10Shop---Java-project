-- Création de la table product_category
CREATE TABLE product_category (
    id INT AUTO_INCREMENT PRIMARY KEY,
    description TEXT, 
	name VARCHAR(100) NOT NULL
);

-- Création de la table discount
CREATE TABLE discount (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    discount_percent DECIMAL(5, 2) NOT NULL CHECK (discount_percent >= 0 AND discount_percent <= 100),
    active BOOLEAN DEFAULT TRUE
);

-- Création de la table product
CREATE TABLE product (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    color varchar(50),
    price DECIMAL(10, 2) NOT NULL CHECK (price >= 0),
    category_id INT NOT NULL,
    discount_id INT,
    picture_link VARCHAR(255),
    CONSTRAINT fk_product_category FOREIGN KEY (category_id) REFERENCES product_category(id),
    CONSTRAINT fk_product_discount FOREIGN KEY (discount_id) REFERENCES discount(id)
);

-- Création de la table user
CREATE TABLE user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    username VARCHAR(50) DEFAULT NULL UNIQUE,	
    password VARCHAR(200) NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    date_of_birth DATE NOT NULL,
    telephone VARCHAR(20) DEFAULT NULL,
    address VARCHAR(255) NOT NULL,
    authorities varchar(500) DEFAULT NULL,
    account_non_expired TINYINT(1) DEFAULT NULL,
    account_non_locked TINYINT(1) DEFAULT NULL,
    credentials_non_expired TINYINT(1) DEFAULT NULL,
    enabled TINYINT(1) DEFAULT NULL
);

-- Création de la table order
CREATE TABLE `order` (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    is_paid BOOLEAN DEFAULT FALSE,
    CONSTRAINT fk_order_user FOREIGN KEY (user_id) REFERENCES user(id)
);

-- Création de la table order_line
CREATE TABLE order_line (
    id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    size VARCHAR(4) NOT NULL,
    quantity INT NOT NULL CHECK (quantity >= 0),
    price DECIMAL(10, 2) NOT NULL CHECK (price >= 0), 
    CONSTRAINT fk_order_line_order FOREIGN KEY (order_id) REFERENCES `order`(id),
    CONSTRAINT fk_order_line_product FOREIGN KEY (product_id) REFERENCES product(id)
);

-- Création de la table Language
CREATE TABLE language (
    name VARCHAR(50) PRIMARY KEY
);
	
-- Création de la table Translation
CREATE TABLE translation (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name varchar(50) NOT NULL,
    category_id INT NOT NULL,
    language varchar(50) NOT NULL,
    CONSTRAINT fk_translation_name FOREIGN KEY (category_id) REFERENCES product_category(id),
	CONSTRAINT fk_translation_language FOREIGN KEY (language) REFERENCES language(name)
);
