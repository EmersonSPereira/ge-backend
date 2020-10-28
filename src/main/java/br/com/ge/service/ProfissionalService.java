package br.com.ge.service;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.ge.repository.ProfissionalRepository;
import br.com.ge.service.dto.ProfissionalDTO;
import br.com.ge.service.dto.ProfissionalListagemDTO;
import br.com.ge.service.exeption.NegocioExeption;
import br.com.ge.service.mapper.ProfissionalMapper;
import br.com.ge.util.ConstantsUtil;

@Service
@Transactional
public class ProfissionalService {
	
	@Autowired
	private ProfissionalRepository profissionalRepository;
	
	@Autowired
	private ProfissionalMapper profissionalMapper;

	/**
	 * cadastra um profissional na aplicação
	 * @param profissionalDTO
	 */
	public void cadastrarProfissional(@Valid ProfissionalDTO profissionalDTO) {
		salvarProfissional(profissionalDTO);
		
	}


	/**
	 * lista os profissionais cadastrados paginados
	 * @param pageable
	 * @return {@link Page ProfissionalListagemDTO}
	 */
	public Page<ProfissionalListagemDTO> buscarPaginado(Pageable pageable) {
		return profissionalRepository.buscarPaginado(pageable);
	}

	/**
	 * busca um profissional por id
	 * @param id
	 * @return {@link ProfissionalDTO}
	 */
	public ProfissionalDTO buscarPorid(Long id) {
		return profissionalMapper.toProfissionalDTO(this.profissionalRepository.findById(id).orElseThrow(
				() -> new NegocioExeption(ConstantsUtil.MSG_USUARIO_NAO_ENCONTRADO)));
	}

	/**
	 * atualiza um profissional
	 * @param profissionalDTO
	 * @param id
	 */
	public void atualizar(@Valid ProfissionalDTO profissionalDTO, Long id) {
		if(id == null) {
			throw new NegocioExeption(ConstantsUtil.ERRO_ATUALIZAR_PROFISSIONL);
		}
		
		salvarProfissional(profissionalDTO);
		
	}
	
	 

	private void salvarProfissional(ProfissionalDTO profissionalDTO) {
		profissionalRepository.save(profissionalMapper.toProfissional(profissionalDTO));
	}


	public void remover(Long id) {
		if(id == null) {
		throw new NegocioExeption(ConstantsUtil.ERRO_REMOVER_PROFISSIONAL);
	}
		profissionalRepository.deleteById(id);
		
	}
}
