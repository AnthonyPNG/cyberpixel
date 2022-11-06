CREATE DATABASE IF NOT EXISTS `CyberPixel` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `CyberPixel`;

CREATE TABLE `cb` (
  `idcb` int(10) NOT NULL AUTO_INCREMENT,
  `num` bigint(20) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `date` varchar(10) NOT NULL DEFAULT "01/25",
  `cryptogramme` int NOT NULL DEFAULT 000,
  `solde` decimal(10,2) NOT NULL DEFAULT 0.00,
  PRIMARY KEY (`idcb`)
);

INSERT INTO `cb` (`idcb`, `num`, `nom`, `date`, `cryptogramme`, `solde`) VALUES 
(1, 4970101234567890, "Dupont", "08/25", 398, 1023.60),
(2, 4971417834619078, "Dupuit", "01/24", 891, 12.25),
(3, 4973000000000000, "Dupres", "07/24", 321, 253.03);


CREATE TABLE `produit` (
  `idproduit` int(10) NOT NULL AUTO_INCREMENT,
  `nom` varchar(100) DEFAULT NULL,
  `prix` decimal(10,2) NOT NULL DEFAULT 0.00,
  `quantite` int NOT NULL DEFAULT 1,
  `description` varchar(10000) DEFAULT NULL,
  `url` varchar(10000) DEFAULT "https://aeroclub-issoire.fr/wp-content/uploads/2020/05/image-not-found-300x225.jpg",
  PRIMARY KEY (`idproduit`)
);

INSERT INTO `produit` (`idproduit`, `nom`, `prix`, `quantite`, `description`, `url`) VALUES 
(1, 'Casque gaming', 24.99, 20, 'Casque gaming lumineux avec suppression de bruit', 'https://www.cdiscount.com/pdt2/5/9/6/1/700x700/auc1933867483596/rw/casque-gamer-ps4-casque-de-jeu-lumineux-avec-micr.jpg'),
(2, 'Clavier Gamer OMOTON', 35.98, 50, 'Clavier rétroéclairé RGB-LED', 'https://m.media-amazon.com/images/I/717ia5lvwcL._AC_SX425_.jpg'),
(3, 'Tapis de souris Eula Genshin Impact', 5.28, 0, 'Tapis de souris en silicone 300x700x2mm', 'https://ae01.alicdn.com/kf/S900263b0e9fe4d7faf274218ef2c3ca35/Grand-tapis-de-souris-de-jeu-Eula-Genshin-Impact-en-Silicone-accessoire-pour-ordinateur-portable-bureau.jpg_Q90.jpg_.webp');


CREATE TABLE `user` (
  `idclient` int(10) NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) NOT NULL,
  `prenom` varchar(45) NOT NULL,
  `mail` varchar(45) NOT NULL,
  `adresse` varchar(45) NOT NULL,
  `role` varchar(45) NOT NULL DEFAULT "client",
  `passer_commande` tinyint NOT NULL DEFAULT 1,
  `payer_commande` tinyint NOT NULL DEFAULT 1,
  `mdp` varchar(45) NOT NULL,
  PRIMARY KEY (`idclient`)
);

INSERT INTO `user` (`idclient`, `nom`, `prenom`, `mail`, `adresse`, `role`, `passer_commande`, `payer_commande`, `mdp`) VALUES 
(1, 'admin', 'admin', 'admin@cy-tech.fr', 'Av. du Parc, 95000 Cergy', 'admin', DEFAULT, DEFAULT, 'Cypjcaaj'),
(2, 'Dupont', 'Jean', 'jean.dupont@gmail.com', '185 rue de Lancry, 75010 Paris', 'client', DEFAULT, DEFAULT, 'azertyuiop'),
(3, 'Dupuit', 'Martin', 'dupuitmart1@yahoo.fr', '350 rue Saint-Guillaume, 75007 Paris', 'client', DEFAULT, DEFAULT, '123456789'),
(4, 'Rochet', 'Lea', 'learochet.yt@gmail.com', '208 rue au Maire, 75003 Paris', 'client', DEFAULT, 0, 'qwerty0000'),
(5, 'Laroche', 'Pierre', 'pierre.lrch@gmail.com', '148 rue du 8 mai 1945, 92000 Nanterre', 'client', 0, 0, 'zaza1234');