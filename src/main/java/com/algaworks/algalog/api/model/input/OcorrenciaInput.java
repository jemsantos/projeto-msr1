/**
 * 
 */
package com.algaworks.algalog.api.model.input;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

/**
 * @author José Eustaquio Muniz
 *
 */
@Getter
@Setter
public class OcorrenciaInput {

	@NotBlank
	private String descricao;
	
}
