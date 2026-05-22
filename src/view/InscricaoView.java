package view;

import controller.InscricaoController;
import model.entity.Aluno;
import model.entity.Inscricao;
import model.entity.Oficina;
import model.repository.AlunoRepository;
import model.repository.InscricaoRepository;
import model.repository.OficinaRepository;

import java.util.Scanner;

public class InscricaoView {
        private final InscricaoController controller;
        private final InscricaoRepository repository;
        private final AlunoRepository alunoRepository;
        private final OficinaRepository oficinaRepository;
        private final Scanner sc = new Scanner(System.in);

    public InscricaoView(InscricaoController controller, InscricaoRepository repository, 
                         AlunoRepository alunoRepository, OficinaRepository oficinaRepository) {
        this.controller = controller;
        this.repository = repository;
        this.alunoRepository = alunoRepository;
        this.oficinaRepository = oficinaRepository;
    }
    
    public void menuIncricao(){
        int op;
        do{
            System.out.println("+=====================================+");
            System.out.println("|            MENU INSCRIÇÃO           |");
            System.out.println("+=====================================+");
            System.out.println("| [1] Cadastrar Inscrição             |");
            System.out.println("| [2] Listar Inscrições               |");
            System.out.println("| [3] Atualizar Inscrição             |");
            System.out.println("| [4] Cancelar Inscrição              |");
            System.out.println("| [0] Sair                            |");
            System.out.println("+=====================================+");
            System.out.print("Escolha uma opção: ");
            try{
                op = Integer.parseInt(sc.nextLine());

                switch (op){

                    case 1 ->{
                        cadastrarInscricao();
                    }
                    
                    case 2 ->{
                       listarInscricoes(); 
                    }
                    
                    case 3 ->{
                        atualizarInscricao();
                    }
                    
                    case 4 ->{
                        cancelarInscricao();
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
    
    private  void cadastrarInscricao(){
        int id = -1;
        int idAluno = -1;
        int idOficina = -1;
        
        try{
            
            System.out.print("ID da inscrição: ");
            id = Integer.parseInt(sc.nextLine());
            
            listarAlunos();
            System.out.print("ID do aluno que vai fazer a inscrição: ");
            idAluno = Integer.parseInt(sc.nextLine());
            
            listarOficinas();
            System.out.print("ID da oficina: ");
            idOficina = Integer.parseInt(sc.nextLine());
            
        } catch (NumberFormatException n){
            System.out.println("Apenas números!");
        }
        
        boolean sucesso = controller.cadastrar(id, idAluno, idOficina, Inscricao.Status.ATIVA);
    }
    
    private void listarAlunos(){
        for(Aluno aluno : controller.listarAlunos().values()){
            System.out.println(aluno);
        }
    }
    
    private void listarOficinas(){
        for(Oficina oficina : controller.listarOficinas().values()){
            System.out.println(oficina);
        }
    }
    
    private void listarInscricoes(){
        for(Inscricao inscricao : controller.listarIncricoes().values()){
            System.out.println(inscricao);
        }
    }
    
    private void atualizarInscricao() {
        listarInscricoes();
        int id = -1;
        int idAluno = -1;
        int idOficina = -1;
        try{
            System.out.print("ID da inscrição que deseja atualizar: ");
            id = Integer.parseInt(sc.nextLine());
            Inscricao inscricao = repository.buscar(id);
            
            if(inscricao == null){
                System.out.println("Inscrição não encontrada!");
            }
            
            listarAlunos();
            System.out.print("Novo aluno: ");
            idAluno = Integer.parseInt(sc.nextLine());
            Aluno aluno = alunoRepository.buscar(idAluno);
            
            listarOficinas();
            System.out.print("Nova oficina: ");
            idOficina = Integer.parseInt(sc.nextLine());
            Oficina oficina = oficinaRepository.buscar(idOficina);
        } catch (NumberFormatException n){
            System.out.println("Apenas números!");
        }
    }
    
    private void cancelarInscricao(){
        listarInscricoes();
        try{
            
        } catch (NumberFormatException n){
            System.out.println("Apenas números!");
        }
    }
}
