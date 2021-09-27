package br.com.danielamaral.mineradora.ativos.bussiness;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.danielamaral.mineradora.ativos.model.Ativo;
import br.com.danielamaral.mineradora.ativos.model.Manutencao;
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
	
	
	public Manutencao cadastrarManutencaoAtivo(long idAtivo, Manutencao manutencao) {
		Optional<Ativo> ativo = ativoRepository.findById(idAtivo);
		ativo.get().addManutencao(manutencao);
		ativoRepository.save(ativo.get());
		return manutencao;
	}
}
