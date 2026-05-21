package model.service;

import model.entity.Oficina;
import model.repository.OficinaRepository;

public class OficinaService {

    public boolean cadastrar(int id, String titulo, int cargaHoraria, int vagasDisponiveis, OficinaRepository repository) {

        boolean idDuplicado = false;

        if (id <= 0) {
            return false;
        }
        if (titulo.isBlank()) {
            return false;
        }
        if (cargaHoraria <= 0) {
            return false;
        }
        if (vagasDisponiveis < 0) {
            return false;
        }
    for(Oficina oficina : repository.listar().values()) {

        if (oficina.getId() == id) {
            idDuplicado = true;
        }
    }
        if(idDuplicado){
            return false;
        }
        repository.salvar(new Oficina(id, titulo, cargaHoraria, vagasDisponiveis));
        return true;
    }
}
