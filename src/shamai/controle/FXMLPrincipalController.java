package shamai.controle;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import shamai.Shamai;
import shamai.util.PlatformSystem;

public class FXMLPrincipalController implements Initializable {

    private double x, y;

    @FXML
    private AnchorPane ancoraPrincipal;

    @FXML
    private Label labelHoraPrincipal;

    @FXML
    private TextField textFieldNumeroPedido;

    @FXML
    private Button buttonChamar;

    @FXML
    private Label labelSair;

    @FXML
    private Label labelMinimizar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        this.ancoraPrincipal.setOnMousePressed(evt -> {
            x = evt.getSceneX();
            y = evt.getSceneY();
        });
        this.ancoraPrincipal.setOnMouseDragged(evt -> {
            Shamai.getPrincipal().setX(evt.getScreenX() - x);
            Shamai.getPrincipal().setY(evt.getScreenY() - y);
            Shamai.getPrincipal().setOpacity(0.8f);
        });
        this.ancoraPrincipal.setOnDragDone(evt -> Shamai.getPrincipal().setOpacity(1.0f));
        this.ancoraPrincipal.setOnMouseReleased(evt -> Shamai.getPrincipal().setOpacity(1.0f));

        this.labelSair.setOnMouseClicked(evt -> System.exit(0));
        this.labelMinimizar.setOnMouseClicked(evt -> ((Stage) this.ancoraPrincipal.getScene().getWindow()).setIconified(true));
        PlatformSystem.addHourLabel(this.labelHoraPrincipal);

    }

}
