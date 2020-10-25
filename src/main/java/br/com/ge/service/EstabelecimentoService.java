package br.com.ge.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ge.repository.EstabelecimentoRepository;

@Service
@Transactional
public class EstabelecimentoService {
	
	@Autowired
	private EstabelecimentoRepository estabelecimentoRepository;

}
