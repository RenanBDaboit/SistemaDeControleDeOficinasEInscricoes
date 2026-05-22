package view;

import controller.AlunoController;

import java.util.Scanner;

public class AlunoView {
    private final AlunoController alunoController;
    private final Scanner sc = new Scanner(System.in);
    
    public AlunoView(AlunoController alunoController){
        this.alunoController = alunoController;
    }
    
    public void menuAluno(){
        int op;
        do{
            System.out.println("+=====================================+");
            System.out.println("|              MENU ALUNO             |");
            System.out.println("+=====================================+");
            System.out.println("| [1] Cadastrar Aluno                 |");
            System.out.println("| [0] Sair                            |");
            System.out.println("+=====================================+");
            System.out.print("Escolha uma opção: ");
            try{
                op = Integer.parseInt(sc.nextLine());

                switch (op){

                    case 1 ->{
                        cadastrarAluno();
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
        } while(op != 0);
    }
    
    private void cadastrarAluno(){
        int id = -1;
        try{
            System.out.print("ID: ");
            id = sc.nextInt();
        } catch (NumberFormatException n){
            System.out.println("Apenas números!");
        }
        
        System.out.print("CPF: ");
        String cpf = sc.nextLine();

        System.out.println("Nome: ");
        String nome = sc.nextLine();
        
        boolean sucesso = alunoController.cadastrar(id, cpf, nome);
        
        if(sucesso){
            System.out.println("Aluno cadastrado com sucesso!");
        } else {
            System.out.println("Aluno não cadastrado!");
        }
    }
}
