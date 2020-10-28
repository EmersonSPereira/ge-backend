package br.com.ge.service.exeption;

public class NegocioExeption extends RuntimeException {
	
	private static final long serialVersionUID = -8711304358522860652L;
	
	private String msg;

	public NegocioExeption(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}
	
	
	

}
