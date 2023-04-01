package testes;

import itensLeilao.Lance;
import itensLeilao.Leilao;
import itensLeilao.Lote;
import itensLeilao.Produto;

import java.util.Scanner;

public class Acoes {
    public void inserirLote(Leilao leilao, Scanner scanner) {
        boolean inserirNovoProduto = false;
        Lote lote = new Lote();

        System.out.println("\r\n------\r\nInserindo produtos no novo lote");

        do {
            Produto produto = new Produto();

            System.out.printf("Descrição do produto: ");
            produto.setDescricao(scanner.nextLine());
            scanner.nextLine(); //"Limpa" o buffer do teclado

            //Verifica se o usuário deseja informar um lance inicial
            System.out.printf("Existe um lance inicial para esse produto (S/N)? ");
            if (scanner.next().toLowerCase().equals("s")) {
                System.out.println("\r\nValor do lance: ");
                produto.getMaiorLance().setValor(scanner.nextInt());
                scanner.nextLine(); //"Limpa" o buffer do teclado

                System.out.println("\r\nDeseja informar o nome e o contato de quem fez o lance (S/N?)");
                System.out.println("OBS: Se não informados quem fez o lance não será considerado como arrematador caso tenha feito o maior lance.");
                if (scanner.next().toLowerCase().equals("s")) {
                    System.out.printf("Nome do responsável pelo lance: ");
                    produto.getMaiorLance().getPessoa().setNome(scanner.nextLine());
                    scanner.nextLine(); //"Limpa" o buffer do teclado

                    System.out.printf("Contato do responsável pelo lance: ");
                    produto.getMaiorLance().getPessoa().setContato(scanner.nextLine());
                    scanner.nextLine(); //"Limpa" o buffer do teclado
                }
            }

            lote.inserirProduto(produto);

            System.out.printf("Deseja inserir outro produto (S/N)? ");
            inserirNovoProduto = (scanner.next().toLowerCase().equals("s") ? true : false);
            scanner.nextLine();
        } while (inserirNovoProduto);

        leilao.inserirLote(lote);
    }

    public void fazerLance(Leilao leilao, Scanner scanner) {
        if(leilao.getLotes().isEmpty()){
            System.out.println("Não é possível realizar lances! O leilão não possui lotes.");
            return;
        }

        boolean novoLance = true;

        do {
            Lance lance = new Lance();
            String descricaoProduto;
            int numLote;

            System.out.printf("\r\nNúmero do lote: ");
            numLote = scanner.nextInt();
            scanner.nextLine(); //"Limpa" o buffer do teclado

            System.out.printf("Descrição do produto desejado: ");
            descricaoProduto = scanner.nextLine().toLowerCase();
            scanner.nextLine(); //"Limpa" o buffer do teclado

            System.out.printf("Valor do lance: ");
            lance.setValor(scanner.nextInt());
            scanner.nextLine(); //"Limpa" o buffer do teclado

            System.out.printf("Nome de quem fez o lance (OBRIGATÓRIO): ");
            String nome = scanner.nextLine();
            scanner.nextLine(); //"Limpa" o buffer do teclado
            while (nome.isEmpty()) {
                System.out.printf("Por favor, digite um nome válido.");
                nome = scanner.nextLine();
                scanner.nextLine(); //"Limpa" o buffer do teclado
            }

            lance.getPessoa().setNome(nome);

            System.out.printf("Contato de quem fez o lance (telefone ou e-mail) (OBRIGATÓRIO): ");
            String contato = scanner.nextLine();
            scanner.nextLine(); //"Limpa" o buffer do teclado
            while (contato.isEmpty()) {
                System.out.printf("Por favor, informe um meio de contato válido.");
                contato = scanner.nextLine();
                scanner.nextLine(); //"Limpa" o buffer do teclado
            }
            lance.getPessoa().setContato(contato);

            if(leilao.receberLance(numLote, descricaoProduto, lance)){
                System.out.printf("Deseja fazer um novo lance (S/N)? ");
                novoLance = (scanner.next().toLowerCase().equals("s") ? true : false);
                scanner.nextLine();
            } else {
                System.out.printf("O lote informado não existe.\r\nDeseja fazer um novo lance (S/N)? ");
                novoLance = (scanner.next().toLowerCase().equals("s") ? true : false);
                scanner.nextLine();
            }


        } while (novoLance);
    }

    public void listarProdutos(Leilao leilao) {
        leilao.listarProdutos();
        System.out.println("\r\n");
    }
}
