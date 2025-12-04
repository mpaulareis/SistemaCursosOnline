import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GerenciadorTelas {

    private static Stage stage;

    public static void setStage(Stage s) {
        stage = s;
    }


    public static void mudarPara(String nomeArquivoFxml) {
        try {
            FXMLLoader loader = new FXMLLoader(GerenciadorTelas.class.getResource("/" + nomeArquivoFxml));
            Parent root = loader.load();

            Scene cena = new Scene(root);
            stage.setScene(cena);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao carregar tela: " + nomeArquivoFxml + "\n" + e.getMessage());
        }
    }
}
