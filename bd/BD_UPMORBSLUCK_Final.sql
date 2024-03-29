CREATE DATABASE  IF NOT EXISTS `bd_upmorbsluck` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bd_upmorbsluck`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: bd_upmorbsluck
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `tb_audifonosgamer`
--

DROP TABLE IF EXISTS `tb_audifonosgamer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_audifonosgamer` (
  `codigo_` int NOT NULL AUTO_INCREMENT,
  `codigo` varchar(8) NOT NULL,
  `marca` varchar(45) NOT NULL,
  `modelo` varchar(45) NOT NULL,
  `descripcion` varchar(500) NOT NULL,
  `tipoconex` varchar(45) NOT NULL,
  `precio` decimal(8,2) NOT NULL,
  `stock` int NOT NULL,
  `categoria` varchar(8) NOT NULL,
  PRIMARY KEY (`codigo_`),
  KEY `categoria` (`categoria`),
  CONSTRAINT `tb_audifonosgamer_ibfk_1` FOREIGN KEY (`categoria`) REFERENCES `tb_categoria` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_audifonosgamer`
--

LOCK TABLES `tb_audifonosgamer` WRITE;
/*!40000 ALTER TABLE `tb_audifonosgamer` DISABLE KEYS */;
INSERT INTO `tb_audifonosgamer` VALUES (10,'AG001','VSG','Gravity','multiplataforma con conexion 2.4ghz','inalambrico',373.00,732,'CT002'),(11,'AG002','VSG','Singularity','Audífono con sistema de audio 7.1 virtual','inalambrico',250.00,895,'CT002'),(12,'AG003','VSG','Gemini','Audífono multiplataforma, sistema de sonido estéreo','inalambrico',134.00,680,'CT002'),(13,'AG004','Bengoo','Bengo G9000','Auriculares estéreo para juegos para PS4 PC','alambrico',125.00,822,'CT002'),(14,'AG005','Teraware','Jack 3.5','Audífonos gamer conexión usb y 3.5 mm','Alambrico',60.00,955,'CT002'),(15,'AG006','Razer','Kraken x','Audífonos gamer conexión 3.5 mm, 32 ohm, sensibilidad 109 dB','alambrico',100.00,613,'CT002'),(16,'AG007','Teraware','RG400','conexión 3.5 mm, RGB, compatible PC','inalambrico',80.00,512,'CT002'),(17,'AG008','Teraware','KD-995','USB, 32 ohm, sensibilidad 42 dB, compatible PC','inalambrico',120.00,1272,'CT002'),(18,'AG009','Logitech','G335','sensibilidad: 87.5 dB, compatible PC y consolas','inalambrico',45.00,694,'CT002');
/*!40000 ALTER TABLE `tb_audifonosgamer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_audifonosmusica`
--

DROP TABLE IF EXISTS `tb_audifonosmusica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_audifonosmusica` (
  `codigo_` int NOT NULL AUTO_INCREMENT,
  `codigo` varchar(8) NOT NULL,
  `marca` varchar(45) NOT NULL,
  `modelo` varchar(45) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `tipoconex` varchar(45) NOT NULL,
  `precio` decimal(8,2) NOT NULL,
  `stock` int NOT NULL,
  `categoria` varchar(8) NOT NULL,
  PRIMARY KEY (`codigo_`),
  KEY `categoria` (`categoria`),
  CONSTRAINT `tb_audifonosmusica_ibfk_1` FOREIGN KEY (`categoria`) REFERENCES `tb_categoria` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_audifonosmusica`
--

LOCK TABLES `tb_audifonosmusica` WRITE;
/*!40000 ALTER TABLE `tb_audifonosmusica` DISABLE KEYS */;
INSERT INTO `tb_audifonosmusica` VALUES (1,'AM001','JBL','TUNE','Sonido JBL Pure Bass','Alambrico',169.00,630,'CT003'),(2,'AM002','JBL','Quantum','El sistema sin pérdidas 2,4 GHz','Inalambrico',26.00,721,'CT003'),(3,'AM003','TERAWARE','K-S2','brazo de micrófono','Alambrico',59.00,920,'CT003'),(4,'AM004','Skullcandy','Extra ','Resistente al polvo','Alambrico',18.00,620,'CT003'),(5,'AM005','BLACKSHEEP','Smoke ','Aislamiento de sonido','Alambrico',38.00,751,'CT003'),(6,'AM006','Huawei','Freebuds','Aislamiento de sonido','Inalambrico',29.00,860,'CT003'),(7,'AM007','Acer','Headset ','Resistente al polvo','Alambrico',39.00,462,'CT003'),(8,'AM008','Sony','WH CH510','Compatible con entradas usb y vga','Alambrico',29.00,863,'CT003'),(9,'AM009','Acer','Headset','Predator Sonido stereo','Alambrico',49.00,652,'CT003'),(10,'AM010','Bose','Confort 45','Compatibilidad con windows y mac','Inalambrico',169.00,966,'CT003');
/*!40000 ALTER TABLE `tb_audifonosmusica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_boleta_compra`
--

DROP TABLE IF EXISTS `tb_boleta_compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_boleta_compra` (
  `num` int NOT NULL AUTO_INCREMENT,
  `codBoleta` varchar(200) NOT NULL,
  `cod_Empleado` int NOT NULL,
  `cod_Proveedor` int NOT NULL,
  `fechaVenta` date NOT NULL,
  `descripcion` text NOT NULL,
  `importe` double NOT NULL,
  PRIMARY KEY (`num`),
  KEY `FK_EMPLEADO_idx` (`cod_Empleado`),
  KEY `FK_PROVEEDOR_idx` (`cod_Proveedor`),
  CONSTRAINT `FK_EMPLEADO` FOREIGN KEY (`cod_Empleado`) REFERENCES `tb_empleado` (`codigo_`),
  CONSTRAINT `FK_PROVEEDOR` FOREIGN KEY (`cod_Proveedor`) REFERENCES `tb_proveedor` (`codigo_`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_boleta_compra`
--

LOCK TABLES `tb_boleta_compra` WRITE;
/*!40000 ALTER TABLE `tb_boleta_compra` DISABLE KEYS */;
INSERT INTO `tb_boleta_compra` VALUES (3,'N - 9742305064222154826',1,3,'2022-06-30','Producto N-1 AM002 JBL QUANTUM Precio: 26.0 Cantidad: 1 Importe: 26.0\nProducto N-2 AM003 TERAWARE K-S2 Precio: 59.0 Cantidad: 1 Importe: 59.0\nProducto N-3 AM004 SKULLCANDY EXTRA  Precio: 18.0 Cantidad: 1 Importe: 18.0\nProducto N-4 AM005 BLACKSHEEP SMOKE  Precio: 38.0 Cantidad: 1 Importe: 38.0\nProducto N-5 AM006 HUAWEI FREEBUDS Precio: 29.0 Cantidad: 1 Importe: 29.0\nProducto N-6 AM007 ACER HEADSET  Precio: 39.0 Cantidad: 1 Importe: 39.0\nProducto N-7 AM008 SONY WH CH510 Precio: 29.0 Cantidad: 1 Importe: 29.0\nProducto N-8 AM009 ACER HEADSET Precio: 49.0 Cantidad: 1 Importe: 49.0\nProducto N-9 AM010 BOSE CONFORT 45 Precio: 169.0 Cantidad: 1 Importe: 169.0\n',456),(4,'N - 4243307066228200256',1,2,'2022-06-30','Producto N-1 TG001 LOGITECH CARBON LIGHTSYNC Precio: 659.0 Cantidad: 2 Importe: 1318.0\nProducto N-2 TG002 MICRONICS FRANTIC Precio: 129.0 Cantidad: 44 Importe: 5676.0\nProducto N-3 TG003 THERMALTAKE CHALLENGER Precio: 159.0 Cantidad: 32 Importe: 5088.0\nProducto N-4 TG004 CYBERTEL EBONY Precio: 269.0 Cantidad: 21 Importe: 5649.0\nProducto N-5 TG005 HYPERX ALLOY CORE Precio: 349.0 Cantidad: 22 Importe: 7678.0\nProducto N-6 TG006 TERAWARE ROY MUSTANG Precio: 159.0 Cantidad: 4 Importe: 636.0\nProducto N-7 TG007 TERAWARE KD-955 Precio: 209.0 Cantidad: 6 Importe: 1254.0\nProducto N-8 TG008 HAVIT ONE HAND Precio: 169.0 Cantidad: 3 Importe: 507.0\nProducto N-9 TG009 HP CM3000 Precio: 299.0 Cantidad: 2 Importe: 598.0\nProducto N-10 TG010 REDRAGON KUMARA RAINBOW Precio: 169.0 Cantidad: 8 Importe: 1352.0\n',29756),(5,'N - 2710308066224214008',1,2,'2022-06-30','Producto N-1 SG001 COOL TEC SILLA GAMER DRAGONS 2022 Precio: 584.0 Cantidad: 20 Importe: 11680.0\nProducto N-2 SG002 CASA-JOVEN RECLINABLE GAMER Precio: 379.0 Cantidad: 500 Importe: 189500.0\nProducto N-3 SG003 CASA-JOVEN GAMER TITANIUM Precio: 478.0 Cantidad: 100 Importe: 47800.0\nProducto N-4 SG004 COOL TEC GAMER PRO 2020 Precio: 655.0 Cantidad: 205 Importe: 134275.0\nProducto N-5 SG005 SASARU IMPORTACIONES GAMER BLAZZE Precio: 700.0 Cantidad: 80 Importe: 56000.0\n',439255);
/*!40000 ALTER TABLE `tb_boleta_compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_boleta_venta`
--

DROP TABLE IF EXISTS `tb_boleta_venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_boleta_venta` (
  `num` int NOT NULL AUTO_INCREMENT,
  `codBoleta` varchar(200) NOT NULL,
  `cod_Empleado` int NOT NULL,
  `cod_Cliente` int NOT NULL,
  `fechaVenta` date NOT NULL,
  `descripcion` text NOT NULL,
  `importe` double NOT NULL,
  PRIMARY KEY (`num`),
  KEY `FK_codCli_idx` (`cod_Cliente`),
  KEY `FK_codEmp_idx` (`cod_Empleado`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_boleta_venta`
--

LOCK TABLES `tb_boleta_venta` WRITE;
/*!40000 ALTER TABLE `tb_boleta_venta` DISABLE KEYS */;
INSERT INTO `tb_boleta_venta` VALUES (54,'N - 8924303067226154603',1,7,'2022-06-30','Producto N-1 SG001 COOL TEC SILLA GAMER DRAGONS 2022 Precio: 584.0 Cantidad: 1 Importe: 584.0\nProducto N-2 SG002 CASA-JOVEN RECLINABLE GAMER Precio: 379.0 Cantidad: 1 Importe: 379.0\nProducto N-3 SG003 CASA-JOVEN GAMER TITANIUM Precio: 478.0 Cantidad: 1 Importe: 478.0\nProducto N-4 SG005 SASARU IMPORTACIONES GAMER BLAZZE Precio: 700.0 Cantidad: 1 Importe: 700.0\nProducto N-5 SG006 SKU-SILLAGAMERTURBOR GAMER TURBO Precio: 542.0 Cantidad: 1 Importe: 542.0\nProducto N-6 SG007 SKU-SILLAGAMERTURBOR SILLA GAMER RACER Precio: 456.0 Cantidad: 1 Importe: 456.0\nProducto N-7 JG003 GTA V ROCKSTAR GAMES Precio: 40.0 Cantidad: 1 Importe: 40.0\nProducto N-8 LP001 ACER ASPIRE Precio: 1400.0 Cantidad: 1 Importe: 1400.0\nProducto N-9 LP002 LENOVO IDEAPAD 2 Precio: 849.0 Cantidad: 1 Importe: 849.0\nProducto N-10 LP003 ASUS M415DA-EB931W Precio: 1799.0 Cantidad: 1 Importe: 1799.0\nProducto N-11 LP004 HP 15-EF2507LA Precio: 1999.0 Cantidad: 1 Importe: 1999.0\nProducto N-12 LP005 LENOVO IDEAPAD 3 Precio: 2199.0 Cantidad: 1 Importe: 2199.0\nProducto N-13 LP006 HP 15-DY2205 Precio: 2399.0 Cantidad: 1 Importe: 2399.0\nProducto N-14 LP007 LENOVO IDEAPAD 4 Precio: 1500.0 Cantidad: 1 Importe: 1500.0\nProducto N-15 LP008 ACER ASHADOW Precio: 2199.0 Cantidad: 1 Importe: 2199.0\nProducto N-16 LP009 LENOVO FLEX Precio: 1449.0 Cantidad: 1 Importe: 1449.0\nProducto N-17 LP010 ASUS X415JA-EB1361W Precio: 1400.0 Cantidad: 1 Importe: 1400.0\n',20372),(55,'N - 9204307063224154953',1,5,'2020-06-30','Producto N-1 SG004 COOL TEC GAMER PRO 2020 Precio: 655.0 Cantidad: 1 Importe: 655.0\n',655),(56,'N - 8114300061224213847',1,5,'2022-06-30','Producto N-1 PG001 INTEL CORE I7 4TH 3.4 GHZ DISCO SÓLIDO SSD M2 NVME 500GB Precio: 1950.0 Cantidad: 10 Importe: 19500.0\nProducto N-2 PG002 INTEL CORE I9 6TH 3.4 GHZ HDD 2TB 7200 RPM Precio: 2150.0 Cantidad: 5 Importe: 10750.0\nProducto N-3 PG003 AMD RYZEN 5 5600X 3.7 GHZ, 3 MB L2, 6 NÚCLEOS, 12 HILOS WESTERN DIGITAL BLACK P10 GAME DRIVE 4TB, USB 3.2, 140MB/S Precio: 5450.0 Cantidad: 2 Importe: 10900.0\nProducto N-4 MG004 ASUS MEETION-RATÓN MECÁNICO Precio: 299.0 Cantidad: 5 Importe: 1495.0\nProducto N-5 MG008 CETUS G502 HERO – NEGRO Precio: 79.0 Cantidad: 2 Importe: 158.0\nProducto N-6 TG004 CYBERTEL EBONY Precio: 269.0 Cantidad: 7 Importe: 1883.0\n',44686);
/*!40000 ALTER TABLE `tb_boleta_venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_camaraweb`
--

DROP TABLE IF EXISTS `tb_camaraweb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_camaraweb` (
  `codigo_` int NOT NULL AUTO_INCREMENT,
  `codigo` varchar(8) NOT NULL,
  `marca` varchar(45) NOT NULL,
  `modelo` varchar(45) NOT NULL,
  `tipoconex` varchar(45) NOT NULL,
  `precio` decimal(12,2) NOT NULL,
  `stock` int DEFAULT NULL,
  `categoria` varchar(8) NOT NULL,
  PRIMARY KEY (`codigo_`),
  KEY `categoria` (`categoria`),
  CONSTRAINT `tb_camaraweb_ibfk_1` FOREIGN KEY (`categoria`) REFERENCES `tb_categoria` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_camaraweb`
--

LOCK TABLES `tb_camaraweb` WRITE;
/*!40000 ALTER TABLE `tb_camaraweb` DISABLE KEYS */;
INSERT INTO `tb_camaraweb` VALUES (1,'CW001','Genius','ECam 8000','Alambrico',193.00,250,'CT003'),(2,'CW002','Prolink','UA 1200','Alambrico',193.00,172,'CT003'),(3,'CW003','Lenovo','CMOS','Alambrico',169.00,190,'CT003'),(4,'CW004','Razer','KIYO','Inalambrico',499.00,180,'CT003'),(5,'CW005','Redragon','Hitman','Alambrico',199.00,120,'CT003'),(6,'CW006','Radioshack','SDH4','Inalambrico',89.00,346,'CT003'),(7,'CW007','Xiaomi','Imilab','Alambrico',119.00,454,'CT003'),(8,'CW008','Logitech','C922','Inalambrico',351.00,544,'CT003'),(9,'CW009','NV Snoppy','2KH','Alambrico',69.00,506,'CT003'),(10,'CW010','Teros','TE-903','Alambrico',79.00,522,'CT003');
/*!40000 ALTER TABLE `tb_camaraweb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_cargo`
--

DROP TABLE IF EXISTS `tb_cargo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_cargo` (
  `codigo` varchar(8) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_cargo`
--

LOCK TABLES `tb_cargo` WRITE;
/*!40000 ALTER TABLE `tb_cargo` DISABLE KEYS */;
INSERT INTO `tb_cargo` VALUES ('CR001','Supervisor'),('CR002','Gerente'),('CR003','Asistente'),('CR004','Practicante'),('CR005','Secretario');
/*!40000 ALTER TABLE `tb_cargo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_categoria`
--

DROP TABLE IF EXISTS `tb_categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_categoria` (
  `codigo` varchar(8) NOT NULL,
  `categoria` varchar(45) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_categoria`
--

LOCK TABLES `tb_categoria` WRITE;
/*!40000 ALTER TABLE `tb_categoria` DISABLE KEYS */;
INSERT INTO `tb_categoria` VALUES ('CT001','videojuegos'),('CT002','gaming'),('CT003','electronica');
/*!40000 ALTER TABLE `tb_categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_celular`
--

DROP TABLE IF EXISTS `tb_celular`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_celular` (
  `codigo_` int NOT NULL AUTO_INCREMENT,
  `codigo` varchar(8) NOT NULL,
  `marca` varchar(45) NOT NULL,
  `modelo` varchar(45) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `precio` decimal(8,2) NOT NULL,
  `stock` int NOT NULL,
  `categoria` varchar(8) NOT NULL,
  PRIMARY KEY (`codigo_`),
  KEY `categoria` (`categoria`),
  CONSTRAINT `tb_celular_ibfk_1` FOREIGN KEY (`categoria`) REFERENCES `tb_categoria` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_celular`
--

LOCK TABLES `tb_celular` WRITE;
/*!40000 ALTER TABLE `tb_celular` DISABLE KEYS */;
INSERT INTO `tb_celular` VALUES (1,'CL001','Apple','Iphone 11','Batería recargable integrada',2699.00,926,'CT003'),(2,'CL002','Apple','iPhone 9','Full screen UHD',1800.00,456,'CT003'),(3,'CL003','Samsung','Galaxi A32','Cámara posterior 64MP',949.00,623,'CT003'),(4,'CL004','Huawei','Nova 8I','Memoria interna 128GB',929.00,754,'CT003'),(5,'CL005','Samsung','Galaxi A52S','Batería 4500 mAh',1599.00,517,'CT003'),(6,'CL006','Huawei','P50 PRO','Memoria interna 256GB',3699.00,924,'CT003'),(7,'CL007','Apple','iPhone 13','Memoria interna 128GB',4199.00,683,'CT003'),(8,'CL008','Huawei','Nova 9 Pro','Cámara frontal 32MP',1599.00,499,'CT003'),(9,'CL009','Xiaomi','Redmi Note 11','Memoria interna 128GB',739.00,780,'CT003'),(10,'CL010','Honor','Lite','Cantidad de camaras 5 ',899.00,963,'CT003');
/*!40000 ALTER TABLE `tb_celular` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_cliente`
--

DROP TABLE IF EXISTS `tb_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_cliente` (
  `codigo_` int NOT NULL AUTO_INCREMENT,
  `codigo` varchar(8) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `dni` varchar(45) NOT NULL,
  `edad` int NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `genero` varchar(8) NOT NULL,
  `estadocivil` varchar(8) NOT NULL,
  `celular` varchar(9) NOT NULL,
  `correo` varchar(45) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  PRIMARY KEY (`codigo_`),
  KEY `genero` (`genero`),
  KEY `estadocivil` (`estadocivil`),
  CONSTRAINT `tb_cliente_ibfk_1` FOREIGN KEY (`genero`) REFERENCES `tb_genero` (`codigo`),
  CONSTRAINT `tb_cliente_ibfk_2` FOREIGN KEY (`estadocivil`) REFERENCES `tb_estadocivil` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_cliente`
--

LOCK TABLES `tb_cliente` WRITE;
/*!40000 ALTER TABLE `tb_cliente` DISABLE KEYS */;
INSERT INTO `tb_cliente` VALUES (1,'CL001','Juan','Perez Ugarte','74859678',21,'2001-06-25','GEN01','ESTC01','994738579','juanperez@hotmail.com','Jr Jose M Cortez'),(2,'CL002','James','Lawson Webb','75930343',24,'1997-02-15','GEN01','ESTC02','994837567','jameslawson@hotmail.com','Los Gorriones'),(3,'CL003','Cris','Howard Paredes','78573431',32,'1990-11-21','GEN01','ESTC01','939283746','howard12@hotmail.com','Calle Los Angeles'),(5,'CL005','Santiago','Beltran','67894512',27,'1994-06-16','GEN01','ESTC02','987654321','sabe@gmail.com','Urb. Bosque Real 2324'),(6,'CL006','Mariangel','Rubi','76412535',39,'1982-09-18','GEN02','ESTC02','978654321','maru@outlook.com','Calle Reyes del Sol 451'),(7,'CL007','Georgina','Martinez','57894612',33,'1988-09-08','GEN02','ESTC02','987654321','Gecha@gmail.com','Av. Los Manzanos 456');
/*!40000 ALTER TABLE `tb_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_consola`
--

DROP TABLE IF EXISTS `tb_consola`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_consola` (
  `codigo_` int NOT NULL AUTO_INCREMENT,
  `codigo` varchar(8) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `modelo` varchar(45) NOT NULL,
  `color` varchar(45) NOT NULL,
  `precio` decimal(8,2) NOT NULL,
  `stock` int NOT NULL,
  `categoria` varchar(8) NOT NULL,
  PRIMARY KEY (`codigo_`),
  KEY `categoria` (`categoria`),
  CONSTRAINT `tb_consola_ibfk_1` FOREIGN KEY (`categoria`) REFERENCES `tb_categoria` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_consola`
--

LOCK TABLES `tb_consola` WRITE;
/*!40000 ALTER TABLE `tb_consola` DISABLE KEYS */;
INSERT INTO `tb_consola` VALUES (11,'CN001','PlayStation','One','white',200.00,695,'CT001'),(12,'CN002','PlayStation','Premium','red',500.00,467,'CT001'),(13,'CN003','PlayStation','Classic','black',800.00,852,'CT001'),(14,'CN004','PlayStation','Platinium','darkblue',1500.00,741,'CT001'),(16,'CN006','Nintendo','Switch','white',900.00,963,'CT001'),(17,'CN007','Nintendo','3DS','black',850.00,862,'CT001'),(18,'CN008','Nintendo','WII U','white',700.00,935,'CT001'),(19,'CN009','Xbox','360','blue',350.00,753,'CT001'),(20,'CN010','Xbox','One','darkblue',500.00,743,'CT001');
/*!40000 ALTER TABLE `tb_consola` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_empleado`
--

DROP TABLE IF EXISTS `tb_empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_empleado` (
  `codigo_` int NOT NULL AUTO_INCREMENT,
  `codigo` varchar(8) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `dni` varchar(45) NOT NULL,
  `edad` int NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `genero` varchar(8) NOT NULL,
  `estadocivil` varchar(8) NOT NULL,
  `celular` varchar(9) NOT NULL,
  `correo` varchar(45) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `cargo` varchar(8) NOT NULL,
  `sede` varchar(8) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `clave` varchar(45) NOT NULL,
  PRIMARY KEY (`codigo_`),
  KEY `genero` (`genero`),
  KEY `estadocivil` (`estadocivil`),
  KEY `cargo` (`cargo`),
  KEY `sede` (`sede`),
  CONSTRAINT `tb_empleado_ibfk_1` FOREIGN KEY (`genero`) REFERENCES `tb_genero` (`codigo`),
  CONSTRAINT `tb_empleado_ibfk_2` FOREIGN KEY (`estadocivil`) REFERENCES `tb_estadocivil` (`codigo`),
  CONSTRAINT `tb_empleado_ibfk_3` FOREIGN KEY (`cargo`) REFERENCES `tb_cargo` (`codigo`),
  CONSTRAINT `tb_empleado_ibfk_4` FOREIGN KEY (`sede`) REFERENCES `tb_sede` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=410 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_empleado`
--

LOCK TABLES `tb_empleado` WRITE;
/*!40000 ALTER TABLE `tb_empleado` DISABLE KEYS */;
INSERT INTO `tb_empleado` VALUES (1,'EM001','Jheyson Patrick','Castillo Figueroa','71798936',20,'2002-04-30','GEN01','ESTC01','912595379','patrick30al@gmail.com','Alameda Sur 724','CR001','SD004','ADMIN','admin'),(2,'EM002','Diego','Valenzuela','73845837',26,'1996-03-14','GEN01','ESTC02','984384685','diegovalenzuela@hotmail.com','Pascual Morales 832','CR004','SD001','U002','54jd2k'),(4,'EM004','Mariana','Salcedo Ticona','74729680',29,'1993-11-28','GEN02','ESTC01','997271849','leandroticona@hotmail.com','Calle Los Pinos 102','CR003','SD002','U004','qs1q2k'),(5,'EM005','Nicole','Rodríguez','77540534',25,'1996-10-22','GEN02','ESTC03','972733610','NiRo05@gmail.com','Urb. El Olivar 548','CR004','SD006','U005','984gfd'),(6,'EM006','Carolina','Díaz','73481306',71,'1951-04-16','GEN02','ESTC03','902355550','CaDí61@gmail.com','Urb. Samuel de Luque 492','CR003','SD005','U006','tCfqmf'),(7,'EM007','Ahzià','Smith','72522521',22,'1999-09-08','GEN01','ESTC01','970653133','AhSm57@hotmail.com','Calle Samuel de Luque 546','CR001','SD001','U007','e4PJp3'),(8,'EM008','Maria','Murphy','73575773',24,'1997-11-05','GEN02','ESTC03','987773672','LaMu55@hotmail.com','Urb. Blueberry 235','CR002','SD001','U008','4vmWP2'),(13,'EM013','Jazmín','Jackson','75362717',32,'1989-08-22','GEN02','ESTC01','914305131','JaJa66@hotmail.com','Urb. Miguel Angel902','CR002','SD008','U013','BolQlN'),(14,'EM014','Darío','Martin','75677212',57,'1965-01-09','GEN01','ESTC03','953648054','DaMa20@gmail.com','Calle El Triunfo 253','CR003','SD001','U014','g8p1ew'),(16,'EM016','Adriana','Díaz','74787755',64,'1958-01-23','GEN02','ESTC02','964836742','AdDí78@outlook.com','Urb. Santiago Wagner 195','CR001','SD004','U016','ma7i53'),(17,'EM017','Pedro','Wright','78586748',34,'1987-08-17','GEN01','ESTC01','916336883','LuWr54@gmail.com','Av. Blueberry 519','CR001','SD008','U017','Fs3G67'),(18,'EM018','Fernanda','Thompson','70002518',69,'1953-01-13','GEN02','ESTC01','928705688','FeTh82@hotmail.com','Urb. Samuel de Luque 365','CR004','SD007','U018','mxOt5C'),(19,'EM019','Ana Sofía','Davis','73352677',20,'2001-06-19','GEN02','ESTC01','946754027','AnDa66@gmail.com','Av. San Martin 840','CR002','SD006','U019','YPb8kk'),(20,'EM020','Melissa','Edwards','76873251',27,'1994-09-25','GEN02','ESTC02','901144446','MeEd13@gmail.com','Urb. Brazil 718','CR001','SD001','U020','Kbk1r8'),(21,'EM021','Moad','Wilson','77031563',31,'1990-07-07','GEN01','ESTC01','924385284','MoWi88@hotmail.com','Calle San Martin 258','CR003','SD005','U021','26gdkv'),(22,'EM022','Naomí','Johnson','72624325',45,'1976-07-24','GEN02','ESTC02','931138853','NaJo72@gmail.com','Av. Samuel de Luque 629','CR003','SD006','U022','vQqlea'),(23,'EM023','Moad','Nelson','70854720',24,'1998-01-25','GEN01','ESTC03','987847115','MoNe24@outlook.com','Urb. Los Olivos 903','CR001','SD004','U023','UgqCdl'),(24,'EM024','Jazmín','Johnson','71472133',64,'1957-09-19','GEN02','ESTC01','952411543','JaJo62@hotmail.com','Urb. German Garmendia 795','CR002','SD003','U024','hqeI29'),(25,'EM025','Eleazar','Martínez','72506324',20,'2002-02-18','GEN01','ESTC03','905173033','ElMa63@gmail.com','Urb. El Triunfo 997','CR001','SD003','U025','eS2Af7'),(26,'EM026','Gabriela','Espinoza','78785785',36,'1985-10-08','GEN02','ESTC03','968148121','GaEs72@outlook.com','Urb. El Mariana 178','CR003','SD007','U026','fuf2d7'),(27,'EM027','Nael','Castro','77308553',66,'1955-11-12','GEN01','ESTC03','933825074','NaCa02@outlook.com','Av. Buenaventura 974','CR004','SD005','U027','ctMp8s'),(28,'EM028','Monserrat','Chávez','75445146',62,'1960-05-01','GEN02','ESTC03','904567575','MoCh53@hotmail.com','Calle El Mariana 156','CR001','SD001','U028','7u8mf6'),(29,'EM029','Jun','Torres','71371333',66,'1955-11-11','GEN01','ESTC02','957375207','JuTo52@hotmail.com','Calle San Martin 403','CR003','SD001','U029','yqJhej'),(30,'EM030','Sofía','Vásquez','77321611',54,'1968-03-06','GEN02','ESTC03','911168118','SoVá01@hotmail.com','Av. Spreen 529','CR002','SD002','U030','aspy14'),(31,'EM031','Josefina','Sánchez','76883218',61,'1961-03-08','GEN02','ESTC02','953241844','JoSá44@gmail.com','Urb. Los Olivos 249','CR003','SD004','U031','811giu'),(32,'EM032','Lucía','Davis','72337443',47,'1975-02-12','GEN02','ESTC01','917737646','LuDa22@hotmail.com','Urb. El Olivar 277','CR002','SD001','U032','qjsB1W'),(33,'EM033','María José','Torres','74288582',64,'1958-01-20','GEN02','ESTC01','974641043','MaTo51@hotmail.com','Urb. Don Ibai 250','CR004','SD006','U033','hfrGTl'),(34,'EM034','Alba','Díaz','78008486',44,'1977-07-18','GEN02','ESTC03','914476242','AlDí43@hotmail.com','Urb. Spreen 422','CR004','SD001','U034','nc8984'),(35,'EM035','Doroteu','Morris','77778571',29,'1993-04-27','GEN01','ESTC02','952063573','DoMo02@outlook.com','Av. Miguel Angel155','CR002','SD005','U035','JnvDOs'),(36,'EM036','Rebeca','Mamani','76686121',47,'1975-01-24','GEN02','ESTC02','925041200','ReMa21@outlook.com','Calle El Mariana 768','CR004','SD001','U036','qy84jV'),(37,'EM037','Isidora','Rojas','71028077',55,'1966-08-06','GEN02','ESTC03','941853657','IsRo83@gmail.com','Av. German Garmendia 762','CR002','SD009','U037','Ae4Hkc'),(38,'EM038','Abel','Phillips','72028537',33,'1989-04-06','GEN01','ESTC03','915722430','AbPh35@gmail.com','Av. Buenaventura 199','CR003','SD001','U038','3Mxyab'),(40,'EM040','Ana Sofía','Flores','75532658',57,'1964-09-09','GEN02','ESTC01','903214303','AnFl31@gmail.com','Av. Samuel de Luque 488','CR001','SD005','U040','hg2Rgf'),(41,'EM041','Alexandra','Rogers','78400317',53,'1969-04-04','GEN02','ESTC02','954706833','AlRo73@gmail.com','Calle Miguel Angel592','CR001','SD001','U041','2dxy3i'),(42,'EM042','Esteban','Phillips','73303163',71,'1951-04-02','GEN01','ESTC03','950784553','EsPh44@gmail.com','Urb. El Triunfo 299','CR002','SD007','U042','77syCm'),(43,'EM043','Emma','Edwards','74622321',22,'1999-10-04','GEN02','ESTC02','905151223','EmEd20@outlook.com','Av. San Martin 896','CR003','SD006','U043','rdjjBS'),(44,'EM044','Abraham','Torres','76384441',72,'1950-01-09','GEN01','ESTC02','962448113','AbTo48@gmail.com','Calle Cascanuesces 611','CR001','SD002','U044','FjufVR'),(45,'EM045','Ana','Pérez','78317428',72,'1950-02-16','GEN02','ESTC02','983331167','AnPé00@hotmail.com','Av. San Martin 627','CR001','SD003','U045','okckr4'),(46,'EM046','Diana','Smith','70664886',47,'1975-02-23','GEN02','ESTC01','918468741','DiSm05@gmail.com','Calle German Garmendia 191','CR002','SD009','U046','uf2nie'),(47,'EM047','Ashley','Rojas','70025325',53,'1968-09-19','GEN02','ESTC03','945040006','AsRo40@outlook.com','Calle Blueberry 719','CR004','SD008','U047','vyjSil'),(48,'EM048','Misael','Flores','70817003',60,'1962-01-11','GEN01','ESTC01','910850262','MiFl15@hotmail.com','Calle Blueberry 836','CR002','SD009','U048','pKoh8h'),(49,'EM049','Guadalupe','Espinoza','74133678',19,'2002-11-09','GEN02','ESTC03','952287018','GuEs01@hotmail.com','Urb. El Triunfo 167','CR002','SD006','U049','kOy8uc'),(50,'EM050','Adriana','Rodríguez','77121521',35,'1987-02-07','GEN02','ESTC02','924072616','AdRo03@hotmail.com','Calle Spreen 706','CR002','SD007','U050','Ag7as5'),(51,'EM051','Beltrán','Díaz','77564052',53,'1968-09-17','GEN01','ESTC02','923028416','BeDí30@outlook.com','Urb. German Garmendia 371','CR001','SD005','U051','coac2J'),(52,'EM052','José','Campbell','73313112',30,'1991-10-09','GEN01','ESTC01','964621206','JoCa66@hotmail.com','Calle Los Portales 790','CR001','SD007','U052','WU7fw4'),(53,'EM053','Julieta','Thomas','72106400',37,'1985-02-10','GEN02','ESTC01','908578010','JuTh00@gmail.com','Av. Blueberry 280','CR004','SD005','U053','INrtq6'),(54,'EM054','Agustín','Vargas','78008165',30,'1991-06-25','GEN01','ESTC02','933362426','AgVa44@hotmail.com','Av. Brazil 396','CR002','SD003','U054','bV5jpt'),(55,'EM055','Irai','Scott','78580246',24,'1997-09-24','GEN01','ESTC02','926447568','IrSc21@gmail.com','Urb. El Triunfo 155','CR003','SD003','U055','etskVm'),(56,'EM056','Claudia','Jones','74410350',48,'1973-08-25','GEN02','ESTC02','920664502','ClJo84@outlook.com','Calle Cascanuesces 941','CR001','SD007','U056','5vrSwo'),(57,'EM057','Laura','Sánchez','73882154',32,'1990-02-14','GEN02','ESTC02','973235801','LaSá54@gmail.com','Urb. El Olivar 630','CR001','SD006','U057','31b8nD'),(58,'EM058','Azariel','López','71448410',61,'1961-02-01','GEN01','ESTC02','983448407','AzLó71@outlook.com','Urb. Blueberry 995','CR003','SD004','U058','hcka8p'),(59,'EM059','Alejandra','Romero','71747124',61,'1961-03-27','GEN02','ESTC01','955801543','AlRo71@outlook.com','Calle Cascanuesces 803','CR001','SD009','U059','B155gl'),(60,'EM060','María','Vásquez','77072555',29,'1993-04-27','GEN02','ESTC02','935035201','MaVá21@gmail.com','Calle Los Olivos 275','CR002','SD003','U060','31gN7K'),(61,'EM061','Briana','Baker','78677500',22,'2000-05-13','GEN02','ESTC03','966413154','BrBa42@gmail.com','Urb. Spreen 539','CR002','SD009','U061','Or2aml'),(62,'EM062','Alexa','GOnzales','76864200',52,'1969-09-16','GEN02','ESTC02','960665146','AlGO82@gmail.com','Av. Don Ibai 481','CR002','SD007','U062','dEX78k'),(63,'EM063','Abigail','Allen','71763806',33,'1989-05-04','GEN02','ESTC01','960434334','AbAl50@outlook.com','Calle Spreen 774','CR003','SD004','U063','r2anUb'),(64,'EM064','Germán','GOnzales','76118567',20,'2001-09-10','GEN01','ESTC01','914013642','GeGO02@outlook.com','Av. Los Olivos 757','CR003','SD003','U064','puvb1g'),(65,'EM065','Camila','López','74827728',21,'2000-09-26','GEN02','ESTC02','910812270','CaLó61@outlook.com','Calle Don Ibai 916','CR003','SD004','U065','es8X7h'),(66,'EM066','Esteban','Murphy','75866588',72,'1950-05-09','GEN01','ESTC03','916341670','EsMu05@gmail.com','Calle Gonzales Prada 955','CR002','SD003','U066','ubgYfk'),(67,'EM067','Juan','Rodríguez','76731288',59,'1963-02-16','GEN01','ESTC03','927683376','JuRo23@gmail.com','Urb. Blueberry 219','CR004','SD008','U067','avwthO'),(68,'EM068','Edivaldo','Hernández','75717867',28,'1993-10-09','GEN01','ESTC01','942782478','EdHe08@gmail.com','Av. Auron 106','CR002','SD005','U068','vMM3pf'),(69,'EM069','Ariana','Jackson','71231873',63,'1958-06-19','GEN02','ESTC03','937406817','ArJa53@gmail.com','Calle Santiago Wagner 290','CR001','SD005','U069','I6g57C'),(70,'EM070','Ana Sofía','Williams','74112448',58,'1964-03-16','GEN02','ESTC02','951543527','AnWi56@gmail.com','Urb. El Triunfo 384','CR001','SD004','U070','39qi5l'),(71,'EM071','Laura','López','70542350',55,'1966-06-08','GEN02','ESTC03','947421742','LaLó05@outlook.com','Calle Spreen 487','CR001','SD007','U071','wyaiKj'),(72,'EM072','Paulin','Mendoza','76823684',58,'1963-10-17','GEN02','ESTC02','930438010','PaMe42@hotmail.com','Calle Los Olivos 433','CR003','SD004','U072','i1mwg1'),(73,'EM073','Iyad','Torres','74181433',31,'1991-01-26','GEN01','ESTC01','901868178','IyTo38@outlook.com','Urb. Santiago Wagner 895','CR001','SD007','U073','78tf3x'),(74,'EM074','Andrea','Mitchell','71008308',71,'1950-08-01','GEN02','ESTC01','951734713','AnMi65@outlook.com','Av. Gonzales Prada 382','CR002','SD004','U074','p6r5Gr'),(75,'EM075','María José','Carter','77288571',59,'1963-03-26','GEN02','ESTC02','942251215','MaCa57@hotmail.com','Av. Buenaventura 836','CR003','SD002','U075','e3Dhlc'),(76,'EM076','Alexa','Nelson','74186781',34,'1987-08-08','GEN02','ESTC03','961280386','AlNe57@hotmail.com','Urb. Santiago Wagner 351','CR003','SD003','U076','pmDFbt'),(77,'EM077','Adriana','López','78388764',52,'1969-10-18','GEN02','ESTC03','926640282','AdLó15@gmail.com','Calle El Mariana 534','CR001','SD009','U077','q5V5Nu'),(78,'EM078','Juanita','Cruz','75437536',61,'1960-09-09','GEN02','ESTC03','912651854','JuCr23@outlook.com','Calle Los Portales 419','CR001','SD004','U078','3qce4l'),(79,'EM079','Elena','Turner','72261243',42,'1979-06-04','GEN02','ESTC03','941616227','ElTu15@outlook.com','Calle Cascanuesces 549','CR001','SD009','U079','o43jd3'),(80,'EM080','Crisólogo','Young','78150627',53,'1968-08-17','GEN01','ESTC03','920666866','CrYo26@gmail.com','Urb. German Garmendia 331','CR001','SD009','U080','wmonYT'),(81,'EM081','Ariana','Miller','72205718',30,'1991-08-09','GEN02','ESTC02','974733473','ArMi02@gmail.com','Calle Blueberry 981','CR003','SD008','U081','j3mtd5'),(82,'EM082','Martina','Jackson','72087873',60,'1961-09-25','GEN02','ESTC02','961280013','MaJa20@gmail.com','Calle Geronimo 287','CR001','SD004','U082','vdlko6'),(83,'EM083','Abdiel','Torres','74675517',20,'2001-10-07','GEN01','ESTC03','937254672','AbTo31@gmail.com','Urb. Blueberry 486','CR002','SD008','U083','qyflvf'),(84,'EM084','María Fernanda','Wright','74064720',53,'1968-07-24','GEN02','ESTC03','926163545','MaWr76@gmail.com','Calle El Triunfo 163','CR002','SD007','U084','eH4jVx'),(85,'EM085','Alba','Pérez','78052681',46,'1976-03-11','GEN02','ESTC01','934037605','AlPé32@gmail.com','Calle Spreen 127','CR004','SD007','U085','cImbcS'),(86,'EM086','Natalie','Jackson','73076374',31,'1991-01-07','GEN02','ESTC01','906353806','NaJa71@outlook.com','Av. Buenaventura 550','CR003','SD004','U086','3xroUt'),(87,'EM087','Darío','Wilson','77784264',69,'1953-01-17','GEN01','ESTC01','924407743','DaWi27@hotmail.com','Av. Brazil 131','CR001','SD002','U087','S8vAor'),(88,'EM088','Luciana','Turner','72882443',30,'1991-06-06','GEN02','ESTC01','960817271','LuTu87@hotmail.com','Urb. Los Olivos 774','CR004','SD005','U088','Ayjw2u'),(89,'EM089','Gael','Torres','76004357',54,'1967-09-21','GEN01','ESTC02','976564146','GaTo42@gmail.com','Av. Spreen 856','CR002','SD001','U089','K72d2B'),(90,'EM090','Irai','García','78130301',60,'1961-09-14','GEN01','ESTC02','980485155','IrGa66@outlook.com','Av. Don Ibai 785','CR004','SD008','U090','pFEhAw'),(91,'EM091','Guido','Torres','78786664',22,'2000-03-08','GEN01','ESTC01','988751112','GuTo05@hotmail.com','Av. Buenaventura 790','CR004','SD006','U091','Fhau7E'),(92,'EM092','Jorge','Mendoza','76212445',65,'1956-10-08','GEN01','ESTC03','982656363','JoMe42@gmail.com','Av. Brazil 476','CR001','SD002','U092','qejpe6'),(93,'EM093','Abraham','Mendoza','77838468',64,'1957-08-04','GEN01','ESTC02','938462111','AbMe22@gmail.com','Calle Brazil 736','CR003','SD003','U093','cqhkwi'),(94,'EM094','Zigor','Murphy','74125568',66,'1955-07-18','GEN01','ESTC01','906445802','ZiMu63@outlook.com','Av. German Garmendia 164','CR003','SD001','U094','1e7ywu'),(95,'EM095','Galo','Pérez','77462623',55,'1966-07-11','GEN01','ESTC01','936853458','GaPé30@gmail.com','Av. Los Olivos 675','CR003','SD008','U095','h7l4yy'),(96,'EM096','Climen','Salazar','78267380',48,'1973-07-17','GEN01','ESTC01','918841080','ClSa40@hotmail.com','Av. Auron 168','CR003','SD002','U096','16jcnL'),(97,'EM097','Baltasar','Mendoza','78341301',58,'1963-06-17','GEN01','ESTC01','962661175','BaMe15@gmail.com','Av. Gonzales Prada 436','CR002','SD005','U097','cvrCki'),(98,'EM098','Aldo','Díaz','76840870',46,'1976-02-23','GEN01','ESTC01','912812057','AlDí44@outlook.com','Av. El Mariana 629','CR001','SD003','U098','772624'),(99,'EM099','Akos','Flores','74685830',22,'2000-03-14','GEN01','ESTC02','966780571','AkFl11@outlook.com','Av. Miguel Angel162','CR004','SD002','U099','E3pjjy'),(100,'EM100','Giulio','Gómez','78161181',34,'1988-05-03','GEN01','ESTC01','906214835','GiGó26@outlook.com','Av. Miguel Angel806','CR002','SD007','U100','5YDh39'),(101,'EM101','Algimantas','Taylor','73735771',50,'1971-07-23','GEN01','ESTC03','978850034','AlTa40@hotmail.com','Av. Santiago Wagner 791','CR002','SD007','U101','N6PoJw'),(102,'EM102','Alba','Salazar','75748254',52,'1969-08-13','GEN02','ESTC01','937321025','AlSa47@hotmail.com','Calle Miguel Angel605','CR004','SD004','U102','yrahBn'),(103,'EM103','Ashley','Espinoza','72741407',35,'1986-10-23','GEN02','ESTC01','901502222','AsEs15@outlook.com','Av. Samuel de Luque 700','CR001','SD009','U103','gl81bo'),(104,'EM104','Misael','Murphy','78530531',22,'2000-02-21','GEN01','ESTC03','921824707','MiMu31@hotmail.com','Urb. Santiago Wagner 933','CR004','SD006','U104','2Ckggp'),(105,'EM105','Isabella','Ruiz','71050804',39,'1982-08-18','GEN02','ESTC02','946023174','IsRu15@gmail.com','Calle German Garmendia 842','CR001','SD006','U105','wW6ode'),(106,'EM106','Constanza','Anderson','75384327',24,'1997-06-10','GEN02','ESTC02','958138608','CoAn80@hotmail.com','Av. Auron 605','CR003','SD002','U106','4Iisdw'),(107,'EM107','Andrés','Carter','71755268',63,'1958-07-18','GEN01','ESTC01','955204233','AnCa03@hotmail.com','Calle Los Olivos 861','CR003','SD005','U107','7l46hn'),(108,'EM108','Clara','Hall','72224232',30,'1992-03-22','GEN02','ESTC01','912537858','ClHa20@hotmail.com','Urb. San Martin 498','CR002','SD007','U108','av8O8h'),(109,'EM109','Renata','White','78045371',58,'1964-03-14','GEN02','ESTC02','902437648','ReWh58@gmail.com','Av. Blueberry 439','CR003','SD001','U109','YfH8js'),(110,'EM110','Crisólogo','Martin','78480008',31,'1991-01-08','GEN01','ESTC03','986553866','CrMa65@outlook.com','Calle Blueberry 129','CR004','SD002','U110','262rcK'),(111,'EM111','Guim','Edwards','78088458',30,'1992-03-24','GEN01','ESTC01','916823337','GuEd65@outlook.com','Urb. San Martin 385','CR003','SD005','U111','Sp4xwj'),(112,'EM112','Aitana','Martínez','75057053',63,'1959-02-17','GEN02','ESTC02','943430155','AiMa64@outlook.com','Calle Don Ibai 332','CR002','SD004','U112','uAhMrH'),(113,'EM113','Sergio','Parker','71217883',53,'1969-01-03','GEN01','ESTC01','911014451','SePa40@gmail.com','Av. Spreen 434','CR003','SD003','U113','Siyw47'),(114,'EM114','Sara','Baker','71308485',37,'1985-01-15','GEN02','ESTC02','960602138','SaBa74@gmail.com','Av. Auron 490','CR002','SD004','U114','dv3kM2'),(115,'EM115','Camila','Flores','78827363',65,'1957-02-07','GEN02','ESTC03','936536125','CaFl11@outlook.com','Urb. Miguel Angel890','CR002','SD007','U115','kAl4or'),(116,'EM116','Constantí','Rojas','76166036',26,'1995-11-05','GEN01','ESTC01','988681602','CoRo24@outlook.com','Av. Brazil 364','CR004','SD008','U116','2y6y5q'),(117,'EM117','Daniel','Baker','77184326',55,'1967-05-22','GEN01','ESTC03','960678235','DaBa35@outlook.com','Calle El Mariana 898','CR001','SD003','U117','DqTx1c'),(118,'EM118','Luca','Johnson','77630576',50,'1972-04-24','GEN01','ESTC02','950311025','LuJo11@hotmail.com','Calle Gonzales Prada 596','CR004','SD006','U118','lf4KBl'),(119,'EM119','Martina','Hernández','77040304',55,'1967-03-26','GEN02','ESTC01','965627542','MaHe26@outlook.com','Calle Los Portales 200','CR002','SD003','U119','8jR5L2'),(120,'EM120','Diana','Ramos','74052072',65,'1956-10-07','GEN02','ESTC02','946518047','DiRa64@hotmail.com','Calle Los Olivos 784','CR002','SD006','U120','ipjWDx'),(121,'EM121','Ashur','Castillo','72207852',46,'1976-02-19','GEN01','ESTC03','923327761','AsCa14@outlook.com','Av. El Mariana 733','CR004','SD007','U121','e2mKcl'),(122,'EM122','Aran','Young','76086181',33,'1989-02-22','GEN01','ESTC02','961451575','ArYo12@outlook.com','Urb. Miguel Angel774','CR002','SD007','U122','17G1sg'),(123,'EM123','Michelle','López','75826534',52,'1970-03-23','GEN02','ESTC01','914814828','MiLó61@outlook.com','Calle Blueberry 822','CR004','SD006','U123','x24bFe'),(124,'EM124','Adonis','Lee','74155058',24,'1998-03-24','GEN01','ESTC01','968653106','AdLe51@outlook.com','Calle San Martin 676','CR002','SD006','U124','pB3ovm'),(125,'EM125','Damen','Roberts','78770662',33,'1988-10-05','GEN01','ESTC01','936837106','DaRo10@hotmail.com','Urb. El Triunfo 442','CR004','SD006','U125','4eg3tm'),(126,'EM126','Julieta','Pérez','70531821',44,'1977-08-16','GEN02','ESTC03','903025478','JuPé61@outlook.com','Calle Brazil 306','CR001','SD006','U126','x84ejK'),(127,'EM127','Ariana','Espinoza','78628322',54,'1967-10-26','GEN02','ESTC03','938053204','ArEs62@gmail.com','Urb. Spreen 336','CR002','SD001','U127','yyLuwD'),(128,'EM128','Aleix','Lewis','70738601',70,'1951-07-18','GEN01','ESTC02','907571111','AlLe55@hotmail.com','Av. Geronimo 594','CR003','SD005','U128','mty9hS'),(129,'EM129','Mía','GOnzales','71811613',29,'1992-09-03','GEN02','ESTC01','936667061','MíGO87@outlook.com','Av. Cascanuesces 215','CR003','SD001','U129','wemTqq'),(130,'EM130','Angela','Salazar','75263828',36,'1985-08-06','GEN02','ESTC03','983505648','AnSa40@gmail.com','Av. Buenaventura 633','CR004','SD009','U130','qFbfcg'),(131,'EM131','Carolina','Jones','72721273',32,'1990-01-04','GEN02','ESTC03','958152804','CaJo60@gmail.com','Calle Cascanuesces 871','CR003','SD007','U131','roevGN'),(132,'EM132','Guifre','López','73866147',46,'1976-02-03','GEN01','ESTC03','928270482','GuLó16@hotmail.com','Av. Auron 457','CR002','SD007','U132','1tnv1C'),(133,'EM133','Monserrat','Moore','72523101',41,'1980-10-01','GEN02','ESTC02','986217764','MoMo06@gmail.com','Av. Cascanuesces 935','CR004','SD007','U133','C2sqt5'),(134,'EM134','Manuela','Pérez','75121455',38,'1984-05-03','GEN02','ESTC01','957365528','MaPé00@outlook.com','Urb. Gonzales Prada 352','CR002','SD008','U134','62ygvK'),(135,'EM135','Claudia','Rivera','70018123',68,'1954-01-05','GEN02','ESTC01','962213823','ClRi87@gmail.com','Calle Spreen 461','CR001','SD006','U135','gb6jA5'),(136,'EM136','Gastón','Roberts','73586571',24,'1998-04-19','GEN01','ESTC01','946583873','GaRo06@outlook.com','Av. Spreen 569','CR004','SD004','U136','CKnDxy'),(137,'EM137','Enric','Walker','78118641',63,'1959-03-09','GEN01','ESTC01','987757648','EnWa87@outlook.com','Urb. Buenaventura 688','CR001','SD002','U137','8DgtIa'),(138,'EM138','Lionel','Clark','74712166',37,'1984-06-01','GEN01','ESTC03','984832488','LiCl37@outlook.com','Av. Miguel Angel668','CR003','SD002','U138','ysksbD'),(139,'EM139','Morena','Davis','75308865',42,'1980-05-18','GEN02','ESTC01','981752853','MoDa48@hotmail.com','Urb. Geronimo 321','CR002','SD001','U139','gr54lw'),(140,'EM140','Nael','Fernández','78360220',48,'1973-09-09','GEN01','ESTC02','927581354','NaFe38@hotmail.com','Av. El Mariana 308','CR002','SD007','U140','JVj1xx'),(141,'EM141','Anish','Castro','74584814',37,'1985-05-01','GEN01','ESTC02','947216842','AnCa11@gmail.com','Urb. Samuel de Luque 241','CR002','SD009','U141','u8Yycl'),(142,'EM142','Alejandra','Moore','76233054',56,'1965-09-14','GEN02','ESTC02','931476775','AlMo62@hotmail.com','Urb. Gonzales Prada 722','CR004','SD006','U142','4u512B'),(143,'EM143','Julia','Parker','71606622',61,'1960-06-16','GEN02','ESTC01','966721473','JuPa26@hotmail.com','Av. El Mariana 278','CR001','SD006','U143','aOayU9'),(144,'EM144','Eñaut','Rivera','77768363',68,'1953-08-16','GEN01','ESTC01','912623187','EñRi80@hotmail.com','Urb. Blueberry 921','CR003','SD009','U144','xxlbsw'),(145,'EM145','Isabel','Murphy','77084110',34,'1987-07-09','GEN02','ESTC02','904835375','IsMu07@gmail.com','Calle El Triunfo 642','CR004','SD004','U145','8lS9Pe'),(146,'EM146','Paula','Roberts','74808745',56,'1966-03-13','GEN02','ESTC03','986554107','PaRo77@hotmail.com','Urb. Samuel de Luque 996','CR004','SD003','U146','clen23'),(147,'EM147','Arián','Cruz','75450578',53,'1968-07-14','GEN01','ESTC02','921237712','ArCr67@outlook.com','Av. Don Ibai 661','CR003','SD006','U147','jotpvh'),(148,'EM148','Antonella','Fernández','72672607',28,'1993-11-05','GEN02','ESTC01','966404221','AnFe15@gmail.com','Urb. Buenaventura 245','CR001','SD007','U148','f5pmt6'),(149,'EM149','Sara','Stewart','77210733',45,'1977-05-24','GEN02','ESTC02','921042650','SaSt73@gmail.com','Urb. Los Portales 556','CR002','SD003','U149','lta9j4'),(150,'EM150','Dariel','Young','78830633',49,'1972-08-14','GEN01','ESTC03','906738351','DaYo03@hotmail.com','Calle Buenaventura 941','CR003','SD006','U150','wxKE2s'),(151,'EM151','Natalia','Ramírez','78785086',43,'1978-09-15','GEN02','ESTC03','983837778','NaRa11@gmail.com','Urb. Spreen 416','CR004','SD003','U151','ytq1AM'),(152,'EM152','Nicolás','Stewart','73445146',56,'1966-05-13','GEN01','ESTC03','952414262','NiSt28@gmail.com','Calle Don Ibai 600','CR001','SD008','U152','qenLho'),(153,'EM153','Paloma','Mendoza','70153120',70,'1951-07-20','GEN02','ESTC02','967433707','PaMe16@hotmail.com','Av. El Olivar 289','CR004','SD007','U153','5E46Ls'),(154,'EM154','Artur','Taylor','77283032',40,'1981-11-11','GEN01','ESTC02','946112681','ArTa01@gmail.com','Calle El Olivar 520','CR004','SD008','U154','YjU9oG'),(155,'EM155','Mariana','Pérez','75804426',51,'1970-08-21','GEN02','ESTC03','958102837','MaPé82@outlook.com','Urb. Santiago Wagner 307','CR003','SD001','U155','Ihvbe4'),(156,'EM156','Elena','Walker','75415113',26,'1996-05-13','GEN02','ESTC01','952086226','ElWa28@hotmail.com','Av. Santiago Wagner 177','CR004','SD006','U156','ykdmKE'),(157,'EM157','Sara','Scott','74114835',27,'1995-03-11','GEN02','ESTC01','945524360','SaSc14@gmail.com','Urb. Brazil 824','CR001','SD007','U157','ErymKl'),(158,'EM158','Regina','Rogers','77508570',57,'1964-06-21','GEN02','ESTC01','947003660','ReRo10@hotmail.com','Av. El Mariana 322','CR004','SD007','U158','U8wdMy'),(159,'EM159','Neo','Huamán','77837432',58,'1964-05-07','GEN01','ESTC01','986736074','NeHu00@gmail.com','Av. Samuel de Luque 524','CR002','SD008','U159','g12fFh'),(160,'EM160','Akos','Nelson','73823204',69,'1952-07-17','GEN01','ESTC03','928640004','AkNe01@outlook.com','Calle El Olivar 378','CR004','SD002','U160','GyArPn'),(161,'EM161','Monserrat','Díaz','77418402',36,'1985-07-01','GEN02','ESTC02','975187510','MoDí17@hotmail.com','Av. Los Olivos 759','CR002','SD007','U161','egdnR2'),(162,'EM162','Abigail','Castro','71347564',56,'1965-09-24','GEN02','ESTC02','923217141','AbCa77@hotmail.com','Calle Los Portales 524','CR004','SD002','U162','3o22fp'),(163,'EM163','Emilia','Romero','77507208',21,'2000-08-16','GEN02','ESTC01','940512475','EmRo68@hotmail.com','Calle Los Portales 215','CR004','SD005','U163','gIflfX'),(164,'EM164','Abril','Scott','77001400',66,'1955-08-04','GEN02','ESTC01','943531157','AbSc10@outlook.com','Av. Brazil 781','CR004','SD005','U164','h5qvFo'),(165,'EM165','Juanita','Murphy','73453061',61,'1961-01-09','GEN02','ESTC03','961448510','JuMu32@gmail.com','Av. El Olivar 591','CR001','SD001','U165','JcC3iF'),(166,'EM166','Àlvar','Ramos','73672765',54,'1968-05-20','GEN01','ESTC02','976677343','ÀlRa61@gmail.com','Calle German Garmendia 979','CR004','SD003','U166','2p9Twg'),(167,'EM167','Otto','Gómez','71686817',38,'1984-04-17','GEN01','ESTC03','965812033','OtGó75@hotmail.com','Urb. San Martin 389','CR004','SD003','U167','otb2N5'),(168,'EM168','Guadalupe','Morales','75284524',72,'1950-01-22','GEN02','ESTC01','978520870','GuMo18@outlook.com','Av. Gonzales Prada 276','CR001','SD008','U168','XS3v81'),(169,'EM169','Guido','Roberts','74883883',37,'1984-09-10','GEN01','ESTC03','941740761','GuRo78@outlook.com','Calle San Martin 611','CR003','SD001','U169','c5jimi'),(170,'EM170','Martina','Cruz','76027580',31,'1991-05-18','GEN02','ESTC03','902115183','MaCr84@outlook.com','Urb. German Garmendia 472','CR002','SD008','U170','245Cld'),(171,'EM171','Artur','Sánchez','75421500',50,'1972-01-08','GEN01','ESTC02','964368853','ArSá66@outlook.com','Calle El Triunfo 181','CR001','SD003','U171','h98skg'),(172,'EM172','Andrea','Mamani','74303768',66,'1955-09-13','GEN02','ESTC01','923242848','AnMa74@gmail.com','Urb. El Triunfo 731','CR003','SD005','U172','eUk51k'),(173,'EM173','Guido','White','74053005',58,'1964-03-03','GEN01','ESTC03','947173654','GuWh60@gmail.com','Urb. Gonzales Prada 507','CR003','SD005','U173','bvejoi'),(174,'EM174','Alejandro','Ortiz','76150134',47,'1975-04-07','GEN01','ESTC02','981480181','AlOr45@outlook.com','Av. Gonzales Prada 563','CR004','SD007','U174','unx9o8'),(175,'EM175','Cosme','Jackson','75470488',69,'1953-01-18','GEN01','ESTC02','901642106','CoJa45@hotmail.com','Calle Los Portales 960','CR001','SD004','U175','fQj9b5'),(176,'EM176','Grober','Rogers','72200171',19,'2002-09-27','GEN01','ESTC01','913808645','GrRo74@outlook.com','Av. Samuel de Luque 755','CR004','SD004','U176','h4P6V2'),(177,'EM177','Ángel','Gutiérrez','76781841',23,'1998-09-27','GEN01','ESTC02','952555875','ÁnGu66@hotmail.com','Calle El Triunfo 875','CR003','SD004','U177','HOyIeP'),(178,'EM178','Sara','Ruiz','78038433',51,'1971-02-25','GEN02','ESTC02','946720561','SaRu44@outlook.com','Av. Los Portales 825','CR002','SD007','U178','c2x5kE'),(179,'EM179','Camila','Taylor','70627005',33,'1988-10-01','GEN02','ESTC02','984833048','CaTa87@outlook.com','Calle Cascanuesces 644','CR001','SD005','U179','DQo79m'),(180,'EM180','Julieta','Jones','77350104',28,'1994-05-11','GEN02','ESTC01','936326021','JuJo32@gmail.com','Urb. Don Ibai 613','CR004','SD002','U180','e3K4o1'),(181,'EM181','Luciana','Mitchell','72714577',66,'1956-02-10','GEN02','ESTC01','965313872','LuMi28@gmail.com','Urb. Los Portales 797','CR001','SD002','U181','jl8m5f'),(182,'EM182','Andrea','Chávez','70475700',66,'1955-08-27','GEN02','ESTC03','912614754','AnCh13@gmail.com','Calle Miguel Angel333','CR001','SD005','U182','ljIHAW'),(183,'EM183','Ahzià','Nelson','74035441',31,'1991-01-16','GEN01','ESTC01','970330664','AhNe25@hotmail.com','Urb. Brazil 313','CR003','SD005','U183','934pqr'),(184,'EM184','Andrea','Vargas','74154401',70,'1951-07-16','GEN02','ESTC03','970018285','AnVa71@gmail.com','Calle El Triunfo 927','CR001','SD002','U184','6EoLov'),(185,'EM185','Allison','Ruiz','72787838',60,'1962-04-18','GEN02','ESTC02','945835037','AlRu60@hotmail.com','Calle El Olivar 223','CR003','SD002','U185','P8hyhc'),(186,'EM186','Ángel','Díaz','74014715',72,'1950-03-17','GEN01','ESTC03','973603700','ÁnDí34@outlook.com','Calle Geronimo 750','CR001','SD005','U186','Ok97et'),(187,'EM187','Lucía','Morales','75072705',72,'1950-04-10','GEN02','ESTC03','917456735','LuMo57@gmail.com','Calle Geronimo 566','CR004','SD006','U187','HBl9U8'),(188,'EM188','Abril','Parker','76300564',45,'1977-01-17','GEN02','ESTC02','934037826','AbPa52@gmail.com','Av. Brazil 492','CR003','SD001','U188','q1E7E9'),(189,'EM189','Emily','Flores','78610123',63,'1958-10-22','GEN02','ESTC01','961810430','EmFl01@gmail.com','Calle Spreen 873','CR002','SD008','U189','8Vx9H5'),(190,'EM190','Bárbara','Clark','71606767',34,'1987-06-14','GEN02','ESTC01','903433725','BáCl86@hotmail.com','Urb. San Martin 256','CR003','SD001','U190','3y6xRk'),(191,'EM191','Sara','Hernández','71818203',23,'1998-09-02','GEN02','ESTC03','942422547','SaHe42@hotmail.com','Av. Geronimo 283','CR001','SD005','U191','9q7eE2'),(192,'EM192','Ahzià','Davis','74024111',30,'1992-02-21','GEN01','ESTC02','917827632','AhDa27@hotmail.com','Av. Buenaventura 541','CR003','SD006','U192','4V359d'),(193,'EM193','Alexa','Gómez','74858555',29,'1993-05-06','GEN02','ESTC03','901626716','AlGó44@outlook.com','Urb. Miguel Angel471','CR002','SD001','U193','1gkYiT'),(194,'EM194','Abigail','Fernández','78502202',67,'1955-01-06','GEN02','ESTC03','971334867','AbFe41@gmail.com','Av. Brazil 165','CR003','SD003','U194','T6je9l'),(195,'EM195','Pilar','Flores','76683401',40,'1982-03-15','GEN02','ESTC01','984417788','PiFl44@hotmail.com','Urb. Los Olivos 812','CR002','SD006','U195','3n1ihb'),(196,'EM196','Carles','Espinoza','73313362',20,'2001-08-11','GEN01','ESTC03','946440310','CaEs21@gmail.com','Calle Buenaventura 584','CR004','SD001','U196','vcpiPI'),(197,'EM197','Eloi','Pérez','76150842',61,'1960-09-09','GEN01','ESTC02','983627618','ElPé61@gmail.com','Urb. Buenaventura 514','CR003','SD007','U197','te6ePn'),(198,'EM198','Florencia','Miller','73885162',51,'1970-09-27','GEN02','ESTC01','962625233','FlMi10@outlook.com','Urb. El Mariana 462','CR003','SD008','U198','1LcE4x'),(199,'EM199','Melissa','Adams','78155224',69,'1953-05-14','GEN02','ESTC01','917345106','MeAd26@gmail.com','Urb. Santiago Wagner 874','CR001','SD007','U199','dv2wKY'),(200,'EM200','Juliana','Johnson','75782383',49,'1973-03-12','GEN02','ESTC03','945638035','JuJo77@hotmail.com','Av. Los Portales 789','CR004','SD008','U200','mDF53b'),(201,'EM201','Alejandra','Pérez','77864318',57,'1965-02-07','GEN02','ESTC02','986356025','AlPé64@hotmail.com','Urb. Miguel Angel403','CR003','SD003','U201','4aYPlb'),(202,'EM202','Bianca','Flores','73813718',57,'1964-10-24','GEN02','ESTC02','977478012','BiFl00@outlook.com','Av. El Triunfo 260','CR004','SD004','U202','YHr9jw'),(203,'EM203','Guadalupe','Sánchez','70506188',71,'1951-03-21','GEN02','ESTC02','920122741','GuSá77@outlook.com','Calle Cascanuesces 914','CR002','SD001','U203','3d2p7s'),(204,'EM204','Ashley','Vargas','78344084',45,'1977-01-22','GEN02','ESTC01','985126683','AsVa33@gmail.com','Av. San Martin 964','CR001','SD009','U204','3cQyQ2'),(205,'EM205','Samantha','Harris','75452480',68,'1953-09-22','GEN02','ESTC02','903060787','SaHa65@gmail.com','Urb. El Olivar 843','CR001','SD005','U205','t5xeaj'),(206,'EM206','Catalina','Ramos','72613530',27,'1995-01-23','GEN02','ESTC01','968714117','CaRa85@hotmail.com','Av. Samuel de Luque 674','CR004','SD002','U206','ya9f6r'),(207,'EM207','Valeria','Fernández','71811754',41,'1981-03-22','GEN02','ESTC01','971452772','VaFe15@gmail.com','Av. El Olivar 324','CR003','SD006','U207','i5PLnx'),(208,'EM208','María','Castillo','78783438',64,'1958-02-18','GEN02','ESTC01','968224212','MaCa22@gmail.com','Urb. German Garmendia 294','CR003','SD003','U208','rdPYj4'),(209,'EM209','Lola','Gutiérrez','70377877',57,'1965-04-15','GEN02','ESTC02','932865050','LoGu88@gmail.com','Calle Santiago Wagner 750','CR004','SD005','U209','L6galm'),(210,'EM210','Eufemio','Edwards','74755677',52,'1969-08-20','GEN01','ESTC02','931001003','EuEd35@outlook.com','Urb. Blueberry 784','CR001','SD001','U210','6em7g3'),(211,'EM211','Gadiel','Hall','73421402',38,'1984-04-05','GEN01','ESTC02','948347088','GaHa03@outlook.com','Urb. Cascanuesces 423','CR003','SD007','U211','o196Jh'),(212,'EM212','María José','Thompson','77847066',40,'1981-11-24','GEN02','ESTC03','985716320','MaTh05@gmail.com','Calle Gonzales Prada 715','CR001','SD002','U212','so3v6t'),(213,'EM213','Paloma','Roberts','76808515',38,'1984-02-09','GEN02','ESTC02','945661617','PaRo08@gmail.com','Urb. Santiago Wagner 166','CR002','SD003','U213','qYsIW9'),(214,'EM214','Natalia','Rivera','74664775',23,'1998-06-21','GEN02','ESTC03','983506476','NaRi00@gmail.com','Calle Buenaventura 901','CR001','SD005','U214','ia7kFt'),(215,'EM215','Mariana','Jackson','73411064',54,'1968-05-07','GEN02','ESTC01','927885273','MaJa10@gmail.com','Av. San Martin 186','CR003','SD001','U215','vrl4dm'),(216,'EM216','Caleb','Hall','77626537',42,'1979-06-06','GEN01','ESTC02','918161254','CaHa40@outlook.com','Urb. Santiago Wagner 346','CR002','SD002','U216','yllSPp'),(217,'EM217','Leónidas','Roberts','72131361',23,'1999-01-15','GEN01','ESTC01','932416261','LeRo16@outlook.com','Av. Geronimo 450','CR004','SD009','U217','6PpG29'),(218,'EM218','Sabrina','Wright','70882455',68,'1954-04-07','GEN02','ESTC02','900516713','SaWr47@hotmail.com','Urb. Miguel Angel564','CR002','SD001','U218','FSCf4g'),(219,'EM219','Foudil','Ortiz','71704566',41,'1980-11-14','GEN01','ESTC03','971651401','FoOr35@gmail.com','Urb. Brazil 182','CR002','SD004','U219','Oegm3c'),(220,'EM220','Agustina','Torres','78575583',51,'1970-07-07','GEN02','ESTC02','968018338','AgTo63@gmail.com','Urb. San Martin 281','CR003','SD002','U220','HxlpT3'),(221,'EM221','Bernat','GOnzales','74062108',67,'1954-09-04','GEN01','ESTC02','967363848','BeGO40@gmail.com','Calle German Garmendia 482','CR004','SD005','U221','5bosje'),(222,'EM222','Pilar','Stewart','75736873',61,'1961-03-08','GEN02','ESTC01','921774701','PiSt77@outlook.com','Calle Blueberry 941','CR001','SD005','U222','gogf2r'),(223,'EM223','Laura','Flores','75350348',28,'1994-04-24','GEN02','ESTC01','900464185','LaFl04@gmail.com','Urb. Blueberry 146','CR004','SD007','U223','mk2kb9'),(224,'EM224','Taha','Williams','75072162',38,'1984-05-12','GEN01','ESTC01','980780173','TaWi57@outlook.com','Av. Spreen 722','CR003','SD005','U224','698m3w'),(225,'EM225','Biel','Salazar','71552848',63,'1959-01-07','GEN01','ESTC02','908681307','BiSa58@gmail.com','Urb. Spreen 475','CR001','SD007','U225','js3qu2'),(226,'EM226','Arnau','Castillo','73622566',33,'1988-07-17','GEN01','ESTC01','903540806','ArCa46@hotmail.com','Urb. San Martin 690','CR004','SD002','U226','yh438w'),(227,'EM227','Gabriela','López','71337065',72,'1950-04-15','GEN02','ESTC01','913735578','GaLó34@gmail.com','Calle Buenaventura 591','CR003','SD001','U227','S6T6xu'),(228,'EM228','Fiorenzo','Martínez','74775552',39,'1983-05-02','GEN01','ESTC03','954702400','FiMa56@hotmail.com','Calle Cascanuesces 677','CR003','SD001','U228','EA7f9e'),(229,'EM229','Laura','López','72710086',59,'1962-10-26','GEN02','ESTC01','950203366','LaLó16@hotmail.com','Av. Buenaventura 636','CR002','SD001','U229','qgp7P3'),(230,'EM230','Rebeca','Chávez','77770118',35,'1987-02-03','GEN02','ESTC02','915186843','ReCh28@hotmail.com','Urb. Spreen 563','CR003','SD009','U230','3p9Qy3'),(231,'EM231','Sara','Mamani','76143500',45,'1977-05-14','GEN02','ESTC02','924123301','SaMa15@outlook.com','Calle El Olivar 720','CR003','SD006','U231','uvj3bi'),(232,'EM232','Delmiro','Sánchez','70716881',49,'1973-05-06','GEN01','ESTC02','937302308','DeSá11@hotmail.com','Calle German Garmendia 271','CR003','SD002','U232','Gm6nbr'),(233,'EM233','Gael','Allen','74735158',26,'1995-07-12','GEN01','ESTC01','985187380','GaAl08@hotmail.com','Av. Buenaventura 784','CR004','SD006','U233','j2lToh'),(234,'EM234','Artur','Collins','74211231',64,'1958-05-05','GEN01','ESTC01','944171174','ArCo43@gmail.com','Calle Samuel de Luque 494','CR001','SD003','U234','Okaeoa'),(235,'EM235','Sofía','Young','73702608',20,'2002-05-22','GEN02','ESTC03','941772205','SoYo55@outlook.com','Calle El Olivar 654','CR002','SD009','U235','3medJ9'),(236,'EM236','Micaela','Pérez','73427237',51,'1970-09-15','GEN02','ESTC02','927766221','MiPé54@hotmail.com','Calle German Garmendia 261','CR001','SD004','U236','sJt6Fe'),(237,'EM237','María','Wilson','77856204',37,'1984-08-16','GEN02','ESTC02','948828514','MaWi87@gmail.com','Av. Don Ibai 967','CR004','SD006','U237','6P94lY'),(238,'EM238','Neo','Morales','73840034',52,'1970-05-22','GEN01','ESTC02','967047054','NeMo22@outlook.com','Av. San Martin 926','CR002','SD008','U238','km2hVB'),(239,'EM239','Victoria','Mitchell','73754865',45,'1977-02-23','GEN02','ESTC02','972052573','ViMi76@outlook.com','Urb. Gonzales Prada 958','CR001','SD007','U239','x8l1ro'),(240,'EM240','Emily','López','76458566',20,'2002-02-24','GEN02','ESTC01','907634546','EmLó14@gmail.com','Urb. Gonzales Prada 770','CR002','SD006','U240','oh7Uvk'),(241,'EM241','Demócrito','Wright','70625707',43,'1979-04-05','GEN01','ESTC03','977887030','DeWr17@hotmail.com','Av. El Olivar 656','CR004','SD002','U241','ug9hR5'),(242,'EM242','Baltasar','Romero','72647715',55,'1966-09-21','GEN01','ESTC02','975152680','BaRo85@hotmail.com','Urb. Auron 631','CR004','SD007','U242','rivwhf'),(243,'EM243','Andrea','Rodríguez','70237608',22,'2000-05-17','GEN02','ESTC02','942565043','AnRo74@gmail.com','Av. Geronimo 729','CR001','SD003','U243','Yonqp1'),(244,'EM244','Camila','Flores','76132545',27,'1995-02-26','GEN02','ESTC03','983128408','CaFl30@gmail.com','Av. El Triunfo 574','CR003','SD006','U244','gjn3hq'),(245,'EM245','Eneas','Thomas','76480558',29,'1992-09-24','GEN01','ESTC03','961850746','EnTh68@outlook.com','Calle Los Portales 600','CR003','SD009','U245','eehA3k'),(246,'EM246','Gabriel','Lee','75633385',69,'1953-03-14','GEN01','ESTC02','980626830','GaLe50@hotmail.com','Calle El Mariana 549','CR002','SD001','U246','815f6l'),(247,'EM247','Ariel','Castillo','76117170',30,'1992-01-19','GEN01','ESTC01','904341683','ArCa06@gmail.com','Av. El Mariana 257','CR004','SD005','U247','xcouid'),(248,'EM248','Ana Sofía','Flores','70727885',51,'1971-05-14','GEN02','ESTC01','923304071','AnFl17@hotmail.com','Calle Spreen 300','CR002','SD006','U248','Iw7Mgv'),(249,'EM249','Cesc','Torres','77075850',62,'1959-06-11','GEN01','ESTC02','972483372','CeTo27@gmail.com','Urb. Blueberry 889','CR003','SD004','U249','o6cpLd'),(250,'EM250','Ahzià','Nelson','70268410',33,'1988-06-04','GEN01','ESTC02','986010240','AhNe13@outlook.com','Calle Santiago Wagner 957','CR002','SD007','U250','Qr8eQ7'),(251,'EM251','Stephanie','Murphy','78428344',34,'1987-07-11','GEN02','ESTC01','942115125','StMu70@outlook.com','Calle Samuel de Luque 102','CR003','SD009','U251','5mm3qX'),(252,'EM252','Diana','Rivera','77272684',60,'1962-05-07','GEN02','ESTC03','910013413','DiRi68@gmail.com','Urb. Los Olivos 549','CR003','SD004','U252','6H7ul8'),(253,'EM253','Samantha','Walker','74868387',41,'1980-08-05','GEN02','ESTC01','927435460','SaWa80@hotmail.com','Calle Geronimo 634','CR004','SD009','U253','Lk61sv'),(254,'EM254','Carlos','Phillips','70605661',54,'1968-03-19','GEN01','ESTC03','901524682','CaPh86@gmail.com','Urb. Miguel Angel147','CR002','SD004','U254','1a48um'),(255,'EM255','Íker','Sánchez','72288428',44,'1978-01-10','GEN01','ESTC02','982234702','ÍkSá36@hotmail.com','Av. Brazil 338','CR003','SD008','U255','nkU5A8'),(256,'EM256','María Fernanda','Carter','71444016',53,'1969-03-17','GEN02','ESTC02','957053573','MaCa21@gmail.com','Calle Los Olivos 536','CR001','SD001','U256','5eduqx'),(257,'EM257','Ensa','Rodríguez','77718728',64,'1958-01-07','GEN01','ESTC02','924645040','EnRo30@outlook.com','Av. German Garmendia 459','CR003','SD002','U257','9p74A5'),(258,'EM258','Valerie','Díaz','76803648',42,'1980-02-12','GEN02','ESTC02','906353421','VaDí41@gmail.com','Urb. El Triunfo 323','CR003','SD008','U258','p7toe5'),(259,'EM259','Fátima','Johnson','73685455',36,'1985-10-05','GEN02','ESTC01','963080065','FáJo64@hotmail.com','Av. Buenaventura 348','CR002','SD003','U259','emWiFp'),(260,'EM260','Félix','Miller','75533471',29,'1993-02-18','GEN01','ESTC02','932031207','FéMi74@hotmail.com','Av. Los Portales 389','CR001','SD007','U260','8QfNs4'),(261,'EM261','María','Fernández','74656652',33,'1988-08-20','GEN02','ESTC01','920166642','MaFe30@gmail.com','Av. Miguel Angel201','CR002','SD009','U261','ex4reX'),(262,'EM262','Alejandro','Taylor','77547881',54,'1967-09-22','GEN01','ESTC02','906251751','AlTa33@hotmail.com','Urb. Los Portales 629','CR001','SD005','U262','VdyqrV'),(263,'EM263','Alexandra','López','78713368',27,'1995-01-14','GEN02','ESTC02','950584870','AlLó51@hotmail.com','Calle El Olivar 670','CR002','SD001','U263','2tv1yC'),(264,'EM264','Hugo','Espinoza','72765536',59,'1963-01-23','GEN01','ESTC01','932806316','HuEs55@gmail.com','Calle Blueberry 582','CR002','SD007','U264','uW3g1X'),(265,'EM265','Angela','Edwards','74804775',29,'1993-05-19','GEN02','ESTC01','950455577','AnEd53@gmail.com','Urb. Don Ibai 628','CR004','SD005','U265','98vBUc'),(266,'EM266','Zoe','Cruz','72537801',36,'1985-06-01','GEN02','ESTC03','977135437','ZoCr60@hotmail.com','Calle San Martin 516','CR003','SD001','U266','598YoX'),(267,'EM267','Radu','Torres','77830814',24,'1997-09-04','GEN01','ESTC02','958367627','RaTo46@hotmail.com','Calle San Martin 552','CR003','SD005','U267','Vx9Sr1'),(268,'EM268','Climen','Stewart','75248408',39,'1982-08-25','GEN01','ESTC02','941875220','ClSt53@gmail.com','Urb. Samuel de Luque 284','CR002','SD003','U268','VkGxBp'),(269,'EM269','Policarpo','Torres','72333863',29,'1993-05-18','GEN01','ESTC02','984012167','PoTo30@hotmail.com','Calle German Garmendia 227','CR002','SD003','U269','3cnNkr'),(270,'EM270','Fiorenzo','Sánchez','71672472',46,'1975-09-09','GEN01','ESTC01','917555137','FiSá65@gmail.com','Urb. Brazil 986','CR003','SD001','U270','vm2mxp'),(271,'EM271','Lucía','Lee','71288551',29,'1992-09-08','GEN02','ESTC02','930762721','LuLe51@hotmail.com','Urb. Don Ibai 340','CR003','SD003','U271','1sTqpd'),(272,'EM272','Sabrina','López','74615133',21,'2001-03-23','GEN02','ESTC03','901626152','SaLó41@hotmail.com','Calle Brazil 233','CR004','SD005','U272','ekK1TB'),(273,'EM273','Fabián','Cruz','76608245',56,'1965-08-26','GEN01','ESTC02','917647214','FaCr06@hotmail.com','Av. Cascanuesces 824','CR003','SD005','U273','qnGpac'),(274,'EM274','Nicole','GOnzales','73467383',24,'1997-10-24','GEN02','ESTC02','983822374','NiGO80@gmail.com','Av. Geronimo 450','CR004','SD004','U274','oaonYF'),(275,'EM275','Florencia','Ortiz','71608508',48,'1973-08-02','GEN02','ESTC02','965018716','FlOr86@outlook.com','Calle Los Portales 112','CR003','SD006','U275','NT4wyv'),(276,'EM276','Ana María','Evans','78682787',71,'1951-05-19','GEN02','ESTC01','965336184','AnEv04@gmail.com','Urb. German Garmendia 693','CR003','SD001','U276','uvrUqf'),(277,'EM277','Engracio','Rodríguez','72150754',24,'1998-02-21','GEN01','ESTC02','930013566','EnRo36@gmail.com','Urb. Auron 956','CR004','SD003','U277','f87RCw'),(278,'EM278','Aitana','Vargas','78173884',55,'1967-03-09','GEN02','ESTC03','935162365','AiVa80@hotmail.com','Calle Blueberry 109','CR004','SD002','U278','dle995'),(279,'EM279','Elena','Gutiérrez','74686256',37,'1985-01-21','GEN02','ESTC01','910348587','ElGu23@outlook.com','Calle Gonzales Prada 551','CR003','SD001','U279','mxbf69'),(280,'EM280','Victoria','Gutiérrez','73288625',67,'1954-10-13','GEN02','ESTC01','968530318','ViGu75@outlook.com','Calle Gonzales Prada 542','CR001','SD003','U280','ULhdF4'),(281,'EM281','Valerie','Mamani','76764324',26,'1996-05-24','GEN02','ESTC01','962111744','VaMa57@hotmail.com','Calle Santiago Wagner 180','CR003','SD009','U281','JCpn71'),(282,'EM282','Giulio','Harris','78755341',35,'1986-07-20','GEN01','ESTC02','956801441','GiHa84@outlook.com','Calle El Mariana 788','CR002','SD002','U282','UM1gda'),(283,'EM283','Emma','Huamán','76581378',50,'1972-02-13','GEN02','ESTC03','907607763','EmHu24@gmail.com','Calle German Garmendia 595','CR001','SD007','U283','n4s3XX'),(284,'EM284','Agustín','Salazar','77302335',61,'1960-11-18','GEN01','ESTC01','945127383','AgSa87@outlook.com','Urb. El Mariana 174','CR003','SD006','U284','p7v92r'),(285,'EM285','Diana','Edwards','73575815',26,'1995-10-22','GEN02','ESTC03','955063481','DiEd71@hotmail.com','Urb. Spreen 886','CR002','SD002','U285','rR6qcQ'),(286,'EM286','Elías','Huamán','78306274',59,'1963-01-19','GEN01','ESTC01','944058661','ElHu76@outlook.com','Av. Miguel Angel294','CR001','SD009','U286','dhAqto'),(287,'EM287','Arián','Mitchell','71434286',48,'1974-02-02','GEN01','ESTC01','961034865','ArMi83@hotmail.com','Calle San Martin 112','CR003','SD003','U287','uq4ist'),(288,'EM288','Ashley','Rojas','71385412',19,'2002-07-24','GEN02','ESTC03','917484373','AsRo81@outlook.com','Av. El Mariana 357','CR003','SD008','U288','Dai1Me'),(289,'EM289','Constanza','Walker','75011651',34,'1987-10-10','GEN02','ESTC03','952344305','CoWa86@hotmail.com','Av. Gonzales Prada 708','CR004','SD005','U289','5DXdEx'),(290,'EM290','Darío','Harris','75267651',24,'1997-06-26','GEN01','ESTC01','921337185','DaHa82@outlook.com','Calle Geronimo 607','CR003','SD001','U290','gQ9joE'),(291,'EM291','Briana','Taylor','74444478',47,'1974-05-27','GEN02','ESTC02','912682013','BrTa58@gmail.com','Urb. Geronimo 800','CR004','SD006','U291','ymp32p'),(292,'EM292','Melissa','Collins','75431381',49,'1972-07-20','GEN02','ESTC01','908562857','MeCo85@gmail.com','Calle Geronimo 165','CR003','SD009','U292','371cYy'),(293,'EM293','Arián','García','74678744',55,'1967-02-01','GEN01','ESTC01','921604200','ArGa16@outlook.com','Calle Don Ibai 258','CR001','SD003','U293','3dKxx2'),(294,'EM294','María','Rivera','70408050',66,'1956-03-19','GEN02','ESTC03','925058484','MaRi03@gmail.com','Urb. German Garmendia 317','CR001','SD005','U294','341mcd'),(295,'EM295','Hermes','Mendoza','73315071',24,'1997-06-02','GEN01','ESTC01','981111051','HeMe23@gmail.com','Urb. Auron 517','CR002','SD002','U295','eHiwv6'),(296,'EM296','Camila','Ramírez','77777203',60,'1962-05-24','GEN02','ESTC01','956485342','CaRa32@outlook.com','Av. El Triunfo 942','CR004','SD007','U296','lKDhvr'),(297,'EM297','Abril','Brown','70860702',29,'1993-02-17','GEN02','ESTC01','911220574','AbBr56@outlook.com','Urb. Cascanuesces 884','CR002','SD006','U297','56ymi7'),(298,'EM298','Emilia','Taylor','75077737',35,'1987-05-14','GEN02','ESTC03','958811880','EmTa52@gmail.com','Av. El Olivar 909','CR002','SD008','U298','R2Cvgv'),(299,'EM299','Valeria','Vargas','76878565',29,'1993-01-20','GEN02','ESTC02','922517167','VaVa51@gmail.com','Urb. Don Ibai 751','CR002','SD007','U299','6bxveh'),(300,'EM300','Stephanie','Ramírez','74410016',63,'1958-11-04','GEN02','ESTC02','904464518','StRa51@outlook.com','Av. Don Ibai 123','CR001','SD007','U300','9uQ7lq'),(301,'EM301','Isabel','Díaz','78713354',52,'1970-03-16','GEN02','ESTC01','902201856','IsDí65@outlook.com','Av. Auron 556','CR001','SD006','U301','l4twun'),(302,'EM302','Ana María','Carter','71544401',66,'1955-08-08','GEN02','ESTC03','943806285','AnCa03@outlook.com','Urb. Spreen 965','CR004','SD005','U302','bnYfy3'),(303,'EM303','Mariana','Hall','73572210',52,'1970-05-13','GEN02','ESTC03','946372063','MaHa23@hotmail.com','Calle El Mariana 429','CR003','SD007','U303','EH6Mua'),(304,'EM304','Ezequiel','Taylor','76476086',28,'1993-07-19','GEN01','ESTC03','946880060','EzTa40@gmail.com','Av. El Triunfo 269','CR004','SD002','U304','sN6lfO'),(305,'EM305','Candela','Vásquez','78825122',26,'1995-06-21','GEN02','ESTC02','921700711','CaVá84@outlook.com','Urb. Auron 735','CR001','SD005','U305','dh56Q6'),(306,'EM306','Paula','Jackson','75205823',22,'2000-03-06','GEN02','ESTC02','955713563','PaJa07@gmail.com','Av. Geronimo 163','CR004','SD008','U306','xrV4xu'),(307,'EM307','Valentina','Fernández','70132378',26,'1996-04-25','GEN02','ESTC02','914835313','VaFe86@gmail.com','Av. Los Olivos 701','CR004','SD002','U307','Jw5wJW'),(308,'EM308','Sofía','Evans','78737150',63,'1958-11-03','GEN02','ESTC03','952341206','SoEv78@gmail.com','Urb. Gonzales Prada 521','CR003','SD005','U308','BD2n89'),(309,'EM309','Valentina','Robinson','76217523',26,'1996-02-22','GEN02','ESTC03','952078870','VaRo60@hotmail.com','Calle Auron 477','CR004','SD002','U309','Syxq6a'),(310,'EM310','Isabel','Pérez','73686126',63,'1958-06-23','GEN02','ESTC01','960442847','IsPé88@hotmail.com','Av. Los Olivos 136','CR002','SD008','U310','B6onGC'),(311,'EM311','María','Cruz','74516488',43,'1978-10-09','GEN02','ESTC01','962531228','MaCr68@gmail.com','Urb. German Garmendia 660','CR004','SD002','U311','3X6ym8'),(312,'EM312','Carles','Jackson','76851215',32,'1989-10-12','GEN01','ESTC02','900107644','CaJa23@outlook.com','Av. Auron 790','CR004','SD001','U312','v28nw4'),(313,'EM313','Alexa','Gómez','72378450',29,'1992-06-22','GEN02','ESTC03','974757746','AlGó06@hotmail.com','Av. San Martin 927','CR001','SD001','U313','DsPr5y'),(314,'EM314','Guadalupe','Gómez','70053218',46,'1975-07-13','GEN02','ESTC01','902415280','GuGó30@hotmail.com','Calle Miguel Angel300','CR001','SD005','U314','qxmxCK'),(315,'EM315','Ana María','Wilson','76447528',52,'1970-04-09','GEN02','ESTC02','974701154','AnWi27@hotmail.com','Calle Blueberry 975','CR002','SD006','U315','1nm3mt'),(316,'EM316','Camila','Clark','76473662',64,'1958-05-01','GEN02','ESTC01','932440642','CaCl51@hotmail.com','Urb. Los Olivos 684','CR002','SD009','U316','lu476h'),(317,'EM317','Dilan','Ramírez','78175586',59,'1962-07-25','GEN01','ESTC01','964184585','DiRa73@outlook.com','Calle Miguel Angel500','CR001','SD004','U317','Bbg9u3'),(318,'EM318','Stephanie','Mendoza','74258624',31,'1990-06-10','GEN02','ESTC03','922382333','StMe73@outlook.com','Calle El Mariana 399','CR004','SD004','U318','Acderq'),(319,'EM319','Paula','López','72385858',27,'1994-06-13','GEN02','ESTC03','936157360','PaLó02@outlook.com','Av. El Mariana 345','CR001','SD005','U319','6y8jB8'),(320,'EM320','Guim','Morris','78568473',45,'1977-04-03','GEN01','ESTC01','921025448','GuMo52@outlook.com','Calle Auron 598','CR001','SD007','U320','qr1hrx'),(321,'EM321','Ana','Sánchez','76035800',45,'1976-08-05','GEN02','ESTC03','921205527','AnSá57@hotmail.com','Calle El Triunfo 790','CR004','SD006','U321','gIC82b'),(322,'EM322','Marc','Ruiz','73065308',23,'1999-04-25','GEN01','ESTC03','957561510','MaRu50@gmail.com','Calle Cascanuesces 239','CR004','SD009','U322','op9iyp'),(323,'EM323','Giorgio','Gómez','73546832',20,'2002-05-10','GEN01','ESTC03','977172453','GiGó73@outlook.com','Av. Blueberry 419','CR001','SD001','U323','sEwROh'),(324,'EM324','Bianca','Thompson','76786424',34,'1987-06-27','GEN02','ESTC02','938105447','BiTh57@outlook.com','Av. Los Olivos 895','CR001','SD002','U324','tmGycv'),(325,'EM325','Paloma','Turner','77438755',52,'1969-11-18','GEN02','ESTC01','935684586','PaTu32@gmail.com','Calle San Martin 316','CR001','SD006','U325','Gg1baV'),(326,'EM326','Climen','Baker','71408413',45,'1976-07-10','GEN01','ESTC02','912576543','ClBa58@gmail.com','Urb. Auron 733','CR001','SD004','U326','gjliWb'),(327,'EM327','Efraín','Evans','74122887',36,'1985-07-02','GEN01','ESTC02','974553014','EfEv22@gmail.com','Urb. San Martin 918','CR001','SD001','U327','ihrnRx'),(328,'EM328','Julia','Sánchez','70745544',23,'1998-10-14','GEN02','ESTC02','907674082','JuSá02@outlook.com','Calle German Garmendia 751','CR004','SD007','U328','s5nGvO'),(329,'EM329','Abigail','Cruz','72756273',57,'1965-05-22','GEN02','ESTC03','973424831','AbCr16@hotmail.com','Av. Los Olivos 222','CR004','SD009','U329','Drknr8'),(330,'EM330','Melanie','Pérez','75587226',45,'1976-11-18','GEN02','ESTC01','977872823','MePé56@hotmail.com','Urb. Brazil 764','CR004','SD007','U330','haphTp'),(331,'EM331','Daniela','Phillips','74205205',41,'1981-03-12','GEN02','ESTC01','916481380','DaPh13@hotmail.com','Av. Gonzales Prada 183','CR001','SD004','U331','DlespI'),(332,'EM332','Vanessa','García','75028374',44,'1978-02-17','GEN02','ESTC02','981715068','VaGa10@gmail.com','Calle Miguel Angel240','CR001','SD001','U332','h259ed'),(333,'EM333','Engracio','Gutiérrez','78354231',41,'1981-04-16','GEN01','ESTC03','962478721','EnGu13@outlook.com','Calle Blueberry 371','CR002','SD008','U333','VxJ3j2'),(334,'EM334','Alexandra','Smith','76555532',39,'1982-11-06','GEN02','ESTC03','930536401','AlSm55@hotmail.com','Av. El Olivar 729','CR002','SD003','U334','st3RAs'),(335,'EM335','Candela','Ortiz','76183016',46,'1976-04-12','GEN02','ESTC01','911547644','CaOr13@outlook.com','Av. El Olivar 381','CR003','SD003','U335','a23A1d'),(336,'EM336','Aitana','Pérez','77485224',40,'1982-04-17','GEN02','ESTC03','922627740','AiPé62@hotmail.com','Calle Buenaventura 485','CR003','SD008','U336','VArehy'),(337,'EM337','Catalina','Fernández','76407428',56,'1966-04-14','GEN02','ESTC03','971485734','CaFe12@gmail.com','Av. Buenaventura 525','CR001','SD001','U337','eQl4um'),(338,'EM338','Édgar','López','76036105',62,'1960-01-21','GEN01','ESTC03','904431854','ÉdLó88@outlook.com','Calle Brazil 530','CR002','SD007','U338','q75hWf'),(339,'EM339','Lionel','Campbell','72170176',25,'1996-10-09','GEN01','ESTC02','967431610','LiCa71@gmail.com','Urb. San Martin 714','CR004','SD002','U339','k2buW9'),(340,'EM340','Blai','López','72128173',66,'1956-01-14','GEN01','ESTC03','967016088','BlLó12@outlook.com','Av. Cascanuesces 518','CR004','SD009','U340','RLqMr9'),(341,'EM341','Andrea','Roberts','73102405',24,'1998-02-03','GEN02','ESTC03','961842322','AnRo03@gmail.com','Urb. San Martin 768','CR004','SD007','U341','oXI91k'),(342,'EM342','Emma','Pérez','76733431',45,'1976-10-27','GEN02','ESTC03','927507783','EmPé45@outlook.com','Urb. German Garmendia 639','CR002','SD004','U342','aBv1V2'),(343,'EM343','Juanita','Murphy','78660461',40,'1981-09-16','GEN02','ESTC02','914741520','JuMu42@gmail.com','Urb. Geronimo 771','CR001','SD007','U343','9uMwkf'),(344,'EM344','Alejandra','Rojas','74154853',62,'1959-09-20','GEN02','ESTC02','916430101','AlRo00@hotmail.com','Calle Los Portales 501','CR004','SD007','U344','5jBD4a'),(345,'EM345','Natalia','López','74065245',20,'2001-11-02','GEN02','ESTC03','927182158','NaLó52@gmail.com','Urb. Samuel de Luque 140','CR003','SD006','U345','5kfc55'),(346,'EM346','Carlos','Clark','75411215',68,'1954-05-25','GEN01','ESTC01','976466036','CaCl73@gmail.com','Calle Santiago Wagner 722','CR001','SD008','U346','dtxjrv'),(347,'EM347','Ariel','Fernández','73233076',31,'1990-09-23','GEN01','ESTC03','987265520','ArFe35@gmail.com','Calle El Mariana 497','CR002','SD002','U347','xd2cFd'),(348,'EM348','Crisólogo','Pérez','75833448',35,'1987-01-20','GEN01','ESTC02','923475484','CrPé71@gmail.com','Calle Gonzales Prada 499','CR002','SD008','U348','638P8x'),(349,'EM349','Victoria','Thompson','78154671',52,'1970-05-08','GEN02','ESTC01','925837311','ViTh42@hotmail.com','Av. German Garmendia 680','CR001','SD002','U349','F1r6vf'),(350,'EM350','Gaspar','Gómez','78145667',52,'1970-05-24','GEN01','ESTC02','911814342','GaGó68@hotmail.com','Calle Geronimo 424','CR004','SD005','U350','riniuU'),(351,'EM351','Felipe','Lewis','70218386',37,'1984-10-14','GEN01','ESTC03','920063634','FeLe72@hotmail.com','Calle San Martin 528','CR003','SD003','U351','xk6lE8'),(352,'EM352','Paula','Pérez','70447788',21,'2001-05-04','GEN02','ESTC01','937076866','PaPé13@hotmail.com','Urb. Geronimo 433','CR001','SD006','U352','etcHeM'),(353,'EM353','Pilar','Ortiz','70407777',19,'2002-10-14','GEN02','ESTC01','978070628','PiOr73@outlook.com','Urb. Don Ibai 995','CR002','SD003','U353','iviLgv'),(354,'EM354','Nicole','Gutiérrez','76007308',24,'1998-01-09','GEN02','ESTC01','983004225','NiGu04@outlook.com','Av. Brazil 840','CR003','SD001','U354','OqqC9y'),(355,'EM355','Ensa','Huamán','72501222',68,'1954-01-05','GEN01','ESTC01','928612866','EnHu28@hotmail.com','Calle German Garmendia 573','CR002','SD004','U355','1YScf8'),(356,'EM356','Josefina','Lee','76274083',43,'1979-03-10','GEN02','ESTC03','915768824','JoLe57@hotmail.com','Av. Spreen 736','CR002','SD002','U356','aMqx9q'),(357,'EM357','Fabián','Jackson','74568258',46,'1975-08-04','GEN01','ESTC02','924330784','FaJa70@gmail.com','Av. Geronimo 516','CR001','SD002','U357','wbvYMr'),(358,'EM358','María','Roberts','78484515',41,'1980-09-08','GEN02','ESTC01','916044765','MaRo33@gmail.com','Av. Auron 932','CR002','SD006','U358','jwcn2d'),(359,'EM359','Gautam','Lee','76410803',64,'1958-01-14','GEN01','ESTC01','913280585','GaLe55@outlook.com','Av. Cascanuesces 955','CR003','SD002','U359','Vx71q6'),(360,'EM360','Daniela','Rivera','73737000',60,'1961-09-18','GEN02','ESTC01','910546771','DaRi66@hotmail.com','Av. Gonzales Prada 793','CR001','SD005','U360','HclcX7'),(361,'EM361','Daniel','Sánchez','78141377',29,'1993-04-01','GEN01','ESTC02','913833563','DaSá18@outlook.com','Av. Blueberry 763','CR002','SD005','U361','U3k6jb'),(362,'EM362','Ana','Williams','77880437',27,'1995-02-07','GEN02','ESTC01','931043777','AnWi37@outlook.com','Calle Los Portales 451','CR002','SD001','U362','nths7u'),(363,'EM363','Nicole','Morales','74268206',19,'2002-09-01','GEN02','ESTC01','988038887','NiMo67@hotmail.com','Calle German Garmendia 933','CR002','SD004','U363','35e7qK'),(364,'EM364','Pilar','Mamani','72311575',32,'1990-05-19','GEN02','ESTC03','948655254','PiMa60@outlook.com','Urb. Spreen 530','CR003','SD008','U364','7Urcam'),(365,'EM365','Ramsés','Stewart','74281355',20,'2001-06-03','GEN01','ESTC01','971008317','RaSt47@outlook.com','Urb. Spreen 107','CR001','SD006','U365','X3Lure'),(366,'EM366','Lucía','White','77747450',64,'1958-03-03','GEN02','ESTC01','923086813','LuWh87@outlook.com','Calle Gonzales Prada 483','CR002','SD001','U366','Avm69L'),(367,'EM367','Paulin','Parker','71713602',39,'1982-06-07','GEN02','ESTC02','916357061','PaPa45@outlook.com','Urb. Don Ibai 281','CR002','SD007','U367','av2p7N'),(368,'EM368','Iyad','Clark','77738845',65,'1957-04-15','GEN01','ESTC01','901772717','IyCl66@hotmail.com','Urb. Auron 895','CR001','SD005','U368','yFvu17'),(369,'EM369','Gabriela','Adams','73610246',50,'1972-03-12','GEN02','ESTC03','963004146','GaAd42@hotmail.com','Urb. El Olivar 227','CR002','SD003','U369','xseEbI'),(370,'EM370','Paulin','Chávez','76676650',44,'1978-02-09','GEN02','ESTC03','977383262','PaCh62@gmail.com','Av. Auron 144','CR001','SD008','U370','tj6ebr'),(371,'EM371','Bárbara','Ramírez','73803631',33,'1988-11-25','GEN02','ESTC01','937407103','BáRa23@gmail.com','Calle Cascanuesces 888','CR004','SD005','U371','rcbBpp'),(372,'EM372','Cosme','Mamani','71223875',67,'1955-02-12','GEN01','ESTC02','903724802','CoMa37@outlook.com','Av. Miguel Angel952','CR002','SD002','U372','DACnHv'),(373,'EM373','María José','Sánchez','71458267',40,'1981-09-17','GEN02','ESTC01','934545051','MaSá02@hotmail.com','Urb. El Mariana 541','CR001','SD007','U373','eG13ca'),(374,'EM374','Briana','Lewis','75234582',58,'1963-11-25','GEN02','ESTC01','961420044','BrLe05@gmail.com','Urb. El Mariana 766','CR003','SD004','U374','uef9ro'),(375,'EM375','Tao','Baker','71737064',51,'1970-07-18','GEN01','ESTC01','914242318','TaBa75@outlook.com','Urb. Los Olivos 914','CR001','SD002','U375','52jcxQ'),(376,'EM376','Andrés','Pérez','72704322',57,'1965-05-13','GEN01','ESTC03','988864286','AnPé71@gmail.com','Calle San Martin 360','CR001','SD006','U376','73cGdh'),(377,'EM377','Carlos','Taylor','77657846',45,'1977-03-01','GEN01','ESTC01','951706206','CaTa81@gmail.com','Calle Don Ibai 154','CR003','SD007','U377','UJyQ1S'),(378,'EM378','Danilo','Murphy','77412716',56,'1965-11-16','GEN01','ESTC03','938704284','DaMu71@hotmail.com','Av. Buenaventura 366','CR003','SD003','U378','YUYw5r'),(379,'EM379','Rómulo','Wright','78462555',61,'1960-09-15','GEN01','ESTC01','964057081','RóWr34@outlook.com','Calle Miguel Angel297','CR001','SD005','U379','8VdBM9'),(380,'EM380','Lier','Pérez','71841536',44,'1978-03-24','GEN01','ESTC02','962088545','LiPé50@hotmail.com','Calle Blueberry 912','CR004','SD002','U380','v61l7j'),(381,'EM381','Catalina','Gutiérrez','78766336',64,'1958-03-03','GEN02','ESTC02','920000818','CaGu32@outlook.com','Av. Geronimo 222','CR001','SD001','U381','Oq1wL3'),(382,'EM382','Iyán','Ortiz','74662064',42,'1979-06-11','GEN01','ESTC01','971844415','IyOr10@outlook.com','Calle El Triunfo 968','CR002','SD005','U382','j7j8yd'),(383,'EM383','Juanita','Morales','78184357',43,'1978-09-19','GEN02','ESTC03','911005636','JuMo05@hotmail.com','Av. El Triunfo 699','CR001','SD001','U383','2L2423'),(384,'EM384','Caleb','Harris','72060205',31,'1991-01-18','GEN01','ESTC03','968724417','CaHa55@outlook.com','Urb. Samuel de Luque 188','CR004','SD009','U384','4bemwO'),(385,'EM385','Mariana','Brown','71388760',59,'1962-07-17','GEN02','ESTC02','957575755','MaBr26@outlook.com','Av. Buenaventura 688','CR003','SD002','U385','FerceS'),(386,'EM386','Alexandra','Walker','77281383',42,'1980-03-13','GEN02','ESTC03','903524530','AlWa70@hotmail.com','Urb. El Triunfo 367','CR003','SD007','U386','wcyo51'),(387,'EM387','Stephanie','Miller','75172015',35,'1987-03-14','GEN02','ESTC01','941245085','StMi75@hotmail.com','Calle El Triunfo 280','CR004','SD001','U387','Sn7gG4'),(388,'EM388','Regina','Rivera','73350602',28,'1993-07-27','GEN02','ESTC01','914664186','ReRi44@hotmail.com','Av. Don Ibai 193','CR004','SD006','U388','h6k7Gd'),(389,'EM389','Gaspar','Ramos','76448146',42,'1979-08-01','GEN01','ESTC02','932776522','GaRa62@hotmail.com','Av. Gonzales Prada 871','CR004','SD007','U389','ht41s3'),(390,'EM390','Paola','García','72201654',40,'1981-11-17','GEN02','ESTC01','946433738','PaGa64@hotmail.com','Av. Cascanuesces 306','CR003','SD002','U390','T1KEqu'),(391,'EM391','Eliseo','Hernández','74062824',59,'1963-02-26','GEN01','ESTC02','976085305','ElHe08@hotmail.com','Calle Gonzales Prada 966','CR004','SD002','U391','tw8825'),(392,'EM392','Mariana','Davis','71014513',25,'1996-10-04','GEN02','ESTC01','972517210','MaDa26@hotmail.com','Urb. Buenaventura 230','CR002','SD005','U392','u521jq'),(393,'EM393','Zoe','Hall','75401777',68,'1953-07-20','GEN02','ESTC02','932463206','ZoHa20@hotmail.com','Calle Don Ibai 146','CR003','SD006','U393','4mw9ck'),(394,'EM394','Gael','Walker','78015682',38,'1984-02-11','GEN01','ESTC03','911381318','GaWa08@outlook.com','Urb. El Olivar 413','CR004','SD008','U394','tw9gpK'),(395,'EM395','Luciana','Pérez','72873177',37,'1984-06-17','GEN02','ESTC02','914258004','LuPé45@outlook.com','Urb. Brazil 302','CR003','SD004','U395','n2fm15'),(396,'EM396','Abril','Lewis','72212840',37,'1985-01-07','GEN02','ESTC02','985357806','AbLe88@hotmail.com','Av. Blueberry 914','CR002','SD005','U396','gE29Pv'),(397,'EM397','Simeón','Lee','75201662',59,'1963-02-06','GEN01','ESTC01','953711811','SiLe54@gmail.com','Urb. Santiago Wagner 552','CR003','SD007','U397','lar3xn'),(398,'EM398','Florencia','Stewart','74500016',63,'1958-07-13','GEN02','ESTC02','915752321','FlSt18@outlook.com','Urb. San Martin 466','CR002','SD009','U398','3xb8Qb'),(399,'EM399','Antonia','Castro','73166240',58,'1964-01-09','GEN02','ESTC01','983547146','AnCa14@gmail.com','Urb. El Mariana 384','CR001','SD006','U399','9e6kpm'),(400,'EM400','Zoe','Sánchez','73836352',51,'1970-09-10','GEN02','ESTC01','977738148','ZoSá58@gmail.com','Calle El Mariana 713','CR002','SD009','U400','fL9Ul1'),(401,'EM401','Guido','Sánchez','73431403',45,'1976-09-16','GEN01','ESTC01','972356141','GuSá52@outlook.com','Calle Gonzales Prada 815','CR002','SD004','U401','DW2rij'),(402,'EM402','Isidora','López','70383024',42,'1980-04-09','GEN02','ESTC03','952557423','IsLó38@hotmail.com','Urb. German Garmendia 511','CR003','SD002','U402','srbqn9'),(403,'EM403','Catalina','Rojas','74272405',55,'1966-07-24','GEN02','ESTC02','954022820','CaRo35@hotmail.com','Urb. El Triunfo 127','CR002','SD001','U403','xBsIMe'),(404,'EM404','Isabel','López','75843750',72,'1950-03-17','GEN02','ESTC02','978484714','IsLó14@hotmail.com','Calle Blueberry 691','CR003','SD001','U404','rwobS6'),(405,'EM405','Felipe','Arjona','45678912',44,'1977-08-18','GEN01','ESTC02','798456123','sasa@gmail.com','av. Lavanda 2526','CR003','SD007','U405','3k8OtB'),(406,'EM406','Santiago','Munez','45613278',29,'1992-06-13','GEN01','ESTC02','965487321','GIGI@gmail.com','av Lopez 2522','CR004','SD006','U406','rmNi49'),(407,'EM407','Chichobella','Monaguez','95684235',22,'1999-06-18','GEN02','ESTC01','956283147','sasasas@gmail.com','Urb. Robles','CR001','SD004','U407','8qrxv1'),(409,'EM408','Felipe','Castro','45612378',26,'1995-08-15','GEN01','ESTC01','989456123','felipeC@gmail.com','Av. Las serpientes Mz F Lt 25','CR003','SD006','U408','gAxob4');
/*!40000 ALTER TABLE `tb_empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_estadocivil`
--

DROP TABLE IF EXISTS `tb_estadocivil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_estadocivil` (
  `codigo` varchar(8) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_estadocivil`
--

LOCK TABLES `tb_estadocivil` WRITE;
/*!40000 ALTER TABLE `tb_estadocivil` DISABLE KEYS */;
INSERT INTO `tb_estadocivil` VALUES ('ESTC01','Soltero/a'),('ESTC02','Casado/a'),('ESTC03','Divorsiado/a'),('ESTC04','Viudo/a');
/*!40000 ALTER TABLE `tb_estadocivil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_genero`
--

DROP TABLE IF EXISTS `tb_genero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_genero` (
  `codigo` varchar(8) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_genero`
--

LOCK TABLES `tb_genero` WRITE;
/*!40000 ALTER TABLE `tb_genero` DISABLE KEYS */;
INSERT INTO `tb_genero` VALUES ('GEN01','M'),('GEN02','F');
/*!40000 ALTER TABLE `tb_genero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_juego`
--

DROP TABLE IF EXISTS `tb_juego`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_juego` (
  `codigo_` int NOT NULL AUTO_INCREMENT,
  `codigo` varchar(8) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `desarrolladora` varchar(45) NOT NULL,
  `plataforma` varchar(45) DEFAULT NULL,
  `precio` decimal(8,2) NOT NULL,
  `stock` int NOT NULL,
  `categoria` varchar(8) NOT NULL,
  PRIMARY KEY (`codigo_`),
  KEY `categoria` (`categoria`),
  CONSTRAINT `tb_juego_ibfk_1` FOREIGN KEY (`categoria`) REFERENCES `tb_categoria` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_juego`
--

LOCK TABLES `tb_juego` WRITE;
/*!40000 ALTER TABLE `tb_juego` DISABLE KEYS */;
INSERT INTO `tb_juego` VALUES (11,'JG001','Left 4 Dead','PC','Valve Corporation',30.00,964,'CT001'),(12,'JG002','Minecraft','PC','Mojang Studios',25.00,567,'CT001'),(13,'JG003','GTA V','PlayStation 4','Rockstar Games',40.00,539,'CT001'),(14,'JG004','Counter Strike','PC','Valve Corporation',10.00,641,'CT001'),(15,'JG005','Warcraft','PC','Blizzard Entertainment',70.00,824,'CT001'),(16,'JG006','Mario bros 2','WII U','Nintendo Entertainment',35.00,921,'CT001'),(17,'JG007','Valorant','PC','Riot Games',20.00,229,'CT001'),(18,'JG008','Just Dance','WII U','Ubisoft',60.00,466,'CT001'),(19,'JG009','Fornite','PC','Epic Games',15.00,961,'CT001'),(20,'JG010','Mario Kart 8','WII U','Nintendo Entertainment',5.00,146,'CT001');
/*!40000 ALTER TABLE `tb_juego` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_laptop`
--

DROP TABLE IF EXISTS `tb_laptop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_laptop` (
  `codigo_` int NOT NULL AUTO_INCREMENT,
  `codigo` varchar(8) NOT NULL,
  `marca` varchar(45) NOT NULL,
  `modelo` varchar(45) NOT NULL,
  `procesador` varchar(45) NOT NULL,
  `tarjetavideo` varchar(45) NOT NULL,
  `pantalla` varchar(45) NOT NULL,
  `precio` decimal(8,2) NOT NULL,
  `stock` int NOT NULL,
  `categoria` varchar(8) NOT NULL,
  PRIMARY KEY (`codigo_`),
  KEY `categoria` (`categoria`),
  CONSTRAINT `tb_laptop_ibfk_1` FOREIGN KEY (`categoria`) REFERENCES `tb_categoria` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_laptop`
--

LOCK TABLES `tb_laptop` WRITE;
/*!40000 ALTER TABLE `tb_laptop` DISABLE KEYS */;
INSERT INTO `tb_laptop` VALUES (1,'LP001','ACER','Aspire','Intel Core i3','10110U','15.6\"',1400.00,599,'CT003'),(2,'LP002','Lenovo','Ideapad 2','ATHLON','3020e','15.6\"',849.00,699,'CT003'),(3,'LP003','ASUS','M415DA-EB931W','Ryzen 5','DDR4','14\"',1799.00,559,'CT003'),(4,'LP004','HP','15-ef2507la','AMD Ryzen 5 5500U','Natural silver DDR4','15.6\"',1999.00,899,'CT003'),(5,'LP005','Lenovo','IdeaPad 3','Ryzen 5','SDW2','15.6\"',2199.00,1519,'CT003'),(6,'LP006','HP','15-dy2205','Intel Core i5','SSD+Optane','15.6\"',2399.00,435,'CT003'),(7,'LP007','Lenovo','IdeaPad 4','Ryzen 3','SRD 12','14\"',1500.00,637,'CT003'),(8,'LP008','ACER','AShadow','Intel Core i5','10210U','15.6\"',2199.00,597,'CT003'),(9,'LP009','Lenovo','Flex','Intel Celeron','N4020','11.6\"',1449.00,444,'CT003'),(10,'LP010','ASUS','X415JA-EB1361W',' Core i5','intel® UHD Graphics','14\"',1400.00,884,'CT003');
/*!40000 ALTER TABLE `tb_laptop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_laptopgamer`
--

DROP TABLE IF EXISTS `tb_laptopgamer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_laptopgamer` (
  `codigo_` int NOT NULL AUTO_INCREMENT,
  `codigo` varchar(8) NOT NULL,
  `marca` varchar(45) NOT NULL,
  `modelo` varchar(45) NOT NULL,
  `procesador` varchar(45) NOT NULL,
  `tarjetavideo` varchar(45) NOT NULL,
  `size` varchar(45) NOT NULL,
  `precio` decimal(8,2) NOT NULL,
  `stock` int NOT NULL,
  `categoria` varchar(8) NOT NULL,
  PRIMARY KEY (`codigo_`),
  KEY `categoria` (`categoria`),
  CONSTRAINT `tb_laptopgamer_ibfk_1` FOREIGN KEY (`categoria`) REFERENCES `tb_categoria` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_laptopgamer`
--

LOCK TABLES `tb_laptopgamer` WRITE;
/*!40000 ALTER TABLE `tb_laptopgamer` DISABLE KEYS */;
INSERT INTO `tb_laptopgamer` VALUES (1,'LG001','LENOVO','82K1015CUS','11th Gen Intel® Core i5-11300H','GEFORCE RTX 3050 VENTUS 2X 8G OC MSI','Pantalla 15.6\" Full HD',5788.00,602,'CT002'),(2,'LG002','Acer','NITRO 5 15 CI5','Core i5 10300H',' 4GB GDDR6 GIGABYTE GTX 1650 D6 OC HDMI/DP','15.6\"',10599.00,741,'CT002'),(3,'LG003','LENOVO','Legion 7i 16\" 6ta Gen - Storm Grey','11va generación Intel® Core™ i9-11980HK','GEFORCE RTX 2060 VENTUS 12G OC MSI','Pantalla de 16',13498.00,626,'CT002'),(4,'LG004','Asus','TUF F15 FX506LH-HN004W','Intel Core i5','GEFORCE RTX 3080 VENTUS 3X PLUS 12G OC LHR','15.6\"',5999.00,363,'CT002'),(5,'LG005','HP','15-ec1038la - 3Y7A5LA','AMD Ryzen 7','Nvidia Geforce Gtx 1650 Ti 4GB','15.6 Pulgadas',8759.00,578,'CT002'),(6,'LG006','ASUS','FX506LH-HN129W','Intel Core i7','12GB GDDR6 PNY RTX 2060 192BITSB','16.0',6500.00,642,'CT002'),(7,'LG007','HP','3YW42LT','Intel Core i7','GIGABYTE GEFORCE GT 730 2GB GDDR5 64 BIT','15.6',8499.00,165,'CT002'),(8,'LG008','LENOVO','Legion Slim 7 15\" 6ta Gen','AMD Ryzen™ 7 5800H',' GeForce® RTX™ 3060 6GB GDDR6','15.6\"',6298.00,687,'CT002'),(9,'LG009','ASUS','FX506LH-HN004W','Intel® Core™ i5-10300H','NVIDIA® GeForce® GTX 1650','16.0\"',7459.00,325,'CT002'),(10,'LG010','TUF',' FA506IC','AMD Ryzen 5 4600H','NVIDIA® GeForce RTX¿ 3050','16.0',4399.00,354,'CT002');
/*!40000 ALTER TABLE `tb_laptopgamer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_mando`
--

DROP TABLE IF EXISTS `tb_mando`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_mando` (
  `codigo_` int NOT NULL AUTO_INCREMENT,
  `codigo` varchar(8) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `marca` varchar(45) NOT NULL,
  `tipoconex` varchar(45) NOT NULL,
  `precio` double NOT NULL,
  `stock` int NOT NULL,
  `categoria` varchar(8) NOT NULL,
  PRIMARY KEY (`codigo_`),
  KEY `categoria` (`categoria`),
  CONSTRAINT `tb_mando_ibfk_1` FOREIGN KEY (`categoria`) REFERENCES `tb_categoria` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_mando`
--

LOCK TABLES `tb_mando` WRITE;
/*!40000 ALTER TABLE `tb_mando` DISABLE KEYS */;
INSERT INTO `tb_mando` VALUES (21,'MD001','Mando Retro de Conexion','Atpshop','alambrico',20,477,'CT001'),(22,'MD002','Mando Neo Versa Bundle PS4','Sony','inalambrico',350,965,'CT001'),(23,'MD003','Mando Crash Racing Wii','Nintendo','inalambrico',459,684,'CT001'),(24,'MD004','Mando Recargable','Sony','inalambrico',70,654,'CT001'),(25,'MD005','Mando Gamepad','Halion','inalambrico',45,638,'CT001'),(26,'MD006','Dreamger pro','Shadow','alambrico',100,748,'CT001'),(27,'MD007','Mando para celular','Seisa','inalambrico',45,963,'CT001'),(28,'MD008','Thump grips x8','Kuzler','inalambrico',300,951,'CT001'),(29,'MD009','KontrolFreek','Samsung','alambrico',40,665,'CT001'),(30,'MD010','Mando Xtreme','Nox','inalambrico',76,437,'CT001');
/*!40000 ALTER TABLE `tb_mando` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_microfono`
--

DROP TABLE IF EXISTS `tb_microfono`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_microfono` (
  `codigo_` int NOT NULL AUTO_INCREMENT,
  `codigo` varchar(8) NOT NULL,
  `marca` varchar(45) NOT NULL,
  `modelo` varchar(45) NOT NULL,
  `tipoconex` varchar(45) NOT NULL,
  `precio` decimal(12,2) NOT NULL,
  `stock` int NOT NULL,
  `categoria` varchar(8) NOT NULL,
  PRIMARY KEY (`codigo_`),
  KEY `categoria` (`categoria`),
  CONSTRAINT `tb_microfono_ibfk_1` FOREIGN KEY (`categoria`) REFERENCES `tb_categoria` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_microfono`
--

LOCK TABLES `tb_microfono` WRITE;
/*!40000 ALTER TABLE `tb_microfono` DISABLE KEYS */;
INSERT INTO `tb_microfono` VALUES (1,'MC001','HYPERX','Hyperx Quad Cast Standalone','inalambrico',120.00,536,'CT003'),(2,'MC002','Razer','Seiren Mini','alambrico',90.00,299,'CT003'),(3,'MC003','KREED','K9','inalambrico',75.00,547,'CT003'),(4,'MC004','HYPERX','Quadcast HX-MICQC BK','inalambrico',169.00,683,'CT003'),(5,'MC005','Gaming Xtech','Igneus XTH-551','alambrico',89.00,592,'CT003'),(6,'MC006','Headset Gamer','JBL Quantum 100','alambrico',55.00,833,'CT003'),(7,'MC007','Fifine','B09JG62KDJ','inalambrico',145.00,722,'CT003'),(8,'MC008','KREED','K10','inalambrico',110.00,745,'CT003'),(9,'MC009','HYPERX','QuadCast S Standalone','alambrico',99.00,764,'CT003'),(10,'MC010','Razer',' Seiren Mini 5','inalambrico',96.00,645,'CT003');
/*!40000 ALTER TABLE `tb_microfono` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_mouse`
--

DROP TABLE IF EXISTS `tb_mouse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_mouse` (
  `codigo_` int NOT NULL AUTO_INCREMENT,
  `codigo` varchar(8) NOT NULL,
  `marca` varchar(45) NOT NULL,
  `modelo` varchar(45) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `tipoconex` varchar(45) NOT NULL,
  `precio` decimal(12,2) NOT NULL,
  `stock` int NOT NULL,
  `categoria` varchar(8) NOT NULL,
  PRIMARY KEY (`codigo_`),
  KEY `categoria` (`categoria`),
  CONSTRAINT `tb_mouse_ibfk_1` FOREIGN KEY (`categoria`) REFERENCES `tb_categoria` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_mouse`
--

LOCK TABLES `tb_mouse` WRITE;
/*!40000 ALTER TABLE `tb_mouse` DISABLE KEYS */;
INSERT INTO `tb_mouse` VALUES (1,'MS001','ACER','Silver','ecológico','Alambrico',29.00,475,'CT003'),(2,'MS002','Asus','MR200','optico','Alambrico',59.00,574,'CT003'),(3,'MS003','ACER','Vero','adapatable conexion','Inalambrico',49.00,678,'CT003'),(4,'MS004','Halion','Razer','Mantis speed','Alambrico',69.00,896,'CT003'),(5,'MS005','HP','Silver','Wireless','Inalambrico',59.00,574,'CT003');
/*!40000 ALTER TABLE `tb_mouse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_mousegamer`
--

DROP TABLE IF EXISTS `tb_mousegamer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_mousegamer` (
  `codigo_` int NOT NULL AUTO_INCREMENT,
  `codigo` varchar(8) NOT NULL,
  `marca` varchar(45) NOT NULL,
  `modelo` varchar(45) NOT NULL,
  `descripcion` varchar(1000) NOT NULL,
  `tipoconex` varchar(45) NOT NULL,
  `precio` double NOT NULL,
  `stock` int NOT NULL,
  `categoria` varchar(8) NOT NULL,
  PRIMARY KEY (`codigo_`),
  KEY `categoria` (`categoria`),
  CONSTRAINT `tb_mousegamer_ibfk_1` FOREIGN KEY (`categoria`) REFERENCES `tb_categoria` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_mousegamer`
--

LOCK TABLES `tb_mousegamer` WRITE;
/*!40000 ALTER TABLE `tb_mousegamer` DISABLE KEYS */;
INSERT INTO `tb_mousegamer` VALUES (1,'MG001','Lenovo','Mouse gaming Primus Gladius 32000P RGB','Armado con un sensor Pixart especial para gamers, el dispositivo ofrece una sensibilidad excepcional','inalambrico',250,252,'CT002'),(2,'MG002','LOGITECH G','MOUSE GAMER G203 RGB LIGHTSYNC','el mouse G203 para juegos disponible en una variedad de vibrantes colores. Con la tecnología LIGHTSYNC, un sensor para juegos y un diseño clásico de 6 botones','inalambrico',245,568,'CT002'),(3,'MG003','Logitech','G903 LucesPEED','el mouse G903 ofrece desempeño, capacidad de respuesta y precisión al más alto nivel competitivo','inalambrico',123,654,'CT002'),(4,'MG004','ASUS','MEETION-ratón mecánico','para videojuegos, dispositivo electrónico profesional para deporte, programable, de definición Macro, 7D','alambrico',299,533,'CT002'),(5,'MG005','ASUS','ROG Spatha X','12 botones programables','inalambrico',455,678,'CT002'),(6,'MG006','LOGITECH','G502 LIGHTSPEED WIRELESS RGB 25K DPI','11 botones y Sensor Hero. El mouse G502 ha sido de los ratones para juegos más usados en estos últimos tiempos','inalambrico',500,985,'CT002'),(7,'MG007','Lenovo','Legion M600 Sports ','Posee una batería de larga duración y de carga rápida, ideal para las exigentes sesiones de juegos','inalambrico',220,756,'CT002'),(8,'MG008','Cetus','G502 HERO – NEGRO','Ésta es la versión \"baddest\" del mouse para juegos favorito de los fans, el G502','inalambrico',79,754,'CT002'),(9,'MG009','LOGITECH G','G203 RGB LIGHTSYNC','Tiene una variedad de sensores que reproduce música, películas, juegos... prácticamente cualquier sonido: el G203','alambrico',130,788,'CT002'),(10,'MG010','REDRAGON','STORM ELITE M988-RGB','Mouse más ligero de la marca al pesar solo 85 gramos. Combina el exitoso diseño del mouse Cobra M711 con la agilidad.','inalambrico',169,657,'CT002');
/*!40000 ALTER TABLE `tb_mousegamer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_parlante`
--

DROP TABLE IF EXISTS `tb_parlante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_parlante` (
  `codigo_` int NOT NULL AUTO_INCREMENT,
  `codigo` varchar(8) NOT NULL,
  `marca` varchar(45) NOT NULL,
  `modelo` varchar(45) NOT NULL,
  `descripcion` varchar(1000) NOT NULL,
  `tipoconex` varchar(45) NOT NULL,
  `precio` decimal(8,2) NOT NULL,
  `stock` int NOT NULL,
  `categoria` varchar(8) NOT NULL,
  PRIMARY KEY (`codigo_`),
  KEY `categoria` (`categoria`),
  CONSTRAINT `tb_parlante_ibfk_1` FOREIGN KEY (`categoria`) REFERENCES `tb_categoria` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_parlante`
--

LOCK TABLES `tb_parlante` WRITE;
/*!40000 ALTER TABLE `tb_parlante` DISABLE KEYS */;
INSERT INTO `tb_parlante` VALUES (1,'PL001','LG','KILLER - MIC S600','Posee de varios compartimientos como usb, ssd y tambien es compatible para dispositivos como celulares, laptop y pc','alambrico',250.00,863,'CT003'),(2,'PL002','SAMSUNG','FISHER HA-F76 120W Bt/Fm/Usb','Lo básico e importante para disfrutas de la música como es entrada memoria USB/SD, resistentes a los rasguños y al polvo a diferencia de los discos compactos','inalambrico',120.00,961,'CT003'),(3,'PL003','XIAOMI',' Sp-Q160 Usb Power 6w Iron Grey','Formatos de reproducción de audio: MP3 , ademas posee de entradas de usb y lector de ssd','inalambrico',89.00,483,'CT003'),(4,'PL004','SONY','JBL Charge','La última versión de la Serie Charge de JBL Charge 5 incluye topes de silicona y un llamativo logo de JBL, El altavoz combina una estructura resistente y duradera con un diseño elegante','alambrico',98.00,662,'CT003'),(5,'PL005','LG','XBOOM ','Parlantes BluetoothLa música y la movilidad son de LG, porque los equipos portátiles LG están diseñados para que su reducido tamaño no afecte a la calidad de sonido','inalambrico',105.00,780,'CT003'),(6,'PL006','PHILIPS','FS22','Calidad de sonido estéreo, super graves, mano de obra pequeña y hermosa.2. Admitir archivos de música en formato MP3 y WMA3','inalambrico',215.00,258,'CT003'),(7,'PL007','XIAOMI','TAS1505B','Obtienes 8 horas de tiempo de reproducción, y una carga completa tarda 2,5 horas, lo que te asegura música por muchas horas. Solo configura tu dispositivo a través de su conexión Bluetooth.','inalambrico',59.00,392,'CT003'),(8,'PL008','LG','spirit HA-F46 100W','Contrólalo desde la pista de baile haz que cada fiesta sea única. Activa los efectos de sonido desde la aplicación de DJ en Android o iOS','inalambrico',80.00,427,'CT003'),(9,'PL009','SAMSUNG','CH HW-T400/PE',' Funcion de memoria, comienza a reproducir automaticamente desde la cancion reproducida7. Tiempo de trabajo de 4 a 5 horas.8. Tiempo de carga 5 horas.8. Resistente al agua','inalambrico',70.00,694,'CT003'),(10,'PL010','SONY','Spirit HA-F46 100W','es un práctico parlante portátil que puedes llevar contigo a tus paseos o reuniones al aire libre y disfrutar de la mejor música.','alambrico',160.00,471,'CT003');
/*!40000 ALTER TABLE `tb_parlante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_pcescritorio`
--

DROP TABLE IF EXISTS `tb_pcescritorio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_pcescritorio` (
  `codigo_` int NOT NULL AUTO_INCREMENT,
  `codigo` varchar(8) NOT NULL,
  `procesador` varchar(100) NOT NULL,
  `discoduro` varchar(100) NOT NULL,
  `placamadre` varchar(100) NOT NULL,
  `tarjetavideo` varchar(100) NOT NULL,
  `fuentepoder` varchar(100) NOT NULL,
  `refrigeracion` varchar(100) NOT NULL,
  `precio` decimal(12,2) NOT NULL,
  `stock` int NOT NULL,
  `categoria` varchar(8) NOT NULL,
  PRIMARY KEY (`codigo_`),
  KEY `categoria` (`categoria`),
  CONSTRAINT `tb_pcescritorio_ibfk_1` FOREIGN KEY (`categoria`) REFERENCES `tb_categoria` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_pcescritorio`
--

LOCK TABLES `tb_pcescritorio` WRITE;
/*!40000 ALTER TABLE `tb_pcescritorio` DISABLE KEYS */;
INSERT INTO `tb_pcescritorio` VALUES (8,'PE001','Intel Core i3 5th 3.2 GHz','Disco Sólido 250GB','Placa Main Yamaha PSRS550','Nvidia GTX1050TI 1GB GDDR5 128Bits','550 W','Liquida 360R rgb',1950.00,869,'CT003'),(9,'PE002','Intel Core i5 6th 3.4 GHz','HDD 1TB 7200 RPM','Z590-e Asus','NVIDIA GT 730 2GB','350 W','Liquida',2150.00,854,'CT003'),(10,'PE003','AMD Ryzen 3 5600x 3.7 GHz, 3 MB L2, 6 Núcleos, 8 Hilos','Western Digital Black P10 Game drive 1TB, USB 3.2, 140MB/s','B450M-A II M4','NVIDIA GTX1050TI 4GB GDDR5 768','550 W','Liquida',5450.00,566,'CT003'),(11,'PE004','Intel Core i3 10105F3.7 GHz Cache 6MB','HDD 2TB','jancd-1003e','NVIDIA GTX1650 1GB GDDR5 896 cudas 128 bits','550 W','Liquida Ccw-3000',5433.00,739,'CT003'),(12,'PE005','Intel Core i3 12600KF','HDD 2TB','Maximus Xiii Extreme ','GTX1650 4GB','650 W','Liquida',7500.00,838,'CT003'),(13,'PE006','AMD Ryzen 3 5700G 3.8GHz, 4MB L2, 8 Núcleos, 83 Hilos','SEAGATE BARRACUDA ST4000DM004, 1TB, SATA 6.0 GBPS, 5400 RPM, 3.5','GIGABYTE A520M DS3H AM4','NVIDIA GTX1050TI 4GB GDDR5 768','550 W','LÍQUIDA DE CPU CORSAIR H150I ELITE CAPELLIX',4250.00,856,'CT003'),(14,'PE007','MD Ryzen 5 5900X 3.7 GHz, 6 MB L2, 64MB L3 6 Núcleos, 4 Hilos','3TB','Motherboard ATX Prime X299-A','RX6700XT 2GB GDDR6','750 W Certificada','S0p9da Msi MPG Coreliquid K360, 60 mm, 3 ventiladores',7546.00,869,'CT003');
/*!40000 ALTER TABLE `tb_pcescritorio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_pcgamer`
--

DROP TABLE IF EXISTS `tb_pcgamer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_pcgamer` (
  `codigo_` int NOT NULL AUTO_INCREMENT,
  `codigo` varchar(8) NOT NULL,
  `procesador` varchar(200) NOT NULL,
  `discoduro` varchar(200) NOT NULL,
  `placamadre` varchar(200) NOT NULL,
  `tarjvideo` varchar(200) NOT NULL,
  `fuentepoder` varchar(200) NOT NULL,
  `refrigeracion` varchar(200) NOT NULL,
  `precio` decimal(8,2) NOT NULL,
  `stock` int NOT NULL,
  `categoria` varchar(8) NOT NULL,
  PRIMARY KEY (`codigo_`),
  KEY `categoria` (`categoria`),
  CONSTRAINT `tb_pcgamer_ibfk_1` FOREIGN KEY (`categoria`) REFERENCES `tb_categoria` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_pcgamer`
--

LOCK TABLES `tb_pcgamer` WRITE;
/*!40000 ALTER TABLE `tb_pcgamer` DISABLE KEYS */;
INSERT INTO `tb_pcgamer` VALUES (1,'PG001','Intel Core i7 4th 3.4 GHz','Disco Sólido SSD M2 NVME 500GB','Placa Main Yamaha PSRS550','Nvidia GTX1050TI 4GB GDDR5 128Bits','550 W','Liquida 360R rgb',1950.00,563,'CT002'),(2,'PG002','Intel Core i9 6th 3.4 GHz','HDD 2TB 7200 RPM','Z590-e Asus','NVIDIA GT 730 4GB','350 W','Liquida',2150.00,948,'CT002'),(3,'PG003','AMD Ryzen 5 5600x 3.7 GHz, 3 MB L2, 6 Núcleos, 12 Hilos','Western Digital Black P10 Game drive 4TB, USB 3.2, 140MB/s','B450M-A II M4','NVIDIA GTX1050TI 4GB GDDR5 768','550 W','Liquida',5450.00,647,'CT002'),(4,'PG004','Intel Core i3 10105F3.7 GHz Cache 6MB','HDD 2TB','jancd-1003e','NVIDIA GTX1650 4GB GDDR5 896 cudas 128 bits','550 W','Liquida Ccw-3000',5433.00,240,'CT002'),(5,'PG005','Intel Core i5 12600KF','HDD 2TB','Maximus Xiii Extreme ','GTX1650 4GB','650 W','Liquida',7500.00,635,'CT002'),(6,'PG006','AMD Ryzen 7 5700G 3.8GHz, 4MB L2, 8 Núcleos, 16 Hilos','SEAGATE BARRACUDA ST4000DM004, 4TB, SATA 6.0 GBPS, 5400 RPM, 3.5','GIGABYTE A520M DS3H AM4','NVIDIA GTX1050TI 4GB GDDR5 768','550 W','LÍQUIDA DE CPU CORSAIR H150I ELITE CAPELLIX',4250.00,593,'CT002'),(7,'PG007','MD Ryzen 9 5900X 3.7 GHz, 6 MB L2, 64MB L3 12 Núcleos, 24 Hilos','8TB','Motherboard ATX Prime X299-A','RX6700XT 12GB GDDR6','750 W Certificada','líquida Msi MPG Coreliquid K360, 60 mm, 3 ventiladores',7546.00,249,'CT002');
/*!40000 ALTER TABLE `tb_pcgamer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_proveedor`
--

DROP TABLE IF EXISTS `tb_proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_proveedor` (
  `codigo_` int NOT NULL AUTO_INCREMENT,
  `codigo` varchar(8) NOT NULL,
  `razonSocial` varchar(45) NOT NULL,
  `ruc` varchar(45) NOT NULL,
  `contacto` varchar(10) NOT NULL,
  `correo` varchar(55) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `sede` varchar(50) NOT NULL,
  PRIMARY KEY (`codigo_`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_proveedor`
--

LOCK TABLES `tb_proveedor` WRITE;
/*!40000 ALTER TABLE `tb_proveedor` DISABLE KEYS */;
INSERT INTO `tb_proveedor` VALUES (1,'PRO01','VideoJuegos S.A.C.','20986554237','01 3889698','videojuegos@games.es','Av. Los Andes 4578','Lima'),(2,'PRO02','GAMING S.A.C.','20654988777','01 4861298','gaming@computer.com','Av. Los Marsupios 7896','Trujillo'),(3,'PRO03','Electronica S.A.C.','20945654885','01 6574684','electronic@elements.org','Av. Pikachu 5612','Lima');
/*!40000 ALTER TABLE `tb_proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_sede`
--

DROP TABLE IF EXISTS `tb_sede`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_sede` (
  `codigo` varchar(8) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_sede`
--

LOCK TABLES `tb_sede` WRITE;
/*!40000 ALTER TABLE `tb_sede` DISABLE KEYS */;
INSERT INTO `tb_sede` VALUES ('SD001','Chorillos'),('SD002','Miraflores'),('SD003','Lince'),('SD004','Centro Lima'),('SD005','SJL'),('SD006','Surquillo'),('SD007','Barranco'),('SD008','Independencia'),('SD009','Comas'),('SD010','Surco');
/*!40000 ALTER TABLE `tb_sede` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_sillagamer`
--

DROP TABLE IF EXISTS `tb_sillagamer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_sillagamer` (
  `codigo_` int NOT NULL AUTO_INCREMENT,
  `codigo` varchar(8) NOT NULL,
  `marca` varchar(45) NOT NULL,
  `modelo` varchar(45) NOT NULL,
  `descripcion` varchar(300) NOT NULL,
  `precio` decimal(8,2) NOT NULL,
  `stock` int NOT NULL,
  `categoria` varchar(8) NOT NULL,
  PRIMARY KEY (`codigo_`),
  KEY `categoria` (`categoria`),
  CONSTRAINT `tb_sillagamer_ibfk_1` FOREIGN KEY (`categoria`) REFERENCES `tb_categoria` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_sillagamer`
--

LOCK TABLES `tb_sillagamer` WRITE;
/*!40000 ALTER TABLE `tb_sillagamer` DISABLE KEYS */;
INSERT INTO `tb_sillagamer` VALUES (1,'SG001','COOL TEC','silla gamer dragons 2022','Viene con un reposabrazos y apoyo lumbar acolchado',584.00,11863,'CT002'),(2,'SG002','CASA-JOVEN','RECLINABLE GAMER','Silla gamer reclinable con reposapie',379.00,8563,'CT002'),(3,'SG003','CASA-JOVEN','gamer titanium','silla gamer armable con reposapie',478.00,9258,'CT002'),(4,'SG004','COOL TEC','GAMER PRO 2020','La silla gamer cuenta con espuma inyectada y amoldable',655.00,7680,'CT002'),(5,'SG005','SASARU IMPORTACIONES','gamer blazze','silla gamer inclinable y desarmable',700.00,5050,'CT002'),(6,'SG006','SKU-SILLAGAMERTURBOR','GAMER TURBO','Lleva un apoya brazos ajustable en altura con almohadilla y reposacabezas',542.00,643,'CT002'),(7,'SG007','SKU-SILLAGAMERTURBOR','SILLA GAMER RACER','Reclinable con soporte lumbar',456.00,520,'CT002'),(8,'SG008','DREIZT','DREIZT SHINE','Construida con un diseño ergonómico y cojines ajustables para la cabeza y el respaldo lumbar',579.00,358,'CT002'),(9,'SG009','KUZLER','KUZ0272BLK','silla reclinable con reposabrazos',246.00,365,'CT002'),(10,'SG010','UNLIMITED','GAMER MAGE UNLIMITED','Recubierta  de cuerina con reposapie y apoya brazos, incluye cojin de cabeza y lumbar',354.00,211,'CT002');
/*!40000 ALTER TABLE `tb_sillagamer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tablet`
--

DROP TABLE IF EXISTS `tb_tablet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_tablet` (
  `codigo_` int NOT NULL AUTO_INCREMENT,
  `codigo` varchar(8) NOT NULL,
  `marca` varchar(45) NOT NULL,
  `modelo` varchar(45) NOT NULL,
  `procesador` varchar(45) NOT NULL,
  `descripcion` varchar(1000) NOT NULL,
  `precio` decimal(8,2) NOT NULL,
  `stock` int NOT NULL,
  `categoria` varchar(8) NOT NULL,
  PRIMARY KEY (`codigo_`),
  KEY `categoria` (`categoria`),
  CONSTRAINT `tb_tablet_ibfk_1` FOREIGN KEY (`categoria`) REFERENCES `tb_categoria` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tablet`
--

LOCK TABLES `tb_tablet` WRITE;
/*!40000 ALTER TABLE `tb_tablet` DISABLE KEYS */;
INSERT INTO `tb_tablet` VALUES (1,'TB001','SAMSUNG','GALAXY TAB A7','MediaTek MT8768N','Sistema operativo Android 11',549.00,756,'CT003'),(2,'TB002','HUAWEI','T10','HUAWEI Kirin 820','Memoria interna 128GB',949.00,655,'CT003'),(3,'TB003','Apple','iPad 2 Air','Chip A13 Bionic','Memoria interna 64GB',1599.00,632,'CT003'),(4,'TB004','Xiaomi','PAD 5','Snapdragon 860','Memoria interna 256GB',2099.00,835,'CT003'),(5,'TB005','SAMSUNG','GALAXY','MediaTek','SistemaoperativoAndroid11',1100.00,698,'CT003'),(6,'TB006','Apple','iPad Mini 6','Chip A15 Bionic','Memoria interna 64GB',2899.00,532,'CT003'),(7,'TB007','Lenovo','Tab11','Snapdragon 15','Memoria interna 128GB',1449.00,333,'CT003'),(8,'TB008','Smarket','Premium','SC9863A OCTA COR','Family friendly pe',799.00,385,'CT003'),(9,'TB009','Lenovo','Smart12','MediaTek Helio P22T','Memoria interna 64GB',749.00,365,'CT003'),(10,'TB010','Smarket','Paw Patrolsito','RK3326 Quad core','Memoria interna 16GB',399.00,247,'CT003');
/*!40000 ALTER TABLE `tb_tablet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_teclado`
--

DROP TABLE IF EXISTS `tb_teclado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_teclado` (
  `codigo_` int NOT NULL AUTO_INCREMENT,
  `codigo` varchar(8) NOT NULL,
  `marca` varchar(45) NOT NULL,
  `modelo` varchar(45) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `tipoconex` varchar(45) NOT NULL,
  `precio` decimal(12,2) NOT NULL,
  `stock` int NOT NULL,
  `categoria` varchar(8) NOT NULL,
  PRIMARY KEY (`codigo_`),
  KEY `categoria` (`categoria`),
  CONSTRAINT `tb_teclado_ibfk_1` FOREIGN KEY (`categoria`) REFERENCES `tb_categoria` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_teclado`
--

LOCK TABLES `tb_teclado` WRITE;
/*!40000 ALTER TABLE `tb_teclado` DISABLE KEYS */;
INSERT INTO `tb_teclado` VALUES (1,'TO001','Genius','Smart','full online','Alambrico',69.00,50,'CT003'),(2,'TO002','Logitech','MK 235','funcioable oulast','Alambrico',79.00,50,'CT003'),(3,'TO003','Hyper X','RGB 12','Membrana','Alambrico',49.00,50,'CT003'),(4,'TO004','Microsoft','Desktop 4000','Scrulpt Comfortable','Inalambrico',89.00,50,'CT003'),(5,'TO005','Microsoft','Desktop 3050','suavisante yum','Analambrico',59.00,50,'CT003');
/*!40000 ALTER TABLE `tb_teclado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tecladogamer`
--

DROP TABLE IF EXISTS `tb_tecladogamer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_tecladogamer` (
  `codigo_` int NOT NULL AUTO_INCREMENT,
  `codigo` varchar(8) NOT NULL,
  `marca` varchar(45) NOT NULL,
  `modelo` varchar(45) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `tipoconex` varchar(45) NOT NULL,
  `precio` decimal(8,2) NOT NULL,
  `stock` int NOT NULL,
  `categoria` varchar(8) NOT NULL,
  PRIMARY KEY (`codigo_`),
  KEY `categoria` (`categoria`),
  CONSTRAINT `tb_tecladogamer_ibfk_1` FOREIGN KEY (`categoria`) REFERENCES `tb_categoria` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tecladogamer`
--

LOCK TABLES `tb_tecladogamer` WRITE;
/*!40000 ALTER TABLE `tb_tecladogamer` DISABLE KEYS */;
INSERT INTO `tb_tecladogamer` VALUES (1,'TG001','Logitech','Carbon Lightsync','Gaming RGB Black','Alambrico',659.00,687,'CT002'),(2,'TG002','Micronics','Frantic','Teclas curvas','Alambrico',129.00,667,'CT002'),(3,'TG003','THERMALTAKE','CHALLENGER','Teclado RGB','Alambrico',159.00,321,'CT002'),(4,'TG004','CYBERTEL','EBONY','Teclado multimedia','Alambrico',269.00,970,'CT002'),(5,'TG005','HYPERX','Alloy Core','Gaming membrana','Inalambrico',349.00,508,'CT002'),(6,'TG006','Teraware','Roy Mustang','Gon and killua','Alambrico',159.00,456,'CT002'),(7,'TG007','Teraware','KD-955',' teclado para gaming se conecta vía USB','Inalambrico',209.00,404,'CT002'),(8,'TG008','Havit','One Hand','para un juego más fluido','Inalambrico',169.00,587,'CT002'),(9,'TG009','HP','Cm3000','headset','Alambrico',299.00,568,'CT002'),(10,'TG010','REDRAGON','KUMARA RAINBOW','Light Mecannic Switch','Alambrico',169.00,255,'CT002');
/*!40000 ALTER TABLE `tb_tecladogamer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_televisor`
--

DROP TABLE IF EXISTS `tb_televisor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_televisor` (
  `codigo_` int NOT NULL AUTO_INCREMENT,
  `codigo` varchar(8) NOT NULL,
  `marca` varchar(45) NOT NULL,
  `modelo` varchar(45) NOT NULL,
  `descripcion` varchar(1000) NOT NULL,
  `precio` decimal(8,2) NOT NULL,
  `stock` int NOT NULL,
  `categoria` varchar(8) NOT NULL,
  PRIMARY KEY (`codigo_`),
  KEY `categoria` (`categoria`),
  CONSTRAINT `tb_televisor_ibfk_1` FOREIGN KEY (`categoria`) REFERENCES `tb_categoria` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_televisor`
--

LOCK TABLES `tb_televisor` WRITE;
/*!40000 ALTER TABLE `tb_televisor` DISABLE KEYS */;
INSERT INTO `tb_televisor` VALUES (1,'TL001','LG','4K SMART THINQ AI 55UP771C0SB','Los televisores LG UHD superan tus expectativas en todo momento, experimenta una calidad de imagen real',1699.00,465,'CT003'),(2,'TL002','Samsung','Smart TV UHD 4K UN43AU7090GXPE','Este televisor tiene una resolucion 4k donde podras disfrutar de una buena vista la cual podras vivir al maximo cada pelicula',5900.00,213,'CT003'),(3,'TL003','Xiaomi','P1 55 Mi Android 10 4K UHD HDR10+','Los televisores  de XIAOMI  poseen una tecnologia de las mejores',2988.00,652,'CT003'),(4,'TL004','LG','SMART TV - 43UN711C0SA','Con este televisor viviras la mejor experiencia con colores nitidos la cual podras disfrutar de una buena pelicula en familia',3660.00,355,'CT003'),(5,'TL005','SAMSUNG','SMART TV UHD 4K UN55AU7090GXPE','Disfrute de una experiencia inmensiva en sonido con su tecnologia Q-SYMPHONY',4259.00,125,'CT003'),(6,'TL006','SAMSUNG','4K ISDBT ANDROID TV BT CHROMECAST','Este dispositivo cuenta con internet y tambien con una tecnologia de ultima generacion',5946.00,652,'CT003'),(7,'TL007','Hyundai','Smart TV HD HYLED3244NIM','El modelo HYLED3244NiM presenta una pantalla de 32 pulgadas, la misma que brinda una experiencia inigualable de colores y movimientos',700.00,365,'CT003'),(8,'TL008','PHILIPS','SMART TV 70PUD6774','Permite que los videos se sientan como si estuvieras allí. Este televisor te brinda una amplia gama de colores',2499.00,455,'CT003'),(9,'TL009','SAMSUNG','Smart TV 65\" Neo QLED 8K QN65QN700AGXPE','Samsung aprende en cada escena y crea una experiencia de visualización inmejorable',7988.00,563,'CT003'),(10,'TL010','LG','50UP7750 4K UHD Smart TV','Los televisores LG UHD superan tus expectativas en todo momento. Experimenta una calidad de imagen real',8945.00,456,'CT003');
/*!40000 ALTER TABLE `tb_televisor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tipoboleta`
--

DROP TABLE IF EXISTS `tb_tipoboleta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_tipoboleta` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tipoboleta`
--

LOCK TABLES `tb_tipoboleta` WRITE;
/*!40000 ALTER TABLE `tb_tipoboleta` DISABLE KEYS */;
INSERT INTO `tb_tipoboleta` VALUES (1,'Venta'),(2,'Compra');
/*!40000 ALTER TABLE `tb_tipoboleta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'bd_upmorbsluck'
--

--
-- Dumping routines for database 'bd_upmorbsluck'
--
/*!50003 DROP PROCEDURE IF EXISTS `ActualizarAudifonoGamer` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ActualizarAudifonoGamer`(vMarca varchar(100), vModelo varchar(100), vDescripcion varchar(500), vTipoConex varchar(100), vPrecio DOUBLE, 
vStock INT, vCodigo varchar(45))
update tb_audifonosgamer set marca = vMarca, modelo = vModelo, descripcion = vDescripcion,   tipoconex = vTipoConex, precio = vPrecio, 
stock = vStock where codigo = vCodigo ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ActualizarAudifonos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ActualizarAudifonos`(vMarca varchar(100), vModelo varchar(100), vDescripcion varchar(500), vTipoConex varchar(100), vPrecio DOUBLE, 
vStock INT, vCodigo varchar(45))
update tb_audifonosmusica set marca = vMarca, modelo = vModelo, descripcion = vDescripcion,   tipoconex = vTipoConex, precio = vPrecio, 
stock = vStock where codigo = vCodigo ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ActualizarCamaraWeb` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ActualizarCamaraWeb`(vMarca varchar(100), vModelo varchar(100), vTipoConex varchar(100), vPrecio DOUBLE, 
vStock INT, vCodigo varchar(45))
update tb_camaraweb set marca = vMarca, modelo = vModelo, tipoconex = vTipoConex, precio = vPrecio, 
stock = vStock where codigo = vCodigo ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ActualizarCelular` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ActualizarCelular`(vMarca varchar(100), vModelo varchar(100), vDescripcion varchar(100), vPrecio DOUBLE, 
vStock INT, vCodigo varchar(45))
update tb_celular set marca = vMarca, modelo = vModelo, descripcion = vDescripcion, precio = vPrecio, 
stock = vStock where codigo = vCodigo ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ActualizarCliente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ActualizarCliente`(vNombre varchar(45), vApellido varchar(45), vDni varchar(45), vEdad INT, 
vFechaNacimiento varchar(45), vGenero varchar(45), vEstadoCivil varchar(45), vCelular varchar(45),  
vCorreo varchar(45), vDireccion varchar(45), vCodigo varchar(45))
update tb_cliente set nombre = vNombre, apellido = vApellido, dni = vDni, edad = vEdad, 
fechaNacimiento = vFechaNacimiento, genero = vGenero, estadoCivil = vEstadoCivil, 
celular = vCelular, correo = vCorreo, direccion = vDireccion where codigo = vCodigo ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ActualizarConsola` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ActualizarConsola`(vNombre varchar(100), vModelo varchar(100), vColor varchar(100), vPrecio DOUBLE, 
vStock INT, vCodigo varchar(45))
update tb_consola set nombre = vNombre, modelo = vModelo, color = vColor, precio = vPrecio, 
stock = vStock where codigo = vCodigo ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ActualizarEmpleado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ActualizarEmpleado`(vNombre varchar(45), vApellido varchar(45), vDni varchar(45), vEdad INT, 
vFechaNacimiento varchar(45), vGenero varchar(45), vEstadoCivil varchar(45), vCelular varchar(45),  
vCorreo varchar(45), vDireccion varchar(45),  
vCargo varchar(45), vSede varchar(45), vCodigo varchar(45))
update tb_empleado set nombre = vNombre, apellido = vApellido, dni = vDni, edad = vEdad, 
fechaNacimiento = vFechaNacimiento, genero = vGenero, estadoCivil = vEstadoCivil, 
celular = vCelular, correo = vCorreo, direccion = vDireccion, cargo = vCargo, sede = vSede where codigo = vCodigo ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ActualizarJuego` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ActualizarJuego`(vNombre varchar(100), vDesarrolladora varchar(100), vPlataforma varchar(100), vPrecio DOUBLE, 
vStock INT, vCodigo varchar(45))
update tb_juego set nombre = vNombre, desarrolladora = vDesarrolladora, plataforma = vPlataforma, precio = vPrecio, 
stock = vStock where codigo = vCodigo ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ActualizarLaptop` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ActualizarLaptop`(vMarca varchar(100), vModelo varchar(100), vProcesador varchar(100), vTarjetaVideo varchar(100), vPantalla varchar(100), vPrecio DOUBLE, 
vStock INT, vCodigo varchar(45))
update tb_laptop set marca = vMarca, modelo = vModelo, procesador = vProcesador, tarjetavideo = vTarjetaVideo, pantalla = vPantalla, precio = vPrecio, 
stock = vStock where codigo = vCodigo ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ActualizarLaptopGamer` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ActualizarLaptopGamer`(vMarca varchar(100), vModelo varchar(100), vProcesador varchar(100), vTarjetaVideo varchar(100), vSize varchar(100), vPrecio DOUBLE, 
vStock INT, vCodigo varchar(45))
update tb_laptopgamer set marca = vMarca, modelo = vModelo, procesador = vProcesador,   tarjetavideo = vTarjetaVideo, size = vSize, precio = vPrecio, 
stock = vStock where codigo = vCodigo ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ActualizarMando` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ActualizarMando`(vNombre varchar(100), vMarca varchar(100), vTipoConex varchar(100), vPrecio DOUBLE, 
vStock INT, vCodigo varchar(45))
update tb_mando set nombre = vNombre, marca = vMarca, tipoconex = vTipoConex, precio = vPrecio, 
stock = vStock where codigo = vCodigo ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ActualizarMicrofono` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ActualizarMicrofono`(vMarca varchar(100), vModelo varchar(100), vTipoConex varchar(100), vPrecio DOUBLE, 
vStock INT, vCodigo varchar(45))
update tb_microfono set marca = vMarca, modelo = vModelo, tipoconex = vTipoConex, precio = vPrecio, 
stock = vStock where codigo = vCodigo ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ActualizarMouse` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ActualizarMouse`(vMarca varchar(100), vModelo varchar(100), vDescripcion varchar(500), vTipoConex varchar(100), vPrecio DOUBLE, 
vStock INT, vCodigo varchar(45))
update tb_mouse set marca = vMarca, modelo = vModelo, descripcion = vDescripcion,   tipoconex = vTipoConex, precio = vPrecio, 
stock = vStock where codigo = vCodigo ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ActualizarMouseGamer` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ActualizarMouseGamer`(vMarca varchar(100), vModelo varchar(100), vDescripcion varchar(500), vTipoConex varchar(100), vPrecio DOUBLE, 
vStock INT, vCodigo varchar(45))
update tb_mousegamer set marca = vMarca, modelo = vModelo, descripcion = vDescripcion,   tipoconex = vTipoConex, precio = vPrecio, 
stock = vStock where codigo = vCodigo ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ActualizarParlante` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ActualizarParlante`(vMarca varchar(100), vModelo varchar(100), vDescripcion varchar(500), vTipoConex varchar(100), vPrecio DOUBLE, 
vStock INT, vCodigo varchar(45))
update tb_parlante set marca = vMarca, modelo = vModelo, descripcion = vDescripcion,   tipoconex = vTipoConex, precio = vPrecio, 
stock = vStock where codigo = vCodigo ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ActualizarPCEscritorio` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ActualizarPCEscritorio`(vProcesador varchar(100), vDiscoDuro varchar(100), vPlacaMadre varchar(100), vTarjetaVideo varchar(100), vFuentePoder varchar(100), vRefrigeracion varchar(100), vPrecio DOUBLE, 
vStock INT, vCodigo varchar(45))
update tb_pcescritorio set procesador = vProcesador, discoduro = vDiscoDuro, placamadre = vPlacaMadre, tarjetavideo = vTarjetaVideo, fuentepoder = vFuentePoder, refrigeracion = vRefrigeracion, precio = vPrecio, 
stock = vStock where codigo = vCodigo ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ActualizarPCGamer` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ActualizarPCGamer`(vProcesador varchar(100), vDiscoDuro varchar(100), vPlacaMadre varchar(100), vTarjVideo varchar(100), vFuentePoder varchar(100), vRefrigeracion varchar(100), vPrecio DOUBLE, 
vStock INT, vCodigo varchar(45))
update tb_pcgamer set procesador = vProcesador, discoduro = vDiscoDuro, placamadre = vPlacaMadre,   tarjvideo = vTarjVideo, fuentepoder = vFuentePoder, refrigeracion = vRefrigeracion, precio = vPrecio, 
stock = vStock where codigo = vCodigo ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ActualizarSillaGamer` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ActualizarSillaGamer`(vMarca varchar(100), vModelo varchar(100), vDescripcion varchar(500), vPrecio DOUBLE, 
vStock INT, vCodigo varchar(45))
update tb_sillagamer set marca = vMarca, modelo = vModelo, descripcion = vDescripcion, precio = vPrecio, 
stock = vStock where codigo = vCodigo ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ActualizarTablet` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ActualizarTablet`(vMarca varchar(100), vModelo varchar(100), vProcesador varchar(100), vDescripcion varchar(500), vPrecio DOUBLE, 
vStock INT, vCodigo varchar(45))
update tb_tablet set marca = vMarca, modelo = vModelo, procesador = vProcesador, descripcion = vDescripcion, precio = vPrecio, 
stock = vStock where codigo = vCodigo ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ActualizarTeclado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ActualizarTeclado`(vMarca varchar(100), vModelo varchar(100), vDescripcion varchar(500), vTipoConex varchar(100), vPrecio DOUBLE, 
vStock INT, vCodigo varchar(45))
update tb_teclado set marca = vMarca, modelo = vModelo, descripcion = vDescripcion,   tipoconex = vTipoConex, precio = vPrecio, 
stock = vStock where codigo = vCodigo ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ActualizarTecladoGamer` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ActualizarTecladoGamer`(vMarca varchar(100), vModelo varchar(100), vDescripcion varchar(500), vTipoConex varchar(100), vPrecio DOUBLE, 
vStock INT, vCodigo varchar(45))
update tb_tecladogamer set marca = vMarca, modelo = vModelo, descripcion = vDescripcion,   tipoconex = vTipoConex, precio = vPrecio, 
stock = vStock where codigo = vCodigo ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ActualizarTelevisor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ActualizarTelevisor`(vMarca varchar(100), vModelo varchar(100), vDescripcion varchar(500), vPrecio DOUBLE, 
vStock INT, vCodigo varchar(45))
update tb_televisor set marca = vMarca, modelo = vModelo, descripcion = vDescripcion, precio = vPrecio, 
stock = vStock where codigo = vCodigo ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `busquedaEmpleadoIngreso` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `busquedaEmpleadoIngreso`(code Varchar(10))
select e.codigo_, e. codigo, e.nombre, e.apellido, e.dni, e.edad, e.fechaNacimiento, g.descripcion as "genero", est.descripcion as "estadocivil", e.celular, e.correo, e.direccion, c.descripcion as "cargo", s.descripcion as "sede", e.usuario, e.clave from tb_empleado e inner join tb_genero g on e.genero = g.codigo inner join tb_cargo c on e.cargo = c.codigo inner join tb_sede s on e.sede = s.codigo inner join tb_estadocivil est on e.estadocivil = est.codigo where e.clave = code ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `busquedaPorCodigoCliente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `busquedaPorCodigoCliente`(code Varchar(10))
select cli.codigo_, cli.codigo, cli.nombre, cli.apellido, cli.dni, cli.edad, cli.fechaNacimiento, g.descripcion, est.descripcion, 
cli.celular, cli.correo, cli.direccion
 from tb_cliente cli 
 inner join tb_genero g on cli.genero = g.codigo 
 inner join tb_estadocivil est on cli.estadocivil = est.codigo
 where cli.codigo = code ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `busquedaPorCodigoEmpleado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `busquedaPorCodigoEmpleado`(code Varchar(10))
select e.codigo_, e. codigo, e.nombre, e.apellido, e.dni, e.edad, e.fechaNacimiento, g.descripcion, est.descripcion, 
e.celular, e.correo, e.direccion, c.descripcion, s.descripcion, e.usuario, e.clave
 from tb_empleado e 
 inner join tb_genero g on e.genero = g.codigo 
 inner join tb_cargo c on e.cargo = c.codigo
 inner join tb_sede s on e.sede = s.codigo
 inner join tb_estadocivil est on e.estadocivil = est.codigo
 where e.codigo = code ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `busquedaPorCodigoProveedor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `busquedaPorCodigoProveedor`(vCodigo Varchar(45))
SELECT * FROM tb_proveedor where codigo = vCodigo ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `busquedaPorFechaBoletaCompra` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `busquedaPorFechaBoletaCompra`(vFecha varchar (15))
SELECT b.num, b.codBoleta, e.codigo, p.codigo, b.fechaVenta, b.descripcion, b.importe FROM tb_boleta_compra b inner join tb_empleado e on b.cod_Empleado = e.codigo_ inner join tb_proveedor p on b.cod_Proveedor = p.codigo_ where fechaVenta like CONCAT(vFecha,'%') ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `busquedaPorFechaBoletaVenta` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `busquedaPorFechaBoletaVenta`(vFecha varchar(15))
SELECT b.num, b.codBoleta, e.codigo, c.codigo, b.fechaVenta, b.descripcion, b.importe FROM tb_boleta_venta b inner join tb_empleado e on b.cod_Empleado = e.codigo_ inner join tb_cliente c on b.cod_Cliente = c.codigo_ where fechaVenta like CONCAT(vFecha,'%') ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listarAudifonoGamer` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listarAudifonoGamer`()
select a.codigo_, a.codigo, a.marca, a.modelo, a.descripcion, a.tipoconex, a.precio, a.stock, cat.categoria as "categoria"
 from tb_audifonosgamer a 
 inner join tb_categoria cat on a.categoria = cat.codigo
 order by a.codigo ASC ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listarAudifonos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listarAudifonos`()
select t.codigo_, t.codigo, t.marca, t.modelo, t.descripcion, t.tipoconex, t.precio, t.stock, cat.categoria as "categoria"
 from tb_audifonosmusica t 
 inner join tb_categoria cat on t.categoria = cat.codigo
 order by t.codigo ASC ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listarBoletaCompras` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listarBoletaCompras`()
SELECT b.num, b.codBoleta, e.codigo, p.codigo, b.fechaVenta, b.descripcion, b.importe FROM tb_boleta_compra b inner join tb_empleado e on b.cod_Empleado = e.codigo_ inner join tb_proveedor p on b.cod_Proveedor = p.codigo_ ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listarBoletaVentas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listarBoletaVentas`()
SELECT b.num, b.codBoleta, e.codigo, c.codigo, b.fechaVenta, b.descripcion, b.importe FROM tb_boleta_venta b inner join tb_empleado e on b.cod_Empleado = e.codigo_ inner join tb_cliente c on b.cod_Cliente = c.codigo_ ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listarCamaraWeb` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listarCamaraWeb`()
select t.codigo_, t.codigo, t.marca, t.modelo, t.tipoconex, t.precio, t.stock, cat.categoria as "categoria"
 from tb_camaraweb t 
 inner join tb_categoria cat on t.categoria = cat.codigo
 order by t.codigo ASC ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listarCelular` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listarCelular`()
select c.codigo_, c.codigo, c.marca, c.modelo, c.descripcion, c.precio, c.stock, cat.categoria as "categoria"
 from tb_celular c 
 inner join tb_categoria cat on c.categoria = cat.codigo
 order by c.codigo ASC ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listarClientesASC` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listarClientesASC`()
select cli.codigo_, cli. codigo, cli.nombre, cli.apellido, cli.dni, cli.edad, cli.fechaNacimiento, g.descripcion as "genero", est.descripcion as "estadocivil", 
cli.celular, cli.correo, cli.direccion
 from tb_cliente cli 
 inner join tb_genero g on cli.genero = g.codigo
 inner join tb_estadocivil est on cli.estadocivil = est.codigo
 order by cli.codigo ASC ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listarClientesDESC` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listarClientesDESC`()
select cli.codigo_, cli. codigo, cli.nombre, cli.apellido, cli.dni, cli.edad, cli.fechaNacimiento, g.descripcion as "genero", est.descripcion as "estadocivil", 
cli.celular, cli.correo, cli.direccion
 from tb_cliente cli 
 inner join tb_genero g on cli.genero = g.codigo
 inner join tb_estadocivil est on cli.estadocivil = est.codigo
 order by cli.codigo DESC ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listarConsolas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listarConsolas`()
select c.codigo_, c.codigo, c.nombre, c.modelo, c.color, c.precio, c.stock, cat.categoria as "categoria"
 from tb_consola c 
 inner join tb_categoria cat on c.categoria = cat.codigo
 order by c.codigo ASC ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listarEmpleadosASC` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listarEmpleadosASC`(xColumn INT)
select e.codigo_, e. codigo, e.nombre, e.apellido, e.dni, e.edad, e.fechaNacimiento, g.descripcion as "genero", est.descripcion as "estadocivil", 
e.celular, e.correo, e.direccion, c.descripcion as "cargo", s.descripcion as "sede", e.usuario, e.clave
 from tb_empleado e 
 inner join tb_genero g on e.genero = g.codigo 
 inner join tb_cargo c on e.cargo = c.codigo
 inner join tb_sede s on e.sede = s.codigo
 inner join tb_estadocivil est on e.estadocivil = est.codigo
 order by CASE 
	WHEN xColumn = 1  THEN e.codigo
	WHEN xColumn = 2  THEN e.nombre
    WHEN xColumn = 3  THEN e.apellido
    WHEN xColumn = 4  THEN e.dni
    WHEN xColumn = 5  THEN e.edad
    WHEN xColumn = 6  THEN e.fechaNacimiento
    WHEN xColumn = 7  THEN e.genero
    WHEN xColumn = 8  THEN e.estadocivil
    WHEN xColumn = 9  THEN e.celular
	WHEN xColumn = 10 THEN e.correo
	WHEN xColumn = 11 THEN e.direccion
	WHEN xColumn = 12 THEN e.cargo
	WHEN xColumn = 13 THEN e.sede
    ELSE e.codigo 
 END ASC ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listarEmpleadosDESC` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listarEmpleadosDESC`(xColumn INT)
select e.codigo_, e. codigo, e.nombre, e.apellido, e.dni, e.edad, e.fechaNacimiento, g.descripcion as "genero", est.descripcion as "estadocivil", 
e.celular, e.correo, e.direccion, c.descripcion as "cargo", s.descripcion as "sede", e.usuario, e.clave
 from tb_empleado e 
 inner join tb_genero g on e.genero = g.codigo 
 inner join tb_cargo c on e.cargo = c.codigo
 inner join tb_sede s on e.sede = s.codigo
 inner join tb_estadocivil est on e.estadocivil = est.codigo
 order by CASE 
	WHEN xColumn = 1  THEN e.codigo
	WHEN xColumn = 2  THEN e.nombre
    WHEN xColumn = 3  THEN e.apellido
    WHEN xColumn = 4  THEN e.dni
    WHEN xColumn = 5  THEN e.edad
    WHEN xColumn = 6  THEN e.fechaNacimiento
    WHEN xColumn = 7  THEN e.genero
    WHEN xColumn = 8  THEN e.estadocivil
    WHEN xColumn = 9  THEN e.celular
	WHEN xColumn = 10 THEN e.correo
	WHEN xColumn = 11 THEN e.direccion
	WHEN xColumn = 12 THEN e.cargo
	WHEN xColumn = 13 THEN e.sede
    ELSE e.codigo 
 END DESC ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listarJuegos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listarJuegos`()
select j.codigo_, j.codigo, j.nombre, j.desarrolladora, j.plataforma, j.precio, j.stock, cat.categoria as "categoria"
 from tb_juego j 
 inner join tb_categoria cat on j.categoria = cat.codigo
 order by j.codigo ASC ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listarLaptop` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listarLaptop`()
select t.codigo_, t.codigo, t.marca, t.modelo, t.procesador, t.tarjetavideo, t.pantalla, t.precio, t.stock, cat.categoria as "categoria"
 from tb_laptop t 
 inner join tb_categoria cat on t.categoria = cat.codigo
 order by t.codigo ASC ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listarLaptopGamer` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listarLaptopGamer`()
select l.codigo_, l.codigo, l.marca, l.modelo, l.procesador, l.tarjetavideo, l.size, l.precio, l.stock, cat.categoria as "categoria"
 from tb_laptopgamer l 
 inner join tb_categoria cat on l.categoria = cat.codigo
 order by l.codigo ASC ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listarMandos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listarMandos`()
select m.codigo_, m.codigo, m.nombre, m.marca, m.tipoconex, m.precio, m.stock, cat.categoria as "categoria"
 from tb_mando m 
 inner join tb_categoria cat on m.categoria = cat.codigo
 order by m.codigo ASC ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listarMicrofono` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listarMicrofono`()
select t.codigo_, t.codigo, t.marca, t.modelo, t.tipoconex, t.precio, t.stock, cat.categoria as "categoria"
 from tb_microfono t 
 inner join tb_categoria cat on t.categoria = cat.codigo
 order by t.codigo ASC ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listarMouse` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listarMouse`()
select t.codigo_, t.codigo, t.marca, t.modelo, t.descripcion, t.tipoconex, t.precio, t.stock, cat.categoria as "categoria"
 from tb_mouse t 
 inner join tb_categoria cat on t.categoria = cat.codigo
 order by t.codigo ASC ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listarMouseGamer` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listarMouseGamer`()
select m.codigo_, m.codigo, m.marca, m.modelo, m.descripcion, m.tipoconex, m.precio, m.stock, cat.categoria as "categoria"
 from tb_mousegamer m 
 inner join tb_categoria cat on m.categoria = cat.codigo
 order by m.codigo ASC ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listarParlante` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listarParlante`()
select t.codigo_, t.codigo, t.marca, t.modelo, t.descripcion, t.tipoconex, t.precio, t.stock, cat.categoria as "categoria"
 from tb_parlante t 
 inner join tb_categoria cat on t.categoria = cat.codigo
 order by t.codigo ASC ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listarPCEscritorio` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listarPCEscritorio`()
select t.codigo_, t.codigo, t.procesador, t.discoduro, t.placamadre, t.tarjetavideo, t.fuentepoder, t.refrigeracion, t.precio, t.stock, cat.categoria as "categoria"
 from tb_pcescritorio t 
 inner join tb_categoria cat on t.categoria = cat.codigo
 order by t.codigo ASC ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listarPCGamer` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listarPCGamer`()
select p.codigo_, p.codigo, p.procesador, p.discoduro, p.placamadre, p.tarjvideo, p.fuentepoder, p.refrigeracion, p.precio, p.stock, cat.categoria as "categoria"
 from tb_pcgamer p 
 inner join tb_categoria cat on p.categoria = cat.codigo
 order by p.codigo ASC ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listarProveedor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listarProveedor`()
SELECT * FROM tb_proveedor ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listarSillaGamer` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listarSillaGamer`()
select s.codigo_, s.codigo, s.marca, s.modelo, s.descripcion, s.precio, s.stock, cat.categoria as "categoria"
 from tb_sillagamer s 
 inner join tb_categoria cat on s.categoria = cat.codigo
 order by s.codigo ASC ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listarTablet` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listarTablet`()
select t.codigo_, t.codigo, t.marca, t.modelo, t.procesador, t.descripcion, t.precio, t.stock, cat.categoria as "categoria"
 from tb_tablet t 
 inner join tb_categoria cat on t.categoria = cat.codigo
 order by t.codigo ASC ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listarTeclado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listarTeclado`()
select t.codigo_, t.codigo, t.marca, t.modelo, t.descripcion, t.tipoconex, t.precio, t.stock, cat.categoria as "categoria"
 from tb_teclado t 
 inner join tb_categoria cat on t.categoria = cat.codigo
 order by t.codigo ASC ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listarTecladoGamer` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listarTecladoGamer`()
select t.codigo_, t.codigo, t.marca, t.modelo, t.descripcion, t.tipoconex, t.precio, t.stock, cat.categoria as "categoria"
 from tb_tecladogamer t 
 inner join tb_categoria cat on t.categoria = cat.codigo
 order by t.codigo ASC ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listarTelevisor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listarTelevisor`()
select t.codigo_, t.codigo, t.marca, t.modelo, t.descripcion, t.precio, t.stock, cat.categoria as "categoria"
 from tb_televisor t 
 inner join tb_categoria cat on t.categoria = cat.codigo
 order by t.codigo ASC ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-01  5:37:37
