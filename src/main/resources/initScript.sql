SET GLOBAL time_zone = '-3:00';

CREATE DATABASE  IF NOT EXISTS `devops_login`;
USE `devops_login`;

CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) NOT NULL,
  `pass` varchar(100) NOT NULL,
  `fullName` varchar(100) NOT NULL,  
  PRIMARY KEY (`id`)
);

INSERT INTO `user` VALUES (1,'danip','123','Daniela Perez'),(2,'juanl','456','Juan Lopez'),(3,'carog','789','Carolina García');