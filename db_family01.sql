/*
 Navicat Premium Data Transfer

 Source Server         : Mysql
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : localhost:3306
 Source Schema         : db_family01

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 18/09/2023 14:27:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_account
-- ----------------------------
DROP TABLE IF EXISTS `t_account`;
CREATE TABLE `t_account`  (
  `aid` bigint NOT NULL AUTO_INCREMENT COMMENT '账户id',
  `uid` bigint NULL DEFAULT NULL COMMENT '用户id',
  `account_des` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '账户说明',
  `account_money` decimal(10, 2) NULL DEFAULT 0.00 COMMENT '账户总金额',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `deleted` tinyint NOT NULL COMMENT '是否删除 0未删除 1删除',
  PRIMARY KEY (`aid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_account
-- ----------------------------
INSERT INTO `t_account` VALUES (1, 5, 'mao的账户', 800.00, '第一个哦', '2023-09-15 09:55:36', '2023-09-15 21:38:26', 0);
INSERT INTO `t_account` VALUES (2, 6, 'song的账户', 1000.00, '第二个哦', '2023-09-13 10:24:13', '2023-09-15 16:38:30', 0);
INSERT INTO `t_account` VALUES (3, 8, 'mama的账户', 10000.00, '是弱智哦', '2023-09-15 10:53:27', '2023-09-18 09:43:22', 0);
INSERT INTO `t_account` VALUES (5, 9, 'niao的账户', 10000.00, '鸟', '2023-09-18 11:25:23', NULL, 1);
INSERT INTO `t_account` VALUES (6, 9, 'niao的账户', 15000.00, '--\\(˙<>˙)/--', '2023-09-18 11:33:10', NULL, 0);

-- ----------------------------
-- Table structure for t_education
-- ----------------------------
DROP TABLE IF EXISTS `t_education`;
CREATE TABLE `t_education`  (
  `eid` bigint NOT NULL AUTO_INCREMENT COMMENT '学历主键',
  `education_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '学历编号',
  `education_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '学历名称',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `deleted` tinyint NOT NULL COMMENT '是否删除 0不删除 1删除',
  PRIMARY KEY (`eid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_education
-- ----------------------------
INSERT INTO `t_education` VALUES (1, '01', '中专', '是中专哦', '2023-09-13 17:27:44', '2023-09-14 13:28:05', 0);
INSERT INTO `t_education` VALUES (2, '02', '大专', '', '2023-09-14 09:46:19', '2023-09-16 08:34:48', 0);
INSERT INTO `t_education` VALUES (3, '03', '大学', NULL, '2023-09-14 09:46:32', NULL, 0);
INSERT INTO `t_education` VALUES (4, '04', '研究生', '', '2023-09-14 13:19:07', NULL, 0);

-- ----------------------------
-- Table structure for t_family
-- ----------------------------
DROP TABLE IF EXISTS `t_family`;
CREATE TABLE `t_family`  (
  `fid` bigint NOT NULL AUTO_INCREMENT COMMENT '家庭主键',
  `family_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '家庭编码',
  `family_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '家庭名称',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `deleted` tinyint NOT NULL COMMENT '是否删除 0不删除 1删除',
  PRIMARY KEY (`fid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_family
-- ----------------------------
INSERT INTO `t_family` VALUES (2, 'qht002', '破裂一家', '感情破裂了哦', '2023-09-12 18:57:35', '2023-09-13 22:19:18', 0);
INSERT INTO `t_family` VALUES (3, 'ts002', '和谐一家', '很和谐的一家哦', '2023-09-12 18:58:59', '2023-09-13 22:21:24', 0);
INSERT INTO `t_family` VALUES (4, 'ts003', '八孩之家', '有八个孩子哦', '2023-09-13 21:37:54', '2023-09-15 17:18:57', 0);
INSERT INTO `t_family` VALUES (5, 'x001', '小三之家', '嘻嘻家主是小三哦', '2023-09-13 22:25:04', '2023-09-15 17:19:22', 0);
INSERT INTO `t_family` VALUES (6, 'x002', '睡眠之家', '很喜欢睡眠', '2023-09-13 22:43:52', '2023-09-13 22:44:26', 0);
INSERT INTO `t_family` VALUES (7, 'qhd004', '点点点', '点点点', '2023-09-15 08:38:26', NULL, 1);
INSERT INTO `t_family` VALUES (8, 'xgh', '许光汉家', '有嫩p哦', '2023-09-15 18:19:02', NULL, 0);

-- ----------------------------
-- Table structure for t_type
-- ----------------------------
DROP TABLE IF EXISTS `t_type`;
CREATE TABLE `t_type`  (
  `tid` bigint NOT NULL AUTO_INCREMENT COMMENT '类型主键',
  `type_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '类型编号',
  `type_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '类型名称',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `deleted` tinyint NULL DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`tid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_type
-- ----------------------------
INSERT INTO `t_type` VALUES (1, '0001', '中国人民银行', '活期储蓄哦', '2023-09-15 16:43:05', '2023-09-15 17:33:30', 0);
INSERT INTO `t_type` VALUES (2, '0002', '支付宝支付', NULL, '2023-09-15 16:46:32', NULL, 0);
INSERT INTO `t_type` VALUES (3, '0003', '黄金', NULL, '2023-09-15 17:02:43', NULL, 0);
INSERT INTO `t_type` VALUES (4, '0004', '花呗', '每月还钱', '2023-09-16 14:13:52', NULL, 0);
INSERT INTO `t_type` VALUES (8, '0005', '现金', NULL, '2023-09-18 09:42:42', NULL, 0);

-- ----------------------------
-- Table structure for t_type_account
-- ----------------------------
DROP TABLE IF EXISTS `t_type_account`;
CREATE TABLE `t_type_account`  (
  `ttid` bigint NOT NULL AUTO_INCREMENT COMMENT '账户类型主键',
  `aid` bigint NULL DEFAULT NULL COMMENT '账户id',
  `account_des` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '账户描述说明',
  `account_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '账户编码',
  `account_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '支付方式',
  `accrual_money` decimal(10, 2) NULL DEFAULT 0.00 COMMENT '发送额',
  `balance_money` decimal(10, 2) NULL DEFAULT 0.00 COMMENT '余额',
  `tid` bigint NULL DEFAULT NULL COMMENT '类型id',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `deleted` tinyint NULL DEFAULT 0 COMMENT '是否删除',
  `divert_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '转入人',
  `divert_time` datetime NULL DEFAULT NULL COMMENT '转入时间',
  `out_id` bigint NULL DEFAULT NULL COMMENT '转出人id',
  `div_id` bigint NULL DEFAULT NULL COMMENT '转入人id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `is_type` tinyint NULL DEFAULT 0 COMMENT '支付类型 1收入 0支出',
  PRIMARY KEY (`ttid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_type_account
-- ----------------------------
INSERT INTO `t_type_account` VALUES (1, 1, '人民银行账户', 'm01', '微信支付', 0.00, 2000.00, NULL, NULL, '2023-09-17 14:41:14', NULL, 0, NULL, NULL, NULL, NULL, 'niao', NULL);
INSERT INTO `t_type_account` VALUES (2, 3, '麻麻的现金账户', 'mama002', NULL, 0.00, 1500.00, 8, NULL, '2023-09-18 11:00:22', NULL, 0, NULL, NULL, NULL, NULL, 'mama', 0);
INSERT INTO `t_type_account` VALUES (3, 1, 'mao的支付宝', 'mao001', '支付宝支付', 0.00, 200.00, 2, NULL, '2023-09-18 11:10:32', NULL, 0, NULL, NULL, NULL, NULL, '毛毛', 0);

-- ----------------------------
-- Table structure for t_users
-- ----------------------------
DROP TABLE IF EXISTS `t_users`;
CREATE TABLE `t_users`  (
  `uid` bigint NOT NULL AUTO_INCREMENT COMMENT '用户主键',
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户姓名',
  `sex` tinyint NULL DEFAULT NULL COMMENT '用户性别 0男 1女',
  `occupation` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户职业',
  `eid` bigint NULL DEFAULT NULL COMMENT '学历id',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户信息描述',
  `fid` bigint NULL DEFAULT NULL COMMENT '家庭id',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `deleted` tinyint NOT NULL COMMENT '是否删除 0不删除 1删除',
  `is_account` tinyint NULL DEFAULT 0 COMMENT '是否开通账户 0未开通 1开通',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_users
-- ----------------------------
INSERT INTO `t_users` VALUES (1, 'admin', 'e10adc3949ba59abbe56e057f20f883e', '管理员', NULL, NULL, NULL, '', NULL, '是备注哦', '2023-09-14 15:03:13', '2023-09-14 15:53:30', 0, 0);
INSERT INTO `t_users` VALUES (2, 'test', '', '测试', NULL, NULL, NULL, '', NULL, '', '2023-09-14 15:54:37', NULL, 1, 0);
INSERT INTO `t_users` VALUES (3, 'test2', '', '测试哦', NULL, NULL, NULL, '', NULL, '', '2023-09-14 15:55:07', NULL, 1, 0);
INSERT INTO `t_users` VALUES (4, 'yu', '123456', '毛羽', 1, NULL, 2, '', 2, '', '2023-09-14 17:00:59', NULL, 1, 0);
INSERT INTO `t_users` VALUES (5, 'mao', '111111', '毛毛', 0, '街溜子', 4, 'idel', 6, '我有玉玉症', '2023-09-14 17:13:24', NULL, 0, 1);
INSERT INTO `t_users` VALUES (6, 'song', '123456', '宋松', 1, '小三', 1, '小三是一种态度', 5, '小三是一种生活', '2023-09-14 21:57:47', '2023-09-15 16:38:21', 0, 1);
INSERT INTO `t_users` VALUES (7, 'zhang', '123456', '章鱼哥', 1, '章鱼小丸子', 3, '很好吃哦', 5, '木鱼花加倍', '2023-09-15 09:12:58', NULL, 0, 0);
INSERT INTO `t_users` VALUES (8, 'mama', 'e10adc3949ba59abbe56e057f20f883e', '麻麻', 0, '法师', 2, '沉默术专精', 2, '小时候吃过三鹿奶粉', '2023-09-15 09:15:36', '2023-09-15 15:38:36', 0, 1);
INSERT INTO `t_users` VALUES (9, 'niao', '9fe352d7912a5310f2510bc441405b94', '鸟子哥', 0, '搬砖', 4, '苦逼的搬砖狗一枚呀~', 3, '周六上班没有加班费', '2023-09-16 18:41:15', NULL, 0, 1);

SET FOREIGN_KEY_CHECKS = 1;
