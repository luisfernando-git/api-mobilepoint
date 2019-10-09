package br.com.mobilepoint.utils;

public class NegocioException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public NegocioException() {
		super();
	}

    public NegocioException(String message) {
        super(message);
    }
}
