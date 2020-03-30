package shamai.controle;

import java.net.URL;
import java.time.LocalTime;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import shamai.Shamai;
import shamai.modelo.Cliente;
import shamai.servico.ClienteServico;
import shamai.util.PlatformSystem;

public class FXMLPrincipalController extends ComponentesTelaPrincipal implements Initializable {

    private double horizontal, vertical;

    private ObservableList<Cliente> clientes;

    private ListaCliente listaCliente;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.listaCliente = new ListaCliente();
        this.ancoraPrincipal.setOnMousePressed(evt -> {
            this.horizontal = evt.getSceneX();
            this.vertical = evt.getSceneY();
        });
        this.ancoraPrincipal.setOnMouseDragged(evt -> {
            Shamai.getPrincipal().setX(evt.getScreenX() - this.horizontal);
            Shamai.getPrincipal().setY(evt.getScreenY() - this.vertical);
            Shamai.getPrincipal().setOpacity(0.8f);
        });
        this.ancoraPrincipal.setOnDragDone(evt -> Shamai.getPrincipal().setOpacity(1.0f));
        this.ancoraPrincipal.setOnMouseReleased(evt -> Shamai.getPrincipal().setOpacity(1.0f));

        this.labelSair.setOnMouseClicked(evt -> {
            System.exit(0);
            ClienteServico.setClientes(null);
        });
        this.labelMinimizar.setOnMouseClicked(evt -> ((Stage) this.ancoraPrincipal.getScene().getWindow()).setIconified(true));
        PlatformSystem.addHourLabel(this.labelHoraPrincipal);

        this.clientes = ClienteServico.getClientes();

        this.listaCliente.setLabelHoraSenha1(labelHoraSenha1);
        this.listaCliente.setLabelHoraSenha2(labelHoraSenha2);
        this.listaCliente.setLabelHoraSenha3(labelHoraSenha3);
        this.listaCliente.setLabelHoraSenha4(labelHoraSenha4);
        this.listaCliente.setLabelSenha1(labelSenha1);
        this.listaCliente.setLabelSenha2(labelSenha2);
        this.listaCliente.setLabelSenha3(labelSenha3);
        this.listaCliente.setLabelSenha4(labelSenha4);
        this.listaCliente.setClientes(this.clientes);

        this.buttonChamar.setOnAction(evt -> {
            if (this.validarSeCampoDaSenhaEstaVazio()) {
                this.mostrarMensagem("Campo da senha está vazio.", Alert.AlertType.WARNING);
                this.textFieldNumeroPedido.requestFocus();
                return;
            }
            this.adicionarPedido();
            this.removendoCliente();
            this.listaCliente.preencherClientes();
            this.textFieldNumeroPedido.setText("");
        });
        this.textFieldNumeroPedido.setOnAction(evt -> {
            if (this.validarSeCampoDaSenhaEstaVazio()) {
                this.mostrarMensagem("Campo da senha está vazio.", Alert.AlertType.WARNING);
                this.textFieldNumeroPedido.requestFocus();
                return;
            }
            this.adicionarPedido();
            this.removendoCliente();
            this.listaCliente.preencherClientes();
            this.textFieldNumeroPedido.setText("");
        });
    }

    private void adicionarPedido() {
        Cliente cliente = new Cliente(this.textFieldNumeroPedido.getText(), LocalTime.now());
        int indice = this.clientes.indexOf(cliente);
        if (indice >= 0) {
            Cliente clientePrincipal = this.clientes.get(0);
            this.clientes.set(indice, clientePrincipal);
            this.clientes.set(0, cliente);
            return;
        }
        this.clientes.add(0, cliente);
    }

    private void removendoCliente() {
        if (this.clientes.size() > 4) {
            this.clientes.remove(this.clientes.size() - 1);
        }
    }

    private boolean validarSeCampoDaSenhaEstaVazio() {
        return this.textFieldNumeroPedido.getText().isEmpty();
    }

    private void mostrarMensagem(String mensagem, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle("SHAMAI");
        alert.setHeaderText("AVISO");
        alert.setContentText(mensagem);
        alert.show();
    }

}
