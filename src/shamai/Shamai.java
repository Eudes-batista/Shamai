package shamai;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Shamai extends Application {

    private static Stage principal;
    private static Stage senhaCliente;

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.chamarTelaPrincipal(primaryStage);
        this.chamarTelaSenhaClientes(new Stage());
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static Stage getPrincipal() {
        return principal;
    }

    public static Stage getSenhaCliente() {
        return senhaCliente;
    }

    private void chamarTelaPrincipal(Stage stage) throws IOException {
        this.criarStage(stage, "/shamai/visao/FXMLPrincipal.fxml");
        principal = stage;
    }

    private void chamarTelaSenhaClientes(Stage stage) throws IOException {
        this.criarStage(stage, "/shamai/visao/FXMLMonitor.fxml");
        senhaCliente = stage;
    }

    private void criarStage(Stage primaryStage, String xml) throws IOException {
        FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource(xml));
        Parent root = fXMLLoader.load();
        primaryStage.setScene(new Scene(root));
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();
    }

}
