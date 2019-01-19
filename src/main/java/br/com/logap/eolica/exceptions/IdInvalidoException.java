package br.com.logap.eolica.exceptions;

public class IdInvalidoException extends Exception {

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "ID inválido.";
	}
	
}
