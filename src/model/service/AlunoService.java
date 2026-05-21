package model.service;

import model.entity.Aluno;
import model.repository.AlunoRepository;

public class AlunoService {

    public boolean cadastrar(int id, String nome, String cpf, AlunoRepository repository) {

    boolean idDuplicado = false;
    boolean cpfDuplicado = false;

    if (id <= 0) {
        return false;
    }
    if (nome.isBlank()) {
        return false;
    }
    if (cpf.isBlank()) {
        return false;
    }

    for (Aluno aluno : repository.listar().values()) {

        if (aluno.getId() == id) {
            idDuplicado = true;
        }
        if (aluno.getCpf().equals(cpf)) {
            cpfDuplicado = true;
        }

    }
    if (idDuplicado || cpfDuplicado) {
        return false;
    }
    repository.salvar(new Aluno(id, cpf, nome));
    return true;
    }
}

