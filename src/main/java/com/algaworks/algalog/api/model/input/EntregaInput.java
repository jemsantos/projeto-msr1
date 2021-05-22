/**
 * 
 */
package com.algaworks.algalog.api.model.input;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

/**
 * @author José Eustaquio Muniz
 *
 */
@Getter
@Setter
public class EntregaInput {

	@Valid
	@NotNull
	private ClienteIdInput cliente;

	@Valid
	@NotNull
	private DestinatarioInput destinatario;

	@NotNull
	private BigDecimal taxa;

}
