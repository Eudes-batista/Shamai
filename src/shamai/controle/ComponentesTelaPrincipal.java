/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shamai.controle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author eudes
 */
public abstract class ComponentesTelaPrincipal {
 
    @FXML
    protected AnchorPane ancoraPrincipal;

    @FXML
    protected TextField textFieldNumeroPedido;

    @FXML
    protected Button buttonChamar;

    @FXML
    protected Label labelHoraPrincipal;

    @FXML
    protected Label labelSair;

    @FXML
    protected Label labelMinimizar;

    @FXML
    protected Label labelHoraSenha1;

    @FXML
    protected Label labelSenha1;

    @FXML
    protected Label labelHoraSenha2;

    @FXML
    protected Label labelSenha2;

    @FXML
    protected Label labelHoraSenha3;

    @FXML
    protected Label labelSenha3;

    @FXML
    protected Label labelHoraSenha4;

    @FXML
    protected Label labelSenha4;
    
}
