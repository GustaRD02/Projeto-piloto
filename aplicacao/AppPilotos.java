package aplicacao;

import java.io.IOException;
import java.util.Scanner;

import classes.Piloto;

public class AppPilotos {
    public static void main(String[] args) throws InterruptedException, IOException {

        final int MAX_ELEMENTOS = 10;
        int opcao, qtdCadastrados = 0;
        Piloto[] pilotos = new Piloto[MAX_ELEMENTOS];

        // List<Piloto> pilotos = new ArrayList<Piloto>();

        Scanner in = new Scanner(System.in);

        do {
            System.out.println("\n****\nMENU\n****\n");
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
                    System.out.println("CPF invalido");
                    System.out.println("Insira um cpf válido: ");
                    cpf = in.nextLine();
                }
                System.out.println("Insira seu brevê: ");
                String breve = in.nextLine();

                Piloto piloto = new Piloto(nome, cpf, breve);
                pilotos[qtdCadastrados] = piloto;
                qtdCadastrados = qtdCadastrados + 1;

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
                System.out.println("*** Pilotos cadrastados ***");
                for (Piloto piloto : pilotos) {
                    if (piloto != null) {
                        System.out.println("Nome: " + piloto.getNome());
                        System.out.println("CPF: " + piloto.getCpf());
                        System.out.println("Brevê: " + piloto.getBreve());
                        System.out.println("------------");
                    }
                }

                voltarMenu(in);
            } else if (opcao == 3) {
                boolean key = false;
                Piloto pilotoEncontrado = null;
                System.out.print("\nInforme o Brevê: ");
                String breve = in.nextLine();

                for (int i = 0; !key && i < qtdCadastrados; i++) {
                    key = breve.equals(pilotos[i].getBreve());
                    if(key){
                    pilotoEncontrado = pilotos[i];
                    }
                }

                if (key) {
                    System.out.printf("BREVÊ: " + pilotoEncontrado.getBreve() + " cadastrado.");
                } else if (pilotoEncontrado == null) {
                    System.out.println("Piloto não cadastrado.");
                }

                
                voltarMenu(in);
            } else if (opcao == 4) {
                // Se não tem ninguém cadastrado no vetor, caio fora
                if (qtdCadastrados == 0) {
                    System.out.println("\nSem pilotos, não há como cadastrar uma aeronave");
                    voltarMenu(in);
                    continue;
                }

                // Solicite ao usuário o piloto
                // Crie a aeronave vinculando-a ao piloto
                
                System.out.println("\nAeronave cadastrada com sucesso.");
                // Exiba os dados da aeronave
                voltarMenu(in);
            } else if (opcao != 0) {
                System.out.println("\nOpção inválida!");
            }
        } while (opcao != 0);

        System.out.println("Fim do programa!");

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
