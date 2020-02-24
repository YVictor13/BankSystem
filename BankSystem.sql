/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : atm

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2017-07-17 11:14:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `bank`
-- ----------------------------
DROP TABLE IF EXISTS `bank`;
CREATE TABLE `bank` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `balance` double(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bank
-- ----------------------------
INSERT INTO `bank` VALUES ('1', 'aa', 'aa', '200.00');
INSERT INTO `bank` VALUES ('2', '小邵', '123', '703.62');
INSERT INTO `bank` VALUES ('3', '小疯子', '123', '100.00');
INSERT INTO `bank` VALUES ('4', '小张', '123', '250.00');
INSERT INTO `bank` VALUES ('5', 'w', '789', '400.00');
INSERT INTO `bank` VALUES ('6', 'qwer', 'zxc', '0.00');
INSERT INTO `bank` VALUES ('7', '789', '123', '0.00');
INSERT INTO `bank` VALUES ('8', '7894', '123', '0.00');
