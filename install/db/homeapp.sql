CREATE SCHEMA IF NOT EXISTS homeapp
  CHARACTER SET utf8
  COLLATE utf8_general_ci;

CREATE TABLE IF NOT EXISTS stations (
  id      INT PRIMARY KEY AUTO_INCREMENT,
  name    VARCHAR(100) NOT NULL,
  site_id INT          NOT NULL,
  type    VARCHAR(45)  NOT NULL,
  x       INT          NOT NULL,
  y       INT          NOT NULL
);