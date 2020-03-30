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

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("/shamai/visao/FXMLPrincipal.fxml"));
        Parent root = fXMLLoader.load();
        primaryStage.setScene(new Scene(root));
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();
        principal = primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static Stage getPrincipal() {
        return principal;
    }

}
