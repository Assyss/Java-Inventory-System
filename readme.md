Markdown

# 📦 StockMaster - Java & MySQL Inventory System

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![JDBC](https://img.shields.io/badge/JDBC-Connector-blue?style=for-the-badge)

> Um sistema robusto de **Gestão de Estoque (CRUD)** desenvolvido em Java, utilizando o padrão de arquitetura **DAO (Data Access Object)** para integração profissional com banco de dados **MySQL**.

---

## 🖥️ Funcionalidades

O sistema oferece um menu interativo via terminal para controle total dos produtos:

* **➕ Cadastrar:** Adiciona novos produtos ao banco de dados.
* **📋 Listar:** Recupera e exibe todo o estoque em tempo real.
* **✏️ Atualizar:** Permite alterar preço, nome ou quantidade de um item específico via ID.
* **🗑️ Apagar:** Remove produtos do sistema de forma persistente.

```text
===============================
       MENU PRINCIPAL
===============================
1. ➕ Cadastrar Produto
2. 📋 Listar Produtos
3. ✏️ Atualizar Produto
4. 🗑️ Apagar Produto
5. 🚪 Sair
Escolha uma opção:

🛠️ Arquitetura e Tecnologias
Este projeto foi construído seguindo as melhores práticas de Engenharia de Software para separar a lógica de negócio do acesso aos dados.

Linguagem: Java (JDK 17+)

Banco de Dados: MySQL 8.0

Gerenciador de Dependências: Apache Maven

Padrão de Projeto: DAO (Data Access Object)

Estrutura do Código
com.loja.modelo: Classes POJO que representam as tabelas (Entidades).

com.loja.dao: Classes responsáveis por todo o SQL (INSERT, SELECT, UPDATE, DELETE).

com.loja.conexao: ConnectionFactory para gestão de conexões JDBC seguras.

com.loja.app: Interface do usuário (CLI) e lógica de interação.

⚙️ Como rodar este projeto
1. Configurar o Banco de Dados
Certifique-se de ter o MySQL instalado. Execute o script database.sql incluído neste repositório ou rode os comandos abaixo:

SQL

CREATE DATABASE lojadb;
USE lojadb;
CREATE TABLE produtos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    preco DECIMAL(10, 2),
    quantidade INT
);

2. Configurar a Conexão
No arquivo src/main/java/com/loja/conexao/ConexaoFactory.java, edite a linha da senha para corresponder ao seu MySQL local:

Java

return DriverManager.getConnection("jdbc:mysql://localhost:3306/lojadb", "root", "SUA_SENHA");

3. Executar
Importe o projeto como Maven Project na sua IDE favorita (Eclipse/IntelliJ) e execute a classe SistemaLoja.java.

👨‍💻 Autor
Desenvolvido por Bruno Assis. Projeto focado em demonstrar competências em Java Backend, SQL e JDBC.
