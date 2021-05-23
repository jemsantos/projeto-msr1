/**
 * 
 */
package com.algaworks.algalog.api.model;

import java.time.OffsetDateTime;

import lombok.Getter;
import lombok.Setter;

/**
 * @author José Eustaquio Muniz
 *
 */
@Getter
@Setter
public class OcorrenciaModel {

	private Long id;
	private String descricao;
	private OffsetDateTime dataRegistro;

}
