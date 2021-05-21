/**
 * 
 */
package com.algaworks.algalog.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.service.SolicitacaoEntregaService;

import lombok.AllArgsConstructor;

/**
 * @author José Eustaquio Muniz
 *
 */
@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {

	private SolicitacaoEntregaService solicitacaoEntregaService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	private Entrega solicitar(@RequestBody Entrega entrega) {

		return solicitacaoEntregaService.solicitar(entrega);

	}

}
/* {
  "cliente": {
	"id": 2
  },
  "destintario": {
	"nome": "Joaquim da Silva",
	"logradouro": "Rua das Goiabas",
	"numero": "100",
	"complemento": "Apto 200",
	"bairro": "Centro"
  },
  "taxa": 100.50
} */
