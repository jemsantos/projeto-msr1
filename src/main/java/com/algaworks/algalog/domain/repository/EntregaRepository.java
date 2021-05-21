/**
 * 
 */
package com.algaworks.algalog.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.algalog.domain.model.Entrega;

/**
 * @author José Eustaquio Muniz
 *
 */
@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long> {
}
