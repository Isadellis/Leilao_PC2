package itensLeilao;

import java.util.ArrayList;

public class Lote {
    private ArrayList<Produto> produtos;

    public Lote(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    public Lote() {
        this.produtos = new ArrayList<Produto>();
    }

    public void inserirProduto(Produto produto) {
        //Não permite que um mesmo produto seja inserido mais de uma vez
        for (Produto auxProduto: produtos) {
            if(auxProduto.getDescricao().toLowerCase().equals(produto.getDescricao().toLowerCase()))
                System.out.println("\r\nO produto já existe nesse lote.");
                return;
        }
        produtos.add(produto);
    }

    /*GETTER E SETTER*/
    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }
}
