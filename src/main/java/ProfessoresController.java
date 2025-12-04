
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class ProfessoresController {

    @FXML private TableView<Professor> tabelaProfessores;
    @FXML private TableColumn<Professor, String> colunaNome;
    @FXML private TableColumn<Professor, String> colunaCpf;
    @FXML private TableColumn<Professor, String> colunaArea;
    @FXML private TableColumn<Professor, String> colunaEmail;

    @FXML private TextField campoNome;
    @FXML private TextField campoCpf;
    @FXML private TextField campoArea;
    @FXML private TextField campoEmail;

    private final ObservableList<Professor> listaObservavel = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        colunaArea.setCellValueFactory(new PropertyValueFactory<>("areaAtuacao"));
        colunaEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        tabelaProfessores.setItems(listaObservavel);
        atualizarTabela();


        tabelaProfessores.setRowFactory(tv -> {
            TableRow<Professor> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty()) {
                    Professor p = row.getItem();
                    preencherCampos(p);
                }
            });
            return row;
        });
    }

    private void preencherCampos(Professor p) {
        campoNome.setText(p.getNome());
        campoCpf.setText(p.getCpf());
        campoArea.setText(p.getAreaAtuacao());
        campoEmail.setText(p.getEmail());
    }

    @FXML
    public void cadastrarProfessor() {
        try {
            String nome = campoNome.getText().trim();
            String cpf = campoCpf.getText().trim();
            String area = campoArea.getText().trim();
            String email = campoEmail.getText().trim();

            if (nome.isEmpty() || cpf.isEmpty()) {
                mostrarErro("Nome e CPF são obrigatórios");
                return;
            }

            Professor p = new Professor(nome, cpf, area, email);
            Fachada.getInstancia().cadastrarProfessor(p);

            atualizarTabela();
            limparCampos();
            mostrarInfo("Professor cadastrado com sucesso!");

        } catch (Exception e) {
            mostrarErro("Erro ao cadastrar: " + e.getMessage());
        }
    }

    @FXML
    public void atualizarTabela() {
        listaObservavel.clear();
        Professor[] arr = Fachada.getInstancia().listarProfessores();
        if (arr != null) listaObservavel.addAll(arr);
    }

    private void limparCampos() {
        campoNome.clear();
        campoCpf.clear();
        campoArea.clear();
        campoEmail.clear();
    }

    private void mostrarErro(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    private void mostrarInfo(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
