package br.com.ge.service.exeption;

public class NegocioExeption extends RuntimeException {
	
	private static final long serialVersionUID = -8711304358522860652L;
	
	public NegocioExeption(String msg) {
		super(msg);
	}

}
