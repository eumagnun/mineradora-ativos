package br.com.danielamaral.mineradora.ativos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.danielamaral.mineradora.ativos.model.Orcamento;

public interface OrcamentoRepository  extends JpaRepository<Orcamento, Long>{

}
