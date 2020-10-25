package br.com.ge.service.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.ge.domain.Telefone;

public class ProfissionalDTO implements Serializable {
	
	private static final long serialVersionUID = 4066904058803193040L;

	private Long id;

	@NotEmpty(message = "nome não pode ser vazio")
	private String nome;

	@NotNull(message = "endereço não pode ser nulo")
	private EnderecoDTO endereco;

	@NotNull(message = "telefone celular não pode ser nulo")
	@Size(min = 2,message = "o profissional deve cadastrar dois telefones")
	private List<Telefone> telefones;


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

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	

}
