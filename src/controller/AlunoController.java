package controller;

import model.repository.AlunoRepository;
import model.service.AlunoService;

public class AlunoController {
    private final AlunoRepository alunoRepository;
    private final AlunoService alunoService = new AlunoService();
    
    public AlunoController(AlunoRepository alunoRepository){
        this.alunoRepository = alunoRepository;
    }
    
    public boolean cadastrar(int id, String cpf, String nome){
        return alunoService.cadastrar(id, cpf, nome, alunoRepository);
    }
}
