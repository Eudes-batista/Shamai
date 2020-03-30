/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shamai.controle;

import java.time.format.DateTimeFormatter;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import shamai.modelo.Cliente;

/**
 *
 * @author eudes
 */
public class ListaCliente {

    private Label labelHoraSenha1;

    private Label labelSenha1;

    private Label labelHoraSenha2;

    private Label labelSenha2;

    private Label labelHoraSenha3;

    private Label labelSenha3;

    private Label labelHoraSenha4;

    private Label labelSenha4;

    private ObservableList<Cliente> clientes;

    
    public void preencherClientes() {
        this.preencherCliente1();
        this.preencherCliente2();
        this.preencherCliente3();
        this.preencherCliente4();
    }

    private void preencherCliente1() {
        Cliente clienteSenha1 = this.clientes.get(0);
        this.labelHoraSenha1.setText(clienteSenha1.getHoraDaEntrega().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        this.labelSenha1.setText(clienteSenha1.getSenha());
    }

    private void preencherCliente2() {
        if (this.clientes.size() < 2) {
            return;
        }
        Cliente clienteSenha2 = this.clientes.get(1);
        this.labelHoraSenha2.setText(clienteSenha2.getHoraDaEntrega().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        this.labelSenha2.setText(clienteSenha2.getSenha());
    }

    private void preencherCliente3() {
        if (this.clientes.size() < 3) {
            return;
        }
        Cliente clienteSenha3 = this.clientes.get(2);
        this.labelHoraSenha3.setText(clienteSenha3.getHoraDaEntrega().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        this.labelSenha3.setText(clienteSenha3.getSenha());
    }

    private void preencherCliente4() {
        if (this.clientes.size() < 4) {
            return;
        }
        Cliente clienteSenha4 = this.clientes.get(3);
        this.labelHoraSenha4.setText(clienteSenha4.getHoraDaEntrega().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        this.labelSenha4.setText(clienteSenha4.getSenha());
    }

    public Label getLabelHoraSenha1() {
        return labelHoraSenha1;
    }

    public void setLabelHoraSenha1(Label labelHoraSenha1) {
        this.labelHoraSenha1 = labelHoraSenha1;
    }

    public Label getLabelSenha1() {
        return labelSenha1;
    }

    public void setLabelSenha1(Label labelSenha1) {
        this.labelSenha1 = labelSenha1;
    }

    public Label getLabelHoraSenha2() {
        return labelHoraSenha2;
    }

    public void setLabelHoraSenha2(Label labelHoraSenha2) {
        this.labelHoraSenha2 = labelHoraSenha2;
    }

    public Label getLabelSenha2() {
        return labelSenha2;
    }

    public void setLabelSenha2(Label labelSenha2) {
        this.labelSenha2 = labelSenha2;
    }

    public Label getLabelHoraSenha3() {
        return labelHoraSenha3;
    }

    public void setLabelHoraSenha3(Label labelHoraSenha3) {
        this.labelHoraSenha3 = labelHoraSenha3;
    }

    public Label getLabelSenha3() {
        return labelSenha3;
    }

    public void setLabelSenha3(Label labelSenha3) {
        this.labelSenha3 = labelSenha3;
    }

    public Label getLabelHoraSenha4() {
        return labelHoraSenha4;
    }

    public void setLabelHoraSenha4(Label labelHoraSenha4) {
        this.labelHoraSenha4 = labelHoraSenha4;
    }

    public Label getLabelSenha4() {
        return labelSenha4;
    }

    public void setLabelSenha4(Label labelSenha4) {
        this.labelSenha4 = labelSenha4;
    }

    public ObservableList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ObservableList<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    

}
