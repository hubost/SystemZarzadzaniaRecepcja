-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: systemzarzadzaniarecepcja
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `rezerwacja`
--

DROP TABLE IF EXISTS `rezerwacja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rezerwacja` (
  `id` int NOT NULL AUTO_INCREMENT,
  `data_od` date DEFAULT NULL,
  `data_do` date DEFAULT NULL,
  `ilosc_dob` int DEFAULT NULL,
  `koszt` int DEFAULT NULL,
  `czy_rozliczona` tinyint(1) DEFAULT NULL,
  `pokoje_id` int NOT NULL,
  `pracownik_id` int NOT NULL,
  `klient_id` int NOT NULL,
  `data_utworzenia` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `rezerwacja_klient_fk` (`klient_id`),
  KEY `rezerwacja_pokoje_fk` (`pokoje_id`),
  KEY `rezerwacja_pracownik_fk` (`pracownik_id`),
  CONSTRAINT `rezerwacja_klient_fk` FOREIGN KEY (`klient_id`) REFERENCES `klient` (`id`),
  CONSTRAINT `rezerwacja_pokoje_fk` FOREIGN KEY (`pokoje_id`) REFERENCES `pokoje` (`id`),
  CONSTRAINT `rezerwacja_pracownik_fk` FOREIGN KEY (`pracownik_id`) REFERENCES `pracownik` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rezerwacja`
--

LOCK TABLES `rezerwacja` WRITE;
/*!40000 ALTER TABLE `rezerwacja` DISABLE KEYS */;
INSERT INTO `rezerwacja` VALUES (5,'2023-01-20','2023-01-22',2,702,1,1,1,4,NULL),(6,'2023-01-23','2023-01-25',2,640,1,21,2,22,NULL),(7,'2023-01-27','2023-01-29',2,1340,1,9,2,24,NULL),(8,'2023-01-28','2023-01-31',3,750,1,5,2,5,NULL),(9,'2023-01-30','2023-01-31',1,120,1,14,2,5,NULL),(10,'2023-02-23','2023-02-25',2,400,0,7,1,8,NULL),(11,'2023-01-26','2023-01-28',2,280,0,15,1,9,NULL),(12,'2023-01-23','2023-01-25',2,440,0,16,2,7,NULL),(13,'2023-01-25','2023-01-27',2,660,1,11,2,11,NULL),(14,'2023-01-27','2023-01-28',1,550,0,12,2,20,NULL),(15,'2023-01-27','2023-01-29',2,800,0,2,2,23,NULL),(16,'2023-01-23','2023-01-25',2,480,0,17,1,25,NULL),(17,'2023-01-23','2023-01-25',2,700,1,1,1,18,NULL),(18,'2023-01-21','2023-01-24',3,1050,1,1,1,27,NULL),(20,'2023-01-27','2023-01-29',2,700,1,1,13,30,NULL),(21,'2023-01-25','2023-01-27',2,240,1,14,13,30,'2023-01-24'),(22,'2023-01-26','2023-01-27',1,250,1,5,1,11,'2023-01-25'),(23,'2023-01-26','2023-01-28',2,700,1,8,1,21,'2023-01-25'),(24,'2023-01-27','2023-01-28',1,410,1,18,2,32,'2023-01-25'),(25,'2023-02-25','2023-02-26',1,200,1,22,15,33,'2023-02-24'),(26,'2023-02-26','2023-02-27',1,330,1,11,1,33,'2023-02-25'),(27,'2023-04-12','2023-04-14',2,400,1,22,16,33,'2023-04-10'),(28,'2023-04-15','2023-04-16',1,320,1,21,17,35,'2023-04-13'),(29,'2023-04-22','2023-04-24',2,820,1,18,18,36,'2023-04-15');
/*!40000 ALTER TABLE `rezerwacja` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-08-15 16:44:42
