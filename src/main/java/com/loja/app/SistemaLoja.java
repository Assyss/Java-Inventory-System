package com.loja.app;

import java.util.List;
import java.util.Scanner;
import com.loja.dao.ProdutoDAO;
import com.loja.modelo.Produto;

public class SistemaLoja {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        ProdutoDAO dao = new ProdutoDAO();
        int opcao = 0;

        System.out.println("Bem-vindo ao STOCK MASTER 1.0");

        // O loop garante que o programa não fecha sozinho
        while (opcao != 5) {
            System.out.println("\n===============================");
            System.out.println("       MENU PRINCIPAL");
            System.out.println("===============================");
            System.out.println("1. ➕ Cadastrar Produto");
            System.out.println("2. 📋 Listar Produtos");
            System.out.println("3. ✏️ Atualizar Produto");
            System.out.println("4. 🗑️ Apagar Produto");
            System.out.println("5. 🚪 Sair");
            System.out.print("Escolha uma opção: ");

            opcao = leitor.nextInt();
            leitor.nextLine();
            switch (opcao) {
                case 1:
                    System.out.println("\n--- NOVO CADASTRO ---");
                    System.out.print("Nome do produto: ");
                    String nome = leitor.nextLine();
                    
                    System.out.print("Preço: ");
                    double preco = leitor.nextDouble();
                    
                    System.out.print("Quantidade: ");
                    int qtd = leitor.nextInt();
                    
                    Produto p = new Produto(nome, preco, qtd);
                    dao.cadastrar(p);
                    break;

                case 2:
                    System.out.println("\n--- ESTOQUE ATUAL ---");
                    List<Produto> lista = dao.listar();
                    for (Produto item : lista) {
                        System.out.println(item);
                    }
                    break;

                case 3:
                    System.out.println("\n--- ATUALIZAÇÃO ---");
                    // Primeiro listamos para o usuário ver os IDs
                    listarRapido(dao); 
                    
                    System.out.print("Digite o ID do produto que quer alterar: ");
                    int idParaAlterar = leitor.nextInt();
                    leitor.nextLine(); // Limpar buffer
                    
                    System.out.print("Novo Nome: ");
                    String novoNome = leitor.nextLine();
                    
                    System.out.print("Novo Preço: ");
                    double novoPreco = leitor.nextDouble();
                    
                    System.out.print("Nova Quantidade: ");
                    int novaQtd = leitor.nextInt();
                    
                    Produto produtoAlterado = new Produto(novoNome, novoPreco, novaQtd);
                    produtoAlterado.setId(idParaAlterar); // IMPORTANTE: Definir qual ID mudar
                    
                    dao.atualizar(produtoAlterado);
                    break;

                case 4:
                    System.out.println("\n--- REMOÇÃO ---");
                    listarRapido(dao);
                    
                    System.out.print("Digite o ID do produto para apagar: ");
                    int idParaApagar = leitor.nextInt();
                    
                    dao.deletar(idParaApagar);
                    break;

                case 5:
                    System.out.println("A encerrar sistema... Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
        
        leitor.close();
    }
    
    // Método auxiliar apenas para mostrar a lista simples antes de editar /apagar
    private static void listarRapido(ProdutoDAO dao) {
        List<Produto> lista = dao.listar();
        for (Produto p : lista) {
            System.out.println("ID: " + p.getId() + " - " + p.getNome());
        }
    }
}