package classes;

public class Aeronave {
    private String modelo;
    private String numeroSerie;
    private Piloto[] pilotos;
    private int qtdPilotos;

    public Aeronave(String modelo, String numeroSerie, int maxPilotos) {
        this.modelo = modelo;
        this.numeroSerie = numeroSerie;
        this.pilotos = new Piloto[maxPilotos];
        this.qtdPilotos = 0;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

      public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public Piloto[] getPilotos() {
        return pilotos;
    }

    public void setPilotos(Piloto[] pilotos) {
        this.pilotos = pilotos;
    }

    public int getQtdPilotos() {
        return qtdPilotos;
    }

    public void setQtdPilotos(int qtdPilotos) {
        this.qtdPilotos = qtdPilotos;
    }


    public void adicionarPiloto(Piloto piloto) {
        if (qtdPilotos < pilotos.length) {
            pilotos[qtdPilotos] = piloto;
            qtdPilotos++;
            System.out.println("Piloto adicionado à aeronave.");
        } else {
            System.out.println("Não é possível adicionar mais pilotos. Limite alcançado.");
        }
    }

    public void listarPilotos() {
        System.out.println("Pilotos cadastrados na aeronave:");
        for (int i = 0; i < qtdPilotos; i++) {
            System.out.println("Nome: " + pilotos[i].getNome());
            System.out.println("CPF: " + pilotos[i].getCpf());
            System.out.println("Brevê: " + pilotos[i].getBreve());
            System.out.println("------------");
        }
    }
}
