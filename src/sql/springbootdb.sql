/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : localhost
 Source Database       : springbootdb

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : utf-8

 Date: 08/30/2017 18:51:16 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `city`
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '城市编号',
  `province_id` int(10) unsigned NOT NULL COMMENT '省份编号',
  `city_name` varchar(25) CHARACTER SET utf8 DEFAULT NULL COMMENT '城市名称',
  `description` varchar(25) CHARACTER SET utf8 DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `city`
-- ----------------------------
BEGIN;
INSERT INTO `city` VALUES ('1', '1', '温岭市', '你的家乡是风景秀美的吗？'), ('3', '116', '平顶山', '最美的家在平顶山'), ('4', '16', '郑州', '最棒的省会在郑州'), ('5', '21', '上海', '上海是我生活的地方吗'), ('6', '21', '北京', '北京是首都吗？'), ('7', '21', '南京', '南京为什么也叫京？'), ('8', '15', '开封北站', '开封中州国际大酒店'), ('9', '15', '开封北站', '开封中州国际大酒店'), ('10', '166', '开封宋城路', '开封玉详国际大酒店'), ('11', '166', '开封宋城路', '开封玉详国际大酒店'), ('12', '166', '开封宋城路', '开封玉详国际大酒店'), ('13', '166', '开封宋城路', '开封玉详国际大酒店'), ('14', '166', '开封宋城路', '开封玉详国际大酒店'), ('15', '166', '开封宋城路', '开封玉详国际大酒店'), ('16', '18', '上海信隆行信息科技股份有限公司', '高云涛'), ('17', '18', '高云涛', '上海市工商行政管理局');
COMMIT;

-- ----------------------------
--  Table structure for `company`
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `name` varchar(255) DEFAULT NULL COMMENT '公司名称',
  `code` varchar(255) NOT NULL COMMENT '统一社会信用代码',
  `boss` varchar(255) DEFAULT NULL COMMENT '法人代表',
  `reg` varchar(255) DEFAULT '' COMMENT '登记机关',
  `date` varchar(255) DEFAULT NULL COMMENT '成立日期',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='企业信用信息';

-- ----------------------------
--  Records of `company`
-- ----------------------------
BEGIN;
INSERT INTO `company` VALUES ('1', '上海信隆行信息科技股份有限公司', '913100005707693130', '高云涛', '上海市工商行政管理局', '2011年03月15日'), ('2', '上海信隆行信息科技股份有限公司', '913100005707693130', '高云涛', '上海市工商行政管理局', '2011年03月15日'), ('3', '上海信隆行信息科技股份有限公司', '913100005707693130', '高云涛', '上海市工商行政管理局', '2011年03月15日');
COMMIT;

-- ----------------------------
--  Table structure for `token`
-- ----------------------------
DROP TABLE IF EXISTS `token`;
CREATE TABLE `token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户编号,base_user.bu_id',
  `value` varchar(255) DEFAULT NULL COMMENT '凭证值',
  `create_time` datetime DEFAULT NULL COMMENT 'Token生成时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='token信息表';

-- ----------------------------
--  Records of `token`
-- ----------------------------
BEGIN;
INSERT INTO `token` VALUES ('1', '9527', '123456', '2017-07-27 16:18:28');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
