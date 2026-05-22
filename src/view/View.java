package view;

import controller.AlunoController;
import controller.InscricaoController;
import controller.OficinaController;
import model.repository.AlunoRepository;
import model.repository.InscricaoRepository;
import model.repository.OficinaRepository;

import java.util.Scanner;

public class View {

    private final Scanner sc = new Scanner(System.in);

    private final AlunoView alunoView;
    private final OficinaView oficinaView;
    private final InscricaoView inscricaoView;

    public View(AlunoController alunoController,
                         OficinaController oficinaController,
                         InscricaoController inscricaoController,
                         InscricaoRepository inscricaoRepository,
                         AlunoRepository alunoRepository,
                         OficinaRepository oficinaRepository) {

        this.alunoView = new AlunoView(alunoController);
        this.oficinaView = new OficinaView(oficinaController);
        this.inscricaoView = new InscricaoView(inscricaoController, inscricaoRepository, alunoRepository, oficinaRepository);
    }

    public void menuPrincipal() {
        int op;
        do {
            System.out.println("+=====================================+");
            System.out.println("|           MENU PRINCIPAL            |");
            System.out.println("+=====================================+");
            System.out.println("| [1] Aluno                           |");
            System.out.println("| [2] Oficina                         |");
            System.out.println("| [3] Inscrição                       |");
            System.out.println("| [0] Sair                            |");
            System.out.println("+=====================================+");
            System.out.print("Escolha uma opção: ");
            try {
                op = Integer.parseInt(sc.nextLine());

                switch (op) {
                    case 1 ->{
                        alunoView.menuAluno();
                    }
                    case 2 ->{
                        oficinaView.menuOficina();
                    }
                    case 3 ->{
                        inscricaoView.menuIncricao();
                    }
                    case 0 ->{
                        System.out.println("Saindo...");
                    }
                    default ->{
                        System.out.println("Opção incorreta!");
                    }
                }
            } catch (NumberFormatException n) {
                System.out.println("Apenas números!");
                op = -1;
            }
            
        } while (op != 0);
    }
}