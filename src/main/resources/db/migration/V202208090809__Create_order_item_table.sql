CREATE TABLE IF NOT EXISTS `order_item`
(
  `id`                       VARCHAR(32)    NOT NULL COMMENT '主键',
  `product_id`                   VARCHAR(32)    NOT NULL,
  `order_id`                   VARCHAR(32)    NOT NULL,
  `quantity`                 INT    COMMENT '数量',
  `create_time`          TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time`          TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY(`id`)
USING BTREE
)ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;