package itensLeilao;

import java.util.ArrayList;

public class Leilao {
    private ArrayList<Lote> lotes;

    public Leilao(ArrayList<Lote> lotes) {
        this.lotes = lotes;
    }

    public Leilao() {
        this.lotes = new ArrayList<Lote>();
    }

    public void inserirLote(Lote lote) {
        this.lotes.add(lote);
    }

    public void listarProdutos() {
        if (lotes.isEmpty()){
            System.out.println("Nenhum lote foi cadastrado.");
            return;
        }

        int i = 0;
        for (Lote lote : lotes) {
            System.out.println("\n----------");
            System.out.println("Produtos do lote " + i + ": ");
            System.out.println("----------");
            i++;
            System.out.println("Descrição\t\t | \t\tMaior Lance");
            ArrayList<Produto> produtos = lote.getProdutos();

            for (Produto produto : produtos) {
                System.out.println(produto.getDescricao() + "\t\t   \t\tR$" + produto.getMaiorLance().getValor());

            }
        }
    }

    public boolean receberLance(int numLote, String descricaoProduto, Lance lance) {
        if (numLote > lotes.size())
            return false;
        Lote lote = lotes.get(numLote);

        ArrayList<Produto> produtos = lote.getProdutos();
        Produto produto;

        //Encontra o produto com base na sua descrição e compara o lance feito, caso seja maior que o atual, o substitui
        for (int i = 0; i < produtos.size(); i++)
            if (produtos.get(i).getDescricao().toLowerCase().equals(descricaoProduto)) {
                produtos.get(i).verificarMaiorLance(lance);
                break; //Para o loop assim que a mesma descrição é encontrada
            }

        return true;
    }

    public void encerrarLeilao() {
        if (lotes.isEmpty()){
            System.out.println("Nenhum lote foi cadastrado.");
            return;
        }

        int i = 0;
        for (Lote lote : lotes) {
            System.out.println("----------");
            System.out.println("Produtos do lote " + i + ": ");
            i++;
            System.out.println("Descrição\t\t  \t\tArrematador\t\t\t\t  \t\t\t\tMaior Lance");
            //Caso não seja possível identificar o arrematador o produto não será apresentado
            for (Produto produto : lote.getProdutos()) {
                if (!(produto.getMaiorLance().getPessoa().getNome().isEmpty() && produto.getMaiorLance().getPessoa().getContato().isEmpty()))
                    System.out.println(produto.getDescricao() + "\t\t   \t\t" + produto.getMaiorLance().getPessoa().getNome() + "(" + produto.getMaiorLance().getPessoa().getContato() + ")" + "\t\t\t\t  \t\t\t\tR$" + produto.getMaiorLance().getValor());
            }
        }
    }

    /*GETTER E SETTER*/
    public ArrayList<Lote> getLotes() {
        return lotes;
    }

    public void setLotes(ArrayList<Lote> lotes) {
        this.lotes = lotes;
    }
}
