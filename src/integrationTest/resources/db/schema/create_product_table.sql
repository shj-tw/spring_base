CREATE TABLE IF NOT EXISTS product
(
    id                   VARCHAR(32)    PRIMARY KEY,
    name                 VARCHAR(255)   NOT NULL,
    price                VARCHAR(32),
    status               VARCHAR(32)    NOT NULL,
    created_time         TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_time         TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);