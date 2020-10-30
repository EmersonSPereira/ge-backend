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

import br.com.ge.service.EstabelecimentoService;
import br.com.ge.service.dto.DominioFixoDTO;
import br.com.ge.service.dto.EstabelecimentoDTO;
import br.com.ge.service.dto.EstabelecimentoListagemDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/estabelecimentos")
public class EstabelecimentoResource {

	@Autowired
	private EstabelecimentoService profissionalService;

	private Logger log = LoggerFactory.getLogger(EstabelecimentoResource.class);

	@PostMapping
	@ApiOperation(value = "Cadastra um profissional na aplicação")
	public ResponseEntity<Void> cadastrar(@RequestBody @Valid EstabelecimentoDTO profissionalDTO) {
		log.debug("Requisição REST para cadastrar o Estabelecimento : {}", profissionalDTO);
		profissionalService.cadastrar(profissionalDTO);
		return ResponseEntity.ok().build();
	}

	@GetMapping()
	public ResponseEntity<Page<EstabelecimentoListagemDTO>> buscarPaginados(@ApiParam Pageable pageable) {
		log.debug("Requisição REST para listar os Estabelecimentos paginados");
		return ResponseEntity.ok(profissionalService.buscarPaginado(pageable));
	}

	@GetMapping("{id}")
	public ResponseEntity<EstabelecimentoDTO> buscarPorId(@PathVariable Long id) {
		log.debug("Requisição REST para buscar o Estabelecimento : {}", id);
		return ResponseEntity.ok(profissionalService.buscarPorid(id));
	}

	@PutMapping("{id}")
	public ResponseEntity<Void> atualizar(@PathVariable Long id,
			@Valid @RequestBody EstabelecimentoDTO profissionalDTO) {
		log.debug("Requisição REST para editar o Estabelecimento : {}", profissionalDTO);
		profissionalService.atualizar(profissionalDTO, id);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		log.debug("Requisição REST para remover o Estabelecimento : {}", id);
		profissionalService.remover(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<DominioFixoDTO>> buscarPorNome(@PathVariable String nome) {
		log.debug("Requisição REST para buscar o Estabelecimento por nome : {}", nome);
		return ResponseEntity.ok(profissionalService.buscarPorNome(nome));
	}
	
	@GetMapping("/{id}/verificar-vinculo")
    public ResponseEntity<Boolean> verificarVinculoComProfissional(@PathVariable Long id) {
        log.debug("Requisição REST para validar vinculo com Profissional : {}", id);
        return ResponseEntity.ok(profissionalService.verificarVinculoComProfissional(id));
    }

}
