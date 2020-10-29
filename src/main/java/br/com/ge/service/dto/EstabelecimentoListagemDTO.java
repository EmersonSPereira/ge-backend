package br.com.ge.service.dto;

import java.io.Serializable;

public class EstabelecimentoListagemDTO implements Serializable{
	
	private static final long serialVersionUID = 9132677655907885956L;

	private Long id;

	private String nome;
	
	private String telefoneFixo;

	public EstabelecimentoListagemDTO(Long id, String nome, String telefoneFixo) {
		this.id = id;
		this.nome = nome;
		this.telefoneFixo = telefoneFixo;
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
	
	
	

}
