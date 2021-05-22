/**
 * 
 */
package com.algaworks.algalog.api.model.input;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

/**
 * @author José Eustaquio Muniz
 *
 */
@Getter
@Setter
public class ClienteIdInput {
	
	@NotNull
	private Long id;

}
