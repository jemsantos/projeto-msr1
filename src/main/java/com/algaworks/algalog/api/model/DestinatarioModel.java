/**
 * 
 */
package com.algaworks.algalog.api.model;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

/**
 * @author José Eustaquio Muniz
 *
 */
@Getter
@Setter
public class DestinatarioModel {

	private String nome;
	
	private String logradouro;
	
	private String numero;
	
	private String complemento;
	
	private String bairro;
	
}
