CREATE TABLE IF NOT EXISTS `product`
(
  `id`                   VARCHAR(32),
  `name`                 VARCHAR(255)   NOT NULL,
  `price`                VARCHAR(32),
  `status`               VARCHAR(32)    NOT NULL,
  `created_time`         TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_time`         TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY(`id`)
USING BTREE
)ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

INSERT INTO product values ('1','product-1','10','VALID', '2023-08-09 21:31:14','2022-08-09 21:31:14'),
                           ('2','product-2',null,'VALID','2022-08-09 21:31:14','2022-08-09 21:31:14'),
                           ('3','product-3','10','INVALID', '2022-08-09 21:31:14','2022-08-09 21:31:14');