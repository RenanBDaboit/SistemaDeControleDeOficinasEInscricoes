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
    
    private final AlunoRepository alunoRepository = new AlunoRepository();
    private final InscricaoRepository inscricaoRepository = new InscricaoRepository();
    private final OficinaRepository oficinaRepository = new OficinaRepository();
    
    private final AlunoController alunoController = new AlunoController(alunoRepository);
    private final InscricaoController inscricaoController = new InscricaoController(inscricaoRepository, 
            alunoRepository, oficinaRepository);
    private final OficinaController oficinaController = new OficinaController(oficinaRepository);
    
    private final AlunoView alunoView = new AlunoView(alunoController);
    private final InscricaoView inscricaoView = new InscricaoView(inscricaoController, 
            inscricaoRepository, alunoRepository, oficinaRepository);
    private final OficinaView oficinaView = new OficinaView(oficinaController);
    
    public void menuPrincipal(){
        int op;
        do{
            System.out.println("+=====================================+");
            System.out.println("|            MENU PRINCIPAL           |");
            System.out.println("+=====================================+");
            System.out.println("| [1] Alunos                          |");
            System.out.println("| [2] Inscrições                      |");
            System.out.println("| [3] Oficinas                        |");
            System.out.println("| [0] Sair                            |");
            System.out.println("+=====================================+");
            System.out.print("Escolha uma opção: ");
            try {
                op = Integer.parseInt(sc.nextLine());

                switch (op){
                    case 1 -> {
                        alunoView.menuAluno();
                    }

                    case 2 ->{
                        inscricaoView.menuIncricao();
                    }

                    case 3 ->{
                        oficinaView.menuOficina();
                    }

                    case 0 ->{
                        System.out.println("Saindo...");
                        break;
                    }

                    default ->{
                        System.out.println("Opção incorreta!");
                    }

                }
            } catch (NumberFormatException e) {
                System.out.println("Entre com números");
                op = -1;
            }
        } while (op != 0);
    }
}