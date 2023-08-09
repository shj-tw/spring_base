CREATE TABLE IF NOT EXISTS customer
(
    id                   VARCHAR(32)    PRIMARY KEY,
    name                 VARCHAR(32)    NOT NULL,
    create_time          TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time          TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);