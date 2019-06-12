DROP TABLE PRODUCTS IF EXISTS;
DROP TABLE CUSTOMERS IF EXISTS;

CREATE TABLE PRODUCTS(
                       ID VARCHAR(25) PRIMARY KEY,
                       NAME VARCHAR(50),
                       DESCRIPTION VARCHAR(250),
                       UNIT_PRICE DECIMAL,
                       MANUFACTURER VARCHAR(50),
                       CATEGORY VARCHAR(50),
                       CONDITION VARCHAR(50),
                       UNITS_IN_STOCK BIGINT,
                       UNITS_IN_ORDER BIGINT,
                       DISCONTINUED BOOLEAN
);

CREATE TABLE CUSTOMERS(
                        ID VARCHAR(25) PRIMARY KEY,
                        NAME VARCHAR(50),
                        ADDRESS VARCHAR(250),
                        NO_ORDERS_MADE BIGINT
);


INSERT INTO PRODUCTS VALUES('P1234', 'iPhone 6s', 'Apple iPhone 6s smartphone with 4.00-inch 640X1136 diplay and 8-megapixel rear camera', 500, 'Apple', 'Smartphone', 'New', 450, 0, false);

INSERT INTO PRODUCTS VALUES('P1235', 'Dell Inspiron', 'Dell Inspiron 14-inch Laptop with 3rd Generation Intel Core processors', 700, 'Dell', 'Laptop', 'New', 1000, 0, false);

INSERT INTO PRODUCTS VALUES('P1236', 'Nexus 7', 'Google Nexus 7 is the lightest 7 inch tablet with a quad-core S4 Pro procrssor', 300, 'Google', 'Tablet', 'New', 1000, 0, false);


INSERT INTO CUSTOMERS VALUES('C1231', 'Rujuan Xing', '910 N 10TH ST, Fairfield IA, 52556', 10);
INSERT INTO CUSTOMERS VALUES('C1232', 'John Smith', '1000 N 4TH ST, Fairfield IA, 52557', 10);
INSERT INTO CUSTOMERS VALUES('C1233', 'Lily Black', '5230 Pterson ST, Austin TX, 92553', 10);

