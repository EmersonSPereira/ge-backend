package br.com.ge.service.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import br.com.ge.service.enumeration.TipoTelefoneEnum;

public class TelefoneDTO implements Serializable{

	private static final long serialVersionUID = -1451683899045994967L;

	private Long id;

	@NotEmpty(message = "número não pode ser vazio")
	private String numeroTelefone;

	@NotEmpty(message = "o tipo do telefone não pode ser vazio")
	private TipoTelefoneEnum tipoPermissao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public TipoTelefoneEnum getTipoPermissao() {
		return tipoPermissao;
	}

	public void setTipoPermissao(TipoTelefoneEnum tipoPermissao) {
		this.tipoPermissao = tipoPermissao;
	}

}
