package br.com.ge.service.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class EnderecoDTO implements Serializable {
	
	private static final long serialVersionUID = 827010174298488069L;

	private Long id;

	@NotEmpty(message = "número não pode ser vazio")
	private String numero;

	@NotEmpty(message = "rua não pode ser vazio")
	private String rua;

	@NotEmpty(message = "bairro não pode ser vazio")
	private String bairro;

	@NotEmpty(message = "cidade não pode ser vazio")
	private String cidade;

	@NotEmpty(message = "estado não pode ser vazio")
	private String estado;
	
	@NotEmpty(message = "CEP não pode ser vazio")
	private String cep;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	

}
