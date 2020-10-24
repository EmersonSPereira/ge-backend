package br.com.ge.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/funcionario")
public class FuncionarioResource {
	
    @GetMapping()
    @ApiOperation(value = "Mostra lista de questões")
    public ResponseEntity<String> getUsuario() {
        return ResponseEntity.ok("teste");
    }

}
