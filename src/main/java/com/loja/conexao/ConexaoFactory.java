package com.loja.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

    public Connection recuperarConexao() {
        try {
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/lojadb", "SEU_USER_AQUI", "SUA_SENHA_AQUI");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}