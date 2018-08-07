/*
Navicat MySQL Data Transfer

Source Server         : 10.10.10.121
Source Server Version : 50723
Source Host           : 10.10.10.121:3306
Source Database       : cat_demo_schema

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2018-08-07 18:57:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `title` varchar(64) DEFAULT NULL COMMENT '标题',
  `summary` varchar(128) DEFAULT NULL COMMENT '摘要',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='文章表';

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', '1', '颈椎病康复指南', '颈椎疼痛真难受');
INSERT INTO `article` VALUES ('2', '1', '腰椎间盘突出日常护理', '腰部疼痛下肢麻木越来越严重');
INSERT INTO `article` VALUES ('3', '1', '活着', '好好活着不好吗');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(32) DEFAULT NULL COMMENT '用户名称',
  `password` varchar(32) DEFAULT NULL COMMENT '用户密码',
  `email` varchar(64) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin', 'admin@gmail.com');
INSERT INTO `user` VALUES ('2', 'guest', 'guest', 'guest@gmail.com');
