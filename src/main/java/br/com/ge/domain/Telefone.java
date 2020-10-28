package br.com.ge.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_TELEFONE")
public class Telefone implements Serializable {

	private static final long serialVersionUID = -4519622876284243904L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TELEFONE")
	@SequenceGenerator(sequenceName = "SQ_TELEFONE", name = "SQ_TELEFONE", allocationSize = 1)
	@Column(name = "CO_TELEFONE")
	private Long id;

	@Column(name = "DS_TELEFONE_FIXO", nullable = false)
	private String numeroTelefoneFixo;
	
	@Column(name = "DS_TELEFONE_CELULAR", nullable = true)
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
