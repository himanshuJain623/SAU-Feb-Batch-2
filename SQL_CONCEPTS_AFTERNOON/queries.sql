SHOW DATABASES;
CREATE DATABASE HAMENS;
USE HAMENS;
SHOW TABLES;

-- CREATING TABLES

CREATE TABLE product(
	p_code INT,
    p_name VARCHAR(50),
    p_price NUMERIC,
    c_code INT,
    PRIMARY KEY(p_code)
);

DESCRIBE product;

CREATE TABLE category(
	c_code INT,
    c_name VARCHAR(50),
    PRIMARY KEY(c_code)
);

DESCRIBE category;

ALTER TABLE product
ADD FOREIGN KEY(c_code)
REFERENCES category(c_code)
ON DELETE CASCADE;

CREATE TABLE location(
	l_code INT,
    l_name VARCHAR(50),
    PRIMARY KEY(l_code)
);

DESCRIBE location;

CREATE TABLE sales_executive(
	se_code INT,
    f_name VARCHAR(50),
    l_name VARCHAR(50),
    dob DATE,
    gender VARCHAR(1),
    m_number VARCHAR(15),
    l_code INT,
    PRIMARY KEY(se_code),
    FOREIGN KEY(l_code) REFERENCES location(l_code) ON DELETE SET NULL
);

DESCRIBE sales_executive;

CREATE TABLE customer(
	cust_code INT,
    f_name VARCHAR(50),
    l_name VARCHAR(50),
    dob DATE,
    gender VARCHAR(1),
    m_number VARCHAR(15),
    l_code INT,
    PRIMARY KEY(cust_code),
    FOREIGN KEY(l_code) REFERENCES location(l_code) ON DELETE SET NULL
);

DESCRIBE customer;
CREATE TABLE purchased(
	p_code INT,
    cust_code INT,
    se_code INT,
    no_of_units INT,
    date_of_purchase DATE,
    PRIMARY KEY(p_code,cust_code,se_code),
    FOREIGN KEY(p_code) REFERENCES product(p_code),
    FOREIGN KEY(cust_code) REFERENCES customer(cust_code),
    FOREIGN KEY(se_code) REFERENCES sales_executive(se_code)
);

DESCRIBE purchased;

-- INSERTING DATA

INSERT INTO category VALUES
(1,'clothes'),
(2,'shoes'),
(3,'cosmetics')
;

SELECT * FROM category;

INSERT INTO location VALUES
(11,'delhi'),
(22,'mumbai'),
(33,'hyderabad')
;
SELECT * FROM location;

INSERT INTO customer VALUES
(111,'rohan','kumar','1990-12-1','M','8989898990',11),
(222,'harvey','smith','1995-2-12','M','8773398990',33),
(333,'dona','mathew','1994-7-16','F','9089898597',22),
(444,'mike','dayson','1998-1-23','M','9999898990',33);

SELECT * FROM customer;

INSERT INTO sales_executive VALUES
(1111,'tommy','shelby','1980-12-1','M','9898898990',11),
(2222,'john','shelby','1985-2-12','M','9999398990',22),
(3333,'aurther','shelby','1984-7-16','M','9681898597',22),
(4444,'poly','gray','1988-1-23','F','9000898990',33);

SELECT * FROM sales_executive;

INSERT INTO product VALUES
(11111,'t-shirt',800,1),
(22222,'sport-shoes',1500,2),
(33333,'shorts',1000,1),
(44444,'sun-cream',300,3);

SELECT * FROM product;

INSERT INTO purchased VALUES
(11111,444,3333,10,'2021-02-10'),
(22222,111,3333,17,'2021-02-11'),
(22222,333,2222,20,'2021-02-12'),
(33333,222,1111,50,'2021-02-13'),
(44444,111,1111,30,'2021-02-10');

SELECT * FROM purchased;

-- query 2

SELECT purchased.p_code,product.p_name,SUM(purchased.no_of_units),purchased.date_of_purchase
FROM purchased
JOIN customer
ON purchased.cust_code=customer.cust_code
JOIN location
ON customer.l_code=location.l_code
JOIN product
ON purchased.p_code=product.p_code
WHERE location.l_name='hyderabad' AND purchased.date_of_purchase >='2021-02-07' AND purchased.date_of_purchase <='2021-02-14'
GROUP BY purchased.p_code,purchased.date_of_purchase
ORDER BY SUM(purchased.no_of_units) DESC;



-- query 3

SELECT sales_executive.*,SUM(no_of_units) AS products_sold
FROM purchased
JOIN sales_executive
ON purchased.se_code=sales_executive.se_code
GROUP BY se_code;









