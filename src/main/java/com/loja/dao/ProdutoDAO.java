package com.loja.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.loja.conexao.ConexaoFactory;
import com.loja.modelo.Produto;

public class ProdutoDAO {

    private Connection connection;

    public ProdutoDAO() {
        // Assim que criamos o DAO, ele pega logo uma conexão
        this.connection = new ConexaoFactory().recuperarConexao();
    }

    // (CREATE)
    public void cadastrar(Produto produto) {
        // O "?" é uma segurança contra hackers (SQL Injection)
        String sql = "INSERT INTO produtos (nome, preco, quantidade) VALUES (?, ?, ?)";

        try {
            // Prepara o SQL
            PreparedStatement ps = connection.prepareStatement(sql);
            
            // Substitui os "?" pelos dados do produto
            ps.setString(1, produto.getNome());
            ps.setDouble(2, produto.getPreco());
            ps.setInt(3, produto.getQuantidade());

            // Executa o comando no banco
            ps.execute();
            ps.close();
            
            System.out.println("✅ Produto gravado no banco com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        
    }
    
    // (READ / LISTAR)
    public List<Produto> listar() {
        String sql = "SELECT * FROM produtos";
        List<Produto> produtos = new ArrayList<>();

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            
            // O ResultSet é como uma planilha que volta do banco
            ResultSet rs = ps.executeQuery();

            // Enquanto houver uma próxima linha na planilha...
            while (rs.next()) {
                Produto p = new Produto();
                
                // Pegamos os dados da coluna e colocamos no objeto
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setPreco(rs.getDouble("preco"));
                p.setQuantidade(rs.getInt("quantidade"));

                // Adiciona na lista
                produtos.add(p);
            }
            
            ps.close();
            rs.close();
            return produtos;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    // (UPDATE / ATUALIZAR)
    public void atualizar(Produto produto) {
        // CUIDADO: O "WHERE id = ?" é obrigatório! Sem ele, muda a loja toda.
        String sql = "UPDATE produtos SET nome = ?, preco = ?, quantidade = ? WHERE id = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            
            // Preenchemos os novos dados
            ps.setString(1, produto.getNome());
            ps.setDouble(2, produto.getPreco());
            ps.setInt(3, produto.getQuantidade());
            
            // O ID é o critério para saber QUEM vamos alterar (é o 4º ponto de interrogação)
            ps.setInt(4, produto.getId());

            ps.execute();
            ps.close();
            
            System.out.println("✅ Produto atualizado com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // (DELETE / APAGAR)
    public void deletar(int id) {
        String sql = "DELETE FROM produtos WHERE id = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            
            // Só precisamos do ID para apagar
            ps.setInt(1, id);

            ps.execute();
            ps.close();
            
            System.out.println("✅ Produto removido com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}