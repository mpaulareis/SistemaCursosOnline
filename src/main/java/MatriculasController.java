import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class MatriculasController {

    @FXML private TextField campoCpf;
    @FXML private TextField campoCurso;
    @FXML private TextField campoData;

    @FXML private TableView<Matricula> tabelaMatriculas;

    private final ObservableList<Matricula> listaObs = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        tabelaMatriculas.setItems(listaObs);
        atualizarTabela();
    }

    @FXML
    public void matricular() {
        try {
            String cpf = campoCpf.getText();
            String titulo = campoCurso.getText();
            String data = campoData.getText();

            if (cpf == null || cpf.trim().isEmpty() || titulo == null || titulo.trim().isEmpty()) {
                mostrarAlertaErro("Preencha CPF e Título do Curso");
                return;
            }

            Fachada.getInstancia().matricularAluno(cpf.trim(), titulo.trim(), data == null ? "" : data.trim());
            atualizarTabela();
            mostrarAlertaInfo("Matrícula realizada com sucesso.");
            campoCpf.clear();
            campoCurso.clear();
            campoData.clear();
        } catch (Exception e) {
            mostrarAlertaErro("Erro na matrícula: " + e.getMessage());
        }
    }

    public void atualizarTabela() {
        listaObs.clear();
        Matricula[] arr = Fachada.getInstancia().listarTodasMatriculas();
        if (arr != null) {
            for (Matricula m : arr) {
                listaObs.add(m);
            }
        }
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
