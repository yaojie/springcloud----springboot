/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.40 : Database - orderingsystem
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`orderingsystem` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `orderingsystem`;

/*Table structure for table `t_admin` */

DROP TABLE IF EXISTS `t_admin`;

CREATE TABLE `t_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(11) DEFAULT NULL,
  `password` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_admin` */

insert  into `t_admin`(`id`,`username`,`password`) values (1,'admin1','123123');

/*Table structure for table `t_menu` */

DROP TABLE IF EXISTS `t_menu`;

CREATE TABLE `t_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `flavor` varchar(11) DEFAULT NULL,
  `tid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `tid` (`tid`),
  CONSTRAINT `t_menu_ibfk_1` FOREIGN KEY (`tid`) REFERENCES `t_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

/*Data for the table `t_menu` */

insert  into `t_menu`(`id`,`name`,`price`,`flavor`,`tid`) values (2,'烧椒扣肉12',46,'微辣',3),(3,'栗子三杯鸡',56,'五香',1),(4,'毛血旺',50,'麻辣',1),(5,'菠菜拌粉丝',22,'五香',2),(6,'凉拌豆腐皮',19,'微辣',2),(7,'酱牛肉',36,'麻辣',2),(8,'鱼头豆腐汤',32,'五香',3),(9,'瘦肉鸡蛋白菜汤',30,'五香',3),(10,'西葫芦虾仁蒸饺',26,'五香',4),(11,'蛋炒饭1',18,'五香',4),(12,'酥粒椰蓉面包',12,'香甜',5),(16,NULL,0,NULL,NULL);

/*Table structure for table `t_order` */

DROP TABLE IF EXISTS `t_order`;

CREATE TABLE `t_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `mid` int(11) DEFAULT NULL,
  `aid` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `uid` (`uid`),
  KEY `mid` (`mid`),
  KEY `aid` (`aid`),
  CONSTRAINT `t_order_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `t_user` (`id`),
  CONSTRAINT `t_order_ibfk_2` FOREIGN KEY (`mid`) REFERENCES `t_menu` (`id`),
  CONSTRAINT `t_order_ibfk_3` FOREIGN KEY (`aid`) REFERENCES `t_admin` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

/*Data for the table `t_order` */

insert  into `t_order`(`id`,`uid`,`mid`,`aid`,`date`,`state`) values (1,1,7,1,'2019-02-06',1),(2,1,2,1,'2019-02-06',1),(5,1,5,1,'2019-02-06',1),(6,1,9,1,'2019-02-06',1),(10,1,10,1,'2019-02-06',1),(11,1,10,1,'2019-02-06',1),(12,1,10,1,'2019-02-06',1),(14,1,6,1,'2019-02-06',1),(16,1,10,1,'2019-02-06',1),(19,1,7,1,'2019-02-07',1),(26,2,8,1,'2019-02-08',1),(27,2,12,1,'2019-02-08',1),(29,1,2,NULL,NULL,0),(30,1,2,NULL,NULL,0),(31,1,2,NULL,'2020-02-23',0),(32,1,2,NULL,'2020-02-23',0),(33,1,11,NULL,'2020-02-23',0),(34,1,11,NULL,'2020-02-23',0),(35,1,2,NULL,'2020-02-23',0),(36,1,2,NULL,'2020-02-23',0),(37,1,2,NULL,'2020-02-23',0),(38,1,3,NULL,'2020-02-23',0);

/*Table structure for table `t_type` */

DROP TABLE IF EXISTS `t_type`;

CREATE TABLE `t_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `t_type` */

insert  into `t_type`(`id`,`name`) values (1,'热菜'),(2,'凉菜'),(3,'汤羹'),(4,'主食'),(5,'烘焙');

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(11) DEFAULT NULL,
  `password` varchar(11) DEFAULT NULL,
  `nickname` varchar(11) DEFAULT NULL,
  `gender` varchar(2) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `registerdate` date DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`username`,`password`,`nickname`,`gender`,`telephone`,`registerdate`,`address`) values (1,'zhangsan','123123','张三','男','13576765678','2019-02-03','科技路'),(2,'lisi','123123','李四','女','18678987676','2019-02-03','科技路');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
