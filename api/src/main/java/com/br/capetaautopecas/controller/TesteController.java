package com.br.capetaautopecas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TesteController {
	
	@GetMapping("/exemplo")
    public String exemplo() {
        return "Olá, mundo!";
    }
}
