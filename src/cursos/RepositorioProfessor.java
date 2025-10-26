package cursos;

import cursos.exceptions.EntidadeJaExisteException;
import cursos.exceptions.EntidadeNaoEncontradaException;
import cursos.exceptions.RepositorioCheioException;

public class RepositorioProfessor {
    private static RepositorioProfessor instancia;
    private Professor[] professores;
    private int indice;

    private RepositorioProfessor() { professores = new Professor[50]; indice = 0; }

    public static RepositorioProfessor getInstancia() {
        if (instancia == null) instancia = new RepositorioProfessor();
        return instancia;
    }

    public void cadastrar(Professor professor) {
        if (professor == null) throw new IllegalArgumentException("Professor nulo");
        if (buscarPorNome(professor.getNome()) != null) throw new EntidadeJaExisteException("Professor já cadastrado");
        if (indice >= professores.length) throw new RepositorioCheioException("Repositório de professores cheio");
        professores[indice++] = professor;
    }

    public Professor buscarPorNome(String nome) {
        for (int i = 0; i < indice; i++) {
            if (professores[i].getNome().equalsIgnoreCase(nome)) return professores[i];
        }
        return null;
    }

    public void removerPorNome(String nome) {
        for (int i = 0; i < indice; i++) {
            if (professores[i].getNome().equalsIgnoreCase(nome)) {
                professores[i] = professores[indice - 1];
                professores[indice - 1] = null;
                indice--;
                return;
            }
        }
        throw new EntidadeNaoEncontradaException("Professor não encontrado");
    }

    public Professor[] listar() {
        Professor[] copia = new Professor[indice];
        for (int i = 0; i < indice; i++) copia[i] = professores[i];
        return copia;
    }
}
