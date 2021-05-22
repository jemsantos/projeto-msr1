/**
 * 
 */
package com.algaworks.algalog.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.algalog.domain.model.Client;

/**
 * @author José Eustaquio Muniz
 *
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

	List<Client> findByName(String name);
	List<Client> findByNameContaining(String name);

	Optional<Client> findByEmail(String email);

}
