/**
 * 
 */
package com.algaworks.algalog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.api.model.DestinatarioModel;
import com.algaworks.algalog.api.model.EntregaModel;
import com.algaworks.algalog.domain.model.Destinatario;
import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.repository.EntregaRepository;
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

	private EntregaRepository entregaRepository;
	private SolicitacaoEntregaService solicitacaoEntregaService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	private Entrega solicitar(@Valid @RequestBody Entrega entrega) {

		return solicitacaoEntregaService.solicitar(entrega);

	}
	
	@GetMapping
	public List<Entrega> listar() {
		return entregaRepository.findAll();
	}

	@GetMapping("/{entregaId}")
	public ResponseEntity<EntregaModel> bucar(@PathVariable Long entregaId) {
		return entregaRepository.findById(entregaId)
				.map(entrega -> {
					Destinatario destinatario = entrega.getDestinatario();
					
					DestinatarioModel destinatarioModel = new DestinatarioModel();
					destinatarioModel.setNome(destinatario.getNome());
					destinatarioModel.setLogradouro(destinatario.getLogradouro());
					destinatarioModel.setNumero(destinatario.getNumero());
					destinatarioModel.setComplemento(destinatario.getComplemento());
					destinatarioModel.setBairro(destinatario.getBairro());
					
					EntregaModel entregaModel = new EntregaModel();
					entregaModel.setId(entrega.getId());
					entregaModel.setNomeCliente(entrega.getCliente().getName());
					entregaModel.setDestinatario(destinatarioModel);
					entregaModel.setTaxa(entrega.getTaxa());
					entregaModel.setStatus(entrega.getStatus());
					entregaModel.setDataPedido(entrega.getDataPedido());
					entregaModel.setDataFinalizacao(entrega.getDataFinalizacao());

					return ResponseEntity.ok(entregaModel);
				}).orElse(ResponseEntity.notFound().build());
	}

}
