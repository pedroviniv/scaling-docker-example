/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.docker.dac.exemplo.jse;

import br.edu.ifpb.pos.docker.dac.exemplo.shared.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kieckegard
 */
public class Main {
    
    private static Cliente criaCliente(ResultSet rs) throws SQLException {
        
        int id = rs.getInt("id");
        String nome = rs.getString("nome");
        String email = rs.getString("email");
        
        return new Cliente(id,nome,email);
    }
    
    private static List<Cliente> criaListaClientes(ResultSet rs) throws SQLException {
        
        List<Cliente> clientes = new ArrayList<>();
        
        while(rs.next()) {
            Cliente cliente = criaCliente(rs);
            if(cliente != null)
                clientes.add(cliente);
        }
        
        return clientes;
    }
    
    public static void main(String[] args) throws SQLException {
        
        ConexaoBD fabricaConexao = new ConexaoBD();
        
        fabricaConexao.criarConexao();
        
        Connection conexao = fabricaConexao.getConnection();
        PreparedStatement stmt = conexao
                .prepareStatement("SELECT * FROM cliente");
        
        ResultSet resultSet = stmt.executeQuery();
        
        List<Cliente> clientes = criaListaClientes(resultSet);
        
        System.out.println("==== Clientes ====");
        for(Cliente cliente : clientes) {
            
            System.out.println(cliente);
        }
    }
}
