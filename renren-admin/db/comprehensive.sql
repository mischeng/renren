/*
Navicat MySQL Data Transfer

Source Server         : test_linux
Source Server Version : 50644
Source Host           : 193.112.43.114:10001
Source Database       : xixie0001user

Target Server Type    : MYSQL
Target Server Version : 50644
File Encoding         : 65001

Date: 2019-07-07 10:10:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for comprehensive
-- ----------------------------
DROP TABLE IF EXISTS `comprehensive`;
CREATE TABLE `comprehensive` (
  `uuid` varchar(255) DEFAULT NULL,
  `announcement` text,
  `discount` float(11,0) DEFAULT NULL,
  `point` varchar(1000) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comprehensive
-- ----------------------------
