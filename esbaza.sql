/*
SQLyog Community v11.51 (32 bit)
MySQL - 5.6.17 : Database - inteligentnisistemi
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`inteligentnisistemi` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `inteligentnisistemi`;

/*Table structure for table `kosarkas` */

DROP TABLE IF EXISTS `kosarkas`;

CREATE TABLE `kosarkas` (
  `id` int(5) NOT NULL,
  `ime` varchar(50) DEFAULT NULL,
  `prezime` varchar(50) DEFAULT NULL,
  `pozicija` varchar(50) DEFAULT NULL,
  `visina` int(5) DEFAULT NULL,
  `tezina` int(5) DEFAULT NULL,
  `kvalitetOdbranbeneIgre` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `kosarkas` */

insert  into `kosarkas`(`id`,`ime`,`prezime`,`pozicija`,`visina`,`tezina`,`kvalitetOdbranbeneIgre`) values (1,'TARENCE','KINSEY','bek',198,84,'odlican'),(2,'NEMANJA','DANGUBIC','krilo',204,88,'odlican'),(3,'LUKA','MITROVIC','krilni centar',206,102,'solidan'),(4,'VLADIMIR','STIMAC','centar',211,116,'los'),(5,'MAIK','CIRBES','centar',208,115,'dobar'),(6,'QUINCY','MILLER','krilni centar',208,107,'solidan'),(7,'MARKO','GUDURIC','krilo',199,91,'dobar'),(8,'MARKO','SIMONOVIC','krilo',205,93,'odlican'),(9,'STEFAN','JOVIC','plej',198,94,'solidan'),(10,'VASILIJE','MICIC','plej',195,92,'plej'),(11,'NIKOLA','REBIC','krilni centar/centar',206,107,'dobar'),(12,'BRANKO','LAZIC','plej/bek',196,91,'odlican'),(13,'NANDO','DE COLO','plej',196,91,'solidan'),(14,'AARON','JACKSON','bek',191,83,'dobar'),(15,'VITALY','FRIDZON','krilo',195,81,'odlican'),(16,'ANDREY','VORONTSEVICH','krilni centar',207,107,'odlican');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
