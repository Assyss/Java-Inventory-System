CREATE DATABASE lojadb;

USE lojadb;

CREATE TABLE produtos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    preco DECIMAL(10, 2),
    quantidade INT
);

INSERT INTO produtos (nome, preco, quantidade) VALUES ('Notebook Gamer', 4500.00, 5);