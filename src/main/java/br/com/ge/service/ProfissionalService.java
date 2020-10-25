package br.com.ge.service;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ge.repository.ProfissionalRepository;
import br.com.ge.service.dto.ProfissionalDTO;
import br.com.ge.service.mapper.ProfissionalMapper;

@Service
@Transactional
public class ProfissionalService {
	
	@Autowired
	private ProfissionalRepository profissionalRepository;
	
	@Autowired
	private ProfissionalMapper profissionalMapper;

	public void cadastrarProfissional(@Valid ProfissionalDTO profissionalDTO) {
		this.profissionalRepository.save(profissionalMapper.toProfissional(profissionalDTO));
		
	}

}
