package br.com.ge.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ge.domain.Estabelecimento;
import br.com.ge.domain.Profissional;
import br.com.ge.repository.ProfissionalRepository;
import br.com.ge.service.dto.DominioFixoDTO;
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

	@Autowired
	private EstabelecimentoService estabelecimentoService;

	/**
	 * cadastra um profissional na aplicação
	 * 
	 * @param profissionalDTO
	 */
	public void cadastrar(@Valid ProfissionalDTO profissionalDTO) {
		salvarProfissional(profissionalDTO);

	}

	/**
	 * lista os profissionais cadastrados paginados
	 * 
	 * @param pageable
	 * @return {@link Page ProfissionalListagemDTO}
	 */
	@Transactional(readOnly = true)
	public Page<ProfissionalListagemDTO> buscarPaginado(Pageable pageable) {
		return profissionalRepository.buscarPaginado(pageable);
	}

	/**
	 * busca um profissional por id
	 * 
	 * @param id
	 * @return {@link ProfissionalDTO}
	 */
	@Transactional(readOnly = true)
	public ProfissionalDTO buscarPorid(Long id) {
		return profissionalMapper.toProfissionalDTO(this.profissionalRepository.findById(id)
				.orElseThrow(() -> new NegocioExeption(ConstantsUtil.MSG_PROFISSIONAL_NAO_ENCONTRADO)));
	}

	/**
	 * atualiza um profissional
	 * 
	 * @param profissionalDTO
	 * @param id
	 */
	public void atualizar(@Valid ProfissionalDTO profissionalDTO, Long id) {
		if (id == null) {
			throw new NegocioExeption(ConstantsUtil.ERRO_ATUALIZAR_PROFISSIONAL);
		}

		salvarProfissional(profissionalDTO);

	}

	private void salvarProfissional(ProfissionalDTO profissionalDTO) {
		profissionalRepository.save(profissionalMapper.toProfissional(profissionalDTO));
	}

	/**
	 * remove um profissional por id
	 * 
	 * @param id
	 */
	public void remover(Long id) {
		if (id == null) {
			throw new NegocioExeption(ConstantsUtil.ERRO_REMOVER_PROFISSIONAL);
		}
		profissionalRepository.deleteById(id);

	}

	/**
	 * lista os profissionais por nome
	 * 
	 * @param nome
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<DominioFixoDTO> buscarPorNome(String nome) {
		return profissionalRepository.buscarPorNome(nome);
	}

	/**
	 * associa um profissional a um estabelecimento
	 * 
	 * @param id
	 * @param idEstabelecimento
	 */
	public void associar(Long id, Long idEstabelecimento) {

		Profissional profissional = this.profissionalRepository.findById(id)
				.orElseThrow(() -> new NegocioExeption(ConstantsUtil.MSG_PROFISSIONAL_NAO_ENCONTRADO));

		Estabelecimento estabelecimento = this.estabelecimentoService.buscarEstabelecimentoPorId(idEstabelecimento);

		profissional.setEstabelecimento(estabelecimento);

		profissionalRepository.save(profissional);

	}

	/**
	 * busca os profissionais por id do estabelecimento paginados
	 * @param id
	 * @param pageable
	 * @return {@link Page ProfissionalListagemDTO}
	 */
	public Page<ProfissionalListagemDTO> buscarPorIdEstabelecimentoPaginado(Long id, Pageable pageable) {
		return profissionalRepository.buscarPorIdEstabelecimentoPaginado(id, pageable);
	}
}
