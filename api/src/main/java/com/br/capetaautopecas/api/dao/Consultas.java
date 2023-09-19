package com.br.capetaautopecas.api.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Consultas {

    private Connection conexao;

    public Consultas(Connection conexao) {
        this.conexao = conexao;
    }

    public JsonArray executarConsulta(String consultaSQL, Object... parametros) {
        JsonArray resultadosJson = new JsonArray();

        try {
            // Preparar a consulta
            PreparedStatement preparedStatement = conexao.prepareStatement(consultaSQL);

            // Definir os parâmetros, se houver
            for (int i = 0; i < parametros.length; i++) {
                preparedStatement.setObject(i + 1, parametros[i]);
            }

            // Executar a consulta
            ResultSet resultSet = preparedStatement.executeQuery();

            // Processar os resultados
            while (resultSet.next()) {
                JsonObject resultadoJson = new JsonObject();
                //resultadoJson.addProperty("idusuario", resultSet.getInt("idusuario"));
                resultadoJson.addProperty("login", resultSet.getString("login"));
                resultadoJson.addProperty("senha", resultSet.getString("senha"));
                resultadoJson.addProperty("nome", resultSet.getString("nome"));
                //resultadoJson.addProperty("idperfilacesso", resultSet.getInt("idperfilacesso"));
                //resultadoJson.addProperty("idnativo", resultSet.getInt("idnativo"));
                
                resultadosJson.add(resultadoJson);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(resultadosJson);
        return resultadosJson;
    }
}
