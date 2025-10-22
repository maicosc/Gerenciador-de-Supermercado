CREATE DATABASE redemaik;
USE redemaik;

CREATE TABLE Usuarios (
    cpf VARCHAR(14) PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    tipoUsuario VARCHAR(50) NOT NULL
);

CREATE TABLE Produtos (
    codProd INT PRIMARY KEY,
    nomeProd VARCHAR(100) NOT NULL,
    quantidade INT NOT NULL,
    preco DECIMAL(10,2) NOT NULL
);

CREATE TABLE Carrinho (
    id INT AUTO_INCREMENT PRIMARY KEY,
    valorProduto DECIMAL(10,2) NOT NULL,
    nomeProduto VARCHAR(100) NOT NULL,
    quantidade INT NOT NULL,
    codProd INT NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    FOREIGN KEY (codProd) REFERENCES Produtos(codProd),
    FOREIGN KEY (cpf) REFERENCES Usuarios(cpf)
);
