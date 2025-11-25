package com.loja.modelo;

public class Produto {
    
    // 1. Atributos (Espelho das colunas do MySQL)
    private int id;
    private String nome;
    private double preco;
    private int quantidade;

    // 2. Construtor Vazio (Necessário para o Java criar objetos em branco)
    public Produto() {
    }

    // 3. Construtor Cheio (Para criar produtos novos rapidamente)
    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    // 4. Getters e Setters (Para acessar e modificar os dados protegidos)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    // 5. Método toString (Para imprimir o produto no console)
    @Override
    public String toString() {
        return String.format("ID: %d | %s | R$ %.2f | Estoque: %d", 
                id, nome, preco, quantidade);
    }
}