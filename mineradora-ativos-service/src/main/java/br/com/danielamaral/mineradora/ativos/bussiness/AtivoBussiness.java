package br.com.danielamaral.mineradora.ativos.bussiness;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.danielamaral.mineradora.ativos.model.Ativo;
import br.com.danielamaral.mineradora.ativos.model.Situacao;
import br.com.danielamaral.mineradora.ativos.repository.AtivoRepository;

@Service
public class AtivoBussiness {

	@Autowired
	private AtivoRepository ativoRepository;
	
	public List<Ativo> listarAtivosAdquiridos() {
		List<Situacao> situacoes = new ArrayList<>();
		situacoes.add(Situacao.aprovado);
		return ativoRepository.findBySituacaoIn(situacoes);
		
	}
	
	
	public List<Ativo> listarAtivosPendentesOuReprovados() {
		List<Situacao> situacoes = new ArrayList<>();
		situacoes.add(Situacao.pendente);
		situacoes.add(Situacao.reprovado);
		return ativoRepository.findBySituacaoIn(situacoes);
		
	}
}
