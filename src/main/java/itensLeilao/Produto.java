package itensLeilao;

public class Produto {
    private String descricao;
    private Lance maiorLance;

    public Produto() {
        this.maiorLance = new Lance();
        this.descricao = "";
    }

    public Produto(String descricao, Lance maiorLance) {
        this.descricao = descricao;
        this.maiorLance = maiorLance;
    }

    /*MÉTODOS*/
    public void verificarMaiorLance (Lance lance){
        if(this.maiorLance.getValor() < lance.getValor()) {
            System.out.println("Lance realizado com sucesso!");
            this.setMaiorLance(lance);
        }

        System.out.println("O valor informado é menor do que o maior lance atual.");
    }

    /*GETTERS*/
    public String getDescricao() {
        return descricao;
    }

    public Lance getMaiorLance() {
        return maiorLance;
    }

    /*SETTERS*/
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setMaiorLance(Lance maiorLance) {
        this.maiorLance = maiorLance;
    }
}
