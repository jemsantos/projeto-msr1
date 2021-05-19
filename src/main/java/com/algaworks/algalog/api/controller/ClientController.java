/**
 * 
 */
package com.algaworks.algalog.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.domain.model.Client;
import com.algaworks.algalog.domain.repository.ClientRepository;

import lombok.AllArgsConstructor;

/**
 * @author José Eustaquio
 */
@AllArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClientController {

	private ClientRepository clientRepository;

	@GetMapping("")
	public List<Client> listar() {
		return clientRepository.findAll();
	}

	@GetMapping("/{clienteId}")
	public ResponseEntity<Client> buscar(@PathVariable Long clienteId) {
		// opção 03:
		return clientRepository.findById(clienteId)
				.map( cliente -> ResponseEntity.ok(cliente) )
				.orElse( ResponseEntity.notFound().build() );
		
		
		//Optional<Client> cliente = clientRepository.findById(clienteId);
		
		// opção 01:
		   // return cliente.orElse(null);
		// opção 02:
//		  if (cliente.isPresent()) {
//			  return ResponseEntity.ok(cliente.get());
//		  }
//		  return ResponseEntity.notFound().build();
	}
	
	/*{
		"name": "Fernando",
		"email": "fernando@algaworks.com",
		"telefone": "34 97778-9990"
	} */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Client adicionar( @RequestBody Client cliente ) {
		return clientRepository.save(cliente);
	}
	
	
	@PutMapping("/{clienteId}")
	public  ResponseEntity<Client> atualizar( @PathVariable Long clienteId,
			@RequestBody Client cliente ) {
		if (!clientRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}
		
		cliente.setId(clienteId);
		Client clienteSalvo = clientRepository.save(cliente);
		
		return ResponseEntity.ok(clienteSalvo);
	}
	
	
	@DeleteMapping("/{clienteId}")
	public ResponseEntity<Void> remover( @PathVariable Long clienteId  ) {
		if (!clientRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}
		
		clientRepository.deleteById(clienteId);
		
		return ResponseEntity.noContent().build();
	}
	
	
	
	
	
	
	
	
	

	// BUSCAR POR NOME: "return clientRepository.findByName("João da Silva");"
	// BUSCAR COM LIKE: "return clientRepository.findByNameContaining("a");"

	/*
	 * insert into cliente (nome, email, fone) values ('João da Silva', 'joao.silva@alga.com', '34 94989-0090');
	 * insert into cliente (nome, email, fone) values ('Maria Abadia', 'mariaabadia@alga.com', '33 94959-0490');
	 * 
	USANDO O OPTIONAL e BIGDECIMAL

	Optional<Produto> produtoOptional = catalogo.buscarOptional("Picanha 1kg");

	OPÇÃO 01:
	if (produtoOptional.iSPresent()) {
		Produto produto = produtoOptional.get();
		produto.setPreco(produto.getPreco().add(new BigDecimal(100)));
		
		System.out.printl(produto.getPreco());
	}
	
	
	OPÇÃO 02:
	produtoOptional.ifPresent(produto -> {
		produto.setPreco(produto.getPreco().add(new BigDecimal(100)));
		
		System.out.printl(produto.getPreco());
	});
	
	
	OPÇÃO 03:
	// produtoOptional.stream().forEach(produto -> {
	catalogo.buscarOptional("Picanha 2kg").stream().forEach(produto -> {
		produto.setPreco(produto.getPreco().add(new BigDecimal(100)));
		
		System.out.printl(produto.getPreco());
	});
	
	
	
	QDO PRECISA PREGAR UM ATRIBUTO DO OBJETO:
	CatalogoProdutos catalogo = new CatalogoProdutos();
	
	BigDecimal preco = catologo.buscarPreco("Picanha 12kg").orElse(BigDecimal.ZERO);
	OU
	BigDecimal preco = catologo.buscarPreco("Picanha 12kg")
		.orElseThrow(() -> new RuntimeException("Preço do produto não encontrado"));
	
	System.out.println(preco);
	
	*/

}































