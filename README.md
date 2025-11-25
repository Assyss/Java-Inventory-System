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
