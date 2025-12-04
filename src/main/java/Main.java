import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader fx = new FXMLLoader(getClass().getResource("/login.fxml"));
        Scene sc = new Scene(fx.load());
        stage.setTitle("Sistema de Cursos");
        stage.setScene(sc);
        stage.show();
    }

}