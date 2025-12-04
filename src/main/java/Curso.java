public class Curso {
    private String titulo;
    private String descricao;
    private int cargaHoraria;
    private String categoria;
    private Professor professor;
    private Aula[] aulas;
    private int contadorAulas;

    public Curso(String titulo, String descricao, int cargaHoraria, String categoria, Professor professor) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
        this.categoria = categoria;
        this.professor = professor;
        this.aulas = new Aula[100];
        this.contadorAulas = 0;
    }

    public void adicionarAula(Aula aula) {
        if (contadorAulas<aulas.length) {
            aulas[contadorAulas] = aula;
        }
    }

    public String getTitulo() { return titulo; }
    public Professor getProfessor() { return professor; }

    public Aula[] getAulas() {
        return aulas;
    }

    @Override
    public String toString() {
        return "Curso: " + titulo + " | Carga horária: " + cargaHoraria + "h | Categoria: " + categoria;
    }
}
