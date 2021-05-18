/**
 * 
 */
package com.algaworks.algalog.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.domain.model.Client;

/**
 * @author José Eustaquio
 */
@RestController
public class ClientController {

	@GetMapping("/clientes")
	public List<Client> listar() {
		Client client1 = new Client();
		client1.setId(1L);
		client1.setNome("João");
		client1.setTelefone("34 99999-1111");
		client1.setEmail("joaodascouves@algaworks.com");
		
		Client client2 = new Client();
		client2.setId(2L);
		client2.setNome("Maria");
		client2.setTelefone("11 97777-2222");
		client2.setEmail("mariadasilva@algaworks.com");
		
		return Arrays.asList(client1, client2);
	}
	
	
	/*
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































