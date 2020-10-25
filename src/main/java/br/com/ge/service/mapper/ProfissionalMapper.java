package br.com.ge.service.mapper;

import org.mapstruct.Mapper;

import br.com.ge.domain.Profissional;
import br.com.ge.service.dto.ProfissionalDTO;

@Mapper(componentModel = "spring" , uses = {EnderecoMapper.class, TelefoneMapper.class} )
public interface ProfissionalMapper {

	ProfissionalDTO toProfissionalDTO (Profissional profissional);
	
	Profissional toProfissional (ProfissionalDTO profissionalDTO);
}
