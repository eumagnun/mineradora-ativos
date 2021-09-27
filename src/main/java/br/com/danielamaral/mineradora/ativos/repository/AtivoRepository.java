package br.com.danielamaral.mineradora.ativos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.danielamaral.mineradora.ativos.model.Ativo;
import br.com.danielamaral.mineradora.ativos.model.Situacao;

public interface AtivoRepository  extends JpaRepository<Ativo, Long> {
	
	List<Ativo> findBySituacaoIn(List<Situacao> situacoes);

}
