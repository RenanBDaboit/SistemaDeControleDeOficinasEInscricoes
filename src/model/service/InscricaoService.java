package model.service;

import model.entity.Aluno;
import model.entity.Inscricao;
import model.entity.Oficina;
import model.repository.AlunoRepository;
import model.repository.InscricaoRepository;
import model.repository.OficinaRepository;

public class InscricaoService {

    public boolean cadastrar(int id, int idAluno, int idOficina, OficinaRepository oficinaRepository, AlunoRepository alunoRepository, InscricaoRepository repository) {

        boolean alunoExiste = false;
        boolean oficinaExiste = false;

        Aluno alunoSalvar = null;
        Oficina oficinaSalvar = null;

        if (id <= 0) {
            return false;
        }

        for (Aluno aluno : alunoRepository.listar().values()) {

            if (aluno.getId() == id) {
                alunoExiste = true;
                alunoSalvar = aluno;
            }

        }

        for (Oficina oficina : oficinaRepository.listar().values()) {
            if (oficina.getId() == id) {
                oficinaExiste = true;
                oficinaSalvar = oficina;
            }

        }
        for (Inscricao inscricao : repository.listar().values()) {
            if (inscricao.getId() == id) {
                return false;


            }
        }
        repository.salvar(new Inscricao(id, alunoSalvar, oficinaSalvar, Inscricao.Status.ATIVA));
        return true;
    }
}
