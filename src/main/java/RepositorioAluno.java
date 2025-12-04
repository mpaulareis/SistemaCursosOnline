import exceptions.EntidadeJaExisteException;
import exceptions.EntidadeNaoEncontradaException;
import exceptions.RepositorioCheioException;
import java.util.Arrays;
import java.util.List;

public class RepositorioAluno{
    private static RepositorioAluno instance;
    private Aluno[] alunos;
    private int indice;

    private RepositorioAluno(){alunos = new Aluno[100];indice = 0;}

    public static RepositorioAluno getInstance(){
        if(instance == null){
            instance = new RepositorioAluno();
        }
        return instance;
    }

    public void cadastrar(Aluno aluno){
        if(aluno == null){throw new IllegalArgumentException("Aluno mulo");}
        if (buscarPorCpf(aluno.getCpf()) != null) {
            throw new EntidadeJaExisteException("Aluno já cadastrado");
        } if (indice >= alunos.length){throw new RepositorioCheioException("Repositorio Cheio");}
        alunos[indice++] = aluno;
}
    public Aluno buscarPorCpf(String cpf) {
        for (int i = 0; i < indice; i++) {
            if (alunos[i].getCpf().equals(cpf)) {
                return alunos[i];
            }
        }
        return null;
    }

public void removerPorCpf(String cpf){
    for(int i = 0; i < indice; i++){
        if(alunos[i].getCpf().equals(cpf)){
            alunos[i] = alunos[indice-1];
            alunos[indice-1] = null;
            indice--;
            return;
        }
    }
    throw new EntidadeNaoEncontradaException("Aluno não encontrado para remoção");
}

public Aluno[]listar(){
        Aluno[]copia = new Aluno[indice];
        for(int i = 0; i < indice; i++){copia[i] = alunos[i];}
        return copia;
}

    }