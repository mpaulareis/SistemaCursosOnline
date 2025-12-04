import exceptions.EntidadeJaExisteException;
import exceptions.EntidadeNaoEncontradaException;
import exceptions.RepositorioCheioException;
import java.util.Arrays;
import java.util.List;

public class RepositorioProfessor {
    private static RepositorioProfessor instancia;
    private Professor[] professores;
    private int indice;

    private RepositorioProfessor() {
        professores = new Professor[50];
        indice = 0;
    }

    public static RepositorioProfessor getInstancia() {
        if (instancia == null) instancia = new RepositorioProfessor();
        return instancia;
    }

    public void cadastrar(Professor professor) {
        if (professor == null) throw new IllegalArgumentException("Professor nulo");

        if (buscarPorCpf(professor.getCpf()) != null)
            throw new EntidadeJaExisteException("Professor já cadastrado");

        if (indice >= professores.length)
            throw new RepositorioCheioException("Repositório de professores cheio");

        professores[indice++] = professor;
    }

    public Professor buscarPorNome(String nome) {
        for (Professor p : professores) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                return p;
            }
        }
        return null; // Retorna null se não encontrar
    }

    public Professor buscarPorCpf(String cpf) {
        for (int i = 0; i < indice; i++) {
            if (professores[i].getCpf().equals(cpf)) return professores[i];
        }
        return null;
    }

    public void removerPorCpf(String cpf) {
        for (int i = 0; i < indice; i++) {
            if (professores[i].getCpf().equals(cpf)) {
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
