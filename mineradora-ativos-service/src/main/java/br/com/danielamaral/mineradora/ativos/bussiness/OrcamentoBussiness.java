package br.com.danielamaral.mineradora.ativos.bussiness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.danielamaral.mineradora.ativos.model.Orcamento;
import br.com.danielamaral.mineradora.ativos.model.Situacao;
import br.com.danielamaral.mineradora.ativos.repository.AtivoRepository;
import br.com.danielamaral.mineradora.ativos.repository.OrcamentoRepository;

@Service
public class OrcamentoBussiness {

	@Autowired
	private OrcamentoRepository repository;

	@Autowired
	private AtivoRepository ativoRepository;

	public Orcamento avaliarOrcamento(Long id, Situacao situacao) {
		Orcamento orcamento = repository.getOne(id);
		if (orcamento.getSituacaoOrcamento().equals(Situacao.pendente)) {
			orcamento.setSituacaoOrcamento(situacao);
			repository.save(orcamento);
			
			orcamento.getAtivo().setSituacao(orcamento.getSituacaoOrcamento());
			ativoRepository.save(orcamento.getAtivo());

		}

		return orcamento;

	}

	public void submeterOrcamento(Orcamento orcamento) {
		repository.save(orcamento);
	}

}
