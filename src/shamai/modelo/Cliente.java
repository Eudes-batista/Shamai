package shamai.modelo;

import java.time.LocalTime;
import java.util.Objects;

/**
 *
 * @author eudes
 */
public class Cliente {
    private String senha;
    private LocalTime horaDaEntrega;

    public String getSenha() {
        return senha;
    }

    public LocalTime getHoraDaEntrega() {
        return horaDaEntrega;
    }

    public Cliente(String senha, LocalTime horaDaEntrega) {
        this.senha = senha;
        this.horaDaEntrega = horaDaEntrega;
    }

    public Cliente(String senha) {
        this.senha = senha;
    }
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.senha);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        return Objects.equals(this.senha, other.senha);
    }

    @Override
    public String toString() {
        return "Cliente{" + "senha=" + senha + ", horaDaEntrega=" + horaDaEntrega + '}';
    }        
    
}
