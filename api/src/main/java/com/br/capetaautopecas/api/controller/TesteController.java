package com.br.capetaautopecas.api.controller;

import java.sql.Connection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.capetaautopecas.api.dao.Conexao;
import com.br.capetaautopecas.api.dao.Consultas;
import com.google.gson.JsonArray;

@RestController
public class TesteController {

    @GetMapping("/teste")
    @ResponseBody
    public String teste() {
        // Conectar ao banco de dados
        Connection conexao = Conexao.conectar();
        
        // Criar uma instância da classe Consultas com a conexão
        Consultas consulta = new Consultas(conexao);

        String consultaSQL = "SELECT idusuario, login, senha, nome, idperfilacesso, idnativo FROM usuario";

        JsonArray resultadoConsulta = consulta.executarConsulta(consultaSQL);

        // Fechar a conexão com o banco de dados
        Conexao.desconectar(conexao);

        // Converter a lista de objetos JSON em uma string JSON formatada
        String jsonString = resultadoConsulta.toString();

//        // Remover os colchetes iniciais e finais da string JSON, se existirem
//        if (jsonString.startsWith("[") && jsonString.endsWith("]")) {
//            jsonString = jsonString.substring(1, jsonString.length() - 1);
//        }

        return jsonString;
    }
}
