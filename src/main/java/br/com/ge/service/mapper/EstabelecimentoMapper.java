package br.com.ge.service.mapper;

import org.mapstruct.Mapper;

import br.com.ge.domain.Estabelecimento;
import br.com.ge.service.dto.EstabelecimentoDTO;

@Mapper(componentModel = "spring" , uses = {EnderecoMapper.class, TelefoneMapper.class} )
public interface EstabelecimentoMapper {
	
	EstabelecimentoDTO toEstabelecimentoDTO (Estabelecimento estabelecimento);
	
	Estabelecimento toEstabelecimento ( EstabelecimentoDTO estabelecimentoDTO);

}
