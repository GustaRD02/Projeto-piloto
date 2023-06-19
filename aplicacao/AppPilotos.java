package aplicacao;

import java.io.IOException;
import java.util.Scanner;

import classes.Aeronave;
import classes.Piloto;

public class AppPilotos {
    public static void main(String[] args) throws InterruptedException, IOException {

        final int MAX_ELEMENTOS = 10;
        int opcao, qtdCadastrados = 0;
        Piloto[] pilotos = new Piloto[MAX_ELEMENTOS];

        Scanner in = new Scanner(System.in);

        do {
            System.out.println("\n**\nMENU\n**\n");
            System.out.println("1 - Cadastrar piloto");
            System.out.println("2 - Listar pilotos cadastrados");
            System.out.println("3 - Localizar piloto pelo BREVE");
            System.out.println("4 - Cadastrar aeronave");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = in.nextInt();
            in.nextLine(); // Tira o ENTER que ficou na entrada na instrução anterior

            if (opcao == 1) {
                // Se não tem mais espaço no vetor, saio do cadastro
                if (qtdCadastrados == MAX_ELEMENTOS) {
                    System.out.println("\nNão há espaço para cadastrar novos pilotos.");
                    voltarMenu(in);
                    continue;
                }

                // Cadastre seu piloto aqui
                System.out.println("Insira o nome do piloto: ");
                String nome = in.nextLine();
                System.out.println("Insira o cpf: ");
                String cpf = in.nextLine();
                while (!cpf.matches("\\d{3}[.]{1}\\d{3}[.]{1}\\d{3}[-]{1}\\d{2}")) {
                    System.out.println("CPF inválido");
                    System.out.println("Insira um CPF válido: ");
                    cpf = in.nextLine();
                }
                System.out.println("Insira o brevê: ");
                String breve = in.nextLine();

                Piloto piloto = new Piloto(nome, cpf, breve);
                pilotos[qtdCadastrados] = piloto;
                qtdCadastrados++;

                System.out.println("\nPiloto cadastrado com sucesso.");
                voltarMenu(in);
            } else if (opcao == 2) {
                // Se não tem ninguém cadastrado no vetor, caio fora
                if (qtdCadastrados == 0) {
                    System.out.println("\nNão há pilotos cadastrados para exibir.");
                    voltarMenu(in);
                    continue;
                }

                // Exiba os pilotos aqui
                System.out.println("* Pilotos cadastrados *");
                for (int i = 0; i < qtdCadastrados; i++) {
                    System.out.println("Nome: " + pilotos[i].getNome());
                    System.out.println("CPF: " + pilotos[i].getCpf());
                    System.out.println("Brevê: " + pilotos[i].getBreve());
                    System.out.println("------------");
                }

                voltarMenu(in);
            } else if (opcao == 3) {
                boolean key = false;
                Piloto pilotoEncontrado = null;
                System.out.print("\nInforme o brevê: ");
                String breve = in.nextLine();

                for (int i = 0; !key && i < qtdCadastrados; i++) {
                    key = breve.equals(pilotos[i].getBreve());
                    if (key) {
                        pilotoEncontrado = pilotos[i];
                    }
                }

                if (key) {
                    System.out.println("Brevê: " + pilotoEncontrado.getBreve() + " cadastrado.");
                } else {
                    System.out.println("Piloto não cadastrado.");
                }

                voltarMenu(in);
            } else if (opcao == 4) {
                // Se não tem ninguém cadastrado no vetor, caio fora
                if (qtdCadastrados == 0) {
                    System.out.println("\nSem pilotos, não é possível cadastrar uma aeronave.");
                    voltarMenu(in);
                    continue;
                }

                // Solicite ao usuário o piloto
                System.out.println("Insira o brevê do piloto: ");
                String breve = in.nextLine();

                Piloto piloto = null;
                for (int i = 0; i < qtdCadastrados; i++) {
                    if (breve.equals(pilotos[i].getBreve())) {
                        piloto = pilotos[i];
                        break;
                    }
                }

                if (piloto != null) {
                    System.out.println("Insira o modelo da Aeronave: ");
                    String modelo = in.nextLine();
                    System.out.println("Insira o número de série da Aeronave: ");
                    String numSerie = in.nextLine();

                    Aeronave aeronave = new Aeronave(modelo, numSerie, MAX_ELEMENTOS);
                    aeronave.adicionarPiloto(piloto);

                    System.out.println("\nAeronave cadastrada com sucesso.");
                    System.out.println("Piloto vinculado à aeronave:");
                    System.out.println("Nome: " + piloto.getNome());
                    System.out.println("CPF: " + piloto.getCpf());
                    System.out.println("Brevê: " + piloto.getBreve());
                    System.out.println("Aeronave - Modelo: " + aeronave.getModelo() + " Número de Série: "
                            + aeronave.getNumeroSerie());
                } else {
                    System.out.println("Piloto não encontrado.");
                }

                voltarMenu(in);
            } else if (opcao == 0) {
                System.out.println("\nSaindo...");
            } else {
                System.out.println("\nOpção inválida!");
                voltarMenu(in);
            }

        } while (opcao != 0);

        in.close();
    }

    private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();

        // Limpa toda a tela, deixando novamente apenas o menu
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");

        System.out.flush();

    }
}