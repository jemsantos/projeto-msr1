/**
 * 
 */
package com.algaworks.algalog.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algalog.domain.exception.NegocioException;
import com.algaworks.algalog.domain.model.Client;
import com.algaworks.algalog.domain.repository.ClientRepository;

import lombok.AllArgsConstructor;

/**
 * @author Jose Eustaquio Muniz
 *
 */
@AllArgsConstructor
@Service
public class CatalogoClientService {

	private ClientRepository clientRepository;
	
	@Transactional
	public Client salvar(Client cliente) {
		boolean emailEmUso = clientRepository.findByEmail(cliente.getEmail())
				.stream()
				.anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
		
		if (emailEmUso) {
			throw new NegocioException("Já existe um cliente cadastrado com esse e-mail");
		}
		
		return clientRepository.save(cliente);
	}
	
	@Transactional
	public void excluir(Long clienteId) {
		clientRepository.deleteById(clienteId);
	}
}
