/**
 * 
 */
package com.algaworks.algalog.api.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.algaworks.algalog.domain.model.Cliente;
import com.algaworks.algalog.domain.repository.ClienteRepository;
import com.algaworks.algalog.domain.service.CatalogoClienteService;

import lombok.AllArgsConstructor;

/**
 * @author José Eustaquio Muniz
 */
@AllArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClienteController {

	private ClienteRepository clienteRepository;
	private CatalogoClienteService catalogoClienteService;

	@GetMapping
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}

	@GetMapping("/{clienteId}")
	public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId) {
		// opção 03:
		return clienteRepository.findById(clienteId)
				.map( cliente -> ResponseEntity.ok(cliente) )
				.orElse( ResponseEntity.notFound().build() );
		
		
		//Optional<Cliente> cliente = clienteRepository.findById(clienteId);
		
		// opção 01:
		   // return cliente.orElse(null);
		// opção 02:
//		  if (cliente.isPresent()) {
//			  return ResponseEntity.ok(cliente.get());
//		  }
//		  return ResponseEntity.notFound().build();
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar( @Valid @RequestBody Cliente cliente ) {

		return catalogoClienteService.salvar(cliente);

	}
	
	
	@PutMapping("/{clienteId}")
	public  ResponseEntity<Cliente> atualizar( @PathVariable Long clienteId,
			@Valid @RequestBody Cliente cliente ) {

		if (!clienteRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}

		cliente.setId(clienteId);
		Cliente clienteSalvo = catalogoClienteService.salvar(cliente);
		
		return ResponseEntity.ok(clienteSalvo);
	}
	
	
	@DeleteMapping("/{clienteId}")
	public ResponseEntity<Void> remover( @PathVariable Long clienteId  ) {

		if (!clienteRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}
		
		catalogoClienteService.excluir(clienteId);
		
		return ResponseEntity.noContent().build();

	}
	
	
	
	
	
	
	
	
	

	// BUSCAR POR NOME: "return clienteRepository.findByName("João da Silva");"
	// BUSCAR COM LIKE: "return clienteRepository.findByNameContaining("a");"

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
	
	
	
	QDO PRECISA PEGAR UM ATRIBUTO DO OBJETO:
	CatalogoProdutos catalogo = new CatalogoProdutos();
	
	BigDecimal preco = catologo.buscarPreco("Picanha 12kg").orElse(BigDecimal.ZERO);
	OU
	BigDecimal preco = catologo.buscarPreco("Picanha 12kg")
		.orElseThrow(() -> new RuntimeException("Preço do produto não encontrado"));
	
	System.out.println(preco);
	
	*/

}
