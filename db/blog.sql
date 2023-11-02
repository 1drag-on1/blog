/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80033
 Source Host           : localhost:3306
 Source Schema         : blog

 Target Server Type    : MySQL
 Target Server Version : 80033
 File Encoding         : 65001

 Date: 02/11/2023 23:10:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for about
-- ----------------------------
DROP TABLE IF EXISTS `about`;
CREATE TABLE `about`  (
  `id` int NOT NULL,
  `name_en` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '名称（英文）',
  `name_ch` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '名称（中文）',
  `value` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '值',
  `deleted` int NULL DEFAULT NULL COMMENT '软删除（0：正常 1：删除）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '关于表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of about
-- ----------------------------

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '文章标题',
  `context` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '文章内容',
  `likes` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '文章点赞数（是否是热门文章）',
  `state` tinyint NULL DEFAULT NULL COMMENT '公开或私密',
  `recommend` tinyint NULL DEFAULT NULL COMMENT '推荐开关',
  `appreciation` tinyint NULL DEFAULT NULL COMMENT '赞赏开关',
  `comment_enabled` tinyint NULL DEFAULT NULL COMMENT '评论开关',
  `top` tinyint NULL DEFAULT NULL COMMENT '是否置顶',
  `views` int NULL DEFAULT NULL COMMENT '浏览次数',
  `words` int NULL DEFAULT NULL COMMENT '文章字数',
  `read_time` int NULL DEFAULT NULL COMMENT '阅读时长（分钟）',
  `password` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '密码保护',
  `user_id` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '文章作者',
  `category` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '文章分类',
  `description` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '描述',
  `first_picture` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '文章首图，用于随机文章展示',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` int NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间（最后一次）',
  `deleted` int NULL DEFAULT NULL COMMENT '软删除（0：正常 1：删除）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of article
-- ----------------------------

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int NOT NULL,
  `nick_name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `email` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `content` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '评论内容',
  `avatar` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '头像(图片路径)',
  `ip` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '评论者ip地址',
  `published` tinyint NULL DEFAULT NULL COMMENT '公开或回收站',
  `admin_comment` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '博主回复',
  `page` int NULL DEFAULT NULL COMMENT '0普通文章，1关于我页面，2友链页面',
  `notice` tinyint NULL DEFAULT NULL COMMENT '接收邮件提醒',
  `article_id` int NULL DEFAULT NULL COMMENT '所在文章id',
  `parent_comment_id` int NULL DEFAULT NULL COMMENT '父评论id，-1为根评论',
  `website` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '个人网站',
  `qq` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '如果评论昵称为QQ号，则将昵称和头像置为QQ昵称和QQ头像，并将此字段置为QQ号备份',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `deleted` int NULL DEFAULT NULL COMMENT '软删除（0：正常 1：删除）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '评论表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for moment
-- ----------------------------
DROP TABLE IF EXISTS `moment`;
CREATE TABLE `moment`  (
  `id` int NOT NULL,
  `content` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '动态内容',
  `likes` int NULL DEFAULT NULL COMMENT '点赞数',
  `published` tinyint NULL DEFAULT NULL COMMENT '是否公开',
  `deleted` int NULL DEFAULT NULL COMMENT '软删除（0：正常 1：删除）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '动态表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of moment
-- ----------------------------

-- ----------------------------
-- Table structure for sys_per
-- ----------------------------
DROP TABLE IF EXISTS `sys_per`;
CREATE TABLE `sys_per`  (
  `id` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT 'id',
  `userId` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户id',
  `role` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '角色',
  `permissions` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '权限',
  `deleted` tinyint NULL DEFAULT NULL COMMENT '逻辑删除'
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '权限表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_per
-- ----------------------------
INSERT INTO `sys_per` VALUES ('8e25054d3e6157c4632d5860113b4c75', 'c235a0909237d45d1078d574f1c8c534', 'user', '', 0);
INSERT INTO `sys_per` VALUES ('923c91cd18acc327217bedc43865e9cf', '41a4735f7d0528624fe613e0321b63fc', 'admin', '', 0);
INSERT INTO `sys_per` VALUES ('4f49a36d5c03e9e194f15a3bb5c999cd', '9d589c81383d53bac95c48daefac5e4c', '', '0', 0);
INSERT INTO `sys_per` VALUES ('4b750fcac815bb2b886386547f7f81a7', 'c195de4cc2a3a46280556bbd73b52221', '', '0', 0);
INSERT INTO `sys_per` VALUES ('48cf17f6051c5d5f64ecdbe7cefe3690', 'ae99116ae4b4f978d3d44f2eea832b7d', 'user', '0', 0);
INSERT INTO `sys_per` VALUES ('a6de782dc5890bc586c72d7c650c255e', '28ed3b12296630097bf9f477b49f4bd7', 'user', '0', 0);
INSERT INTO `sys_per` VALUES ('02db60ff3ec7fa9fbfcb241157f56bf2', '119cb6e8020797817fbc106d4482daad', 'ddd', '0', 0);
INSERT INTO `sys_per` VALUES ('af8380e4bf0170054b3e4985b9f19bda', 'ae9a439da7f38b0a2185867f47ce6e65', 'eee', '0', 0);
INSERT INTO `sys_per` VALUES ('4edf3d944baa32ed04cacb92716db5a2', '6d0283884a1465535d420ab052d3f622', '2233', '0', 0);
INSERT INTO `sys_per` VALUES ('9d9dc181f97bf0c5092ce3fd3406aa22', '0f70fdffce7042f0e028a0ab158e048c', 'admin', '0', 0);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `username` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '账号',
  `password` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '密码',
  `salt` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT 'md5盐值加密',
  `role` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '角色（1：管理员 2：普通用户）',
  `head_picture` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '头像',
  `email` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `wechat` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '微信',
  `qq` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT 'qq',
  `introduction` varchar(150) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '个人介绍',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` int NULL DEFAULT NULL COMMENT '新建人',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `update_by` int NULL DEFAULT NULL COMMENT '修改人',
  `deleted` tinyint NULL DEFAULT 0 COMMENT '软删除（0：未删 1：已删）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '用户表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_user
-- ----------------------------

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag`  (
  `id` int NOT NULL,
  `tag_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '标签名字',
  `color` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '标签颜色',
  `deleted` int NULL DEFAULT NULL COMMENT '软删除（0：正常 1：删除）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '标签表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tag
-- ----------------------------

-- ----------------------------
-- Table structure for visitor
-- ----------------------------
DROP TABLE IF EXISTS `visitor`;
CREATE TABLE `visitor`  (
  `id` int NOT NULL,
  `uuid` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '访客身份标识码',
  `ip` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT 'ip',
  `ip_source` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT 'ip来源',
  `os` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '操作系统',
  `browser` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '浏览器',
  `pv` int NULL DEFAULT NULL COMMENT '访问页数统计',
  `user_agent` varchar(2000) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT 'user-agent用户代理',
  `last_time` datetime NULL DEFAULT NULL COMMENT '最后访问时间',
  `create_time` datetime NULL DEFAULT NULL COMMENT '首次访问时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '访客表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of visitor
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
