package view;

import controller.OficinaController;
import java.util.Scanner;

public class OficinaView {
    
    private final OficinaController oficinaController;
    private final Scanner sc = new Scanner(System.in);
    
    public OficinaView(OficinaController oficinaController){
        this.oficinaController = oficinaController;
    }
    
    public void menuOficina(){
        int op;
        do{
            System.out.println("+=====================================+");
            System.out.println("|             MENU OFICINA            |");
            System.out.println("+=====================================+");
            System.out.println("| [1] Cadastrar oficina               |");
            System.out.println("| [0] Sair                            |");
            System.out.println("+=====================================+");
            System.out.print("Escolha uma opção: ");
            try{
                op = Integer.parseInt(sc.nextLine());

                switch (op){

                    case 1 ->{
                        cadastrarOficina();
                    }

                    case 0 ->{
                        System.out.println("Saindo...");
                    }

                    default ->{
                        System.out.println("Opção incorreta!");
                    }
                }
            } catch (NumberFormatException n){
                System.out.println("Apenas números!");
                op = -1;
            }
        } while (op != 0);
    }

    private void cadastrarOficina() {
        int id = -1;
        int cargaHoraria = -1;
        int vagasDisponiveis = -1;
        String titulo = null;
        try {
            System.out.print("ID: ");
            id = Integer.parseInt(sc.nextLine());

            System.out.print("Título da oficina: ");
            titulo = sc.nextLine();

            System.out.print("Carga horária: ");
            cargaHoraria = Integer.parseInt(sc.nextLine());

            System.out.print("Vagas disponíveis: ");
            vagasDisponiveis = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException n) {
            System.out.println("Apenas números!");
        }

        boolean sucesso = oficinaController.cadastrar(id, titulo, cargaHoraria, vagasDisponiveis);
        
        if(sucesso){
            System.out.println("Oficina cadastrada com sucesso!");
        } else {
            System.out.println("Oficina não cadastrada!");
        }
    }
}
