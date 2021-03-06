/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shamai.controle;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.ScaleTransition;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import shamai.Shamai;
import shamai.audio.Audio;
import shamai.efeito.ScaleTransitionUtil;
import shamai.modelo.Cliente;
import shamai.servico.ClienteServico;
import shamai.util.PlatformSystem;

/**
 * FXML Controller class
 *
 * @author eudes
 */
public class FXMLMonitorController extends ComponentesTelaMonitor implements Initializable {

    private double horizontal, vertical;

    private ObservableList<Cliente> clientes;
    private ListaCliente listaCliente;
    @FXML
    private AnchorPane ancoraPrincipal;
    @FXML
    private AnchorPane ancoraSenhaPrincipal;
    @FXML
    private Label labelSenhaPrincipal;
    @FXML
    private AnchorPane ancoraSenha1;
    @FXML
    private Label labelHoraSenha1;
    @FXML
    private Label labelSenha1;
    @FXML
    private AnchorPane ancoraSenha2;
    @FXML
    private Label labelHoraSenha2;
    @FXML
    private Label labelSenha2;
    @FXML
    private AnchorPane ancoraSenha3;
    @FXML
    private Label labelHoraSenha3;
    @FXML
    private Label labelSenha3;
    @FXML
    private AnchorPane ancoraSenha4;
    @FXML
    private Label labelHoraSenha4;
    @FXML
    private Label labelSenha4;
    @FXML
    private Label labelHoraPrincipal;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.clientes = ClienteServico.getClientes();
        this.listaCliente = new ListaCliente();
        this.ancoraPrincipal.setOnMousePressed(evt -> {
            this.horizontal = evt.getSceneX();
            this.vertical = evt.getSceneY();
        });
        this.ancoraPrincipal.setOnMouseDragged(evt -> {
            Shamai.getSenhaCliente().setX(evt.getScreenX() - this.horizontal);
            Shamai.getSenhaCliente().setY(evt.getScreenY() - this.vertical);
            Shamai.getSenhaCliente().setOpacity(0.8f);
        });
        this.ancoraPrincipal.setOnDragDone(evt -> Shamai.getSenhaCliente().setOpacity(1.0f));
        this.ancoraPrincipal.setOnMouseReleased(evt -> Shamai.getSenhaCliente().setOpacity(1.0f));
        PlatformSystem.addHourLabel(this.labelHoraPrincipal);

        this.listaCliente.setLabelHoraSenha1(labelHoraSenha1);
        this.listaCliente.setLabelHoraSenha2(labelHoraSenha2);
        this.listaCliente.setLabelHoraSenha3(labelHoraSenha3);
        this.listaCliente.setLabelHoraSenha4(labelHoraSenha4);
        this.listaCliente.setLabelSenha1(labelSenha1);
        this.listaCliente.setLabelSenha2(labelSenha2);
        this.listaCliente.setLabelSenha3(labelSenha3);
        this.listaCliente.setLabelSenha4(labelSenha4);
        this.listaCliente.setClientes(this.clientes);

        this.clientes.addListener((ListChangeListener.Change<? extends Cliente> c) -> {
            this.ancoraSenhaPrincipal.setVisible(true);
            this.listaCliente.preencherClientes();
            this.labelSenhaPrincipal.setText(c.getList().get(0).getSenha());
            ScaleTransition scaleTransition = ScaleTransitionUtil.getScaleTransition(ancoraSenhaPrincipal);
            scaleTransition.play();
            Audio.getAudio().tocar();
        });

        this.ancoraPrincipal.setOnMouseClicked(evt -> {
            if (evt.getClickCount() == 1) {
                return;
            }
            if (Shamai.getSenhaCliente().isMaximized()) {
                Shamai.getSenhaCliente().setMaximized(false);
            } else {
                Shamai.getSenhaCliente().setMaximized(true);
            }
        });
    }

}
