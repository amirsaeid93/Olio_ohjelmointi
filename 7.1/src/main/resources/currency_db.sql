DROP DATABASE IF EXISTS currency_db;
CREATE DATABASE currency_db;
USE currency_db;

CREATE TABLE currency (
    abbreviation VARCHAR(3) NOT NULL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    rate DECIMAL(10, 4) NOT NULL
);

INSERT INTO currency (abbreviation, name, rate) VALUES ('USD', 'United States Dollar', 1.0000);
INSERT INTO currency (abbreviation, name, rate) VALUES ('EUR', 'Euro', 0.9150);
INSERT INTO currency (abbreviation, name, rate) VALUES ('GBP', 'British Pound Sterling', 0.7840);
INSERT INTO currency (abbreviation, name, rate) VALUES ('JPY', 'Japanese Yen', 147.6500);
INSERT INTO currency (abbreviation, name, rate) VALUES ('AUD', 'Australian Dollar', 1.5230);
INSERT INTO currency (abbreviation, name, rate) VALUES ('CAD', 'Canadian Dollar', 1.3510);
INSERT INTO currency (abbreviation, name, rate) VALUES ('CHF', 'Swiss Franc', 0.8760);
INSERT INTO currency (abbreviation, name, rate) VALUES ('CNY', 'Chinese Yuan', 7.1820);

DROP USER IF EXISTS 'appuser'@'localhost';
CREATE USER 'appuser'@'localhost' IDENTIFIED BY 'password';

GRANT SELECT ON currency_db.currency TO 'appuser'@'localhost';
FLUSH PRIVILEGES;