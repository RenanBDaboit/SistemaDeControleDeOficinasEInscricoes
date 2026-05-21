package model.entity;

public class Inscricao {
    private int id;
    private Aluno aluno;
    private Oficina oficina;
    private enum Status{
        ATIVA,
        CANCELADA
    }
    
    public Status status;

    public Inscricao(int id, Aluno aluno, Oficina oficina, Status status) {
        this.id = id;
        this.aluno = aluno;
        this.oficina = oficina;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Oficina getOficina() {
        return oficina;
    }

    public void setOficina(Oficina oficina) {
        this.oficina = oficina;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Inscricao{" +
                "id=" + id +
                ", aluno=" + aluno +
                ", oficina=" + oficina +
                ", status=" + status +
                '}';
    }
}
