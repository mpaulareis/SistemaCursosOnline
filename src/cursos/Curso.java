package cursos;


import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String titulo;
    private String descricao;
    private int cargaHoraria;
    private String categoria;
    private Professor professor;
    private List<Aula> aulas = new ArrayList<>();

    public Curso(String titulo, String descricao, int cargaHoraria, String categoria, Professor professor) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
        this.categoria = categoria;
        this.professor = professor;
    }

    public void adicionarAula(Aula aula) {
        aulas.add(aula);
    }

    public String getTitulo() { return titulo; }

    @Override
    public String toString() {
        return "Curso: " + titulo + " | Carga horária: " + cargaHoraria + "h | Categoria: " + categoria;
    }
}
