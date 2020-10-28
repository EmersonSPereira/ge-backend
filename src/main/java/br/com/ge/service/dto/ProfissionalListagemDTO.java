package br.com.ge.service.dto;

import java.io.Serializable;

public class ProfissionalListagemDTO implements Serializable {

	private static final long serialVersionUID = -6475202848909858813L;


	private Long id;

	private String nome;
	
	private String telefoneFixo;
	
	private String telefoneCelular;
	
	

	public ProfissionalListagemDTO(Long id, String nome, String telefoneFixo, String telefoneCelular) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefoneFixo = telefoneFixo;
		this.telefoneCelular = telefoneCelular;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefoneFixo() {
		return telefoneFixo;
	}

	public void setTelefoneFixo(String telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
	}

	public String getTelefoneCelular() {
		return telefoneCelular;
	}

	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

}
