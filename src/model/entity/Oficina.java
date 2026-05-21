package model.entity;

public class Oficina {
    private int id;
    private String titulo;
    private int cargaHoraria;
    private int vagasDisponiveis;

    public Oficina(int id, String titulo, int cargaHoraria, int vagasDisponiveis) {
        this.id = id;
        this.titulo = titulo;
        this.cargaHoraria = cargaHoraria;
        this.vagasDisponiveis = vagasDisponiveis;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public int getVagasDisponiveis() {
        return vagasDisponiveis;
    }

    public void setVagasDisponiveis(int vagasDisponiveis) {
        this.vagasDisponiveis = vagasDisponiveis;
    }

    @Override
    public String toString() {
        return "Oficina{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                ", vagasDisponiveis=" + vagasDisponiveis +
                '}';
    }
}
