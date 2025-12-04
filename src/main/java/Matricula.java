public class Matricula {
    private Aluno aluno;
    private Curso curso;
    private String dataMatricula;
    private double nota;

    public Matricula(Aluno aluno, Curso curso, String dataMatricula) {
        this.aluno = aluno;
        this.curso = curso;
        this.dataMatricula = dataMatricula;
    }

    public Aluno  getAluno() { return aluno; }
    public Curso getCurso() { return curso; }
    public String getDataMatricula() { return dataMatricula; }
    public double getNota() { return nota; }

    public void registrarNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Matrícula: " + aluno.getNome() + " no curso " + curso.getTitulo() +
                " | Data: " + dataMatricula + " | Nota: " + nota;
    }
}

