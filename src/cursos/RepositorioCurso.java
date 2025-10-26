package cursos;

import cursos.exceptions.EntidadeJaExisteException;
import cursos.exceptions.EntidadeNaoEncontradaException;
import cursos.exceptions.RepositorioCheioException;

public class RepositorioCurso {
    private static RepositorioCurso instancia;
    private Curso[] cursos;
    private int indice;

    private RepositorioCurso() { cursos = new Curso[100]; indice = 0; }

    public static RepositorioCurso getInstancia() {
        if (instancia == null) instancia = new RepositorioCurso();
        return instancia;
    }

    public void cadastrar(Curso curso) {
        if (curso == null) throw new IllegalArgumentException("Curso nulo");
        if (buscarPorTitulo(curso.getTitulo()) != null) throw new EntidadeJaExisteException("Curso já cadastrado");
        if (indice >= cursos.length) throw new RepositorioCheioException("Repositório de cursos cheio");
        cursos[indice++] = curso;
    }

    public Curso buscarPorTitulo(String titulo) {
        for (int i = 0; i < indice; i++) {
            if (cursos[i].getTitulo().equalsIgnoreCase(titulo)) return cursos[i];
        }
        return null;
    }

    public void removerPorTitulo(String titulo) {
        for (int i = 0; i < indice; i++) {
            if (cursos[i].getTitulo().equalsIgnoreCase(titulo)) {
                cursos[i] = cursos[indice - 1];
                cursos[indice - 1] = null;
                indice--;
                return;
            }
        }
        throw new EntidadeNaoEncontradaException("Curso não encontrado");
    }

    public Curso[] listar() {
        Curso[] copia = new Curso[indice];
        for (int i = 0; i < indice; i++) copia[i] = cursos[i];
        return copia;
    }
}

