CREATE TABLE user
(
    id         BIGINT      NOT NULL auto_increment primary key,
    first_name VARCHAR(10) NOT NULL,
    last_name  VARCHAR(10) NOT NULL,
    email      VARCHAR(50) NOT NULL,
    phone      VARCHAR(20) NOT NULL,
    password   VARCHAR(20) NOT NULL,
    age        INT         NOT NULL,
    gender     SMALLINT    NOT NULL,
    birthday   date        NOT NULL,
    created_at datetime    DEFAULT CURRENT_TIMESTAMP,
    updated_at datetime    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);