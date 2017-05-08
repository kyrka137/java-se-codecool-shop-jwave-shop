DROP TABLE IF EXISTS suppliers;

CREATE TABLE suppliers
(
id varchar(36) PRIMARY KEY,
name varchar(40)
);


DROP TABLE IF EXISTS products;

CREATE TABLE products
(
id varchar(36) PRIMARY KEY,
name varchar(40)
supplier integer references (suppliers.id)
);

DROP TABLE IF EXISTS productsCategory;

CREATE TABLE productCategory
(
id varchar(36) PRIMARY KEY,
name varchar(40)
);
