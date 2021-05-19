/**
 * 
 */
package com.algaworks.algalog.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.domain.model.Client;
import com.algaworks.algalog.domain.repository.ClientRepository;

import lombok.AllArgsConstructor;

/**
 * @author José Eustaquio
 */
@AllArgsConstructor
@RestController
public class ClientController {

	private ClientRepository clientRepository;

	@GetMapping("/clientes")
	public List<Client> listar() {
		return clientRepository.findAll();
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































