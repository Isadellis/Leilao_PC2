package itensLeilao;

public class Lance {
    private Pessoa pessoa;
    private float valor;

    public Lance() {
        this.pessoa = new Pessoa();
        this.valor = 0;
    }

    public Lance(Pessoa pessoa, float valor) {
        this.pessoa = pessoa;
        this.valor = valor;
    }


    /*GETTERS*/
    public Pessoa getPessoa() {
        return pessoa;
    }

    public float getValor() {
        return valor;
    }


    /*SETTERS*/
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}
