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

 Date: 09/07/2017 11:28:52 AM
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
  `city_name` varchar(25) DEFAULT NULL COMMENT '城市名称',
  `description` varchar(25) DEFAULT NULL COMMENT '描述',
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
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COMMENT='企业信用信息';

-- ----------------------------
--  Records of `company`
-- ----------------------------
BEGIN;
INSERT INTO `company` VALUES ('1', '上海信隆行信息科技股份有限公司', '913100005707693130', '高云涛', '上海市工商行政管理局', '2011年03月15日', '2017-09-04 14:55:18', '2017-09-04 14:55:18'), ('2', '佛山市信隆行纺织有限公司', '91440604MA4ULWFX9D', '陈玉书', '佛山市禅城区工商行政管理局', '2016年02月03日', '2017-09-04 14:55:18', '2017-09-04 14:55:18'), ('3', '湖南信隆行信息技术有限公司', '430104000142024', '陆婷', '长沙市工商行政管理局岳麓分局', '2015年05月21日', '2017-09-04 14:55:18', '2017-09-04 14:55:18'), ('4', '上海信隆行信福投资管理有限公司', '913101105997851578', '徐军', '杨浦区市场监管局', '2012年07月19日', '2017-09-04 14:55:18', '2017-09-04 14:55:18'), ('5', '广州市荔湾区信隆行木业经营部', '914401017142710642', '李渊明', '广州市荔湾区工商行政管理局', '1999年04月27日', '2017-09-04 14:55:18', '2017-09-04 14:55:18'), ('6', '惠州市信隆行房地产有限公司', '914413033454732680', '黄育青', '惠阳区工商行政管理局', '2015年07月06日', '2017-09-04 14:55:18', '2017-09-04 14:55:18'), ('7', '四川信隆行信息技术有限公司', '915101003579777112', '高云涛', '高新工商局', '2015年09月17日', '2017-09-04 14:55:18', '2017-09-04 14:55:18'), ('8', '上海信隆行信息科技股份有限公司温州分公司', '913303020894761197', '陈是力', '温州市鹿城区市场监督管理局', '2013年12月23日', '2017-09-04 14:55:18', '2017-09-04 14:55:18'), ('9', '上海信隆行信息科技股份有限公司杭州分公司', '91330108341790522R', '孙震', '杭州市高新区（滨江）市场监督管理局', '2015年05月04日', '2017-09-04 14:55:18', '2017-09-04 17:35:18'), ('10', '上海信隆行信息科技股份有限公司嘉兴分公司', '91330401337013704C', '倪秋霞', '嘉兴市市场监督局经济开发区分局', '2015年05月11日', '2017-09-04 14:55:18', '2017-09-04 17:55:18'), ('11', '上海信隆行信息科技股份有限公司分公司', '91310106MA1FY4594Y', '李堃', '静安区市场监管局', '2016年10月20日', '2017-09-04 14:55:18', '2017-09-05 10:06:18'), ('12', '上海信隆行信息科技股份有限公司江阴分公司', '913202813311256765', '谭帧华', '江阴市市场监督管理局', '2015年02月13日', '2017-09-04 14:55:18', '2017-09-04 14:55:18'), ('13', '上海信隆行信息科技股份有限公司北京分公司', '911101063512918665', '张磊', '北京市工商行政管理局朝阳分局', '2015年07月20日', '2017-09-04 14:55:18', '2017-09-04 14:55:18'), ('14', '上海信隆行信息科技股份有限公司南昌分公司', '91360108352138759E', '丁佳', '南昌经济技术开发区市场和质量监督管理局', '2015年09月08日', '2017-09-04 14:55:18', '2017-09-04 14:55:18'), ('15', '上海信隆行信息科技股份有限公司张家港分公司', '91320582MA1M90R938', '何倩', '张家港市市场监督管理局', '2015年09月08日', '2017-09-04 14:55:18', '2017-09-04 14:55:18'), ('16', '上海信隆行信息科技股份有限公司常熟分公司', '91320581MA1M92R055', '范思思', '注销（其他原因）', '2017年06月19日', '2017-09-04 14:55:18', '2017-09-04 14:55:18'), ('17', '上海信隆行信息科技股份有限公司舟山分公司', '91330901355389094Q', '周意科', '舟山市市场监督管理局海洋产业集聚区分局', '2015年09月16日', '2017-09-04 14:55:18', '2017-09-04 14:55:18'), ('18', '上海信隆行信息科技股份有限公司合肥分公司', '91340100MA2MQ8Q26K', '陈琢', '合肥市高新开发区市场监督管理局', '2015年10月13日', '2017-09-04 14:55:18', '2017-09-04 14:55:18'), ('19', '上海信隆行信息科技股份有限公司绍兴分公司', '91330600MA28825F1J', '赵辰斌', '绍兴市越城区市场监督管理局', '2015年11月10日', '2017-09-04 14:55:18', '2017-09-04 14:55:18'), ('20', '上海信隆行信息科技股份有限公司武汉分公司', '91420100MA4KLB779X', '赵辰斌', ' 武汉东湖新技术开发区', '2015年11月10日', '2017-09-04 14:55:18', '2017-09-04 14:55:18'), ('21', '上海信隆行信息科技股份有限公司台州分公司', '91331021MA28G2ER0M', '赵辰斌', '台州市市场监督管理局经济开发区分局', '2015年11月12日', '2017-09-04 14:55:18', '2017-09-04 14:55:18'), ('22', '上海信隆行信息科技股份有限公司无锡分公司', '91320213MA1MBXHC5P', '倪辛谷', '无锡市新吴区市场监督管理局', '2015年12月01日', '2017-09-04 14:55:18', '2017-09-04 14:55:18'), ('23', '上海信隆行信息科技股份有限公司江苏分公司', '91320102MA1MCQQ51C', '谭帧华', '南京市玄武区市场监督管理局', '2015年12月14日', '2017-09-04 14:55:18', '2017-09-04 14:55:18'), ('24', '上海信隆行信息科技股份有限公司四川分公司', '91510100MA61TC9J25', '陆婷', '高新工商局', '2016年01月21日', '2017-09-04 14:55:18', '2017-09-04 14:55:18'), ('25', '上海信隆行信息科技股份有限公司湖南分公司', '91430100MA4L3CFLX1', '赵辰斌', '长沙市工商行政管理局高新技术产业开发分局', '2016年03月23日', '2017-09-04 14:55:18', '2017-09-04 14:55:18'), ('26', '上海信隆行信息科技股份有限公司湖州分公司', '91330501MA28CANC5E', '李亮', '湖州市市场监督管理局湖州经济技术开发区分局', '2016年06月12日', '2017-09-04 14:55:18', '2017-09-04 14:55:18'), ('27', '上海信隆行信息科技股份有限公司青岛分公司', '91370203MA3CL0MG9D', '范思思', '青岛市市北区工商行政管理局', '2016年11月04日', '2017-09-04 14:55:18', '2017-09-04 14:55:18'), ('28', '上海信隆行信息科技股份有限公司常州分公司', '91320402339028934D', '丁佳', '常州市天宁区市场监督管理局', '2015年05月08日', '2017-09-04 14:55:18', '2017-09-04 14:55:18'), ('30', '北京信隆行信息科技有限公司', '913100005707693130', '高云涛', '北京市工商行政管理局海淀分局', '2017年09月05日', '2017-09-06 13:52:14', '2017-09-06 13:52:14'), ('31', '湖州信隆行信息科技有限公司', '913100005707693130', '高云涛', '湖州市吴兴区工商行政管理局', '2017年09月05日', '2017-09-06 13:55:57', '2017-09-06 13:55:57'), ('32', '杭州信隆行信息科技有限公司', '913100005707693130', '高云涛', '杭州市下沙街道', '2017年09月05日', '2017-09-06 13:57:10', '2017-09-06 13:57:10'), ('33', '合肥信隆行信息科技有限公司', '913100005707693130', '高云涛', '合肥市高新区', '2017年09月05日', '2017-09-06 13:57:41', '2017-09-06 13:57:41'), ('34', '舟山信隆行信息科技有限公司', '913100005707693130', '高云涛', '舟山市定海区中国（舟山）海洋科学城', '2017年09月05日', '2017-09-06 13:58:03', '2017-09-06 13:58:03');
COMMIT;

-- ----------------------------
--  Table structure for `loan`
-- ----------------------------
DROP TABLE IF EXISTS `loan`;
CREATE TABLE `loan` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `finance` varchar(255) NOT NULL COMMENT '金融机构',
  `name` varchar(255) NOT NULL COMMENT '金融产品名称',
  `type` int(11) unsigned zerofill DEFAULT NULL COMMENT '贷款类型(1:发票贷, 2:过桥贷, 3:税收贷)',
  `loan_limit` int(20) unsigned zerofill NOT NULL COMMENT '贷款额度(万元)',
  `time_limit` int(10) unsigned zerofill NOT NULL COMMENT '贷款期限(月)',
  `approval` int(11) DEFAULT NULL COMMENT '审核时间(天)',
  `repayment` int(10) unsigned zerofill DEFAULT NULL COMMENT '还款方式(1:到期本金付息, 2:可按月、按季或到期一次性还款，3：每月付息，到期一次性还本)',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='贷款产品信息';

-- ----------------------------
--  Records of `loan`
-- ----------------------------
BEGIN;
INSERT INTO `loan` VALUES ('1', '复星小贷', '发票贷', '0', '300', '0', '0', '0', '2017-09-06 18:02:00', '2017-09-06 18:02:03'), ('2', '复星小贷', '过桥贷', '0', '200', '0', '0', '0', '2017-09-07 10:39:11', '2017-09-07 10:39:13'), ('3', '复星小贷', '税收贷', '0', '100', '0', '0', '0', '2017-09-07 10:39:15', '2017-09-07 10:39:17'), ('4', '上海专享', '软件贷', '0', '3000', '0', '0', '0', '2017-09-07 10:39:20', '2017-09-07 10:39:23'), ('5', '上海专享', '订单贷', '0', '3000', '0', '30', '0', '2017-09-07 10:39:26', '2017-09-07 10:39:28'), ('6', '上海专享', '节能贷', '0', '3000', '0', '30', '0', '2017-09-07 10:39:30', '2017-09-07 10:39:32'), ('7', '上海专享', '创意贷', '0', '3000', '0', '30', '0', '2017-09-07 10:39:36', '2017-09-07 10:39:37'), ('8', '上海专享', '智权贷', '0', '3000', '0', '30', '0', '2017-09-07 10:39:40', '2017-09-07 10:39:42'), ('9', '上海专享', '智权贷', '0', '3000', '0', '30', '0', '2017-09-07 10:39:45', '2017-09-07 10:39:47'), ('10', '上海', '中高标抵押物（住房、别墅）贷款', '0', '6000', '0', '3', '0', '2017-09-07 10:39:49', '2017-09-07 10:39:51'), ('11', '南京、无锡、常州', '小易租', '0', '100', '0', '3', '0', '2017-09-07 10:39:53', '2017-09-07 10:39:55'), ('12', '星罗', '微贷通', '0', '100', '0', '3', '0', '2017-09-07 10:39:58', '2017-09-07 10:40:00');
COMMIT;

-- ----------------------------
--  Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `t_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `t_name` varchar(255) DEFAULT NULL,
  `t_age` int(11) DEFAULT NULL,
  `t_address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `t_user`
-- ----------------------------
BEGIN;
INSERT INTO `t_user` VALUES ('1', '妞儿', '23', '的三个垃圾股；领导'), ('2', '三个大杀手', '25', '阿三的换个卡睡个懒觉安徽快乐');
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
