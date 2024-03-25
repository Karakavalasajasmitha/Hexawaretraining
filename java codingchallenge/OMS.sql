create database OMS;
use OMS;
--- task-1 --- creating tables ----

CREATE TABLE Product (
    productId INT PRIMARY KEY,
    productName VARCHAR(255),
    description VARCHAR(255),
    price DOUBLE,
    quantityInStock INT,
    type VARCHAR(20)
);

CREATE TABLE Electronics (
    productId INT PRIMARY KEY,
    brand VARCHAR(255),
    warrantyPeriod int,
    FOREIGN KEY (productId) REFERENCES Product(productId)
);
drop table electronics;

CREATE TABLE Clothing (
    productId INT PRIMARY KEY,
    size VARCHAR(20),
    color VARCHAR(20),
    FOREIGN KEY (productId) REFERENCES Product(productId)
);

CREATE TABLE User (
    userId INT PRIMARY KEY,
    username VARCHAR(50),
    password VARCHAR(50),
    role VARCHAR(20)
);

CREATE TABLE Orders (
    orderId INT PRIMARY KEY,
    userId INT,
    productId INT,
    FOREIGN KEY (userId) REFERENCES User(userId),
    FOREIGN KEY (productId) REFERENCES Product(productId)
);
--- task-2 --- inserting the values into the tables
INSERT INTO Product (productId, productName, description, price, quantityInStock, type)
VALUES (1, 'Smartphone', 'Latest smartphone model', 999.99, 50, 'Electronics');

INSERT INTO Product (productId, productName, description, price, quantityInStock, type)
VALUES (2, 'T-shirt', 'Cotton T-shirt', 19.99, 100, 'Clothing');

-- Insert values into Electronics table
INSERT INTO Electronics (productId, brand, warrantyPeriod)
VALUES (1, 'Samsung', 12);

-- Insert values into Clothing table
INSERT INTO Clothing (productId, size, color)
VALUES (2, 'M', 'Blue');

-- Insert values into User table
INSERT INTO User (userId, username, password, role)
VALUES (1, 'admin', 'adminpass', 'Admin');

INSERT INTO User (userId, username, password, role)
VALUES (2, 'user1', 'userpass', 'User');

-- Insert values into Orders table
INSERT INTO Orders (orderId, userId, productId)
VALUES (1, 2, 1);

INSERT INTO Orders (orderId, userId, productId)
VALUES (2, 2, 2);

select * from product;
select * from electronics;
select * from user;
select * from clothing;
