package br.com.ge.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ge.domain.Estabelecimento;
import br.com.ge.service.dto.DominioFixoDTO;
import br.com.ge.service.dto.EstabelecimentoListagemDTO;

@Repository
public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Long> {

	@Query("SELECT new  br.com.ge.service.dto.EstabelecimentoListagemDTO"
			+ "(e.id, e.nome,e.telefone.numeroTelefoneFixo)" + " FROM Estabelecimento e ORDER BY e.id ASC ")
	Page<EstabelecimentoListagemDTO> buscarPaginado(Pageable pageable);

	@Query(value = "SELECT new br.com.ge.service.dto.DominioFixoDTO(e.id,e.nome)"
            + " FROM Estabelecimento e WHERE LOWER(e.nome) LIKE lower(concat('%', :nome,'%'))")
	List<DominioFixoDTO> buscarPorNome(@Param("nome") String nome);

}
