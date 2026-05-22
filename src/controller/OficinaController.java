package controller;

import model.repository.OficinaRepository;
import model.service.OficinaService;

public class OficinaController {
    private final OficinaRepository oficinaRepository;
    private final OficinaService oficinaService = new OficinaService();
    
    public OficinaController(OficinaRepository oficinaRepository){
        this.oficinaRepository = oficinaRepository;
    }
    
    public boolean cadastrar(int id, String titulo, int cargaHoraria, int vagasDisponiveis){
        return oficinaService.cadastrar(id, titulo, cargaHoraria, vagasDisponiveis, oficinaRepository);
    }
}
