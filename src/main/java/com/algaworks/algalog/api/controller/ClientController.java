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
 * @author 081867890213
 *
 */
@RestController
public class ClientController {

	@GetMapping("/clientes")
	public List<Client> listar() {
		Client cliente1 = new Client();
		cliente1.setId(1L);
		cliente1.setNome("João");
		cliente1.setTelefone("34 99999-1111");
		cliente1.setEmail("joaodascouves@algaworks.com");
		
		Client cliente2 = new Client();
		cliente2.setId(2L);
		cliente2.setNome("Maria");
		cliente2.setTelefone("11 97777-2222");
		cliente2.setEmail("mariadasilva@algaworks.com");
		
		return Arrays.asList(cliente1, cliente2);
	}

}
