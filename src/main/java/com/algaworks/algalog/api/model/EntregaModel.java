/**
 * 
 */
package com.algaworks.algalog.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.algaworks.algalog.domain.model.StatusEntrega;

import lombok.Getter;
import lombok.Setter;

/**
 * @author José Eustaquio Muniz
 *
 */
@Getter
@Setter
public class EntregaModel {

	private Long id;
	
	/* private Long idCliente;
	private String nameCliente; */
	private ClienteResumoModel cliente;

	private DestinatarioModel destinatario;
	
	private BigDecimal taxa;
	
	private StatusEntrega status;
	
	private OffsetDateTime dataPedido;

	private OffsetDateTime dataFinalizacao;

}
