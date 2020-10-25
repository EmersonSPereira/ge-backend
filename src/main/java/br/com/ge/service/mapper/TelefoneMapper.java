package br.com.ge.service.mapper;

import org.mapstruct.Mapper;

import br.com.ge.domain.Telefone;
import br.com.ge.service.dto.TelefoneDTO;

@Mapper(componentModel = "spring" )
public interface TelefoneMapper {
	
	TelefoneDTO toTelefoneDTO (Telefone telefone);
	
	Telefone toTelefone (TelefoneDTO telefoneDTO);

}
