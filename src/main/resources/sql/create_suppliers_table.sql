DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS suppliers;
DROP TABLE IF EXISTS categories;

CREATE TABLE suppliers
(
  id SERIAL PRIMARY KEY,
  name varchar
);

CREATE TABLE categories
(
  id SERIAL PRIMARY KEY,
  name varchar
);

CREATE TABLE products
(
  id SERIAL PRIMARY KEY,
  name varchar,
  defaultPrice float,
  currencyString varchar,
  description varchar,
  productCategory INTEGER REFERENCES categories(id),
  supplier INTEGER REFERENCES suppliers(id)
);