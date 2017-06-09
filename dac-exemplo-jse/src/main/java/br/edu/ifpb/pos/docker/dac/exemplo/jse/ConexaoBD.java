/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.docker.dac.exemplo.jse;

/**
 *
 * @author Joseph
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {

    private Connection conn;

    public void criarConexao() {
        try {
            String url = "jdbc:postgresql://dac-docker-exemplo-db:5432/cliente";
//            String url = "jdbc:postgresql://localhost:5433/cliente";
            String user = "postgres";
            String password = "12345";
            Class.forName("org.postgresql.Driver");
            this.conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException |ClassNotFoundException  e) {
            System.err.println(e.getMessage());
        }
    }

    public Connection getConnection() {
        criarConexao();
        return this.conn;
    }

    public void desconecta() {
        try {
            conn.close();
        } catch (SQLException ex) {
        }
    }

}
