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
-- Table structure for table `klient`
--

DROP TABLE IF EXISTS `klient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `klient` (
  `id` int NOT NULL AUTO_INCREMENT,
  `imie` varchar(30) DEFAULT NULL,
  `nazwisko` varchar(30) DEFAULT NULL,
  `plec` varchar(1) DEFAULT NULL,
  `pesel` varchar(11) DEFAULT NULL,
  `numerdowodu` varchar(30) DEFAULT NULL,
  `numertelefonu` varchar(9) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `data_utworzenia` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `klient__un` (`pesel`,`numerdowodu`,`email`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `klient`
--

LOCK TABLES `klient` WRITE;
/*!40000 ALTER TABLE `klient` DISABLE KEYS */;
INSERT INTO `klient` VALUES (1,'Hubert','Ostrowski','m','99702500000','ABC123456','999888777','email@email.com','2023-01-12'),(3,'Adam','Kalinowski','k','85092618519','ABC123459','888666222','mailtest@mail.com','2023-01-12'),(4,'Ewelina','Nowak','k','89110372713','CDE199999','482903192','ewenow@mail.com','2023-01-12'),(5,'Jan','Nowak','k','94050313988','XYZ123456','888000111','hubert.ostrowski@gmail.com','2023-01-12'),(6,'Leo','Ostrowski','k','49122618784','DFG204020','482122310','leotest@mail.com','2023-01-12'),(7,'Adam','Nowak','k','74012811437','ABC100000','888200194','anowak@mail.com','2023-01-12'),(8,'Jakub','Polski','k','67042296675','DBF102934','123994201','emailjakub@mail.com','2023-01-12'),(9,'Norbert','Kowalski','k','91080914648','DFG010101','754021023','emailnk@mail.com','2023-01-12'),(10,'Elżbieta','Nowak','k','72040357455','ABC920132','724010101','enowak@mail.com','2023-01-12'),(11,'Adam','Nowacki','k','77122733532','iop912365','902129322','anowacki@mail.com','2023-01-12'),(17,'Błażej','Włodecki','m','99072500159','PPW192001','293452191','bwlod@mail.com','2023-01-13'),(18,'Piotr','Nowakowski','m','70072245115','PUG740626','840291352','pnowak@mail.com','2023-01-21'),(19,'Gracjan','Wiliński','m','71052911192','DQL044642','892040135','gwilinski@mail.com','2023-01-21'),(20,'Mariusz','Szczepański','m','53052982336','USN656231','820492555','marszczepan@mail.com','2023-01-21'),(21,'Iwona','Świetlik','k','99030155455','WDY820135','982000521','iswietlik@mail.com','2023-01-21'),(22,'Jadwiga','Schmidt','k','64091792275','FMX491226','872010727','jaschmidt@mail.com','2023-01-21'),(23,'Damian','Jędrzejczyk','m','58100644514','EPL993931','772481074','djedrzejczyk@mail.com','2023-01-21'),(24,'Kacper','Kowalski','m','66103118318','HYU396465','888727450','kkowal@mail.com','2023-01-21'),(25,'Agata','Sahin','k','66103118318','UIG840745','567828010','asahin@mail.com','2023-01-21'),(26,'Daria','Bogucka','k','72081976431','YYG090421','901492888','dbogucka@mail.com','2023-01-21'),(27,'Paweł ','Świetlik','m','99112000494','SAP929301','742838291','pswietliczek@mail.com','2023-01-21'),(28,'Piotr','Nowicki','m','99072511329','DBD992030','784202302','pnowicki@mail.com','2023-01-23'),(29,'Adam','Wiśniewski','m','99072500124','ABC283421','509242333','awisniewski@mail.com','2023-01-23'),(30,'Klaudia ','Marszal','k','98082378321','DBD829321','691203242','kmarszal@mail.com','2023-01-24'),(31,'Jonasz','Mazowiecki','m','98070200321','DYP820390','999232573','jmazow@mail.com','2023-01-25'),(32,'Jeremi','Świątek','k','97010300393','DAW829030','723949201','jswiatek@mail.com','2023-01-25'),(33,'Jan','Nowacki','m','99082500321','DBD691302','982891049','jannowacki@mail.com','2023-02-24'),(35,'Damian','Manikowski','m','99072500300','DBD12399','997204932','dmanikok@mai.com','2023-04-13'),(36,'Hubert','Ostrowski','k','99072500302','ABC823913','842032189','hubostrowski@mail.com','2023-04-15');
/*!40000 ALTER TABLE `klient` ENABLE KEYS */;
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
