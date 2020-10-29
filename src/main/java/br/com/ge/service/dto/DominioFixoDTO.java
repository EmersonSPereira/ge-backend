package br.com.ge.service.dto;

import java.io.Serializable;

public class DominioFixoDTO implements Serializable {
	
	private static final long serialVersionUID = 3126154189180023865L;

	private Long id;
	
	private String descricao;
	
	public DominioFixoDTO(Long id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
