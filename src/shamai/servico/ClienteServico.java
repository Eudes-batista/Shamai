package shamai.servico;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shamai.modelo.Cliente;

/**
 *
 * @author eudes
 */
public class ClienteServico {
    
    private static ObservableList<Cliente> clientes;

    public static ObservableList<Cliente> getClientes() {
        if(clientes == null){
            clientes = FXCollections.observableArrayList();
        }
        return clientes;
    }

    public static void setClientes(ObservableList<Cliente> clientes) {
        ClienteServico.clientes = clientes;
    }
}
