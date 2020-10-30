package br.com.ge.resource;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ge.service.ProfissionalService;
import br.com.ge.service.dto.DominioFixoDTO;
import br.com.ge.service.dto.ProfissionalDTO;
import br.com.ge.service.dto.ProfissionalListagemDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/profissional")
public class ProfissionalResource {

	@Autowired
	private ProfissionalService profissionalService;

	private Logger log = LoggerFactory.getLogger(ProfissionalResource.class);

	@PostMapping
	@ApiOperation(value = "Cadastra um profissional na aplicação")
	public ResponseEntity<Void> cadastrar(@RequestBody @Valid ProfissionalDTO profissionalDTO) {
		log.debug("Requisição REST para cadastrar o Profissional : {}", profissionalDTO);
		profissionalService.cadastrar(profissionalDTO);
		return ResponseEntity.ok().build();
	}

	@GetMapping()
	public ResponseEntity<Page<ProfissionalListagemDTO>> buscarPaginado(@ApiParam Pageable pageable) {
		log.debug("Requisição REST para listar os Profissionais paginados");
		return ResponseEntity.ok(profissionalService.buscarPaginado(pageable));
	}

	@GetMapping("{id}")
	public ResponseEntity<ProfissionalDTO> buscarPorId(@PathVariable Long id) {
		log.debug("Requisição REST para buscar o Profissional : {}", id);
		return ResponseEntity.ok(profissionalService.buscarPorid(id));
	}

	@PutMapping("{id}")
	public ResponseEntity<Void> atualizar(@PathVariable Long id, @Valid @RequestBody ProfissionalDTO profissionalDTO) {
		log.debug("Requisição REST para editar o Profissional : {}", profissionalDTO);
		profissionalService.atualizar(profissionalDTO, id);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		log.debug("Requisição REST para remover o Profissional : {}", id);
		profissionalService.remover(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<DominioFixoDTO>> buscarPorNome(@PathVariable String nome) {
		log.debug("Requisição REST para buscar o Profissional por nome : {}", nome);
		return ResponseEntity.ok(profissionalService.buscarPorNome(nome));
	}
	
	@PostMapping("/{id}/associar/{idEstabelecimento}")
	@ApiOperation(value = "Associa um profissional a um estabelecimento")
	public ResponseEntity<Void> associar(@PathVariable Long id, @PathVariable Long idEstabelecimento) {
		log.debug("Requisição REST para associar o Profissional : {} ao Estbelecimento :{}", id, idEstabelecimento);
		profissionalService.associar(id, idEstabelecimento);
		return ResponseEntity.ok().build();
	}
	@PostMapping("/{id}/desassociar")
	@ApiOperation(value = "Desassocia um profissional de um estabelecimento")
	public ResponseEntity<Void> desassociar(@PathVariable Long id) {
		log.debug("Requisição REST para desassociar o Profissional : {}", id);
		profissionalService.desassociar(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/estabelecimentos/{id}")
	public ResponseEntity<Page<ProfissionalListagemDTO>> buscarPorIdEstabeleCimentoPaginado(@PathVariable Long id,@ApiParam Pageable pageable) {
		log.debug("Requisição REST para listar os Profissionais paginados");
		return ResponseEntity.ok(profissionalService.buscarPorIdEstabelecimentoPaginado(id,pageable));
	}

}
