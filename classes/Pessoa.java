package classes;

public class Pessoa {
    private String nome;
    private String cpf;

    public Pessoa() {
    }

    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf.matches("\\d{3}[.]{1}\\d{3}[.]{1}\\d{3}[-]{1}\\d{2}")) {
            this.cpf = cpf;
        } else {
            this.cpf = "O CPF deve ter 11 dígitos!!!";
        }

    }

}