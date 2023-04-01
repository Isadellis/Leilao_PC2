package itensLeilao;

public class Pessoa {
    private String nome;
    private String contato;

    public Pessoa() {
        this.nome = "";
        this.contato = "";
    }

    public Pessoa(String nome, String contato) {
        this.nome = nome;
        this.contato = contato;
    }

    /*GETTERS*/
    public String getNome() {
        return nome;
    }

    public String getContato() {
        return contato;
    }

    /*SETTERS*/

    public void setContato(String contato) {
        this.contato = contato;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}