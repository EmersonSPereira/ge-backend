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
@Table(name = "TB_ENDERECO")
public class Endereco implements Serializable {

	private static final long serialVersionUID = -6364353775340665299L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ENDERECO")
	@SequenceGenerator(sequenceName = "SQ_ENDERECO", name = "SQ_ENDERECO", allocationSize = 1)
	@Column(name = "CO_ENDERECO")
	private Long id;

	@Column(name = "DS_NUMERO")
	private String numero;

	@Column(name = "DS_RUA")
	private String rua;

	@Column(name = "DS_BAIRRO")
	private String bairro;

	@Column(name = "DS_CIDADE")
	private String cidade;

	@Column(name = "DS_ESTADO")
	private String estado;

	@Column(name = "DS_CEP")
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

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof Endereco)) {
			return false;
		}
		Endereco castOther = (Endereco) other;
		return Objects.equals(id, castOther.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	

}
