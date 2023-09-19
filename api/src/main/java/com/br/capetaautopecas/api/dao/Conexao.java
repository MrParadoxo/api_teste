package com.br.capetaautopecas.api.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	 // Configurações de conexão com o banco de dados
    private static final String URL = "jdbc:postgresql://localhost:5432/vision_broker";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "Rally0509!";

    public static Connection conectar() {
        Connection conexao = null;
        try {
            // Carregar o driver JDBC
            Class.forName("org.postgresql.Driver");

            // Estabelecer a conexão com o banco de dados
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);

            if (conexao != null) {
                System.out.println("Conexão com o banco de dados PostgreSQL estabelecida com sucesso.");
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Erro ao carregar o driver JDBC: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados PostgreSQL: " + e.getMessage());
        }
        return conexao;
    }

    public static void desconectar(Connection conexao) {
        if (conexao != null) {
            try {
                conexao.close();
                System.out.println("Conexão com o banco de dados PostgreSQL fechada com sucesso.");
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão com o banco de dados PostgreSQL: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        // Exemplo de uso da classe de conexão
        Connection conexao = conectar();

        // Realize suas operações com o banco de dados aqui...

        // Feche a conexão quando terminar
        desconectar(conexao);
    }
	
}
