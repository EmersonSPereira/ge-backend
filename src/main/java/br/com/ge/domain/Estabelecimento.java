package br.com.ge.domain;

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

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TB_ESTABELECIMENTO")
public class Estabelecimento implements Serializable{

	private static final long serialVersionUID = -7626582677729585314L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ESTABELECIMENTO")
	@SequenceGenerator(sequenceName = "SQ_ESTABELECIMENTO", name = "SQ_ESTABELECIMENTO", allocationSize = 1)
	@Column(name = "CO_ESTABELECIMENTO")
	private Long id;

	@Column(name = "NO_ESTABELECIMENTO", nullable = false)
	private String nome;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CO_ENDERECO")
	private Endereco endereco;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CO_TELEFONE")
	private Telefone telefone;
	
	@OneToMany(cascade = CascadeType.MERGE)
	@JoinColumn(name = "CO_ESTABELECIMENTO")
	private List<Profissional> profissionais;

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

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}
	

	public List<Profissional> getProfissionais() {
		return profissionais;
	}

	public void setProfissionais(List<Profissional> profissionais) {
		this.profissionais = profissionais;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof Estabelecimento)) {
			return false;
		}
		Estabelecimento castOther = (Estabelecimento) other;
		return Objects.equals(id, castOther.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

}
