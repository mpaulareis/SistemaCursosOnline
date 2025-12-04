import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.jetbrains.annotations.NotNull;
import javafx.event.ActionEvent;

public class LoginController {

    @FXML private TextField campoCpf;
    @FXML private PasswordField campoSenha;

    @FXML
    public void fazerLogin(@NotNull ActionEvent event) {
        try {
            String cpf = campoCpf.getText();
            String senha = campoSenha.getText();

            if (cpf == null || cpf.isBlank() || senha == null || senha.isBlank()) {
                mostrarErro("Preencha CPF e senha.");
                return;
            }

            Aluno a = Fachada.getInstancia().buscarAlunoPorCpf(cpf);
            if (a == null) {
                mostrarErro("Aluno não encontrado.");
                return;
            }

            if (!a.getSenha().equals(senha)) {
                mostrarErro("Senha incorreta.");
                return;
            }

            SessaoUsuario.setUsuarioLogado(a);

            GerenciadorTelas.mudarPara("dashboard.fxml");

        } catch (Exception e) {
            mostrarErro("Erro ao tentar logar: " + e.getMessage());
        }
    }

    private void mostrarErro(String msg) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Erro");
        alerta.setHeaderText(null);
        alerta.setContentText(msg);
        alerta.showAndWait();
    }
}
