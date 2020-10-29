package br.com.ge.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CO_TELEFONE")
	private Telefone telefone;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CO_ESTABELECIMENTO")
	private Estabelecimento estabelecimento;


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

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
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
