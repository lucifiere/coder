-- 商家当日累计曝光
CREATE TABLE IF NOT EXISTS rt_app_wm_mv_poi_expose
(
 wm_poi_id         int        comment '门店id',
 dt                int        comment 'yyyyMMdd',
 exp_num           int        comment '曝光次数',
 exp_cnt           int        comment '曝光人数',
 buss_exp_num      int        comment '商圈曝光次数',
 buss_exp_cnt      int        comment '商圈曝光人数',
 buss_top_exp_num  int        comment '商圈top10曝光次数',
 buss_top_exp_cnt  int        comment '商圈top10曝光人数'
)
UNIQUE KEY(wm_poi_id,dt)
PARTITION BY RANGE(dt)
(
PARTITION p20200616 VALUES LESS THAN ("20200616"),
PARTITION p20200617 VALUES LESS THAN ("20200617")
)
DISTRIBUTED BY HASH(wm_poi_id) BUCKETS 32
;
-- 商家分时曝光
CREATE TABLE IF NOT EXISTS rt_app_wm_mv_poi_expose_hour
(
 wm_poi_id         int        comment '门店id',
 hour              int        comment '小时',
 dt                int        comment 'yyyyMMdd',
 exp_num           int        comment '曝光次数',
 exp_cnt           int        comment '曝光人数',
 buss_exp_num      int        comment '商圈曝光次数',
 buss_exp_cnt      int        comment '商圈曝光人数',
 buss_top_exp_num  int        comment '商圈top10曝光次数',
 buss_top_exp_cnt  int        comment '商圈top10曝光人数'
)
UNIQUE KEY(wm_poi_id,hour,dt)
PARTITION BY RANGE(dt)
(
PARTITION p20200616 VALUES LESS THAN ("20200616"),
PARTITION p20200617 VALUES LESS THAN ("20200617")
)
DISTRIBUTED BY HASH(wm_poi_id) BUCKETS 32
;

-- 商家当日累计点击
CREATE TABLE IF NOT EXISTS rt_app_wm_mv_poi_click
(
 wm_poi_id           int        comment '门店id',
 dt                  int        comment 'yyyyMMdd',
 click_num           int        comment '点击次数',
 click_cnt           int        comment '点击人数',
 buss_click_num      int        comment '商圈点击次数',
 buss_click_cnt      int        comment '商圈点击人数',
 buss_top_click_num  int        comment '商圈top10点击次数',
 buss_top_click_cnt  int        comment '商圈top10点击人数'
)
UNIQUE KEY(wm_poi_id,dt)
PARTITION BY RANGE(dt)
(
PARTITION p20200616 VALUES LESS THAN ("20200616"),
PARTITION p20200617 VALUES LESS THAN ("20200617")
)
DISTRIBUTED BY HASH(wm_poi_id) BUCKETS 32
;
-- 商家分时点击
CREATE TABLE IF NOT EXISTS rt_app_wm_mv_poi_click_hour
(
 wm_poi_id           int        comment '门店id',
 hour                int        comment '小时',
 dt                  int        comment 'yyyyMMdd',
 click_num           int        comment '点击次数',
 click_cnt           int        comment '点击人数',
 buss_click_num      int        comment '商圈点击次数',
 buss_click_cnt      int        comment '商圈点击人数',
 buss_top_click_num  int        comment '商圈top10点击次数',
 buss_top_click_cnt  int        comment '商圈top10点击人数'
)
UNIQUE KEY(wm_poi_id,hour,dt)
PARTITION BY RANGE(dt)
(
PARTITION p20200616 VALUES LESS THAN ("20200616"),
PARTITION p20200617 VALUES LESS THAN ("20200617")
)
DISTRIBUTED BY HASH(wm_poi_id) BUCKETS 32
;