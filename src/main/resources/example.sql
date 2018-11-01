/*
 Navicat MySQL Data Transfer

 Source Server         : LARK-COUPON
 Source Server Type    : MySQL
 Source Server Version : 50629
 Source Host           : tddl.daily.alibaba.net:3306
 Source Schema         : LARK_COUPON_APP

 Target Server Type    : MySQL
 Target Server Version : 50629
 File Encoding         : 65001

 Date: 01/11/2018 10:08:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for coupon_coupon_batch
-- ----------------------------
DROP TABLE IF EXISTS `coupon_coupon_batch`;
CREATE TABLE `coupon_coupon_batch` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '批次编码',
  `template_code` bigint(20) NOT NULL COMMENT '券模板编码',
  `template_type` int(4) DEFAULT NULL COMMENT '券类型(1,代金券，2.兑换券，3.折扣券)',
  `product_type` int(4) DEFAULT NULL COMMENT '商品类型(1.卖品。2.电影票)',
  `check_count` int(11) DEFAULT NULL COMMENT '已核销数量',
  `send_count` bigint(20) DEFAULT NULL COMMENT '已发送数量',
  `price` bigint(20) NOT NULL COMMENT '券批次面值',
  `batch_count` int(11) NOT NULL COMMENT '数量',
  `direct_type` int(11) NOT NULL DEFAULT '1' COMMENT '流向类型(1,系统设定，2.手动发券)',
  `direct_to` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '流向',
  `state` int(11) NOT NULL COMMENT '券批次状态状态(1.新建，2.生效，3.过期，4.作废 5.审核中 6.已发放 7.已驳回)',
  `audit_state` int(11) NOT NULL COMMENT '券批次审核状态(1.未提交，2.待审核，3.审核通过，4.驳回)',
  `start_time` datetime NOT NULL COMMENT '有效开始时间',
  `end_time` datetime NOT NULL COMMENT '结束时间',
  `create_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '创建人',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `modify_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '修改人',
  `gmt_modify` datetime DEFAULT NULL COMMENT '修改时间',
  `audit_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '审核人',
  `gmt_audit` datetime DEFAULT NULL COMMENT '审核时间',
  `extension` varchar(2000) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '扩展字段',
  `reason` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '驳回原因',
  `lease_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '租户信息',
  `base_price` int(11) DEFAULT NULL COMMENT '批次结算价',
  `issuer` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '批次发行方',
  `remark` varchar(1000) DEFAULT NULL COMMENT '备注',
  `start_serialno` varchar(20) DEFAULT NULL COMMENT '外部券开始号',
  `end_serialno` varchar(20) DEFAULT NULL COMMENT '外部券结束号',
  `voucher_no_type` varchar(10) NOT NULL DEFAULT '1' COMMENT '外部券号生成方式 1-自动生成 2-外部指定',
  `active_time` datetime DEFAULT '1900-01-01 00:00:00' COMMENT '激活时间\n',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=218120180132614 DEFAULT CHARSET=utf8 COMMENT='券批次表';

SET FOREIGN_KEY_CHECKS = 1;
