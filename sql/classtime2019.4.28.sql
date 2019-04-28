/*
Navicat MySQL Data Transfer

Source Server         : asd
Source Server Version : 50723
Source Host           : localhost:3306
Source Database       : classtime

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2019-04-28 23:06:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `phone_model`
-- ----------------------------
DROP TABLE IF EXISTS `phone_model`;
CREATE TABLE `phone_model` (
  `model_id` int(10) NOT NULL AUTO_INCREMENT,
  `open_id` varchar(30) NOT NULL COMMENT '用户的openId',
  `brand` varchar(50) DEFAULT NULL COMMENT '设备品牌',
  `model` varchar(50) DEFAULT NULL COMMENT '设备型号',
  `languages` varchar(50) DEFAULT NULL COMMENT '微信设置的语言',
  `version` varchar(50) DEFAULT NULL COMMENT '微信版本号',
  `system` varchar(50) DEFAULT NULL COMMENT '操作系统及其版本',
  `platform` varchar(50) DEFAULT NULL COMMENT '客户端平台',
  `sdk_version` varchar(50) DEFAULT NULL COMMENT '客户端基础库版本',
  PRIMARY KEY (`model_id`),
  KEY `phone_model_ibfk_1` (`open_id`),
  CONSTRAINT `phone_model_ibfk_1` FOREIGN KEY (`open_id`) REFERENCES `user` (`open_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='保留用户设备信息';

-- ----------------------------
-- Records of phone_model
-- ----------------------------

-- ----------------------------
-- Table structure for `ranking`
-- ----------------------------
DROP TABLE IF EXISTS `ranking`;
CREATE TABLE `ranking` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '系统生成的记录主键',
  `open_id` varchar(30) NOT NULL COMMENT '用户信息',
  `times` int(10) DEFAULT '0' COMMENT '总的秒数',
  PRIMARY KEY (`id`),
  KEY `ranking_ibfk_1` (`open_id`),
  CONSTRAINT `ranking_ibfk_1` FOREIGN KEY (`open_id`) REFERENCES `user` (`open_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='存放所有人的时间总记录';

-- ----------------------------
-- Records of ranking
-- ----------------------------

-- ----------------------------
-- Table structure for `reply`
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply` (
  `reply_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '系统自动生成',
  `open_id` varchar(30) NOT NULL COMMENT '提交反馈的人',
  `contact` varchar(40) NOT NULL COMMENT '联系方式',
  `content` varchar(2000) NOT NULL COMMENT '反馈内容',
  `create_time` char(30) DEFAULT NULL COMMENT '提交的时间',
  `check_box_value` varchar(30) DEFAULT NULL COMMENT '反馈类型',
  `stars` int(10) unsigned zerofill DEFAULT '0000000000' COMMENT '评价的星数',
  PRIMARY KEY (`reply_id`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reply
-- ----------------------------
INSERT INTO `reply` VALUES ('1', '645645', '13546', '3456135', '2019-12-3', '4564354', '0000000005');
INSERT INTO `reply` VALUES ('2', '5645343', '45645645', '4634534534645645', '1988', 'asdasd', '0000000005');
INSERT INTO `reply` VALUES ('3', '3', '3', '3', '3', '3', '0000000005');
INSERT INTO `reply` VALUES ('4', '4', '4', '4', '4', '4', '0000000005');
INSERT INTO `reply` VALUES ('5', '5', '5', '5', '5', '5', '0000000005');
INSERT INTO `reply` VALUES ('6', '6', '6', '6', '6', '6', '0000000005');
INSERT INTO `reply` VALUES ('7', '7', '7', '7', '7', '7', '0000000007');
INSERT INTO `reply` VALUES ('8', '8', '8', '8', '8', '8', '0000000008');
INSERT INTO `reply` VALUES ('9', '9', '9', '9', '9', '9', '0000000005');
INSERT INTO `reply` VALUES ('10', '10', '10', '10', '10', '10', '0000000005');
INSERT INTO `reply` VALUES ('11', '11', '11', '11', '11', '11', '0000000005');
INSERT INTO `reply` VALUES ('12', '12', '12', '12', '12', '12', '0000000005');
INSERT INTO `reply` VALUES ('13', '13', '13', '13', '13', '13', '0000000005');

-- ----------------------------
-- Table structure for `room`
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `room_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '房间id，唯一',
  `room_number` int(10) NOT NULL COMMENT '房间码',
  `open_id` varchar(30) NOT NULL COMMENT '创建者',
  `room_state` int(1) NOT NULL DEFAULT '1' COMMENT '是否有效，有效期为两小时，1代表有效，0代表无效',
  `room_peoples` int(5) DEFAULT '0' COMMENT '房间人数',
  `remark` char(50) DEFAULT NULL COMMENT '房间备注',
  `create_time` char(30) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`room_id`),
  KEY `open_id` (`open_id`),
  CONSTRAINT `room_ibfk_1` FOREIGN KEY (`open_id`) REFERENCES `user` (`open_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用于保存房间本身的基本信息，保留一条系统记录，用作表示未加入房间的情况，id为1，state永远为1';

-- ----------------------------
-- Records of room
-- ----------------------------

-- ----------------------------
-- Table structure for `room_people`
-- ----------------------------
DROP TABLE IF EXISTS `room_people`;
CREATE TABLE `room_people` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '这条记录的主键，系统自动累加',
  `open_id` varchar(30) NOT NULL COMMENT '提交记录的人',
  `name` char(30) DEFAULT NULL COMMENT '昵称或姓名，绑定姓名则保存姓名，否则显示昵称',
  `room_id` int(10) NOT NULL COMMENT '加入的房间id，不是房间号',
  `begain_time` char(30) DEFAULT NULL COMMENT '加入房间的时间',
  `times` int(10) DEFAULT '0' COMMENT '在该房间类总共计时的时间',
  `school_id` char(15) DEFAULT NULL COMMENT '学号，没有就为空',
  PRIMARY KEY (`id`),
  KEY `room_id` (`room_id`),
  KEY `open_id` (`open_id`),
  CONSTRAINT `room_people_ibfk_1` FOREIGN KEY (`room_id`) REFERENCES `room` (`room_id`) ON UPDATE CASCADE,
  CONSTRAINT `room_people_ibfk_2` FOREIGN KEY (`open_id`) REFERENCES `user` (`open_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='保存加入房间的人的信息，每个加入房间的人都会创建一条记录，以后可更新times字段';

-- ----------------------------
-- Records of room_people
-- ----------------------------

-- ----------------------------
-- Table structure for `test`
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `ids` int(5) NOT NULL AUTO_INCREMENT,
  `name` char(5) DEFAULT NULL,
  PRIMARY KEY (`ids`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用来做测试的表，可任意更改';

-- ----------------------------
-- Records of test
-- ----------------------------

-- ----------------------------
-- Table structure for `time`
-- ----------------------------
DROP TABLE IF EXISTS `time`;
CREATE TABLE `time` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '系统生成的记录主键',
  `open_id` varchar(30) NOT NULL COMMENT '提交记录的人',
  `room_id` int(10) DEFAULT NULL COMMENT '若加入房间则是房间记录的主键id，否则为1，表示为加入房间',
  `dates` char(30) DEFAULT NULL COMMENT '提交记录的日期，年-月-日',
  `begain` char(30) DEFAULT NULL COMMENT '本次记录开始的时间，时-分-秒',
  `ends` char(30) DEFAULT NULL COMMENT '本次记录结束的时间，时-分-秒',
  `pause` int(3) DEFAULT NULL COMMENT '暂停次数，最后一次翻过手机并停止并不算暂停',
  `times` char(10) DEFAULT NULL COMMENT '这一次计时的时间，若加入房间，在该房间内可产生多条记录，时间会累加到room_people的times字段上',
  `pause_msg` varchar(255) DEFAULT NULL COMMENT '该计时区间内每次开始和暂停的时刻',
  `net_work_type` char(10) DEFAULT NULL COMMENT '所用网络类型网络类型',
  PRIMARY KEY (`id`),
  KEY `open_id` (`open_id`),
  KEY `room_id` (`room_id`),
  CONSTRAINT `time_ibfk_1` FOREIGN KEY (`open_id`) REFERENCES `user` (`open_id`) ON UPDATE CASCADE,
  CONSTRAINT `time_ibfk_2` FOREIGN KEY (`room_id`) REFERENCES `room` (`room_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='保存每按下stop按钮所提交的记录，即便同一房间类也可能产生多条记录';

-- ----------------------------
-- Records of time
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `open_id` varchar(30) NOT NULL COMMENT '用户的openId',
  `school_id` char(15) DEFAULT NULL COMMENT '学号或教师号，可不绑定',
  `name` char(30) DEFAULT NULL COMMENT '微信昵称',
  `session_key` char(30) DEFAULT NULL COMMENT '系统key',
  `union_id` char(30) DEFAULT NULL COMMENT '系统key',
  `school_name` char(30) DEFAULT NULL COMMENT '学校的姓名，可不绑定',
  PRIMARY KEY (`open_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息';

-- ----------------------------
-- Records of user
-- ----------------------------
