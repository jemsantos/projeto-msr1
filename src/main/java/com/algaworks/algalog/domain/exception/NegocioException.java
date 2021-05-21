/**
 * 
 */
package com.algaworks.algalog.domain.exception;

/**
 * @author José Eustaquio Muniz
 *
 */
public class NegocioException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public NegocioException(String message) {
		super(message);
	}
	
}
