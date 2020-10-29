package br.com.ge.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ge.domain.Estabelecimento;
import br.com.ge.repository.EstabelecimentoRepository;
import br.com.ge.service.dto.DominioFixoDTO;
import br.com.ge.service.dto.EstabelecimentoDTO;
import br.com.ge.service.dto.EstabelecimentoListagemDTO;
import br.com.ge.service.exeption.NegocioExeption;
import br.com.ge.service.mapper.EstabelecimentoMapper;
import br.com.ge.util.ConstantsUtil;

@Service
@Transactional
public class EstabelecimentoService {

	@Autowired
	private EstabelecimentoRepository estabelecimentoRepository;

	@Autowired
	private EstabelecimentoMapper estabelecimentoMapper;

	/**
	 * Cadastra um Estabelecimento
	 * 
	 * @param estabelecimentoDTO
	 */
	public void cadastrar(@Valid EstabelecimentoDTO estabelecimentoDTO) {
		salvarEstabelecimento(estabelecimentoDTO);

	}

	/**
	 * lista os estabelecimentos paginados
	 * 
	 * @param pageable
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<EstabelecimentoListagemDTO> buscarPaginado(Pageable pageable) {
		return estabelecimentoRepository.buscarPaginado(pageable);
	}

	/**
	 * busca um estabelecimento por id
	 * 
	 * @param id
	 * @return {@link EstabelecimentoDTO}
	 */
	@Transactional(readOnly = true)
	public EstabelecimentoDTO buscarPorid(Long id) {
		return estabelecimentoMapper.toEstabelecimentoDTO(buscarEstabelecimentoPorId(id));
	}

	public void atualizar(@Valid EstabelecimentoDTO estabelecimentoDTO, Long id) {
		if (id == null) {
			throw new NegocioExeption(ConstantsUtil.ERRO_ATUALIZAR_ESTABELECIMENTO);
		}

		salvarEstabelecimento(estabelecimentoDTO);

	}

	/**
	 * remove um estabelecimento por id
	 * 
	 * @param id
	 */
	public void remover(Long id) {
		if (id == null) {
			throw new NegocioExeption(ConstantsUtil.ERRO_REMOVER_ESTABELECIMENTO);
		}
		estabelecimentoRepository.deleteById(id);

	}

	/**
	 * lista os estabelecimento por nome
	 * 
	 * @param nome
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<DominioFixoDTO> buscarPorNome(String nome) {
		return estabelecimentoRepository.buscarPorNome(nome);
	}

	private void salvarEstabelecimento(EstabelecimentoDTO estabelecimentoDTO) {
		estabelecimentoRepository.save(estabelecimentoMapper.toEstabelecimento(estabelecimentoDTO));
	}

	public Estabelecimento buscarEstabelecimentoPorId(Long id) {
		return this.estabelecimentoRepository.findById(id)
				.orElseThrow(() -> new NegocioExeption(ConstantsUtil.MSG_ESTABELECIMENTO_NAO_ENCONTRADO));
	}

}
