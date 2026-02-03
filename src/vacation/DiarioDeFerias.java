package vacation;

import java.util.List;
import java.util.Scanner;

public class DiarioDeFerias {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MeuDiarioDeFerias diario = new MeuDiarioDeFerias();
        int opcao = 0;

        do {
            try {
                System.out.println("\n MENU DIÁRIO DE FÉRIAS ");
                System.out.println("1- Adicionar nova atividade");
                System.out.println("2- Listar todas as atividades");
                System.out.println("3- Listar atividades por nota (maior para menor)");
                System.out.println("4- Pesquisar atividades por tag");
                System.out.println("5- Sair");

                opcao = sc.nextInt();
                sc.nextLine();

                switch (opcao) {
                    case 1:
                        System.out.print("Descrição: ");
                        String descricao = sc.nextLine();
                        System.out.print("Tag: ");
                        String tag = sc.nextLine();
                        System.out.print("Nota: ");
                        double nota = sc.nextDouble();

                        AtividadeDeFerias novaAtividade = new AtividadeDeFerias(descricao, tag, nota);
                        diario.adicionarAtividade(novaAtividade);
                        System.out.println("Atividade adicionada com sucesso!");
                        break;

                    case 2:
                        List<AtividadeDeFerias> todas = diario.listarAtividades();
                        for (AtividadeDeFerias a : todas) {
                            System.out.println(a);
                        }
                        break;

                    case 3:
                        List<AtividadeDeFerias> ordenadas = diario.listarAtividadesNota();
                        for (AtividadeDeFerias a : ordenadas) {
                            System.out.println(a);
                        }
                        break;

                    case 4:
                        System.out.print("Digite a tag: ");
                        String tagBusca = sc.nextLine();
                        List<AtividadeDeFerias> resultados = diario.pesquisarPorTag(tagBusca);
                        if (resultados.isEmpty()) {
                            System.out.println("Nenhuma atividade encontrada para essa tag.");
                        } else {
                            for (AtividadeDeFerias a : resultados) {
                                System.out.println(a);
                            }
                        }
                        break;

                    case 5:
                        System.out.println("Saindo...");
                        break;

                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
                sc.nextLine();
            }
        } while (opcao != 5);

        sc.close();
    }
}