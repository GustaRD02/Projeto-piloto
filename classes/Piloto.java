package classes;

import java.util.ArrayList;
import java.util.List;

public class Piloto extends Pessoa {
    // breve = uma carteira de pilotos de aeronave privado
    private String breve;
    private List<Aeronave> aeronaves = new ArrayList<>();

    public Piloto() {
    }

    public Piloto(String nome, String cpf, String breve) {
        super(nome, cpf);
        this.breve = breve;
        // TODO Auto-generated constructor stub
    }

    public List<Aeronave> getAeronaves() {
        return aeronaves;
    }

    public void setAeronaves(List<Aeronave> aeronaves) {
        this.aeronaves = aeronaves;
    }

    public String getBreve() {
        return breve;
    }

    public void setBreve(String breve) {
        this.breve = breve;
    }

    @Override
    public String toString() {
        return String.format("\nNome: %s\nCPF: %s\nBreve: %s\n--------------------", getNome(), getCpf(), getBreve());
    }
}
