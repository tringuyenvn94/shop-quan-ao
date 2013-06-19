-- MySQL dump 10.13  Distrib 5.5.15, for Win32 (x86)
--
-- Host: localhost    Database: shopquanao
-- ------------------------------------------------------
-- Server version	5.5.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `shopquanao`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `shopquanao` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `shopquanao`;

--
-- Table structure for table `binhluan`
--

DROP TABLE IF EXISTS `binhluan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `binhluan` (
  `mabinhluan` int(11) NOT NULL AUTO_INCREMENT,
  `noidung` varchar(10000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `manguoidung` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `matv` int(11) DEFAULT NULL,
  `xoa` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`mabinhluan`),
  KEY `FK_TenTruyCap` (`manguoidung`),
  KEY `FK_BL_MaTV` (`matv`),
  CONSTRAINT `FK_BL_MaTV` FOREIGN KEY (`matv`) REFERENCES `tv` (`MaTV`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_TenTruyCap` FOREIGN KEY (`manguoidung`) REFERENCES `khachhang` (`TenTruyCap`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `binhluan`
--

LOCK TABLES `binhluan` WRITE;
/*!40000 ALTER TABLE `binhluan` DISABLE KEYS */;
INSERT INTO `binhluan` VALUES (1,'good','test',5,0),(2,'good','test',2,0),(4,'good','test',2,0),(5,'good','test',2,0),(6,'good','test',2,0);
/*!40000 ALTER TABLE `binhluan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chitietdondathang`
--

DROP TABLE IF EXISTS `chitietdondathang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chitietdondathang` (
  `MaChiTiet` int(11) NOT NULL AUTO_INCREMENT,
  `MaDonHang` int(11) DEFAULT NULL,
  `MaSP` int(11) DEFAULT NULL,
  `SoLuong` int(11) DEFAULT NULL,
  `Xoa` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`MaChiTiet`),
  KEY `FK_MaDonHang` (`MaDonHang`),
  KEY `FK_MaTV` (`MaSP`),
  KEY `FK_MaSP` (`MaSP`),
  CONSTRAINT `FK_MaDonHang` FOREIGN KEY (`MaDonHang`) REFERENCES `dondathang` (`MaDonDatHang`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_MaSP` FOREIGN KEY (`MaSP`) REFERENCES `sp` (`MaSP`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitietdondathang`
--

LOCK TABLES `chitietdondathang` WRITE;
/*!40000 ALTER TABLE `chitietdondathang` DISABLE KEYS */;
/*!40000 ALTER TABLE `chitietdondathang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `danhmuc`
--

DROP TABLE IF EXISTS `danhmuc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `danhmuc` (
  `MaDanhMuc` int(11) NOT NULL AUTO_INCREMENT,
  `TenDanhMuc` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `XuatXu` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Xoa` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`MaDanhMuc`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `danhmuc`
--

LOCK TABLES `danhmuc` WRITE;
/*!40000 ALTER TABLE `danhmuc` DISABLE KEYS */;
INSERT INTO `danhmuc` VALUES (11,'Áo sơ mi','Việt Nam',NULL),(12,'Áo Khoác','Việt Nam',NULL),(13,'Quần Jean nữ','Việt Nam',NULL),(14,'Áo Thun nữ','Việt Nam',NULL),(15,'Váy thời trang','Việt Nam',NULL);
/*!40000 ALTER TABLE `danhmuc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dondathang`
--

DROP TABLE IF EXISTS `dondathang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dondathang` (
  `MaDonDatHang` int(11) NOT NULL AUTO_INCREMENT,
  `NgayDatHang` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `NgayGiao` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `MaKhachHang` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `GiaTri` float DEFAULT NULL,
  `MaNVGH` int(11) DEFAULT NULL,
  `MaTinhTrang` int(11) DEFAULT NULL,
  `Xoa` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`MaDonDatHang`),
  KEY `F_MaTinhTrang` (`MaTinhTrang`),
  KEY `FK_MaKH` (`MaKhachHang`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dondathang`
--

LOCK TABLES `dondathang` WRITE;
/*!40000 ALTER TABLE `dondathang` DISABLE KEYS */;
/*!40000 ALTER TABLE `dondathang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khachhang`
--

DROP TABLE IF EXISTS `khachhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `khachhang` (
  `TenTruyCap` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `MatKhau` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `HoTen` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Email` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DienThoai` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DiaChi` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Xoa` tinyint(1) DEFAULT '0',
  `Admin` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`TenTruyCap`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khachhang`
--

LOCK TABLES `khachhang` WRITE;
/*!40000 ALTER TABLE `khachhang` DISABLE KEYS */;
INSERT INTO `khachhang` VALUES ('admin','admin','Admin','tanbinh.dev@gamil.com',NULL,NULL,0,1),('test','123','test','abc@gmail.com','null','',0,0);
/*!40000 ALTER TABLE `khachhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sp`
--

DROP TABLE IF EXISTS `sp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sp` (
  `MaSP` int(11) NOT NULL AUTO_INCREMENT,
  `TenSP` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `MaDanhMuc` int(11) DEFAULT NULL,
  `SoLuongTon` int(11) DEFAULT NULL,
  `SoLuong` int(11) DEFAULT NULL,
  `MoTa` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DonGia` float DEFAULT NULL,
  `HinhAnh` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Xoa` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`MaSP`),
  KEY `FK_NhaSanXuat` (`MaDanhMuc`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sp`
--

LOCK TABLES `sp` WRITE;
/*!40000 ALTER TABLE `sp` DISABLE KEYS */;
INSERT INTO `sp` VALUES (36,'Áo khoác nữ kiểu dáng Burberry',12,10,10,'Chất liệu: thun da cá cao cấp\r\nMàu sắc: xám, xanh da trời\r\nSize:có kích thước dài 60cm, dài tay 55cm\r\n',300000,'imgs/K_03.jpg',NULL),(37,'Áo khoác cài nút',12,10,10,'Chất liệu: vải nỉ mềm mài\r\nMàu sắc: da bò, đỏ\r\nSize: dài 57cm, ngang ngực 52cm, ngang lai (bo thun) 46cm, ngang vai 41cm, dài tay 57m, mũ 37cm. \r\n',225000,'imgs/K_06.jpg',NULL),(38,'Áo khoác cá tính ngày hè',12,10,10,'Chất liệu: thun nỉ\r\nMàu sắc: màu bò\r\nSize: thích hợp cho những cô nàng cao từ 1m50-1m60',300000,' imgs/K_04.jpg',NULL),(39,'Áo sơ mi trắng nẹp đen',11,5,5,'- Chất liệu : Tơ nhung\r\n- Màu sắc : Trắng \r\n- Size : Freesize, dài 62cm\r\n- Mô tả : Áo sơ mi trắng cách điệu viền đen, tạo phong cách mới cho bạn. Bạn sẽ trở nên nỗi bật khi mặc chiếc áo này, đặc biệt phù hợp với những bạn nữ đi làm công sở.',140000,'imgs/SM_01.jpg',NULL),(40,'Áo Sơ mi công sở ASM',11,5,5,'Loại vải: Chiffon\r\nSize: L, M, S, XL\r\nMàu:Trắng',390000,'imgs/SM_02.jpg',NULL),(41,'Áo Sơ mi viền cổ xanh đen',11,5,5,'Chất liệu: Voan\r\nMàu sắc: Xanh dương\r\nSize: M ',300000,'imgs/SM_03.jpg',NULL),(42,'Áo sơ mi nữ thanh lịch',11,10,10,'Chất liệu : Cotton\r\nSize : S – M – L – XL\r\nMàu Sắc : Trắng',300000,'imgs/SM_04.jpg',NULL),(43,'Áo sơ mi họa tiết tay dài',11,5,5,'Chất liệu: Voan\r\nMàu sắc: Họa tiết Xanh dương, Đỏ\r\nSize: M',150000,'imgs/SM_05.jpg',NULL),(44,'Áo thun Bird',14,10,10,'Chất liệu: 95% cotton + 5% Spandex \nMàu: Xanh dương, Bạc hà \nSize: S, M ',138000,'imgs/AoThun_Bird_138k.jpg',NULL),(45,'Áo thun Dream',14,15,15,'Chất liệu: 95%cotton và 5%cycra\r\nMàu: Xanh lá, Đỏ\r\nSize: S, M',138000,'imgs/Aothun_Dream_138k_AnhNho.jpg',NULL),(46,'Áo thun Mr',14,5,5,'Chất liệu: 95%cotton và 5%cycra\r\nMàu: Trắng, Vàng.\r\nSize: S, M.',158000,'imgs/AoThun_Mr.png',NULL),(47,'Áo thun Đồng Hồ Tháp',14,5,5,'Chất liệu: 95%cotton và 5%cycra\r\nMàu: Xanh dương , Xanh lá\r\nSize: S, M ',138000,'imgs/Aothun_ThapDongHo_138k.jpg',NULL),(48,'Áo thun TX',14,10,10,'Chất liệu: 95%cotton và 5%cycra\r\nMàu: Trắng - Đen, Trắng - Xanh lá\r\nSize: S, M',148000,'imgs/AoThun_TX.jpg',NULL),(49,'Váy ngày hè thanh lịch',15,10,10,'Chất liệu: Voan mềm mại\r\nMàu: Pastel bóng\r\nSize: thích hợp cho những cô nàng nhỏ nhắn cao dưới 1m60',300000,'imgs/V_01.jpg',NULL),(50,'Váy đẹp ngày hè',15,10,10,'Chất liệu: Voan\r\nMàu sắc: vàng nhạt, xanh nhạt, hồng nhạt\r\nSize:S - M - L - XL\r\n',370000,'imgs/V_02.jpg',NULL),(51,'Váy xòe',15,10,10,'Chất liệu: thun mềm\r\nMàu:hồng nhạt\r\nSize: thích hợp cho những cô nàng cao dưới 1m60, vóc người nhỏ nhắn',405000,'imgs/V_03.jpg',NULL),(52,'Váy liền tiểu thư',15,10,10,'Chất liệu: Vải\r\nMàu sắc: Hông\r\nSize: S-M',300000,'imgs/V_05_1.jpg',NULL),(53,'Váy ren tiểu thư',15,10,10,'Chất liêu: ren và thun\r\nMàu sắc: hồng phấn\r\nSize: S-M',300000,'imgs/V_06.jpg',NULL);
/*!40000 ALTER TABLE `sp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thamso`
--

DROP TABLE IF EXISTS `thamso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `thamso` (
  `MaThamSo` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `TenThamSo` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `GiaTri` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`MaThamSo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thamso`
--

LOCK TABLES `thamso` WRITE;
/*!40000 ALTER TABLE `thamso` DISABLE KEYS */;
INSERT INTO `thamso` VALUES ('CVC','Cước vận chuyển','0.01'),('TGTGT','Thuế','0.1');
/*!40000 ALTER TABLE `thamso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tinhtrangdondathang`
--

DROP TABLE IF EXISTS `tinhtrangdondathang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tinhtrangdondathang` (
  `MaTinhTrang` int(11) NOT NULL AUTO_INCREMENT,
  `TenTinhTrang` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Xoa` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`MaTinhTrang`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tinhtrangdondathang`
--

LOCK TABLES `tinhtrangdondathang` WRITE;
/*!40000 ALTER TABLE `tinhtrangdondathang` DISABLE KEYS */;
INSERT INTO `tinhtrangdondathang` VALUES (1,'Chưa Đặt Hàng',NULL),(2,'Đã Đặt Hàng',NULL);
/*!40000 ALTER TABLE `tinhtrangdondathang` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-06-19  9:07:28
