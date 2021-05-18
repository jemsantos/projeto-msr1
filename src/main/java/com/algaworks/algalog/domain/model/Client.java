/**
 * 
 */
package com.algaworks.algalog.domain.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author José Eustaquio
 *
 */
@Getter
@Setter
public class Client {

	private Long id;
	private String nome;
	private String email;
	private String telefone;

}
