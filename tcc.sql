# MySQL-Front 5.0  (Build 1.0)

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;


# Host: 127.0.0.1    Database: tcc
# ------------------------------------------------------
# Server version 5.0.15-nt

CREATE DATABASE `tcc` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `tcc`;

#
# Table structure for table admin
#

CREATE TABLE `admin` (
  `id` int(11) NOT NULL auto_increment,
  `userName` varchar(255) default NULL,
  `userPw` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `admin` VALUES (1,'admin','biyeseng');

#
# Table structure for table cfei
#

CREATE TABLE `cfei` (
  `id` int(11) NOT NULL auto_increment,
  `hao` varchar(255) default NULL,
  `jdate` varchar(255) default NULL,
  `ldate` varchar(255) default NULL,
  `jine` varchar(255) default NULL,
  `adate` varchar(255) default NULL,
  `shijian` varchar(255) default NULL,
  `biao` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `cfei` VALUES (2,'京AE123H','2016-03-10 11:56:20','2016-03-10 20:13:24','24','2016-03-10 20:13:25','8','3');

#
# Table structure for table che
#

CREATE TABLE `che` (
  `id` int(11) NOT NULL auto_increment,
  `hao` varchar(255) default NULL,
  `leixing` varchar(255) default NULL,
  `pic` varchar(255) default NULL,
  `info` varchar(255) default NULL,
  `uid` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `che` VALUES (1,'京AE123H','大众宝来','/upload/1426251805448.jpg','33',1);

#
# Table structure for table chewei
#

CREATE TABLE `chewei` (
  `id` int(11) NOT NULL auto_increment,
  `hao` varchar(255) default NULL,
  `info` varchar(255) default NULL,
  `qu` varchar(255) default NULL,
  `chepai` varchar(255) default NULL,
  `adate` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `chewei` VALUES (2,'A01','A01','A区','京AE123H','2016-03-13 21:03:37');
INSERT INTO `chewei` VALUES (3,'A02','A02','A区','','');
INSERT INTO `chewei` VALUES (4,'A03','A03','A区','','');
INSERT INTO `chewei` VALUES (5,'B01','B01','B区','','');
INSERT INTO `chewei` VALUES (6,'B02','B02','B区','','');
INSERT INTO `chewei` VALUES (7,'C01','C01','C区','','');
INSERT INTO `chewei` VALUES (8,'C02','大飒飒','C区','','');

#
# Table structure for table fei
#

CREATE TABLE `fei` (
  `id` int(11) NOT NULL auto_increment,
  `price` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `fei` VALUES (1,'3');

#
# Table structure for table userinfo
#

CREATE TABLE `userinfo` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(255) default NULL,
  `pwd` varchar(255) default NULL,
  `age` varchar(255) default NULL,
  `tel` varchar(255) default NULL,
  `jine` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `userinfo` VALUES (1,'zs','biyeseng','22','13572260111','175');

/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
