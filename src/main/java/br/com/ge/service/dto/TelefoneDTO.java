package br.com.ge.service.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class TelefoneDTO implements Serializable{

	private static final long serialVersionUID = -1451683899045994967L;

	private Long id;

	@NotEmpty(message = "número não pode ser vazio")
	private String numeroTelefoneFixo;
	
	@NotEmpty(message = "número não pode ser vazio")
	private String numeroTelefoneCelular;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroTelefoneFixo() {
		return numeroTelefoneFixo;
	}

	public void setNumeroTelefoneFixo(String numeroTelefoneFixo) {
		this.numeroTelefoneFixo = numeroTelefoneFixo;
	}

	public String getNumeroTelefoneCelular() {
		return numeroTelefoneCelular;
	}

	public void setNumeroTelefoneCelular(String numeroTelefoneCelular) {
		this.numeroTelefoneCelular = numeroTelefoneCelular;
	}

	
	

}
