/**
 * 
 */
package com.algaworks.algalog.api.model.input;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Jose Eustaquio Muniz
 *
 */
@Getter
@Setter
public class DestinatarioInput {

	@NotBlank
	private String nome;
	
	@NotBlank
	private String logradouro;
	
	@NotBlank
	private String numero;
	
	@NotBlank
	private String complemento;
	
	@NotBlank
	private String bairro;

}
