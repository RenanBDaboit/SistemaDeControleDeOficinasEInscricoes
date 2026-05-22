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
            if(oficinaSalvar.getVagasDisponiveis() <= 0){
                return false;

        }
        for (Inscricao inscricao : repository.listar().values()) {
            if (inscricao.getId() == id) {
                return false;

            }
        }
        if (!alunoExiste) {
            return false;
        }
        if (!oficinaExiste) {
            return false;
        }
        if (oficinaSalvar.getVagasDisponiveis() <= 0) {
            return false;
        }
        repository.salvar(new Inscricao(id, alunoSalvar, oficinaSalvar, Inscricao.Status.ATIVA));
        oficinaSalvar.setVagasDisponiveis(oficinaSalvar.getVagasDisponiveis() - 1);
        return true;
    }

    public boolean atualizar(int id, int idAluno, int idOficina, OficinaRepository oficinaRepository, AlunoRepository alunoRepository, InscricaoRepository repository) {

        boolean alunoExiste = false;
        boolean oficinaExiste = false;
        boolean idExiste = false;

        Aluno alunoAtualizar = null;
        Oficina oficinaAtualizar = null;

        if (id <= 0) {
            return false;
        }

        for (Aluno aluno : alunoRepository.listar().values()) {

            if (aluno.getId() == id) {
                alunoExiste = true;
                alunoAtualizar = aluno;
            }
        }
        for (Oficina oficina : oficinaRepository.listar().values()) {
            if (oficina.getId() == id) {
                oficinaExiste = true;
                oficinaAtualizar = oficina;
            }

        }
        for (Inscricao inscricao : repository.listar().values()) {
            if (inscricao.getId() == id) {
                return false;

            }
        }
        if (!alunoExiste) {
            return false;
        }
        if (!oficinaExiste) {
            return false;
        }
        if (oficinaAtualizar.getVagasDisponiveis() <= 0) {
            return false;
        }
        repository.salvar(new Inscricao(id, alunoAtualizar, oficinaAtualizar, Inscricao.Status.ATIVA));
        oficinaAtualizar.setVagasDisponiveis(oficinaAtualizar.getVagasDisponiveis() - 1);

        return true;
    }

    public boolean cancelar(int id,InscricaoRepository repository){

        boolean idExiste = false;
        for(Inscricao inscricao : repository.listar().values()) {
            if (inscricao.getId() == id) {
                idExiste = true;
            }

        }
        if(!idExiste){
            return false;
        }
        repository.listar().get(id).setStatus(Inscricao.Status.CANCELADA);
        return true;
    }
}