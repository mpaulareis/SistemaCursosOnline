
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CursosController {

    @FXML private TableView<Curso> tabelaCursos;
    @FXML private TableColumn<Curso, String> colunaTitulo;
    @FXML private TableColumn<Curso, String> colunaDescricao;
    @FXML private TableColumn<Curso, Integer> colunaCarga;
    @FXML private TableColumn<Curso, String> colunaCategoria;
    @FXML private TableColumn<Curso, String> colunaProfessor;

    @FXML private TextField campoTitulo;
    @FXML private TextField campoDescricao;
    @FXML private TextField campoCargaHoraria;
    @FXML private TextField campoCategoria;

    @FXML private ComboBox<String> comboProfessor;

    private final ObservableList<Curso> listaCursos = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        colunaTitulo.setCellValueFactory(param -> new javafx.beans.property.SimpleStringProperty(param.getValue().getTitulo()));

        colunaDescricao.setCellValueFactory(param -> new javafx.beans.property.SimpleStringProperty(param.getValue().toString())); // ajuste se quiser outra info

        colunaCarga.setCellValueFactory(param ->
                new javafx.beans.property.SimpleObjectProperty<>(param.getValue().getAulas().length));

        colunaCategoria.setCellValueFactory(param ->
                new javafx.beans.property.SimpleStringProperty(""));

        colunaProfessor.setCellValueFactory(param ->
                new javafx.beans.property.SimpleStringProperty(
                        param.getValue().getProfessor() != null ? param.getValue().getProfessor().getNome() : ""
                ));

        tabelaCursos.setItems(listaCursos);

        atualizarTabela();
        carregarProfessores();
    }

    private void carregarProfessores() {
        comboProfessor.getItems().clear();
        Professor[] profs = Fachada.getInstancia().listarProfessores();
        if (profs != null) {
            for (Professor p : profs) comboProfessor.getItems().add(p.getNome());
        }
    }

    @FXML
    public void cadastrarCurso() {
        try {
            String titulo = campoTitulo.getText();
            String descricao = campoDescricao.getText();
            String cargaTxt = campoCargaHoraria.getText();
            String categoria = campoCategoria.getText();
            String nomeProfessor = comboProfessor.getValue();

            if (titulo == null || titulo.isBlank()) {
                mostrarErro("Título é obrigatório!");
                return;
            }

            int carga = 0;
            try {
                carga = Integer.parseInt(cargaTxt);
            } catch (Exception e) {
                mostrarErro("Carga horária inválida!");
                return;
            }

            Professor prof = Fachada.getInstancia().buscarProfessorPorNome(nomeProfessor);
            if (prof == null) {
                mostrarErro("Professor não encontrado!");
                return;
            }

            Curso c = new Curso(titulo, descricao, carga, categoria, prof);
            Fachada.getInstancia().cadastrarCurso(c);

            atualizarTabela();
            limparCampos();
            mostrarInfo("Curso cadastrado!");

        } catch (Exception e) {
            mostrarErro("Erro: " + e.getMessage());
        }
    }

    @FXML
    public void atualizarTabela() {
        listaCursos.clear();
        Curso[] cursos = Fachada.getInstancia().listarCursos();
        if (cursos != null) listaCursos.addAll(cursos);
    }

    private void limparCampos() {
        campoTitulo.clear();
        campoDescricao.clear();
        campoCargaHoraria.clear();
        campoCategoria.clear();
        comboProfessor.setValue(null);
    }

    private void mostrarErro(String msg) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setContentText(msg);
        a.show();
    }

    private void mostrarInfo(String msg) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText(msg);
        a.show();
    }
}
