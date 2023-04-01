package testes;

import itensLeilao.Leilao;

import java.util.Scanner;

public class Menu {
    private Acoes acoes;

    public Menu() {
        this.acoes = new Acoes();
    }

    public void exibirMenu(Leilao leilao, Scanner scanner) {
        System.out.println("\r\nOPÇÕES\r\n---------------");
        System.out.println("1 - Inserir um lote");
        System.out.println("2 - Fazer um lance");
        System.out.println("3 - Listar produtos");

        System.out.printf("Informe o que deseja fazer: ");
        controlaOpcoes(scanner.nextInt(), leilao, scanner);
    }

    private void controlaOpcoes(int opcao, Leilao leilao, Scanner scanner) {
        boolean opcaoInvalida = true;

        while (opcaoInvalida) {
            scanner.nextLine(); //"Limpa" o buffer do teclado
            switch (opcao) {
                case 1:
                    acoes.inserirLote(leilao, scanner);
                    opcaoInvalida = false;
                    break;
                case 2:
                    acoes.fazerLance(leilao, scanner);
                    opcaoInvalida = false;
                    break;
                case 3:
                    acoes.listarProdutos(leilao);
                    opcaoInvalida = false;
                    break;
                default:
                    System.out.printf("\r\n");
                    System.out.printf("Opção inválida!\r\nInforme novamente o que deseja fazer: ");
                    opcao = scanner.nextInt();
            }
        }

    }
}