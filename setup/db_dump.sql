-- MariaDB dump 10.19  Distrib 10.9.4-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: wwChallenge
-- ------------------------------------------------------
-- Server version	8.0.30-22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `child`
--

DROP TABLE IF EXISTS `child`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `child` (
  `dtype` varchar(31) NOT NULL,
  `id` bigint NOT NULL,
  `age` int DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `hair_color` varchar(255) DEFAULT NULL,
  `bicycle_color` varchar(255) DEFAULT NULL,
  `parent_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKo11vo1p67t0u4wb7q7jtayng6` (`parent_id`),
  CONSTRAINT `FKo11vo1p67t0u4wb7q7jtayng6` FOREIGN KEY (`parent_id`) REFERENCES `person` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `child`
--

LOCK TABLES `child` WRITE;
/*!40000 ALTER TABLE `child` DISABLE KEYS */;
INSERT INTO `child` VALUES
('Daughter',1,3,'Vale Jiselle','red',NULL,3),
('Son',2,5,'Tremayne Dennie ',NULL,'gray',4),
('Son',3,5,'Jeffrey Paul ','','gray',4),
('Daughter',4,43,'Hadleigh Betty ','green',NULL,5),
('Daughter',6,7,'Holley Kim ','purple',NULL,4),
('Son',7,6,'Ed Leland ',NULL,'dark gray',4);
/*!40000 ALTER TABLE `child` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `child_favorite_meals`
--

DROP TABLE IF EXISTS `child_favorite_meals`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `child_favorite_meals` (
  `child_id` bigint NOT NULL,
  `meal_id` bigint NOT NULL,
  `favorite_meals_order` int NOT NULL,
  PRIMARY KEY (`child_id`,`favorite_meals_order`),
  KEY `FK72lj99ot1jmtlaywuylyo331c` (`meal_id`),
  CONSTRAINT `FK72lj99ot1jmtlaywuylyo331c` FOREIGN KEY (`meal_id`) REFERENCES `meal` (`id`),
  CONSTRAINT `FKp73y6cx64ve779hay4t5eq60h` FOREIGN KEY (`child_id`) REFERENCES `child` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `child_favorite_meals`
--

LOCK TABLES `child_favorite_meals` WRITE;
/*!40000 ALTER TABLE `child_favorite_meals` DISABLE KEYS */;
INSERT INTO `child_favorite_meals` VALUES
(1,1,0),
(1,2,1),
(2,2,0);
/*!40000 ALTER TABLE `child_favorite_meals` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `child_seq`
--

DROP TABLE IF EXISTS `child_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `child_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `child_seq`
--

LOCK TABLES `child_seq` WRITE;
/*!40000 ALTER TABLE `child_seq` DISABLE KEYS */;
INSERT INTO `child_seq` VALUES
(7);
/*!40000 ALTER TABLE `child_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `house`
--

DROP TABLE IF EXISTS `house`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `house` (
  `id` bigint NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `type` smallint DEFAULT NULL,
  `zip_code` varchar(255) DEFAULT NULL,
  `person_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkldmkahebcv2wk4tm83o4avup` (`person_id`),
  CONSTRAINT `FKkldmkahebcv2wk4tm83o4avup` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `house`
--

LOCK TABLES `house` WRITE;
/*!40000 ALTER TABLE `house` DISABLE KEYS */;
INSERT INTO `house` VALUES
(1,'Kemper Lane',0,'1344',3),
(2,'Flanigan Oaks Drive 45b',1,'4597',4),
(3,'Pearl Street 4',2,'4074',5);
/*!40000 ALTER TABLE `house` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `house_seq`
--

DROP TABLE IF EXISTS `house_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `house_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `house_seq`
--

LOCK TABLES `house_seq` WRITE;
/*!40000 ALTER TABLE `house_seq` DISABLE KEYS */;
INSERT INTO `house_seq` VALUES
(4);
/*!40000 ALTER TABLE `house_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `meal`
--

DROP TABLE IF EXISTS `meal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `meal` (
  `id` bigint NOT NULL,
  `invented` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meal`
--

LOCK TABLES `meal` WRITE;
/*!40000 ALTER TABLE `meal` DISABLE KEYS */;
INSERT INTO `meal` VALUES
(1,'1700-05-11 12:43:14.227000','Pizza Napoletana'),
(2,'2022-12-17 13:54:57.907000','Chocolate with boiled eggs');
/*!40000 ALTER TABLE `meal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `meal_seq`
--

DROP TABLE IF EXISTS `meal_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `meal_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meal_seq`
--

LOCK TABLES `meal_seq` WRITE;
/*!40000 ALTER TABLE `meal_seq` DISABLE KEYS */;
INSERT INTO `meal_seq` VALUES
(3);
/*!40000 ALTER TABLE `meal_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parent_summary`
--

DROP TABLE IF EXISTS `parent_summary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parent_summary` (
  `id` bigint NOT NULL,
  `amount_of_children` bigint DEFAULT NULL,
  `amount_of_persons` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_iepco9dcmfmsg2t63smqi6uh` (`amount_of_persons`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parent_summary`
--

LOCK TABLES `parent_summary` WRITE;
/*!40000 ALTER TABLE `parent_summary` DISABLE KEYS */;
INSERT INTO `parent_summary` VALUES
(1,1,2),
(2,4,1);
/*!40000 ALTER TABLE `parent_summary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parent_summary_seq`
--

DROP TABLE IF EXISTS `parent_summary_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parent_summary_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parent_summary_seq`
--

LOCK TABLES `parent_summary_seq` WRITE;
/*!40000 ALTER TABLE `parent_summary_seq` DISABLE KEYS */;
INSERT INTO `parent_summary_seq` VALUES
(3);
/*!40000 ALTER TABLE `parent_summary_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person` (
  `id` bigint NOT NULL,
  `age` int DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `house_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6fe2v09hiovxvythi1tpg0igb` (`house_id`),
  CONSTRAINT `FK6fe2v09hiovxvythi1tpg0igb` FOREIGN KEY (`house_id`) REFERENCES `house` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES
(3,45,'person1',1),
(4,33,'person2',1),
(5,56,'person3',1);
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person_seq`
--

DROP TABLE IF EXISTS `person_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person_seq`
--

LOCK TABLES `person_seq` WRITE;
/*!40000 ALTER TABLE `person_seq` DISABLE KEYS */;
INSERT INTO `person_seq` VALUES
(5);
/*!40000 ALTER TABLE `person_seq` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-18 21:46:38
