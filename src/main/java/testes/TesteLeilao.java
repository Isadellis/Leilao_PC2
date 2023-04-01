package testes;

import itensLeilao.Leilao;

import java.util.Scanner;

public class TesteLeilao {

    public static void main(String[] args) {
        boolean fimLeilao = false;
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(); //Responsável pela exibição do menu e pelos métodos chamados com base na opção escolhida
        Leilao leilao = new Leilao();

        System.out.println("\r\nAVISO: Em caso de travamentos após a inserção de um dado, pressione a tecla 'ENTER' novamente");
        while (!fimLeilao) {
            menu.exibirMenu(leilao, scanner);

            System.out.printf("Deseja encerrar o leilão (S/N)? ");
            fimLeilao = (scanner.next().toLowerCase().equals("s") ? true : false);

        }
        System.out.flush();
        System.out.println("\nRESULTADO DO LEILÃO");
        scanner.close();
        leilao.encerrarLeilao();
    }
}
