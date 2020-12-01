package app;

import app.models.entities.Cliente;
import app.models.entities.Instituicao;
import app.models.entities.Leilao;
import app.models.entities.produtos.IProduto;
import app.models.repositories.BaseRepository;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        BaseRepository<IProduto> produtosRepo = new BaseRepository<>();
        BaseRepository<Cliente> clientesRepo = new BaseRepository<>();
        BaseRepository<Instituicao> insituicoesRepo = new BaseRepository<>();
        BaseRepository<Leilao> leiloesRepo = new BaseRepository<>();
        while(true) {
            System.out.println("Iniciando Cadastros...");
            System.out.println("1 - Produtos");
            System.out.println("2 - Clientes");
            System.out.println("3 - Instituições Financeiras");
            System.out.println("4 - Leilões");
            System.out.println("5 - Terminar Cadastros");
            System.out.println("Digite o número correspondente a sua opção");
            int escolha = sc.nextInt();
            boolean flag = false;
            switch (escolha) {
                case 1 -> {
                    System.out.println("Produtos...");
                    System.out.println("Lista de Produtos:" + produtosRepo.getEntidades());
                    System.out.println("1 - Inserir");
                    System.out.println("2 - Atualizar");
                    System.out.println("3 - Deletar");
                    System.out.println("Digite o número correspondente a sua opção");
                    escolha = sc.nextInt();
                    switch (escolha){
                        case 1 -> {
                            System.out.println("Digite os valores ");
                        }
                        case 2 -> {

                        }
                        case 3 -> {

                        }
                        default -> System.out.println("Digito incorreto");
                    }
                }
                case 2 -> {
                    System.out.println("Clientes...");
                    System.out.println("Lista de Clientes:" + clientesRepo.getEntidades());
                    System.out.println("1 - Inserir");
                    System.out.println("2 - Atualizar");
                    System.out.println("3 - Deletar");
                    System.out.println("Digite o número correspondente a sua opção");
                    escolha = sc.nextInt();
                    switch (escolha){
                        case 1 -> {
                            System.out.println("Digite os valores do cliente:");
                            System.out.println("Numero de documento:");
                            String ndoc = sc.next();
                            System.out.println("Codigo de acesso:");
                            String codigo = sc.next();
                            System.out.println("Senha:");
                            String senha = sc.next();
                            Cliente novo = new Cliente(ndoc, codigo, senha);
                            clientesRepo.add(novo);
                        }
                        case 2 -> {
                            System.out.println("Digite os valores do cliente:");
                            System.out.println("Id:");
                            Integer id = sc.nextInt();
                            System.out.println("Numero de documento:");
                            String ndoc = sc.next();
                            System.out.println("Codigo de acesso:");
                            String codigo = sc.next();
                            System.out.println("Senha:");
                            String senha = sc.next();
                            Cliente novo = new Cliente(id, ndoc, codigo, senha);
                            clientesRepo.add(novo);
                        }
                        case 3 -> {
                            System.out.println("Digite os valores do cliente:");
                            System.out.println("Id:");
                            Integer id = sc.nextInt();
                            clientesRepo.delete(id);
                        }
                        default -> System.out.println("Digito incorreto");
                    }
                }
                case 3 -> {
                    System.out.println("3");
                }
                case 4 -> {
                    System.out.println("4");
                }
                case 5 -> flag = true;
                default -> System.out.println("Digito incorreto");
            }
            if(flag)
                break;
        }
    }
}