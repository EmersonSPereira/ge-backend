package br.com.ge.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TB_PROFISSIONAL")
public class Profissional implements Serializable {

	private static final long serialVersionUID = 8501874457458549342L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PROFISSIONAL")
	@SequenceGenerator(sequenceName = "SQ_PROFISSIONAL", name = "SQ_PROFISSIONAL", allocationSize = 1)
	@Column(name = "CO_PROFISSIONAL")
	private Long id;

	@Column(name = "NO_PROFISSIONAL", nullable = false)
	private String nome;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CO_ENDERECO")
	private Endereco endereco;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "CO_PROFISSIONAL")
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
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

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof Profissional)) {
			return false;
		}
		Profissional castOther = (Profissional) other;
		return Objects.equals(id, castOther.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

}
