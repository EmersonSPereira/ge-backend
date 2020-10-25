package br.com.ge.service.mapper;

import org.mapstruct.Mapper;

import br.com.ge.domain.Endereco;
import br.com.ge.service.dto.EnderecoDTO;

@Mapper(componentModel = "spring" )
public interface EnderecoMapper {
	
	EnderecoDTO toEnderecoDTO(Endereco endereco);
	
	Endereco toEndereco (EnderecoDTO enderecoDTO);

}
