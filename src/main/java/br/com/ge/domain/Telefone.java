package br.com.ge.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.ge.service.enumeration.TipoTelefoneEnum;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "TB_TELEFONE")
public class Telefone implements Serializable {

	private static final long serialVersionUID = -4519622876284243904L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TELEFONE")
	@SequenceGenerator(sequenceName = "SQ_TELEFONE", name = "SQ_TELEFONE", allocationSize = 1)
	@Column(name = "CO_TELEFONE")
	private Long id;

	@Column(name = "DS_TELEFONE", nullable = false)
	private String numeroTelefone;

	@Enumerated(EnumType.STRING)
	@Column(name = "TIPO_TELEFONE", nullable = false)
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

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof Telefone)) {
			return false;
		}
		Telefone castOther = (Telefone) other;
		return Objects.equals(id, castOther.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

}
