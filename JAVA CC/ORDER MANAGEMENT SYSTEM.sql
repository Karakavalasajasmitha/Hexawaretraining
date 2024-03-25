CREATE DATABASE Ordermanagementsystem;
USE Ordermanagementsystem;

CREATE TABLE Product (
    product_id INT PRIMARY KEY,
    product_name VARCHAR(100) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2),
    quantity_in_stock INT,
    type VARCHAR(20),
    brand VARCHAR(50),
    warranty_period INT,
    size VARCHAR(20),
    color VARCHAR(20)
);
CREATE TABLE Users (
    user_id INT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    role VARCHAR(20) NOT NULL
);
CREATE TABLE Orders (
    order_id INT,
    user_id INT,
    product_id INT
 );

INSERT INTO Product (product_id, product_name, description, price, quantity_in_stock, type, brand, warranty_period, size, color)
VALUES 
    (1, 'Laptop', '125-inch laptop with 8 gb ram', 50000.00, 10, 'Electronics', 'HP', 1, '15-inch', 'Silver'),
    (2, 'Smartphone', 'Latest smartphone ', 8000.00, 15, 'Electronics', 'Samsung', 1, '6.2-inch', 'Black');
  

INSERT INTO Users (user_id, username, password, role)
VALUES
    (100,'jassie','adm123','admin'),
    (102, 'varshu', 'user1', 'user');
 

INSERT INTO Orders (order_id, user_id, product_id)
VALUES
    (100, 102, 1), 
    (101, 102, 2);