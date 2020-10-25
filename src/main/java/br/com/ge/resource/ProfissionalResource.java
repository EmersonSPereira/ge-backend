package br.com.ge.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ge.service.ProfissionalService;
import br.com.ge.service.dto.ProfissionalDTO;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/profissional")
public class ProfissionalResource {
	
	@Autowired
	private ProfissionalService profissionalService;
	
    @PostMapping
    @ApiOperation(value = "Cadastra um profissional na aplicação")
    public ResponseEntity<Void> cadastrarProfissonal(@RequestBody @Valid ProfissionalDTO profissionalDTO) {
    	this.profissionalService.cadastrarProfissional(profissionalDTO);
        return ResponseEntity.ok().build();
    }

}
