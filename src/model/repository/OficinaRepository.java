package model.repository;

import model.entity.Oficina;
import java.util.HashMap;

public class OficinaRepository {

    private final HashMap<Integer, Oficina> oficinas = new HashMap<>();

    public void salvar(Oficina oficina){
        oficinas.put(oficina.getId(), oficina);
    }
    public void atualizar(Oficina oficina){
        oficinas.replace(oficina.getId(), oficina);
    }
    public HashMap<Integer, Oficina> listar(){
        return oficinas;
    }
    public void remover(int id){
        oficinas.remove(id);
    }
    public Oficina buscar(int id){
        return oficinas.get(id);
    }
    
}

