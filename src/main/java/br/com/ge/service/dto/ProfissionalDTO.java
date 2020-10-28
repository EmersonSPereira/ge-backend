package br.com.ge.service.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ProfissionalDTO implements Serializable {
	
	private static final long serialVersionUID = 4066904058803193040L;

	private Long id;

	@NotEmpty(message = "nome não pode ser vazio")
	private String nome;

	@NotNull(message = "endereço não pode ser nulo")
	private EnderecoDTO endereco;

	@NotNull(message = "telefone celular não pode ser nulo")
	private TelefoneDTO telefone;


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

	public EnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}

	public TelefoneDTO getTelefone() {
		return telefone;
	}

	public void setTelefone(TelefoneDTO telefone) {
		this.telefone = telefone;
	}

	
	

	

	

}
