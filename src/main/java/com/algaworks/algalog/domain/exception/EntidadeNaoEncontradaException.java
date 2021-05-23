/**
 * 
 */
package com.algaworks.algalog.domain.exception;

/**
 * @author José Eustaquio Muniz
 *
 */
public class EntidadeNaoEncontradaException extends NegocioException {

	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 */
	public EntidadeNaoEncontradaException(String message) {

		super(message);

	}

}
