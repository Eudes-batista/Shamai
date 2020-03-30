/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.time.LocalTime;
import javafx.collections.ObservableList;
import shamai.modelo.Cliente;
import shamai.servico.ClienteServico;

/**
 *
 * @author eudes
 */
public class TesteClienteServico {
    public static void main(String[] args) {
        
        ObservableList<Cliente> clientes = ClienteServico.getClientes();
        
        clientes.add(new Cliente("123", LocalTime.now()));
        clientes.add(new Cliente("456", LocalTime.now()));
        clientes.add(new Cliente("789", LocalTime.now()));
        System.out.println("clientes = " + clientes);
        
        clientes.add(0, new Cliente("1", LocalTime.now()));
        clientes.add(0, new Cliente("2", LocalTime.now()));
        System.out.println("clientes = " + clientes);
    }
}
