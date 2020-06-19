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

	public void avaliarOrcamento(Orcamento orcamento) {
		repository.save(orcamento);
		if(orcamento.getSituacaoOrcamento().equals(Situacao.aprovado)) {
			orcamento.getAtivo().setSituacao(Situacao.aprovado);
			ativoRepository.save(orcamento.getAtivo());
		}
	}
	
	public void submeterOrcamento(Orcamento orcamento) {
		repository.save(orcamento);
	}

}
