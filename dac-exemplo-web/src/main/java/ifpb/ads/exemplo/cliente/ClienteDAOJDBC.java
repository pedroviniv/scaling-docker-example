package ifpb.ads.exemplo.cliente;

import br.edu.ifpb.pos.docker.dac.exemplo.shared.Cliente;
import ifpb.ads.exemplo.infra.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 29/05/2017, 08:09:34
 */
public class ClienteDAOJDBC {

    private final ConexaoBD conexao = new ConexaoBD();
    private final Connection connection;

    public ClienteDAOJDBC() {
        connection = conexao.getConnection();
    }

    public List<Cliente> todosOsClientes() {
        try {
            List<Cliente> clientes = new ArrayList<>();
             
            ResultSet result = consultarTodosOsClientes();
 
            while (result.next()) {
                clientes.add(criarCliente(result));
            }
            return clientes;

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Collections.EMPTY_LIST;
    }

    private ResultSet consultarTodosOsClientes() throws SQLException {
        PreparedStatement prepareStatement = connection.prepareStatement("Select * from cliente");
        ResultSet result = prepareStatement.executeQuery();
        return result;
    }

    private Cliente criarCliente(ResultSet result) throws SQLException {
        int id = result.getInt("id");
        String nome = result.getString("nome");
        String email = result.getString("email");
        return new Cliente(id, nome, email);

    }
}
