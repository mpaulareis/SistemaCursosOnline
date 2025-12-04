import exceptions.EntidadeJaExisteException;
import exceptions.EntidadeNaoEncontradaException;
import exceptions.RepositorioCheioException;
import java.util.Arrays;
import java.util.List;

public class RepositorioMatricula {
    private static RepositorioMatricula instancia;
    private Matricula[] matriculas;
    private int indice;

    private RepositorioMatricula() { matriculas = new Matricula[200]; indice = 0; }

    public static RepositorioMatricula getInstancia() {
        if (instancia == null) instancia = new RepositorioMatricula();
        return instancia;
    }


    public void cadastrar(Matricula m) {
        if (m == null) throw new IllegalArgumentException("Matrícula nula");
        if (existeMatricula(m.getAluno().getCpf(), m.getCurso().getTitulo())) throw new EntidadeJaExisteException("Aluno já matriculado neste curso");
        if (indice >= matriculas.length) throw new RepositorioCheioException("Repositório de matrículas cheio");
        matriculas[indice++] = m;
    }

    public boolean existeMatricula(String cpfAluno, String tituloCurso) {
        for (int i = 0; i < indice; i++) {
            if (matriculas[i].getAluno().getCpf().equals(cpfAluno)
                    && matriculas[i].getCurso().getTitulo().equalsIgnoreCase(tituloCurso)) {
                return true;
            }
        }
        return false;
    }

    public Matricula[] listarPorAluno(String cpfAluno) {
        int count = 0;
        for (int i = 0; i < indice; i++) if (matriculas[i].getAluno().getCpf().equals(cpfAluno)) count++;
        Matricula[] res = new Matricula[count];
        int pos = 0;
        for (int i = 0; i < indice; i++) {
            if (matriculas[i].getAluno().getCpf().equals(cpfAluno)) res[pos++] = matriculas[i];
        }
        return res;
    }

    public void remover(String cpfAluno, String tituloCurso) {
        for (int i = 0; i < indice; i++) {
            if (matriculas[i].getAluno().getCpf().equals(cpfAluno)
                    && matriculas[i].getCurso().getTitulo().equalsIgnoreCase(tituloCurso)) {
                matriculas[i] = matriculas[indice - 1];
                matriculas[indice - 1] = null;
                indice--;
                return;
            }
        }
        throw new EntidadeNaoEncontradaException("Matrícula não encontrada");
    }

    public Matricula[] listar() {
        Matricula[] copia = new Matricula[indice];
        for (int i = 0; i < indice; i++) copia[i] = matriculas[i];
        return copia;
    }

}
