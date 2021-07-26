/*
 Navicat MySQL Data Transfer

 Source Server         : 我的阿里云服务器
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : 47.103.218.111:3306
 Source Schema         : restaurant

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 27/05/2021 22:39:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '员工姓名',
  `number` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '员工编号',
  `sex` tinyint DEFAULT NULL COMMENT '性别(0男1女)',
  `age` tinyint DEFAULT NULL COMMENT '年龄',
  `role` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '普通员工' COMMENT '角色',
  `phone` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '电话',
  `salary` int DEFAULT NULL COMMENT '薪水',
  `stay` tinyint DEFAULT NULL COMMENT '是否离职(0未离职1已离职)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='员工表';

-- ----------------------------
-- Records of employee
-- ----------------------------
BEGIN;
INSERT INTO `employee` VALUES (1, '员工1号', 'emp1', 1, 11, '员工', '13512345678', 3, 0);
INSERT INTO `employee` VALUES (2, '员工2号', 'emp2', 0, 18, '员工', '18314321782', 3000, 0);
INSERT INTO `employee` VALUES (3, '员工3号', 'emp3', 0, 18, '员工', '18314321783', 3000, 0);
INSERT INTO `employee` VALUES (4, '员工4号', 'emp4', 0, 18, '员工', '18314321784', 3000, 0);
INSERT INTO `employee` VALUES (5, '员工5号', 'emp5', 0, 18, '员工', '18314321785', 3000, 0);
INSERT INTO `employee` VALUES (6, '员工6号', 'emp6', 0, 18, '员工', '18314321786', 3000, 0);
INSERT INTO `employee` VALUES (7, '员工7号', 'emp7', 0, 18, '员工', '18314321787', 3000, 0);
INSERT INTO `employee` VALUES (8, '员工8号', 'emp8', 0, 18, '员工', '18314321788', 3000, 0);
INSERT INTO `employee` VALUES (9, '员工9号', 'emp9', 0, 18, '员工', '18314321789', 3000, 0);
INSERT INTO `employee` VALUES (10, '员工10号', 'emp10', 0, 18, '员工', '183143217810', 3000, 0);
INSERT INTO `employee` VALUES (11, '员工11号', 'emp11', 0, 18, '员工', '183143217811', 3000, 0);
INSERT INTO `employee` VALUES (12, '员工12号', 'emp12', 0, 18, '员工', '183143217812', 3000, 0);
INSERT INTO `employee` VALUES (13, '员工13号', 'emp13', 0, 18, '员工', '183143217813', 3000, 0);
INSERT INTO `employee` VALUES (14, '员工14号', 'emp14', 0, 18, '员工', '183143217814', 3000, 0);
INSERT INTO `employee` VALUES (15, '员工15号', 'emp15', 0, 18, '员工', '183143217815', 3000, 0);
INSERT INTO `employee` VALUES (16, '员工16号', 'emp16', 0, 18, '员工', '183143217816', 3000, 0);
INSERT INTO `employee` VALUES (17, '员工17号', 'emp17', 0, 18, '员工', '183143217817', 3000, 0);
INSERT INTO `employee` VALUES (18, '员工18号', 'emp18', 0, 18, '员工', '183143217818', 3000, 0);
INSERT INTO `employee` VALUES (19, '员工19号', 'emp19', 0, 18, '员工', '183143217819', 3000, 0);
INSERT INTO `employee` VALUES (20, '员工20号', 'emp20', 0, 18, '员工', '183143217820', 3000, 0);
INSERT INTO `employee` VALUES (21, '员工21号', 'emp21', 1, 18, '员工', '13578901234', 12, 1);
INSERT INTO `employee` VALUES (22, '员工22号', 'emp22', 0, 17, '员工', '13523346788', 3000, 0);
INSERT INTO `employee` VALUES (23, '员工23号', 'emp23', 1, 12, '经理', '18327895643', 6666, 1);
INSERT INTO `employee` VALUES (24, '王五', 'emp24', 0, 19, '厨师', '18312349876', 6000, 0);
INSERT INTO `employee` VALUES (25, '赵六', 'emp25', 1, 18, '服务员', '13212347890', 4000, 0);
INSERT INTO `employee` VALUES (26, '张三', 'emp26', 0, 18, '厨师', '13512345679', 3100, 0);
INSERT INTO `employee` VALUES (27, '阿七', 'emp27', 1, 19, '服务员', '13523231898', 3400, 0);
INSERT INTO `employee` VALUES (28, '周八', 'emp28', 0, 18, '服务员', '13578963671', 2500, 1);
INSERT INTO `employee` VALUES (31, '小明', 'empzs', 0, 18, '厨师', '13218971456', 3000, 1);
INSERT INTO `employee` VALUES (32, '小红', 'empls', 1, 18, '服务员', '13498014567', 3000, 0);
COMMIT;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '商品名称',
  `price` decimal(16,2) NOT NULL COMMENT '单价',
  `description` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '货物描述',
  `sid` int DEFAULT NULL COMMENT '所属供应商',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='货物表';

-- ----------------------------
-- Records of goods
-- ----------------------------
BEGIN;
INSERT INTO `goods` VALUES (1, '大白菜', 1.00, '这是一棵大白菜', 1);
INSERT INTO `goods` VALUES (2, '大白菜', 2.00, '这是一棵大白菜', 1);
INSERT INTO `goods` VALUES (3, '大白菜', 3.00, '这是一棵大白菜', 1);
INSERT INTO `goods` VALUES (4, '大白菜', 4.00, '这是一棵大白菜', 1);
INSERT INTO `goods` VALUES (5, '大白菜', 5.00, '这是一棵大白菜', 1);
INSERT INTO `goods` VALUES (6, '大白菜', 6.00, '这是一棵大白菜', 1);
INSERT INTO `goods` VALUES (7, '大白菜', 7.00, '这是一棵大白菜', 1);
INSERT INTO `goods` VALUES (8, '大白菜', 8.00, '这是一棵大白菜', 1);
INSERT INTO `goods` VALUES (9, '大白菜', 9.00, '这是一棵大白菜', 1);
INSERT INTO `goods` VALUES (10, '大白菜', 10.00, '这是一棵大白菜', 1);
INSERT INTO `goods` VALUES (11, '大白菜', 11.00, '这是一棵大白菜', 1);
INSERT INTO `goods` VALUES (12, '大白菜', 12.00, '这是一棵大白菜', 1);
INSERT INTO `goods` VALUES (13, '大白菜', 13.00, '这是一棵大白菜', 1);
INSERT INTO `goods` VALUES (14, '大白菜', 14.00, '这是一棵大白菜', 1);
INSERT INTO `goods` VALUES (15, '大白菜', 15.00, '这是一棵大白菜', 1);
INSERT INTO `goods` VALUES (16, '大白菜', 16.00, '这是一棵大白菜', 1);
INSERT INTO `goods` VALUES (17, '大白菜', 17.00, '这是一棵大白菜', 1);
INSERT INTO `goods` VALUES (18, '大白菜', 18.00, '这是一棵大白菜', 1);
INSERT INTO `goods` VALUES (19, '大白菜', 19.00, '这是一棵大白菜', 1);
INSERT INTO `goods` VALUES (20, '大白菜', 20.00, '这是一棵大白菜', 1);
COMMIT;

-- ----------------------------
-- Table structure for goods_info
-- ----------------------------
DROP TABLE IF EXISTS `goods_info`;
CREATE TABLE `goods_info` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '进货id',
  `supplier_name` varchar(32) DEFAULT NULL COMMENT '供应商名称',
  `goods_name` varchar(32) DEFAULT NULL COMMENT '商品名称',
  `pay_type` varchar(32) DEFAULT NULL COMMENT '支付类型',
  `purchase_time` varchar(32) DEFAULT NULL COMMENT '进货时间',
  `quantity` int DEFAULT NULL COMMENT '进货数量',
  `total_price` int DEFAULT NULL COMMENT '总价',
  `remark` varchar(128) DEFAULT NULL COMMENT '备注',
  `returned` tinyint DEFAULT '0' COMMENT '是否退货0未退货(默认)1已退货',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods_info
-- ----------------------------
BEGIN;
INSERT INTO `goods_info` VALUES (3, '广州a食品有限公司', '大白菜', '支付宝', '2021-01-05 15:34:27', 1, 2, '332', 1);
INSERT INTO `goods_info` VALUES (4, '广州b食品有限公司', '大白菜', '银联', '2021-03-06 15:35:03', 1, 2, '332', 1);
INSERT INTO `goods_info` VALUES (9, '广州A食品有限公司', '马铃薯', '支付宝', '2021-01-05 15:43:14', 9, 19, '1', 1);
INSERT INTO `goods_info` VALUES (10, '广州B食品有限公司', '番茄', '银联', '2021-03-06 15:46:34', 1, 2, 'wrw', 0);
INSERT INTO `goods_info` VALUES (18, '广州C食品有限公司', '可乐', '银联', '2021-01-05 15:56:08', 1, 2, '1', 0);
INSERT INTO `goods_info` VALUES (19, '广州D食品有限公司', '大白菜', '支付宝', '2021-01-05 15:56:19', 1, 2, '4', 0);
INSERT INTO `goods_info` VALUES (25, '广州E食品有限公司', '南瓜', '微信', '2021-03-06 15::11:11', 1, 1, '无', 0);
COMMIT;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '菜名',
  `price` decimal(16,0) DEFAULT NULL COMMENT '单价',
  `description` varchar(128) DEFAULT NULL COMMENT '描述',
  `url` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '图片',
  `is_collected` varchar(32) DEFAULT '0' COMMENT '菜的状态0正常1下架',
  `status_` tinyint DEFAULT '0' COMMENT '逻辑删除(0未删除1已删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='菜单表';

-- ----------------------------
-- Records of menu
-- ----------------------------
BEGIN;
INSERT INTO `menu` VALUES (1, '百合炖梨盅', 1600, NULL, 'http://47.103.218.111:82/menu_imgs/529c1588-17b8-4f26-bc64-df7569550251.jpg', NULL, NULL);
INSERT INTO `menu` VALUES (2, '轻松熊咖喱饭', 1800, NULL, 'http://47.103.218.111:82/menu_imgs/91e25c63-9a94-4bac-8818-a50a8215df70.jpg', NULL, NULL);
INSERT INTO `menu` VALUES (3, '萝卜炖汤', 2000, NULL, 'http://47.103.218.111:82/menu_imgs/93843ccb-3e11-4d0b-8f9d-f3b95b1c52f7.jpg', '0', 0);
INSERT INTO `menu` VALUES (4, '开心小米粥', 3000, NULL, 'http://47.103.218.111:82/menu_imgs/2d84208e-b4e8-48e6-849b-43a224cdcfd2.jpg', NULL, NULL);
INSERT INTO `menu` VALUES (5, '番茄柠檬泡泡饮', 1000, NULL, 'http://47.103.218.111:82/menu_imgs/fcd2fef2-1db1-4caa-9daa-796fe61f2ad8.jpg', NULL, NULL);
INSERT INTO `menu` VALUES (6, '青瓜柠檬特饮', 3, NULL, 'http://47.103.218.111:82/menu_imgs/64afcf8e-b818-4077-a9bd-43d93cb806e0.jpg', NULL, NULL);
INSERT INTO `menu` VALUES (7, '爱心玫瑰小小酥', 2, NULL, 'http://47.103.218.111:82/menu_imgs/f0a0ced3-f416-4c06-9d53-844077453e23.jpg', NULL, NULL);
INSERT INTO `menu` VALUES (8, '青菜粥', 1, NULL, 'http://47.103.218.111:82/menu_imgs/dce755bd-7c1b-428e-b10f-a31a715fcdc0.jpg', NULL, NULL);
INSERT INTO `menu` VALUES (20, '酸菜鱼', 1900, NULL, 'http://47.103.218.111:82/menu_imgs/7a413afa-c00e-4ec7-91a5-9fbf5be2cdbc.jpg', NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
  `detail_id` bigint NOT NULL AUTO_INCREMENT COMMENT '订单详情自增id',
  `order_id` bigint NOT NULL COMMENT '对应的主订单id',
  `menu_id` bigint NOT NULL COMMENT '菜单id',
  `menu_name` varchar(64) NOT NULL COMMENT '菜单名称',
  `menu_price` decimal(8,2) NOT NULL COMMENT '菜单当前价格,单位分',
  `menu_quantity` int NOT NULL COMMENT '订了多少份',
  `menu_icon` varchar(512) DEFAULT NULL COMMENT '小图',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `status_` tinyint NOT NULL DEFAULT '0' COMMENT '逻辑删除0未删除1已删除',
  PRIMARY KEY (`detail_id`),
  KEY `idx_order_id` (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='订单详情表';

-- ----------------------------
-- Records of order_detail
-- ----------------------------
BEGIN;
INSERT INTO `order_detail` VALUES (22, 50, 8, '青菜粥', 1.00, 1, 'http://47.103.218.111:82/menu_imgs/dce755bd-7c1b-428e-b10f-a31a715fcdc0.jpg', '2021-03-05 03:40:26', '2021-03-05 03:40:26', 0);
INSERT INTO `order_detail` VALUES (23, 51, 8, '青菜粥', 1.00, 1, 'http://47.103.218.111:82/menu_imgs/dce755bd-7c1b-428e-b10f-a31a715fcdc0.jpg', '2021-03-05 04:23:51', '2021-03-05 04:23:51', 0);
INSERT INTO `order_detail` VALUES (87, 115, 20, '酸菜鱼', 1800.00, 1, 'http://47.103.218.111:82/menu_imgs/7a413afa-c00e-4ec7-91a5-9fbf5be2cdbc.jpg', '2021-03-06 15:12:00', '2021-03-06 15:12:00', 0);
INSERT INTO `order_detail` VALUES (88, 116, 20, '酸菜鱼', 1800.00, 1, 'http://47.103.218.111:82/menu_imgs/7a413afa-c00e-4ec7-91a5-9fbf5be2cdbc.jpg', '2021-03-29 14:13:59', '2021-03-29 14:13:59', 0);
INSERT INTO `order_detail` VALUES (89, 117, 7, '爱心玫瑰小小酥', 2.00, 1, 'http://47.103.218.111:82/menu_imgs/f0a0ced3-f416-4c06-9d53-844077453e23.jpg', '2021-03-29 14:16:19', '2021-03-29 14:16:19', 0);
INSERT INTO `order_detail` VALUES (90, 118, 6, '青瓜柠檬特饮', 3.00, 1, 'http://47.103.218.111:82/menu_imgs/64afcf8e-b818-4077-a9bd-43d93cb806e0.jpg', '2021-03-29 14:16:34', '2021-03-29 14:16:34', 0);
INSERT INTO `order_detail` VALUES (91, 119, 1, '百合炖梨盅', 1600.00, 1, 'http://47.103.218.111:82/menu_imgs/529c1588-17b8-4f26-bc64-df7569550251.jpg', '2021-03-29 14:16:47', '2021-03-29 14:16:47', 0);
INSERT INTO `order_detail` VALUES (92, 120, 20, '酸菜鱼', 1900.00, 1, 'http://47.103.218.111:82/menu_imgs/7a413afa-c00e-4ec7-91a5-9fbf5be2cdbc.jpg', '2021-03-29 14:52:21', '2021-03-29 14:52:21', 0);
INSERT INTO `order_detail` VALUES (93, 121, 20, '酸菜鱼', 1900.00, 1, 'http://47.103.218.111:82/menu_imgs/7a413afa-c00e-4ec7-91a5-9fbf5be2cdbc.jpg', '2021-04-05 20:56:39', '2021-04-05 20:56:39', 0);
INSERT INTO `order_detail` VALUES (94, 122, 20, '酸菜鱼', 1900.00, 1, 'http://47.103.218.111:82/menu_imgs/7a413afa-c00e-4ec7-91a5-9fbf5be2cdbc.jpg', '2021-04-05 20:58:20', '2021-04-05 20:58:20', 0);
INSERT INTO `order_detail` VALUES (95, 123, 8, '青菜粥', 1.00, 1, 'http://47.103.218.111:82/menu_imgs/dce755bd-7c1b-428e-b10f-a31a715fcdc0.jpg', '2021-05-15 08:01:19', '2021-05-15 08:01:19', 0);
INSERT INTO `order_detail` VALUES (96, 124, 8, '青菜粥', 1.00, 1, 'http://47.103.218.111:82/menu_imgs/dce755bd-7c1b-428e-b10f-a31a715fcdc0.jpg', '2021-05-15 08:02:45', '2021-05-15 08:02:45', 0);
COMMIT;

-- ----------------------------
-- Table structure for order_master
-- ----------------------------
DROP TABLE IF EXISTS `order_master`;
CREATE TABLE `order_master` (
  `order_id` bigint NOT NULL AUTO_INCREMENT COMMENT '订单自增id',
  `order_number` varchar(32) NOT NULL COMMENT '订单号，唯一',
  `order_amount` decimal(16,2) NOT NULL COMMENT '订单总金额',
  `table_number` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '桌号',
  `order_status` tinyint NOT NULL DEFAULT '0' COMMENT '订单状态, 默认为新下单',
  `pay_status` tinyint NOT NULL DEFAULT '0' COMMENT '支付状态, 默认未支付',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=125 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='订单主表';

-- ----------------------------
-- Records of order_master
-- ----------------------------
BEGIN;
INSERT INTO `order_master` VALUES (50, '4cad5e2fdd2745bba4e7507b0815e7df', 1.00, '一号桌', 0, 0, '2021-03-05 03:40:26', '2021-03-05 11:54:05');
INSERT INTO `order_master` VALUES (51, '2f053dc7d7524008bdf08081a8b889e9', 1.00, '二号桌', 2, 0, '2021-03-05 04:23:51', '2021-03-06 04:20:39');
INSERT INTO `order_master` VALUES (115, 'af282a976d5f437a807a9a6739fa755b', 1800.00, '一号桌', 1, 1, '2021-03-06 15:12:00', '2021-03-06 15:13:15');
INSERT INTO `order_master` VALUES (116, '01fe86beec1a4ce398f2caca3c147d75', 1800.00, '一、', 0, 0, '2021-03-29 14:13:59', '2021-03-29 14:13:59');
INSERT INTO `order_master` VALUES (117, '81fae3c0947b43e0ae7213eaac6a457e', 2.00, '一', 0, 0, '2021-03-29 14:16:19', '2021-03-29 14:16:19');
INSERT INTO `order_master` VALUES (118, '9f38700463664204865126504a049967', 3.00, '一', 0, 0, '2021-03-29 14:16:34', '2021-03-29 14:16:34');
INSERT INTO `order_master` VALUES (119, 'aaacaa60e94542289b49f55e12aaf4e0', 1600.00, '一', 0, 0, '2021-03-29 14:16:47', '2021-03-29 14:16:47');
INSERT INTO `order_master` VALUES (120, '4a2a8716cb95420a82c5c163da00bc38', 1900.00, '一', 0, 0, '2021-03-29 14:52:21', '2021-03-29 14:52:21');
INSERT INTO `order_master` VALUES (121, 'b42a2cf5e95c427296b87b6d68104ee5', 1900.00, '一', 0, 0, '2021-04-05 20:56:39', '2021-04-05 20:56:39');
INSERT INTO `order_master` VALUES (122, '6249a475b9ab4acb853f5f12655b7f67', 1900.00, '一', 2, 0, '2021-04-05 20:58:20', '2021-05-01 15:44:05');
INSERT INTO `order_master` VALUES (123, 'ea91946b947d43ddb06b8259b65c3d75', 1.00, '一号桌', 0, 1, '2021-05-15 08:01:19', '2021-05-15 08:02:09');
INSERT INTO `order_master` VALUES (124, '31b9d66cb763411f8cc3056be4cf36f6', 1.00, '一号桌', 0, 1, '2021-05-15 08:02:45', '2021-05-15 08:03:06');
COMMIT;

-- ----------------------------
-- Table structure for register_user
-- ----------------------------
DROP TABLE IF EXISTS `register_user`;
CREATE TABLE `register_user` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '用户名',
  `avatar` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '头像',
  `sex` tinyint DEFAULT NULL COMMENT '性别',
  `email` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '电话',
  `status_` tinyint DEFAULT '0' COMMENT '状态',
  `area` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '地区',
  `openid` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '微信用户唯一标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='注册用户表';

-- ----------------------------
-- Records of register_user
-- ----------------------------
BEGIN;
INSERT INTO `register_user` VALUES (19, '南瓜塌塌', 'http://47.103.218.111:82/menu_imgs/dce755bd-7c1b-428e-b10f-a31a715fcdc0.jpg', 0, '532767248@qq.com', '18314321781', 1, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for restaurant
-- ----------------------------
DROP TABLE IF EXISTS `restaurant`;
CREATE TABLE `restaurant` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增主键id',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '分店名称',
  `manager` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '店长',
  `phone` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '分店电话',
  `address` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '分店地址',
  `start_time` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '开店时间',
  `cost` varchar(32) DEFAULT NULL COMMENT '成本',
  `turnover` varchar(32) DEFAULT NULL COMMENT '营业额',
  `status_` tinyint DEFAULT NULL COMMENT '逻辑删除(0未删除1已删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='分店表';

-- ----------------------------
-- Records of restaurant
-- ----------------------------
BEGIN;
INSERT INTO `restaurant` VALUES (1, '分店1', '小明', '020-12345671', '广州市太平镇广州大学华软软件学院', '2020-12-01', NULL, NULL, 0);
INSERT INTO `restaurant` VALUES (2, '分店2', '小红', '020-12345672', '广州市太平镇广州大学华软软件学院', '2020-12-02', NULL, NULL, 0);
INSERT INTO `restaurant` VALUES (3, '分店3', '小蓝', '020-12345673', '广州市太平镇广州大学华软软件学院', '2020-12-03', NULL, NULL, 0);
INSERT INTO `restaurant` VALUES (4, '分店4', '小芳', '020-12345674', '广州市太平镇广州大学华软软件学院', '2020-12-04', NULL, NULL, 0);
INSERT INTO `restaurant` VALUES (5, '分店5', '小丽', '020-12345675', '广州市太平镇广州大学华软软件学院', '2020-12-05', NULL, NULL, 0);
INSERT INTO `restaurant` VALUES (6, '分店6', '小俊', '020-12345676', '广州市太平镇广州大学华软软件学院', '2020-12-06', NULL, NULL, 0);
INSERT INTO `restaurant` VALUES (7, '分店7', '小黄', '020-12345677', '广州市太平镇广州大学华软软件学院', '2020-12-07', NULL, NULL, 0);
INSERT INTO `restaurant` VALUES (8, '分店8', '小明', '020-12345678', '广州市太平镇广州大学华软软件学院', '2020-12-08', NULL, NULL, 0);
INSERT INTO `restaurant` VALUES (9, '分店9', '小明', '020-12345679', '广州市太平镇广州大学华软软件学院', '2020-12-09', NULL, NULL, 0);
INSERT INTO `restaurant` VALUES (10, '分店10', '小明', '020-12345610', '广州市太平镇广州大学华软软件学院', '2020-12-10', NULL, NULL, 0);
INSERT INTO `restaurant` VALUES (11, '分店11', '小明', '020-12345611', '广州市太平镇广州大学华软软件学院', '2020-12-11', NULL, NULL, 0);
INSERT INTO `restaurant` VALUES (12, '科学城分店', '小蓝', '020-12345612', '广州市黄埔区科学城', '2020-12-12', '900', '950', 0);
INSERT INTO `restaurant` VALUES (13, '番禺广场分店', '小丽', '020-12345613', '广州市番禺区番禺广场', '2020-01-13', '800', '850', 0);
INSERT INTO `restaurant` VALUES (14, '天河智慧城分店', '小红', '020-12345614', '广州市天河区天河智慧城', '2020-01-14', '700', '750', 0);
INSERT INTO `restaurant` VALUES (15, '从化街口分店', '小华', '020-12345615', '广州市从化区街口', '2020-01-15', '600', '650', 0);
INSERT INTO `restaurant` VALUES (16, '太平镇广软分店', '小明', '020-12345616', '广州市从化区广软学院', '2020-01-16', '500', '550', 0);
COMMIT;

-- ----------------------------
-- Table structure for sys_backend_api_table
-- ----------------------------
DROP TABLE IF EXISTS `sys_backend_api_table`;
CREATE TABLE `sys_backend_api_table` (
  `backend_api_id` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '主键',
  `backend_api_name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'API名称',
  `backend_api_url` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'API请求地址',
  `backend_api_method` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'API请求方式：GET、POST、PUT、DELETE',
  `pid` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '父ID',
  `backend_api_sort` int NOT NULL COMMENT '排序',
  `description` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`backend_api_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='后端api表';

-- ----------------------------
-- Records of sys_backend_api_table
-- ----------------------------
BEGIN;
INSERT INTO `sys_backend_api_table` VALUES ('032b6fb177fa888c96d590d38411387d', '完结订单', '/orderMaster/finish/*', 'PUT', '5bc0bbaebdd7789f1b3393597ca95750', 302, '完结订单');
INSERT INTO `sys_backend_api_table` VALUES ('0ad6d11f5f18d263d032a14dd8d5ee6d', '添加菜单', '/menu/add', 'POST', 'fb5d9b3173dbb1fdf80f8c55f193ed05', 502, '添加菜单');
INSERT INTO `sys_backend_api_table` VALUES ('1', '所有API', '/**', 'GET,POST,PUT,DELETE', NULL, 0, '	admin特有');
INSERT INTO `sys_backend_api_table` VALUES ('14077b72f8f98047de7f33661ec68ba6', '人员管理', 'none', NULL, NULL, 200, '人员管理下的所有API');
INSERT INTO `sys_backend_api_table` VALUES ('195f9f730d1223e3e229828efc7fb76e', '保存分店', '/restaurant/save', 'POST', 'f7e6303037849970d742fed2b3e06a4b', 402, '保存分店');
INSERT INTO `sys_backend_api_table` VALUES ('1ed92fc53b45795f4b9f4065ce6bbec8', '根据订单id查询订单详情', '/orderMaster/detail/*', 'GET', '5bc0bbaebdd7789f1b3393597ca95750', 303, '根据订单id查询订单详情');
INSERT INTO `sys_backend_api_table` VALUES ('21505846f270ad33fa69a8c181ce6f9b', '查看记录详情', '/orderMaster/detail/*', 'GET', '69b1b8c12c9f6c58e966198a60baa254', 602, '查看记录详情');
INSERT INTO `sys_backend_api_table` VALUES ('2225bf6a340d60666e912ea022aa43c7', '删除分店', '/restaurant/*', 'DELETE', 'f7e6303037849970d742fed2b3e06a4b', 401, '删除分店');
INSERT INTO `sys_backend_api_table` VALUES ('3930e1a901ec0cb2e11257059fd5fbea', '获取退货信息列表', '/goodsInfo/getReturnedList', 'GET', '54b61472cfaf1c4a6dd7c2339e1edc29', 106, '获取退货信息列表');
INSERT INTO `sys_backend_api_table` VALUES ('47edfb154ccce3d6c73381642b1d0fee', '分页查所有人员', '/employee/findByPage/*/*', 'POST', '14077b72f8f98047de7f33661ec68ba6', 201, '分页查所有人员');
INSERT INTO `sys_backend_api_table` VALUES ('4acbe3889f099ef02308a045937f5104', '查询分店列表带分页', '/restaurant/findByPage/*/*', 'POST', 'f7e6303037849970d742fed2b3e06a4b', 405, '查询分店列表带分页');
INSERT INTO `sys_backend_api_table` VALUES ('4c8b3924d0f1cadc6bc697b4f1d56468', '保存员工', '/employee/save', 'POST', '14077b72f8f98047de7f33661ec68ba6', 205, '保存员工');
INSERT INTO `sys_backend_api_table` VALUES ('52764465ca7193af3a6921db4b5b9f2c', '查看消费记录', '/orderMaster/record/*/*', 'POST', '69b1b8c12c9f6c58e966198a60baa254', 601, '查看消费记录');
INSERT INTO `sys_backend_api_table` VALUES ('53168b1b8482682775501c86c4258fcb', '分页查所有进货信息', '/goodsInfo/getGoodsInfoList/*/*', 'POST', '54b61472cfaf1c4a6dd7c2339e1edc29', 101, '分页查所有进货信息');
INSERT INTO `sys_backend_api_table` VALUES ('54b61472cfaf1c4a6dd7c2339e1edc29', '进货管理', 'none', NULL, NULL, 100, '进货管理下的所有API');
INSERT INTO `sys_backend_api_table` VALUES ('5bc0bbaebdd7789f1b3393597ca95750', '订餐管理', 'none', NULL, NULL, 300, '订餐管理下所有API');
INSERT INTO `sys_backend_api_table` VALUES ('5d2ab0a92b82007ce55725decee4aacd', '订单列表', '/orderMaster/findByPage/*/*', 'POST', '5bc0bbaebdd7789f1b3393597ca95750', 304, '订单列表');
INSERT INTO `sys_backend_api_table` VALUES ('5d40badde0317afec766a20cd10611ea', '编辑员工', '/employee/findById/*', 'GET', '14077b72f8f98047de7f33661ec68ba6', 202, '编辑员工');
INSERT INTO `sys_backend_api_table` VALUES ('623c3f7156fb4a345f3c030f87d09aa9', '菜单管理', '/sysFrontendMenuTable', 'GET,POST,PUT,DELETE', 'ccb6659817cf193adc6bfb4dc17709ec', 902, '前端菜单管理');
INSERT INTO `sys_backend_api_table` VALUES ('69b1b8c12c9f6c58e966198a60baa254', '消费记录管理', 'none', '', NULL, 600, '消费记录管理下的所有API');
INSERT INTO `sys_backend_api_table` VALUES ('7ceb5d6d100268f624225c24a1170b59', '更新分店信息', '/restaurant/update/*', 'PUT', 'f7e6303037849970d742fed2b3e06a4b', 403, '更新分店信息');
INSERT INTO `sys_backend_api_table` VALUES ('8286e6f4986233ecceb7c9eaeffdcaa6', '修改菜单', '/menu/update/*', 'PUT', 'fb5d9b3173dbb1fdf80f8c55f193ed05', 503, '修改菜单');
INSERT INTO `sys_backend_api_table` VALUES ('82f06ed9d288e7e298556ccb199ac2de', '更新进货信息', '/goodsInfo/update/*', 'PUT', '54b61472cfaf1c4a6dd7c2339e1edc29', 107, '更新进货信息');
INSERT INTO `sys_backend_api_table` VALUES ('862190eb71ac59e3f0a19164ca0162e4', '删除进货信息', '/goodsInfo/deleteById/*', 'DELETE', '54b61472cfaf1c4a6dd7c2339e1edc29', 103, '删除进货信息');
INSERT INTO `sys_backend_api_table` VALUES ('883243e731a773854f26cbca2a9f3d30', '删除员工', '/employee/*', 'DELETE', '14077b72f8f98047de7f33661ec68ba6', 203, '删除员工');
INSERT INTO `sys_backend_api_table` VALUES ('90abedefaf821256fc042def2739a7df', '加载菜单列表', '/menu/findByPage/*/*', 'GET', 'fb5d9b3173dbb1fdf80f8c55f193ed05', 504, '加载菜单列表');
INSERT INTO `sys_backend_api_table` VALUES ('9c8f5f257a1378eceea6c6ae3c0b481b', '根据id查询菜单', '/menu/findById/*', 'GET', 'fb5d9b3173dbb1fdf80f8c55f193ed05', 501, '根据id查询菜单');
INSERT INTO `sys_backend_api_table` VALUES ('9e70d298027fc5a101f40b1cd38d3d41', '前端菜单显示', '/frontendMenu', 'GET', 'ccb6659817cf193adc6bfb4dc17709ec', 901, '前端左侧菜单显示');
INSERT INTO `sys_backend_api_table` VALUES ('9eba7631d9ac91837b00e522c43033a1', '根据id查询分店', '/restaurant/findById/*', 'GET', 'f7e6303037849970d742fed2b3e06a4b', 404, '根据id查询分店');
INSERT INTO `sys_backend_api_table` VALUES ('a287e2dfb6b307ade993a66c29b5e4c1', '上传菜单图片', '/menu/upload', 'POST', 'fb5d9b3173dbb1fdf80f8c55f193ed05', 506, '上传菜单图片');
INSERT INTO `sys_backend_api_table` VALUES ('adb57e99d4a822ea7147eaf30fa5f8ce', '添加商品进货', '/goodsInfo/save', 'POST', '54b61472cfaf1c4a6dd7c2339e1edc29', 104, '添加商品进货');
INSERT INTO `sys_backend_api_table` VALUES ('b1b75830d3b40197f9660b839638bf97', '删除菜单', '/menu/delete/*', 'DELETE', 'fb5d9b3173dbb1fdf80f8c55f193ed05', 505, '删除菜单');
INSERT INTO `sys_backend_api_table` VALUES ('ccb6659817cf193adc6bfb4dc17709ec', '系统管理', 'none', NULL, NULL, 900, NULL);
INSERT INTO `sys_backend_api_table` VALUES ('cd3a85ed7bf285e09744a8aa4b2ee3d8', '取消订单', '/orderMaster/cancel/*', 'PUT', '5bc0bbaebdd7789f1b3393597ca95750', 301, '取消列表页订单');
INSERT INTO `sys_backend_api_table` VALUES ('d009558bfb5809701eb54a58990a19e4', '退货', '/goodsInfo/returnGoods/*', 'PUT', '54b61472cfaf1c4a6dd7c2339e1edc29', 102, '退货');
INSERT INTO `sys_backend_api_table` VALUES ('da947c8dcf657ce12873786a658cb37b', '更新员工', '/employee/update/*', 'PUT', '14077b72f8f98047de7f33661ec68ba6', 204, '更新员工');
INSERT INTO `sys_backend_api_table` VALUES ('dfd4991e387eced01e6be1430d6856e9', '查询单条进货信息', '/goodsInfo/findById/*', 'GET', '54b61472cfaf1c4a6dd7c2339e1edc29', 105, '查询单条进货信息');
INSERT INTO `sys_backend_api_table` VALUES ('f7e6303037849970d742fed2b3e06a4b', '分店管理', 'none', NULL, NULL, 400, '分店管理下所有API');
INSERT INTO `sys_backend_api_table` VALUES ('fb5d9b3173dbb1fdf80f8c55f193ed05', '菜单管理', 'none', NULL, NULL, 500, '菜单管理下所有API');
COMMIT;

-- ----------------------------
-- Table structure for sys_frontend_menu_table
-- ----------------------------
DROP TABLE IF EXISTS `sys_frontend_menu_table`;
CREATE TABLE `sys_frontend_menu_table` (
  `frontend_menu_id` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '主键',
  `frontend_menu_name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '前端菜单名称',
  `frontend_menu_url` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '前端菜单访问HTML地址',
  `pid` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '父ID',
  `frontend_menu_sort` int NOT NULL COMMENT '排序',
  `description` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`frontend_menu_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='系统前端菜单表';

-- ----------------------------
-- Records of sys_frontend_menu_table
-- ----------------------------
BEGIN;
INSERT INTO `sys_frontend_menu_table` VALUES ('00ce4b154f38d7fadfaf93d6ab41f4ae', '菜单管理', NULL, NULL, 500, NULL);
INSERT INTO `sys_frontend_menu_table` VALUES ('0469284462711f1d6a42605862338a79', '消费记录管理', NULL, NULL, 600, NULL);
INSERT INTO `sys_frontend_menu_table` VALUES ('0af385f5e237445d369a49cb35b20da4', '系统管理', NULL, NULL, 900, NULL);
INSERT INTO `sys_frontend_menu_table` VALUES ('16a23f0c6823260c5982fa3e34b51046', '订餐列表', 'order/index.html', '4034cc72276712d93283de22e03fb47c', 302, '订餐列表页面');
INSERT INTO `sys_frontend_menu_table` VALUES ('1e98994f2c4ba700f1f39bc1a6cb0e7c', '进货信息', 'goods/purchaseInfo.html', '1f85b73188c3ff5b618263db39e0e4bc', 101, '进货信息');
INSERT INTO `sys_frontend_menu_table` VALUES ('1f85b73188c3ff5b618263db39e0e4bc', '进货管理', NULL, NULL, 100, '');
INSERT INTO `sys_frontend_menu_table` VALUES ('4034cc72276712d93283de22e03fb47c', '订餐管理', '', NULL, 300, '');
INSERT INTO `sys_frontend_menu_table` VALUES ('40ca076892e16ef6f788eb4d753df964', '用户管理', 'sys/user.html', '0af385f5e237445d369a49cb35b20da4', 902, '角色管理页面');
INSERT INTO `sys_frontend_menu_table` VALUES ('41b981204487760522e86af417f57944', '人员管理', '', NULL, 200, '');
INSERT INTO `sys_frontend_menu_table` VALUES ('4aacfd60ac7ae4a10f6cde3378c6c44b', '分店管理', 'restaurant/index.html', '7deb84425da23d813eb8ad1f7ed168ed', 401, '分店管理页面');
INSERT INTO `sys_frontend_menu_table` VALUES ('5769a1e50d6338ea33ae061a164e3797', '人员管理', 'person/index.html', '41b981204487760522e86af417f57944', 201, '人员查询、录入管理');
INSERT INTO `sys_frontend_menu_table` VALUES ('58dbbeff45e309e8d08e16b9fbc95402', '菜单管理', 'menu/index.html', '00ce4b154f38d7fadfaf93d6ab41f4ae', 501, '餐馆菜单管理页面');
INSERT INTO `sys_frontend_menu_table` VALUES ('7deb84425da23d813eb8ad1f7ed168ed', '分店管理', NULL, NULL, 400, '');
INSERT INTO `sys_frontend_menu_table` VALUES ('80c23202f9d72076359518ef33854a4f', '角色-菜单分配', 'sys/rolemenu.html', '0af385f5e237445d369a49cb35b20da4', 906, '角色-菜单分配');
INSERT INTO `sys_frontend_menu_table` VALUES ('ab9fdc8116dab6c8d110aa4387c97e08', '角色-API分配', 'sys/roleapi.html', '0af385f5e237445d369a49cb35b20da4', 907, '角色-API分配');
INSERT INTO `sys_frontend_menu_table` VALUES ('b973d15c229778a6d98e742d096b2e41', '角色管理', 'sys/role.html', '0af385f5e237445d369a49cb35b20da4', 901, '角色管理页面');
INSERT INTO `sys_frontend_menu_table` VALUES ('c16fffe904f8de760ac028184e07e0d4', '查看消费记录', 'record/index.html', '0469284462711f1d6a42605862338a79', 601, '消费记录管理页面');
INSERT INTO `sys_frontend_menu_table` VALUES ('cfef08ef7cb5410b8605f3919faefb79', '注册管理', 'register/index.html', 'e1af24beb1838e8bd34a63da47fcf8a4', 701, '注册管理页面');
INSERT INTO `sys_frontend_menu_table` VALUES ('e1af24beb1838e8bd34a63da47fcf8a4', '注册管理', NULL, NULL, 700, '');
INSERT INTO `sys_frontend_menu_table` VALUES ('e1fc2013f32ece3c772becb9489296e4', '后端API管理', 'sys/api.html', '0af385f5e237445d369a49cb35b20da4', 904, '后端API管理页面');
INSERT INTO `sys_frontend_menu_table` VALUES ('e529e97e6ab0f95fc85cfbda5247eeaa', '前端菜单管理', 'sys/menu.html', '0af385f5e237445d369a49cb35b20da4', 903, NULL);
INSERT INTO `sys_frontend_menu_table` VALUES ('eb70ecd66ed156ca2f49e4d0e32b36f6', '角色-用户分配', 'sys/roleuser.html', '0af385f5e237445d369a49cb35b20da4', 905, '角色用户分配');
INSERT INTO `sys_frontend_menu_table` VALUES ('ef0946803dde76e04553e46ce8a4e255', '订餐二维码', 'order/qrcode.html', '4034cc72276712d93283de22e03fb47c', 301, '订餐二维码页面');
INSERT INTO `sys_frontend_menu_table` VALUES ('f19e5fb44bd470d477f9203de4c2b9a2', '退货信息', 'goods/refundInfo.html', '1f85b73188c3ff5b618263db39e0e4bc', 102, '退货信息');
COMMIT;

-- ----------------------------
-- Table structure for sys_role_backend_api_table
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_backend_api_table`;
CREATE TABLE `sys_role_backend_api_table` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色ID',
  `backend_api_id` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'API管理表ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=798 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='角色后端api表';

-- ----------------------------
-- Records of sys_role_backend_api_table
-- ----------------------------
BEGIN;
INSERT INTO `sys_role_backend_api_table` VALUES (34, '1', '1');
INSERT INTO `sys_role_backend_api_table` VALUES (389, '2f412c59e5077e0cd53d21fac3eee402', '3930e1a901ec0cb2e11257059fd5fbea');
INSERT INTO `sys_role_backend_api_table` VALUES (390, '2f412c59e5077e0cd53d21fac3eee402', '5d2ab0a92b82007ce55725decee4aacd');
INSERT INTO `sys_role_backend_api_table` VALUES (391, '2f412c59e5077e0cd53d21fac3eee402', '53168b1b8482682775501c86c4258fcb');
INSERT INTO `sys_role_backend_api_table` VALUES (392, '2f412c59e5077e0cd53d21fac3eee402', 'fb5d9b3173dbb1fdf80f8c55f193ed05');
INSERT INTO `sys_role_backend_api_table` VALUES (393, '2f412c59e5077e0cd53d21fac3eee402', '52764465ca7193af3a6921db4b5b9f2c');
INSERT INTO `sys_role_backend_api_table` VALUES (394, '2f412c59e5077e0cd53d21fac3eee402', '21505846f270ad33fa69a8c181ce6f9b');
INSERT INTO `sys_role_backend_api_table` VALUES (395, '2f412c59e5077e0cd53d21fac3eee402', '1ed92fc53b45795f4b9f4065ce6bbec8');
INSERT INTO `sys_role_backend_api_table` VALUES (396, '2f412c59e5077e0cd53d21fac3eee402', '69b1b8c12c9f6c58e966198a60baa254');
INSERT INTO `sys_role_backend_api_table` VALUES (397, '2f412c59e5077e0cd53d21fac3eee402', '54b61472cfaf1c4a6dd7c2339e1edc29');
INSERT INTO `sys_role_backend_api_table` VALUES (398, '2f412c59e5077e0cd53d21fac3eee402', '5bc0bbaebdd7789f1b3393597ca95750');
INSERT INTO `sys_role_backend_api_table` VALUES (399, '2f412c59e5077e0cd53d21fac3eee402', '90abedefaf821256fc042def2739a7df');
INSERT INTO `sys_role_backend_api_table` VALUES (770, '104c2ebb1e32995f384ad49f6d4b421d', '47edfb154ccce3d6c73381642b1d0fee');
INSERT INTO `sys_role_backend_api_table` VALUES (771, '104c2ebb1e32995f384ad49f6d4b421d', '69b1b8c12c9f6c58e966198a60baa254');
INSERT INTO `sys_role_backend_api_table` VALUES (772, '104c2ebb1e32995f384ad49f6d4b421d', '52764465ca7193af3a6921db4b5b9f2c');
INSERT INTO `sys_role_backend_api_table` VALUES (773, '104c2ebb1e32995f384ad49f6d4b421d', '862190eb71ac59e3f0a19164ca0162e4');
INSERT INTO `sys_role_backend_api_table` VALUES (774, '104c2ebb1e32995f384ad49f6d4b421d', 'adb57e99d4a822ea7147eaf30fa5f8ce');
INSERT INTO `sys_role_backend_api_table` VALUES (775, '104c2ebb1e32995f384ad49f6d4b421d', '54b61472cfaf1c4a6dd7c2339e1edc29');
INSERT INTO `sys_role_backend_api_table` VALUES (776, '104c2ebb1e32995f384ad49f6d4b421d', 'fb5d9b3173dbb1fdf80f8c55f193ed05');
INSERT INTO `sys_role_backend_api_table` VALUES (777, '104c2ebb1e32995f384ad49f6d4b421d', 'da947c8dcf657ce12873786a658cb37b');
INSERT INTO `sys_role_backend_api_table` VALUES (778, '104c2ebb1e32995f384ad49f6d4b421d', 'b1b75830d3b40197f9660b839638bf97');
INSERT INTO `sys_role_backend_api_table` VALUES (779, '104c2ebb1e32995f384ad49f6d4b421d', '5d2ab0a92b82007ce55725decee4aacd');
INSERT INTO `sys_role_backend_api_table` VALUES (780, '104c2ebb1e32995f384ad49f6d4b421d', 'dfd4991e387eced01e6be1430d6856e9');
INSERT INTO `sys_role_backend_api_table` VALUES (781, '104c2ebb1e32995f384ad49f6d4b421d', '9c8f5f257a1378eceea6c6ae3c0b481b');
INSERT INTO `sys_role_backend_api_table` VALUES (782, '104c2ebb1e32995f384ad49f6d4b421d', '1ed92fc53b45795f4b9f4065ce6bbec8');
INSERT INTO `sys_role_backend_api_table` VALUES (783, '104c2ebb1e32995f384ad49f6d4b421d', '21505846f270ad33fa69a8c181ce6f9b');
INSERT INTO `sys_role_backend_api_table` VALUES (784, '104c2ebb1e32995f384ad49f6d4b421d', 'a287e2dfb6b307ade993a66c29b5e4c1');
INSERT INTO `sys_role_backend_api_table` VALUES (785, '104c2ebb1e32995f384ad49f6d4b421d', '0ad6d11f5f18d263d032a14dd8d5ee6d');
INSERT INTO `sys_role_backend_api_table` VALUES (786, '104c2ebb1e32995f384ad49f6d4b421d', '5d40badde0317afec766a20cd10611ea');
INSERT INTO `sys_role_backend_api_table` VALUES (787, '104c2ebb1e32995f384ad49f6d4b421d', '4c8b3924d0f1cadc6bc697b4f1d56468');
INSERT INTO `sys_role_backend_api_table` VALUES (788, '104c2ebb1e32995f384ad49f6d4b421d', '5bc0bbaebdd7789f1b3393597ca95750');
INSERT INTO `sys_role_backend_api_table` VALUES (789, '104c2ebb1e32995f384ad49f6d4b421d', '53168b1b8482682775501c86c4258fcb');
INSERT INTO `sys_role_backend_api_table` VALUES (790, '104c2ebb1e32995f384ad49f6d4b421d', 'd009558bfb5809701eb54a58990a19e4');
INSERT INTO `sys_role_backend_api_table` VALUES (791, '104c2ebb1e32995f384ad49f6d4b421d', '032b6fb177fa888c96d590d38411387d');
INSERT INTO `sys_role_backend_api_table` VALUES (792, '104c2ebb1e32995f384ad49f6d4b421d', 'cd3a85ed7bf285e09744a8aa4b2ee3d8');
INSERT INTO `sys_role_backend_api_table` VALUES (793, '104c2ebb1e32995f384ad49f6d4b421d', '90abedefaf821256fc042def2739a7df');
INSERT INTO `sys_role_backend_api_table` VALUES (794, '104c2ebb1e32995f384ad49f6d4b421d', '14077b72f8f98047de7f33661ec68ba6');
INSERT INTO `sys_role_backend_api_table` VALUES (795, '104c2ebb1e32995f384ad49f6d4b421d', '3930e1a901ec0cb2e11257059fd5fbea');
INSERT INTO `sys_role_backend_api_table` VALUES (796, '104c2ebb1e32995f384ad49f6d4b421d', '8286e6f4986233ecceb7c9eaeffdcaa6');
INSERT INTO `sys_role_backend_api_table` VALUES (797, '104c2ebb1e32995f384ad49f6d4b421d', '82f06ed9d288e7e298556ccb199ac2de');
COMMIT;

-- ----------------------------
-- Table structure for sys_role_frontend_menu_table
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_frontend_menu_table`;
CREATE TABLE `sys_role_frontend_menu_table` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色ID',
  `frontend_menu_id` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '前端菜单管理ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=366 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='角色前端菜单表';

-- ----------------------------
-- Records of sys_role_frontend_menu_table
-- ----------------------------
BEGIN;
INSERT INTO `sys_role_frontend_menu_table` VALUES (282, '2f412c59e5077e0cd53d21fac3eee402', '4034cc72276712d93283de22e03fb47c');
INSERT INTO `sys_role_frontend_menu_table` VALUES (283, '2f412c59e5077e0cd53d21fac3eee402', '1f85b73188c3ff5b618263db39e0e4bc');
INSERT INTO `sys_role_frontend_menu_table` VALUES (284, '2f412c59e5077e0cd53d21fac3eee402', '00ce4b154f38d7fadfaf93d6ab41f4ae');
INSERT INTO `sys_role_frontend_menu_table` VALUES (285, '2f412c59e5077e0cd53d21fac3eee402', '16a23f0c6823260c5982fa3e34b51046');
INSERT INTO `sys_role_frontend_menu_table` VALUES (286, '2f412c59e5077e0cd53d21fac3eee402', '1e98994f2c4ba700f1f39bc1a6cb0e7c');
INSERT INTO `sys_role_frontend_menu_table` VALUES (287, '2f412c59e5077e0cd53d21fac3eee402', 'f19e5fb44bd470d477f9203de4c2b9a2');
INSERT INTO `sys_role_frontend_menu_table` VALUES (288, '2f412c59e5077e0cd53d21fac3eee402', 'c16fffe904f8de760ac028184e07e0d4');
INSERT INTO `sys_role_frontend_menu_table` VALUES (289, '2f412c59e5077e0cd53d21fac3eee402', '58dbbeff45e309e8d08e16b9fbc95402');
INSERT INTO `sys_role_frontend_menu_table` VALUES (290, '2f412c59e5077e0cd53d21fac3eee402', '0469284462711f1d6a42605862338a79');
INSERT INTO `sys_role_frontend_menu_table` VALUES (322, '1', 'f19e5fb44bd470d477f9203de4c2b9a2');
INSERT INTO `sys_role_frontend_menu_table` VALUES (323, '1', 'eb70ecd66ed156ca2f49e4d0e32b36f6');
INSERT INTO `sys_role_frontend_menu_table` VALUES (324, '1', 'eb70ecd66ed156ca2f49e4d0e32b36f6');
INSERT INTO `sys_role_frontend_menu_table` VALUES (325, '1', 'cfef08ef7cb5410b8605f3919faefb79');
INSERT INTO `sys_role_frontend_menu_table` VALUES (326, '1', '80c23202f9d72076359518ef33854a4f');
INSERT INTO `sys_role_frontend_menu_table` VALUES (327, '1', '1e98994f2c4ba700f1f39bc1a6cb0e7c');
INSERT INTO `sys_role_frontend_menu_table` VALUES (328, '1', 'e529e97e6ab0f95fc85cfbda5247eeaa');
INSERT INTO `sys_role_frontend_menu_table` VALUES (329, '1', '41b981204487760522e86af417f57944');
INSERT INTO `sys_role_frontend_menu_table` VALUES (330, '1', '4034cc72276712d93283de22e03fb47c');
INSERT INTO `sys_role_frontend_menu_table` VALUES (331, '1', '0af385f5e237445d369a49cb35b20da4');
INSERT INTO `sys_role_frontend_menu_table` VALUES (332, '1', '41b981204487760522e86af417f57944');
INSERT INTO `sys_role_frontend_menu_table` VALUES (333, '1', '00ce4b154f38d7fadfaf93d6ab41f4ae');
INSERT INTO `sys_role_frontend_menu_table` VALUES (334, '1', '4aacfd60ac7ae4a10f6cde3378c6c44b');
INSERT INTO `sys_role_frontend_menu_table` VALUES (335, '1', 'ab9fdc8116dab6c8d110aa4387c97e08');
INSERT INTO `sys_role_frontend_menu_table` VALUES (336, '1', '0af385f5e237445d369a49cb35b20da4');
INSERT INTO `sys_role_frontend_menu_table` VALUES (337, '1', 'e1fc2013f32ece3c772becb9489296e4');
INSERT INTO `sys_role_frontend_menu_table` VALUES (338, '1', '0469284462711f1d6a42605862338a79');
INSERT INTO `sys_role_frontend_menu_table` VALUES (339, '1', '40ca076892e16ef6f788eb4d753df964');
INSERT INTO `sys_role_frontend_menu_table` VALUES (340, '1', 'ab9fdc8116dab6c8d110aa4387c97e08');
INSERT INTO `sys_role_frontend_menu_table` VALUES (341, '1', '16a23f0c6823260c5982fa3e34b51046');
INSERT INTO `sys_role_frontend_menu_table` VALUES (342, '1', 'b973d15c229778a6d98e742d096b2e41');
INSERT INTO `sys_role_frontend_menu_table` VALUES (343, '1', 'e1af24beb1838e8bd34a63da47fcf8a4');
INSERT INTO `sys_role_frontend_menu_table` VALUES (344, '1', '7deb84425da23d813eb8ad1f7ed168ed');
INSERT INTO `sys_role_frontend_menu_table` VALUES (345, '1', '58dbbeff45e309e8d08e16b9fbc95402');
INSERT INTO `sys_role_frontend_menu_table` VALUES (346, '1', '1f85b73188c3ff5b618263db39e0e4bc');
INSERT INTO `sys_role_frontend_menu_table` VALUES (347, '1', 'b973d15c229778a6d98e742d096b2e41');
INSERT INTO `sys_role_frontend_menu_table` VALUES (348, '1', 'e1fc2013f32ece3c772becb9489296e4');
INSERT INTO `sys_role_frontend_menu_table` VALUES (349, '1', '5769a1e50d6338ea33ae061a164e3797');
INSERT INTO `sys_role_frontend_menu_table` VALUES (350, '1', 'ef0946803dde76e04553e46ce8a4e255');
INSERT INTO `sys_role_frontend_menu_table` VALUES (351, '1', 'c16fffe904f8de760ac028184e07e0d4');
INSERT INTO `sys_role_frontend_menu_table` VALUES (352, '1', 'e529e97e6ab0f95fc85cfbda5247eeaa');
INSERT INTO `sys_role_frontend_menu_table` VALUES (353, '1', '40ca076892e16ef6f788eb4d753df964');
INSERT INTO `sys_role_frontend_menu_table` VALUES (354, '104c2ebb1e32995f384ad49f6d4b421d', 'f19e5fb44bd470d477f9203de4c2b9a2');
INSERT INTO `sys_role_frontend_menu_table` VALUES (355, '104c2ebb1e32995f384ad49f6d4b421d', '58dbbeff45e309e8d08e16b9fbc95402');
INSERT INTO `sys_role_frontend_menu_table` VALUES (356, '104c2ebb1e32995f384ad49f6d4b421d', '1f85b73188c3ff5b618263db39e0e4bc');
INSERT INTO `sys_role_frontend_menu_table` VALUES (357, '104c2ebb1e32995f384ad49f6d4b421d', '41b981204487760522e86af417f57944');
INSERT INTO `sys_role_frontend_menu_table` VALUES (358, '104c2ebb1e32995f384ad49f6d4b421d', '4034cc72276712d93283de22e03fb47c');
INSERT INTO `sys_role_frontend_menu_table` VALUES (359, '104c2ebb1e32995f384ad49f6d4b421d', 'ef0946803dde76e04553e46ce8a4e255');
INSERT INTO `sys_role_frontend_menu_table` VALUES (360, '104c2ebb1e32995f384ad49f6d4b421d', '16a23f0c6823260c5982fa3e34b51046');
INSERT INTO `sys_role_frontend_menu_table` VALUES (361, '104c2ebb1e32995f384ad49f6d4b421d', 'c16fffe904f8de760ac028184e07e0d4');
INSERT INTO `sys_role_frontend_menu_table` VALUES (362, '104c2ebb1e32995f384ad49f6d4b421d', '1e98994f2c4ba700f1f39bc1a6cb0e7c');
INSERT INTO `sys_role_frontend_menu_table` VALUES (363, '104c2ebb1e32995f384ad49f6d4b421d', '00ce4b154f38d7fadfaf93d6ab41f4ae');
INSERT INTO `sys_role_frontend_menu_table` VALUES (364, '104c2ebb1e32995f384ad49f6d4b421d', '5769a1e50d6338ea33ae061a164e3797');
INSERT INTO `sys_role_frontend_menu_table` VALUES (365, '104c2ebb1e32995f384ad49f6d4b421d', '0469284462711f1d6a42605862338a79');
COMMIT;

-- ----------------------------
-- Table structure for sys_role_table
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_table`;
CREATE TABLE `sys_role_table` (
  `role_id` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `role_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色ID',
  `description` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`role_id`) USING BTREE,
  UNIQUE KEY `sys_role_table_pk` (`role_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='角色表';

-- ----------------------------
-- Records of sys_role_table
-- ----------------------------
BEGIN;
INSERT INTO `sys_role_table` VALUES ('1', 'ROLE_ADMIN', '管理员');
INSERT INTO `sys_role_table` VALUES ('104c2ebb1e32995f384ad49f6d4b421d', 'ROLE_店长', '店长');
INSERT INTO `sys_role_table` VALUES ('2f412c59e5077e0cd53d21fac3eee402', 'ROLE_店员', '店员');
COMMIT;

-- ----------------------------
-- Table structure for sys_role_user_table
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_user_table`;
CREATE TABLE `sys_role_user_table` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色ID',
  `user_id` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='角色用户表';

-- ----------------------------
-- Records of sys_role_user_table
-- ----------------------------
BEGIN;
INSERT INTO `sys_role_user_table` VALUES (49, '1', 'bcad19f214499feab47f15b18ae9bc88');
INSERT INTO `sys_role_user_table` VALUES (52, '2f412c59e5077e0cd53d21fac3eee402', 'b0b4c302687e1c29409ebb688298b667');
INSERT INTO `sys_role_user_table` VALUES (53, '104c2ebb1e32995f384ad49f6d4b421d', 'd01c54801e8155223f3a6656056fa2dd');
COMMIT;

-- ----------------------------
-- Table structure for sys_user_table
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_table`;
CREATE TABLE `sys_user_table` (
  `user_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `user_name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名称',
  `pass_word` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码-BCR算法加密',
  `description` varchar(800) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '描述',
  `state` int DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='系统用户表';

-- ----------------------------
-- Records of sys_user_table
-- ----------------------------
BEGIN;
INSERT INTO `sys_user_table` VALUES ('b0b4c302687e1c29409ebb688298b667', '李四', '$2a$10$A2VqsKYA7wIZlMjpsXM.jOEAujhTPWr2Jzx27SKaXbMy1HvcMH0Ku', '店员', 1);
INSERT INTO `sys_user_table` VALUES ('bcad19f214499feab47f15b18ae9bc88', 'admin', '$2a$10$orFz7joKE617neozH1YF0u7mF0zifZmIUiit/SvzvgftBuWAoTRoa', '管理员', 1);
INSERT INTO `sys_user_table` VALUES ('d01c54801e8155223f3a6656056fa2dd', '张三', '$2a$10$I6D7a1xPGiAISZROHWoIo.zQrzDZH2MrvAPSsJado5oB5d4aejnma', '店长', 1);
COMMIT;

-- ----------------------------
-- Procedure structure for callback
-- ----------------------------
DROP PROCEDURE IF EXISTS `callback`;
delimiter ;;
CREATE PROCEDURE `callback`()
begin
   declare num int;
   set num = 1;
   LOOP_LABLE :
   loop
 		set num = num + 1;
 		INSERT INTO `employee` VALUES (NULL, concat("员工",num, "号"), concat("emp",num), '0', '18', '员工', concat("1831432178",num), '3000', '0', '0');
     if num >= 20
     then leave LOOP_LABLE;
     end if;
   end loop;
 end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for goodsProceduce
-- ----------------------------
DROP PROCEDURE IF EXISTS `goodsProceduce`;
delimiter ;;
CREATE PROCEDURE `goodsProceduce`()
begin
  declare num int;
  set num = 1;
  LOOP_LABLE :
  loop
		INSERT INTO `goods` VALUES (NULL, "大白菜", num, "这是一棵大白菜", 1);
		set num = num + 1;
    if num >= 21
    then leave LOOP_LABLE;
    end if;
  end loop;
end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for insert_restaurant
-- ----------------------------
DROP PROCEDURE IF EXISTS `insert_restaurant`;
delimiter ;;
CREATE PROCEDURE `insert_restaurant`()
begin
  declare num int;
  set num = 10;
  LOOP_LABLE :
  loop
		set num = num + 1;
		INSERT INTO `restaurant` VALUES (NULL, concat("分店",num), concat("020-123456",num), '广州市太平镇广州大学华软软件学院', concat("2020-12-",num), 0);
    if num >= 20
    then leave LOOP_LABLE;
    end if;
  end loop;
end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for register_user
-- ----------------------------
DROP PROCEDURE IF EXISTS `register_user`;
delimiter ;;
CREATE PROCEDURE `register_user`()
begin
  declare num int;
  set num = 1;
  LOOP_LABLE :
  loop
		set num = num + 1;
		INSERT INTO `register_user` VALUES (NULL, concat("用户00",num-1), concat("头像",num-1), '0', '532767248@qq.com', "18314321781", NULL, NULL);
    if num >= 20
    then leave LOOP_LABLE;
    end if;
  end loop;
end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for supplierProceduce
-- ----------------------------
DROP PROCEDURE IF EXISTS `supplierProceduce`;
delimiter ;;
CREATE PROCEDURE `supplierProceduce`()
begin
  declare num int;
  set num = 1;
  LOOP_LABLE :
  loop
		INSERT INTO `supplier` VALUES (NULL, "广州xx食品有限公司", concat("广州市xx区"), concat("张三",num), concat("020-8989999",num), concat("53276724",num, "@qq.com"), 1, '0');
		set num = num + 1;
    if num >= 21
    then leave LOOP_LABLE;
    end if;
  end loop;
end
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
