package br.com.ge.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ge.domain.Profissional;
import br.com.ge.service.dto.DominioFixoDTO;
import br.com.ge.service.dto.ProfissionalListagemDTO;

@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {

	@Query("SELECT new  br.com.ge.service.dto.ProfissionalListagemDTO"
			+ "(p.id, p.nome,p.telefone.numeroTelefoneFixo, p.telefone.numeroTelefoneFixo.numeroTelefoneCelular)"
			+ " FROM Profissional p ORDER BY p.id ASC ")
	Page<ProfissionalListagemDTO> buscarPaginado(Pageable pageable);

	@Query(value = "SELECT new br.com.ge.service.dto.DominioFixoDTO(p.id,p.nome)"
			+ " FROM Profissional p WHERE LOWER(p.nome) LIKE lower(concat('%', :nome,'%'))")
	List<DominioFixoDTO> buscarPorNome(@Param("nome") String nome);

	@Query("SELECT new  br.com.ge.service.dto.ProfissionalListagemDTO"
			+ "(p.id, p.nome,p.telefone.numeroTelefoneFixo, p.telefone.numeroTelefoneFixo.numeroTelefoneCelular)"
			+ " FROM Profissional p LEFT JOIN p.estabelecimento e WHERE e.id = :idEstabelecimento ORDER BY p.id ASC ")
	Page<ProfissionalListagemDTO> buscarPorIdEstabelecimentoPaginado(@Param("idEstabelecimento") Long idEstabelecimento, Pageable pageable);
}
