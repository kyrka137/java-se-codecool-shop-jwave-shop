DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS suppliers;
DROP TABLE IF EXISTS categories;

CREATE TABLE suppliers
(
  id int PRIMARY KEY,
  name varchar UNIQUE,
  description varchar
);

CREATE TABLE categories
(
  id int PRIMARY KEY,
  name varchar UNIQUE,
  department varchar,
  description varchar
);

CREATE TABLE products
(
  id int PRIMARY KEY,
  name varchar UNIQUE,
  defaultPrice float,
  currencyString varchar,
  description varchar,
  productCategory varchar,
  supplier varchar
--  productCategory INTEGER REFERENCES categories(category_id),
--  supplier INTEGER REFERENCES suppliers(supplier_id)
);