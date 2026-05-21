package model.repository;

import model.entity.Inscricao;

import java.util.HashMap;

public class InscricaoRepository {

    private final HashMap<Integer, Inscricao> inscricoes = new HashMap<>();

    public void salvar(Inscricao inscricao) {
        inscricoes.put(inscricao.getId(), inscricao);
    }

    public Inscricao buscar(int id) {
        return inscricoes.get(id);
    }

    public void atualizar(Inscricao inscricao) {
        inscricoes.replace(inscricao.getId(), inscricao);
    }

    public HashMap<Integer, Inscricao> listar() {
        return inscricoes;
    }

    public void remover(int id) {
        inscricoes.remove(id);
    }

}
