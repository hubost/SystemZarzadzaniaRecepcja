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
-- Table structure for table `pokoje`
--

DROP TABLE IF EXISTS `pokoje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pokoje` (
  `id` int NOT NULL AUTO_INCREMENT,
  `numerpokoju` int DEFAULT NULL,
  `ileosob` int DEFAULT NULL,
  `ilelozek` int DEFAULT NULL,
  `cenadoba` varchar(5) DEFAULT NULL,
  `status` varchar(15) DEFAULT NULL,
  `opis` varchar(30) DEFAULT NULL,
  `telewizor` tinyint(1) DEFAULT NULL,
  `wifi` tinyint(1) DEFAULT NULL,
  `toaleta` tinyint(1) DEFAULT NULL,
  `aneks` tinyint(1) DEFAULT NULL,
  `balkon` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pokoje`
--

LOCK TABLES `pokoje` WRITE;
/*!40000 ALTER TABLE `pokoje` DISABLE KEYS */;
INSERT INTO `pokoje` VALUES (1,101,2,1,'350','Wolny','',0,0,0,0,0),(2,102,4,4,'400','Zajety','',0,0,0,0,0),(4,104,1,1,'150','Wolny','',0,0,0,0,0),(5,105,4,2,'250','Wolny','',0,0,0,0,0),(6,107,1,1,'100','Nieczynny','Remont',1,0,0,0,0),(7,108,2,2,'200','Zajety','',1,0,0,0,0),(8,109,3,3,'350','Wolny','',1,1,1,1,1),(9,103,6,6,'670','Wolny','',1,1,1,0,0),(10,106,5,3,'525','Wolny','',1,0,1,0,0),(11,110,3,2,'330','Wolny','',0,0,0,0,0),(12,111,5,5,'550','Zajety','',1,0,1,1,1),(13,112,6,3,'650','Nieczynny','Awaria toalety',1,0,1,1,1),(14,201,1,1,'120','Wolny','',1,0,0,0,0),(15,202,1,1,'140','Zajety','',1,0,0,0,0),(16,203,2,2,'220','Zajety','',0,0,0,0,0),(17,204,2,1,'240','Zajety','',1,1,1,1,0),(18,205,4,4,'410','Wolny','',1,1,0,0,0),(19,301,6,6,'750','Zajety','',1,0,1,1,0),(20,302,5,5,'520','Nieczynny','Awaria toalety',1,1,1,1,1),(21,304,3,2,'320','Wolny','',1,0,0,0,0),(22,120,2,2,'200','Wolny','',1,1,1,1,1),(23,305,4,2,'450','Wolny','',1,0,1,0,1),(24,308,2,2,'200','Wolny','',0,1,0,1,0),(25,214,6,3,'550','Nieczynny','Awaria',0,1,1,1,0),(26,209,2,1,'200','Wolny','',1,0,1,1,0),(27,301,6,6,'750','Zajety','',1,0,1,1,0);
/*!40000 ALTER TABLE `pokoje` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-08-15 16:44:43
