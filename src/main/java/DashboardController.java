
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DashboardController {

    @FXML private Label labelNome;

    public void initialize() {
        if (SessaoUsuario.getUsuarioLogado() != null) {
            // fazendo a conversão para o tipo Aluno
            Aluno alunoLogado = (Aluno) SessaoUsuario.getUsuarioLogado();

            labelNome.setText("Bem-vindo(a), " + alunoLogado.getNome());
        }
    }

    public void abrirAlunos() { GerenciadorTelas.mudarPara("alunos.fxml"); }
    public void abrirCursos() { GerenciadorTelas.mudarPara("cursos.fxml"); }
    public void abrirProfessores() { GerenciadorTelas.mudarPara("professores.fxml"); }
    public void abrirMatriculas() { GerenciadorTelas.mudarPara("matriculas.fxml"); }

    public void sair() {
        SessaoUsuario.limpar();
        GerenciadorTelas.mudarPara("login.fxml");
    }
}
