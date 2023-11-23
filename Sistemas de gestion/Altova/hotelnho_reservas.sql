CREATE DATABASE  IF NOT EXISTS `hotelnho` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `hotelnho`;
-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: hotelnho
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `reservas`
--

DROP TABLE IF EXISTS `reservas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservas` (
  `localizador` int(11) NOT NULL,
  `fecha_alta_res` date DEFAULT NULL,
  `cod_canal_venta` int(11) DEFAULT NULL,
  `tipo_habitacion` int(11) DEFAULT NULL,
  `cod_regimen` int(11) DEFAULT NULL,
  `cod_cliente` int(11) DEFAULT NULL,
  `fecha_entrada` date DEFAULT NULL,
  `num_noches` int(11) DEFAULT NULL,
  `observaciones` varchar(255) DEFAULT NULL,
  `controladorACA` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`localizador`),
  KEY `cod_canal_venta` (`cod_canal_venta`),
  KEY `tipo_habitacion` (`tipo_habitacion`),
  KEY `cod_regimen` (`cod_regimen`),
  KEY `cod_cliente` (`cod_cliente`),
  CONSTRAINT `reservas_ibfk_1` FOREIGN KEY (`cod_canal_venta`) REFERENCES `canales_venta` (`cod_canal_venta`),
  CONSTRAINT `reservas_ibfk_2` FOREIGN KEY (`tipo_habitacion`) REFERENCES `habitaciones` (`tipo_habitacion`),
  CONSTRAINT `reservas_ibfk_3` FOREIGN KEY (`cod_regimen`) REFERENCES `regimenes_alimenticios` (`cod_regimen`),
  CONSTRAINT `reservas_ibfk_4` FOREIGN KEY (`cod_cliente`) REFERENCES `clientes` (`cod_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservas`
--

LOCK TABLES `reservas` WRITE;
/*!40000 ALTER TABLE `reservas` DISABLE KEYS */;
INSERT INTO `reservas` VALUES (100001,'2023-08-15',1,1,1,1,'2023-10-19',4,'Necesita una cuna','Aaron Castro Arias'),(100002,'2023-08-17',2,2,3,2,'2023-11-16',6,'Guardarropa','Aaron Castro Arias'),(100003,'2023-08-20',3,3,2,3,'2023-11-17',2,'Entrar 2 horas antes','Aaron Castro Arias'),(100004,'2023-09-01',4,5,4,4,'2023-10-04',3,'Opción una noche más','Aaron Castro Arias'),(100005,'2023-09-01',4,4,3,5,'2023-12-18',5,'Servicio de lavandería','Aaron Castro Arias'),(100006,'2023-09-02',3,2,1,6,'2023-09-25',1,'Regalo bienvenida','Aaron Castro Arias'),(100007,'2023-09-03',2,1,4,7,'2023-12-09',7,'Visita guiada','Aaron Castro Arias'),(100008,'2023-09-03',3,2,2,8,'2024-03-11',2,'Mascota - Gato','Aaron Castro Arias'),(100009,'2023-09-05',2,5,4,9,'2024-01-02',4,'Plaza de parking','Aaron Castro Arias'),(100010,'2023-09-06',1,3,1,10,'2023-11-23',5,'Mascota - Perro','Aaron Castro Arias'),(100011,'2023-09-07',1,3,5,11,'2023-11-05',6,'Coche de alquiler','Aaron Castro Arias'),(100012,'2023-07-23',3,1,5,12,'2024-02-06',3,'Guardarropa','Aaron Castro Arias');
/*!40000 ALTER TABLE `reservas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-23 13:32:46
