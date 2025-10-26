package cursos;

import cursos.exceptions.EntidadeNaoEncontradaException;

public class Fachada {
    private static Fachada instancia;

    private RepositorioAluno repoAluno = RepositorioAluno.getInstance();
    private RepositorioProfessor repoProfessor = RepositorioProfessor.getInstancia();
    private RepositorioCurso repoCurso = RepositorioCurso.getInstancia();
    private RepositorioMatricula repoMatricula = RepositorioMatricula.getInstancia();

    private Fachada() {}

    public static Fachada getInstancia() {
        if (instancia == null) instancia = new Fachada();
        return instancia;
    }

    public void cadastrarAluno(Aluno a) { repoAluno.cadastrar(a); }
    public Aluno buscarAlunoPorCpf(String cpf) { return repoAluno.buscarPorCpf(cpf); }
    public void cadastrarProfessor(Professor p) { repoProfessor.cadastrar(p); }
    public void cadastrarCurso(Curso c) { repoCurso.cadastrar(c); }
    public Curso buscarCursoPorTitulo(String titulo) { return repoCurso.buscarPorTitulo(titulo); }

    public void matricularAluno(String cpfAluno, String tituloCurso, String data) {
        Aluno a = repoAluno.buscarPorCpf(cpfAluno);
        if (a == null) throw new EntidadeNaoEncontradaException("Aluno não encontrado");
        Curso c = repoCurso.buscarPorTitulo(tituloCurso);
        if (c == null) throw new EntidadeNaoEncontradaException("Curso não encontrado");
        Matricula m = new Matricula(a, c, data);
        repoMatricula.cadastrar(m);
    }

    public Matricula[] listarMatriculasDoAluno(String cpfAluno) {
        return repoMatricula.listarPorAluno(cpfAluno);
    }

}
