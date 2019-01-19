package br.com.logap.eolica.exceptions;

public class FaltandoValoresException extends Exception{

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Faltando valores.";
	}
	
	
}
