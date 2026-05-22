package controller;
import model.repository.AlunoRepository;
import model.repository.InscricaoRepository;
import model.repository.OficinaRepository;
import model.service.InscricaoService;

public class InscricaoController {
    private final InscricaoService inscricaoService = new InscricaoService();
    private final InscricaoRepository repository;
    private final AlunoRepository alunoRepository;
    private final OficinaRepository oficinaRepository;
    
    public InscricaoController(InscricaoRepository repository, AlunoRepository alunoRepository, 
                               OficinaRepository oficinaRepository){
        this.repository = repository;
        this.alunoRepository = alunoRepository;
        this.oficinaRepository = oficinaRepository;
        
    }
    
    public boolean cadastrar(int id, int idAluno, int idOficina){
        return inscricaoService.cadastrar(id, idAluno, idOficina, oficinaRepository, alunoRepository, repository);
    }
    
    public boolean atualizar(int id, int idAluno, int idOficina) {
        return inscricaoService.cadastrar(id, idAluno, idOficina, oficinaRepository, alunoRepository, repository);
    }
    
    public boolean cancelar(int id){
        return inscricaoService.cancelar(id, repository);
    }
}
