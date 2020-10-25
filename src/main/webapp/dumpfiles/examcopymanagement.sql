-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: examcopymanagement
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `alloted_copies`
--

DROP TABLE IF EXISTS `alloted_copies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alloted_copies` (
  `enrollment_no` int NOT NULL,
  `serial_no` int DEFAULT NULL,
  PRIMARY KEY (`enrollment_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alloted_copies`
--

LOCK TABLES `alloted_copies` WRITE;
/*!40000 ALTER TABLE `alloted_copies` DISABLE KEYS */;
/*!40000 ALTER TABLE `alloted_copies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detailed_info_cs`
--

DROP TABLE IF EXISTS `detailed_info_cs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detailed_info_cs` (
  `id` int NOT NULL,
  `enrollment_no` varchar(255) DEFAULT NULL,
  `foo` varchar(255) DEFAULT NULL,
  `foo1` varchar(255) DEFAULT NULL,
  `foo2` varchar(255) DEFAULT NULL,
  `foo3` varchar(255) DEFAULT NULL,
  `foo4` varchar(255) DEFAULT NULL,
  `foo5` varchar(255) DEFAULT NULL,
  `foo6` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detailed_info_cs`
--

LOCK TABLES `detailed_info_cs` WRITE;
/*!40000 ALTER TABLE `detailed_info_cs` DISABLE KEYS */;
INSERT INTO `detailed_info_cs` VALUES (0,'ENROLLMENT NO',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1,'0808CS171001',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,'0808CS171002',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,'0808CS171003',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(4,'0808CS171004',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(5,'0808CS171005',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'0808CS171006',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'0808CS171007',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'0808CS171008',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(9,'0808CS171009',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(10,'0808CS171010',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(11,'0808CS171011',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(12,'0808CS171012',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(13,'0808CS171013',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(14,'0808CS171014',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(15,'0808CS171015',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(16,'0808CS171016',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(17,'0808CS171017',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(18,'0808CS171018',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(19,'0808CS171019',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(20,'0808CS171020',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(21,'0808CS171021',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(22,'0808CS171022',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(23,'0808CS171023',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(24,'0808CS171024',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(25,'0808CS171025',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(26,'0808CS171026',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(27,'0808CS171027',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(28,'0808CS171028',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(29,'0808CS171029',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(30,'0808CS171030',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(31,'0808CS171031',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(32,'0808CS171032',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(33,'0808CS171033',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(34,'0808CS171034',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(35,'0808CS171035',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(36,'0808CS171036',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(37,'0808CS171037',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(38,'0808CS171038',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(39,'0808CS171039',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(40,'0808CS171040',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(41,'0808CS171041',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(42,'0808CS171042',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(43,'0808CS171043',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(44,'0808CS171044',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(45,'0808CS171045',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(46,'0808CS171046',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(47,'0808CS171047',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(48,'0808CS171048',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(49,'0808CS171049',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(50,'0808CS171050',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(51,'0808CS171051',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(52,'0808CS171052',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(53,'0808CS171053',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(54,'0808CS171054',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(55,'0808CS171055',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(56,'0808CS171056',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(57,'0808CS171057',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(58,'0808CS171058',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(59,'0808CS171059',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(60,'0808CS171060',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(61,'0808CS171061',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(62,'0808CS171062',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(63,'0808CS171063',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(64,'0808CS171064',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(65,'0808CS171065',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(66,'0808CS171066',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(67,'0808CS171067',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(68,'0808CS171068',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(69,'0808CS171069',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(70,'0808CS171070',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(71,'0808CS171071',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(72,'0808CS171072',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(73,'0808CS171073',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(74,'0808CS171074',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(75,'0808CS171075',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(76,'0808CS171076',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(77,'0808CS171077',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(78,'0808CS171078',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(79,'0808CS171079',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(80,'0808CS171080',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(81,'0808CS171081',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(82,'0808CS171082',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(83,'0808CS171083',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(84,'0808CS171084',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(85,'0808CS171085',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(86,'0808CS171086',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(87,'0808CS171087',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(88,'0808CS171088',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(89,'0808CS171089',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(90,'0808CS171090',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(91,'0808CS171091',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(92,'0808CS171092',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(93,'0808CS171093',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(94,'0808CS171094',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(95,'0808CS171095',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(96,'0808CS171096',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(97,'0808CS171097',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(98,'0808CS171098',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(99,'0808CS171099',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(100,'0808CS171100',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(101,'0808CS171101',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(102,'0808CS171102',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(103,'0808CS171103',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(104,'0808CS171104',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(105,'0808CS171105',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(106,'0808CS171106',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(107,'0808CS171107',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(108,'0808CS171108',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(109,'0808CS171109',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(110,'0808CS171110',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(111,'0808CS171111',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(112,'0808CS171112',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(113,'0808CS171113',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(114,'0808CS171114',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(115,'0808CS171115',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(116,'0808CS171116',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(117,'0808CS171117',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(118,'0808CS171118',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(119,'0808CS171119',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(120,'0808CS171120',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(121,'0808CS171121',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(122,'0808CS171122',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(123,'0808CS171123',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(124,'0808CS171124',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(125,'0808CS171125',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(126,'0808CS171126',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(127,'0808CS171127',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(128,'0808CS171128',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(129,'0808CS171129',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(130,'0808CS171130',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(131,'0808CS171131',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(132,'0808CS171132',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(133,'0808CS171133',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(134,'0808CS171134',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(135,'0808CS171135',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(136,'0808CS171136',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(137,'0808CS171137',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(138,'0808CS171138',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(139,'0808CS171139',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(140,'0808CS171140',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(141,'0808CS171141',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(142,'0808CS171142',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(143,'0808CS171143',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(144,'0808CS171144',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(145,'0808CS171145',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(146,'0808CS171146',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(147,'0808CS171147',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(148,'0808CS171148',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(149,'0808CS171149',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(150,'0808CS171150',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(151,'0808CS171151',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(152,'0808CS171152',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(153,'0808CS171153',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(154,'0808CS171154',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(155,'0808CS171155',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(156,'0808CS171156',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(157,'0808CS171157',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(158,'0808CS171158',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(159,'0808CS171159',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(160,'0808CS171160',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(161,'0808CS171161',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(162,'0808CS171162',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(163,'0808CS171163',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(164,'0808CS171164',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(165,'0808CS171165',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(166,'0808CS171166',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(167,'0808CS171167',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(168,'0808CS171168',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(169,'0808CS171169',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(170,'0808CS171170',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(171,'0808CS171171',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(172,'0808CS171172',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(173,'0808CS171173',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(174,'0808CS171174',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(175,'0808CS171175',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(176,'0808CS171176',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(177,'0808CS171177',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(178,'0808CS171178',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(179,'0808CS171179',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(180,'0808CS171180',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `detailed_info_cs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detailed_info_me`
--

DROP TABLE IF EXISTS `detailed_info_me`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detailed_info_me` (
  `id` int NOT NULL,
  `enrollment_no` varchar(255) DEFAULT NULL,
  `foo` varchar(255) DEFAULT NULL,
  `foo1` varchar(255) DEFAULT NULL,
  `foo2` varchar(255) DEFAULT NULL,
  `foo3` varchar(255) DEFAULT NULL,
  `foo4` varchar(255) DEFAULT NULL,
  `foo5` varchar(255) DEFAULT NULL,
  `foo6` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detailed_info_me`
--

LOCK TABLES `detailed_info_me` WRITE;
/*!40000 ALTER TABLE `detailed_info_me` DISABLE KEYS */;
INSERT INTO `detailed_info_me` VALUES (0,'ENROLLMENT NO','2020-03-24',NULL,NULL,NULL,NULL,NULL,NULL),(1,'0808ME171001','10000',NULL,NULL,NULL,NULL,NULL,NULL),(2,'0808ME171002','10001',NULL,NULL,NULL,NULL,NULL,NULL),(3,'0808ME171003','10002',NULL,NULL,NULL,NULL,NULL,NULL),(4,'0808ME171004','10003',NULL,NULL,NULL,NULL,NULL,NULL),(5,'0808ME171005','10004',NULL,NULL,NULL,NULL,NULL,NULL),(6,'0808ME171006','10005',NULL,NULL,NULL,NULL,NULL,NULL),(7,'0808ME171007','10006',NULL,NULL,NULL,NULL,NULL,NULL),(8,'0808ME171008','10007',NULL,NULL,NULL,NULL,NULL,NULL),(9,'0808ME171009','10008',NULL,NULL,NULL,NULL,NULL,NULL),(10,'0808ME171010','10009',NULL,NULL,NULL,NULL,NULL,NULL),(11,'0808ME171011','10010',NULL,NULL,NULL,NULL,NULL,NULL),(12,'0808ME171012','10011',NULL,NULL,NULL,NULL,NULL,NULL),(13,'0808ME171013','10012',NULL,NULL,NULL,NULL,NULL,NULL),(14,'0808ME171014','10013',NULL,NULL,NULL,NULL,NULL,NULL),(15,'0808ME171015','10014',NULL,NULL,NULL,NULL,NULL,NULL),(16,'0808ME171016','10015',NULL,NULL,NULL,NULL,NULL,NULL),(17,'0808ME171017','10016',NULL,NULL,NULL,NULL,NULL,NULL),(18,'0808ME171018','10017',NULL,NULL,NULL,NULL,NULL,NULL),(19,'0808ME171019','10018',NULL,NULL,NULL,NULL,NULL,NULL),(20,'0808ME171020','10019',NULL,NULL,NULL,NULL,NULL,NULL),(21,'0808ME171021','10020',NULL,NULL,NULL,NULL,NULL,NULL),(22,'0808ME171022','10021',NULL,NULL,NULL,NULL,NULL,NULL),(23,'0808ME171023','10022',NULL,NULL,NULL,NULL,NULL,NULL),(24,'0808ME171024','10023',NULL,NULL,NULL,NULL,NULL,NULL),(25,'0808ME171025','10024',NULL,NULL,NULL,NULL,NULL,NULL),(26,'0808ME171026','10025',NULL,NULL,NULL,NULL,NULL,NULL),(27,'0808ME171027','10026',NULL,NULL,NULL,NULL,NULL,NULL),(28,'0808ME171028','10027',NULL,NULL,NULL,NULL,NULL,NULL),(29,'0808ME171029','10028',NULL,NULL,NULL,NULL,NULL,NULL),(30,'0808ME171030','10029',NULL,NULL,NULL,NULL,NULL,NULL),(31,'0808ME171031','10030',NULL,NULL,NULL,NULL,NULL,NULL),(32,'0808ME171032','10031',NULL,NULL,NULL,NULL,NULL,NULL),(33,'0808ME171033','10032',NULL,NULL,NULL,NULL,NULL,NULL),(34,'0808ME171034','10033',NULL,NULL,NULL,NULL,NULL,NULL),(35,'0808ME171035','10034',NULL,NULL,NULL,NULL,NULL,NULL),(36,'0808ME171036','10035',NULL,NULL,NULL,NULL,NULL,NULL),(37,'0808ME171037','10036',NULL,NULL,NULL,NULL,NULL,NULL),(38,'0808ME171038','10037',NULL,NULL,NULL,NULL,NULL,NULL),(39,'0808ME171039','10038',NULL,NULL,NULL,NULL,NULL,NULL),(40,'0808ME171040','10039',NULL,NULL,NULL,NULL,NULL,NULL),(41,'0808ME171041','10040',NULL,NULL,NULL,NULL,NULL,NULL),(42,'0808ME171042','10041',NULL,NULL,NULL,NULL,NULL,NULL),(43,'0808ME171043','10042',NULL,NULL,NULL,NULL,NULL,NULL),(44,'0808ME171044','10043',NULL,NULL,NULL,NULL,NULL,NULL),(45,'0808ME171045','10044',NULL,NULL,NULL,NULL,NULL,NULL),(46,'0808ME171046','10045',NULL,NULL,NULL,NULL,NULL,NULL),(47,'0808ME171047','10046',NULL,NULL,NULL,NULL,NULL,NULL),(48,'0808ME171048','10047',NULL,NULL,NULL,NULL,NULL,NULL),(49,'0808ME171049','10048',NULL,NULL,NULL,NULL,NULL,NULL),(50,'0808ME171050','10049',NULL,NULL,NULL,NULL,NULL,NULL),(51,'0808ME171051','10050',NULL,NULL,NULL,NULL,NULL,NULL),(52,'0808ME171052','10051',NULL,NULL,NULL,NULL,NULL,NULL),(53,'0808ME171053','10052',NULL,NULL,NULL,NULL,NULL,NULL),(54,'0808ME171054','10053',NULL,NULL,NULL,NULL,NULL,NULL),(55,'0808ME171055','10054',NULL,NULL,NULL,NULL,NULL,NULL),(56,'0808ME171056','10055',NULL,NULL,NULL,NULL,NULL,NULL),(57,'0808ME171057','10056',NULL,NULL,NULL,NULL,NULL,NULL),(58,'0808ME171058','10057',NULL,NULL,NULL,NULL,NULL,NULL),(59,'0808ME171059','10058',NULL,NULL,NULL,NULL,NULL,NULL),(60,'0808ME171060','10059',NULL,NULL,NULL,NULL,NULL,NULL),(61,'0808ME171061','10060',NULL,NULL,NULL,NULL,NULL,NULL),(62,'0808ME171062','10061',NULL,NULL,NULL,NULL,NULL,NULL),(63,'0808ME171063','10062',NULL,NULL,NULL,NULL,NULL,NULL),(64,'0808ME171064','10063',NULL,NULL,NULL,NULL,NULL,NULL),(65,'0808ME171065','10064',NULL,NULL,NULL,NULL,NULL,NULL),(66,'0808ME171066','10065',NULL,NULL,NULL,NULL,NULL,NULL),(67,'0808ME171067','10066',NULL,NULL,NULL,NULL,NULL,NULL),(68,'0808ME171068','10067',NULL,NULL,NULL,NULL,NULL,NULL),(69,'0808ME171069','10068',NULL,NULL,NULL,NULL,NULL,NULL),(70,'0808ME171070','10069',NULL,NULL,NULL,NULL,NULL,NULL),(71,'0808ME171071','10070',NULL,NULL,NULL,NULL,NULL,NULL),(72,'0808ME171072','10071',NULL,NULL,NULL,NULL,NULL,NULL),(73,'0808ME171073','10072',NULL,NULL,NULL,NULL,NULL,NULL),(74,'0808ME171074','10073',NULL,NULL,NULL,NULL,NULL,NULL),(75,'0808ME171075','10074',NULL,NULL,NULL,NULL,NULL,NULL),(76,'0808ME171076','10075',NULL,NULL,NULL,NULL,NULL,NULL),(77,'0808ME171077','10076',NULL,NULL,NULL,NULL,NULL,NULL),(78,'0808ME171078','10077',NULL,NULL,NULL,NULL,NULL,NULL),(79,'0808ME171079','10078',NULL,NULL,NULL,NULL,NULL,NULL),(80,'0808ME171080','10079',NULL,NULL,NULL,NULL,NULL,NULL),(81,'0808ME171081','10080',NULL,NULL,NULL,NULL,NULL,NULL),(82,'0808ME171082','10081',NULL,NULL,NULL,NULL,NULL,NULL),(83,'0808ME171083','10082',NULL,NULL,NULL,NULL,NULL,NULL),(84,'0808ME171084','10083',NULL,NULL,NULL,NULL,NULL,NULL),(85,'0808ME171085','10084',NULL,NULL,NULL,NULL,NULL,NULL),(86,'0808ME171086','10085',NULL,NULL,NULL,NULL,NULL,NULL),(87,'0808ME171087','10086',NULL,NULL,NULL,NULL,NULL,NULL),(88,'0808ME171088','10087',NULL,NULL,NULL,NULL,NULL,NULL),(89,'0808ME171089','10088',NULL,NULL,NULL,NULL,NULL,NULL),(90,'0808ME171090','10089',NULL,NULL,NULL,NULL,NULL,NULL),(91,'0808ME171091','10090',NULL,NULL,NULL,NULL,NULL,NULL),(92,'0808ME171092','10091',NULL,NULL,NULL,NULL,NULL,NULL),(93,'0808ME171093','10092',NULL,NULL,NULL,NULL,NULL,NULL),(94,'0808ME171094','10093',NULL,NULL,NULL,NULL,NULL,NULL),(95,'0808ME171095','10094',NULL,NULL,NULL,NULL,NULL,NULL),(96,'0808ME171096','10095',NULL,NULL,NULL,NULL,NULL,NULL),(97,'0808ME171097','10096',NULL,NULL,NULL,NULL,NULL,NULL),(98,'0808ME171098','10097',NULL,NULL,NULL,NULL,NULL,NULL),(99,'0808ME171099','10098',NULL,NULL,NULL,NULL,NULL,NULL),(100,'0808ME171100','10099',NULL,NULL,NULL,NULL,NULL,NULL),(101,'0808ME171101','10100',NULL,NULL,NULL,NULL,NULL,NULL),(102,'0808ME171102','10101',NULL,NULL,NULL,NULL,NULL,NULL),(103,'0808ME171103','10102',NULL,NULL,NULL,NULL,NULL,NULL),(104,'0808ME171104','10103',NULL,NULL,NULL,NULL,NULL,NULL),(105,'0808ME171105','10104',NULL,NULL,NULL,NULL,NULL,NULL),(106,'0808ME171106','10105',NULL,NULL,NULL,NULL,NULL,NULL),(107,'0808ME171107','10106',NULL,NULL,NULL,NULL,NULL,NULL),(108,'0808ME171108','10107',NULL,NULL,NULL,NULL,NULL,NULL),(109,'0808ME171109','10108',NULL,NULL,NULL,NULL,NULL,NULL),(110,'0808ME171110','10109',NULL,NULL,NULL,NULL,NULL,NULL),(111,'0808ME171111','10110',NULL,NULL,NULL,NULL,NULL,NULL),(112,'0808ME171112','10111',NULL,NULL,NULL,NULL,NULL,NULL),(113,'0808ME171113','10112',NULL,NULL,NULL,NULL,NULL,NULL),(114,'0808ME171114','10113',NULL,NULL,NULL,NULL,NULL,NULL),(115,'0808ME171115','10114',NULL,NULL,NULL,NULL,NULL,NULL),(116,'0808ME171116','10115',NULL,NULL,NULL,NULL,NULL,NULL),(117,'0808ME171117','10116',NULL,NULL,NULL,NULL,NULL,NULL),(118,'0808ME171118','10117',NULL,NULL,NULL,NULL,NULL,NULL),(119,'0808ME171119','10118',NULL,NULL,NULL,NULL,NULL,NULL),(120,'0808ME171120','10119',NULL,NULL,NULL,NULL,NULL,NULL),(121,'0808ME171121','10120',NULL,NULL,NULL,NULL,NULL,NULL),(122,'0808ME171122','10121',NULL,NULL,NULL,NULL,NULL,NULL),(123,'0808ME171123','10122',NULL,NULL,NULL,NULL,NULL,NULL),(124,'0808ME171124','10123',NULL,NULL,NULL,NULL,NULL,NULL),(125,'0808ME171125','10124',NULL,NULL,NULL,NULL,NULL,NULL),(126,'0808ME171126','10125',NULL,NULL,NULL,NULL,NULL,NULL),(127,'0808ME171127','10126',NULL,NULL,NULL,NULL,NULL,NULL),(128,'0808ME171128','10127',NULL,NULL,NULL,NULL,NULL,NULL),(129,'0808ME171129','10128',NULL,NULL,NULL,NULL,NULL,NULL),(130,'0808ME171130','10129',NULL,NULL,NULL,NULL,NULL,NULL),(131,'0808ME171131','10130',NULL,NULL,NULL,NULL,NULL,NULL),(132,'0808ME171132','10131',NULL,NULL,NULL,NULL,NULL,NULL),(133,'0808ME171133','10132',NULL,NULL,NULL,NULL,NULL,NULL),(134,'0808ME171134','10133',NULL,NULL,NULL,NULL,NULL,NULL),(135,'0808ME171135','10134',NULL,NULL,NULL,NULL,NULL,NULL),(136,'0808ME171136','10135',NULL,NULL,NULL,NULL,NULL,NULL),(137,'0808ME171137','10136',NULL,NULL,NULL,NULL,NULL,NULL),(138,'0808ME171138','10137',NULL,NULL,NULL,NULL,NULL,NULL),(139,'0808ME171139','10138',NULL,NULL,NULL,NULL,NULL,NULL),(140,'0808ME171140','10139',NULL,NULL,NULL,NULL,NULL,NULL),(141,'0808ME171141','10140',NULL,NULL,NULL,NULL,NULL,NULL),(142,'0808ME171142','10141',NULL,NULL,NULL,NULL,NULL,NULL),(143,'0808ME171143','10142',NULL,NULL,NULL,NULL,NULL,NULL),(144,'0808ME171144','10143',NULL,NULL,NULL,NULL,NULL,NULL),(145,'0808ME171145','10144',NULL,NULL,NULL,NULL,NULL,NULL),(146,'0808ME171146','10145',NULL,NULL,NULL,NULL,NULL,NULL),(147,'0808ME171147','10146',NULL,NULL,NULL,NULL,NULL,NULL),(148,'0808ME171148','10147',NULL,NULL,NULL,NULL,NULL,NULL),(149,'0808ME171149','10148',NULL,NULL,NULL,NULL,NULL,NULL),(150,'0808ME171150','10149',NULL,NULL,NULL,NULL,NULL,NULL),(151,'0808ME171151','10150',NULL,NULL,NULL,NULL,NULL,NULL),(152,'0808ME171152','10151',NULL,NULL,NULL,NULL,NULL,NULL),(153,'0808ME171153','10152',NULL,NULL,NULL,NULL,NULL,NULL),(154,'0808ME171154','10153',NULL,NULL,NULL,NULL,NULL,NULL),(155,'0808ME171155','10154',NULL,NULL,NULL,NULL,NULL,NULL),(156,'0808ME171156','10155',NULL,NULL,NULL,NULL,NULL,NULL),(157,'0808ME171157','10156',NULL,NULL,NULL,NULL,NULL,NULL),(158,'0808ME171158','10157',NULL,NULL,NULL,NULL,NULL,NULL),(159,'0808ME171159','10158',NULL,NULL,NULL,NULL,NULL,NULL),(160,'0808ME171160','10159',NULL,NULL,NULL,NULL,NULL,NULL),(161,'0808ME171161','10160',NULL,NULL,NULL,NULL,NULL,NULL),(162,'0808ME171162','10161',NULL,NULL,NULL,NULL,NULL,NULL),(163,'0808ME171163','10162',NULL,NULL,NULL,NULL,NULL,NULL),(164,'0808ME171164','10163',NULL,NULL,NULL,NULL,NULL,NULL),(165,'0808ME171165','10164',NULL,NULL,NULL,NULL,NULL,NULL),(166,'0808ME171166','10165',NULL,NULL,NULL,NULL,NULL,NULL),(167,'0808ME171167','10166',NULL,NULL,NULL,NULL,NULL,NULL),(168,'0808ME171168','10167',NULL,NULL,NULL,NULL,NULL,NULL),(169,'0808ME171169','10168',NULL,NULL,NULL,NULL,NULL,NULL),(170,'0808ME171170','10169',NULL,NULL,NULL,NULL,NULL,NULL),(171,'0808ME171171','10170',NULL,NULL,NULL,NULL,NULL,NULL),(172,'0808ME171172','10171',NULL,NULL,NULL,NULL,NULL,NULL),(173,'0808ME171173','10172',NULL,NULL,NULL,NULL,NULL,NULL),(174,'0808ME171174','10173',NULL,NULL,NULL,NULL,NULL,NULL),(175,'0808ME171175','10174',NULL,NULL,NULL,NULL,NULL,NULL),(176,'0808ME171176','10175',NULL,NULL,NULL,NULL,NULL,NULL),(177,'0808ME171177','10176',NULL,NULL,NULL,NULL,NULL,NULL),(178,'0808ME171178','10177',NULL,NULL,NULL,NULL,NULL,NULL),(179,'0808ME171179','10178',NULL,NULL,NULL,NULL,NULL,NULL),(180,'0808ME171180','10179',NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `detailed_info_me` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (4),(4);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `missing_copies`
--

DROP TABLE IF EXISTS `missing_copies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `missing_copies` (
  `u_id` int NOT NULL,
  `serial_no` int DEFAULT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `missing_copies`
--

LOCK TABLES `missing_copies` WRITE;
/*!40000 ALTER TABLE `missing_copies` DISABLE KEYS */;
/*!40000 ALTER TABLE `missing_copies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `role_id` int NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ROLE_CS'),(2,'ROLE_ME'),(3,'ROLE_CE'),(4,'ROLE_FT');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `serial_copies`
--

DROP TABLE IF EXISTS `serial_copies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `serial_copies` (
  `s_id` int NOT NULL,
  `serial_no` int DEFAULT NULL,
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `serial_copies`
--

LOCK TABLES `serial_copies` WRITE;
/*!40000 ALTER TABLE `serial_copies` DISABLE KEYS */;
/*!40000 ALTER TABLE `serial_copies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock_cs`
--

DROP TABLE IF EXISTS `stock_cs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stock_cs` (
  `id` int NOT NULL,
  `date_time` date DEFAULT NULL,
  `total_alloted` int DEFAULT NULL,
  `total_missing` int DEFAULT NULL,
  `total_serial_copies` int DEFAULT NULL,
  `total_ufm` int DEFAULT NULL,
  `total_unalloted` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock_cs`
--

LOCK TABLES `stock_cs` WRITE;
/*!40000 ALTER TABLE `stock_cs` DISABLE KEYS */;
/*!40000 ALTER TABLE `stock_cs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_cs`
--

DROP TABLE IF EXISTS `student_cs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_cs` (
  `student_id` int NOT NULL,
  `enrollment_no` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_cs`
--

LOCK TABLES `student_cs` WRITE;
/*!40000 ALTER TABLE `student_cs` DISABLE KEYS */;
INSERT INTO `student_cs` VALUES (1,'0808CS171001'),(2,'0808CS171002'),(3,'0808CS171003'),(4,'0808CS171004'),(5,'0808CS171005'),(6,'0808CS171006'),(7,'0808CS171007'),(8,'0808CS171008'),(9,'0808CS171009'),(10,'0808CS171010'),(11,'0808CS171011'),(12,'0808CS171012'),(13,'0808CS171013'),(14,'0808CS171014'),(15,'0808CS171015'),(16,'0808CS171016'),(17,'0808CS171017'),(18,'0808CS171018'),(19,'0808CS171019'),(20,'0808CS171020'),(21,'0808CS171021'),(22,'0808CS171022'),(23,'0808CS171023'),(24,'0808CS171024'),(25,'0808CS171025'),(26,'0808CS171026'),(27,'0808CS171027'),(28,'0808CS171028'),(29,'0808CS171029'),(30,'0808CS171030'),(31,'0808CS171031'),(32,'0808CS171032'),(33,'0808CS171033'),(34,'0808CS171034'),(35,'0808CS171035'),(36,'0808CS171036'),(37,'0808CS171037'),(38,'0808CS171038'),(39,'0808CS171039'),(40,'0808CS171040'),(41,'0808CS171041'),(42,'0808CS171042'),(43,'0808CS171043'),(44,'0808CS171044'),(45,'0808CS171045'),(46,'0808CS171046'),(47,'0808CS171047'),(48,'0808CS171048'),(49,'0808CS171049'),(50,'0808CS171050'),(51,'0808CS171051'),(52,'0808CS171052'),(53,'0808CS171053'),(54,'0808CS171054'),(55,'0808CS171055'),(56,'0808CS171056'),(57,'0808CS171057'),(58,'0808CS171058'),(59,'0808CS171059'),(60,'0808CS171060'),(61,'0808CS171061'),(62,'0808CS171062'),(63,'0808CS171063'),(64,'0808CS171064'),(65,'0808CS171065'),(66,'0808CS171066'),(67,'0808CS171067'),(68,'0808CS171068'),(69,'0808CS171069'),(70,'0808CS171070'),(71,'0808CS171071'),(72,'0808CS171072'),(73,'0808CS171073'),(74,'0808CS171074'),(75,'0808CS171075'),(76,'0808CS171076'),(77,'0808CS171077'),(78,'0808CS171078'),(79,'0808CS171079'),(80,'0808CS171080'),(81,'0808CS171081'),(82,'0808CS171082'),(83,'0808CS171083'),(84,'0808CS171084'),(85,'0808CS171085'),(86,'0808CS171086'),(87,'0808CS171087'),(88,'0808CS171088'),(89,'0808CS171089'),(90,'0808CS171090'),(91,'0808CS171091'),(92,'0808CS171092'),(93,'0808CS171093'),(94,'0808CS171094'),(95,'0808CS171095'),(96,'0808CS171096'),(97,'0808CS171097'),(98,'0808CS171098'),(99,'0808CS171099'),(100,'0808CS171100'),(101,'0808CS171101'),(102,'0808CS171102'),(103,'0808CS171103'),(104,'0808CS171104'),(105,'0808CS171105'),(106,'0808CS171106'),(107,'0808CS171107'),(108,'0808CS171108'),(109,'0808CS171109'),(110,'0808CS171110'),(111,'0808CS171111'),(112,'0808CS171112'),(113,'0808CS171113'),(114,'0808CS171114'),(115,'0808CS171115'),(116,'0808CS171116'),(117,'0808CS171117'),(118,'0808CS171118'),(119,'0808CS171119'),(120,'0808CS171120'),(121,'0808CS171121'),(122,'0808CS171122'),(123,'0808CS171123'),(124,'0808CS171124'),(125,'0808CS171125'),(126,'0808CS171126'),(127,'0808CS171127'),(128,'0808CS171128'),(129,'0808CS171129'),(130,'0808CS171130'),(131,'0808CS171131'),(132,'0808CS171132'),(133,'0808CS171133'),(134,'0808CS171134'),(135,'0808CS171135'),(136,'0808CS171136'),(137,'0808CS171137'),(138,'0808CS171138'),(139,'0808CS171139'),(140,'0808CS171140'),(141,'0808CS171141'),(142,'0808CS171142'),(143,'0808CS171143'),(144,'0808CS171144'),(145,'0808CS171145'),(146,'0808CS171146'),(147,'0808CS171147'),(148,'0808CS171148'),(149,'0808CS171149'),(150,'0808CS171150'),(151,'0808CS171151'),(152,'0808CS171152'),(153,'0808CS171153'),(154,'0808CS171154'),(155,'0808CS171155'),(156,'0808CS171156'),(157,'0808CS171157'),(158,'0808CS171158'),(159,'0808CS171159'),(160,'0808CS171160'),(161,'0808CS171161'),(162,'0808CS171162'),(163,'0808CS171163'),(164,'0808CS171164'),(165,'0808CS171165'),(166,'0808CS171166'),(167,'0808CS171167'),(168,'0808CS171168'),(169,'0808CS171169'),(170,'0808CS171170'),(171,'0808CS171171'),(172,'0808CS171172'),(173,'0808CS171173'),(174,'0808CS171174'),(175,'0808CS171175'),(176,'0808CS171176'),(177,'0808CS171177'),(178,'0808CS171178'),(179,'0808CS171179'),(180,'0808CS171180');
/*!40000 ALTER TABLE `student_cs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_me`
--

DROP TABLE IF EXISTS `student_me`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_me` (
  `student_id` int NOT NULL,
  `enrollment_no` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_me`
--

LOCK TABLES `student_me` WRITE;
/*!40000 ALTER TABLE `student_me` DISABLE KEYS */;
INSERT INTO `student_me` VALUES (1,'0808ME171001'),(2,'0808ME171002'),(3,'0808ME171003'),(4,'0808ME171004'),(5,'0808ME171005'),(6,'0808ME171006'),(7,'0808ME171007'),(8,'0808ME171008'),(9,'0808ME171009'),(10,'0808ME171010'),(11,'0808ME171011'),(12,'0808ME171012'),(13,'0808ME171013'),(14,'0808ME171014'),(15,'0808ME171015'),(16,'0808ME171016'),(17,'0808ME171017'),(18,'0808ME171018'),(19,'0808ME171019'),(20,'0808ME171020'),(21,'0808ME171021'),(22,'0808ME171022'),(23,'0808ME171023'),(24,'0808ME171024'),(25,'0808ME171025'),(26,'0808ME171026'),(27,'0808ME171027'),(28,'0808ME171028'),(29,'0808ME171029'),(30,'0808ME171030'),(31,'0808ME171031'),(32,'0808ME171032'),(33,'0808ME171033'),(34,'0808ME171034'),(35,'0808ME171035'),(36,'0808ME171036'),(37,'0808ME171037'),(38,'0808ME171038'),(39,'0808ME171039'),(40,'0808ME171040'),(41,'0808ME171041'),(42,'0808ME171042'),(43,'0808ME171043'),(44,'0808ME171044'),(45,'0808ME171045'),(46,'0808ME171046'),(47,'0808ME171047'),(48,'0808ME171048'),(49,'0808ME171049'),(50,'0808ME171050'),(51,'0808ME171051'),(52,'0808ME171052'),(53,'0808ME171053'),(54,'0808ME171054'),(55,'0808ME171055'),(56,'0808ME171056'),(57,'0808ME171057'),(58,'0808ME171058'),(59,'0808ME171059'),(60,'0808ME171060'),(61,'0808ME171061'),(62,'0808ME171062'),(63,'0808ME171063'),(64,'0808ME171064'),(65,'0808ME171065'),(66,'0808ME171066'),(67,'0808ME171067'),(68,'0808ME171068'),(69,'0808ME171069'),(70,'0808ME171070'),(71,'0808ME171071'),(72,'0808ME171072'),(73,'0808ME171073'),(74,'0808ME171074'),(75,'0808ME171075'),(76,'0808ME171076'),(77,'0808ME171077'),(78,'0808ME171078'),(79,'0808ME171079'),(80,'0808ME171080'),(81,'0808ME171081'),(82,'0808ME171082'),(83,'0808ME171083'),(84,'0808ME171084'),(85,'0808ME171085'),(86,'0808ME171086'),(87,'0808ME171087'),(88,'0808ME171088'),(89,'0808ME171089'),(90,'0808ME171090'),(91,'0808ME171091'),(92,'0808ME171092'),(93,'0808ME171093'),(94,'0808ME171094'),(95,'0808ME171095'),(96,'0808ME171096'),(97,'0808ME171097'),(98,'0808ME171098'),(99,'0808ME171099'),(100,'0808ME171100'),(101,'0808ME171101'),(102,'0808ME171102'),(103,'0808ME171103'),(104,'0808ME171104'),(105,'0808ME171105'),(106,'0808ME171106'),(107,'0808ME171107'),(108,'0808ME171108'),(109,'0808ME171109'),(110,'0808ME171110'),(111,'0808ME171111'),(112,'0808ME171112'),(113,'0808ME171113'),(114,'0808ME171114'),(115,'0808ME171115'),(116,'0808ME171116'),(117,'0808ME171117'),(118,'0808ME171118'),(119,'0808ME171119'),(120,'0808ME171120'),(121,'0808ME171121'),(122,'0808ME171122'),(123,'0808ME171123'),(124,'0808ME171124'),(125,'0808ME171125'),(126,'0808ME171126'),(127,'0808ME171127'),(128,'0808ME171128'),(129,'0808ME171129'),(130,'0808ME171130'),(131,'0808ME171131'),(132,'0808ME171132'),(133,'0808ME171133'),(134,'0808ME171134'),(135,'0808ME171135'),(136,'0808ME171136'),(137,'0808ME171137'),(138,'0808ME171138'),(139,'0808ME171139'),(140,'0808ME171140'),(141,'0808ME171141'),(142,'0808ME171142'),(143,'0808ME171143'),(144,'0808ME171144'),(145,'0808ME171145'),(146,'0808ME171146'),(147,'0808ME171147'),(148,'0808ME171148'),(149,'0808ME171149'),(150,'0808ME171150'),(151,'0808ME171151'),(152,'0808ME171152'),(153,'0808ME171153'),(154,'0808ME171154'),(155,'0808ME171155'),(156,'0808ME171156'),(157,'0808ME171157'),(158,'0808ME171158'),(159,'0808ME171159'),(160,'0808ME171160'),(161,'0808ME171161'),(162,'0808ME171162'),(163,'0808ME171163'),(164,'0808ME171164'),(165,'0808ME171165'),(166,'0808ME171166'),(167,'0808ME171167'),(168,'0808ME171168'),(169,'0808ME171169'),(170,'0808ME171170'),(171,'0808ME171171'),(172,'0808ME171172'),(173,'0808ME171173'),(174,'0808ME171174'),(175,'0808ME171175'),(176,'0808ME171176'),(177,'0808ME171177'),(178,'0808ME171178'),(179,'0808ME171179'),(180,'0808ME171180');
/*!40000 ALTER TABLE `student_me` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ufm_copies`
--

DROP TABLE IF EXISTS `ufm_copies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ufm_copies` (
  `u_id` int NOT NULL,
  `serial_no` int DEFAULT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ufm_copies`
--

LOCK TABLES `ufm_copies` WRITE;
/*!40000 ALTER TABLE `ufm_copies` DISABLE KEYS */;
/*!40000 ALTER TABLE `ufm_copies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unalloted_copies`
--

DROP TABLE IF EXISTS `unalloted_copies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `unalloted_copies` (
  `u_id` int NOT NULL,
  `serial_no` int DEFAULT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unalloted_copies`
--

LOCK TABLES `unalloted_copies` WRITE;
/*!40000 ALTER TABLE `unalloted_copies` DISABLE KEYS */;
/*!40000 ALTER TABLE `unalloted_copies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `user_id` int NOT NULL,
  `role_id` int NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKt7e7djp752sqn6w22i6ocqy6q` (`role_id`),
  CONSTRAINT `FKj345gk1bovqvfame88rcx7yyx` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `FKt7e7djp752sqn6w22i6ocqy6q` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1),(3,2);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` int NOT NULL,
  `active` bit(1) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,_binary '','$2a$10$5E3UQ28BnoJTDJAAHuitF.CTh8l5wUuQONWZlCiHp0hHyLM0aoQgS','abhinav'),(3,_binary '','$2a$10$ca.2WabKA8iyeGv5J36NguAbKntsExfnRGx3C47VpXG8JMRhwc9z.','anay');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'examcopymanagement'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-24 11:13:58