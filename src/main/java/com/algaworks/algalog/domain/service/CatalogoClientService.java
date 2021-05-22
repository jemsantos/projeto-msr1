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
 * @author José Eustaquio Muniz
 *
 */
@AllArgsConstructor
@Service
public class CatalogoClientService {

	private ClientRepository clientRepository;

	public Client buscar(Long clienteId) {
		return clientRepository.findById(clienteId)
				.orElseThrow(() -> new NegocioException("Cliente não encontrado"));
	}

	@Transactional
	public Client salvar(Client cliente) {
		/* boolean emailEmUso = clientRepository.findByEmail(cliente.getEmail())
				.stream()
				.anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
		
		if (emailEmUso) {
			throw new NegocioException("Já existe um cliente cadastrado com esse e-mail");
		} VALIDAÇÃO ESTÁ COM ERRO NO STREAM... */

		return clientRepository.save(cliente);
	}
	
	@Transactional
	public void excluir(Long clienteId) {
		clientRepository.deleteById(clienteId);
	}

}
