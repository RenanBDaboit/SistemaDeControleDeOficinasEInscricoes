package model.repository;

import model.entity.Aluno;
import java.util.HashMap;

public class AlunoRepository {

    private final HashMap<Integer, Aluno> alunos = new HashMap<>();

    public void salvar(Aluno aluno){
        alunos.put(aluno.getId(), aluno);
    }
    public Aluno buscar(int id){
        return alunos.get(id);
    }
    public void atualizar(Aluno aluno){
        alunos.replace(aluno.getId(), aluno);
    }
    public HashMap<Integer, Aluno> listar() {
        return alunos;
    }
    public void remover(int id){
        alunos.remove(id);
    }
}
