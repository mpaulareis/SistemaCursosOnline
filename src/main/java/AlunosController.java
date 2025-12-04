import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class AlunosController {

    @FXML private TableView<Aluno> tabelaAlunos;
    @FXML private TableColumn<Aluno, String> colunaNome;
    @FXML private TableColumn<Aluno, String> colunaCpf;
    @FXML private TableColumn<Aluno, String> colunaEmail;
    @FXML private TableColumn<Aluno, String> colunaTelefone;

    @FXML private TextField campoNome;
    @FXML private TextField campoCpf;
    @FXML private TextField campoEmail;
    @FXML private TextField campoTelefone;

    @FXML private PasswordField campoSenha;

    private final ObservableList<Aluno> listaObservavel = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        colunaEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colunaTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));

        tabelaAlunos.setItems(listaObservavel);
        atualizarTabela();

        tabelaAlunos.setRowFactory(tv -> {
            TableRow<Aluno> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty()) {
                    Aluno a = row.getItem();
                    preencherCampos(a);
                }
            });
            return row;
        });
    }

    private void preencherCampos(Aluno a) {
        campoNome.setText(a.getNome());
        campoCpf.setText(a.getCpf());
        campoEmail.setText(a.getEmail());
        campoTelefone.setText(a.getTelefone());
        campoSenha.setText(a.getSenha());   // <<< NOVO
    }

    @FXML
    public void cadastrarAluno() {
        try {
            String nome = campoNome.getText();
            String cpf = campoCpf.getText();
            String email = campoEmail.getText();
            String telefone = campoTelefone.getText();
            String senha = campoSenha.getText();   // <<< NOVO

            if (nome == null || nome.trim().isEmpty() ||
                    cpf == null || cpf.trim().isEmpty()) {
                mostrarAlertaErro("Preencha nome e CPF");
                return;
            }

            Aluno a = new Aluno(
                    nome.trim(),
                    cpf.trim(),
                    (email == null ? "" : email.trim()),
                    (telefone == null ? "" : telefone.trim()),
                    (senha == null ? "" : senha.trim())   // <<< NOVO
            );

            Fachada.getInstancia().cadastrarAluno(a);
            atualizarTabela();
            limparCampos();
            mostrarAlertaInfo("Aluno cadastrado com sucesso");

        } catch (Exception e) {
            mostrarAlertaErro("Erro ao cadastrar: " + e.getMessage());
        }
    }

    @FXML
    public void atualizarTabela() {
        listaObservavel.clear();
        Aluno[] arr = Fachada.getInstancia().listarAlunos();
        if (arr != null) {
            listaObservavel.addAll(arr);
        }
    }

    private void limparCampos() {
        campoNome.clear();
        campoCpf.clear();
        campoEmail.clear();
        campoTelefone.clear();
        campoSenha.clear();     // <<< NOVO
    }

    private void mostrarAlertaInfo(String msg) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Info");
        a.setHeaderText(null);
        a.setContentText(msg);
        a.showAndWait();
    }

    private void mostrarAlertaErro(String msg) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Erro");
        a.setHeaderText(null);
        a.setContentText(msg);
        a.showAndWait();
    }
}
