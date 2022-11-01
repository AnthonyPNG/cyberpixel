CREATE DATABASE IF NOT EXISTS `CyberPixel` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `CyberPixel`;

CREATE TABLE `cb` (
  `num` int NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL,
  `cryptogramme` int DEFAULT NULL,
  `solde` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`num`)
);

CREATE TABLE `produit` (
  `idproduit` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(100) DEFAULT NULL,
  `prix` decimal(10,2) DEFAULT NULL,
  `quantite` int DEFAULT NULL,
  `description` varchar(10000) DEFAULT NULL,
  `url` varchar(10000),
  PRIMARY KEY (`idproduit`)
);

CREATE TABLE `user` (
  `idclient` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) NOT NULL,
  `prenom` varchar(45) NOT NULL,
  `mail` varchar(45) NOT NULL,
  `adresse` varchar(45) NOT NULL,
  `estconnecte` tinyint DEFAULT NULL,
  `role` varchar(45) NOT NULL,
  `passer_commande` tinyint DEFAULT NULL,
  `payer_commande` tinyint DEFAULT NULL,
  `mdp` varchar(45) NOT NULL,
  PRIMARY KEY (`idclient`)
);
